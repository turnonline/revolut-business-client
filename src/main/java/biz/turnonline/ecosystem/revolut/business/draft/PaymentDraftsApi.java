package biz.turnonline.ecosystem.revolut.business.draft;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftRequest;
import biz.turnonline.ecosystem.revolut.business.draft.model.CreatePaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftResponse;
import biz.turnonline.ecosystem.revolut.business.draft.model.PaymentDraftsResponse;
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
import java.util.UUID;

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.599+01:00[Europe/Bratislava]" )
public class PaymentDraftsApi
{
    private ApiClient apiClient;

    public PaymentDraftsApi()
    {
        this( new ApiClient() );
    }

    public PaymentDraftsApi( ApiClient apiClient )
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
     * Create a new payment draft
     * <p><b>201</b> - Id of an added payment draft
     * <p><b>204</b> - No payments provided
     * <p><b>0</b> - Unexpected error
     *
     * @param createPaymentDraftRequest Payment draft info
     * @return CreatePaymentDraftResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public CreatePaymentDraftResponse createPaymentDraft( CreatePaymentDraftRequest createPaymentDraftRequest )
            throws IOException
    {
        HttpResponse response = createPaymentDraftForHttpResponse( createPaymentDraftRequest );
        TypeReference<CreatePaymentDraftResponse> typeRef = new TypeReference<CreatePaymentDraftResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Create a new payment draft
     * <p><b>201</b> - Id of an added payment draft
     * <p><b>204</b> - No payments provided
     * <p><b>0</b> - Unexpected error
     *
     * @param createPaymentDraftRequest Payment draft info
     * @param params                    Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return CreatePaymentDraftResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public CreatePaymentDraftResponse createPaymentDraft( CreatePaymentDraftRequest createPaymentDraftRequest,
                                                          Map<String, Object> params ) throws IOException
    {
        HttpResponse response = createPaymentDraftForHttpResponse( createPaymentDraftRequest, params );
        TypeReference<CreatePaymentDraftResponse> typeRef = new TypeReference<CreatePaymentDraftResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse createPaymentDraftForHttpResponse( CreatePaymentDraftRequest createPaymentDraftRequest )
            throws IOException
    {
        // verify the required parameter 'createPaymentDraftRequest' is set
        if ( createPaymentDraftRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'createPaymentDraftRequest' when calling createPaymentDraft" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( createPaymentDraftRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse createPaymentDraftForHttpResponse( java.io.InputStream createPaymentDraftRequest,
                                                           String mediaType ) throws IOException
    {
        // verify the required parameter 'createPaymentDraftRequest' is set
        if ( createPaymentDraftRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'createPaymentDraftRequest' when calling createPaymentDraft" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = createPaymentDraftRequest == null ?
                apiClient.new JacksonJsonHttpContent( null ) :
                new InputStreamContent( mediaType == null ? Json.MEDIA_TYPE : mediaType, createPaymentDraftRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse createPaymentDraftForHttpResponse( CreatePaymentDraftRequest createPaymentDraftRequest,
                                                           Map<String, Object> params ) throws IOException
    {
        // verify the required parameter 'createPaymentDraftRequest' is set
        if ( createPaymentDraftRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'createPaymentDraftRequest' when calling createPaymentDraft" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts" );

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

        HttpContent content = apiClient.new JacksonJsonHttpContent( createPaymentDraftRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }


    /**
     * Delete the payment draft
     * <p><b>204</b> - Payment draft deleted
     * <p><b>0</b> - Unexpected error
     *
     * @param paymentDraftId The id of the payment draft to delete
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void deletePaymentDraft( UUID paymentDraftId ) throws IOException
    {
        deletePaymentDraftForHttpResponse( paymentDraftId );
    }

    /**
     * Delete the payment draft
     * <p><b>204</b> - Payment draft deleted
     * <p><b>0</b> - Unexpected error
     *
     * @param paymentDraftId The id of the payment draft to delete
     * @param params         Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void deletePaymentDraft( UUID paymentDraftId, Map<String, Object> params ) throws IOException
    {
        deletePaymentDraftForHttpResponse( paymentDraftId, params );
    }

    public HttpResponse deletePaymentDraftForHttpResponse( UUID paymentDraftId ) throws IOException
    {
        // verify the required parameter 'paymentDraftId' is set
        if ( paymentDraftId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentDraftId' when calling deletePaymentDraft" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "paymentDraftId", paymentDraftId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts/{paymentDraftId}" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.DELETE, genericUrl, content ).execute();
    }

    public HttpResponse deletePaymentDraftForHttpResponse( UUID paymentDraftId, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'paymentDraftId' is set
        if ( paymentDraftId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentDraftId' when calling deletePaymentDraft" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "paymentDraftId", paymentDraftId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts/{paymentDraftId}" );

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

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.DELETE, genericUrl, content ).execute();
    }


    /**
     * Payment draft info
     * <p><b>200</b> - Payment draft info
     * <p><b>0</b> - Unexpected error
     *
     * @param paymentDraftId The id of the payment draft to retrieve
     * @return PaymentDraftResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public PaymentDraftResponse getPaymentDraft( UUID paymentDraftId ) throws IOException
    {
        HttpResponse response = getPaymentDraftForHttpResponse( paymentDraftId );
        TypeReference<PaymentDraftResponse> typeRef = new TypeReference<PaymentDraftResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Payment draft info
     * <p><b>200</b> - Payment draft info
     * <p><b>0</b> - Unexpected error
     *
     * @param paymentDraftId The id of the payment draft to retrieve
     * @param params         Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return PaymentDraftResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public PaymentDraftResponse getPaymentDraft( UUID paymentDraftId, Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getPaymentDraftForHttpResponse( paymentDraftId, params );
        TypeReference<PaymentDraftResponse> typeRef = new TypeReference<PaymentDraftResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getPaymentDraftForHttpResponse( UUID paymentDraftId ) throws IOException
    {
        // verify the required parameter 'paymentDraftId' is set
        if ( paymentDraftId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentDraftId' when calling getPaymentDraft" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "paymentDraftId", paymentDraftId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts/{paymentDraftId}" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getPaymentDraftForHttpResponse( UUID paymentDraftId, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'paymentDraftId' is set
        if ( paymentDraftId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentDraftId' when calling getPaymentDraft" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "paymentDraftId", paymentDraftId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts/{paymentDraftId}" );

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

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }


    /**
     * List all payment drafts
     * <p><b>200</b> - List of payment drafts
     * <p><b>0</b> - Unexpected error
     *
     * @return PaymentDraftsResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public PaymentDraftsResponse getPaymentDrafts() throws IOException
    {
        HttpResponse response = getPaymentDraftsForHttpResponse();
        TypeReference<PaymentDraftsResponse> typeRef = new TypeReference<PaymentDraftsResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * List all payment drafts
     * <p><b>200</b> - List of payment drafts
     * <p><b>0</b> - Unexpected error
     *
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return PaymentDraftsResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public PaymentDraftsResponse getPaymentDrafts( Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getPaymentDraftsForHttpResponse( params );
        TypeReference<PaymentDraftsResponse> typeRef = new TypeReference<PaymentDraftsResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getPaymentDraftsForHttpResponse() throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getPaymentDraftsForHttpResponse( Map<String, Object> params ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/payment-drafts" );

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


}
