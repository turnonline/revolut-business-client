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
 * TransactionLeg
 */
@JsonPropertyOrder( {
        TransactionLeg.JSON_PROPERTY_LEG_ID,
        TransactionLeg.JSON_PROPERTY_AMOUNT,
        TransactionLeg.JSON_PROPERTY_FEE,
        TransactionLeg.JSON_PROPERTY_CURRENCY,
        TransactionLeg.JSON_PROPERTY_BILL_AMOUNT,
        TransactionLeg.JSON_PROPERTY_BILL_CURRENCY,
        TransactionLeg.JSON_PROPERTY_ACCOUNT_ID,
        TransactionLeg.JSON_PROPERTY_COUNTERPARTY,
        TransactionLeg.JSON_PROPERTY_DESCRIPTION,
        TransactionLeg.JSON_PROPERTY_BALANCE
} )
public class TransactionLeg
{
    public static final String JSON_PROPERTY_LEG_ID = "leg_id";

    public static final String JSON_PROPERTY_AMOUNT = "amount";

    public static final String JSON_PROPERTY_FEE = "fee";

    public static final String JSON_PROPERTY_CURRENCY = "currency";

    public static final String JSON_PROPERTY_BILL_AMOUNT = "bill_amount";

    public static final String JSON_PROPERTY_BILL_CURRENCY = "bill_currency";

    public static final String JSON_PROPERTY_ACCOUNT_ID = "account_id";

    public static final String JSON_PROPERTY_COUNTERPARTY = "counterparty";

    public static final String JSON_PROPERTY_DESCRIPTION = "description";

    public static final String JSON_PROPERTY_BALANCE = "balance";

    private UUID legId;

    private Double amount;

    private Double fee;

    private String currency;

    private Double billAmount;

    private String billCurrency;

    private UUID accountId;

    private TransactionCounterparty counterparty;

    private String description;

    private Double balance;

    public TransactionLeg legId( UUID legId )
    {

        this.legId = legId;
        return this;
    }

    /**
     * Get legId
     *
     * @return legId
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_LEG_ID )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )
    public UUID getLegId()
    {
        return legId;
    }

    public void setLegId( UUID legId )
    {
        this.legId = legId;
    }

    public TransactionLeg amount( Double amount )
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

    public TransactionLeg fee( Double fee )
    {

        this.fee = fee;
        return this;
    }

    /**
     * Get fee
     *
     * @return fee
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_FEE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public Double getFee()
    {
        return fee;
    }

    public void setFee( Double fee )
    {
        this.fee = fee;
    }

    public TransactionLeg currency( String currency )
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

    public TransactionLeg billAmount( Double billAmount )
    {

        this.billAmount = billAmount;
        return this;
    }

    /**
     * Get billAmount
     *
     * @return billAmount
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_BILL_AMOUNT )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public Double getBillAmount()
    {
        return billAmount;
    }

    public void setBillAmount( Double billAmount )
    {
        this.billAmount = billAmount;
    }

    public TransactionLeg billCurrency( String billCurrency )
    {

        this.billCurrency = billCurrency;
        return this;
    }

    /**
     * Get billCurrency
     *
     * @return billCurrency
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_BILL_CURRENCY )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public String getBillCurrency()
    {
        return billCurrency;
    }

    public void setBillCurrency( String billCurrency )
    {
        this.billCurrency = billCurrency;
    }

    public TransactionLeg accountId( UUID accountId )
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

    public TransactionLeg counterparty( TransactionCounterparty counterparty )
    {

        this.counterparty = counterparty;
        return this;
    }

    /**
     * Get counterparty
     *
     * @return counterparty
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_COUNTERPARTY )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public TransactionCounterparty getCounterparty()
    {
        return counterparty;
    }

    public void setCounterparty( TransactionCounterparty counterparty )
    {
        this.counterparty = counterparty;
    }

    public TransactionLeg description( String description )
    {

        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_DESCRIPTION )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public TransactionLeg balance( Double balance )
    {

        this.balance = balance;
        return this;
    }

    /**
     * Get balance
     *
     * @return balance
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_BALANCE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public Double getBalance()
    {
        return balance;
    }

    public void setBalance( Double balance )
    {
        this.balance = balance;
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
        TransactionLeg transactionLeg = ( TransactionLeg ) o;
        return Objects.equals( this.legId, transactionLeg.legId ) &&
                Objects.equals( this.amount, transactionLeg.amount ) &&
                Objects.equals( this.fee, transactionLeg.fee ) &&
                Objects.equals( this.currency, transactionLeg.currency ) &&
                Objects.equals( this.billAmount, transactionLeg.billAmount ) &&
                Objects.equals( this.billCurrency, transactionLeg.billCurrency ) &&
                Objects.equals( this.accountId, transactionLeg.accountId ) &&
                Objects.equals( this.counterparty, transactionLeg.counterparty ) &&
                Objects.equals( this.description, transactionLeg.description ) &&
                Objects.equals( this.balance, transactionLeg.balance );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( legId, amount, fee, currency, billAmount, billCurrency, accountId, counterparty, description, balance );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class TransactionLeg {\n" );
        sb.append( "    legId: " ).append( toIndentedString( legId ) ).append( "\n" );
        sb.append( "    amount: " ).append( toIndentedString( amount ) ).append( "\n" );
        sb.append( "    fee: " ).append( toIndentedString( fee ) ).append( "\n" );
        sb.append( "    currency: " ).append( toIndentedString( currency ) ).append( "\n" );
        sb.append( "    billAmount: " ).append( toIndentedString( billAmount ) ).append( "\n" );
        sb.append( "    billCurrency: " ).append( toIndentedString( billCurrency ) ).append( "\n" );
        sb.append( "    accountId: " ).append( toIndentedString( accountId ) ).append( "\n" );
        sb.append( "    counterparty: " ).append( toIndentedString( counterparty ) ).append( "\n" );
        sb.append( "    description: " ).append( toIndentedString( description ) ).append( "\n" );
        sb.append( "    balance: " ).append( toIndentedString( balance ) ).append( "\n" );
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

