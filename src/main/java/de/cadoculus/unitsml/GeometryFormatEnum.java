package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'geometryFormatEnum' enumeration.
 */
@XmlType(name = " geometryFormatEnum")
@XmlEnum(String.class)
public enum  GeometryFormatEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue(".igs") DOTIGS,
    @XmlEnumValue(".jt") DOTJT,
    @XmlEnumValue(".stp") DOTSTP
;

   public static GeometryFormatEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( ".igs".equals( value ) ) { return DOTIGS;}
        if ( ".jt".equals( value ) ) { return DOTJT;}
        if ( ".stp".equals( value ) ) { return DOTSTP;}
        return UNKNOWN_VALUE;
   }

}
