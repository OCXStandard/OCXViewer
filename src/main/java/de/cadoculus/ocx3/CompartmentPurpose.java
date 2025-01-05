package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'compartmentPurpose' enumeration.
 */
// compartmentPurpose https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// CompartmentPurposeEnum
// CompartmentPurposeEnum


@XmlType(name = " compartmentPurpose")
@XmlEnum(String.class)
public enum  CompartmentPurpose {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("Cargo") CARGO,
    @XmlEnumValue("Ballast") BALLAST,
    @XmlEnumValue("Freshwater") FRESHWATER,
    @XmlEnumValue("Fuel") FUEL,
    @XmlEnumValue("Machinery") MACHINERY,
    @XmlEnumValue("Void") VOID,
    @XmlEnumValue("Other") OTHER,
    @XmlEnumValue("Lube") LUBE,
    @XmlEnumValue("Passageway") PASSAGEWAY,
    @XmlEnumValue("Access") ACCESS,
    @XmlEnumValue("Miscellaneous") MISCELLANEOUS
;

   public static CompartmentPurpose parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "Cargo".equals( value ) ) { return CARGO;}
        if ( "Ballast".equals( value ) ) { return BALLAST;}
        if ( "Freshwater".equals( value ) ) { return FRESHWATER;}
        if ( "Fuel".equals( value ) ) { return FUEL;}
        if ( "Machinery".equals( value ) ) { return MACHINERY;}
        if ( "Void".equals( value ) ) { return VOID;}
        if ( "Other".equals( value ) ) { return OTHER;}
        if ( "Lube".equals( value ) ) { return LUBE;}
        if ( "Passageway".equals( value ) ) { return PASSAGEWAY;}
        if ( "Access".equals( value ) ) { return ACCESS;}
        if ( "Miscellaneous".equals( value ) ) { return MISCELLANEOUS;}
        return UNKNOWN_VALUE;
   }

}
