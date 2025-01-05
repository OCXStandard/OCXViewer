package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'slotTypeEnum' enumeration.
 */
@XmlType(name = " slotTypeEnum")
@XmlEnum(String.class)
public enum  SlotTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Slit") SLIT,
    @XmlEnumValue("Open") OPEN
;

   public static SlotTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Slit".equals( value ) ) { return SLIT;}
        if ( "Open".equals( value ) ) { return OPEN;}
        return UNKNOWN_VALUE;
   }

}
