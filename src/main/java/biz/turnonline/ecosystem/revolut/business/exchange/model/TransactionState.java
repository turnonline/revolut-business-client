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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TransactionState
 */
public enum TransactionState
{
    CREATED( "created" ),

    PENDING( "pending" ),

    COMPLETED( "completed" ),

    DECLINED( "declined" ),

    FAILED( "failed" ),

    REVERTED( "reverted" );

    private String value;

    TransactionState( String value )
    {
        this.value = value;
    }

    @JsonCreator
    public static TransactionState fromValue( String value )
    {
        for ( TransactionState b : TransactionState.values() )
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

