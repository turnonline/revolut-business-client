package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.oauth.RevolutCredential;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.common.base.Strings;
import org.ctoolkit.restapi.client.adapter.ClientApiProvider;
import org.ctoolkit.restapi.client.adapter.GoogleApiProxyFactory;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.text.FieldPosition;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import static biz.turnonline.ecosystem.revolut.business.facade.RevolutBusinessClientModule.API_PREFIX;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * {@link FacadeClient} provider configured for Revolut for Business production endpoint.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class RevolutBusinessProvider
        extends ClientApiProvider<FacadeClient>
{
    private static final ObjectMapper mapper = new ObjectMapper()
            .disable( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES )
            .disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
            .setDateFormat( new RFC3339() )
            .setSerializationInclusion( JsonInclude.Include.NON_NULL )
            .registerModule( new JavaTimeModule() );

    private final RevolutCredential.Certificate certificate;

    private final RevolutCredential.Storage store;

    private final RevolutCredential.JwtTokenFactory rFactory;

    private RevolutCredential revolutCredential;

    @Inject
    public RevolutBusinessProvider( @Nonnull GoogleApiProxyFactory factory,
                                    @Nonnull RevolutCredential.Certificate certificate,
                                    @Nonnull RevolutCredential.Storage store,
                                    @Nonnull RevolutCredential.JwtTokenFactory rFactory )
    {
        super( factory );
        this.certificate = checkNotNull( certificate, "Revolut certificate can't be null" );
        this.store = checkNotNull( store, "Revolut credential store can't be null" );
        this.rFactory = rFactory;
    }

    @Override
    protected Collection<String> defaultScopes()
    {
        return Collections.emptyList();
    }

    @Override
    protected String api()
    {
        return API_PREFIX;
    }

    @Override
    protected FacadeClient build( @Nonnull GoogleApiProxyFactory factory,
                                  @Nonnull HttpTransport transport,
                                  @Nonnull JsonFactory jsonFactory,
                                  @Nonnull HttpRequestInitializer credential,
                                  @Nonnull String api )
    {
        String rootUrl = factory.getEndpointUrl( api );
        if ( Strings.isNullOrEmpty( rootUrl ) )
        {
            rootUrl = "https://b2b.revolut.com/api/";
        }

        String servicePath = "1.0";
        GenericUrl tokenServer = new GenericUrl( rootUrl + servicePath + "/auth/token" );

        revolutCredential = new RevolutCredential.Builder()
                .setTransport( transport )
                .setJsonFactory( jsonFactory )
                .setTokenServerUrl( tokenServer )
                .setCertificate( certificate )
                .setStorage( store )
                .setJwtTokenFactory( rFactory )
                // client authentication is not needed (already managed by client_assertion), but required by impl.
                .setClientAuthentication( r -> System.out.println( r.toString() ) )
                .build();

        AdapteeObjectParser parser = new AdapteeObjectParser( mapper );

        FacadeClient.Builder builder;
        builder = new FacadeClient.Builder( transport, rootUrl, servicePath, parser );
        builder.setApplicationName( "Revolut for Business" );
        builder.setHttpRequestInitializer( revolutCredential );
        builder.setMapper( mapper );

        return builder.build();
    }

    /**
     * Clears access and refresh token from memory.
     * A next call to Revolut API will cause an attempt to refresh token.
     *
     * @see RevolutCredential#refreshToken()
     */
    public void resetAccessToken()
    {
        revolutCredential.setAccessToken( null );
        revolutCredential.setRefreshToken( null );
    }

    /**
     * {@link java.text.DateFormat} is based on the {@link ISO8601DateFormat} but serializing milliseconds.
     */
    private static class RFC3339
            extends ISO8601DateFormat
    {
        private static final long serialVersionUID = 1L;

        @Override
        public StringBuffer format( Date date, StringBuffer toAppendTo, FieldPosition fieldPosition )
        {
            String value = ISO8601Utils.format( date, true );
            toAppendTo.append( value );
            return toAppendTo;
        }
    }
}
