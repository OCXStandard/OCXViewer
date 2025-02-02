package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'unitCargoType' enumeration.
 */
// unitCargoType https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// UnitCargoTypeEnum
// UnitCargoTypeEnum


@XmlType(name = " unitCargoType")
@XmlEnum(String.class)
public enum  UnitCargoType {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("aircraft") AIRCRAFT_LC,
    @XmlEnumValue("boat") BOAT_LC,
    @XmlEnumValue("cable") CABLE_LC,
    @XmlEnumValue("container") CONTAINER_LC,
    @XmlEnumValue("drums") DRUMS_LC,
    @XmlEnumValue("livestock") LIVESTOCK_LC,
    @XmlEnumValue("pallet") PALLET_LC,
    @XmlEnumValue("trailer") TRAILER_LC,
    @XmlEnumValue("vehicle") VEHICLE_LC,
    @XmlEnumValue("unspecified") UNSPECIFIED_LC
;

   public static UnitCargoType parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "aircraft".equals( value ) ) { return AIRCRAFT_LC;}
        if ( "boat".equals( value ) ) { return BOAT_LC;}
        if ( "cable".equals( value ) ) { return CABLE_LC;}
        if ( "container".equals( value ) ) { return CONTAINER_LC;}
        if ( "drums".equals( value ) ) { return DRUMS_LC;}
        if ( "livestock".equals( value ) ) { return LIVESTOCK_LC;}
        if ( "pallet".equals( value ) ) { return PALLET_LC;}
        if ( "trailer".equals( value ) ) { return TRAILER_LC;}
        if ( "vehicle".equals( value ) ) { return VEHICLE_LC;}
        if ( "unspecified".equals( value ) ) { return UNSPECIFIED_LC;}
        return UNKNOWN_VALUE;
   }

}
