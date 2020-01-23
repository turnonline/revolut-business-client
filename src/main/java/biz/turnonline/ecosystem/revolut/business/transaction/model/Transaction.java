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

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Transaction
 */
@JsonPropertyOrder( {
        Transaction.JSON_PROPERTY_ID,
        Transaction.JSON_PROPERTY_TYPE,
        Transaction.JSON_PROPERTY_REQUEST_ID,
        Transaction.JSON_PROPERTY_STATE,
        Transaction.JSON_PROPERTY_REASON_CODE,
        Transaction.JSON_PROPERTY_CREATED_AT,
        Transaction.JSON_PROPERTY_UPDATED_AT,
        Transaction.JSON_PROPERTY_COMPLETED_AT,
        Transaction.JSON_PROPERTY_SCHEDULED_FOR,
        Transaction.JSON_PROPERTY_RELATED_TRANSACTION_ID,
        Transaction.JSON_PROPERTY_MERCHANT,
        Transaction.JSON_PROPERTY_REFERENCE,
        Transaction.JSON_PROPERTY_LEGS,
        Transaction.JSON_PROPERTY_CARD
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.956+01:00[Europe/Bratislava]" )
public class Transaction
{
    public static final String JSON_PROPERTY_ID = "id";

    public static final String JSON_PROPERTY_TYPE = "type";

    public static final String JSON_PROPERTY_REQUEST_ID = "request_id";

    public static final String JSON_PROPERTY_STATE = "state";

    public static final String JSON_PROPERTY_REASON_CODE = "reason_code";

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";

    public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";

    public static final String JSON_PROPERTY_SCHEDULED_FOR = "scheduled_for";

    public static final String JSON_PROPERTY_RELATED_TRANSACTION_ID = "related_transaction_id";

    public static final String JSON_PROPERTY_MERCHANT = "merchant";

    public static final String JSON_PROPERTY_REFERENCE = "reference";

    public static final String JSON_PROPERTY_LEGS = "legs";

    public static final String JSON_PROPERTY_CARD = "card";

    private String id;

    private TransactionType type;

    private String requestId;

    private TransactionState state;

    private String reasonCode;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private OffsetDateTime completedAt;

    private LocalDate scheduledFor;

    private UUID relatedTransactionId;

    private TransactionMerchant merchant;

    private String reference;

    private List<TransactionLeg> legs = new ArrayList<>();

    private TransactionCard card;


    public Transaction id( String id )
    {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_ID )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public String getId()
    {
        return id;
    }


    public void setId( String id )
    {
        this.id = id;
    }


    public Transaction type( TransactionType type )
    {

        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_TYPE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public TransactionType getType()
    {
        return type;
    }


    public void setType( TransactionType type )
    {
        this.type = type;
    }


    public Transaction requestId( String requestId )
    {

        this.requestId = requestId;
        return this;
    }

    /**
     * Get requestId
     *
     * @return requestId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_REQUEST_ID )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getRequestId()
    {
        return requestId;
    }


    public void setRequestId( String requestId )
    {
        this.requestId = requestId;
    }


    public Transaction state( TransactionState state )
    {

        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_STATE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public TransactionState getState()
    {
        return state;
    }


    public void setState( TransactionState state )
    {
        this.state = state;
    }


    public Transaction reasonCode( String reasonCode )
    {

        this.reasonCode = reasonCode;
        return this;
    }

    /**
     * Get reasonCode
     *
     * @return reasonCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_REASON_CODE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getReasonCode()
    {
        return reasonCode;
    }


    public void setReasonCode( String reasonCode )
    {
        this.reasonCode = reasonCode;
    }


    public Transaction createdAt( OffsetDateTime createdAt )
    {

        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_CREATED_AT )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public OffsetDateTime getCreatedAt()
    {
        return createdAt;
    }


    public void setCreatedAt( OffsetDateTime createdAt )
    {
        this.createdAt = createdAt;
    }


    public Transaction updatedAt( OffsetDateTime updatedAt )
    {

        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get updatedAt
     *
     * @return updatedAt
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_UPDATED_AT )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public OffsetDateTime getUpdatedAt()
    {
        return updatedAt;
    }


    public void setUpdatedAt( OffsetDateTime updatedAt )
    {
        this.updatedAt = updatedAt;
    }


    public Transaction completedAt( OffsetDateTime completedAt )
    {

        this.completedAt = completedAt;
        return this;
    }

    /**
     * Get completedAt
     *
     * @return completedAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_COMPLETED_AT )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public OffsetDateTime getCompletedAt()
    {
        return completedAt;
    }


    public void setCompletedAt( OffsetDateTime completedAt )
    {
        this.completedAt = completedAt;
    }


    public Transaction scheduledFor( LocalDate scheduledFor )
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


    public Transaction relatedTransactionId( UUID relatedTransactionId )
    {

        this.relatedTransactionId = relatedTransactionId;
        return this;
    }

    /**
     * Get relatedTransactionId
     *
     * @return relatedTransactionId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_RELATED_TRANSACTION_ID )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public UUID getRelatedTransactionId()
    {
        return relatedTransactionId;
    }


    public void setRelatedTransactionId( UUID relatedTransactionId )
    {
        this.relatedTransactionId = relatedTransactionId;
    }


    public Transaction merchant( TransactionMerchant merchant )
    {

        this.merchant = merchant;
        return this;
    }

    /**
     * Get merchant
     *
     * @return merchant
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_MERCHANT )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public TransactionMerchant getMerchant()
    {
        return merchant;
    }


    public void setMerchant( TransactionMerchant merchant )
    {
        this.merchant = merchant;
    }


    public Transaction reference( String reference )
    {

        this.reference = reference;
        return this;
    }

    /**
     * Get reference
     *
     * @return reference
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_REFERENCE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getReference()
    {
        return reference;
    }


    public void setReference( String reference )
    {
        this.reference = reference;
    }


    public Transaction legs( List<TransactionLeg> legs )
    {

        this.legs = legs;
        return this;
    }

    public Transaction addLegsItem( TransactionLeg legsItem )
    {
        this.legs.add( legsItem );
        return this;
    }

    /**
     * Get legs
     *
     * @return legs
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_LEGS )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public List<TransactionLeg> getLegs()
    {
        return legs;
    }


    public void setLegs( List<TransactionLeg> legs )
    {
        this.legs = legs;
    }


    public Transaction card( TransactionCard card )
    {

        this.card = card;
        return this;
    }

    /**
     * Get card
     *
     * @return card
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_CARD )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public TransactionCard getCard()
    {
        return card;
    }


    public void setCard( TransactionCard card )
    {
        this.card = card;
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
        Transaction transaction = ( Transaction ) o;
        return Objects.equals( this.id, transaction.id ) &&
                Objects.equals( this.type, transaction.type ) &&
                Objects.equals( this.requestId, transaction.requestId ) &&
                Objects.equals( this.state, transaction.state ) &&
                Objects.equals( this.reasonCode, transaction.reasonCode ) &&
                Objects.equals( this.createdAt, transaction.createdAt ) &&
                Objects.equals( this.updatedAt, transaction.updatedAt ) &&
                Objects.equals( this.completedAt, transaction.completedAt ) &&
                Objects.equals( this.scheduledFor, transaction.scheduledFor ) &&
                Objects.equals( this.relatedTransactionId, transaction.relatedTransactionId ) &&
                Objects.equals( this.merchant, transaction.merchant ) &&
                Objects.equals( this.reference, transaction.reference ) &&
                Objects.equals( this.legs, transaction.legs ) &&
                Objects.equals( this.card, transaction.card );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, type, requestId, state, reasonCode, createdAt, updatedAt, completedAt, scheduledFor, relatedTransactionId, merchant, reference, legs, card );
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class Transaction {\n" );
        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    type: " ).append( toIndentedString( type ) ).append( "\n" );
        sb.append( "    requestId: " ).append( toIndentedString( requestId ) ).append( "\n" );
        sb.append( "    state: " ).append( toIndentedString( state ) ).append( "\n" );
        sb.append( "    reasonCode: " ).append( toIndentedString( reasonCode ) ).append( "\n" );
        sb.append( "    createdAt: " ).append( toIndentedString( createdAt ) ).append( "\n" );
        sb.append( "    updatedAt: " ).append( toIndentedString( updatedAt ) ).append( "\n" );
        sb.append( "    completedAt: " ).append( toIndentedString( completedAt ) ).append( "\n" );
        sb.append( "    scheduledFor: " ).append( toIndentedString( scheduledFor ) ).append( "\n" );
        sb.append( "    relatedTransactionId: " ).append( toIndentedString( relatedTransactionId ) ).append( "\n" );
        sb.append( "    merchant: " ).append( toIndentedString( merchant ) ).append( "\n" );
        sb.append( "    reference: " ).append( toIndentedString( reference ) ).append( "\n" );
        sb.append( "    legs: " ).append( toIndentedString( legs ) ).append( "\n" );
        sb.append( "    card: " ).append( toIndentedString( card ) ).append( "\n" );
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
