package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'geometryFormat' enumeration.
 */
// geometryFormat https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
@XmlType(name = " geometryFormat")
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
