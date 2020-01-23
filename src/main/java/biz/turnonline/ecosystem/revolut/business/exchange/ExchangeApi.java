package biz.turnonline.ecosystem.revolut.business.exchange;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRateResponse;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeRequest;
import biz.turnonline.ecosystem.revolut.business.exchange.model.ExchangeResponse;
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

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.813+01:00[Europe/Bratislava]" )
public class ExchangeApi
{
    private ApiClient apiClient;

    public ExchangeApi()
    {
        this( new ApiClient() );
    }

    public ExchangeApi( ApiClient apiClient )
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
     * Exchange money
     * <p><b>200</b> - Exchange operation info
     * <p><b>0</b> - Unexpected error
     *
     * @param exchangeRequest Exchange info
     * @return ExchangeResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public ExchangeResponse exchangeMoney( ExchangeRequest exchangeRequest ) throws IOException
    {
        HttpResponse response = exchangeMoneyForHttpResponse( exchangeRequest );
        TypeReference<ExchangeResponse> typeRef = new TypeReference<ExchangeResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Exchange money
     * <p><b>200</b> - Exchange operation info
     * <p><b>0</b> - Unexpected error
     *
     * @param exchangeRequest Exchange info
     * @param params          Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return ExchangeResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public ExchangeResponse exchangeMoney( ExchangeRequest exchangeRequest, Map<String, Object> params )
            throws IOException
    {
        HttpResponse response = exchangeMoneyForHttpResponse( exchangeRequest, params );
        TypeReference<ExchangeResponse> typeRef = new TypeReference<ExchangeResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse exchangeMoneyForHttpResponse( ExchangeRequest exchangeRequest ) throws IOException
    {
        // verify the required parameter 'exchangeRequest' is set
        if ( exchangeRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'exchangeRequest' when calling exchangeMoney" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/exchange" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( exchangeRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse exchangeMoneyForHttpResponse( java.io.InputStream exchangeRequest, String mediaType )
            throws IOException
    {
        // verify the required parameter 'exchangeRequest' is set
        if ( exchangeRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'exchangeRequest' when calling exchangeMoney" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/exchange" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = exchangeRequest == null ?
                apiClient.new JacksonJsonHttpContent( null ) :
                new InputStreamContent( mediaType == null ? Json.MEDIA_TYPE : mediaType, exchangeRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse exchangeMoneyForHttpResponse( ExchangeRequest exchangeRequest, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'exchangeRequest' is set
        if ( exchangeRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'exchangeRequest' when calling exchangeMoney" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/exchange" );

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

        HttpContent content = apiClient.new JacksonJsonHttpContent( exchangeRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }


    /**
     * Get exchange rate
     * <p><b>200</b> - Exchange rate info
     * <p><b>0</b> - Unexpected error
     *
     * @param from   The currency you would like to exchange from
     * @param to     The currency you would like to exchange to
     * @param amount Exchange amount, default is 1.00
     * @return ExchangeRateResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public ExchangeRateResponse getRate( String from, String to, Double amount ) throws IOException
    {
        HttpResponse response = getRateForHttpResponse( from, to, amount );
        TypeReference<ExchangeRateResponse> typeRef = new TypeReference<ExchangeRateResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Get exchange rate
     * <p><b>200</b> - Exchange rate info
     * <p><b>0</b> - Unexpected error
     *
     * @param from   The currency you would like to exchange from
     * @param to     The currency you would like to exchange to
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return ExchangeRateResponse
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public ExchangeRateResponse getRate( String from, String to, Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getRateForHttpResponse( from, to, params );
        TypeReference<ExchangeRateResponse> typeRef = new TypeReference<ExchangeRateResponse>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getRateForHttpResponse( String from, String to, Double amount ) throws IOException
    {
        // verify the required parameter 'from' is set
        if ( from == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'from' when calling getRate" );
        }// verify the required parameter 'to' is set
        if ( to == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'to' when calling getRate" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/rate" );
        if ( from != null )
        {
            String key = "from";
            Object value = from;
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
        if ( to != null )
        {
            String key = "to";
            Object value = to;
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
        if ( amount != null )
        {
            String key = "amount";
            Object value = amount;
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getRateForHttpResponse( String from, String to, Map<String, Object> params ) throws IOException
    {
        // verify the required parameter 'from' is set
        if ( from == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'from' when calling getRate" );
        }// verify the required parameter 'to' is set
        if ( to == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'to' when calling getRate" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/rate" );

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>( params );
        // Add the required query param 'from' to the map of query params
        allParams.put( "from", from );
        // Add the required query param 'to' to the map of query params
        allParams.put( "to", to );

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
