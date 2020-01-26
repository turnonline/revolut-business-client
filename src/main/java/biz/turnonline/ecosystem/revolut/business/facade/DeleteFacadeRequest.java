package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;

import javax.annotation.Nonnull;

/**
 * The common {@code DELETE} Facade request implementation.
 *
 * @param <T> the type of the class to deserialize JSON response, or {@code Void.class}
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class DeleteFacadeRequest<T>
        extends AbstractGoogleClientRequest<T>
{
    public DeleteFacadeRequest( @Nonnull AbstractGoogleClient client,
                                @Nonnull String uriTemplate,
                                @Nonnull Class<T> response )
    {
        super( client, "DELETE", uriTemplate, null, response );
    }
}
