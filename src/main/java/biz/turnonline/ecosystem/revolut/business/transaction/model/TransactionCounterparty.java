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
 * TransactionCounterparty
 */
@JsonPropertyOrder( {
        TransactionCounterparty.JSON_PROPERTY_ID,
        TransactionCounterparty.JSON_PROPERTY_ACCOUNT_ID,
        TransactionCounterparty.JSON_PROPERTY_ACCOUNT_TYPE
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.956+01:00[Europe/Bratislava]" )
public class TransactionCounterparty
{
    public static final String JSON_PROPERTY_ID = "id";

    public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";

    public static final String JSON_PROPERTY_ACCOUNT_TYPE = "account_type";

    private UUID id;

    private UUID accountId;

    private TransactionCounterpartyAccountType accountType;


    public TransactionCounterparty id( UUID id )
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


    public TransactionCounterparty accountId( UUID accountId )
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


    public TransactionCounterparty accountType( TransactionCounterpartyAccountType accountType )
    {

        this.accountType = accountType;
        return this;
    }

    /**
     * Get accountType
     *
     * @return accountType
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_ACCOUNT_TYPE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public TransactionCounterpartyAccountType getAccountType()
    {
        return accountType;
    }


    public void setAccountType( TransactionCounterpartyAccountType accountType )
    {
        this.accountType = accountType;
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
        TransactionCounterparty transactionCounterparty = ( TransactionCounterparty ) o;
        return Objects.equals( this.id, transactionCounterparty.id ) &&
                Objects.equals( this.accountId, transactionCounterparty.accountId ) &&
                Objects.equals( this.accountType, transactionCounterparty.accountType );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, accountId, accountType );
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class TransactionCounterparty {\n" );
        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    accountId: " ).append( toIndentedString( accountId ) ).append( "\n" );
        sb.append( "    accountType: " ).append( toIndentedString( accountType ) ).append( "\n" );
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

