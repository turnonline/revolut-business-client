package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;

import javax.annotation.Nonnull;

/**
 * The client thread-safe implementation based on {@link AbstractGoogleClient}
 * used by adaptee implementations. Payload parsing is based on {@link AdapteeObjectParser}.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class FacadeClient
        extends AbstractGoogleClient
{
    /**
     * Constructs facade client.
     *
     * @param builder builder
     */
    protected FacadeClient( Builder builder )
    {
        super( builder );
    }

    /**
     * Builder for {@link FacadeClient}.
     *
     * <p>
     * Implementation is not thread-safe.
     * </p>
     */
    public static final class Builder
            extends AbstractGoogleClient.Builder
    {

        /**
         * Returns an instance of a new builder.
         *
         * @param transport HTTP transport, which should normally be:
         *                  <ul>
         *                  <li>Google App Engine:
         *                  {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
         *                  <li>Android: {@code newCompatibleTransport} from
         *                  {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
         *                  <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
         *                  </li>
         *                  </ul>
         */
        public Builder( @Nonnull HttpTransport transport, @Nonnull String rootUrl, @Nonnull String servicePath )
        {
            super( transport, rootUrl, servicePath, new AdapteeObjectParser(), null );
        }

        /**
         * Builds a new instance of {@link FacadeClient}.
         */
        @Override
        public FacadeClient build()
        {
            return new FacadeClient( this );
        }

        @Override
        public Builder setRootUrl( String rootUrl )
        {
            return ( Builder ) super.setRootUrl( rootUrl );
        }

        @Override
        public Builder setServicePath( String servicePath )
        {
            return ( Builder ) super.setServicePath( servicePath );
        }

        @Override
        public Builder setBatchPath( String batchPath )
        {
            return ( Builder ) super.setBatchPath( batchPath );
        }

        @Override
        public Builder setHttpRequestInitializer( HttpRequestInitializer httpRequestInitializer )
        {
            return ( Builder ) super.setHttpRequestInitializer( httpRequestInitializer );
        }

        @Override
        public Builder setApplicationName( String applicationName )
        {
            return ( Builder ) super.setApplicationName( applicationName );
        }

        @Override
        public Builder setSuppressPatternChecks( boolean suppressPatternChecks )
        {
            return ( Builder ) super.setSuppressPatternChecks( suppressPatternChecks );
        }

        @Override
        public Builder setSuppressRequiredParameterChecks( boolean suppressRequiredParameterChecks )
        {
            return ( Builder ) super.setSuppressRequiredParameterChecks( suppressRequiredParameterChecks );
        }

        @Override
        public Builder setSuppressAllChecks( boolean suppressAllChecks )
        {
            return ( Builder ) super.setSuppressAllChecks( suppressAllChecks );
        }

        @Override
        public Builder setGoogleClientRequestInitializer(
                GoogleClientRequestInitializer googleClientRequestInitializer )
        {
            return ( Builder ) super.setGoogleClientRequestInitializer( googleClientRequestInitializer );
        }
    }
}
