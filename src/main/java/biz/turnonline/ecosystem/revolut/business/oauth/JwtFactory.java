package biz.turnonline.ecosystem.revolut.business.oauth;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.annotation.Nonnull;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * JWT token signer factory.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class JwtFactory
        implements RevolutCredential.JwtTokenFactory
{
    @Override
    public String create( @Nonnull String clientId, @Nonnull String issuer, @Nonnull byte[] secret )
    {
        return createJwtToken( clientId, issuer, "https://revolut.com", secret, 2400 );
    }

    /**
     * Creates RSA (RS256) JWT token.
     *
     * @param clientId the client ID {@code sub}
     * @param issuer   the issuer {@code iss}
     * @param audience the audience {@code aud}
     * @param secret   the private key (pkcs8)
     * @param howLong  token will be valid from now, in seconds
     * @return the fresh JWT token
     */
    public String createJwtToken( @Nonnull String clientId,
                                  @Nonnull String issuer,
                                  @Nonnull String audience,
                                  @Nonnull byte[] secret,
                                  int howLong )
    {
        checkNotNull( clientId, "Client Id can't be null" );
        checkNotNull( issuer, "Issuer can't be null" );
        checkNotNull( audience, "Audience can't be null" );
        checkNotNull( secret, "Secret key can't be null" );

        PrivateKey privateKey;
        try
        {
            privateKey = KeyFactory
                    .getInstance( "RSA" )
                    .generatePrivate( new PKCS8EncodedKeySpec( secret ) );
        }
        catch ( InvalidKeySpecException | NoSuchAlgorithmException e )
        {
            throw new RuntimeException( "Invalid configuration", e );
        }

        HashMap<String, Object> header = new HashMap<>();
        header.put( "typ", "JWT" );

        JwtBuilder builder = Jwts.builder()
                .setHeader( header )
                .setSubject( clientId )
                .setIssuer( issuer )
                .setAudience( audience )
                .signWith( SignatureAlgorithm.RS256, privateKey );

        builder.setExpiration( new Date( System.currentTimeMillis() + ( howLong * 1000 ) ) );

        return builder.compact();
    }
}
