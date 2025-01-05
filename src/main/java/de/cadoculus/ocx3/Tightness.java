package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'tightness' enumeration.
 */
// tightness https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// TightnessEnum
// TightnessEnum


@XmlType(name = " tightness")
@XmlEnum(String.class)
public enum  Tightness {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("NonTight") NONTIGHT,
    @XmlEnumValue("WaterTight") WATERTIGHT,
    @XmlEnumValue("GasTight") GASTIGHT,
    @XmlEnumValue("Undefined") UNDEFINED
;

   public static Tightness parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "NonTight".equals( value ) ) { return NONTIGHT;}
        if ( "WaterTight".equals( value ) ) { return WATERTIGHT;}
        if ( "GasTight".equals( value ) ) { return GASTIGHT;}
        if ( "Undefined".equals( value ) ) { return UNDEFINED;}
        return UNKNOWN_VALUE;
   }

}
