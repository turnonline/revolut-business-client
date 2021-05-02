package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRateResponse;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRequest;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeResponse;
import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.GetFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.facade.PostFacadeRequest;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adaptee.GetExecutorAdaptee;
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
 * The exchange adaptee implementation.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class ExchangeAdaptee
        extends AbstractFacadeAdaptee
        implements GetExecutorAdaptee<ExchangeRateResponse>, InsertExecutorAdaptee<ExchangeRequest>
{
    @Inject
    public ExchangeAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public GetFacadeRequest<ExchangeRateResponse> prepareGet( @Nonnull Identifier identifier )
    {
        return buildGetRequest( "rate", null, ExchangeRateResponse.class );
    }

    @Override
    public ExchangeRateResponse executeGet( @Nonnull Object request,
                                            @Nullable Map<String, Object> parameters,
                                            @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public PostFacadeRequest<ExchangeResponse> prepareInsert( @Nonnull ExchangeRequest payload,
                                                              @Nullable Identifier parentKey,
                                                              @Nullable MediaProvider provider )
    {
        PostFacadeRequest<ExchangeResponse> request;
        request = buildPostRequest( "/exchange", parentKey, payload, ExchangeResponse.class );
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
