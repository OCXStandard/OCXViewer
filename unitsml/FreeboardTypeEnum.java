package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'freeboardTypeEnum' enumeration.
 */
@XmlType(name = " freeboardTypeEnum")
@XmlEnum(String.class)
public enum  FreeboardTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("A") A,
    @XmlEnumValue("B") B
;

   public static FreeboardTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "A".equals( value ) ) { return A;}
        if ( "B".equals( value ) ) { return B;}
        return UNKNOWN_VALUE;
   }

}
