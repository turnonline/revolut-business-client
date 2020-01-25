package biz.turnonline.ecosystem.revolut.business.facade;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;

import javax.annotation.Nonnull;

/**
 * The common GET Facade request implementation.
 *
 * @param <T> the type of the class to deserialize JSON response
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class GetFacadeRequest<T>
        extends AbstractGoogleClientRequest<T>
{
    public GetFacadeRequest( @Nonnull AbstractGoogleClient client,
                             @Nonnull String uriTemplate,
                             @Nonnull Class<T> responseClass )
    {
        super( client, "GET", uriTemplate, null, responseClass );
    }
}
