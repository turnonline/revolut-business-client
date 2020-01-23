package biz.turnonline.ecosystem.revolut.business.transaction;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransferRequest;
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
public class TransfersApi
{
    private ApiClient apiClient;

    public TransfersApi()
    {
        this( new ApiClient() );
    }

    public TransfersApi( ApiClient apiClient )
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
     * Create a transfer
     * <p><b>200</b> - Created transfer info
     * <p><b>0</b> - Unexpected error
     *
     * @param transferRequest Transfer to create
     * @return TransferResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public TransferResponse createTransfer( TransferRequest transferRequest ) throws IOException
    {
        HttpResponse response = createTransferForHttpResponse( transferRequest );
        TypeReference<TransferResponse> typeRef = new TypeReference<TransferResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Create a transfer
     * <p><b>200</b> - Created transfer info
     * <p><b>0</b> - Unexpected error
     *
     * @param transferRequest Transfer to create
     * @param params          Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return TransferResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public TransferResponse createTransfer( TransferRequest transferRequest, Map<String, Object> params )
            throws IOException
    {
        HttpResponse response = createTransferForHttpResponse( transferRequest, params );
        TypeReference<TransferResponse> typeRef = new TypeReference<TransferResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse createTransferForHttpResponse( TransferRequest transferRequest ) throws IOException
    {
        // verify the required parameter 'transferRequest' is set
        if ( transferRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transferRequest' when calling createTransfer" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transfer" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( transferRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse createTransferForHttpResponse( java.io.InputStream transferRequest, String mediaType )
            throws IOException
    {
        // verify the required parameter 'transferRequest' is set
        if ( transferRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transferRequest' when calling createTransfer" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transfer" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = transferRequest == null ?
                apiClient.new JacksonJsonHttpContent( null ) :
                new InputStreamContent( mediaType == null ? Json.MEDIA_TYPE : mediaType, transferRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse createTransferForHttpResponse( TransferRequest transferRequest, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'transferRequest' is set
        if ( transferRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transferRequest' when calling createTransfer" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transfer" );

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

        HttpContent content = apiClient.new JacksonJsonHttpContent( transferRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }


}
