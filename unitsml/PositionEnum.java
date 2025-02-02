package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'positionEnum' enumeration.
 */
@XmlType(name = " positionEnum")
@XmlEnum(String.class)
public enum  PositionEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Near side") NEARBLANKSIDE,
    @XmlEnumValue("Far side") FARBLANKSIDE
;

   public static PositionEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Near side".equals( value ) ) { return NEARBLANKSIDE;}
        if ( "Far side".equals( value ) ) { return FARBLANKSIDE;}
        return UNKNOWN_VALUE;
   }

}
