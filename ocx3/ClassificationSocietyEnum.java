package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'classificationSociety' enumeration.
 */
// classificationSociety https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
@XmlType(name = " classificationSociety")
@XmlEnum(String.class)
public enum  ClassificationSocietyEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("ABS") ABS,
    @XmlEnumValue("BK") BK,
    @XmlEnumValue("BKR") BKR,
    @XmlEnumValue("BV") BV,
    @XmlEnumValue("CCS") CCS,
    @XmlEnumValue("CR") CR,
    @XmlEnumValue("CRS") CRS,
    @XmlEnumValue("CSC") CSC,
    @XmlEnumValue("CSLPR") CSLPR,
    @XmlEnumValue("DNV") DNV,
    @XmlEnumValue("DSRK") DSRK,
    @XmlEnumValue("FN") FN,
    @XmlEnumValue("GL") GL,
    @XmlEnumValue("HR") HR,
    @XmlEnumValue("IRS") IRS,
    @XmlEnumValue("KR") KR,
    @XmlEnumValue("LR") LR,
    @XmlEnumValue("NK") NK,
    @XmlEnumValue("PRS") PRS,
    @XmlEnumValue("RCB") RCB,
    @XmlEnumValue("RDS") RDS,
    @XmlEnumValue("RINA") RINA,
    @XmlEnumValue("RINAVE") RINAVE,
    @XmlEnumValue("RNR") RNR,
    @XmlEnumValue("RR") RR,
    @XmlEnumValue("RRR") RRR,
    @XmlEnumValue("RS") RS,
    @XmlEnumValue("TL") TL,
    @XmlEnumValue("UR") UR,
    @XmlEnumValue("VL") VL,
    @XmlEnumValue("VR") VR,
    @XmlEnumValue("OTHER") OTHER
;

   public static ClassificationSocietyEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "ABS".equals( value ) ) { return ABS;}
        if ( "BK".equals( value ) ) { return BK;}
        if ( "BKR".equals( value ) ) { return BKR;}
        if ( "BV".equals( value ) ) { return BV;}
        if ( "CCS".equals( value ) ) { return CCS;}
        if ( "CR".equals( value ) ) { return CR;}
        if ( "CRS".equals( value ) ) { return CRS;}
        if ( "CSC".equals( value ) ) { return CSC;}
        if ( "CSLPR".equals( value ) ) { return CSLPR;}
        if ( "DNV".equals( value ) ) { return DNV;}
        if ( "DSRK".equals( value ) ) { return DSRK;}
        if ( "FN".equals( value ) ) { return FN;}
        if ( "GL".equals( value ) ) { return GL;}
        if ( "HR".equals( value ) ) { return HR;}
        if ( "IRS".equals( value ) ) { return IRS;}
        if ( "KR".equals( value ) ) { return KR;}
        if ( "LR".equals( value ) ) { return LR;}
        if ( "NK".equals( value ) ) { return NK;}
        if ( "PRS".equals( value ) ) { return PRS;}
        if ( "RCB".equals( value ) ) { return RCB;}
        if ( "RDS".equals( value ) ) { return RDS;}
        if ( "RINA".equals( value ) ) { return RINA;}
        if ( "RINAVE".equals( value ) ) { return RINAVE;}
        if ( "RNR".equals( value ) ) { return RNR;}
        if ( "RR".equals( value ) ) { return RR;}
        if ( "RRR".equals( value ) ) { return RRR;}
        if ( "RS".equals( value ) ) { return RS;}
        if ( "TL".equals( value ) ) { return TL;}
        if ( "UR".equals( value ) ) { return UR;}
        if ( "VL".equals( value ) ) { return VL;}
        if ( "VR".equals( value ) ) { return VR;}
       if ( "OTHER".equals( value ) ) { return OTHER;}
        return UNKNOWN_VALUE;
   }

}
