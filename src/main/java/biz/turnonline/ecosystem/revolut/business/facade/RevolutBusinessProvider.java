package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.common.base.Strings;
import org.ctoolkit.restapi.client.adapter.ClientApiProvider;
import org.ctoolkit.restapi.client.adapter.GoogleApiProxyFactory;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.Collections;

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
        String rootUrl = "https://b2b.revolut.com/api/";

        FacadeClient.Builder builder = new FacadeClient.Builder( transport, rootUrl, "1.0" );
        builder.setApplicationName( "Revolut for Business Java client" );
        builder.setHttpRequestInitializer( credential );

        if ( !Strings.isNullOrEmpty( endpointUrl ) )
        {
            builder.setRootUrl( endpointUrl );
        }

        return builder.build();
    }
}
