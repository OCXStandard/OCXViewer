package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'tightnessEnum' enumeration.
 */
@XmlType(name = " tightnessEnum")
@XmlEnum(String.class)
public enum  TightnessEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("NonTight") NONTIGHT,
    @XmlEnumValue("WaterTight") WATERTIGHT,
    @XmlEnumValue("GasTight") GASTIGHT,
    @XmlEnumValue("Undefined") UNDEFINED
;

   public static TightnessEnum parse(String value) {
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
