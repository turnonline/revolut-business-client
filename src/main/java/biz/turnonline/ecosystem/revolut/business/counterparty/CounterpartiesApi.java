package biz.turnonline.ecosystem.revolut.business.counterparty;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.Counterparty;
import biz.turnonline.ecosystem.revolut.business.counterparty.model.CreateCounterpartyRequest;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.366+01:00[Europe/Bratislava]" )
public class CounterpartiesApi
{
    private ApiClient apiClient;

    public CounterpartiesApi()
    {
        this( new ApiClient() );
    }

    public CounterpartiesApi( ApiClient apiClient )
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
     * Create a new counterparty
     * <p><b>200</b> - Added counterparty
     * <p><b>0</b> - Unexpected error
     *
     * @param createCounterpartyRequest Counterparty to add
     * @return Counterparty
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Counterparty addCounterparty( CreateCounterpartyRequest createCounterpartyRequest ) throws IOException
    {
        HttpResponse response = addCounterpartyForHttpResponse( createCounterpartyRequest );
        TypeReference<Counterparty> typeRef = new TypeReference<Counterparty>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Create a new counterparty
     * <p><b>200</b> - Added counterparty
     * <p><b>0</b> - Unexpected error
     *
     * @param createCounterpartyRequest Counterparty to add
     * @param params                    Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return Counterparty
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Counterparty addCounterparty( CreateCounterpartyRequest createCounterpartyRequest,
                                         Map<String, Object> params ) throws IOException
    {
        HttpResponse response = addCounterpartyForHttpResponse( createCounterpartyRequest, params );
        TypeReference<Counterparty> typeRef = new TypeReference<Counterparty>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse addCounterpartyForHttpResponse( CreateCounterpartyRequest createCounterpartyRequest )
            throws IOException
    {
        // verify the required parameter 'createCounterpartyRequest' is set
        if ( createCounterpartyRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'createCounterpartyRequest' when calling addCounterparty" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = apiClient.new JacksonJsonHttpContent( createCounterpartyRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse addCounterpartyForHttpResponse( java.io.InputStream createCounterpartyRequest,
                                                        String mediaType ) throws IOException
    {
        // verify the required parameter 'createCounterpartyRequest' is set
        if ( createCounterpartyRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'createCounterpartyRequest' when calling addCounterparty" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = createCounterpartyRequest == null ?
                apiClient.new JacksonJsonHttpContent( null ) :
                new InputStreamContent( mediaType == null ? Json.MEDIA_TYPE : mediaType, createCounterpartyRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }

    public HttpResponse addCounterpartyForHttpResponse( CreateCounterpartyRequest createCounterpartyRequest,
                                                        Map<String, Object> params ) throws IOException
    {
        // verify the required parameter 'createCounterpartyRequest' is set
        if ( createCounterpartyRequest == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'createCounterpartyRequest' when calling addCounterparty" );
        }
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty" );

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

        HttpContent content = apiClient.new JacksonJsonHttpContent( createCounterpartyRequest );
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.POST, genericUrl, content ).execute();
    }


    /**
     * Delete the counterparty
     * <p><b>204</b> - Counterparty deleted
     * <p><b>0</b> - Unexpected error
     *
     * @param counterpartyId The id of the counterparty to delete
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void deleteCounterparty( UUID counterpartyId ) throws IOException
    {
        deleteCounterpartyForHttpResponse( counterpartyId );
    }

    /**
     * Delete the counterparty
     * <p><b>204</b> - Counterparty deleted
     * <p><b>0</b> - Unexpected error
     *
     * @param counterpartyId The id of the counterparty to delete
     * @param params         Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void deleteCounterparty( UUID counterpartyId, Map<String, Object> params ) throws IOException
    {
        deleteCounterpartyForHttpResponse( counterpartyId, params );
    }

    public HttpResponse deleteCounterpartyForHttpResponse( UUID counterpartyId ) throws IOException
    {
        // verify the required parameter 'counterpartyId' is set
        if ( counterpartyId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'counterpartyId' when calling deleteCounterparty" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "counterpartyId", counterpartyId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty/{counterpartyId}" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.DELETE, genericUrl, content ).execute();
    }

    public HttpResponse deleteCounterpartyForHttpResponse( UUID counterpartyId, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'counterpartyId' is set
        if ( counterpartyId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'counterpartyId' when calling deleteCounterparty" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "counterpartyId", counterpartyId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty/{counterpartyId}" );

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
     * List all counterparties
     * <p><b>200</b> - List of business counterparties
     * <p><b>0</b> - Unexpected error
     *
     * @return List&lt;Counterparty&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<Counterparty> getCounterparties() throws IOException
    {
        HttpResponse response = getCounterpartiesForHttpResponse();
        TypeReference<List<Counterparty>> typeRef = new TypeReference<List<Counterparty>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * List all counterparties
     * <p><b>200</b> - List of business counterparties
     * <p><b>0</b> - Unexpected error
     *
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return List&lt;Counterparty&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<Counterparty> getCounterparties( Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getCounterpartiesForHttpResponse( params );
        TypeReference<List<Counterparty>> typeRef = new TypeReference<List<Counterparty>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getCounterpartiesForHttpResponse() throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparties" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getCounterpartiesForHttpResponse( Map<String, Object> params ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparties" );

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
     * Info for a specific counterparty
     * <p><b>200</b> - Expected response to a valid request
     * <p><b>0</b> - Unexpected error
     *
     * @param counterpartyId The id of the counterparty to retrieve
     * @return Counterparty
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Counterparty getCounterparty( UUID counterpartyId ) throws IOException
    {
        HttpResponse response = getCounterpartyForHttpResponse( counterpartyId );
        TypeReference<Counterparty> typeRef = new TypeReference<Counterparty>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Info for a specific counterparty
     * <p><b>200</b> - Expected response to a valid request
     * <p><b>0</b> - Unexpected error
     *
     * @param counterpartyId The id of the counterparty to retrieve
     * @param params         Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return Counterparty
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Counterparty getCounterparty( UUID counterpartyId, Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getCounterpartyForHttpResponse( counterpartyId, params );
        TypeReference<Counterparty> typeRef = new TypeReference<Counterparty>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getCounterpartyForHttpResponse( UUID counterpartyId ) throws IOException
    {
        // verify the required parameter 'counterpartyId' is set
        if ( counterpartyId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'counterpartyId' when calling getCounterparty" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "counterpartyId", counterpartyId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty/{counterpartyId}" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getCounterpartyForHttpResponse( UUID counterpartyId, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'counterpartyId' is set
        if ( counterpartyId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'counterpartyId' when calling getCounterparty" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "counterpartyId", counterpartyId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/counterparty/{counterpartyId}" );

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


}
