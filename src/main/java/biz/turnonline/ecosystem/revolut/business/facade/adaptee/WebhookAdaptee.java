package biz.turnonline.ecosystem.revolut.business.facade.adaptee;

import biz.turnonline.ecosystem.revolut.business.facade.AbstractFacadeAdaptee;
import biz.turnonline.ecosystem.revolut.business.facade.DeleteFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.facade.FacadeClient;
import biz.turnonline.ecosystem.revolut.business.facade.GetFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.facade.PostFacadeRequest;
import biz.turnonline.ecosystem.revolut.business.webhook.model.Webhook;
import org.ctoolkit.restapi.client.Identifier;
import org.ctoolkit.restapi.client.adaptee.DeleteExecutorAdaptee;
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
 * The {@link Webhook} adaptee implementation.
 *
 * @author <a href="mailto:medvegy@turnonline.biz">Aurel Medvegy</a>
 */
@Singleton
public class WebhookAdaptee
        extends AbstractFacadeAdaptee
        implements GetExecutorAdaptee<Webhook>, InsertExecutorAdaptee<Webhook>, DeleteExecutorAdaptee<Webhook>
{
    @Inject
    public WebhookAdaptee( Provider<FacadeClient> client )
    {
        super( client );
    }

    @Override
    public DeleteFacadeRequest<Void> prepareDelete( @Nonnull Identifier identifier )
    {
        return buildDeleteRequest( "webhook", null, Void.class );
    }

    @Override
    public Object executeDelete( @Nonnull Object request,
                                 @Nullable Map<String, Object> parameters,
                                 @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public GetFacadeRequest<Webhook> prepareGet( @Nonnull Identifier identifier )
    {
        return buildGetRequest( "webhook", null, Webhook.class );
    }

    @Override
    public Webhook executeGet( @Nonnull Object request,
                               @Nullable Map<String, Object> parameters,
                               @Nullable Locale locale ) throws IOException
    {
        return execute( request, parameters );
    }

    @Override
    public PostFacadeRequest<Void> prepareInsert( @Nonnull Webhook payload,
                                                  @Nullable Identifier parentKey,
                                                  @Nullable MediaProvider provider )
    {
        PostFacadeRequest<Void> request;
        request = buildPostRequest( "webhook", null, payload, Void.class );
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
