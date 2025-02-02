package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'freeboardType' enumeration.
 */
// freeboardType https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// FreeboardTypeEnum
// FreeboardTypeEnum


@XmlType(name = " freeboardType")
@XmlEnum(String.class)
public enum  FreeboardType {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("A") A,
    @XmlEnumValue("B") B
;

   public static FreeboardType parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "A".equals( value ) ) { return A;}
        if ( "B".equals( value ) ) { return B;}
        return UNKNOWN_VALUE;
   }

}
