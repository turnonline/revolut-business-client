package biz.turnonline.ecosystem.revolut.business.transaction;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.transaction.model.Transaction;
import biz.turnonline.ecosystem.revolut.business.transaction.model.TransactionType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpResponse;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.956+01:00[Europe/Bratislava]" )
public class TransactionsApi
{
    private ApiClient apiClient;

    public TransactionsApi()
    {
        this( new ApiClient() );
    }

    public TransactionsApi( ApiClient apiClient )
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
     * Cancel transaction
     * <p><b>204</b> - Transaction cancelled
     * <p><b>0</b> - Unexpected error
     *
     * @param transactionId The id of the transaction
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void cancelTransaction( UUID transactionId ) throws IOException
    {
        cancelTransactionForHttpResponse( transactionId );
    }

    /**
     * Cancel transaction
     * <p><b>204</b> - Transaction cancelled
     * <p><b>0</b> - Unexpected error
     *
     * @param transactionId The id of the transaction
     * @param params        Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public void cancelTransaction( UUID transactionId, Map<String, Object> params ) throws IOException
    {
        cancelTransactionForHttpResponse( transactionId, params );
    }

    public HttpResponse cancelTransactionForHttpResponse( UUID transactionId ) throws IOException
    {
        // verify the required parameter 'transactionId' is set
        if ( transactionId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transactionId' when calling cancelTransaction" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "transactionId", transactionId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transaction/{transactionId}" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.DELETE, genericUrl, content ).execute();
    }

    public HttpResponse cancelTransactionForHttpResponse( UUID transactionId, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'transactionId' is set
        if ( transactionId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transactionId' when calling cancelTransaction" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "transactionId", transactionId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transaction/{transactionId}" );

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
     * Info for a specific transaction
     * <p><b>200</b> - List of business transactions
     * <p><b>0</b> - Unexpected error
     *
     * @param transactionIdentifier The id of the transaction or request id if id_type&#x3D;request_id to retrieve
     * @param idType                type of the transaction identifier provided
     * @return Transaction
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Transaction getTransaction( String transactionIdentifier, String idType ) throws IOException
    {
        HttpResponse response = getTransactionForHttpResponse( transactionIdentifier, idType );
        TypeReference<Transaction> typeRef = new TypeReference<Transaction>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Info for a specific transaction
     * <p><b>200</b> - List of business transactions
     * <p><b>0</b> - Unexpected error
     *
     * @param transactionIdentifier The id of the transaction or request id if id_type&#x3D;request_id to retrieve
     * @param params                Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return Transaction
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Transaction getTransaction( String transactionIdentifier, Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getTransactionForHttpResponse( transactionIdentifier, params );
        TypeReference<Transaction> typeRef = new TypeReference<Transaction>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getTransactionForHttpResponse( String transactionIdentifier, String idType ) throws IOException
    {
        // verify the required parameter 'transactionIdentifier' is set
        if ( transactionIdentifier == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transactionIdentifier' when calling getTransaction" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "transactionIdentifier", transactionIdentifier );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transaction/{transactionIdentifier}" );
        if ( idType != null )
        {
            String key = "id_type";
            Object value = idType;
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

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getTransactionForHttpResponse( String transactionIdentifier, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'transactionIdentifier' is set
        if ( transactionIdentifier == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'transactionIdentifier' when calling getTransaction" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "transactionIdentifier", transactionIdentifier );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transaction/{transactionIdentifier}" );

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
     * List all transactions
     * <p><b>200</b> - List of business transactions
     * <p><b>0</b> - Unexpected error
     *
     * @param from         The from parameter
     * @param to           The to parameter
     * @param counterparty The counterparty parameter
     * @param count        The count parameter
     * @param type         The type parameter
     * @return List&lt;Transaction&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<Transaction> getTransactions( String from,
                                              String to,
                                              UUID counterparty,
                                              Integer count,
                                              TransactionType type ) throws IOException
    {
        HttpResponse response = getTransactionsForHttpResponse( from, to, counterparty, count, type );
        TypeReference<List<Transaction>> typeRef = new TypeReference<List<Transaction>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * List all transactions
     * <p><b>200</b> - List of business transactions
     * <p><b>0</b> - Unexpected error
     *
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return List&lt;Transaction&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<Transaction> getTransactions( Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getTransactionsForHttpResponse( params );
        TypeReference<List<Transaction>> typeRef = new TypeReference<List<Transaction>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getTransactionsForHttpResponse( String from,
                                                        String to,
                                                        UUID counterparty,
                                                        Integer count,
                                                        TransactionType type ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transactions" );
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
        if ( counterparty != null )
        {
            String key = "counterparty";
            Object value = counterparty;
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
        if ( count != null )
        {
            String key = "count";
            Object value = count;
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
        if ( type != null )
        {
            String key = "type";
            Object value = type;
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

    public HttpResponse getTransactionsForHttpResponse( Map<String, Object> params ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/transactions" );

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
