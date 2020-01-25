package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.GetFacadeRequest;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adaptee.GetExecutorAdaptee;
import org.ctoolkit.restapi.client.adaptee.ListExecutorAdaptee;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The {@link Account} adaptee implementation.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
public class AccountAdaptee
        extends AbstractFacadeAdaptee
        implements GetExecutorAdaptee<Account>, ListExecutorAdaptee<Account>
{
    @Inject
    public AccountAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public GetFacadeRequest<Account> prepareGet( @Nonnull Identifier identifier )
    {
        return buildGetRequest( "accounts/{0}", identifier, Account.class );
    }

    @Override
    public Account executeGet( @Nonnull Object request,
                               @Nullable Map<String, Object> params,
                               @Nullable Locale locale ) throws IOException
    {
        @SuppressWarnings( "unchecked" )
        GetFacadeRequest<Account> r = ( GetFacadeRequest<Account> ) request;
        return execute( r, params );
    }

    @Override
    public GetFacadeRequest<ListArray> prepareList( @Nullable Identifier parentKey )
    {
        String uriTemplate = formatUriTemplate( "accounts", null );
        return new GetFacadeRequest<>( client(), uriTemplate, ListArray.class );
    }

    @Override
    public List<Account> executeList( @Nonnull Object request,
                                      @Nullable Map<String, Object> parameters,
                                      @Nullable Locale locale,
                                      @Nullable Integer offset,
                                      @Nullable Integer limit,
                                      @Nullable String orderBy,
                                      @Nullable Boolean ascending ) throws IOException
    {
        @SuppressWarnings( "unchecked" )
        GetFacadeRequest<ListArray> r = ( GetFacadeRequest<ListArray> ) request;
        return execute( r, parameters );
    }

    public static class ListArray
            extends ArrayList<Account>
    {

    }
}
