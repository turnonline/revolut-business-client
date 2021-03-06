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


package biz.turnonline.ecosystem.revolut.business.transaction.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;
import java.util.UUID;

/**
 * PaymentReceiver
 */
@JsonPropertyOrder( {
        PaymentReceiver.JSON_PROPERTY_COUNTERPARTY_ID,
        PaymentReceiver.JSON_PROPERTY_ACCOUNT_ID
} )
public class PaymentReceiver
{
    public static final String JSON_PROPERTY_COUNTERPARTY_ID = "counterparty_id";

    public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";

    private UUID counterpartyId;

    private UUID accountId;

    public PaymentReceiver counterpartyId( UUID counterpartyId )
    {

        this.counterpartyId = counterpartyId;
        return this;
    }

    /**
     * Get counterpartyId
     *
     * @return counterpartyId
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_COUNTERPARTY_ID )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )
    public UUID getCounterpartyId()
    {
        return counterpartyId;
    }

    public void setCounterpartyId( UUID counterpartyId )
    {
        this.counterpartyId = counterpartyId;
    }

    public PaymentReceiver accountId( UUID accountId )
    {

        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_ACCOUNT_ID )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public UUID getAccountId()
    {
        return accountId;
    }

    public void setAccountId( UUID accountId )
    {
        this.accountId = accountId;
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
        PaymentReceiver paymentReceiver = ( PaymentReceiver ) o;
        return Objects.equals( this.counterpartyId, paymentReceiver.counterpartyId ) &&
                Objects.equals( this.accountId, paymentReceiver.accountId );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( counterpartyId, accountId );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class PaymentReceiver {\n" );
        sb.append( "    counterpartyId: " ).append( toIndentedString( counterpartyId ) ).append( "\n" );
        sb.append( "    accountId: " ).append( toIndentedString( accountId ) ).append( "\n" );
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

