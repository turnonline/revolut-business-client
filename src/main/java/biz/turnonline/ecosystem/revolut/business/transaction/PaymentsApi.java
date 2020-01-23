package biz.turnonline.ecosystem.revolut.business.transaction;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.transaction.model.PaymentRequest;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransferResponse;
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

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.956+01:00[Europe/Bratislava]" )
public class PaymentsApi
{
    private ApiClient apiClient;

    public PaymentsApi()
    {
        this( new ApiClient() );
    }

    public PaymentsApi( ApiClient apiClient )
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
     * Create a payemnt
     * <p><b>200</b> - Created payment info
     * <p><b>0</b> - Unexpected error
     *
     * @param paymentRequest Payment to create
     * @return TransferResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public TransferResponse createPayment( PaymentRequest paymentRequest ) throws IOException
    {
        HttpResponse response = createPaymentForHttpResponse( paymentRequest );
        TypeReference<TransferResponse> typeRef = new TypeReference<TransferResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Create a payemnt
     * <p><b>200</b> - Created payment info
     * <p><b>0</b> - Unexpected error
     *
     * @param paymentRequest Payment to create
     * @param params         Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return TransferResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public TransferResponse createPayment( PaymentRequest paymentRequest, Map<String, Object> params )
            throws IOException
    {
        HttpResponse response = createPaymentForHttpResponse( paymentRequest, params );
        TypeReference<TransferResponse> typeRef = new TypeReference<TransferResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse createPaymentForHttpResponse( PaymentRequest paymentRequest ) throws IOException
    {
        // verify the required parameter 'paymentRequest' is set
        if ( paymentRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentRequest' when calling createPayment" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/pay" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( paymentRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse createPaymentForHttpResponse( java.io.InputStream paymentRequest, String mediaType )
            throws IOException
    {
        // verify the required parameter 'paymentRequest' is set
        if ( paymentRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentRequest' when calling createPayment" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/pay" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = paymentRequest == null ?
                apiClient.new JacksonJsonHttpContent( null ) :
                new InputStreamContent( mediaType == null ? Json.MEDIA_TYPE : mediaType, paymentRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse createPaymentForHttpResponse( PaymentRequest paymentRequest, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'paymentRequest' is set
        if ( paymentRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'paymentRequest' when calling createPayment" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/pay" );

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

        HttpContent content = apiClient.new JacksonJsonHttpContent( paymentRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }


}
