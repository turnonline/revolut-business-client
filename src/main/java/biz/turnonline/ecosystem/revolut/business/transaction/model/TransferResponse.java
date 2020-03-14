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

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * TransferResponse
 */
@JsonPropertyOrder( {
        TransferResponse.JSON_PROPERTY_ID,
        TransferResponse.JSON_PROPERTY_STATE,
        TransferResponse.JSON_PROPERTY_CREATED_AT,
        TransferResponse.JSON_PROPERTY_COMPLETED_AT
} )
public class TransferResponse
{
    public static final String JSON_PROPERTY_ID = "id";

    public static final String JSON_PROPERTY_STATE = "state";

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";

    public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";

    private String id;

    private TransactionState state;

    private OffsetDateTime createdAt;

    private OffsetDateTime completedAt;

    public TransferResponse id( String id )
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

    public TransferResponse state( TransactionState state )
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

    public TransferResponse createdAt( OffsetDateTime createdAt )
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

    public TransferResponse completedAt( OffsetDateTime completedAt )
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
        TransferResponse transferResponse = ( TransferResponse ) o;
        return Objects.equals( this.id, transferResponse.id ) &&
                Objects.equals( this.state, transferResponse.state ) &&
                Objects.equals( this.createdAt, transferResponse.createdAt ) &&
                Objects.equals( this.completedAt, transferResponse.completedAt );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, state, createdAt, completedAt );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class TransferResponse {\n" );
        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    state: " ).append( toIndentedString( state ) ).append( "\n" );
        sb.append( "    createdAt: " ).append( toIndentedString( createdAt ) ).append( "\n" );
        sb.append( "    completedAt: " ).append( toIndentedString( completedAt ) ).append( "\n" );
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

