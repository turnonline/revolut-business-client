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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * EstimatedTime
 */
@JsonPropertyOrder( {
        EstimatedTime.JSON_PROPERTY_UNIT,
        EstimatedTime.JSON_PROPERTY_MIN,
        EstimatedTime.JSON_PROPERTY_MAX
} )
public class EstimatedTime
{
    public static final String JSON_PROPERTY_UNIT = "unit";

    public static final String JSON_PROPERTY_MIN = "min";

    public static final String JSON_PROPERTY_MAX = "max";

    private String unit;

    private Integer min;

    private Integer max;

    public EstimatedTime unit( String unit )
    {

        this.unit = unit;
        return this;
    }

    /**
     * Get unit
     *
     * @return unit
     **/
    @ApiModelProperty( required = true, value = "" )
    @JsonProperty( JSON_PROPERTY_UNIT )
    @JsonInclude( value = JsonInclude.Include.ALWAYS )
    public String getUnit()
    {
        return unit;
    }

    public void setUnit( String unit )
    {
        this.unit = unit;
    }

    public EstimatedTime min( Integer min )
    {

        this.min = min;
        return this;
    }

    /**
     * Get min
     *
     * @return min
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_MIN )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public Integer getMin()
    {
        return min;
    }

    public void setMin( Integer min )
    {
        this.min = min;
    }

    public EstimatedTime max( Integer max )
    {

        this.max = max;
        return this;
    }

    /**
     * Get max
     *
     * @return max
     **/
    @javax.annotation.Nullable
    @ApiModelProperty( value = "" )
    @JsonProperty( JSON_PROPERTY_MAX )
    @JsonInclude( value = JsonInclude.Include.USE_DEFAULTS )
    public Integer getMax()
    {
        return max;
    }

    public void setMax( Integer max )
    {
        this.max = max;
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
        EstimatedTime estimatedTime = ( EstimatedTime ) o;
        return Objects.equals( this.unit, estimatedTime.unit ) &&
                Objects.equals( this.min, estimatedTime.min ) &&
                Objects.equals( this.max, estimatedTime.max );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( unit, min, max );
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "class EstimatedTime {\n" );
        sb.append( "    unit: " ).append( toIndentedString( unit ) ).append( "\n" );
        sb.append( "    min: " ).append( toIndentedString( min ) ).append( "\n" );
        sb.append( "    max: " ).append( toIndentedString( max ) ).append( "\n" );
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

