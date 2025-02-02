package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'bulkCargoType' enumeration.
 */
// bulkCargoType https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
@XmlType(name = " bulkCargoType")
@XmlEnum(String.class)
public enum  BulkCargoTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("cement") CEMENT_LC,
    @XmlEnumValue("coal") COAL_LC,
    @XmlEnumValue("fish") FISH_LC,
    @XmlEnumValue("general") GENERAL_LC,
    @XmlEnumValue("grain") GRAIN_LC,
    @XmlEnumValue("mud") MUD_LC,
    @XmlEnumValue("ore") ORE_LC,
    @XmlEnumValue("sugar") SUGAR_LC,
    @XmlEnumValue("timber") TIMBER_LC,
    @XmlEnumValue("unspecified") UNSPECIFIED_LC
;

   public static BulkCargoTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "cement".equals( value ) ) { return CEMENT_LC;}
        if ( "coal".equals( value ) ) { return COAL_LC;}
        if ( "fish".equals( value ) ) { return FISH_LC;}
        if ( "general".equals( value ) ) { return GENERAL_LC;}
        if ( "grain".equals( value ) ) { return GRAIN_LC;}
        if ( "mud".equals( value ) ) { return MUD_LC;}
        if ( "ore".equals( value ) ) { return ORE_LC;}
        if ( "sugar".equals( value ) ) { return SUGAR_LC;}
        if ( "timber".equals( value ) ) { return TIMBER_LC;}
        if ( "unspecified".equals( value ) ) { return UNSPECIFIED_LC;}
        return UNKNOWN_VALUE;
   }

}
