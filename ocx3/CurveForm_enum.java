package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'curveForm_enum' enumeration.
 */
// curveForm_enum https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// CurveFormEnumEnum
// CurveForm_enumEnum


@XmlType(name = " curveForm_enum")
@XmlEnum(String.class)
public enum  CurveForm_enum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Unknown") UNKNOWN,
    @XmlEnumValue("Open") OPEN,
    @XmlEnumValue("Closed") CLOSED,
    @XmlEnumValue("Periodic") PERIODIC
;

   public static CurveForm_enum parse(String value) {
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
