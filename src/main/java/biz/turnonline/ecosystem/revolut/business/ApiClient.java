package biz.turnonline.ecosystem.revolut.business;

import biz.turnonline.ecosystem.revolut.business.account.AccountsApi;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.Json;
import org.openapitools.jackson.nullable.JsonNullableModule;

import java.io.IOException;
import java.io.OutputStream;

@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:40.834+01:00[Europe/Bratislava]" )
public class ApiClient
{
    private static final String defaultBasePath = "https://b2b.revolut.com/api/1.0";

    private final String basePath;

    private final HttpRequestFactory httpRequestFactory;

    private final ObjectMapper objectMapper;

    public ApiClient()
    {
        this( null, null, null, null );
    }

    public ApiClient(
            String basePath,
            HttpTransport httpTransport,
            HttpRequestInitializer initializer,
            ObjectMapper objectMapper
    )
    {
        this.basePath = basePath == null ? defaultBasePath : (
                basePath.endsWith( "/" ) ? basePath.substring( 0, basePath.length() - 1 ) : basePath
        );
        this.httpRequestFactory = ( httpTransport == null ? Utils.getDefaultTransport() : httpTransport ).createRequestFactory( initializer );
        this.objectMapper = ( objectMapper == null ? createDefaultObjectMapper() : objectMapper );
    }

    // A reasonable default object mapper. Client can pass in a chosen ObjectMapper anyway, this is just for reasonable defaults.
    private static ObjectMapper createDefaultObjectMapper()
    {
        ObjectMapper objectMapper = new ObjectMapper()
                .disable( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES )
                .disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
                .setDateFormat( new RFC3339DateFormat() );
        objectMapper.registerModule( new JavaTimeModule() );
        JsonNullableModule jnm = new JsonNullableModule();
        objectMapper.registerModule( jnm );
        return objectMapper;
    }

    public HttpRequestFactory getHttpRequestFactory()
    {
        return httpRequestFactory;
    }

    public String getBasePath()
    {
        return basePath;
    }

    public ObjectMapper getObjectMapper()
    {
        return objectMapper;
    }

    public AccountsApi accountsApi()
    {
        return new AccountsApi( this );
    }

    // Builder pattern to get API instances for this client.

    public class JacksonJsonHttpContent
            extends AbstractHttpContent
    {
        /* A POJO that can be serialized with a com.fasterxml Jackson ObjectMapper */
        private final Object data;

        public JacksonJsonHttpContent( Object data )
        {
            super( Json.MEDIA_TYPE );
            this.data = data;
        }

        @Override
        public void writeTo( OutputStream out ) throws IOException
        {
            objectMapper.writeValue( out, data );
        }
    }

}
