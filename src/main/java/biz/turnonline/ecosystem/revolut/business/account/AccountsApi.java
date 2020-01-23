package biz.turnonline.ecosystem.revolut.business.account;

import biz.turnonline.ecosystem.revolut.business.ApiClient;
import biz.turnonline.ecosystem.revolut.business.account.model.Account;
import biz.turnonline.ecosystem.revolut.business.account.model.AccountBankDetailsItem;
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

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:40.834+01:00[Europe/Bratislava]" )
public class AccountsApi
{
    private ApiClient apiClient;

    public AccountsApi()
    {
        this( new ApiClient() );
    }

    public AccountsApi( ApiClient apiClient )
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
     * Info for a specific account
     * <p><b>200</b> - Expected response to a valid request
     * <p><b>0</b> - Unexpected error
     *
     * @param accountId The id of the account to retrieve
     * @return Account
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Account getAccount( UUID accountId ) throws IOException
    {
        HttpResponse response = getAccountForHttpResponse( accountId );
        TypeReference<Account> typeRef = new TypeReference<Account>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * Info for a specific account
     * <p><b>200</b> - Expected response to a valid request
     * <p><b>0</b> - Unexpected error
     *
     * @param accountId The id of the account to retrieve
     * @param params    Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return Account
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public Account getAccount( UUID accountId, Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getAccountForHttpResponse( accountId, params );
        TypeReference<Account> typeRef = new TypeReference<Account>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getAccountForHttpResponse( UUID accountId ) throws IOException
    {
        // verify the required parameter 'accountId' is set
        if ( accountId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'accountId' when calling getAccount" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "accountId", accountId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/accounts/{accountId}" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getAccountForHttpResponse( UUID accountId, Map<String, Object> params ) throws IOException
    {
        // verify the required parameter 'accountId' is set
        if ( accountId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'accountId' when calling getAccount" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "accountId", accountId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/accounts/{accountId}" );

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
     * List all account bank details
     * <p><b>200</b> - List of business account bank details
     * <p><b>0</b> - Unexpected error
     *
     * @param accountId The id of the account to retrieve it&#39;s bank details
     * @return List&lt;AccountBankDetailsItem&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<AccountBankDetailsItem> getAccountDetails( UUID accountId ) throws IOException
    {
        HttpResponse response = getAccountDetailsForHttpResponse( accountId );
        TypeReference<List<AccountBankDetailsItem>> typeRef = new TypeReference<List<AccountBankDetailsItem>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * List all account bank details
     * <p><b>200</b> - List of business account bank details
     * <p><b>0</b> - Unexpected error
     *
     * @param accountId The id of the account to retrieve it&#39;s bank details
     * @param params    Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return List&lt;AccountBankDetailsItem&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<AccountBankDetailsItem> getAccountDetails( UUID accountId, Map<String, Object> params )
            throws IOException
    {
        HttpResponse response = getAccountDetailsForHttpResponse( accountId, params );
        TypeReference<List<AccountBankDetailsItem>> typeRef = new TypeReference<List<AccountBankDetailsItem>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getAccountDetailsForHttpResponse( UUID accountId ) throws IOException
    {
        // verify the required parameter 'accountId' is set
        if ( accountId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'accountId' when calling getAccountDetails" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "accountId", accountId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/accounts/{accountId}/bank-details" );

        String localVarUrl = uriBuilder.buildFromMap( uriVariables ).toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getAccountDetailsForHttpResponse( UUID accountId, Map<String, Object> params )
            throws IOException
    {
        // verify the required parameter 'accountId' is set
        if ( accountId == null )
        {
            throw new IllegalArgumentException( "Missing the required parameter 'accountId' when calling getAccountDetails" );
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put( "accountId", accountId );
        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/accounts/{accountId}/bank-details" );

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
     * List all accounts
     * <p><b>200</b> - List of business accounts
     * <p><b>0</b> - Unexpected error
     *
     * @return List&lt;Account&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<Account> getAccounts() throws IOException
    {
        HttpResponse response = getAccountsForHttpResponse();
        TypeReference<List<Account>> typeRef = new TypeReference<List<Account>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    /**
     * List all accounts
     * <p><b>200</b> - List of business accounts
     * <p><b>0</b> - Unexpected error
     *
     * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
     * @return List&lt;Account&gt;
     * @throws IOException if an error occurs while attempting to invoke the API
     **/
    public List<Account> getAccounts( Map<String, Object> params ) throws IOException
    {
        HttpResponse response = getAccountsForHttpResponse( params );
        TypeReference<List<Account>> typeRef = new TypeReference<List<Account>>()
        {
        };
        return apiClient.getObjectMapper().readValue( response.getContent(), typeRef );
    }

    public HttpResponse getAccountsForHttpResponse() throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/accounts" );

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl( localVarUrl );

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest( HttpMethods.GET, genericUrl, content ).execute();
    }

    public HttpResponse getAccountsForHttpResponse( Map<String, Object> params ) throws IOException
    {

        UriBuilder uriBuilder = UriBuilder.fromUri( apiClient.getBasePath() + "/accounts" );

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
