package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftsResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentOrderInfo;
import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.GetFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.facade.PostFacadeRequest;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adaptee.DeleteExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.GetExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.InsertExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.ListExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.MediaProvider;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The payment drafts adaptee implementation.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class PaymentDraftAdaptee
        extends AbstractFacadeAdaptee
        implements GetExecutorAdaptee<PaymentDraftResponse>, InsertExecutorAdaptee<CreatePaymentDraftRequest>,
        ListExecutorAdaptee<PaymentOrderInfo>, DeleteExecutorAdaptee<PaymentDraftResponse>
{
    @Inject
    public PaymentDraftAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public Object prepareDelete( @Nonnull Identifier identifier )
    {
        return buildDeleteRequest( "payment-drafts/{0}", identifier, Void.class );
    }

    @Override
    public Object executeDelete( @Nonnull Object request,
                                 @Nullable Map<String, Object> parameters,
                                 @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public GetFacadeRequest<PaymentDraftResponse> prepareGet( @Nonnull Identifier identifier )
    {
        return buildGetRequest( "payment-drafts/{0}", identifier, PaymentDraftResponse.class );
    }

    @Override
    public PaymentDraftResponse executeGet( @Nonnull Object request,
                                            @Nullable Map<String, Object> params,
                                            @Nullable Locale locale ) throws IOException
    {
        return execute( request, params );
    }

    @Override
    public GetFacadeRequest<PaymentDraftsResponse> prepareList( @Nullable Identifier parentKey )
    {
        return buildGetRequest( "payment-drafts", parentKey, PaymentDraftsResponse.class );
    }

    @Override
    public List<PaymentOrderInfo> executeList( @Nonnull Object request,
                                               @Nullable Map<String, Object> parameters,
                                               @Nullable Locale locale,
                                               @Nullable Integer offset,
                                               @Nullable Integer limit,
                                               @Nullable String orderBy,
                                               @Nullable Boolean ascending ) throws IOException
    {
        @SuppressWarnings( "unchecked" )
        GetFacadeRequest<PaymentDraftsResponse> r = ( GetFacadeRequest<PaymentDraftsResponse> ) request;
        return execute( r, parameters ).getPaymentOrders();
    }

    @Override
    public Object prepareInsert( @Nonnull CreatePaymentDraftRequest payload,
                                 @Nullable Identifier parentKey,
                                 @Nullable MediaProvider provider )
    {
        PostFacadeRequest<CreatePaymentDraftResponse> request;
        request = buildPostRequest( "payment-drafts", parentKey, payload, CreatePaymentDraftResponse.class );
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
