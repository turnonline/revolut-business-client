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


package biz.turnonline.ecosystem.revolut.business.draft.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * PaymentRequest
 */
@JsonPropertyOrder( {
        PaymentRequest.JSON_PROPERTY_ACCOUNT_ID,
        PaymentRequest.JSON_PROPERTY_RECEIVER,
        PaymentRequest.JSON_PROPERTY_AMOUNT,
        PaymentRequest.JSON_PROPERTY_CURRENCY,
        PaymentRequest.JSON_PROPERTY_REFERENCE
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.599+01:00[Europe/Bratislava]" )
public class PaymentRequest
{
    public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";

    public static final String JSON_PROPERTY_RECEIVER = "receiver";

    public static final String JSON_PROPERTY_AMOUNT = "amount";

    public static final String JSON_PROPERTY_CURRENCY = "currency";

    public static final String JSON_PROPERTY_REFERENCE = "reference";

    private String accountId;

    private PaymentReceiver receiver;

    private Double amount;

    private String currency;

    private String reference;


    public PaymentRequest accountId( String accountId )
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

    public String getAccountId()
    {
        return accountId;
    }


    public void setAccountId( String accountId )
    {
        this.accountId = accountId;
    }


    public PaymentRequest receiver( PaymentReceiver receiver )
    {

        this.receiver = receiver;
        return this;
    }

    /**
     * Get receiver
     *
     * @return receiver
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_RECEIVER )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public PaymentReceiver getReceiver()
    {
        return receiver;
    }


    public void setReceiver( PaymentReceiver receiver )
    {
        this.receiver = receiver;
    }


    public PaymentRequest amount( Double amount )
    {

        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_AMOUNT )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public Double getAmount()
    {
        return amount;
    }


    public void setAmount( Double amount )
    {
        this.amount = amount;
    }


    public PaymentRequest currency( String currency )
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


    public PaymentRequest reference( String reference )
    {

        this.reference = reference;
        return this;
    }

    /**
     * Get reference
     *
     * @return reference
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_REFERENCE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public String getReference()
    {
        return reference;
    }


    public void setReference( String reference )
    {
        this.reference = reference;
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
        PaymentRequest paymentRequest = ( PaymentRequest ) o;
        return Objects.equals( this.accountId, paymentRequest.accountId ) &&
                Objects.equals( this.receiver, paymentRequest.receiver ) &&
                Objects.equals( this.amount, paymentRequest.amount ) &&
                Objects.equals( this.currency, paymentRequest.currency ) &&
                Objects.equals( this.reference, paymentRequest.reference );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( accountId, receiver, amount, currency, reference );
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class PaymentRequest {\n" );
        sb.append( "    accountId: " ).append( toIndentedString( accountId ) ).append( "\n" );
        sb.append( "    receiver: " ).append( toIndentedString( receiver ) ).append( "\n" );
        sb.append( "    amount: " ).append( toIndentedString( amount ) ).append( "\n" );
        sb.append( "    currency: " ).append( toIndentedString( currency ) ).append( "\n" );
        sb.append( "    reference: " ).append( toIndentedString( reference ) ).append( "\n" );
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
