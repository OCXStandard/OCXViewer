package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'reinforcementType' enumeration.
 */
// reinforcementType https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ReinforcementTypeEnum
// ReinforcementTypeEnum


@XmlType(name = " reinforcementType")
@XmlEnum(String.class)
public enum  ReinforcementType {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Flanged") FLANGED,
    @XmlEnumValue("FacePlate") FACEPLATE,
    @XmlEnumValue("BucklingStiffener") BUCKLINGSTIFFENER
;

   public static ReinforcementType parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Flanged".equals( value ) ) { return FLANGED;}
        if ( "FacePlate".equals( value ) ) { return FACEPLATE;}
        if ( "BucklingStiffener".equals( value ) ) { return BUCKLINGSTIFFENER;}
        return UNKNOWN_VALUE;
   }

}
