package biz.turnonline.ecosystem.revolut.business.oauth;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.CredentialRefreshListener;
import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.auth.oauth2.TokenRequest;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Clock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Thread-safe OAuth 2.0 Revolut credential, helper for accessing protected Revolut resources.
 * Management of:
 * <ul>
 *     <li>JWT token</li>
 *     <li>Access Token</li>
 *     <li>Refresh Access Token</li>
 * </ul>
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 * @see <a href="https://revolut-engineering.github.io/api-docs/#business-api-oauth">Revolut Business API OAuth</a>
 */
public class RevolutCredential
        extends Credential
{
    private static final Logger LOGGER = LoggerFactory.getLogger( RevolutCredential.class );

    private final Certificate certificate;

    private final Storage storage;

    private final JwtTokenFactory factory;

    RevolutCredential( Builder builder )
    {
        super( builder );
        this.certificate = checkNotNull( builder.certificate, "Cert details provider can't be null" );
        this.storage = checkNotNull( builder.storage, "Credential storage provider can't be null" );
        this.factory = checkNotNull( builder.factory, "JWT token Factory can't be null" );
    }

    @Override
    protected TokenResponse executeRefreshToken() throws IOException
    {
        String clientId = certificate.clientId();
        if ( clientId == null )
        {
            LOGGER.error( "Client ID is being required to refresh Revolut token. Issuer " + certificate.issuer() );
            return null;
        }

        String jwt = jwt( clientId );
        if ( jwt == null )
        {
            return null;
        }

        String refreshToken = null;
        try
        {
            refreshToken = storage.getRefreshToken( clientId );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Getting the refresh token for Client ID " + clientId + " has failed", e );
        }

        boolean storeRefreshToken = refreshToken == null;
        TokenRequest request;

        if ( storeRefreshToken )
        {
            String code = storage.getCode( clientId );
            if ( code == null )
            {
                LOGGER.error( "Authorisation code is being required to get Revolut access and refresh token."
                        + " Client ID " + clientId
                        + " Issuer " + certificate.issuer() );
                return null;
            }

            // if successful it will return refresh_token too
            request = new TokenRequest(
                    getTransport(),
                    getJsonFactory(),
                    new GenericUrl( getTokenServerEncodedUrl() ),
                    "authorization_code" );

            request.put( "code", code );
        }
        else
        {
            request = new RefreshTokenRequest(
                    getTransport(),
                    getJsonFactory(),
                    new GenericUrl( getTokenServerEncodedUrl() ),
                    refreshToken );
        }

        request.put( "client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer" );
        request.put( "client_id", clientId );
        request.put( "client_assertion", jwt );

        TokenResponse response = request.execute();
        if ( storeRefreshToken && response.getRefreshToken() != null )
        {
            try
            {
                storage.store( clientId, response.getRefreshToken() );
            }
            catch ( Exception e )
            {
                LOGGER.error( "To store the refresh token for Client ID " + clientId + " has failed", e );
            }
        }
        return response;
    }

    private String jwt( @Nonnull String clientId )
    {
        String issuer = certificate.issuer();
        if ( issuer == null )
        {
            LOGGER.error( "JWT token can't be created for client ID " + clientId + " issuer is null" );
            return null;
        }

        byte[] secretKey;
        try
        {
            secretKey = storage.getSecretKey( clientId );
        }
        catch ( Exception e )
        {
            LOGGER.error( "Getting the secret key for Client ID " + clientId + " has failed", e );
            return null;
        }

        if ( secretKey == null )
        {
            LOGGER.error( "JWT token can't be created for client ID " + clientId + ", secret key is null" );
            return null;
        }

        String token = factory.create( clientId, issuer, secretKey );
        LOGGER.info( "New JWT token for client ID " + clientId + " has been created" );

        return token;
    }

    /**
     * The API Certificate: OAuth authorisation details provider.
     */
    public interface Certificate
    {
        /**
         * Returns the client ID taken from the Revolut Business settings of the chosen API Certificates.
         * Generated by Revolut once public key has been uploaded.
         *
         * @return the client ID
         */
        String clientId();

        /**
         * Returns the JWT token issuer (“iss” in JWT), taken from the Revolut Business settings
         * of the chosen API Certificates. Set while generating a pair of public/private keys.
         *
         * @return the JWT token issuer
         */
        String issuer();
    }

    /**
     * Stores the Revolut credentials in a secure manner.
     * <p>
     * <strong>Revolut</strong>
     * <p>
     * <strong>Commands to generate RSA (RS256) private key (pkcs8) and public X.509 certificate</strong>
     * </p>
     * <pre>
     * {@code
     *   openssl req -x509 -nodes -newkey rsa:2048 -keyout rsa_private.pem -out rsa_public_cert.pem -days 1825
     *   openssl pkcs8 -topk8 -inform PEM -outform DER -in rsa_private.pem -nocrypt > rsa_private_pkcs8
     * }
     * </pre>
     */
    public interface Storage
    {
        /**
         * Returns the authorisation code for specified client ID.
         * A code provided by OAuth redirect URI as a query parameter.
         * <p>
         * Once the authorisation code has been consumed it will be removed
         * and the next attempt to get code thereafter will return {@code null}.
         *
         * @param clientId for which to return code
         * @return the authorisation code or {@code null}
         * @see #store(String, String)
         */
        String getCode( @Nonnull String clientId );

        /**
         * Returns the refresh token for specified client ID.
         *
         * @param clientId for which to return token
         * @return the refresh token
         */
        String getRefreshToken( @Nonnull String clientId );

        /**
         * Stores given refresh token for specified client ID.
         * If token has been successfully stored, authorisation code for this client ID will be removed.
         *
         * @param clientId for which to store refresh token
         * @param token    to be stored
         * @see #getCode(String)
         */
        void store( @Nonnull String clientId, @Nonnull String token );

        /**
         * Returns the private encoded key PKCS8 taken from public/private keys pair.
         * The X509 public key from the pair uploaded to Revolut Business settings.
         *
         * @param clientId for which to return secret key
         * @return the secret key
         */
        byte[] getSecretKey( @Nonnull String clientId );
    }

    /**
     * The JWT token factory to provide a token for 'client_assertion' while:
     * <ul>
     *     <li>Exchange authorisation code</li>
     *     <li>Refresh access token</li>
     * </ul>
     */
    public interface JwtTokenFactory
    {
        /**
         * Creates RSA (RS256) JWT token valid for 40 minutes with 'https://revolut.com' audience.
         * Every Revolut access token is valid for 40 minutes so JWT token is being set to have the same validity.
         *
         * @param clientId the client ID {@code sub}
         * @param issuer   the issuer {@code iss}
         * @param secret   the private key (pkcs8)
         * @return the fresh JWT token
         */
        String create( @Nonnull String clientId, @Nonnull String issuer, @Nonnull byte[] secret );
    }

    /**
     * Revolut Credential builder (access method Bearer token authorization header).
     *
     * <p>
     * Implementation is not thread-safe.
     * </p>
     */
    public static class Builder
            extends Credential.Builder
    {
        private Certificate certificate;

        private Storage storage;

        private JwtTokenFactory factory;

        public Builder()
        {
            super( BearerToken.authorizationHeaderAccessMethod() );
        }

        /**
         * Returns a new credential instance.
         */
        @Override
        public RevolutCredential build()
        {
            return new RevolutCredential( this );
        }

        /**
         * Sets the API Certificate: OAuth authorisation details provider.
         *
         * @param certificate the certificate to be set
         * @return this to chain calls
         */
        public Builder setCertificate( Certificate certificate )
        {
            this.certificate = certificate;
            return this;
        }

        /**
         * Sets the secure  Revolut credentials storage manager.
         *
         * @param storage the storage manager to be set
         * @return this to chain calls
         */
        public Builder setStorage( Storage storage )
        {
            this.storage = storage;
            return this;
        }

        /**
         * Sets the factory to provide a token for 'client_assertion'
         *
         * @param factory the factory to be used to provide a JWT token
         * @return this to chain calls
         */
        public Builder setJwtTokenFactory( JwtTokenFactory factory )
        {
            this.factory = factory;
            return this;
        }

        @Override
        public Builder setTransport( HttpTransport transport )
        {
            return ( Builder ) super.setTransport( transport );
        }

        @Override
        public Builder setClock( Clock clock )
        {
            return ( Builder ) super.setClock( clock );
        }

        @Override
        public Builder setJsonFactory( JsonFactory jsonFactory )
        {
            return ( Builder ) super.setJsonFactory( jsonFactory );
        }

        @Override
        public Builder setTokenServerUrl( GenericUrl tokenServerUrl )
        {
            return ( Builder ) super.setTokenServerUrl( tokenServerUrl );
        }

        @Override
        public Builder setTokenServerEncodedUrl( String tokenServerEncodedUrl )
        {
            return ( Builder ) super.setTokenServerEncodedUrl( tokenServerEncodedUrl );
        }

        @Override
        public Builder setClientAuthentication( HttpExecuteInterceptor clientAuthentication )
        {
            return ( Builder ) super.setClientAuthentication( clientAuthentication );
        }

        @Override
        public Builder setRequestInitializer( HttpRequestInitializer requestInitializer )
        {
            return ( Builder ) super.setRequestInitializer( requestInitializer );
        }

        @Override
        public Builder addRefreshListener( CredentialRefreshListener refreshListener )
        {
            return ( Builder ) super.addRefreshListener( refreshListener );
        }

        @Override
        public Builder setRefreshListeners( Collection<CredentialRefreshListener> refreshListeners )
        {
            return ( Builder ) super.setRefreshListeners( refreshListeners );
        }
    }
}
