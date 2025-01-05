package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'grade' enumeration.
 */
// grade https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
@XmlType(name = " grade")
@XmlEnum(String.class)
public enum  GradeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("A") A,
    @XmlEnumValue("B") B,
    @XmlEnumValue("C") C,
    @XmlEnumValue("D") D,
    @XmlEnumValue("A32") A32,
    @XmlEnumValue("D32") D32,
    @XmlEnumValue("E32") E32,
    @XmlEnumValue("F32") F32,
    @XmlEnumValue("A36") A36,
    @XmlEnumValue("D36") D36,
    @XmlEnumValue("E36") E36,
    @XmlEnumValue("F36") F36,
    @XmlEnumValue("A40") A40,
    @XmlEnumValue("D40") D40,
    @XmlEnumValue("E40") E40,
    @XmlEnumValue("F40") F40
;

   public static GradeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "A".equals( value ) ) { return A;}
        if ( "B".equals( value ) ) { return B;}
        if ( "C".equals( value ) ) { return C;}
        if ( "D".equals( value ) ) { return D;}
        if ( "A32".equals( value ) ) { return A32;}
        if ( "D32".equals( value ) ) { return D32;}
        if ( "E32".equals( value ) ) { return E32;}
        if ( "F32".equals( value ) ) { return F32;}
        if ( "A36".equals( value ) ) { return A36;}
        if ( "D36".equals( value ) ) { return D36;}
        if ( "E36".equals( value ) ) { return E36;}
        if ( "F36".equals( value ) ) { return F36;}
        if ( "A40".equals( value ) ) { return A40;}
        if ( "D40".equals( value ) ) { return D40;}
        if ( "E40".equals( value ) ) { return E40;}
        if ( "F40".equals( value ) ) { return F40;}
        return UNKNOWN_VALUE;
   }

}
