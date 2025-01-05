package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'refType' enumeration.
 */
// refType https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
@XmlType(name = " refType")
@XmlEnum(String.class)
public enum  RefTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("ocx:Panel") OCXCOLONPANEL_LC,
    @XmlEnumValue("ocx:Plate") OCXCOLONPLATE_LC,
    @XmlEnumValue("ocx:Seam") OCXCOLONSEAM_LC,
    @XmlEnumValue("ocx:Bracket") OCXCOLONBRACKET_LC,
    @XmlEnumValue("ocx:Stiffener") OCXCOLONSTIFFENER_LC,
    @XmlEnumValue("ocx:Pillar") OCXCOLONPILLAR_LC,
    @XmlEnumValue("ocx:ConnectionConfiguration") OCXCOLONCONNECTIONCONFIGURATION_LC,
    @XmlEnumValue("ocx:Hole2D") OCXCOLONHOLE2D_LC,
    @XmlEnumValue("ocx:Material") OCXCOLONMATERIAL_LC,
    @XmlEnumValue("ocx:BarSection") OCXCOLONBARSECTION_LC,
    @XmlEnumValue("ocx:Cell") OCXCOLONCELL_LC,
    @XmlEnumValue("ocx:Vessel") OCXCOLONVESSEL_LC,
    @XmlEnumValue("ocx:FreeEdgeCurve3D") OCXCOLONFREEEDGECURVE3D_LC,
    @XmlEnumValue("ocx:Surface") OCXCOLONSURFACE_LC,
    @XmlEnumValue("ocx:EndCut") OCXCOLONENDCUT_LC,
    @XmlEnumValue("ocx:OccurrenceGroup") OCXCOLONOCCURRENCEGROUP_LC,
    @XmlEnumValue("ocx:EdgeReinforcement") OCXCOLONEDGEREINFORCEMENT_LC,
    @XmlEnumValue("ocx:Hole2DContour") OCXCOLONHOLE2DCONTOUR_LC,
    @XmlEnumValue("ocx:ReferencePlane") OCXCOLONREFERENCEPLANE_LC
;

   public static RefTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "ocx:Panel".equals( value ) ) { return OCXCOLONPANEL_LC;}
        if ( "ocx:Plate".equals( value ) ) { return OCXCOLONPLATE_LC;}
        if ( "ocx:Seam".equals( value ) ) { return OCXCOLONSEAM_LC;}
        if ( "ocx:Bracket".equals( value ) ) { return OCXCOLONBRACKET_LC;}
        if ( "ocx:Stiffener".equals( value ) ) { return OCXCOLONSTIFFENER_LC;}
        if ( "ocx:Pillar".equals( value ) ) { return OCXCOLONPILLAR_LC;}
        if ( "ocx:ConnectionConfiguration".equals( value ) ) { return OCXCOLONCONNECTIONCONFIGURATION_LC;}
        if ( "ocx:Hole2D".equals( value ) ) { return OCXCOLONHOLE2D_LC;}
        if ( "ocx:Material".equals( value ) ) { return OCXCOLONMATERIAL_LC;}
        if ( "ocx:BarSection".equals( value ) ) { return OCXCOLONBARSECTION_LC;}
        if ( "ocx:Cell".equals( value ) ) { return OCXCOLONCELL_LC;}
        if ( "ocx:Vessel".equals( value ) ) { return OCXCOLONVESSEL_LC;}
        if ( "ocx:FreeEdgeCurve3D".equals( value ) ) { return OCXCOLONFREEEDGECURVE3D_LC;}
        if ( "ocx:Surface".equals( value ) ) { return OCXCOLONSURFACE_LC;}
        if ( "ocx:EndCut".equals( value ) ) { return OCXCOLONENDCUT_LC;}
        if ( "ocx:OccurrenceGroup".equals( value ) ) { return OCXCOLONOCCURRENCEGROUP_LC;}
        if ( "ocx:EdgeReinforcement".equals( value ) ) { return OCXCOLONEDGEREINFORCEMENT_LC;}
        if ( "ocx:Hole2DContour".equals( value ) ) { return OCXCOLONHOLE2DCONTOUR_LC;}
        if ( "ocx:ReferencePlane".equals( value ) ) { return OCXCOLONREFERENCEPLANE_LC;}
        return UNKNOWN_VALUE;
   }

}
