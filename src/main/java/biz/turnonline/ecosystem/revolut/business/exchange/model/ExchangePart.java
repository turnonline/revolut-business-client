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
import java.util.UUID;

/**
 * ExchangePart
 */
@JsonPropertyOrder( {
        ExchangePart.JSON_PROPERTY_ACCOUNT_ID,
        ExchangePart.JSON_PROPERTY_CURRENCY,
        ExchangePart.JSON_PROPERTY_AMOUNT
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.813+01:00[Europe/Bratislava]" )
public class ExchangePart
{
    public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";

    public static final String JSON_PROPERTY_CURRENCY = "currency";

    public static final String JSON_PROPERTY_AMOUNT = "amount";

    private UUID accountId;

    private String currency;

    private Double amount;


    public ExchangePart accountId( UUID accountId )
    {

        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_ACCOUNT_ID )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public UUID getAccountId()
    {
        return accountId;
    }


    public void setAccountId( UUID accountId )
    {
        this.accountId = accountId;
    }


    public ExchangePart currency( String currency )
    {

        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_CURRENCY )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public String getCurrency()
    {
        return currency;
    }


    public void setCurrency( String currency )
    {
        this.currency = currency;
    }


    public ExchangePart amount( Double amount )
    {

        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_AMOUNT )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public Double getAmount()
    {
        return amount;
    }


    public void setAmount( Double amount )
    {
        this.amount = amount;
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
        ExchangePart exchangePart = ( ExchangePart ) o;
        return Objects.equals( this.accountId, exchangePart.accountId ) &&
                Objects.equals( this.currency, exchangePart.currency ) &&
                Objects.equals( this.amount, exchangePart.amount );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( accountId, currency, amount );
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class ExchangePart {\n" );
        sb.append( "    accountId: " ).append( toIndentedString( accountId ) ).append( "\n" );
        sb.append( "    currency: " ).append( toIndentedString( currency ) ).append( "\n" );
        sb.append( "    amount: " ).append( toIndentedString( amount ) ).append( "\n" );
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

