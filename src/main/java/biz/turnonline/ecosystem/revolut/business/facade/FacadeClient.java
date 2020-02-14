package biz.turnonline.ecosystem.revolut.business.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The client thread-safe implementation based on {@link AbstractGoogleClient}
 * used by adaptee implementations. Payload parsing is based on {@link AdapteeObjectParser}.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class FacadeClient
        extends AbstractGoogleClient
{
    private final ObjectMapper mapper;

    /**
     * Constructs facade client.
     *
     * @param builder builder
     */
    protected FacadeClient( Builder builder )
    {
        super( builder );
        this.mapper = checkNotNull( builder.mapper, "Object mapper can't be null" );
    }

    /**
     * Returns the ObjectMapper that's being used to serialize payload to JSON and vise versa.
     *
     * @return the JSON serializer
     */
    public ObjectMapper getMapper()
    {
        return mapper;
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
        ObjectMapper mapper;

        /**
         * Returns an instance of a new builder.
         *
         * @param transport   HTTP transport, which should normally be:
         *                    <ul>
         *                    <li>Google App Engine:
         *                    {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
         *                    <li>Android: {@code newCompatibleTransport} from
         *                    {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
         *                    <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
         *                    </li>
         *                    </ul>
         * @param rootUrl     root URL of the service
         * @param servicePath relative service path
         * @param parser      to be used for parsing responses
         */
        public Builder( @Nonnull HttpTransport transport,
                        @Nonnull String rootUrl,
                        @Nonnull String servicePath,
                        @Nonnull ObjectParser parser )
        {
            super( transport, rootUrl, servicePath, parser, null );
        }

        /**
         * Builds a new instance of {@link FacadeClient}.
         */
        @Override
        public FacadeClient build()
        {
            return new FacadeClient( this );
        }

        /**
         * Sets the ObjectMapper that will be used to serialize payload to JSON and vise versa.
         *
         * @param mapper the mapper to be set
         */
        public void setMapper( ObjectMapper mapper )
        {
            this.mapper = mapper;
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
