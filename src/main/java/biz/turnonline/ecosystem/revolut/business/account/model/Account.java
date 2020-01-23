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


package biz.turnonline.ecosystem.revolut.business.account.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Account
 */
@JsonPropertyOrder( {
        Account.JSON_PROPERTY_ID,
        Account.JSON_PROPERTY_NAME,
        Account.JSON_PROPERTY_BALANCE,
        Account.JSON_PROPERTY_CURRENCY,
        Account.JSON_PROPERTY_STATE,
        Account.JSON_PROPERTY_PUBLIC,
        Account.JSON_PROPERTY_CREATED_AT,
        Account.JSON_PROPERTY_UPDATED_AT
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:40.834+01:00[Europe/Bratislava]" )
public class Account
{
    public static final String JSON_PROPERTY_ID = "id";

    public static final String JSON_PROPERTY_NAME = "name";

    public static final String JSON_PROPERTY_BALANCE = "balance";

    public static final String JSON_PROPERTY_CURRENCY = "currency";

    public static final String JSON_PROPERTY_STATE = "state";

    public static final String JSON_PROPERTY_PUBLIC = "public";

    public static final String JSON_PROPERTY_CREATED_AT = "created_at";

    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";

    private UUID id;

    private String name;

    private Double balance;

    private String currency;

    private StateEnum state;

    private Boolean _public;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    public Account id( UUID id )
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

    public UUID getId()
    {
        return id;
    }

    public void setId( UUID id )
    {
        this.id = id;
    }

    public Account name( String name )
    {

        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_NAME )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Account balance( Double balance )
    {

        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_BALANCE )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public Double getBalance()
    {
        return balance;
    }

    public void setBalance( Double balance )
    {
        this.balance = balance;
    }

    public Account currency( String currency )
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

    public Account state( StateEnum state )
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

    public StateEnum getState()
    {
        return state;
    }

    public void setState( StateEnum state )
    {
        this.state = state;
    }

    public Account _public( Boolean _public )
    {

        this._public = _public;
        return this;
    }

    /**
     * Get _public
     *
     * @return _public
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_PUBLIC )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )

    public Boolean getPublic()
    {
        return _public;
    }

    public void setPublic( Boolean _public )
    {
        this._public = _public;
    }

    public Account createdAt( OffsetDateTime createdAt )
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

    public Account updatedAt( OffsetDateTime updatedAt )
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
        Account account = ( Account ) o;
        return Objects.equals( this.id, account.id ) &&
                Objects.equals( this.name, account.name ) &&
                Objects.equals( this.balance, account.balance ) &&
                Objects.equals( this.currency, account.currency ) &&
                Objects.equals( this.state, account.state ) &&
                Objects.equals( this._public, account._public ) &&
                Objects.equals( this.createdAt, account.createdAt ) &&
                Objects.equals( this.updatedAt, account.updatedAt );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( id, name, balance, currency, state, _public, createdAt, updatedAt );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class Account {\n" );
        sb.append( "    id: " ).append( toIndentedString( id ) ).append( "\n" );
        sb.append( "    name: " ).append( toIndentedString( name ) ).append( "\n" );
        sb.append( "    balance: " ).append( toIndentedString( balance ) ).append( "\n" );
        sb.append( "    currency: " ).append( toIndentedString( currency ) ).append( "\n" );
        sb.append( "    state: " ).append( toIndentedString( state ) ).append( "\n" );
        sb.append( "    _public: " ).append( toIndentedString( _public ) ).append( "\n" );
        sb.append( "    createdAt: " ).append( toIndentedString( createdAt ) ).append( "\n" );
        sb.append( "    updatedAt: " ).append( toIndentedString( updatedAt ) ).append( "\n" );
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

    /**
     * Gets or Sets state
     */
    public enum StateEnum
    {
        ACTIVE( "active" ),

        INACTIVE( "inactive" );

        private String value;

        StateEnum( String value )
        {
            this.value = value;
        }

        @JsonCreator
        public static StateEnum fromValue( String value )
        {
            for ( StateEnum b : StateEnum.values() )
            {
                if ( b.value.equals( value ) )
                {
                    return b;
                }
            }
            throw new IllegalArgumentException( "Unexpected value '" + value + "'" );
        }

        @JsonValue
        public String getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return String.valueOf( value );
        }
    }

}
