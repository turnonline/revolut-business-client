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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PaymentDraftResponse
 */
@JsonPropertyOrder( {
        PaymentDraftResponse.JSON_PROPERTY_SCHEDULED_FOR,
        PaymentDraftResponse.JSON_PROPERTY_TITLE,
        PaymentDraftResponse.JSON_PROPERTY_PAYMENTS
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.599+01:00[Europe/Bratislava]" )
public class PaymentDraftResponse
{
    public static final String JSON_PROPERTY_SCHEDULED_FOR = "scheduled_for";

    public static final String JSON_PROPERTY_TITLE = "title";

    public static final String JSON_PROPERTY_PAYMENTS = "payments";

    private LocalDate scheduledFor;

    private String title;

    private List<PaymentInfo> payments = new ArrayList<>();


    public PaymentDraftResponse scheduledFor( LocalDate scheduledFor )
    {

        this.scheduledFor = scheduledFor;
        return this;
    }

    /**
     * Get scheduledFor
     *
     * @return scheduledFor
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_SCHEDULED_FOR )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public LocalDate getScheduledFor()
    {
        return scheduledFor;
    }


    public void setScheduledFor( LocalDate scheduledFor )
    {
        this.scheduledFor = scheduledFor;
    }


    public PaymentDraftResponse title( String title )
    {

        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_TITLE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }


    public PaymentDraftResponse payments( List<PaymentInfo> payments )
    {

        this.payments = payments;
        return this;
    }

    public PaymentDraftResponse addPaymentsItem( PaymentInfo paymentsItem )
    {
        this.payments.add( paymentsItem );
        return this;
    }

    /**
     * Get payments
     *
     * @return payments
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_PAYMENTS )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public List<PaymentInfo> getPayments()
    {
        return payments;
    }


    public void setPayments( List<PaymentInfo> payments )
    {
        this.payments = payments;
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
        PaymentDraftResponse paymentDraftResponse = ( PaymentDraftResponse ) o;
        return Objects.equals( this.scheduledFor, paymentDraftResponse.scheduledFor ) &&
                Objects.equals( this.title, paymentDraftResponse.title ) &&
                Objects.equals( this.payments, paymentDraftResponse.payments );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( scheduledFor, title, payments );
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class PaymentDraftResponse {\n" );
        sb.append( "    scheduledFor: " ).append( toIndentedString( scheduledFor ) ).append( "\n" );
        sb.append( "    title: " ).append( toIndentedString( title ) ).append( "\n" );
        sb.append( "    payments: " ).append( toIndentedString( payments ) ).append( "\n" );
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

