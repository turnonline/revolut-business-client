package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.account.model.AccountBankDetailsItem;
import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.GetFacadeRequest;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adaptee.ListExecutorAdaptee;

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
 * The {@link AccountBankDetailsItem} adaptee implementation.
 *
 * @author <a href="mailto:aurel.medvegy@ctoolkit.org">Aurel Medvegy</a>
 */
@Singleton
public class AccountBankDetailsAdaptee
        extends AbstractFacadeAdaptee
        implements ListExecutorAdaptee<AccountBankDetailsItem>
{
    @Inject
    public AccountBankDetailsAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public GetFacadeRequest<ListArray> prepareList( @Nullable Identifier parentKey )
    {
        return buildGetRequest( "accounts/{0}/bank-details", parentKey, ListArray.class );
    }

    @Override
    public List<AccountBankDetailsItem> executeList( @Nonnull Object request,
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
            extends ArrayList<AccountBankDetailsItem>
    {
        private static final long serialVersionUID = 1L;
    }
}
