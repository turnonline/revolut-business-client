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
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets PaymentSystem
 */
public enum PaymentSystem
{

    CHAPS( "chaps" ),

    BACS( "bacs" ),

    FASTER_PAYMENTS( "faster_payments" ),

    SEPA( "sepa" ),

    SWIFT( "swift" ),

    ACH( "ach" ),

    ELIXIR( "elixir" ),

    SORBNET( "sorbnet" ),

    NICS( "nics" ),

    RIX( "rix" ),

    SUMCLEARING( "sumclearing" );

    private String value;

    PaymentSystem( String value )
    {
        this.value = value;
    }

    @JsonCreator
    public static PaymentSystem fromValue( String value )
    {
        for ( PaymentSystem b : PaymentSystem.values() )
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

