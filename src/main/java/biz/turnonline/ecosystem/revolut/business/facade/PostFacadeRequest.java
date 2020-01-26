package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.http.HttpContent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The common {@code POST} Facade request implementation with optional payload (serializable to JSON).
 *
 * @param <T> the type of the class to deserialize JSON response
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class PostFacadeRequest<T>
        extends AbstractGoogleClientRequest<T>
{
    public PostFacadeRequest( @Nonnull AbstractGoogleClient client,
                              @Nonnull String uriTemplate,
                              @Nullable HttpContent content,
                              @Nonnull Class<T> response )
    {
        super( client, "POST", uriTemplate, content, response );
    }
}
