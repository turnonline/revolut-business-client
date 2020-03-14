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

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * ExchangeResponse
 */
@JsonPropertyOrder( {
        ExchangeResponse.JSON_PROPERTY_ID,
        ExchangeResponse.JSON_PROPERTY_TYPE,
        ExchangeResponse.JSON_PROPERTY_REASON_CODE,
        ExchangeResponse.JSON_PROPERTY_CREATED_AT,
        ExchangeResponse.JSON_PROPERTY_COMPLETED_AT,
        ExchangeResponse.JSON_PROPERTY_STATE
} )
public class ExchangeResponse
{
    public static final String JSON_PROPERTY_ID = "id";

    public static final String JSON_PROPERTY_TYPE = "type";

    public static final String JSON_PROPERTY_REASON_CODE = "reason_code";

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";

    public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";

    public static final String JSON_PROPERTY_STATE = "state";

    private UUID id;

    private String type;

    private String reasonCode;

    private OffsetDateTime createdAt;

    private OffsetDateTime completedAt;

    private TransactionState state;

    public ExchangeResponse id( UUID id )
    {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_ID )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public UUID getId()
    {
        return id;
    }

    public void setId( UUID id )
    {
        this.id = id;
    }

    public ExchangeResponse type( String type )
    {

        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_TYPE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public String getType()
    {
        return type;
    }

    public void setType( String type )
    {
        this.type = type;
    }

    public ExchangeResponse reasonCode( String reasonCode )
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

    public ExchangeResponse createdAt( OffsetDateTime createdAt )
    {

        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_CREATED_AT )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public OffsetDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt( OffsetDateTime createdAt )
    {
        this.createdAt = createdAt;
    }

    public ExchangeResponse completedAt( OffsetDateTime completedAt )
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

    public ExchangeResponse state( TransactionState state )
    {

        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_STATE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public TransactionState getState()
    {
        return state;
    }

    public void setState( TransactionState state )
    {
        this.state = state;
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
        ExchangeResponse exchangeResponse = ( ExchangeResponse ) o;
        return Objects.equals( this.id, exchangeResponse.id ) &&
                Objects.equals( this.type, exchangeResponse.type ) &&
                Objects.equals( this.reasonCode, exchangeResponse.reasonCode ) &&
                Objects.equals( this.createdAt, exchangeResponse.createdAt ) &&
                Objects.equals( this.completedAt, exchangeResponse.completedAt ) &&
                Objects.equals( this.state, exchangeResponse.state );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, type, reasonCode, createdAt, completedAt, state );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class ExchangeResponse {\n" );
        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    type: " ).append( toIndentedString( type ) ).append( "\n" );
        sb.append( "    reasonCode: " ).append( toIndentedString( reasonCode ) ).append( "\n" );
        sb.append( "    createdAt: " ).append( toIndentedString( createdAt ) ).append( "\n" );
        sb.append( "    completedAt: " ).append( toIndentedString( completedAt ) ).append( "\n" );
        sb.append( "    state: " ).append( toIndentedString( state ) ).append( "\n" );
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

