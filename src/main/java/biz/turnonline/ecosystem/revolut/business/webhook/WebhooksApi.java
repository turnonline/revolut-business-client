package biz.turnonline.ecosystem.revolut.business.webhook;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.webhook.model.Webhook;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.json.Json;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:42.274+01:00[Europe/Bratislava]" )
public class WebhooksApi
{
    private ApiClient apiClient;

    public WebhooksApi()
    {
        this( new ApiClient() );
    }

    public WebhooksApi( ApiClient apiClient )
    {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient()
    {
        return apiClient;
    }

    public void setApiClient( ApiClient apiClient )
    {
        this.apiClient = apiClient;
    }

    /**
     * Delete a webhook
     * <p><b>204</b> - Webhook has been deleted
     * <p><b>0</b> - Unexpected error
     *
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void deleteWebhook() throws IOException
    {
        deleteWebhookForHttpResponse();
    }

    /**
     * Delete a webhook
     * <p><b>204</b> - Webhook has been deleted
     * <p><b>0</b> - Unexpected error
     *
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void deleteWebhook( Map<String, Object> params ) throws IOException
    {
        deleteWebhookForHttpResponse( params );
    }

    public HttpResponse deleteWebhookForHttpResponse() throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.DELETE, genericUrl, content ).execute();
    }

    public HttpResponse deleteWebhookForHttpResponse( Map<String, Object> params ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>( params );

        for ( Map.Entry<String, Object> entry : allParams.entrySet() )
        {
            String key = entry.getKey();
            Object value = entry.getValue();

            if ( key != null && value != null )
            {
                if ( value instanceof Collection )
                {
                    uriBuilder = uriBuilder.queryParam( key, ( ( Collection ) value ).toArray() );
                }
                else if ( value instanceof Object[] )
                {
                    uriBuilder = uriBuilder.queryParam( key, ( Object[] ) value );
                }
                else
                {
                    uriBuilder = uriBuilder.queryParam( key, value );
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.DELETE, genericUrl, content ).execute();
    }


    /**
     * Get an existing webhook
     * <p><b>200</b> - An existing webhook
     * <p><b>0</b> - Unexpected error
     *
     * @return Webhook
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Webhook getWebhook() throws IOException
    {
        HttpResponse response = getWebhookForHttpResponse();
        TypeReference<Webhook> typeRef = new TypeReference<Webhook>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Get an existing webhook
     * <p><b>200</b> - An existing webhook
     * <p><b>0</b> - Unexpected error
     *
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return Webhook
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Webhook getWebhook( Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getWebhookForHttpResponse( params );
        TypeReference<Webhook> typeRef = new TypeReference<Webhook>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getWebhookForHttpResponse() throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getWebhookForHttpResponse( Map<String, Object> params ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>( params );

        for ( Map.Entry<String, Object> entry : allParams.entrySet() )
        {
            String key = entry.getKey();
            Object value = entry.getValue();

            if ( key != null && value != null )
            {
                if ( value instanceof Collection )
                {
                    uriBuilder = uriBuilder.queryParam( key, ( ( Collection ) value ).toArray() );
                }
                else if ( value instanceof Object[] )
                {
                    uriBuilder = uriBuilder.queryParam( key, ( Object[] ) value );
                }
                else
                {
                    uriBuilder = uriBuilder.queryParam( key, value );
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }


    /**
     * Set up a webhook
     * <p><b>204</b> - Webhook has been set up
     * <p><b>0</b> - Unexpected error
     *
     * @param webhook URL to set up as a webhook
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void setupWebhook( Webhook webhook ) throws IOException
    {
        setupWebhookForHttpResponse( webhook );
    }

    /**
     * Set up a webhook
     * <p><b>204</b> - Webhook has been set up
     * <p><b>0</b> - Unexpected error
     *
     * @param webhook URL to set up as a webhook
     * @param params  Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void setupWebhook( Webhook webhook, Map<String, Object> params ) throws IOException
    {
        setupWebhookForHttpResponse( webhook, params );
    }

    public HttpResponse setupWebhookForHttpResponse( Webhook webhook ) throws IOException
    {
        // verify the required parameter 'webhook' is set
        if ( webhook == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'webhook' when calling setupWebhook" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( webhook );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse setupWebhookForHttpResponse( java.io.InputStream webhook, String mediaType ) throws IOException
    {
        // verify the required parameter 'webhook' is set
        if ( webhook == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'webhook' when calling setupWebhook" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = webhook == null ?
                apiClient.new JacksonJsonHttpContent( null ) :
                new InputStreamContent( mediaType == null ? Json.MEDIA_TYPE : mediaType, webhook );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse setupWebhookForHttpResponse( Webhook webhook, Map<String, Object> params ) throws IOException
    {
        // verify the required parameter 'webhook' is set
        if ( webhook == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'webhook' when calling setupWebhook" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/webhook" );

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>( params );

        for ( Map.Entry<String, Object> entry : allParams.entrySet() )
        {
            String key = entry.getKey();
            Object value = entry.getValue();

            if ( key != null && value != null )
            {
                if ( value instanceof Collection )
                {
                    uriBuilder = uriBuilder.queryParam( key, ( ( Collection ) value ).toArray() );
                }
                else if ( value instanceof Object[] )
                {
                    uriBuilder = uriBuilder.queryParam( key, ( Object[] ) value );
                }
                else
                {
                    uriBuilder = uriBuilder.queryParam( key, value );
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( webhook );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }


}
