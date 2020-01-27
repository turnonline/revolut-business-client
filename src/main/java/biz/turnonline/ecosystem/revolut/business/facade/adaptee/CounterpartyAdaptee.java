package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.counterparty.model.Counterparty;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.CreateCounterpartyRequest;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The {@link Counterparty} adaptee implementation.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class CounterpartyAdaptee
        extends AbstractFacadeAdaptee
        implements GetExecutorAdaptee<Counterparty>, InsertExecutorAdaptee<CreateCounterpartyRequest>,
        ListExecutorAdaptee<Counterparty>, DeleteExecutorAdaptee<Counterparty>
{
    @Inject
    public CounterpartyAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public Object prepareDelete( @Nonnull Identifier identifier )
    {
        return buildDeleteRequest( "/counterparty/{0}", identifier, Void.class );
    }

    @Override
    public Object executeDelete( @Nonnull Object request,
                                 @Nullable Map<String, Object> parameters,
                                 @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public GetFacadeRequest<Counterparty> prepareGet( @Nonnull Identifier identifier )
    {
        return buildGetRequest( "/counterparty/{0}", identifier, Counterparty.class );
    }

    @Override
    public Counterparty executeGet( @Nonnull Object request,
                                    @Nullable Map<String, Object> params,
                                    @Nullable Locale locale ) throws IOException
    {
        return execute( request, params );
    }

    @Override
    public Object prepareList( @Nullable Identifier parentKey )
    {
        return buildGetRequest( "counterparties", parentKey, ListArray.class );
    }

    @Override
    public List<Counterparty> executeList( @Nonnull Object request,
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
    public Object prepareInsert( @Nonnull CreateCounterpartyRequest payload,
                                 @Nullable Identifier parentKey,
                                 @Nullable MediaProvider provider )
    {
        PostFacadeRequest<Counterparty> request;
        request = buildPostRequest( "counterparty", parentKey, payload, Counterparty.class );
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


    public static class ListArray
            extends ArrayList<Counterparty>
    {
        private static final long serialVersionUID = 1L;
    }
}
