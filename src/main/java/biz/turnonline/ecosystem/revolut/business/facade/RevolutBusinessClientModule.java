package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import org.ctoolkit.restapi.client.adapter.ClientApi;

/**
 * The Revolut for Business API Client guice module as a default configuration.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class RevolutBusinessClientModule
        extends AbstractModule
{
    public static final String API_PREFIX = "revolut-business";

    @Override
    protected void configure()
    {
        bind( FacadeClient.class ).toProvider( RevolutBusinessProvider.class );

        MapBinder<String, ClientApi> mapBinder;
        mapBinder = MapBinder.newMapBinder( binder(), String.class, ClientApi.class );
        mapBinder.addBinding( API_PREFIX ).to( RevolutBusinessProvider.class );
    }


}
