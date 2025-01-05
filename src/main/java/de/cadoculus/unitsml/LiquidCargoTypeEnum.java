package de.cadoculus.unitsml;
import jakarta.xml.bind.annotation.*;
/**
 * The 'liquidCargoTypeEnum' enumeration.
 */
@XmlType(name = " liquidCargoTypeEnum")
@XmlEnum(String.class)
public enum  LiquidCargoTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("alcohol") ALCOHOL_LC,
    @XmlEnumValue("ammonia") AMMONIA_LC,
    @XmlEnumValue("asphalt") ASPHALT_LC,
    @XmlEnumValue("aviation oil") AVIATIONBLANKOIL_LC,
    @XmlEnumValue("caustic soda") CAUSTICBLANKSODA_LC,
    @XmlEnumValue("cement") CEMENT_LC,
    @XmlEnumValue("chemical") CHEMICAL_LC,
    @XmlEnumValue("crude oil") CRUDEBLANKOIL_LC,
    @XmlEnumValue("edible oil") EDIBLEBLANKOIL_LC,
    @XmlEnumValue("fuel oil") FUELBLANKOIL_LC,
    @XmlEnumValue("fresh water") FRESHBLANKWATER_LC,
    @XmlEnumValue("hydrochloride acid") HYDROCHLORIDEBLANKACID_LC,
    @XmlEnumValue("lubricating oil") LUBRICATINGBLANKOIL_LC,
    @XmlEnumValue("methanol") METHANOL_LC,
    @XmlEnumValue("molasses") MOLASSES_LC,
    @XmlEnumValue("product oil") PRODUCTBLANKOIL_LC,
    @XmlEnumValue("salt water") SALTBLANKWATER_LC,
    @XmlEnumValue("sullage") SULLAGE_LC,
    @XmlEnumValue("sludge") SLUDGE_LC,
    @XmlEnumValue("sulphur") SULPHUR_LC,
    @XmlEnumValue("vegetable oil") VEGETABLEBLANKOIL_LC,
    @XmlEnumValue("water ballast") WATERBLANKBALLAST_LC,
    @XmlEnumValue("wine") WINE_LC,
    @XmlEnumValue("unspecified") UNSPECIFIED_LC
;

   public static LiquidCargoTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "alcohol".equals( value ) ) { return ALCOHOL_LC;}
        if ( "ammonia".equals( value ) ) { return AMMONIA_LC;}
        if ( "asphalt".equals( value ) ) { return ASPHALT_LC;}
        if ( "aviation oil".equals( value ) ) { return AVIATIONBLANKOIL_LC;}
        if ( "caustic soda".equals( value ) ) { return CAUSTICBLANKSODA_LC;}
        if ( "cement".equals( value ) ) { return CEMENT_LC;}
        if ( "chemical".equals( value ) ) { return CHEMICAL_LC;}
        if ( "crude oil".equals( value ) ) { return CRUDEBLANKOIL_LC;}
        if ( "edible oil".equals( value ) ) { return EDIBLEBLANKOIL_LC;}
        if ( "fuel oil".equals( value ) ) { return FUELBLANKOIL_LC;}
        if ( "fresh water".equals( value ) ) { return FRESHBLANKWATER_LC;}
        if ( "hydrochloride acid".equals( value ) ) { return HYDROCHLORIDEBLANKACID_LC;}
        if ( "lubricating oil".equals( value ) ) { return LUBRICATINGBLANKOIL_LC;}
        if ( "methanol".equals( value ) ) { return METHANOL_LC;}
        if ( "molasses".equals( value ) ) { return MOLASSES_LC;}
        if ( "product oil".equals( value ) ) { return PRODUCTBLANKOIL_LC;}
        if ( "salt water".equals( value ) ) { return SALTBLANKWATER_LC;}
        if ( "sullage".equals( value ) ) { return SULLAGE_LC;}
        if ( "sludge".equals( value ) ) { return SLUDGE_LC;}
        if ( "sulphur".equals( value ) ) { return SULPHUR_LC;}
        if ( "vegetable oil".equals( value ) ) { return VEGETABLEBLANKOIL_LC;}
        if ( "water ballast".equals( value ) ) { return WATERBLANKBALLAST_LC;}
        if ( "wine".equals( value ) ) { return WINE_LC;}
        if ( "unspecified".equals( value ) ) { return UNSPECIFIED_LC;}
        return UNKNOWN_VALUE;
   }

}
