/*
 * Revolut for Business OpenAPI
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package biz.turnonline.ecosystem.revolut.business.exchange.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Error
 */
@JsonPropertyOrder( {
        Error.JSON_PROPERTY_CODE,
        Error.JSON_PROPERTY_MESSAGE
} )
public class Error
{
    public static final String JSON_PROPERTY_CODE = "code";

    public static final String JSON_PROPERTY_MESSAGE = "message";

    private Integer code;

    private String message;

    public Error code( Integer code )
    {

        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_CODE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )
    public Integer getCode()
    {
        return code;
    }

    public void setCode( Integer code )
    {
        this.code = code;
    }

    public Error message( String message )
    {

        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_MESSAGE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )
    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }

    @Override
    public boolean equals( java.lang.Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        Error error = ( Error ) o;
        return Objects.equals( this.code, error.code ) &&
                Objects.equals( this.message, error.message );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( code, message );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class Error {\n" );
        sb.append( "    code: " ).append( toIndentedString( code ) ).append( "\n" );
        sb.append( "    message: " ).append( toIndentedString( message ) ).append( "\n" );
        sb.append( "}" );
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString( java.lang.Object o )
    {
        if ( o == null )
        {
            return "null";
        }
        return o.toString().replace( "\n", "\n    " );
    }
}

