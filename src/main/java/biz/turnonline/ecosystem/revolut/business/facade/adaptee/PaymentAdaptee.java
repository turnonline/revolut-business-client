package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.PostFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.transaction.model.PaymentRequest;
import biz.turnonline.ecosystem.revolut.business.transaction.model.Transaction;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransferResponse;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The payments adaptee implementation.
 * <ul>
 *     <li>{@link PaymentRequest}</li>
 *     <li>{@link Transaction}</li>
 * </ul>
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class PaymentAdaptee
        extends AbstractFacadeAdaptee
        implements GetExecutorAdaptee<Transaction>, ListExecutorAdaptee<Transaction>,
        InsertExecutorAdaptee<PaymentRequest>, DeleteExecutorAdaptee<Transaction>
{
    @Inject
    public PaymentAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public Object prepareGet( @Nonnull Identifier identifier )
    {
        return buildGetRequest( "transaction/{0}", identifier, Transaction.class );
    }

    @Override
    public Transaction executeGet( @Nonnull Object request,
                                   @Nullable Map<String, Object> parameters,
                                   @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public Object prepareList( @Nullable Identifier parentKey )
    {
        return buildGetRequest( "transactions", parentKey, ListArray.class );
    }

    @Override
    public List<Transaction> executeList( @Nonnull Object request,
                                          @Nullable Map<String, Object> parameters,
                                          @Nullable Locale locale,
                                          @Nullable Integer offset,
                                          @Nullable Integer limit,
                                          @Nullable String orderBy,
                                          @Nullable Boolean ascending ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public PostFacadeRequest<TransferResponse> prepareInsert( @Nonnull PaymentRequest payload,
                                                              @Nullable Identifier parentKey,
                                                              @Nullable MediaProvider provider )
    {
        PostFacadeRequest<TransferResponse> request;
        request = buildPostRequest( "pay", parentKey, payload, TransferResponse.class );
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

    @Override
    public Object prepareDelete( @Nonnull Identifier identifier )
    {
        return buildDeleteRequest( "transaction/{0}", identifier, Void.class );
    }

    @Override
    public Object executeDelete( @Nonnull Object request,
                                 @Nullable Map<String, Object> parameters,
                                 @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    public static class ListArray
            extends ArrayList<Transaction>
    {
        private static final long serialVersionUID = 1L;
    }
}
