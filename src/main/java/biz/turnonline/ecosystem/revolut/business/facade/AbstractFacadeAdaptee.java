package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adapter.ClientApi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Provider;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The base adaptee implementation that using {@link AbstractGoogleClient} as a client.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class AbstractFacadeAdaptee
{
    private final Provider<? extends AbstractGoogleClient> client;

    public AbstractFacadeAdaptee( Provider<? extends AbstractGoogleClient> client )
    {
        this.client = client;
    }

    protected <T> GetFacadeRequest<T> buildGetRequest( @Nonnull String path,
                                                       @Nullable Identifier identifier,
                                                       @Nonnull Class<T> responseClass )
    {
        String uriTemplate = formatUriTemplate( path, identifier );
        return new GetFacadeRequest<>( client(), uriTemplate, responseClass );
    }

    /**
     * Formats final full URL with the given identifier.
     *
     * @param path       the relative endpoint path
     * @param identifier the resource identification
     * @return the final resource URL
     */
    protected String formatUriTemplate( @Nonnull String path, @Nullable Identifier identifier )
    {
        String templateUrl = client.get().getBaseUrl() + path;

        List<String> arguments = new ArrayList<>();
        while ( identifier != null )
        {
            arguments.add( identifier.getString() );
            if ( identifier.hasChild() )
            {
                identifier = identifier.child();
            }
            else
            {
                identifier = null;
            }
        }

        String url;
        if ( arguments.isEmpty() )
        {
            url = templateUrl;
        }
        else
        {
            url = MessageFormat.format( templateUrl, arguments.toArray() );
        }
        return url;
    }

    /**
     * Fill request with optional resource parameters added as URL query parameters.
     *
     * @param request    the JSON client request
     * @param parameters the optional resource parameters
     */
    protected void fill( @Nonnull AbstractGoogleClientRequest<?> request,
                         @Nullable Map<String, Object> parameters )
    {
        checkNotNull( request );

        if ( parameters != null )
        {
            for ( Map.Entry<String, Object> entrySet : parameters.entrySet() )
            {
                Object value = entrySet.getValue();
                if ( value instanceof Enum )
                {
                    value = ( ( Enum<?> ) value ).name();
                }
                request.set( entrySet.getKey(), value );
            }
        }
    }

    /**
     * Fill request with optional resource parameters and execute a remote call.
     *
     * @param request    the JSON client request
     * @param parameters the optional resource (query) parameters
     * @return the response of the remote call
     * @throws IOException might be thrown during remote call execution
     */
    protected <T> T execute( @Nonnull AbstractGoogleClientRequest<T> request,
                             @Nullable Map<String, Object> parameters )
            throws IOException
    {
        checkNotNull( request );

        fill( request, parameters );
        return request.execute();
    }

    /**
     * Returns the client instance. Once {@code Provider<? extends AbstractGoogleClient>}
     * configured via {@link ClientApi} the client instance will be thread specific.
     *
     * @return the client
     */
    protected final AbstractGoogleClient client()
    {
        return client.get();
    }
}
