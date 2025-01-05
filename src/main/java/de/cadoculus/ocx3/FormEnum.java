package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'formEnum' enumeration.
 */
@XmlType(name = " formEnum")
@XmlEnum(String.class)
public enum  FormEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Unknown") UNKNOWN,
    @XmlEnumValue("Open") OPEN,
    @XmlEnumValue("Closed") CLOSED,
    @XmlEnumValue("Periodic") PERIODIC
;

   public static FormEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Unknown".equals( value ) ) { return UNKNOWN;}
        if ( "Open".equals( value ) ) { return OPEN;}
        if ( "Closed".equals( value ) ) { return CLOSED;}
        if ( "Periodic".equals( value ) ) { return PERIODIC;}
        return UNKNOWN_VALUE;
   }

}
