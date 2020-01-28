package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.PostFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransferRequest;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransferResponse;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adaptee.InsertExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.MediaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * The transfers adaptee implementation.
 * <ul>
 *     <li>{@link TransferRequest}</li>
 *     <li>{@link TransferResponse}</li>
 * </ul>
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class TransferAdaptee
        extends AbstractFacadeAdaptee
        implements InsertExecutorAdaptee<TransferRequest>
{
    @Inject
    public TransferAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public PostFacadeRequest<TransferResponse> prepareInsert( @Nonnull TransferRequest payload,
                                                              @Nullable Identifier parentKey,
                                                              @Nullable MediaProvider provider )
    {
        PostFacadeRequest<TransferResponse> request;
        request = buildPostRequest( "transfer", parentKey, payload, TransferResponse.class );
        request.setDisableGZipContent( true );
        return request;
    }

    @Override
    public Object executeInsert( @Nonnull Object request,
                                 @Nullable Map<String, Object> parameters,
                                 @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }
}
