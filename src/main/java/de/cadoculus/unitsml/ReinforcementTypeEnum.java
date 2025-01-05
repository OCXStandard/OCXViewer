package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'reinforcementTypeEnum' enumeration.
 */
@XmlType(name = " reinforcementTypeEnum")
@XmlEnum(String.class)
public enum  ReinforcementTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Flanged") FLANGED,
    @XmlEnumValue("FacePlate") FACEPLATE,
    @XmlEnumValue("BucklingStiffener") BUCKLINGSTIFFENER
;

   public static ReinforcementTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Flanged".equals( value ) ) { return FLANGED;}
        if ( "FacePlate".equals( value ) ) { return FACEPLATE;}
        if ( "BucklingStiffener".equals( value ) ) { return BUCKLINGSTIFFENER;}
        return UNKNOWN_VALUE;
   }

}
