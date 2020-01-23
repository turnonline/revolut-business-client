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


package biz.turnonline.ecosystem.revolut.business.counterparty.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * CreateCounterpartyRequest
 */
@JsonPropertyOrder( {
        CreateCounterpartyRequest.JSON_PROPERTY_COMPANY_NAME,
        CreateCounterpartyRequest.JSON_PROPERTY_PROFILE_TYPE,
        CreateCounterpartyRequest.JSON_PROPERTY_NAME,
        CreateCounterpartyRequest.JSON_PROPERTY_INDIVIDUAL_NAME,
        CreateCounterpartyRequest.JSON_PROPERTY_BANK_COUNTRY,
        CreateCounterpartyRequest.JSON_PROPERTY_CURRENCY,
        CreateCounterpartyRequest.JSON_PROPERTY_EMAIL,
        CreateCounterpartyRequest.JSON_PROPERTY_PHONE,
        CreateCounterpartyRequest.JSON_PROPERTY_ACCOUNT_NO,
        CreateCounterpartyRequest.JSON_PROPERTY_IBAN,
        CreateCounterpartyRequest.JSON_PROPERTY_SORT_CODE,
        CreateCounterpartyRequest.JSON_PROPERTY_ROUTING_NUMBER,
        CreateCounterpartyRequest.JSON_PROPERTY_BIC,
        CreateCounterpartyRequest.JSON_PROPERTY_CLABE,
        CreateCounterpartyRequest.JSON_PROPERTY_ADDRESS
} )
@javax.annotation.Generated( value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-01-23T19:47:41.366+01:00[Europe/Bratislava]" )
public class CreateCounterpartyRequest
{
    public static final String JSON_PROPERTY_COMPANY_NAME = "company_name";

    public static final String JSON_PROPERTY_PROFILE_TYPE = "profile_type";

    public static final String JSON_PROPERTY_NAME = "name";

    public static final String JSON_PROPERTY_INDIVIDUAL_NAME = "individual_name";

    public static final String JSON_PROPERTY_BANK_COUNTRY = "bank_country";

    public static final String JSON_PROPERTY_CURRENCY = "currency";

    public static final String JSON_PROPERTY_EMAIL = "email";

    public static final String JSON_PROPERTY_PHONE = "phone";

    public static final String JSON_PROPERTY_ACCOUNT_NO = "account_no";

    public static final String JSON_PROPERTY_IBAN = "iban";

    public static final String JSON_PROPERTY_SORT_CODE = "sort_code";

    public static final String JSON_PROPERTY_ROUTING_NUMBER = "routing_number";

    public static final String JSON_PROPERTY_BIC = "bic";

    public static final String JSON_PROPERTY_CLABE = "clabe";

    public static final String JSON_PROPERTY_ADDRESS = "address";

    private String companyName;

    private ProfileType profileType;

    private String name;

    private IndividualName individualName;

    private String bankCountry;

    private String currency;

    private String email;

    private String phone;

    private String accountNo;

    private String iban;

    private String sortCode;

    private String routingNumber;

    private String bic;

    private String clabe;

    private BeneficiaryAddress address;


    public CreateCounterpartyRequest companyName( String companyName )
    {

        this.companyName = companyName;
        return this;
    }

    /**
     * Get companyName
     *
     * @return companyName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_COMPANY_NAME )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getCompanyName()
    {
        return companyName;
    }


    public void setCompanyName( String companyName )
    {
        this.companyName = companyName;
    }


    public CreateCounterpartyRequest profileType( ProfileType profileType )
    {

        this.profileType = profileType;
        return this;
    }

    /**
     * Get profileType
     *
     * @return profileType
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_PROFILE_TYPE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public ProfileType getProfileType()
    {
        return profileType;
    }


    public void setProfileType( ProfileType profileType )
    {
        this.profileType = profileType;
    }


    public CreateCounterpartyRequest name( String name )
    {

        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_NAME )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public CreateCounterpartyRequest individualName( IndividualName individualName )
    {

        this.individualName = individualName;
        return this;
    }

    /**
     * Get individualName
     *
     * @return individualName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_INDIVIDUAL_NAME )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public IndividualName getIndividualName()
    {
        return individualName;
    }


    public void setIndividualName( IndividualName individualName )
    {
        this.individualName = individualName;
    }


    public CreateCounterpartyRequest bankCountry( String bankCountry )
    {

        this.bankCountry = bankCountry;
        return this;
    }

    /**
     * Get bankCountry
     *
     * @return bankCountry
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_BANK_COUNTRY )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getBankCountry()
    {
        return bankCountry;
    }


    public void setBankCountry( String bankCountry )
    {
        this.bankCountry = bankCountry;
    }


    public CreateCounterpartyRequest currency( String currency )
    {

        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_CURRENCY )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getCurrency()
    {
        return currency;
    }


    public void setCurrency( String currency )
    {
        this.currency = currency;
    }


    public CreateCounterpartyRequest email( String email )
    {

        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_EMAIL )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getEmail()
    {
        return email;
    }


    public void setEmail( String email )
    {
        this.email = email;
    }


    public CreateCounterpartyRequest phone( String phone )
    {

        this.phone = phone;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_PHONE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getPhone()
    {
        return phone;
    }


    public void setPhone( String phone )
    {
        this.phone = phone;
    }


    public CreateCounterpartyRequest accountNo( String accountNo )
    {

        this.accountNo = accountNo;
        return this;
    }

    /**
     * Get accountNo
     *
     * @return accountNo
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_ACCOUNT_NO )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getAccountNo()
    {
        return accountNo;
    }


    public void setAccountNo( String accountNo )
    {
        this.accountNo = accountNo;
    }


    public CreateCounterpartyRequest iban( String iban )
    {

        this.iban = iban;
        return this;
    }

    /**
     * Get iban
     *
     * @return iban
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_IBAN )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getIban()
    {
        return iban;
    }


    public void setIban( String iban )
    {
        this.iban = iban;
    }


    public CreateCounterpartyRequest sortCode( String sortCode )
    {

        this.sortCode = sortCode;
        return this;
    }

    /**
     * Get sortCode
     *
     * @return sortCode
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_SORT_CODE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getSortCode()
    {
        return sortCode;
    }


    public void setSortCode( String sortCode )
    {
        this.sortCode = sortCode;
    }


    public CreateCounterpartyRequest routingNumber( String routingNumber )
    {

        this.routingNumber = routingNumber;
        return this;
    }

    /**
     * Get routingNumber
     *
     * @return routingNumber
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_ROUTING_NUMBER )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getRoutingNumber()
    {
        return routingNumber;
    }


    public void setRoutingNumber( String routingNumber )
    {
        this.routingNumber = routingNumber;
    }


    public CreateCounterpartyRequest bic( String bic )
    {

        this.bic = bic;
        return this;
    }

    /**
     * Get bic
     *
     * @return bic
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_BIC )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getBic()
    {
        return bic;
    }


    public void setBic( String bic )
    {
        this.bic = bic;
    }


    public CreateCounterpartyRequest clabe( String clabe )
    {

        this.clabe = clabe;
        return this;
    }

    /**
     * Get clabe
     *
     * @return clabe
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_CLABE )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public String getClabe()
    {
        return clabe;
    }


    public void setClabe( String clabe )
    {
        this.clabe = clabe;
    }


    public CreateCounterpartyRequest address( BeneficiaryAddress address )
    {

        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_ADDRESS )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )

    public BeneficiaryAddress getAddress()
    {
        return address;
    }


    public void setAddress( BeneficiaryAddress address )
    {
        this.address = address;
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
        CreateCounterpartyRequest createCounterpartyRequest = ( CreateCounterpartyRequest ) o;
        return Objects.equals( this.companyName, createCounterpartyRequest.companyName ) &&
                Objects.equals( this.profileType, createCounterpartyRequest.profileType ) &&
                Objects.equals( this.name, createCounterpartyRequest.name ) &&
                Objects.equals( this.individualName, createCounterpartyRequest.individualName ) &&
                Objects.equals( this.bankCountry, createCounterpartyRequest.bankCountry ) &&
                Objects.equals( this.currency, createCounterpartyRequest.currency ) &&
                Objects.equals( this.email, createCounterpartyRequest.email ) &&
                Objects.equals( this.phone, createCounterpartyRequest.phone ) &&
                Objects.equals( this.accountNo, createCounterpartyRequest.accountNo ) &&
                Objects.equals( this.iban, createCounterpartyRequest.iban ) &&
                Objects.equals( this.sortCode, createCounterpartyRequest.sortCode ) &&
                Objects.equals( this.routingNumber, createCounterpartyRequest.routingNumber ) &&
                Objects.equals( this.bic, createCounterpartyRequest.bic ) &&
                Objects.equals( this.clabe, createCounterpartyRequest.clabe ) &&
                Objects.equals( this.address, createCounterpartyRequest.address );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( companyName, profileType, name, individualName, bankCountry, currency, email, phone, accountNo, iban, sortCode, routingNumber, bic, clabe, address );
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class CreateCounterpartyRequest {\n" );
        sb.append( "    companyName: " ).append( toIndentedString( companyName ) ).append( "\n" );
        sb.append( "    profileType: " ).append( toIndentedString( profileType ) ).append( "\n" );
        sb.append( "    name: " ).append( toIndentedString( name ) ).append( "\n" );
        sb.append( "    individualName: " ).append( toIndentedString( individualName ) ).append( "\n" );
        sb.append( "    bankCountry: " ).append( toIndentedString( bankCountry ) ).append( "\n" );
        sb.append( "    currency: " ).append( toIndentedString( currency ) ).append( "\n" );
        sb.append( "    email: " ).append( toIndentedString( email ) ).append( "\n" );
        sb.append( "    phone: " ).append( toIndentedString( phone ) ).append( "\n" );
        sb.append( "    accountNo: " ).append( toIndentedString( accountNo ) ).append( "\n" );
        sb.append( "    iban: " ).append( toIndentedString( iban ) ).append( "\n" );
        sb.append( "    sortCode: " ).append( toIndentedString( sortCode ) ).append( "\n" );
        sb.append( "    routingNumber: " ).append( toIndentedString( routingNumber ) ).append( "\n" );
        sb.append( "    bic: " ).append( toIndentedString( bic ) ).append( "\n" );
        sb.append( "    clabe: " ).append( toIndentedString( clabe ) ).append( "\n" );
        sb.append( "    address: " ).append( toIndentedString( address ) ).append( "\n" );
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

