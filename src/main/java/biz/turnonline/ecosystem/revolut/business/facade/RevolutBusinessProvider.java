package biz.turnonline.ecosystem.revolut.business.facade;

import biz.turnonline.ecosystem.revolut.business.oauth.JwtFactory;
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

    @Inject
    public RevolutBusinessProvider( @Nonnull GoogleApiProxyFactory factory )
    {
        super( factory );
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
        String endpointUrl = factory.getEndpointUrl( api );
        String servicePath = "1.0";
        String rootUrl = "https://b2b.revolut.com/api";
        GenericUrl tokenServer = new GenericUrl( rootUrl + "/" + servicePath + "/auth/token" );

        RevolutCredential revolut = new RevolutCredential.Builder()
                .setTransport( transport )
                .setJsonFactory( jsonFactory )
                .setTokenServerUrl( tokenServer )
                .setCertificate( null )
                .setStore( null )
                .setJwtTokenFactory( new JwtFactory() )
                // client authentication is not needed here, but required by impl.
                .setClientAuthentication( r -> System.out.println( r.toString() ) )
                .build();

        AdapteeObjectParser parser = new AdapteeObjectParser( mapper );

        FacadeClient.Builder builder;
        builder = new FacadeClient.Builder( transport, rootUrl, servicePath, parser );
        builder.setApplicationName( "Revolut for Business" );
        builder.setHttpRequestInitializer( revolut );
        builder.setMapper( mapper );

        if ( !Strings.isNullOrEmpty( endpointUrl ) )
        {
            builder.setRootUrl( endpointUrl );
        }

        return builder.build();
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
