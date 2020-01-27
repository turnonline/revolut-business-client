package biz.turnonline.ecosystem.revolut.business.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpContent;
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
 * The base adaptee implementation that using {@link FacadeClient} as a client.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class AbstractFacadeAdaptee
{
    private final Provider<? extends FacadeClient> client;

    public AbstractFacadeAdaptee( Provider<? extends FacadeClient> client )
    {
        this.client = client;
    }

    /**
     * Builds GET request instance.
     *
     * @param path          the relative endpoint path with optional placeholder accounts/{0} etc.
     * @param identifier    the optional resource identification as a source for path placeholders
     * @param responseClass the type of the class to deserialize JSON response
     * @return the GET request
     */
    protected <T> GetFacadeRequest<T> buildGetRequest( @Nonnull String path,
                                                       @Nullable Identifier identifier,
                                                       @Nonnull Class<T> responseClass )
    {
        String uriTemplate = formatUriTemplate( path, identifier );
        return new GetFacadeRequest<>( client(), uriTemplate, responseClass );
    }

    /**
     * Builds POST request instance with optional payload.
     * {@link ObjectMapper} used to serialize given payload to JSON.
     *
     * @param path       the relative endpoint path with optional placeholder accounts/{0} etc.
     * @param identifier the optional resource identification as a source for path placeholders
     * @param payload    POJO resource that can be serialized into JSON content or {@code null} for none
     * @param response   the type of the class to deserialize JSON response
     * @return the POST request
     */
    protected <T> PostFacadeRequest<T> buildPostRequest( @Nonnull String path,
                                                         @Nullable Identifier identifier,
                                                         @Nullable Object payload,
                                                         @Nonnull Class<T> response )
    {
        FacadeClient client = client();
        String uriTemplate = formatUriTemplate( path, identifier );
        HttpContent jsonContent = payload == null ? null : new ObjectMapperHttpContent( payload, client.getMapper() );

        return new PostFacadeRequest<>( client, uriTemplate, jsonContent, response );
    }

    /**
     * Builds DELETE request instance.
     *
     * @param path       the relative endpoint path with optional placeholder accounts/{0} etc.
     * @param identifier the optional resource identification as a source for path placeholders
     * @param response   the type of the class to deserialize JSON response
     * @return the DELETE request
     */
    protected <T> DeleteFacadeRequest<T> buildDeleteRequest( @Nonnull String path,
                                                             @Nullable Identifier identifier,
                                                             @Nonnull Class<T> response )
    {
        String uriTemplate = formatUriTemplate( path, identifier );
        return new DeleteFacadeRequest<>( client(), uriTemplate, response );
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
        checkNotNull( path, "Relative endpoint path can't be null" );

        Identifier leaf = identifier == null ? null : identifier.leaf();
        path = path.endsWith( "/" ) ? path.substring( 0, path.length() - 1 ) : path;
        String controller = leaf != null && leaf.hasController() ? leaf.getController() : null;
        String appendix = controller != null ? path + "/" + controller : "";
        String templateUrl = client().getBaseUrl() + path + appendix;

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
     * @param request    the client request
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
     * Fill request with optional resource parameters and execute a remote call.
     *
     * @param request    the client request
     * @param parameters the optional resource (query) parameters
     * @return the response of the remote call
     * @throws IOException might be thrown during remote call execution
     */
    @SuppressWarnings( "unchecked" )
    protected <T> T execute( @Nonnull Object request, @Nullable Map<String, Object> parameters )
            throws IOException
    {
        return ( T ) execute( ( AbstractGoogleClientRequest<?> ) request, parameters );
    }

    /**
     * Returns the client instance. Once {@code Provider<? extends FacadeClient>}
     * configured via {@link ClientApi} the client instance will be thread specific.
     *
     * @return the client
     */
    protected final FacadeClient client()
    {
        return client.get();
    }
}
