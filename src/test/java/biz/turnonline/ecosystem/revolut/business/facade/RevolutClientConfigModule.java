package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.oauth.JwtFactory;
import biz.turnonline.ecosystem.revolut.business.oauth.RevolutCredential;
import com.google.inject.AbstractModule;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Test guice configuration of
 * <ul>
 *     <li>{@link RevolutCredential.Certificate}</li>
 *     <li>{@link RevolutCredential.Storage}</li>
 * </ul>
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class RevolutClientConfigModule
        extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind( RevolutCredential.Certificate.class ).to( Certificate.class ).asEagerSingleton();
        bind( RevolutCredential.Storage.class ).to( Store.class ).asEagerSingleton();
        bind( RevolutCredential.JwtTokenFactory.class ).to( JwtFactory.class ).asEagerSingleton();
    }

    private static class Certificate
            implements RevolutCredential.Certificate
    {
        @Override
        public String clientId()
        {
            return "";
        }

        @Override
        public String issuer()
        {
            return "payment.my.host";
        }
    }

    private static class Store
            implements RevolutCredential.Storage
    {
        @Override
        public String getCode( @Nonnull String clientId )
        {
            return "";
        }

        @Override
        public String getRefreshToken( @Nonnull String clientId )
        {
            return "";
        }

        @Override
        public void store( @Nonnull String clientId, @Nonnull String token )
        {

        }

        @Override
        public byte[] getSecretKey( @Nonnull String clientId )
        {
            try
            {
                return Files.readAllBytes( Paths.get( "" ) );
            }
            catch ( IOException e )
            {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
