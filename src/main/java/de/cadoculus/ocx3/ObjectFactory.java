
package de.cadoculus.ocx3;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;


// objectFactoryJava.ftl
/**
* This object contains factory methods for each
* Java content interface and Java element interface
* generated in the com.prostep.opdm.ship.ocx  package.
* <p>An ObjectFactory allows you to programatically
* construct new instances of the Java representation
* for XML content. The Java representation of XML
* content can consist of schema derived interfaces
* and classes representing the binding of schema
* type definitions, element declarations and model
* groups.  Factory methods for each of these are
* provided in this class.
*/
@XmlRegistry
public class ObjectFactory {

    private final static QName _Header_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Header");
    private final static QName _OcxXML_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ocxXML");
    private final static QName _ApplicationRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ApplicationRef");
    private final static QName _ExternalGeometryRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ExternalGeometryRef");
    private final static QName _MaterialRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MaterialRef");
    private final static QName _SectionRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SectionRef");
    private final static QName _HoleContourRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "HoleContourRef");
    private final static QName _HoleRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "HoleRef");
    private final static QName _PlateMaterial_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PlateMaterial");
    private final static QName _GridRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "GridRef");
    private final static QName _EdgeCurveRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EdgeCurveRef");
    private final static QName _SurfaceRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SurfaceRef");
    private final static QName _SeamRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SeamRef");
    private final static QName _PanelRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PanelRef");
    private final static QName _StiffenerRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "StiffenerRef");
    private final static QName _PlateRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PlateRef");
    private final static QName _BracketRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BracketRef");
    private final static QName _LugPlateRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LugPlateRef");
    private final static QName _PillarRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PillarRef");
    private final static QName _EdgeReinforcementRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EdgeReinforcementRef");
    private final static QName _EndCutRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EndCutRef");
    private final static QName _VesselRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "VesselRef");
    private final static QName _ConnectionConfigurationRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ConnectionConfigurationRef");
    private final static QName _CellRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CellRef");
    private final static QName _OccurrenceGroup_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "OccurrenceGroup");
    private final static QName _DesignView_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DesignView");
    private final static QName _Occurrence_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Occurrence");
    private final static QName _Equipments_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Equipments");
    private final static QName _Equipment_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Equipment");
    private final static QName _Vessel_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Vessel");
    private final static QName _Seam_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Seam");
    private final static QName _Stiffener_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Stiffener");
    private final static QName _Inclination_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Inclination");
    private final static QName _TraceLine_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "TraceLine");
    private final static QName _EdgeReinforcement_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EdgeReinforcement");
    private final static QName _Pillar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Pillar");
    private final static QName _Panel_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Panel");
    private final static QName _ComposedOf_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ComposedOf");
    private final static QName _Plate_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Plate");
    private final static QName _Bracket_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Bracket");
    private final static QName _LimitedBy_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LimitedBy");
    private final static QName _Hole2DContour_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Hole2DContour");
    private final static QName _ConnectionConfiguration_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ConnectionConfiguration");
    private final static QName _Penetration_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Penetration");
    private final static QName _BracketParameters_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BracketParameters");
    private final static QName _FlangeEdgeReinforcement_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlangeEdgeReinforcement");
    private final static QName _FeatureCope_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FeatureCope");
    private final static QName _EndCutEnd1_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EndCutEnd1");
    private final static QName _EndCutEnd2_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EndCutEnd2");
    private final static QName _ConnectedBracketRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ConnectedBracketRef");
    private final static QName _SingleBracket_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SingleBracket");
    private final static QName _DoubleBracket_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DoubleBracket");
    private final static QName _WebStiffenerRef_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebStiffenerRef");
    private final static QName _WebStiffener_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebStiffener");
    private final static QName _WebStiffenerWithSingleBracket_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebStiffenerWithSingleBracket");
    private final static QName _WebStiffenerWithDoubleBracket_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebStiffenerWithDoubleBracket");
    private final static QName _SlotParameters_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SlotParameters");
    private final static QName _ConnectionLength_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ConnectionLength");
    private final static QName _SlotContour_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SlotContour");
    private final static QName _PhysicalProperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PhysicalProperties");
    private final static QName _CutBy_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CutBy");
    private final static QName _PlateCutBy_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PlateCutBy");
    private final static QName _StiffenedBy_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "StiffenedBy");
    private final static QName _SplitBy_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SplitBy");
    private final static QName _PhysicalSpace_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PhysicalSpace");
    private final static QName _Arrangement_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Arrangement");
    private final static QName _Compartment_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Compartment");
    private final static QName _CompartmentFace_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CompartmentFace");
    private final static QName _Cell_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Cell");
    private final static QName _CellBoundary_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CellBoundary");
    private final static QName _CrossFlow_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CrossFlow");
    private final static QName _CompartmentProperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CompartmentProperties");
    private final static QName _BulkCargo_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulkCargo");
    private final static QName _UnitCargo_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UnitCargo");
    private final static QName _LiquidCargo_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LiquidCargo");
    private final static QName _GaseousCargo_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "GaseousCargo");
    private final static QName _CellConnection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CellConnection");
    private final static QName _CarriagePressure_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CarriagePressure");
    private final static QName _Volume_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Volume");
    private final static QName _AirPipeHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "AirPipeHeight");
    private final static QName _CenterOfGravity_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CenterOfGravity");
    private final static QName _StowageHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "StowageHeight");
    private final static QName _ReliefValvePressure_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ReliefValvePressure");
    private final static QName _FillingHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FillingHeight");
    private final static QName _StowageFactor_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "StowageFactor");
    private final static QName _Permeability_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Permeability");
    private final static QName _AngleOfRepose_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "AngleOfRepose");
    private final static QName _ReferenceSurfaces_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ReferenceSurfaces");
    private final static QName _Cylinder3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Cylinder3D");
    private final static QName _Cone3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Cone3D");
    private final static QName _Sphere3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Sphere3D");
    private final static QName _ExtrudedSurface_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ExtrudedSurface");
    private final static QName _Sweep_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Sweep");
    private final static QName _SweepCurve_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SweepCurve");
    private final static QName _BaseCurve_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BaseCurve");
    private final static QName _NURBSSurface_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NURBSSurface");
    private final static QName _Plane3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Plane3D");
    private final static QName _UnboundedGeometry_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UnboundedGeometry");
    private final static QName _SurfaceCollection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SurfaceCollection");
    private final static QName _Tip_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Tip");
    private final static QName _BaseRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BaseRadius");
    private final static QName _TipRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "TipRadius");
    private final static QName _Circle3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Circle3D");
    private final static QName _Ellipse3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Ellipse3D");
    private final static QName _CircumCircle3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CircumCircle3D");
    private final static QName _PolyLine3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PolyLine3D");
    private final static QName _Line3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Line3D");
    private final static QName _CompositeCurve3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CompositeCurve3D");
    private final static QName _NURBS3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NURBS3D");
    private final static QName _CircumArc3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CircumArc3D");
    private final static QName _OuterContour_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "OuterContour");
    private final static QName _InnerContour_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "InnerContour");
    private final static QName _FreeEdgeCurve3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FreeEdgeCurve3D");
    private final static QName _FaceBoundaryCurve_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FaceBoundaryCurve");
    private final static QName _NURBSproperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NURBSproperties");
    private final static QName _VNURBSproperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "V_NURBSproperties");
    private final static QName _UNURBSproperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "U_NURBSproperties");
    private final static QName _KnotVector_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "KnotVector");
    private final static QName _UknotVector_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UknotVector");
    private final static QName _VknotVector_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "VknotVector");
    private final static QName _ControlPoint_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ControlPoint");
    private final static QName _ControlPtList_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ControlPtList");
    private final static QName _CurveLength_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CurveLength");
    private final static QName _SweepLength_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SweepLength");
    private final static QName _CoordinateSystem_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CoordinateSystem");
    private final static QName _LocalCartesian_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LocalCartesian");
    private final static QName _XRefPlanes_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "XRefPlanes");
    private final static QName _YRefPlanes_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "YRefPlanes");
    private final static QName _ZRefPlanes_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ZRefPlanes");
    private final static QName _CylindricalAxes_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CylindricalAxes");
    private final static QName _RadialCylinder_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RadialCylinder");
    private final static QName _Transformation_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Transformation");
    private final static QName _RefPlane_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RefPlane");
    private final static QName _DistanceToAP_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DistanceToAP");
    private final static QName _MajorAxis_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MajorAxis");
    private final static QName _MinorAxis_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MinorAxis");
    private final static QName _Vector3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Vector3D");
    private final static QName _SecondaryAxis_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SecondaryAxis");
    private final static QName _PrimaryAxis_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PrimaryAxis");
    private final static QName _Origin_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Origin");
    private final static QName _Center_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Center");
    private final static QName _Normal_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Normal");
    private final static QName _Point3D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Point3D");
    private final static QName _X_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "X");
    private final static QName _Y_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Y");
    private final static QName _Z_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Z");
    private final static QName _ContourBounds_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ContourBounds");
    private final static QName _ContourStart_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ContourStart");
    private final static QName _ContourEnd_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ContourEnd");
    private final static QName _ClassCatalogue_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ClassCatalogue");
    private final static QName _MaterialCatalogue_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MaterialCatalogue");
    private final static QName _XSectionCatalogue_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "XSectionCatalogue");
    private final static QName _PrincipalParticulars_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PrincipalParticulars");
    private final static QName _HoleShapeCatalogue_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "HoleShapeCatalogue");
    private final static QName _Hole2D_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Hole2D");
    private final static QName _ParametricCircle_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ParametricCircle");
    private final static QName _SymmetricalHole_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SymmetricalHole");
    private final static QName _SuperElliptical_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SuperElliptical");
    private final static QName _RectangularHole_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RectangularHole");
    private final static QName _RectangularMickeyMouseEars_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RectangularMickeyMouseEars");
    private final static QName _Material_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Material");
    private final static QName _BarSection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BarSection");
    private final static QName _BulbFlat_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulbFlat");
    private final static QName _FlatBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlatBar");
    private final static QName _LBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LBar");
    private final static QName _LBarOW_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LBarOW");
    private final static QName _LBarOF_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LBarOF");
    private final static QName _TBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "TBar");
    private final static QName _UBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UBar");
    private final static QName _IBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "IBar");
    private final static QName _ZBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ZBar");
    private final static QName _RoundBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RoundBar");
    private final static QName _HalfRoundBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "HalfRoundBar");
    private final static QName _SquareBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SquareBar");
    private final static QName _HexagonBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "HexagonBar");
    private final static QName _OctagonBar_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "OctagonBar");
    private final static QName _Tube_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Tube");
    private final static QName _RectangularTube_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RectangularTube");
    private final static QName _UserDefinedBarSection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UserDefinedBarSection");
    private final static QName _SectionProperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SectionProperties");
    private final static QName _UserDefinedParameter_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UserDefinedParameter");
    private final static QName _BuilderInformation_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BuilderInformation");
    private final static QName _ShipDesignation_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ShipDesignation");
    private final static QName _DistanceTolerance_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DistanceTolerance");
    private final static QName _AngleTolerance_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "AngleTolerance");
    private final static QName _TonnageData_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "TonnageData");
    private final static QName _StatutoryData_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "StatutoryData");
    private final static QName _ClassificationData_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ClassificationData");
    private final static QName _ClassNotation_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ClassNotation");
    private final static QName _Radius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Radius");
    private final static QName _NetArea_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NetArea");
    private final static QName _Area_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Area");
    private final static QName _ArmLengthU_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ArmLengthU");
    private final static QName _ArmLengthV_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ArmLengthV");
    private final static QName _Unose_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Unose");
    private final static QName _Vnose_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Vnose");
    private final static QName _FreeEdgeRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FreeEdgeRadius");
    private final static QName _CopeHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CopeHeight");
    private final static QName _CopeRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CopeRadius");
    private final static QName _FlangeCutBackAngle_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlangeCutBackAngle");
    private final static QName _WebCutBackAngle_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebCutBackAngle");
    private final static QName _FlangeNoseHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlangeNoseHeight");
    private final static QName _WebNoseHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebNoseHeight");
    private final static QName _CutbackDistance_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CutbackDistance");
    private final static QName _CopeLength_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CopeLength");
    private final static QName _DryWeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DryWeight");
    private final static QName _UpperRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UpperRadius");
    private final static QName _LowerRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LowerRadius");
    private final static QName _Tonnage_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Tonnage");
    private final static QName _Width_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Width");
    private final static QName _Height_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Height");
    private final static QName _Thickness_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Thickness");
    private final static QName _DeadWeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DeadWeight");
    private final static QName _WebThickness_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebThickness");
    private final static QName _FlangeWidth_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlangeWidth");
    private final static QName _BulbAngle_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulbAngle");
    private final static QName _BulbOuterRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulbOuterRadius");
    private final static QName _BulbInnerRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulbInnerRadius");
    private final static QName _BulbTopRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulbTopRadius");
    private final static QName _BulbBottomRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BulbBottomRadius");
    private final static QName _FilletRadius_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FilletRadius");
    private final static QName _Diameter_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Diameter");
    private final static QName _Contour_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Contour");
    private final static QName _Lpp_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Lpp");
    private final static QName _RuleLength_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "RuleLength");
    private final static QName _BlockCoefficient_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "BlockCoefficient");
    private final static QName _FPPos_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FP_Pos");
    private final static QName _MouldedBreadth_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MouldedBreadth");
    private final static QName _MouldedDepth_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MouldedDepth");
    private final static QName _ScantlingDraught_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ScantlingDraught");
    private final static QName _DesignSpeed_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DesignSpeed");
    private final static QName _FreeboardLength_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FreeboardLength");
    private final static QName _NormalBallastDraught_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NormalBallastDraught");
    private final static QName _HeavyBallastDraught_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "HeavyBallastDraught");
    private final static QName _SlammingDraughtEmptyFP_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SlammingDraughtEmptyFP");
    private final static QName _SlammingDraughtFullFP_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SlammingDraughtFullFP");
    private final static QName _LengthOfWaterline_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "LengthOfWaterline");
    private final static QName _FreeboardDeckHeight_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FreeboardDeckHeight");
    private final static QName _APPos_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "AP_Pos");
    private final static QName _ZPosOfDeck_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ZPosOfDeck");
    private final static QName _DeepestEquilibriumWL_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DeepestEquilibriumWL");
    private final static QName _UpperDeckArea_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UpperDeckArea");
    private final static QName _WaterPlaneArea_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WaterPlaneArea");
    private final static QName _ZPosDeckline_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ZPosDeckline");
    private final static QName _SpeedFactor_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SpeedFactor");
    private final static QName _MajorDiameter_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MajorDiameter");
    private final static QName _MinorDiameter_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "MinorDiameter");
    private final static QName _Positions_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Positions");
    private final static QName _StartPoint_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "StartPoint");
    private final static QName _IntermediatePoint_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "IntermediatePoint");
    private final static QName _EndPoint_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "EndPoint");
    private final static QName _Offset_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Offset");
    private final static QName _FlangeThickness_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlangeThickness");
    private final static QName _NeutralAxisU_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NeutralAxisU");
    private final static QName _NeutralAxisV_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "NeutralAxisV");
    private final static QName _InertiaU_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "InertiaU");
    private final static QName _InertiaV_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "InertiaV");
    private final static QName _TorsionConstant_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "TorsionConstant");
    private final static QName _ReferenceLocation_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ReferenceLocation");
    private final static QName _Displacement_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Displacement");
    private final static QName _Density_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Density");
    private final static QName _YoungsModulus_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "YoungsModulus");
    private final static QName _PoissonRatio_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "PoissonRatio");
    private final static QName _YieldStress_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "YieldStress");
    private final static QName _UltimateStress_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UltimateStress");
    private final static QName _ThermalExpansionCoefficient_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ThermalExpansionCoefficient");
    private final static QName _OffsetU_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "OffsetU");
    private final static QName _OffsetV_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "OffsetV");
    private final static QName _WebDirection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "WebDirection");
    private final static QName _FlangeDirection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "FlangeDirection");
    private final static QName _Position_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Position");
    private final static QName _DistanceAbove_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DistanceAbove");
    private final static QName _DistanceBelow_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "DistanceBelow");
    private final static QName _Axis_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Axis");
    private final static QName _Overshoot_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Overshoot");
    private final static QName _UDirection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "UDirection");
    private final static QName _VDirection_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "VDirection");
    private final static QName _Start_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "Start");
    private final static QName _SectionOuterShape_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SectionOuterShape");
    private final static QName _SectionInnerShape_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "SectionInnerShape");
    private final static QName _CustomProperties_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CustomProperties");
    private final static QName _CustomProperty_QNAME = new QName( "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "CustomProperty");

    /**
    * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dnv.data
    *
    */
    public ObjectFactory() {
    }

    // skip abstract type Header_T
    // skip abstract type DocumentBase_T
    // skip abstract type ocxXML_T
    // skip abstract type IdBase_T
    // skip abstract type DescriptionBase_T
    // skip abstract type NamedEntity_T
    // skip abstract type Description_T
    // skip abstract type EntityBase_T
    // skip abstract type ApplicationRef_T
    // skip abstract type ExternalGeometryRef_T
    // skip abstract type ReferenceBase_T
    // skip abstract type CatalogueRef_T
    // skip abstract type MaterialRef_T
    // skip abstract type SectionRef_T
    // skip abstract type HoleContourRef_T
    // skip abstract type HoleRef_T
    // skip abstract type PlateMaterialRef_T
    // skip abstract type BoundedRef_T
    // skip abstract type GridRef_T
    // skip abstract type EdgeCurveRef_T
    // skip abstract type SurfaceRef_T
    // skip abstract type SeamRef_T
    // skip abstract type PanelRef_T
    // skip abstract type StiffenerRef_T
    // skip abstract type StructureRef_T
    // skip abstract type PlateRef_T
    // skip abstract type BracketRef_T
    // skip abstract type LugPlaterRef_T
    // skip abstract type PillarRef_T
    // skip abstract type EdgeReinforcementRef_T
    // skip abstract type EndCutRef_T
    // skip abstract type VesselRef_T
    // skip abstract type ConnectionConfigurationRef_T
    // skip abstract type CellRef_T
    // skip abstract type OccurrenceGroup_T
    // skip abstract type DesignView_T
    // skip abstract type Occurrence_T
    // skip abstract type ProcessLayer_T
    // skip abstract type Form_T
    // skip abstract type Equipments_T
    // skip abstract type Equipment_T
    // skip abstract type Vessel_T
    // skip abstract type Seam_T
    // skip abstract type Member_T
    // skip abstract type Stiffener_T
    // skip abstract type Inclination_T
    // skip abstract type TraceLine_T
    // skip abstract type EdgeReinforcement_T
    // skip abstract type Pillar_T
    // skip abstract type Panel_T
    // skip abstract type ComposedOf_T
    // skip abstract type Plate_T
    // skip abstract type Bracket_T
    // skip abstract type StructurePart_T
    // skip abstract type LimitedBy_T
    // skip abstract type ReferencePlane_T
    // skip abstract type Hole2DContour_T
    // skip abstract type ConnectionConfiguration_T
    // skip abstract type Penetration_T
    // skip abstract type PenetratingObject_T
    // skip abstract type BracketParameters_T
    // skip abstract type FlangeEdgeReinforcement_T
    // skip abstract type FeatureCope_T
    // skip abstract type EndCut_T
    // skip abstract type ConnectedBracketRef_T
    // skip abstract type SingleBracket_T
    // skip abstract type DoubleBracket_T
    // skip abstract type WebStiffenerRef_T
    // skip abstract type WebStiffener_T
    // skip abstract type WebStiffenerWithSingleBracket_T
    // skip abstract type WebStiffenerWithDoubleBracket_T
    // skip abstract type SlotParameters_T
    // skip abstract type PhysicalProperties_T
    // skip abstract type PlateCutBy_T
    // skip abstract type CutBy_T
    // skip abstract type StiffenedBy_T
    // skip abstract type SplitBy_T
    // skip abstract type PhysicalSpace_T
    // skip abstract type Arrangement_T
    // skip abstract type Compartment_T
    // skip abstract type CompartmentFace_T
    // skip abstract type Cell_T
    // skip abstract type CellBoundary_T
    // skip abstract type CompartmentProperties_T
    // skip abstract type BulkCargo_T
    // skip abstract type UnitCargo_T
    // skip abstract type LiquidCargo_T
    // skip abstract type GaseousCargo_T
    // skip abstract type CellConnection_T
    // skip abstract type GeometryRepresentation_T
    // skip abstract type ReferenceSurfaces_T
    // skip abstract type Surface_T
    // skip abstract type Cylinder3D_T
    // skip abstract type Cone3D_T
    // skip abstract type Sphere3D_T
    // skip abstract type ExtrudedSurface_T
    // skip abstract type Sweep_T
    // skip abstract type BaseCurve_T
    // skip abstract type NURBSSurface_T
    // skip abstract type Plane3D_T
    // skip abstract type UnboundedGeometry_T
    // skip abstract type SurfaceCollection_T
    // skip abstract type Curve3D_T
    // skip abstract type Circle3D_T
    // skip abstract type Ellipse3D_T
    // skip abstract type CircumCircle3D_T
    // skip abstract type PolyLine3D_T
    // skip abstract type Line3D_T
    // skip abstract type CompositeCurve3D_T
    // skip abstract type NURBS3D_T
    // skip abstract type CircumArc3D_T
    // skip abstract type Contour3D_T
    // skip abstract type FreeEdgeCurve3D_T
    // skip abstract type NURBSProperties_T
    // skip abstract type KnotVector_T
    // skip abstract type ControlPoint_T
    // skip abstract type ControlPtList_T
    // skip abstract type CoordinateSystem_T
    // skip abstract type RefPlanes_T
    // skip abstract type CylindricalAxes_T
    // skip abstract type RadialCylinder_T
    // skip abstract type Transformation_T
    // skip abstract type RefPlane_T
    // skip abstract type Vector3D_T
    // skip abstract type Point3D_T
    // skip abstract type ContourBounds_T
    // skip abstract type ClassCatalogue_T
    // skip abstract type MaterialCatalogue_T
    // skip abstract type XSectionCatalogue_T
    // skip abstract type PrincipalParticulars_T
    // skip abstract type ShipDesignation_T
    // skip abstract type HoleShapeCatalogue_T
    // skip abstract type ParametricHole2D_T
    // skip abstract type Hole2D_T
    // skip abstract type ParametricCircle_T
    // skip abstract type SymmetricalHole_T
    // skip abstract type SuperElliptical_T
    // skip abstract type RectangularHole_T
    // skip abstract type RectangularMickeyMouseEars_T
    // skip abstract type Material_T
    // skip abstract type BarSection_T
    // skip abstract type BulbFlat_T
    // skip abstract type FlatBar_T
    // skip abstract type LBar_T
    // skip abstract type LBarOW_T
    // skip abstract type LBarOF_T
    // skip abstract type TBar_T
    // skip abstract type UBar_T
    // skip abstract type IBar_T
    // skip abstract type ZBar_T
    // skip abstract type RoundBar_T
    // skip abstract type HalfRoundBar_T
    // skip abstract type SquareBar_T
    // skip abstract type HexagonBar_T
    // skip abstract type OctagonBar_T
    // skip abstract type Tube_T
    // skip abstract type RectangularTube_T
    // skip abstract type UserDefinedBarSection_T
    // skip abstract type SectionProperties_T
    // skip abstract type UserDefinedParameter_T
    // skip abstract type ClassData_T
    // skip abstract type StatutoryData_T
    // skip abstract type ClassParameters_T
    // skip abstract type TonnageData_T
    // skip abstract type Quantity_T
    // skip abstract type ClassNotation_T
    // skip abstract type BuilderInformation_T
    // skip abstract type Positions_T
    // skip abstract type CustomProperties_T
    // skip abstract type CustomProperty_T
        public Header createHeader() { return new Header(); }
    // skip abstract type DocumentBase
        public OcxXML createOcxXML() { return new OcxXML(); }
    // skip abstract type IdBase
    // skip abstract type DescriptionBase
    // skip abstract type EntityBase
        public ApplicationRef createApplicationRef() { return new ApplicationRef(); }
        public ExternalGeometryRef createExternalGeometryRef() { return new ExternalGeometryRef(); }
    // skip abstract type ReferenceBase
    // skip abstract type CatalogueRef
        public MaterialRef createMaterialRef() { return new MaterialRef(); }
        public SectionRef createSectionRef() { return new SectionRef(); }
        public HoleContourRef createHoleContourRef() { return new HoleContourRef(); }
        public HoleRef createHoleRef() { return new HoleRef(); }
        public PlateMaterial createPlateMaterial() { return new PlateMaterial(); }
    // skip abstract type BoundedRef
        public GridRef createGridRef() { return new GridRef(); }
        public EdgeCurveRef createEdgeCurveRef() { return new EdgeCurveRef(); }
        public SurfaceRef createSurfaceRef() { return new SurfaceRef(); }
        public SeamRef createSeamRef() { return new SeamRef(); }
        public PanelRef createPanelRef() { return new PanelRef(); }
        public StiffenerRef createStiffenerRef() { return new StiffenerRef(); }
    // skip abstract type StructureRef
        public PlateRef createPlateRef() { return new PlateRef(); }
        public BracketRef createBracketRef() { return new BracketRef(); }
        public LugPlateRef createLugPlateRef() { return new LugPlateRef(); }
        public PillarRef createPillarRef() { return new PillarRef(); }
        public EdgeReinforcementRef createEdgeReinforcementRef() { return new EdgeReinforcementRef(); }
        public EndCutRef createEndCutRef() { return new EndCutRef(); }
        public VesselRef createVesselRef() { return new VesselRef(); }
        public ConnectionConfigurationRef createConnectionConfigurationRef() { return new ConnectionConfigurationRef(); }
        public CellRef createCellRef() { return new CellRef(); }
        public OccurrenceGroup createOccurrenceGroup() { return new OccurrenceGroup(); }
        public DesignView createDesignView() { return new DesignView(); }
        public Occurrence createOccurrence() { return new Occurrence(); }
    // skip abstract type ProcessLayer
    // skip abstract type Form
        public Equipments createEquipments() { return new Equipments(); }
        public Equipment createEquipment() { return new Equipment(); }
        public Vessel createVessel() { return new Vessel(); }
        public Seam createSeam() { return new Seam(); }
    // skip abstract type Member
        public Stiffener createStiffener() { return new Stiffener(); }
        public Inclination createInclination() { return new Inclination(); }
        public TraceLine createTraceLine() { return new TraceLine(); }
        public EdgeReinforcement createEdgeReinforcement() { return new EdgeReinforcement(); }
        public Pillar createPillar() { return new Pillar(); }
        public Panel createPanel() { return new Panel(); }
        public ComposedOf createComposedOf() { return new ComposedOf(); }
        public Plate createPlate() { return new Plate(); }
        public Bracket createBracket() { return new Bracket(); }
        public LimitedBy createLimitedBy() { return new LimitedBy(); }
    // skip abstract type ReferencePlane
        public Hole2DContour createHole2DContour() { return new Hole2DContour(); }
        public ConnectionConfiguration createConnectionConfiguration() { return new ConnectionConfiguration(); }
        public Penetration createPenetration() { return new Penetration(); }
        public BracketParameters createBracketParameters() { return new BracketParameters(); }
        public FlangeEdgeReinforcement createFlangeEdgeReinforcement() { return new FlangeEdgeReinforcement(); }
        public FeatureCope createFeatureCope() { return new FeatureCope(); }
        public EndCutEnd1 createEndCutEnd1() { return new EndCutEnd1(); }
        public EndCutEnd2 createEndCutEnd2() { return new EndCutEnd2(); }
        public ConnectedBracketRef createConnectedBracketRef() { return new ConnectedBracketRef(); }
        public SingleBracket createSingleBracket() { return new SingleBracket(); }
        public DoubleBracket createDoubleBracket() { return new DoubleBracket(); }
        public WebStiffenerRef createWebStiffenerRef() { return new WebStiffenerRef(); }
        public WebStiffener createWebStiffener() { return new WebStiffener(); }
        public WebStiffenerWithSingleBracket createWebStiffenerWithSingleBracket() { return new WebStiffenerWithSingleBracket(); }
        public WebStiffenerWithDoubleBracket createWebStiffenerWithDoubleBracket() { return new WebStiffenerWithDoubleBracket(); }
        public SlotParameters createSlotParameters() { return new SlotParameters(); }
        public ConnectionLength createConnectionLength() { return new ConnectionLength(); }
        public SlotContour createSlotContour() { return new SlotContour(); }
        public PhysicalProperties createPhysicalProperties() { return new PhysicalProperties(); }
        public CutBy createCutBy() { return new CutBy(); }
        public PlateCutBy createPlateCutBy() { return new PlateCutBy(); }
        public StiffenedBy createStiffenedBy() { return new StiffenedBy(); }
        public SplitBy createSplitBy() { return new SplitBy(); }
        public PhysicalSpace createPhysicalSpace() { return new PhysicalSpace(); }
        public Arrangement createArrangement() { return new Arrangement(); }
        public Compartment createCompartment() { return new Compartment(); }
        public CompartmentFace createCompartmentFace() { return new CompartmentFace(); }
        public Cell createCell() { return new Cell(); }
        public CellBoundary createCellBoundary() { return new CellBoundary(); }
        public CrossFlow createCrossFlow() { return new CrossFlow(); }
        public CompartmentProperties createCompartmentProperties() { return new CompartmentProperties(); }
        public BulkCargo createBulkCargo() { return new BulkCargo(); }
        public UnitCargo createUnitCargo() { return new UnitCargo(); }
        public LiquidCargo createLiquidCargo() { return new LiquidCargo(); }
        public GaseousCargo createGaseousCargo() { return new GaseousCargo(); }
        public CellConnection createCellConnection() { return new CellConnection(); }
        public CarriagePressure createCarriagePressure() { return new CarriagePressure(); }
        public Volume createVolume() { return new Volume(); }
        public AirPipeHeight createAirPipeHeight() { return new AirPipeHeight(); }
        public CenterOfGravity createCenterOfGravity() { return new CenterOfGravity(); }
        public StowageHeight createStowageHeight() { return new StowageHeight(); }
        public ReliefValvePressure createReliefValvePressure() { return new ReliefValvePressure(); }
        public FillingHeight createFillingHeight() { return new FillingHeight(); }
        public StowageFactor createStowageFactor() { return new StowageFactor(); }
        public Permeability createPermeability() { return new Permeability(); }
        public AngleOfRepose createAngleOfRepose() { return new AngleOfRepose(); }
    // skip abstract type GeometryRepresentation
        public ReferenceSurfaces createReferenceSurfaces() { return new ReferenceSurfaces(); }
    // skip abstract type Surface
        public Cylinder3D createCylinder3D() { return new Cylinder3D(); }
        public Cone3D createCone3D() { return new Cone3D(); }
        public Sphere3D createSphere3D() { return new Sphere3D(); }
        public ExtrudedSurface createExtrudedSurface() { return new ExtrudedSurface(); }
        public Sweep createSweep() { return new Sweep(); }
        public SweepCurve createSweepCurve() { return new SweepCurve(); }
        public BaseCurve createBaseCurve() { return new BaseCurve(); }
        public NURBSSurface createNURBSSurface() { return new NURBSSurface(); }
        public Plane3D createPlane3D() { return new Plane3D(); }
        public UnboundedGeometry createUnboundedGeometry() { return new UnboundedGeometry(); }
        public SurfaceCollection createSurfaceCollection() { return new SurfaceCollection(); }
        public Tip createTip() { return new Tip(); }
        public BaseRadius createBaseRadius() { return new BaseRadius(); }
        public TipRadius createTipRadius() { return new TipRadius(); }
    // skip abstract type Curve3D
        public Circle3D createCircle3D() { return new Circle3D(); }
        public Ellipse3D createEllipse3D() { return new Ellipse3D(); }
        public CircumCircle3D createCircumCircle3D() { return new CircumCircle3D(); }
        public PolyLine3D createPolyLine3D() { return new PolyLine3D(); }
        public Line3D createLine3D() { return new Line3D(); }
        public CompositeCurve3D createCompositeCurve3D() { return new CompositeCurve3D(); }
        public NURBS3D createNURBS3D() { return new NURBS3D(); }
        public CircumArc3D createCircumArc3D() { return new CircumArc3D(); }
        public OuterContour createOuterContour() { return new OuterContour(); }
        public InnerContour createInnerContour() { return new InnerContour(); }
        public FreeEdgeCurve3D createFreeEdgeCurve3D() { return new FreeEdgeCurve3D(); }
        public FaceBoundaryCurve createFaceBoundaryCurve() { return new FaceBoundaryCurve(); }
        public NURBSproperties createNURBSproperties() { return new NURBSproperties(); }
        public VNURBSproperties createVNURBSproperties() { return new VNURBSproperties(); }
        public UNURBSproperties createUNURBSproperties() { return new UNURBSproperties(); }
        public KnotVector createKnotVector() { return new KnotVector(); }
        public UknotVector createUknotVector() { return new UknotVector(); }
        public VknotVector createVknotVector() { return new VknotVector(); }
        public ControlPoint createControlPoint() { return new ControlPoint(); }
        public ControlPtList createControlPtList() { return new ControlPtList(); }
        public CurveLength createCurveLength() { return new CurveLength(); }
        public SweepLength createSweepLength() { return new SweepLength(); }
        public CoordinateSystem createCoordinateSystem() { return new CoordinateSystem(); }
        public LocalCartesian createLocalCartesian() { return new LocalCartesian(); }
        public XRefPlanes createXRefPlanes() { return new XRefPlanes(); }
        public YRefPlanes createYRefPlanes() { return new YRefPlanes(); }
        public ZRefPlanes createZRefPlanes() { return new ZRefPlanes(); }
        public CylindricalAxes createCylindricalAxes() { return new CylindricalAxes(); }
        public RadialCylinder createRadialCylinder() { return new RadialCylinder(); }
        public Transformation createTransformation() { return new Transformation(); }
        public RefPlane createRefPlane() { return new RefPlane(); }
        public DistanceToAP createDistanceToAP() { return new DistanceToAP(); }
        public MajorAxis createMajorAxis() { return new MajorAxis(); }
        public MinorAxis createMinorAxis() { return new MinorAxis(); }
        public Vector3D createVector3D() { return new Vector3D(); }
        public SecondaryAxis createSecondaryAxis() { return new SecondaryAxis(); }
        public PrimaryAxis createPrimaryAxis() { return new PrimaryAxis(); }
        public Origin createOrigin() { return new Origin(); }
        public Center createCenter() { return new Center(); }
        public Normal createNormal() { return new Normal(); }
        public Point3D createPoint3D() { return new Point3D(); }
        public X createX() { return new X(); }
        public Y createY() { return new Y(); }
        public Z createZ() { return new Z(); }
        public ContourBounds createContourBounds() { return new ContourBounds(); }
        public ContourStart createContourStart() { return new ContourStart(); }
        public ContourEnd createContourEnd() { return new ContourEnd(); }
        public ClassCatalogue createClassCatalogue() { return new ClassCatalogue(); }
        public MaterialCatalogue createMaterialCatalogue() { return new MaterialCatalogue(); }
        public XSectionCatalogue createXSectionCatalogue() { return new XSectionCatalogue(); }
        public PrincipalParticulars createPrincipalParticulars() { return new PrincipalParticulars(); }
        public HoleShapeCatalogue createHoleShapeCatalogue() { return new HoleShapeCatalogue(); }
    // skip abstract type ParametricHole2D
        public Hole2D createHole2D() { return new Hole2D(); }
        public ParametricCircle createParametricCircle() { return new ParametricCircle(); }
        public SymmetricalHole createSymmetricalHole() { return new SymmetricalHole(); }
        public SuperElliptical createSuperElliptical() { return new SuperElliptical(); }
        public RectangularHole createRectangularHole() { return new RectangularHole(); }
        public RectangularMickeyMouseEars createRectangularMickeyMouseEars() { return new RectangularMickeyMouseEars(); }
        public Material createMaterial() { return new Material(); }
        public BarSection createBarSection() { return new BarSection(); }
        public BulbFlat createBulbFlat() { return new BulbFlat(); }
        public FlatBar createFlatBar() { return new FlatBar(); }
        public LBar createLBar() { return new LBar(); }
        public LBarOW createLBarOW() { return new LBarOW(); }
        public LBarOF createLBarOF() { return new LBarOF(); }
        public TBar createTBar() { return new TBar(); }
        public UBar createUBar() { return new UBar(); }
        public IBar createIBar() { return new IBar(); }
        public ZBar createZBar() { return new ZBar(); }
        public RoundBar createRoundBar() { return new RoundBar(); }
        public HalfRoundBar createHalfRoundBar() { return new HalfRoundBar(); }
        public SquareBar createSquareBar() { return new SquareBar(); }
        public HexagonBar createHexagonBar() { return new HexagonBar(); }
        public OctagonBar createOctagonBar() { return new OctagonBar(); }
        public Tube createTube() { return new Tube(); }
        public RectangularTube createRectangularTube() { return new RectangularTube(); }
        public UserDefinedBarSection createUserDefinedBarSection() { return new UserDefinedBarSection(); }
        public SectionProperties createSectionProperties() { return new SectionProperties(); }
        public UserDefinedParameter createUserDefinedParameter() { return new UserDefinedParameter(); }
        public BuilderInformation createBuilderInformation() { return new BuilderInformation(); }
        public ShipDesignation createShipDesignation() { return new ShipDesignation(); }
    // skip abstract type Quantity
        public DistanceTolerance createDistanceTolerance() { return new DistanceTolerance(); }
        public AngleTolerance createAngleTolerance() { return new AngleTolerance(); }
        public TonnageData createTonnageData() { return new TonnageData(); }
        public StatutoryData createStatutoryData() { return new StatutoryData(); }
        public ClassificationData createClassificationData() { return new ClassificationData(); }
        public ClassNotation createClassNotation() { return new ClassNotation(); }
        public Radius createRadius() { return new Radius(); }
        public NetArea createNetArea() { return new NetArea(); }
        public Area createArea() { return new Area(); }
        public ArmLengthU createArmLengthU() { return new ArmLengthU(); }
        public ArmLengthV createArmLengthV() { return new ArmLengthV(); }
        public Unose createUnose() { return new Unose(); }
        public Vnose createVnose() { return new Vnose(); }
        public FreeEdgeRadius createFreeEdgeRadius() { return new FreeEdgeRadius(); }
        public CopeHeight createCopeHeight() { return new CopeHeight(); }
        public CopeRadius createCopeRadius() { return new CopeRadius(); }
        public FlangeCutBackAngle createFlangeCutBackAngle() { return new FlangeCutBackAngle(); }
        public WebCutBackAngle createWebCutBackAngle() { return new WebCutBackAngle(); }
        public FlangeNoseHeight createFlangeNoseHeight() { return new FlangeNoseHeight(); }
        public WebNoseHeight createWebNoseHeight() { return new WebNoseHeight(); }
        public CutbackDistance createCutbackDistance() { return new CutbackDistance(); }
        public CopeLength createCopeLength() { return new CopeLength(); }
        public DryWeight createDryWeight() { return new DryWeight(); }
        public UpperRadius createUpperRadius() { return new UpperRadius(); }
        public LowerRadius createLowerRadius() { return new LowerRadius(); }
        public Tonnage createTonnage() { return new Tonnage(); }
        public Width createWidth() { return new Width(); }
        public Height createHeight() { return new Height(); }
        public Thickness createThickness() { return new Thickness(); }
        public DeadWeight createDeadWeight() { return new DeadWeight(); }
        public WebThickness createWebThickness() { return new WebThickness(); }
        public FlangeWidth createFlangeWidth() { return new FlangeWidth(); }
        public BulbAngle createBulbAngle() { return new BulbAngle(); }
        public BulbOuterRadius createBulbOuterRadius() { return new BulbOuterRadius(); }
        public BulbInnerRadius createBulbInnerRadius() { return new BulbInnerRadius(); }
        public BulbTopRadius createBulbTopRadius() { return new BulbTopRadius(); }
        public BulbBottomRadius createBulbBottomRadius() { return new BulbBottomRadius(); }
        public FilletRadius createFilletRadius() { return new FilletRadius(); }
        public Diameter createDiameter() { return new Diameter(); }
        public Contour createContour() { return new Contour(); }
        public Lpp createLpp() { return new Lpp(); }
        public RuleLength createRuleLength() { return new RuleLength(); }
        public BlockCoefficient createBlockCoefficient() { return new BlockCoefficient(); }
        public FPPos createFPPos() { return new FPPos(); }
        public MouldedBreadth createMouldedBreadth() { return new MouldedBreadth(); }
        public MouldedDepth createMouldedDepth() { return new MouldedDepth(); }
        public ScantlingDraught createScantlingDraught() { return new ScantlingDraught(); }
        public DesignSpeed createDesignSpeed() { return new DesignSpeed(); }
        public FreeboardLength createFreeboardLength() { return new FreeboardLength(); }
        public NormalBallastDraught createNormalBallastDraught() { return new NormalBallastDraught(); }
        public HeavyBallastDraught createHeavyBallastDraught() { return new HeavyBallastDraught(); }
        public SlammingDraughtEmptyFP createSlammingDraughtEmptyFP() { return new SlammingDraughtEmptyFP(); }
        public SlammingDraughtFullFP createSlammingDraughtFullFP() { return new SlammingDraughtFullFP(); }
        public LengthOfWaterline createLengthOfWaterline() { return new LengthOfWaterline(); }
        public FreeboardDeckHeight createFreeboardDeckHeight() { return new FreeboardDeckHeight(); }
        public APPos createAPPos() { return new APPos(); }
        public ZPosOfDeck createZPosOfDeck() { return new ZPosOfDeck(); }
        public DeepestEquilibriumWL createDeepestEquilibriumWL() { return new DeepestEquilibriumWL(); }
        public UpperDeckArea createUpperDeckArea() { return new UpperDeckArea(); }
        public WaterPlaneArea createWaterPlaneArea() { return new WaterPlaneArea(); }
        public ZPosDeckline createZPosDeckline() { return new ZPosDeckline(); }
        public SpeedFactor createSpeedFactor() { return new SpeedFactor(); }
        public MajorDiameter createMajorDiameter() { return new MajorDiameter(); }
        public MinorDiameter createMinorDiameter() { return new MinorDiameter(); }
        public Positions createPositions() { return new Positions(); }
        public StartPoint createStartPoint() { return new StartPoint(); }
        public IntermediatePoint createIntermediatePoint() { return new IntermediatePoint(); }
        public EndPoint createEndPoint() { return new EndPoint(); }
        public Offset createOffset() { return new Offset(); }
        public FlangeThickness createFlangeThickness() { return new FlangeThickness(); }
        public NeutralAxisU createNeutralAxisU() { return new NeutralAxisU(); }
        public NeutralAxisV createNeutralAxisV() { return new NeutralAxisV(); }
        public InertiaU createInertiaU() { return new InertiaU(); }
        public InertiaV createInertiaV() { return new InertiaV(); }
        public TorsionConstant createTorsionConstant() { return new TorsionConstant(); }
        public ReferenceLocation createReferenceLocation() { return new ReferenceLocation(); }
        public Displacement createDisplacement() { return new Displacement(); }
        public Density createDensity() { return new Density(); }
        public YoungsModulus createYoungsModulus() { return new YoungsModulus(); }
        public PoissonRatio createPoissonRatio() { return new PoissonRatio(); }
        public YieldStress createYieldStress() { return new YieldStress(); }
        public UltimateStress createUltimateStress() { return new UltimateStress(); }
        public ThermalExpansionCoefficient createThermalExpansionCoefficient() { return new ThermalExpansionCoefficient(); }
        public OffsetU createOffsetU() { return new OffsetU(); }
        public OffsetV createOffsetV() { return new OffsetV(); }
        public WebDirection createWebDirection() { return new WebDirection(); }
        public FlangeDirection createFlangeDirection() { return new FlangeDirection(); }
        public Position createPosition() { return new Position(); }
        public DistanceAbove createDistanceAbove() { return new DistanceAbove(); }
        public DistanceBelow createDistanceBelow() { return new DistanceBelow(); }
        public Axis createAxis() { return new Axis(); }
        public Overshoot createOvershoot() { return new Overshoot(); }
        public UDirection createUDirection() { return new UDirection(); }
        public VDirection createVDirection() { return new VDirection(); }
        public Start createStart() { return new Start(); }
        public SectionOuterShape createSectionOuterShape() { return new SectionOuterShape(); }
        public SectionInnerShape createSectionInnerShape() { return new SectionInnerShape(); }
        public CustomProperties createCustomProperties() { return new CustomProperties(); }
        public CustomProperty createCustomProperty() { return new CustomProperty(); }

    // TypeWrapper{name='Header_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='time_stamp', typeName='xs:dateTime', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='author', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='originating_system', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='organization', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='application_version', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='documentation', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='DocumentBase_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='schemaVersion', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='3.0.0', referencedType='Object'}, AttributeWrapper{name='language', typeName='xs:language', targetNamespace='', required=false, defaultValue='en', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Header', typeName='Header', docu='null', type=Header, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ocxXML_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DocumentBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Vessel', typeName='Vessel', docu='null', type=Vessel, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ClassCatalogue', typeName='ClassCatalogue', docu='null', type=ClassCatalogue, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ProcessLayer', typeName='ProcessLayer', docu='null', type=ProcessLayer, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='UnitsML', typeName='UnitsML', docu='null', type=UnitsML, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Equipments', typeName='Equipments', docu='null', type=Equipments, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='IdBase_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='CustomProperties', typeName='CustomProperties', docu='null', type=CustomProperties, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='DescriptionBase_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='IdBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Description', typeName='xs:string', docu='null', type=string, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='NamedEntity_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='IdBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Description', typeName='xs:string', docu='null', type=string, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Description_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='EntityBase_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ApplicationRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='externalRef', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ExternalGeometryRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='externalRef', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='geometryFormat', typeName='geometryFormat', targetNamespace='', required=true, defaultValue='null', fixedValue='.stp', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ReferenceBase_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='localRef', typeName='xs:IDREF', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='CatalogueRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='MaterialRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='CatalogueRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Material', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='SectionRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='CatalogueRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:BarSection', referencedType='Object'}], properties=[PropertyWrapper{name='OffsetU', typeName='OffsetU', docu='null', type=OffsetU, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='OffsetV', typeName='OffsetV', docu='null', type=OffsetV, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='HoleContourRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='CatalogueRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Hole2DContour', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='HoleRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='CatalogueRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Hole2D', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='PlateMaterialRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='CatalogueRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Material', referencedType='Object'}], properties=[PropertyWrapper{name='Thickness', typeName='Thickness', docu='null', type=Thickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='BoundedRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ContourBounds', typeName='ContourBounds', docu='null', type=ContourBounds, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='GridRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:ReferencePlane', referencedType='Object'}], properties=[PropertyWrapper{name='Offset', typeName='Offset', docu='null', type=Offset, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='EdgeCurveRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:FreeEdgeCurve3D', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='SurfaceRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Surface', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='SeamRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Seam', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='PanelRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Panel', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='StiffenerRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Stiffener', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='StructureRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='StiffenerRef', typeName='StiffenerRef', docu='null', type=StiffenerRef, minOccurs=0, maxOccurs=100}]}
    // TypeWrapper{name='PlateRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructureRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='BracketRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructureRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='LugPlaterRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructureRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='PillarRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructureRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='EdgeReinforcementRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:EdgeReinforcement', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='EndCutRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:EndCut', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='VesselRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='ConnectionConfigurationRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='CellRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Cell', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='OccurrenceGroup_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='type', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Occurrence', typeName='Occurrence', docu='null', type=Occurrence, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='OccurrenceGroup', typeName='OccurrenceGroup', docu='null', type=OccurrenceGroup, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='DesignView_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='VesselRef', typeName='VesselRef', docu='null', type=VesselRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='OccurrenceGroup', typeName='OccurrenceGroup', docu='null', type=OccurrenceGroup, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='Occurrence', typeName='Occurrence', docu='null', type=Occurrence, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='Occurrence_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='type', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='StructureRef', typeName='StructureRef', docu='null', type=StructureRef, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='StiffenerRef', typeName='StiffenerRef', docu='null', type=StiffenerRef, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='SeamRef', typeName='SeamRef', docu='null', type=SeamRef, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='HoleRef', typeName='HoleRef', docu='null', type=HoleRef, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='ProcessLayer_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Form_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='DistanceTolerance', typeName='DistanceTolerance', docu='null', type=DistanceTolerance, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='AngleTolerance', typeName='AngleTolerance', docu='null', type=AngleTolerance, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Equipments_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Equipment', typeName='Equipment', docu='null', type=Equipment, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='Equipment_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ExternalGeometryRef', typeName='ExternalGeometryRef', docu='null', type=ExternalGeometryRef, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Vessel_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Form_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CoordinateSystem', typeName='CoordinateSystem', docu='null', type=CoordinateSystem, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='ClassificationData', typeName='ClassificationData', docu='null', type=ClassificationData, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='BuilderInformation', typeName='BuilderInformation', docu='null', type=BuilderInformation, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='TonnageData', typeName='TonnageData', docu='null', type=TonnageData, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='StatutoryData', typeName='StatutoryData', docu='null', type=StatutoryData, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ShipDesignation', typeName='ShipDesignation', docu='null', type=ShipDesignation, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='DesignView', typeName='DesignView', docu='null', type=DesignView, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='Arrangement', typeName='Arrangement', docu='null', type=Arrangement, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ReferenceSurfaces', typeName='ReferenceSurfaces', docu='null', type=ReferenceSurfaces, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Panel', typeName='Panel', docu='null', type=Panel, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='Plate', typeName='Plate', docu='null', type=Plate, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='Stiffener', typeName='Stiffener', docu='null', type=Stiffener, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='Bracket', typeName='Bracket', docu='null', type=Bracket, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='Member', typeName='Member', docu='null', type=Member, minOccurs=0, maxOccurs=100}]}
    // TypeWrapper{name='Seam_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='TraceLine', typeName='TraceLine', docu='null', type=TraceLine, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Member_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructurePart_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Stiffener_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructurePart_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='TraceLine', typeName='TraceLine', docu='null', type=TraceLine, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MaterialRef', typeName='MaterialRef', docu='null', type=MaterialRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SectionRef', typeName='SectionRef', docu='null', type=SectionRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Inclination', typeName='Inclination', docu='null', type=Inclination, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='EndCutEnd1', typeName='EndCutEnd1', docu='null', type=EndCutEnd1, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='EndCutEnd2', typeName='EndCutEnd2', docu='null', type=EndCutEnd2, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Offset', typeName='Offset', docu='null', type=Offset, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ConnectionConfiguration', typeName='ConnectionConfiguration', docu='null', type=ConnectionConfiguration, minOccurs=0, maxOccurs=2}, PropertyWrapper{name='Penetration', typeName='Penetration', docu='null', type=Penetration, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='CutBy', typeName='CutBy', docu='null', type=CutBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Inclination_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='WebDirection', typeName='WebDirection', docu='null', type=WebDirection, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeDirection', typeName='FlangeDirection', docu='null', type=FlangeDirection, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Position', typeName='Position', docu='null', type=Position, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='TraceLine_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CompositeCurve3D', typeName='CompositeCurve3D', docu='null', type=CompositeCurve3D, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='EdgeReinforcement_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructurePart_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='SectionRef', typeName='SectionRef', docu='null', type=SectionRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MaterialRef', typeName='MaterialRef', docu='null', type=MaterialRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Inclination', typeName='Inclination', docu='null', type=Inclination, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='EdgeCurveRef', typeName='EdgeCurveRef', docu='null', type=EdgeCurveRef, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='TraceLine', typeName='TraceLine', docu='null', type=TraceLine, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Pillar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Member_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='MaterialRef', typeName='MaterialRef', docu='null', type=MaterialRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SectionRef', typeName='SectionRef', docu='null', type=SectionRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='TraceLine', typeName='TraceLine', docu='null', type=TraceLine, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Inclination', typeName='Inclination', docu='null', type=Inclination, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='CutBy', typeName='CutBy', docu='null', type=CutBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Penetration', typeName='Penetration', docu='null', type=Penetration, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='ConnectionConfiguration', typeName='ConnectionConfiguration', docu='null', type=ConnectionConfiguration, minOccurs=0, maxOccurs=2}]}
    // TypeWrapper{name='Panel_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='tightness', typeName='tightness', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ComposedOf', typeName='ComposedOf', docu='null', type=ComposedOf, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='PhysicalProperties', typeName='PhysicalProperties', docu='null', type=PhysicalProperties, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='OuterContour', typeName='OuterContour', docu='null', type=OuterContour, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='StiffenedBy', typeName='StiffenedBy', docu='null', type=StiffenedBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='SplitBy', typeName='SplitBy', docu='null', type=SplitBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='CutBy', typeName='CutBy', docu='null', type=CutBy, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='ComposedOf_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Plate', typeName='Plate', docu='null', type=Plate, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='Bracket', typeName='Bracket', docu='null', type=Bracket, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='Pillar', typeName='Pillar', docu='null', type=Pillar, minOccurs=0, maxOccurs=100}]}
    // TypeWrapper{name='Plate_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructurePart_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='NetArea', typeName='NetArea', docu='null', type=NetArea, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='OuterContour', typeName='OuterContour', docu='null', type=OuterContour, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='PlateMaterial', typeName='PlateMaterial', docu='null', type=PlateMaterial, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Offset', typeName='Offset', docu='null', type=Offset, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='PlateCutBy', typeName='PlateCutBy', docu='null', type=PlateCutBy, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Bracket_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='StructurePart_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='BracketParameters', typeName='BracketParameters', docu='null', type=BracketParameters, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='PlateMaterial', typeName='PlateMaterial', docu='null', type=PlateMaterial, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Offset', typeName='Offset', docu='null', type=Offset, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='OuterContour', typeName='OuterContour', docu='null', type=OuterContour, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='CutBy', typeName='CutBy', docu='null', type=CutBy, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='InnerContour', typeName='InnerContour', docu='null', type=InnerContour, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='StiffenedBy', typeName='StiffenedBy', docu='null', type=StiffenedBy, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='StructurePart_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='PhysicalProperties', typeName='PhysicalProperties', docu='null', type=PhysicalProperties, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ExternalGeometryRef', typeName='ExternalGeometryRef', docu='null', type=ExternalGeometryRef, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='LimitedBy_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='FreeEdgeCurve3D', typeName='FreeEdgeCurve3D', docu='null', type=FreeEdgeCurve3D, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='BoundedRef', typeName='BoundedRef', docu='null', type=BoundedRef, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='ReferencePlane_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Hole2DContour_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='GeometryRepresentation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='HoleRef', typeName='HoleRef', docu='null', type=HoleRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Transformation', typeName='Transformation', docu='null', type=Transformation, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ConnectionConfiguration_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Penetration_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ConnectionConfiguration_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='tightness', typeName='tightness', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='SlotParameters', typeName='SlotParameters', docu='null', type=SlotParameters, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='PenetratingObject_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='PlateRef', typeName='PlateRef', docu='null', type=PlateRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SlotParameters', typeName='SlotParameters', docu='null', type=SlotParameters, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='BracketParameters_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='numberOfSupports', typeName='xs:int', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='hasEdgeReinforcement', typeName='xs:boolean', targetNamespace='', required=true, defaultValue='false', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='reinforcementType', typeName='reinforcementType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='ArmLengthU', typeName='ArmLengthU', docu='null', type=ArmLengthU, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ArmLengthV', typeName='ArmLengthV', docu='null', type=ArmLengthV, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UDirection', typeName='UDirection', docu='null', type=UDirection, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='VDirection', typeName='VDirection', docu='null', type=VDirection, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Unose', typeName='Unose', docu='null', type=Unose, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Vnose', typeName='Vnose', docu='null', type=Vnose, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FreeEdgeRadius', typeName='FreeEdgeRadius', docu='null', type=FreeEdgeRadius, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FeatureCope', typeName='FeatureCope', docu='null', type=FeatureCope, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FlangeEdgeReinforcement', typeName='FlangeEdgeReinforcement', docu='null', type=FlangeEdgeReinforcement, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='FlangeEdgeReinforcement_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='FlangeWidth', typeName='FlangeWidth', docu='null', type=FlangeWidth, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='FeatureCope_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CopeRadius', typeName='CopeRadius', docu='null', type=CopeRadius, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='CopeLength', typeName='CopeLength', docu='null', type=CopeLength, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='CopeHeight', typeName='CopeHeight', docu='null', type=CopeHeight, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='EndCut_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='symmetricFlange', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='sniped', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='CutbackDistance', typeName='CutbackDistance', docu='null', type=CutbackDistance, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebCutBackAngle', typeName='WebCutBackAngle', docu='null', type=WebCutBackAngle, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebNoseHeight', typeName='WebNoseHeight', docu='null', type=WebNoseHeight, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FlangeCutBackAngle', typeName='FlangeCutBackAngle', docu='null', type=FlangeCutBackAngle, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FlangeNoseHeight', typeName='FlangeNoseHeight', docu='null', type=FlangeNoseHeight, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FeatureCope', typeName='FeatureCope', docu='null', type=FeatureCope, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='ConnectedBracketRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BracketRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='position', typeName='position', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='SingleBracket_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ConnectedBracketRef', typeName='ConnectedBracketRef', docu='null', type=ConnectedBracketRef, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='DoubleBracket_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ConnectedBracketRef', typeName='ConnectedBracketRef', docu='null', type=ConnectedBracketRef, minOccurs=2, maxOccurs=2}]}
    // TypeWrapper{name='WebStiffenerRef_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='position', typeName='position', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='WebStiffener_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='WebStiffenerRef', typeName='WebStiffenerRef', docu='null', type=WebStiffenerRef, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='WebStiffenerWithSingleBracket_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ConnectedBracketRef', typeName='ConnectedBracketRef', docu='null', type=ConnectedBracketRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebStiffenerRef', typeName='WebStiffenerRef', docu='null', type=WebStiffenerRef, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='WebStiffenerWithDoubleBracket_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ConnectedBracketRef', typeName='ConnectedBracketRef', docu='null', type=ConnectedBracketRef, minOccurs=1, maxOccurs=2}, PropertyWrapper{name='WebStiffenerRef', typeName='WebStiffenerRef', docu='null', type=WebStiffenerRef, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='SlotParameters_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='asymmetric', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='true', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='slotType', typeName='slotType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='Open', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UpperRadius', typeName='UpperRadius', docu='null', type=UpperRadius, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ConnectionLength', typeName='ConnectionLength', docu='null', type=ConnectionLength, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LowerRadius', typeName='LowerRadius', docu='null', type=LowerRadius, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LugPlateRef', typeName='LugPlateRef', docu='null', type=LugPlateRef, minOccurs=0, maxOccurs=2}]}
    // TypeWrapper{name='PhysicalProperties_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='DryWeight', typeName='DryWeight', docu='null', type=DryWeight, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='CenterOfGravity', typeName='CenterOfGravity', docu='null', type=CenterOfGravity, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='PlateCutBy_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='CutBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='CutBy_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Hole2DContour', typeName='Hole2DContour', docu='null', type=Hole2DContour, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='InnerContour', typeName='InnerContour', docu='null', type=InnerContour, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='StiffenedBy_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Stiffener', typeName='Stiffener', docu='null', type=Stiffener, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='EdgeReinforcement', typeName='EdgeReinforcement', docu='null', type=EdgeReinforcement, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='SplitBy_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Seam', typeName='Seam', docu='null', type=Seam, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='PhysicalSpace_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='compartmentPurpose', typeName='compartmentPurpose', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='CompartmentProperties', typeName='CompartmentProperties', docu='null', type=CompartmentProperties, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Cell', typeName='Cell', docu='null', type=Cell, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='CrossFlow', typeName='CrossFlow', docu='null', type=CrossFlow, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='ExternalGeometryRef', typeName='ExternalGeometryRef', docu='null', type=ExternalGeometryRef, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Arrangement_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Compartment', typeName='Compartment', docu='null', type=Compartment, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='PhysicalSpace', typeName='PhysicalSpace', docu='null', type=PhysicalSpace, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Compartment_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='compartmentPurpose', typeName='compartmentPurpose', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='CompartmentProperties', typeName='CompartmentProperties', docu='null', type=CompartmentProperties, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='CompartmentFace', typeName='CompartmentFace', docu='null', type=CompartmentFace, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='ExternalGeometryRef', typeName='ExternalGeometryRef', docu='null', type=ExternalGeometryRef, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='CompartmentFace_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FaceBoundaryCurve', typeName='FaceBoundaryCurve', docu='null', type=FaceBoundaryCurve, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Cell_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='GeometryRepresentation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CellBoundary', typeName='CellBoundary', docu='null', type=CellBoundary, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='CellBoundary_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Panel', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='CompartmentProperties_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CenterOfGravity', typeName='CenterOfGravity', docu='null', type=CenterOfGravity, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Volume', typeName='Volume', docu='null', type=Volume, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='AirPipeHeight', typeName='AirPipeHeight', docu='null', type=AirPipeHeight, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FillingHeight', typeName='FillingHeight', docu='null', type=FillingHeight, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ReliefValvePressure', typeName='ReliefValvePressure', docu='null', type=ReliefValvePressure, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='BulkCargo_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='bulkCargoType', typeName='bulkCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='StowageFactor', typeName='StowageFactor', docu='null', type=StowageFactor, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Permeability', typeName='Permeability', docu='null', type=Permeability, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='AngleOfRepose', typeName='AngleOfRepose', docu='null', type=AngleOfRepose, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='UnitCargo_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='unitCargoType', typeName='unitCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='LiquidCargo_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='liquidCargoType', typeName='liquidCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Density', typeName='Density', docu='null', type=Density, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='CarriagePressure', typeName='CarriagePressure', docu='null', type=CarriagePressure, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='GaseousCargo_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='liquidState', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='liquidCargoType', typeName='liquidCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Density', typeName='Density', docu='null', type=Density, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='CarriagePressure', typeName='CarriagePressure', docu='null', type=CarriagePressure, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='CellConnection_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CellRef', typeName='CellRef', docu='null', type=CellRef, minOccurs=2, maxOccurs=2}]}
    // TypeWrapper{name='GeometryRepresentation_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ReferenceSurfaces_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Surface', typeName='Surface', docu='null', type=Surface, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='SurfaceCollection', typeName='SurfaceCollection', docu='null', type=SurfaceCollection, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='Surface_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='GeometryRepresentation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='FaceBoundaryCurve', typeName='FaceBoundaryCurve', docu='null', type=FaceBoundaryCurve, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Cylinder3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Axis', typeName='Axis', docu='null', type=Axis, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Cone3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Tip', typeName='Tip', docu='null', type=Tip, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='BaseRadius', typeName='BaseRadius', docu='null', type=BaseRadius, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='TipRadius', typeName='TipRadius', docu='null', type=TipRadius, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Sphere3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ExtrudedSurface_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='BaseCurve', typeName='BaseCurve', docu='null', type=BaseCurve, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Sweep_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Vector3D', typeName='Vector3D', docu='null', type=Vector3D, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SweepLength', typeName='SweepLength', docu='null', type=SweepLength, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='BaseCurve_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Curve3D', typeName='Curve3D', docu='null', type=Curve3D, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='NURBSSurface_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='U_NURBSproperties', typeName='U_NURBSproperties', docu='null', type=U_NURBSproperties, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UknotVector', typeName='UknotVector', docu='null', type=UknotVector, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='V_NURBSproperties', typeName='V_NURBSproperties', docu='null', type=V_NURBSproperties, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='VknotVector', typeName='VknotVector', docu='null', type=VknotVector, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ControlPtList', typeName='ControlPtList', docu='null', type=ControlPtList, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='Plane3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Normal', typeName='Normal', docu='null', type=Normal, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UDirection', typeName='UDirection', docu='null', type=UDirection, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='UnboundedGeometry_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Surface', typeName='Surface', docu='null', type=Surface, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='GridRef', typeName='GridRef', docu='null', type=GridRef, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SurfaceRef', typeName='SurfaceRef', docu='null', type=SurfaceRef, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='SurfaceCollection_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Surface', typeName='Surface', docu='null', type=Surface, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='Curve3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='GeometryRepresentation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='is2D', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='CurveLength', typeName='CurveLength', docu='null', type=CurveLength, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Circle3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Diameter', typeName='Diameter', docu='null', type=Diameter, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Center', typeName='Center', docu='null', type=Center, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Normal', typeName='Normal', docu='null', type=Normal, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Ellipse3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Center', typeName='Center', docu='null', type=Center, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MajorDiameter', typeName='MajorDiameter', docu='null', type=MajorDiameter, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MinorDiameter', typeName='MinorDiameter', docu='null', type=MinorDiameter, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MajorAxis', typeName='MajorAxis', docu='null', type=MajorAxis, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MinorAxis', typeName='MinorAxis', docu='null', type=MinorAxis, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Normal', typeName='Normal', docu='null', type=Normal, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='CircumCircle3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Positions', typeName='Positions', docu='null', type=Positions, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='PolyLine3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='isClosed', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Point3D', typeName='Point3D', docu='null', type=Point3D, minOccurs=2, maxOccurs=100}]}
    // TypeWrapper{name='Line3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='StartPoint', typeName='StartPoint', docu='null', type=StartPoint, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='EndPoint', typeName='EndPoint', docu='null', type=EndPoint, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='CompositeCurve3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='PolyLine3D', typeName='PolyLine3D', docu='null', type=PolyLine3D, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Line3D', typeName='Line3D', docu='null', type=Line3D, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='NURBS3D', typeName='NURBS3D', docu='null', type=NURBS3D, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='CircumArc3D', typeName='CircumArc3D', docu='null', type=CircumArc3D, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='NURBS3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='NURBSproperties', typeName='NURBSproperties', docu='null', type=NURBSproperties, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='KnotVector', typeName='KnotVector', docu='null', type=KnotVector, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ControlPtList', typeName='ControlPtList', docu='null', type=ControlPtList, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='CircumArc3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='StartPoint', typeName='StartPoint', docu='null', type=StartPoint, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='IntermediatePoint', typeName='IntermediatePoint', docu='null', type=IntermediatePoint, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='EndPoint', typeName='EndPoint', docu='null', type=EndPoint, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Contour3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Curve3D', typeName='Curve3D', docu='null', type=Curve3D, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='FreeEdgeCurve3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='isUVSpace', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Curve3D', typeName='Curve3D', docu='null', type=Curve3D, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='NURBSProperties_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='degree', typeName='xs:int', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='numCtrlPts', typeName='xs:long', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='numKnots', typeName='xs:long', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='form', typeName='curveForm_enum', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='Open', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='isRational', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='KnotVector_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='value', typeName='ocx:doubleListType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ControlPoint_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='weight', typeName='xs:double', targetNamespace='', required=false, defaultValue='1.0', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ControlPtList_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ControlPoint', typeName='ControlPoint', docu='null', type=ControlPoint, minOccurs=2, maxOccurs=100}]}
    // TypeWrapper{name='CoordinateSystem_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='isGlobal', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='true', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='XRefPlanes', typeName='XRefPlanes', docu='null', type=XRefPlanes, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='YRefPlanes', typeName='YRefPlanes', docu='null', type=YRefPlanes, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ZRefPlanes', typeName='ZRefPlanes', docu='null', type=ZRefPlanes, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LocalCartesian', typeName='LocalCartesian', docu='null', type=LocalCartesian, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='RefPlanes_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ReferencePlane_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='isMainSystem', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='true', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='RefPlane', typeName='RefPlane', docu='null', type=RefPlane, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='CylindricalAxes_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='RadialCylinder', typeName='RadialCylinder', docu='null', type=RadialCylinder, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='RadialCylinder_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Transformation_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='PrimaryAxis', typeName='PrimaryAxis', docu='null', type=PrimaryAxis, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SecondaryAxis', typeName='SecondaryAxis', docu='null', type=SecondaryAxis, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='RefPlane_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ReferenceLocation', typeName='ReferenceLocation', docu='null', type=ReferenceLocation, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Vector3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='direction', typeName='ocx:doubleListType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='Point3D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='coordinates', typeName='ocx:doubleListType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='unit', typeName='xs:IDREF', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ContourBounds_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ContourStart', typeName='ContourStart', docu='null', type=ContourStart, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ContourEnd', typeName='ContourEnd', docu='null', type=ContourEnd, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ClassCatalogue_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='MaterialCatalogue', typeName='MaterialCatalogue', docu='null', type=MaterialCatalogue, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='XSectionCatalogue', typeName='XSectionCatalogue', docu='null', type=XSectionCatalogue, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='HoleShapeCatalogue', typeName='HoleShapeCatalogue', docu='null', type=HoleShapeCatalogue, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='MaterialCatalogue_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Material', typeName='Material', docu='null', type=Material, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='XSectionCatalogue_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='NamedEntity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='BarSection', typeName='BarSection', docu='null', type=BarSection, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='PrincipalParticulars_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='hasDeadweightLessThan', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='hasBilgeKeel', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='numberOfDecksAbove', typeName='xs:int', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='freeboardType', typeName='freeboardType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='A', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Lpp', typeName='Lpp', docu='null', type=Lpp, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='RuleLength', typeName='RuleLength', docu='null', type=RuleLength, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='BlockCoefficient', typeName='BlockCoefficient', docu='null', type=BlockCoefficient, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FP_Pos', typeName='FP_Pos', docu='null', type=FP_Pos, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MouldedBreadth', typeName='MouldedBreadth', docu='null', type=MouldedBreadth, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='MouldedDepth', typeName='MouldedDepth', docu='null', type=MouldedDepth, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ScantlingDraught', typeName='ScantlingDraught', docu='null', type=ScantlingDraught, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='DesignSpeed', typeName='DesignSpeed', docu='null', type=DesignSpeed, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FreeboardLength', typeName='FreeboardLength', docu='null', type=FreeboardLength, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='NormalBallastDraught', typeName='NormalBallastDraught', docu='null', type=NormalBallastDraught, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='HeavyBallastDraught', typeName='HeavyBallastDraught', docu='null', type=HeavyBallastDraught, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='SlammingDraughtEmptyFP', typeName='SlammingDraughtEmptyFP', docu='null', type=SlammingDraughtEmptyFP, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='SlammingDraughtFullFP', typeName='SlammingDraughtFullFP', docu='null', type=SlammingDraughtFullFP, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LengthOfWaterline', typeName='LengthOfWaterline', docu='null', type=LengthOfWaterline, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='FreeboardDeckHeight', typeName='FreeboardDeckHeight', docu='null', type=FreeboardDeckHeight, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='AP_Pos', typeName='AP_Pos', docu='null', type=AP_Pos, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ZPosOfDeck', typeName='ZPosOfDeck', docu='null', type=ZPosOfDeck, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='DeepestEquilibriumWL', typeName='DeepestEquilibriumWL', docu='null', type=DeepestEquilibriumWL, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='UpperDeckArea', typeName='UpperDeckArea', docu='null', type=UpperDeckArea, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='WaterPlaneArea', typeName='WaterPlaneArea', docu='null', type=WaterPlaneArea, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ZPosDeckline', typeName='ZPosDeckline', docu='null', type=ZPosDeckline, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='SpeedFactor', typeName='SpeedFactor', docu='null', type=SpeedFactor, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='ShipDesignation_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='shipName', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='callSign', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='numberIMO', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='shipType', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='HoleShapeCatalogue_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Hole2D', typeName='Hole2D', docu='null', type=Hole2D, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='ParametricHole2D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Hole2D_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='NamedEntity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='ParametricHole2D', typeName='ParametricHole2D', docu='null', type=ParametricHole2D, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Contour', typeName='Contour', docu='null', type=Contour, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ParametricCircle_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Diameter', typeName='Diameter', docu='null', type=Diameter, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='SymmetricalHole_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='SuperElliptical_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='exponent', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='RectangularHole_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FilletRadius', typeName='FilletRadius', docu='null', type=FilletRadius, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='RectangularMickeyMouseEars_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Displacement', typeName='Displacement', docu='null', type=Displacement, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Material_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='NamedEntity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='grade', typeName='grade', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Density', typeName='Density', docu='null', type=Density, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='YoungsModulus', typeName='YoungsModulus', docu='null', type=YoungsModulus, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='PoissonRatio', typeName='PoissonRatio', docu='null', type=PoissonRatio, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='YieldStress', typeName='YieldStress', docu='null', type=YieldStress, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UltimateStress', typeName='UltimateStress', docu='null', type=UltimateStress, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ThermalExpansionCoefficient', typeName='ThermalExpansionCoefficient', docu='null', type=ThermalExpansionCoefficient, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='BarSection_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='RectangularTube', typeName='RectangularTube', docu='null', type=RectangularTube, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='OctagonBar', typeName='OctagonBar', docu='null', type=OctagonBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='SquareBar', typeName='SquareBar', docu='null', type=SquareBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='BulbFlat', typeName='BulbFlat', docu='null', type=BulbFlat, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlatBar', typeName='FlatBar', docu='null', type=FlatBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UBar', typeName='UBar', docu='null', type=UBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='IBar', typeName='IBar', docu='null', type=IBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='LBarOF', typeName='LBarOF', docu='null', type=LBarOF, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ZBar', typeName='ZBar', docu='null', type=ZBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='RoundBar', typeName='RoundBar', docu='null', type=RoundBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='LBar', typeName='LBar', docu='null', type=LBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='TBar', typeName='TBar', docu='null', type=TBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='LBarOW', typeName='LBarOW', docu='null', type=LBarOW, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='HalfRoundBar', typeName='HalfRoundBar', docu='null', type=HalfRoundBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='HexagonBar', typeName='HexagonBar', docu='null', type=HexagonBar, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Tube', typeName='Tube', docu='null', type=Tube, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='UserDefinedBarSection', typeName='UserDefinedBarSection', docu='null', type=UserDefinedBarSection, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='BulbFlat_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeWidth', typeName='FlangeWidth', docu='null', type=FlangeWidth, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='BulbAngle', typeName='BulbAngle', docu='null', type=BulbAngle, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='BulbOuterRadius', typeName='BulbOuterRadius', docu='null', type=BulbOuterRadius, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='BulbInnerRadius', typeName='BulbInnerRadius', docu='null', type=BulbInnerRadius, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='BulbTopRadius', typeName='BulbTopRadius', docu='null', type=BulbTopRadius, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='BulbBottomRadius', typeName='BulbBottomRadius', docu='null', type=BulbBottomRadius, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='FlatBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='LBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='LBarOW_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Overshoot', typeName='Overshoot', docu='null', type=Overshoot, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='LBarOF_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Overshoot', typeName='Overshoot', docu='null', type=Overshoot, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='TBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='UBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='IBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ZBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='RoundBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='HalfRoundBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='SquareBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='HexagonBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='OctagonBar_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Tube_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Diameter', typeName='Diameter', docu='null', type=Diameter, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Thickness', typeName='Thickness', docu='null', type=Thickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='RectangularTube_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='Thickness', typeName='Thickness', docu='null', type=Thickness, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='UserDefinedBarSection_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='numberOfParameters', typeName='xs:int', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='SectionProperties', typeName='SectionProperties', docu='null', type=SectionProperties, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='SectionProperties_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Area', typeName='Area', docu='null', type=Area, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='NeutralAxisU', typeName='NeutralAxisU', docu='null', type=NeutralAxisU, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='NeutralAxisV', typeName='NeutralAxisV', docu='null', type=NeutralAxisV, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='InertiaU', typeName='InertiaU', docu='null', type=InertiaU, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='InertiaV', typeName='InertiaV', docu='null', type=InertiaV, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='TorsionConstant', typeName='TorsionConstant', docu='null', type=TorsionConstant, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='UserDefinedParameter_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Description', typeName='xs:string', docu='null', type=string, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='ClassData_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='identification', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='newbuildingSocietyName', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='societyName', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='newbuildingSociety', typeName='classificationSociety', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='society', typeName='classificationSociety', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='PrincipalParticulars', typeName='PrincipalParticulars', docu='null', type=PrincipalParticulars, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='ClassNotation', typeName='ClassNotation', docu='null', type=ClassNotation, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='StatutoryData_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='portRegistration', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='flagState', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ClassParameters_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='blockCoefficientClass', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='designSpeedAhead', typeName='xs:double', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='designSpeedAstern', typeName='xs:double', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='lengthSolas', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='lengthClass', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='scantlingsDraught', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='TonnageData_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Tonnage', typeName='Tonnage', docu='null', type=Tonnage, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='DeadWeight', typeName='DeadWeight', docu='null', type=DeadWeight, minOccurs=1, maxOccurs=1}]}
    // TypeWrapper{name='Quantity_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='numericvalue', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='unit', typeName='xs:IDREF', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ClassNotation_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='hull', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='machinery', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='iceClass', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='serviceArea', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='serviceFactor', typeName='xs:double', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='additionalNotations', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='BuilderInformation_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='yard', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='designer', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='owner', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='yearOfBuild', typeName='xs:date', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='Positions_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='Point3D', typeName='Point3D', docu='null', type=Point3D, minOccurs=3, maxOccurs=3}]}
    // TypeWrapper{name='CustomProperties_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CustomProperty', typeName='CustomProperty', docu='null', type=CustomProperty, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='CustomProperty_T', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='value', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='unit', typeName='xs:IDREF', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Description', typeName='string', docu='null', type=string, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='Header', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Header_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Header }{@code >}}
    */
    @XmlElementDecl( name = "Header", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Header> createHeader( Header value) {
        return new JAXBElement<Header>( _Header_QNAME, Header.class, null, value);
    }
    // TypeWrapper{name='DocumentBase', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DocumentBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='ocxXML', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ocxXML_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link OcxXML }{@code >}}
    */
    @XmlElementDecl( name = "ocxXML", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<OcxXML> createOcxXML( OcxXML value) {
        return new JAXBElement<OcxXML>( _OcxXML_QNAME, OcxXML.class, null, value);
    }
    // TypeWrapper{name='IdBase', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='IdBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='DescriptionBase', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DescriptionBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='EntityBase', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EntityBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='ApplicationRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ApplicationRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ApplicationRef }{@code >}}
    */
    @XmlElementDecl( name = "ApplicationRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ApplicationRef> createApplicationRef( ApplicationRef value) {
        return new JAXBElement<ApplicationRef>( _ApplicationRef_QNAME, ApplicationRef.class, null, value);
    }
    // TypeWrapper{name='ExternalGeometryRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ExternalGeometryRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ExternalGeometryRef }{@code >}}
    */
    @XmlElementDecl( name = "ExternalGeometryRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ExternalGeometryRef> createExternalGeometryRef( ExternalGeometryRef value) {
        return new JAXBElement<ExternalGeometryRef>( _ExternalGeometryRef_QNAME, ExternalGeometryRef.class, null, value);
    }
    // TypeWrapper{name='ReferenceBase', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='CatalogueRef', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CatalogueRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='MaterialRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='MaterialRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MaterialRef }{@code >}}
    */
    @XmlElementDecl( name = "MaterialRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MaterialRef> createMaterialRef( MaterialRef value) {
        return new JAXBElement<MaterialRef>( _MaterialRef_QNAME, MaterialRef.class, null, value);
    }
    // TypeWrapper{name='SectionRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SectionRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SectionRef }{@code >}}
    */
    @XmlElementDecl( name = "SectionRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SectionRef> createSectionRef( SectionRef value) {
        return new JAXBElement<SectionRef>( _SectionRef_QNAME, SectionRef.class, null, value);
    }
    // TypeWrapper{name='HoleContourRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HoleContourRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link HoleContourRef }{@code >}}
    */
    @XmlElementDecl( name = "HoleContourRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<HoleContourRef> createHoleContourRef( HoleContourRef value) {
        return new JAXBElement<HoleContourRef>( _HoleContourRef_QNAME, HoleContourRef.class, null, value);
    }
    // TypeWrapper{name='HoleRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HoleRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link HoleRef }{@code >}}
    */
    @XmlElementDecl( name = "HoleRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<HoleRef> createHoleRef( HoleRef value) {
        return new JAXBElement<HoleRef>( _HoleRef_QNAME, HoleRef.class, null, value);
    }
    // TypeWrapper{name='PlateMaterial', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PlateMaterialRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PlateMaterial }{@code >}}
    */
    @XmlElementDecl( name = "PlateMaterial", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PlateMaterial> createPlateMaterial( PlateMaterial value) {
        return new JAXBElement<PlateMaterial>( _PlateMaterial_QNAME, PlateMaterial.class, null, value);
    }
    // TypeWrapper{name='BoundedRef', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='GridRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='GridRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link GridRef }{@code >}}
    */
    @XmlElementDecl( name = "GridRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<GridRef> createGridRef( GridRef value) {
        return new JAXBElement<GridRef>( _GridRef_QNAME, GridRef.class, null, value);
    }
    // TypeWrapper{name='EdgeCurveRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EdgeCurveRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EdgeCurveRef }{@code >}}
    */
    @XmlElementDecl( name = "EdgeCurveRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EdgeCurveRef> createEdgeCurveRef( EdgeCurveRef value) {
        return new JAXBElement<EdgeCurveRef>( _EdgeCurveRef_QNAME, EdgeCurveRef.class, null, value);
    }
    // TypeWrapper{name='SurfaceRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SurfaceRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SurfaceRef }{@code >}}
    */
    @XmlElementDecl( name = "SurfaceRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SurfaceRef> createSurfaceRef( SurfaceRef value) {
        return new JAXBElement<SurfaceRef>( _SurfaceRef_QNAME, SurfaceRef.class, null, value);
    }
    // TypeWrapper{name='SeamRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SeamRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SeamRef }{@code >}}
    */
    @XmlElementDecl( name = "SeamRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SeamRef> createSeamRef( SeamRef value) {
        return new JAXBElement<SeamRef>( _SeamRef_QNAME, SeamRef.class, null, value);
    }
    // TypeWrapper{name='PanelRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PanelRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PanelRef }{@code >}}
    */
    @XmlElementDecl( name = "PanelRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PanelRef> createPanelRef( PanelRef value) {
        return new JAXBElement<PanelRef>( _PanelRef_QNAME, PanelRef.class, null, value);
    }
    // TypeWrapper{name='StiffenerRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StiffenerRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link StiffenerRef }{@code >}}
    */
    @XmlElementDecl( name = "StiffenerRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<StiffenerRef> createStiffenerRef( StiffenerRef value) {
        return new JAXBElement<StiffenerRef>( _StiffenerRef_QNAME, StiffenerRef.class, null, value);
    }
    // TypeWrapper{name='StructureRef', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StructureRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='PlateRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PlateRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PlateRef }{@code >}}
    */
    @XmlElementDecl( name = "PlateRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PlateRef> createPlateRef( PlateRef value) {
        return new JAXBElement<PlateRef>( _PlateRef_QNAME, PlateRef.class, null, value);
    }
    // TypeWrapper{name='BracketRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BracketRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BracketRef }{@code >}}
    */
    @XmlElementDecl( name = "BracketRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BracketRef> createBracketRef( BracketRef value) {
        return new JAXBElement<BracketRef>( _BracketRef_QNAME, BracketRef.class, null, value);
    }
    // TypeWrapper{name='LugPlateRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LugPlaterRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ConnectionLength', typeName='ConnectionLength', docu='null', type=ConnectionLength, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='DistanceAbove', typeName='DistanceAbove', docu='null', type=DistanceAbove, minOccurs=1, maxOccurs=1}]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LugPlateRef }{@code >}}
    */
    @XmlElementDecl( name = "LugPlateRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LugPlateRef> createLugPlateRef( LugPlateRef value) {
        return new JAXBElement<LugPlateRef>( _LugPlateRef_QNAME, LugPlateRef.class, null, value);
    }
    // TypeWrapper{name='PillarRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PillarRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PillarRef }{@code >}}
    */
    @XmlElementDecl( name = "PillarRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PillarRef> createPillarRef( PillarRef value) {
        return new JAXBElement<PillarRef>( _PillarRef_QNAME, PillarRef.class, null, value);
    }
    // TypeWrapper{name='EdgeReinforcementRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EdgeReinforcementRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EdgeReinforcementRef }{@code >}}
    */
    @XmlElementDecl( name = "EdgeReinforcementRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EdgeReinforcementRef> createEdgeReinforcementRef( EdgeReinforcementRef value) {
        return new JAXBElement<EdgeReinforcementRef>( _EdgeReinforcementRef_QNAME, EdgeReinforcementRef.class, null, value);
    }
    // TypeWrapper{name='EndCutRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EndCutRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EndCutRef }{@code >}}
    */
    @XmlElementDecl( name = "EndCutRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EndCutRef> createEndCutRef( EndCutRef value) {
        return new JAXBElement<EndCutRef>( _EndCutRef_QNAME, EndCutRef.class, null, value);
    }
    // TypeWrapper{name='VesselRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='VesselRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link VesselRef }{@code >}}
    */
    @XmlElementDecl( name = "VesselRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<VesselRef> createVesselRef( VesselRef value) {
        return new JAXBElement<VesselRef>( _VesselRef_QNAME, VesselRef.class, null, value);
    }
    // TypeWrapper{name='ConnectionConfigurationRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ConnectionConfigurationRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ConnectionConfigurationRef }{@code >}}
    */
    @XmlElementDecl( name = "ConnectionConfigurationRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ConnectionConfigurationRef> createConnectionConfigurationRef( ConnectionConfigurationRef value) {
        return new JAXBElement<ConnectionConfigurationRef>( _ConnectionConfigurationRef_QNAME, ConnectionConfigurationRef.class, null, value);
    }
    // TypeWrapper{name='CellRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CellRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CellRef }{@code >}}
    */
    @XmlElementDecl( name = "CellRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CellRef> createCellRef( CellRef value) {
        return new JAXBElement<CellRef>( _CellRef_QNAME, CellRef.class, null, value);
    }
    // TypeWrapper{name='OccurrenceGroup', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='OccurrenceGroup_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link OccurrenceGroup }{@code >}}
    */
    @XmlElementDecl( name = "OccurrenceGroup", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<OccurrenceGroup> createOccurrenceGroup( OccurrenceGroup value) {
        return new JAXBElement<OccurrenceGroup>( _OccurrenceGroup_QNAME, OccurrenceGroup.class, null, value);
    }
    // TypeWrapper{name='DesignView', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DesignView_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DesignView }{@code >}}
    */
    @XmlElementDecl( name = "DesignView", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DesignView> createDesignView( DesignView value) {
        return new JAXBElement<DesignView>( _DesignView_QNAME, DesignView.class, null, value);
    }
    // TypeWrapper{name='Occurrence', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Occurrence_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Occurrence }{@code >}}
    */
    @XmlElementDecl( name = "Occurrence", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Occurrence> createOccurrence( Occurrence value) {
        return new JAXBElement<Occurrence>( _Occurrence_QNAME, Occurrence.class, null, value);
    }
    // TypeWrapper{name='ProcessLayer', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ProcessLayer_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Form', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Form_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Equipments', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Equipments_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Equipments }{@code >}}
    */
    @XmlElementDecl( name = "Equipments", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Equipments> createEquipments( Equipments value) {
        return new JAXBElement<Equipments>( _Equipments_QNAME, Equipments.class, null, value);
    }
    // TypeWrapper{name='Equipment', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Equipment_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Equipment }{@code >}}
    */
    @XmlElementDecl( name = "Equipment", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Equipment> createEquipment( Equipment value) {
        return new JAXBElement<Equipment>( _Equipment_QNAME, Equipment.class, null, value);
    }
    // TypeWrapper{name='Vessel', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vessel_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Vessel }{@code >}}
    */
    @XmlElementDecl( name = "Vessel", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Vessel> createVessel( Vessel value) {
        return new JAXBElement<Vessel>( _Vessel_QNAME, Vessel.class, null, value);
    }
    // TypeWrapper{name='Seam', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Seam_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Seam }{@code >}}
    */
    @XmlElementDecl( name = "Seam", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Seam> createSeam( Seam value) {
        return new JAXBElement<Seam>( _Seam_QNAME, Seam.class, null, value);
    }
    // TypeWrapper{name='Member', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Member_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Stiffener', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Stiffener_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Stiffener }{@code >}}
    */
    @XmlElementDecl( name = "Stiffener", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Stiffener> createStiffener( Stiffener value) {
        return new JAXBElement<Stiffener>( _Stiffener_QNAME, Stiffener.class, null, value);
    }
    // TypeWrapper{name='Inclination', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Inclination_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Inclination }{@code >}}
    */
    @XmlElementDecl( name = "Inclination", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Inclination> createInclination( Inclination value) {
        return new JAXBElement<Inclination>( _Inclination_QNAME, Inclination.class, null, value);
    }
    // TypeWrapper{name='TraceLine', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TraceLine_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link TraceLine }{@code >}}
    */
    @XmlElementDecl( name = "TraceLine", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<TraceLine> createTraceLine( TraceLine value) {
        return new JAXBElement<TraceLine>( _TraceLine_QNAME, TraceLine.class, null, value);
    }
    // TypeWrapper{name='EdgeReinforcement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EdgeReinforcement_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EdgeReinforcement }{@code >}}
    */
    @XmlElementDecl( name = "EdgeReinforcement", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EdgeReinforcement> createEdgeReinforcement( EdgeReinforcement value) {
        return new JAXBElement<EdgeReinforcement>( _EdgeReinforcement_QNAME, EdgeReinforcement.class, null, value);
    }
    // TypeWrapper{name='Pillar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Pillar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Pillar }{@code >}}
    */
    @XmlElementDecl( name = "Pillar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Pillar> createPillar( Pillar value) {
        return new JAXBElement<Pillar>( _Pillar_QNAME, Pillar.class, null, value);
    }
    // TypeWrapper{name='Panel', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Panel_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Panel }{@code >}}
    */
    @XmlElementDecl( name = "Panel", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Panel> createPanel( Panel value) {
        return new JAXBElement<Panel>( _Panel_QNAME, Panel.class, null, value);
    }
    // TypeWrapper{name='ComposedOf', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ComposedOf_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ComposedOf }{@code >}}
    */
    @XmlElementDecl( name = "ComposedOf", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ComposedOf> createComposedOf( ComposedOf value) {
        return new JAXBElement<ComposedOf>( _ComposedOf_QNAME, ComposedOf.class, null, value);
    }
    // TypeWrapper{name='Plate', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Plate_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Plate }{@code >}}
    */
    @XmlElementDecl( name = "Plate", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Plate> createPlate( Plate value) {
        return new JAXBElement<Plate>( _Plate_QNAME, Plate.class, null, value);
    }
    // TypeWrapper{name='Bracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Bracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Bracket }{@code >}}
    */
    @XmlElementDecl( name = "Bracket", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Bracket> createBracket( Bracket value) {
        return new JAXBElement<Bracket>( _Bracket_QNAME, Bracket.class, null, value);
    }
    // TypeWrapper{name='LimitedBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LimitedBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LimitedBy }{@code >}}
    */
    @XmlElementDecl( name = "LimitedBy", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LimitedBy> createLimitedBy( LimitedBy value) {
        return new JAXBElement<LimitedBy>( _LimitedBy_QNAME, LimitedBy.class, null, value);
    }
    // TypeWrapper{name='ReferencePlane', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ReferencePlane_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Hole2DContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Hole2DContour_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Hole2DContour }{@code >}}
    */
    @XmlElementDecl( name = "Hole2DContour", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Hole2DContour> createHole2DContour( Hole2DContour value) {
        return new JAXBElement<Hole2DContour>( _Hole2DContour_QNAME, Hole2DContour.class, null, value);
    }
    // TypeWrapper{name='ConnectionConfiguration', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ConnectionConfiguration_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ConnectionConfiguration }{@code >}}
    */
    @XmlElementDecl( name = "ConnectionConfiguration", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ConnectionConfiguration> createConnectionConfiguration( ConnectionConfiguration value) {
        return new JAXBElement<ConnectionConfiguration>( _ConnectionConfiguration_QNAME, ConnectionConfiguration.class, null, value);
    }
    // TypeWrapper{name='Penetration', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Penetration_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Penetration }{@code >}}
    */
    @XmlElementDecl( name = "Penetration", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Penetration> createPenetration( Penetration value) {
        return new JAXBElement<Penetration>( _Penetration_QNAME, Penetration.class, null, value);
    }
    // TypeWrapper{name='BracketParameters', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BracketParameters_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BracketParameters }{@code >}}
    */
    @XmlElementDecl( name = "BracketParameters", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BracketParameters> createBracketParameters( BracketParameters value) {
        return new JAXBElement<BracketParameters>( _BracketParameters_QNAME, BracketParameters.class, null, value);
    }
    // TypeWrapper{name='FlangeEdgeReinforcement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FlangeEdgeReinforcement_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlangeEdgeReinforcement }{@code >}}
    */
    @XmlElementDecl( name = "FlangeEdgeReinforcement", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlangeEdgeReinforcement> createFlangeEdgeReinforcement( FlangeEdgeReinforcement value) {
        return new JAXBElement<FlangeEdgeReinforcement>( _FlangeEdgeReinforcement_QNAME, FlangeEdgeReinforcement.class, null, value);
    }
    // TypeWrapper{name='FeatureCope', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FeatureCope_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FeatureCope }{@code >}}
    */
    @XmlElementDecl( name = "FeatureCope", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FeatureCope> createFeatureCope( FeatureCope value) {
        return new JAXBElement<FeatureCope>( _FeatureCope_QNAME, FeatureCope.class, null, value);
    }
    // TypeWrapper{name='EndCutEnd1', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EndCut_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EndCutEnd1 }{@code >}}
    */
    @XmlElementDecl( name = "EndCutEnd1", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EndCutEnd1> createEndCutEnd1( EndCutEnd1 value) {
        return new JAXBElement<EndCutEnd1>( _EndCutEnd1_QNAME, EndCutEnd1.class, null, value);
    }
    // TypeWrapper{name='EndCutEnd2', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EndCut_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EndCutEnd2 }{@code >}}
    */
    @XmlElementDecl( name = "EndCutEnd2", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EndCutEnd2> createEndCutEnd2( EndCutEnd2 value) {
        return new JAXBElement<EndCutEnd2>( _EndCutEnd2_QNAME, EndCutEnd2.class, null, value);
    }
    // TypeWrapper{name='ConnectedBracketRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ConnectedBracketRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ConnectedBracketRef }{@code >}}
    */
    @XmlElementDecl( name = "ConnectedBracketRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ConnectedBracketRef> createConnectedBracketRef( ConnectedBracketRef value) {
        return new JAXBElement<ConnectedBracketRef>( _ConnectedBracketRef_QNAME, ConnectedBracketRef.class, null, value);
    }
    // TypeWrapper{name='SingleBracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SingleBracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SingleBracket }{@code >}}
    */
    @XmlElementDecl( name = "SingleBracket", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SingleBracket> createSingleBracket( SingleBracket value) {
        return new JAXBElement<SingleBracket>( _SingleBracket_QNAME, SingleBracket.class, null, value);
    }
    // TypeWrapper{name='DoubleBracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DoubleBracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DoubleBracket }{@code >}}
    */
    @XmlElementDecl( name = "DoubleBracket", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DoubleBracket> createDoubleBracket( DoubleBracket value) {
        return new JAXBElement<DoubleBracket>( _DoubleBracket_QNAME, DoubleBracket.class, null, value);
    }
    // TypeWrapper{name='WebStiffenerRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='WebStiffenerRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebStiffenerRef }{@code >}}
    */
    @XmlElementDecl( name = "WebStiffenerRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebStiffenerRef> createWebStiffenerRef( WebStiffenerRef value) {
        return new JAXBElement<WebStiffenerRef>( _WebStiffenerRef_QNAME, WebStiffenerRef.class, null, value);
    }
    // TypeWrapper{name='WebStiffener', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='WebStiffener_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebStiffener }{@code >}}
    */
    @XmlElementDecl( name = "WebStiffener", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebStiffener> createWebStiffener( WebStiffener value) {
        return new JAXBElement<WebStiffener>( _WebStiffener_QNAME, WebStiffener.class, null, value);
    }
    // TypeWrapper{name='WebStiffenerWithSingleBracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='WebStiffenerWithSingleBracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebStiffenerWithSingleBracket }{@code >}}
    */
    @XmlElementDecl( name = "WebStiffenerWithSingleBracket", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebStiffenerWithSingleBracket> createWebStiffenerWithSingleBracket( WebStiffenerWithSingleBracket value) {
        return new JAXBElement<WebStiffenerWithSingleBracket>( _WebStiffenerWithSingleBracket_QNAME, WebStiffenerWithSingleBracket.class, null, value);
    }
    // TypeWrapper{name='WebStiffenerWithDoubleBracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='WebStiffenerWithDoubleBracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebStiffenerWithDoubleBracket }{@code >}}
    */
    @XmlElementDecl( name = "WebStiffenerWithDoubleBracket", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebStiffenerWithDoubleBracket> createWebStiffenerWithDoubleBracket( WebStiffenerWithDoubleBracket value) {
        return new JAXBElement<WebStiffenerWithDoubleBracket>( _WebStiffenerWithDoubleBracket_QNAME, WebStiffenerWithDoubleBracket.class, null, value);
    }
    // TypeWrapper{name='SlotParameters', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SlotParameters_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SlotParameters }{@code >}}
    */
    @XmlElementDecl( name = "SlotParameters", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SlotParameters> createSlotParameters( SlotParameters value) {
        return new JAXBElement<SlotParameters>( _SlotParameters_QNAME, SlotParameters.class, null, value);
    }
    // TypeWrapper{name='ConnectionLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ConnectionLength }{@code >}}
    */
    @XmlElementDecl( name = "ConnectionLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ConnectionLength> createConnectionLength( ConnectionLength value) {
        return new JAXBElement<ConnectionLength>( _ConnectionLength_QNAME, ConnectionLength.class, null, value);
    }
    // TypeWrapper{name='SlotContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Hole2DContour_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SlotContour }{@code >}}
    */
    @XmlElementDecl( name = "SlotContour", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SlotContour> createSlotContour( SlotContour value) {
        return new JAXBElement<SlotContour>( _SlotContour_QNAME, SlotContour.class, null, value);
    }
    // TypeWrapper{name='PhysicalProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PhysicalProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PhysicalProperties }{@code >}}
    */
    @XmlElementDecl( name = "PhysicalProperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PhysicalProperties> createPhysicalProperties( PhysicalProperties value) {
        return new JAXBElement<PhysicalProperties>( _PhysicalProperties_QNAME, PhysicalProperties.class, null, value);
    }
    // TypeWrapper{name='CutBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CutBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CutBy }{@code >}}
    */
    @XmlElementDecl( name = "CutBy", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CutBy> createCutBy( CutBy value) {
        return new JAXBElement<CutBy>( _CutBy_QNAME, CutBy.class, null, value);
    }
    // TypeWrapper{name='PlateCutBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PlateCutBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PlateCutBy }{@code >}}
    */
    @XmlElementDecl( name = "PlateCutBy", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PlateCutBy> createPlateCutBy( PlateCutBy value) {
        return new JAXBElement<PlateCutBy>( _PlateCutBy_QNAME, PlateCutBy.class, null, value);
    }
    // TypeWrapper{name='StiffenedBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StiffenedBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link StiffenedBy }{@code >}}
    */
    @XmlElementDecl( name = "StiffenedBy", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<StiffenedBy> createStiffenedBy( StiffenedBy value) {
        return new JAXBElement<StiffenedBy>( _StiffenedBy_QNAME, StiffenedBy.class, null, value);
    }
    // TypeWrapper{name='SplitBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SplitBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SplitBy }{@code >}}
    */
    @XmlElementDecl( name = "SplitBy", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SplitBy> createSplitBy( SplitBy value) {
        return new JAXBElement<SplitBy>( _SplitBy_QNAME, SplitBy.class, null, value);
    }
    // TypeWrapper{name='PhysicalSpace', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PhysicalSpace_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PhysicalSpace }{@code >}}
    */
    @XmlElementDecl( name = "PhysicalSpace", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PhysicalSpace> createPhysicalSpace( PhysicalSpace value) {
        return new JAXBElement<PhysicalSpace>( _PhysicalSpace_QNAME, PhysicalSpace.class, null, value);
    }
    // TypeWrapper{name='Arrangement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Arrangement_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Arrangement }{@code >}}
    */
    @XmlElementDecl( name = "Arrangement", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Arrangement> createArrangement( Arrangement value) {
        return new JAXBElement<Arrangement>( _Arrangement_QNAME, Arrangement.class, null, value);
    }
    // TypeWrapper{name='Compartment', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Compartment_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Compartment }{@code >}}
    */
    @XmlElementDecl( name = "Compartment", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Compartment> createCompartment( Compartment value) {
        return new JAXBElement<Compartment>( _Compartment_QNAME, Compartment.class, null, value);
    }
    // TypeWrapper{name='CompartmentFace', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CompartmentFace_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CompartmentFace }{@code >}}
    */
    @XmlElementDecl( name = "CompartmentFace", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CompartmentFace> createCompartmentFace( CompartmentFace value) {
        return new JAXBElement<CompartmentFace>( _CompartmentFace_QNAME, CompartmentFace.class, null, value);
    }
    // TypeWrapper{name='Cell', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Cell_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Cell }{@code >}}
    */
    @XmlElementDecl( name = "Cell", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Cell> createCell( Cell value) {
        return new JAXBElement<Cell>( _Cell_QNAME, Cell.class, null, value);
    }
    // TypeWrapper{name='CellBoundary', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CellBoundary_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CellBoundary }{@code >}}
    */
    @XmlElementDecl( name = "CellBoundary", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CellBoundary> createCellBoundary( CellBoundary value) {
        return new JAXBElement<CellBoundary>( _CellBoundary_QNAME, CellBoundary.class, null, value);
    }
    // TypeWrapper{name='CrossFlow', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='IdBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CellConnection', typeName='CellConnection', docu='null', type=CellConnection, minOccurs=1, maxOccurs=1}]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CrossFlow }{@code >}}
    */
    @XmlElementDecl( name = "CrossFlow", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CrossFlow> createCrossFlow( CrossFlow value) {
        return new JAXBElement<CrossFlow>( _CrossFlow_QNAME, CrossFlow.class, null, value);
    }
    // TypeWrapper{name='CompartmentProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CompartmentProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CompartmentProperties }{@code >}}
    */
    @XmlElementDecl( name = "CompartmentProperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CompartmentProperties> createCompartmentProperties( CompartmentProperties value) {
        return new JAXBElement<CompartmentProperties>( _CompartmentProperties_QNAME, CompartmentProperties.class, null, value);
    }
    // TypeWrapper{name='BulkCargo', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BulkCargo_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulkCargo }{@code >}}
    */
    @XmlElementDecl( name = "BulkCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulkCargo> createBulkCargo( BulkCargo value) {
        return new JAXBElement<BulkCargo>( _BulkCargo_QNAME, BulkCargo.class, null, value);
    }
    // TypeWrapper{name='UnitCargo', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitCargo_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UnitCargo }{@code >}}
    */
    @XmlElementDecl( name = "UnitCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UnitCargo> createUnitCargo( UnitCargo value) {
        return new JAXBElement<UnitCargo>( _UnitCargo_QNAME, UnitCargo.class, null, value);
    }
    // TypeWrapper{name='LiquidCargo', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LiquidCargo_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LiquidCargo }{@code >}}
    */
    @XmlElementDecl( name = "LiquidCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LiquidCargo> createLiquidCargo( LiquidCargo value) {
        return new JAXBElement<LiquidCargo>( _LiquidCargo_QNAME, LiquidCargo.class, null, value);
    }
    // TypeWrapper{name='GaseousCargo', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='GaseousCargo_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link GaseousCargo }{@code >}}
    */
    @XmlElementDecl( name = "GaseousCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<GaseousCargo> createGaseousCargo( GaseousCargo value) {
        return new JAXBElement<GaseousCargo>( _GaseousCargo_QNAME, GaseousCargo.class, null, value);
    }
    // TypeWrapper{name='CellConnection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CellConnection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CellConnection }{@code >}}
    */
    @XmlElementDecl( name = "CellConnection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CellConnection> createCellConnection( CellConnection value) {
        return new JAXBElement<CellConnection>( _CellConnection_QNAME, CellConnection.class, null, value);
    }
    // TypeWrapper{name='CarriagePressure', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CarriagePressure }{@code >}}
    */
    @XmlElementDecl( name = "CarriagePressure", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CarriagePressure> createCarriagePressure( CarriagePressure value) {
        return new JAXBElement<CarriagePressure>( _CarriagePressure_QNAME, CarriagePressure.class, null, value);
    }
    // TypeWrapper{name='Volume', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Volume }{@code >}}
    */
    @XmlElementDecl( name = "Volume", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Volume> createVolume( Volume value) {
        return new JAXBElement<Volume>( _Volume_QNAME, Volume.class, null, value);
    }
    // TypeWrapper{name='AirPipeHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link AirPipeHeight }{@code >}}
    */
    @XmlElementDecl( name = "AirPipeHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<AirPipeHeight> createAirPipeHeight( AirPipeHeight value) {
        return new JAXBElement<AirPipeHeight>( _AirPipeHeight_QNAME, AirPipeHeight.class, null, value);
    }
    // TypeWrapper{name='CenterOfGravity', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CenterOfGravity }{@code >}}
    */
    @XmlElementDecl( name = "CenterOfGravity", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CenterOfGravity> createCenterOfGravity( CenterOfGravity value) {
        return new JAXBElement<CenterOfGravity>( _CenterOfGravity_QNAME, CenterOfGravity.class, null, value);
    }
    // TypeWrapper{name='StowageHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link StowageHeight }{@code >}}
    */
    @XmlElementDecl( name = "StowageHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<StowageHeight> createStowageHeight( StowageHeight value) {
        return new JAXBElement<StowageHeight>( _StowageHeight_QNAME, StowageHeight.class, null, value);
    }
    // TypeWrapper{name='ReliefValvePressure', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ReliefValvePressure }{@code >}}
    */
    @XmlElementDecl( name = "ReliefValvePressure", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ReliefValvePressure> createReliefValvePressure( ReliefValvePressure value) {
        return new JAXBElement<ReliefValvePressure>( _ReliefValvePressure_QNAME, ReliefValvePressure.class, null, value);
    }
    // TypeWrapper{name='FillingHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FillingHeight }{@code >}}
    */
    @XmlElementDecl( name = "FillingHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FillingHeight> createFillingHeight( FillingHeight value) {
        return new JAXBElement<FillingHeight>( _FillingHeight_QNAME, FillingHeight.class, null, value);
    }
    // TypeWrapper{name='StowageFactor', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link StowageFactor }{@code >}}
    */
    @XmlElementDecl( name = "StowageFactor", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<StowageFactor> createStowageFactor( StowageFactor value) {
        return new JAXBElement<StowageFactor>( _StowageFactor_QNAME, StowageFactor.class, null, value);
    }
    // TypeWrapper{name='Permeability', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Permeability }{@code >}}
    */
    @XmlElementDecl( name = "Permeability", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Permeability> createPermeability( Permeability value) {
        return new JAXBElement<Permeability>( _Permeability_QNAME, Permeability.class, null, value);
    }
    // TypeWrapper{name='AngleOfRepose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link AngleOfRepose }{@code >}}
    */
    @XmlElementDecl( name = "AngleOfRepose", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<AngleOfRepose> createAngleOfRepose( AngleOfRepose value) {
        return new JAXBElement<AngleOfRepose>( _AngleOfRepose_QNAME, AngleOfRepose.class, null, value);
    }
    // TypeWrapper{name='GeometryRepresentation', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='GeometryRepresentation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='ReferenceSurfaces', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceSurfaces_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ReferenceSurfaces }{@code >}}
    */
    @XmlElementDecl( name = "ReferenceSurfaces", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ReferenceSurfaces> createReferenceSurfaces( ReferenceSurfaces value) {
        return new JAXBElement<ReferenceSurfaces>( _ReferenceSurfaces_QNAME, ReferenceSurfaces.class, null, value);
    }
    // TypeWrapper{name='Surface', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Cylinder3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Cylinder3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Cylinder3D }{@code >}}
    */
    @XmlElementDecl( name = "Cylinder3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Cylinder3D> createCylinder3D( Cylinder3D value) {
        return new JAXBElement<Cylinder3D>( _Cylinder3D_QNAME, Cylinder3D.class, null, value);
    }
    // TypeWrapper{name='Cone3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Cone3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Cone3D }{@code >}}
    */
    @XmlElementDecl( name = "Cone3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Cone3D> createCone3D( Cone3D value) {
        return new JAXBElement<Cone3D>( _Cone3D_QNAME, Cone3D.class, null, value);
    }
    // TypeWrapper{name='Sphere3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Sphere3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Sphere3D }{@code >}}
    */
    @XmlElementDecl( name = "Sphere3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Sphere3D> createSphere3D( Sphere3D value) {
        return new JAXBElement<Sphere3D>( _Sphere3D_QNAME, Sphere3D.class, null, value);
    }
    // TypeWrapper{name='ExtrudedSurface', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ExtrudedSurface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ExtrudedSurface }{@code >}}
    */
    @XmlElementDecl( name = "ExtrudedSurface", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ExtrudedSurface> createExtrudedSurface( ExtrudedSurface value) {
        return new JAXBElement<ExtrudedSurface>( _ExtrudedSurface_QNAME, ExtrudedSurface.class, null, value);
    }
    // TypeWrapper{name='Sweep', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Sweep_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Sweep }{@code >}}
    */
    @XmlElementDecl( name = "Sweep", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Sweep> createSweep( Sweep value) {
        return new JAXBElement<Sweep>( _Sweep_QNAME, Sweep.class, null, value);
    }
    // TypeWrapper{name='SweepCurve', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CompositeCurve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SweepCurve }{@code >}}
    */
    @XmlElementDecl( name = "SweepCurve", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SweepCurve> createSweepCurve( SweepCurve value) {
        return new JAXBElement<SweepCurve>( _SweepCurve_QNAME, SweepCurve.class, null, value);
    }
    // TypeWrapper{name='BaseCurve', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BaseCurve_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BaseCurve }{@code >}}
    */
    @XmlElementDecl( name = "BaseCurve", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BaseCurve> createBaseCurve( BaseCurve value) {
        return new JAXBElement<BaseCurve>( _BaseCurve_QNAME, BaseCurve.class, null, value);
    }
    // TypeWrapper{name='NURBSSurface', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSSurface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NURBSSurface }{@code >}}
    */
    @XmlElementDecl( name = "NURBSSurface", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NURBSSurface> createNURBSSurface( NURBSSurface value) {
        return new JAXBElement<NURBSSurface>( _NURBSSurface_QNAME, NURBSSurface.class, null, value);
    }
    // TypeWrapper{name='Plane3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Plane3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Plane3D }{@code >}}
    */
    @XmlElementDecl( name = "Plane3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Plane3D> createPlane3D( Plane3D value) {
        return new JAXBElement<Plane3D>( _Plane3D_QNAME, Plane3D.class, null, value);
    }
    // TypeWrapper{name='UnboundedGeometry', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnboundedGeometry_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UnboundedGeometry }{@code >}}
    */
    @XmlElementDecl( name = "UnboundedGeometry", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UnboundedGeometry> createUnboundedGeometry( UnboundedGeometry value) {
        return new JAXBElement<UnboundedGeometry>( _UnboundedGeometry_QNAME, UnboundedGeometry.class, null, value);
    }
    // TypeWrapper{name='SurfaceCollection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SurfaceCollection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SurfaceCollection }{@code >}}
    */
    @XmlElementDecl( name = "SurfaceCollection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SurfaceCollection> createSurfaceCollection( SurfaceCollection value) {
        return new JAXBElement<SurfaceCollection>( _SurfaceCollection_QNAME, SurfaceCollection.class, null, value);
    }
    // TypeWrapper{name='Tip', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Tip }{@code >}}
    */
    @XmlElementDecl( name = "Tip", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Tip> createTip( Tip value) {
        return new JAXBElement<Tip>( _Tip_QNAME, Tip.class, null, value);
    }
    // TypeWrapper{name='BaseRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BaseRadius }{@code >}}
    */
    @XmlElementDecl( name = "BaseRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BaseRadius> createBaseRadius( BaseRadius value) {
        return new JAXBElement<BaseRadius>( _BaseRadius_QNAME, BaseRadius.class, null, value);
    }
    // TypeWrapper{name='TipRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link TipRadius }{@code >}}
    */
    @XmlElementDecl( name = "TipRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<TipRadius> createTipRadius( TipRadius value) {
        return new JAXBElement<TipRadius>( _TipRadius_QNAME, TipRadius.class, null, value);
    }
    // TypeWrapper{name='Curve3D', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Circle3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Circle3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Circle3D }{@code >}}
    */
    @XmlElementDecl( name = "Circle3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Circle3D> createCircle3D( Circle3D value) {
        return new JAXBElement<Circle3D>( _Circle3D_QNAME, Circle3D.class, null, value);
    }
    // TypeWrapper{name='Ellipse3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Ellipse3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Ellipse3D }{@code >}}
    */
    @XmlElementDecl( name = "Ellipse3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Ellipse3D> createEllipse3D( Ellipse3D value) {
        return new JAXBElement<Ellipse3D>( _Ellipse3D_QNAME, Ellipse3D.class, null, value);
    }
    // TypeWrapper{name='CircumCircle3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CircumCircle3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CircumCircle3D }{@code >}}
    */
    @XmlElementDecl( name = "CircumCircle3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CircumCircle3D> createCircumCircle3D( CircumCircle3D value) {
        return new JAXBElement<CircumCircle3D>( _CircumCircle3D_QNAME, CircumCircle3D.class, null, value);
    }
    // TypeWrapper{name='PolyLine3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PolyLine3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PolyLine3D }{@code >}}
    */
    @XmlElementDecl( name = "PolyLine3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PolyLine3D> createPolyLine3D( PolyLine3D value) {
        return new JAXBElement<PolyLine3D>( _PolyLine3D_QNAME, PolyLine3D.class, null, value);
    }
    // TypeWrapper{name='Line3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Line3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Line3D }{@code >}}
    */
    @XmlElementDecl( name = "Line3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Line3D> createLine3D( Line3D value) {
        return new JAXBElement<Line3D>( _Line3D_QNAME, Line3D.class, null, value);
    }
    // TypeWrapper{name='CompositeCurve3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CompositeCurve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CompositeCurve3D }{@code >}}
    */
    @XmlElementDecl( name = "CompositeCurve3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CompositeCurve3D> createCompositeCurve3D( CompositeCurve3D value) {
        return new JAXBElement<CompositeCurve3D>( _CompositeCurve3D_QNAME, CompositeCurve3D.class, null, value);
    }
    // TypeWrapper{name='NURBS3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBS3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NURBS3D }{@code >}}
    */
    @XmlElementDecl( name = "NURBS3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NURBS3D> createNURBS3D( NURBS3D value) {
        return new JAXBElement<NURBS3D>( _NURBS3D_QNAME, NURBS3D.class, null, value);
    }
    // TypeWrapper{name='CircumArc3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CircumArc3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CircumArc3D }{@code >}}
    */
    @XmlElementDecl( name = "CircumArc3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CircumArc3D> createCircumArc3D( CircumArc3D value) {
        return new JAXBElement<CircumArc3D>( _CircumArc3D_QNAME, CircumArc3D.class, null, value);
    }
    // TypeWrapper{name='OuterContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link OuterContour }{@code >}}
    */
    @XmlElementDecl( name = "OuterContour", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<OuterContour> createOuterContour( OuterContour value) {
        return new JAXBElement<OuterContour>( _OuterContour_QNAME, OuterContour.class, null, value);
    }
    // TypeWrapper{name='InnerContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link InnerContour }{@code >}}
    */
    @XmlElementDecl( name = "InnerContour", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<InnerContour> createInnerContour( InnerContour value) {
        return new JAXBElement<InnerContour>( _InnerContour_QNAME, InnerContour.class, null, value);
    }
    // TypeWrapper{name='FreeEdgeCurve3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FreeEdgeCurve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FreeEdgeCurve3D }{@code >}}
    */
    @XmlElementDecl( name = "FreeEdgeCurve3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FreeEdgeCurve3D> createFreeEdgeCurve3D( FreeEdgeCurve3D value) {
        return new JAXBElement<FreeEdgeCurve3D>( _FreeEdgeCurve3D_QNAME, FreeEdgeCurve3D.class, null, value);
    }
    // TypeWrapper{name='FaceBoundaryCurve', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FaceBoundaryCurve }{@code >}}
    */
    @XmlElementDecl( name = "FaceBoundaryCurve", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FaceBoundaryCurve> createFaceBoundaryCurve( FaceBoundaryCurve value) {
        return new JAXBElement<FaceBoundaryCurve>( _FaceBoundaryCurve_QNAME, FaceBoundaryCurve.class, null, value);
    }
    // TypeWrapper{name='NURBSproperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NURBSproperties }{@code >}}
    */
    @XmlElementDecl( name = "NURBSproperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NURBSproperties> createNURBSproperties( NURBSproperties value) {
        return new JAXBElement<NURBSproperties>( _NURBSproperties_QNAME, NURBSproperties.class, null, value);
    }
    // TypeWrapper{name='V_NURBSproperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link VNURBSproperties }{@code >}}
    */
    @XmlElementDecl( name = "V_NURBSproperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<VNURBSproperties> createVNURBSproperties( VNURBSproperties value) {
        return new JAXBElement<VNURBSproperties>( _VNURBSproperties_QNAME, VNURBSproperties.class, null, value);
    }
    // TypeWrapper{name='U_NURBSproperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NURBSProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UNURBSproperties }{@code >}}
    */
    @XmlElementDecl( name = "U_NURBSproperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UNURBSproperties> createUNURBSproperties( UNURBSproperties value) {
        return new JAXBElement<UNURBSproperties>( _UNURBSproperties_QNAME, UNURBSproperties.class, null, value);
    }
    // TypeWrapper{name='KnotVector', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='KnotVector_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link KnotVector }{@code >}}
    */
    @XmlElementDecl( name = "KnotVector", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<KnotVector> createKnotVector( KnotVector value) {
        return new JAXBElement<KnotVector>( _KnotVector_QNAME, KnotVector.class, null, value);
    }
    // TypeWrapper{name='UknotVector', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='KnotVector_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UknotVector }{@code >}}
    */
    @XmlElementDecl( name = "UknotVector", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UknotVector> createUknotVector( UknotVector value) {
        return new JAXBElement<UknotVector>( _UknotVector_QNAME, UknotVector.class, null, value);
    }
    // TypeWrapper{name='VknotVector', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='KnotVector_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link VknotVector }{@code >}}
    */
    @XmlElementDecl( name = "VknotVector", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<VknotVector> createVknotVector( VknotVector value) {
        return new JAXBElement<VknotVector>( _VknotVector_QNAME, VknotVector.class, null, value);
    }
    // TypeWrapper{name='ControlPoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ControlPoint_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ControlPoint }{@code >}}
    */
    @XmlElementDecl( name = "ControlPoint", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ControlPoint> createControlPoint( ControlPoint value) {
        return new JAXBElement<ControlPoint>( _ControlPoint_QNAME, ControlPoint.class, null, value);
    }
    // TypeWrapper{name='ControlPtList', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ControlPtList_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ControlPtList }{@code >}}
    */
    @XmlElementDecl( name = "ControlPtList", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ControlPtList> createControlPtList( ControlPtList value) {
        return new JAXBElement<ControlPtList>( _ControlPtList_QNAME, ControlPtList.class, null, value);
    }
    // TypeWrapper{name='CurveLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CurveLength }{@code >}}
    */
    @XmlElementDecl( name = "CurveLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CurveLength> createCurveLength( CurveLength value) {
        return new JAXBElement<CurveLength>( _CurveLength_QNAME, CurveLength.class, null, value);
    }
    // TypeWrapper{name='SweepLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SweepLength }{@code >}}
    */
    @XmlElementDecl( name = "SweepLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SweepLength> createSweepLength( SweepLength value) {
        return new JAXBElement<SweepLength>( _SweepLength_QNAME, SweepLength.class, null, value);
    }
    // TypeWrapper{name='CoordinateSystem', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CoordinateSystem_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CoordinateSystem }{@code >}}
    */
    @XmlElementDecl( name = "CoordinateSystem", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CoordinateSystem> createCoordinateSystem( CoordinateSystem value) {
        return new JAXBElement<CoordinateSystem>( _CoordinateSystem_QNAME, CoordinateSystem.class, null, value);
    }
    // TypeWrapper{name='LocalCartesian', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Transformation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LocalCartesian }{@code >}}
    */
    @XmlElementDecl( name = "LocalCartesian", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LocalCartesian> createLocalCartesian( LocalCartesian value) {
        return new JAXBElement<LocalCartesian>( _LocalCartesian_QNAME, LocalCartesian.class, null, value);
    }
    // TypeWrapper{name='XRefPlanes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlanes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='DistanceToAP', typeName='DistanceToAP', docu='null', type=DistanceToAP, minOccurs=0, maxOccurs=1}]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link XRefPlanes }{@code >}}
    */
    @XmlElementDecl( name = "XRefPlanes", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<XRefPlanes> createXRefPlanes( XRefPlanes value) {
        return new JAXBElement<XRefPlanes>( _XRefPlanes_QNAME, XRefPlanes.class, null, value);
    }
    // TypeWrapper{name='YRefPlanes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlanes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link YRefPlanes }{@code >}}
    */
    @XmlElementDecl( name = "YRefPlanes", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<YRefPlanes> createYRefPlanes( YRefPlanes value) {
        return new JAXBElement<YRefPlanes>( _YRefPlanes_QNAME, YRefPlanes.class, null, value);
    }
    // TypeWrapper{name='ZRefPlanes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlanes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ZRefPlanes }{@code >}}
    */
    @XmlElementDecl( name = "ZRefPlanes", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ZRefPlanes> createZRefPlanes( ZRefPlanes value) {
        return new JAXBElement<ZRefPlanes>( _ZRefPlanes_QNAME, ZRefPlanes.class, null, value);
    }
    // TypeWrapper{name='CylindricalAxes', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CylindricalAxes_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CylindricalAxes }{@code >}}
    */
    @XmlElementDecl( name = "CylindricalAxes", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CylindricalAxes> createCylindricalAxes( CylindricalAxes value) {
        return new JAXBElement<CylindricalAxes>( _CylindricalAxes_QNAME, CylindricalAxes.class, null, value);
    }
    // TypeWrapper{name='RadialCylinder', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RadialCylinder_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RadialCylinder }{@code >}}
    */
    @XmlElementDecl( name = "RadialCylinder", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RadialCylinder> createRadialCylinder( RadialCylinder value) {
        return new JAXBElement<RadialCylinder>( _RadialCylinder_QNAME, RadialCylinder.class, null, value);
    }
    // TypeWrapper{name='Transformation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Transformation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Transformation }{@code >}}
    */
    @XmlElementDecl( name = "Transformation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Transformation> createTransformation( Transformation value) {
        return new JAXBElement<Transformation>( _Transformation_QNAME, Transformation.class, null, value);
    }
    // TypeWrapper{name='RefPlane', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlane_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RefPlane }{@code >}}
    */
    @XmlElementDecl( name = "RefPlane", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RefPlane> createRefPlane( RefPlane value) {
        return new JAXBElement<RefPlane>( _RefPlane_QNAME, RefPlane.class, null, value);
    }
    // TypeWrapper{name='DistanceToAP', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DistanceToAP }{@code >}}
    */
    @XmlElementDecl( name = "DistanceToAP", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DistanceToAP> createDistanceToAP( DistanceToAP value) {
        return new JAXBElement<DistanceToAP>( _DistanceToAP_QNAME, DistanceToAP.class, null, value);
    }
    // TypeWrapper{name='MajorAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MajorAxis }{@code >}}
    */
    @XmlElementDecl( name = "MajorAxis", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MajorAxis> createMajorAxis( MajorAxis value) {
        return new JAXBElement<MajorAxis>( _MajorAxis_QNAME, MajorAxis.class, null, value);
    }
    // TypeWrapper{name='MinorAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MinorAxis }{@code >}}
    */
    @XmlElementDecl( name = "MinorAxis", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MinorAxis> createMinorAxis( MinorAxis value) {
        return new JAXBElement<MinorAxis>( _MinorAxis_QNAME, MinorAxis.class, null, value);
    }
    // TypeWrapper{name='Vector3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Vector3D }{@code >}}
    */
    @XmlElementDecl( name = "Vector3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Vector3D> createVector3D( Vector3D value) {
        return new JAXBElement<Vector3D>( _Vector3D_QNAME, Vector3D.class, null, value);
    }
    // TypeWrapper{name='SecondaryAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SecondaryAxis }{@code >}}
    */
    @XmlElementDecl( name = "SecondaryAxis", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SecondaryAxis> createSecondaryAxis( SecondaryAxis value) {
        return new JAXBElement<SecondaryAxis>( _SecondaryAxis_QNAME, SecondaryAxis.class, null, value);
    }
    // TypeWrapper{name='PrimaryAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PrimaryAxis }{@code >}}
    */
    @XmlElementDecl( name = "PrimaryAxis", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PrimaryAxis> createPrimaryAxis( PrimaryAxis value) {
        return new JAXBElement<PrimaryAxis>( _PrimaryAxis_QNAME, PrimaryAxis.class, null, value);
    }
    // TypeWrapper{name='Origin', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Origin }{@code >}}
    */
    @XmlElementDecl( name = "Origin", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Origin> createOrigin( Origin value) {
        return new JAXBElement<Origin>( _Origin_QNAME, Origin.class, null, value);
    }
    // TypeWrapper{name='Center', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Center }{@code >}}
    */
    @XmlElementDecl( name = "Center", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Center> createCenter( Center value) {
        return new JAXBElement<Center>( _Center_QNAME, Center.class, null, value);
    }
    // TypeWrapper{name='Normal', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Normal }{@code >}}
    */
    @XmlElementDecl( name = "Normal", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Normal> createNormal( Normal value) {
        return new JAXBElement<Normal>( _Normal_QNAME, Normal.class, null, value);
    }
    // TypeWrapper{name='Point3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Point3D }{@code >}}
    */
    @XmlElementDecl( name = "Point3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Point3D> createPoint3D( Point3D value) {
        return new JAXBElement<Point3D>( _Point3D_QNAME, Point3D.class, null, value);
    }
    // TypeWrapper{name='X', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link X }{@code >}}
    */
    @XmlElementDecl( name = "X", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<X> createX( X value) {
        return new JAXBElement<X>( _X_QNAME, X.class, null, value);
    }
    // TypeWrapper{name='Y', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Y }{@code >}}
    */
    @XmlElementDecl( name = "Y", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Y> createY( Y value) {
        return new JAXBElement<Y>( _Y_QNAME, Y.class, null, value);
    }
    // TypeWrapper{name='Z', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Z }{@code >}}
    */
    @XmlElementDecl( name = "Z", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Z> createZ( Z value) {
        return new JAXBElement<Z>( _Z_QNAME, Z.class, null, value);
    }
    // TypeWrapper{name='ContourBounds', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ContourBounds_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ContourBounds }{@code >}}
    */
    @XmlElementDecl( name = "ContourBounds", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ContourBounds> createContourBounds( ContourBounds value) {
        return new JAXBElement<ContourBounds>( _ContourBounds_QNAME, ContourBounds.class, null, value);
    }
    // TypeWrapper{name='ContourStart', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ContourStart }{@code >}}
    */
    @XmlElementDecl( name = "ContourStart", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ContourStart> createContourStart( ContourStart value) {
        return new JAXBElement<ContourStart>( _ContourStart_QNAME, ContourStart.class, null, value);
    }
    // TypeWrapper{name='ContourEnd', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ContourEnd }{@code >}}
    */
    @XmlElementDecl( name = "ContourEnd", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ContourEnd> createContourEnd( ContourEnd value) {
        return new JAXBElement<ContourEnd>( _ContourEnd_QNAME, ContourEnd.class, null, value);
    }
    // TypeWrapper{name='ClassCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ClassCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ClassCatalogue }{@code >}}
    */
    @XmlElementDecl( name = "ClassCatalogue", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ClassCatalogue> createClassCatalogue( ClassCatalogue value) {
        return new JAXBElement<ClassCatalogue>( _ClassCatalogue_QNAME, ClassCatalogue.class, null, value);
    }
    // TypeWrapper{name='MaterialCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='MaterialCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MaterialCatalogue }{@code >}}
    */
    @XmlElementDecl( name = "MaterialCatalogue", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MaterialCatalogue> createMaterialCatalogue( MaterialCatalogue value) {
        return new JAXBElement<MaterialCatalogue>( _MaterialCatalogue_QNAME, MaterialCatalogue.class, null, value);
    }
    // TypeWrapper{name='XSectionCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='XSectionCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link XSectionCatalogue }{@code >}}
    */
    @XmlElementDecl( name = "XSectionCatalogue", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<XSectionCatalogue> createXSectionCatalogue( XSectionCatalogue value) {
        return new JAXBElement<XSectionCatalogue>( _XSectionCatalogue_QNAME, XSectionCatalogue.class, null, value);
    }
    // TypeWrapper{name='PrincipalParticulars', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PrincipalParticulars_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PrincipalParticulars }{@code >}}
    */
    @XmlElementDecl( name = "PrincipalParticulars", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PrincipalParticulars> createPrincipalParticulars( PrincipalParticulars value) {
        return new JAXBElement<PrincipalParticulars>( _PrincipalParticulars_QNAME, PrincipalParticulars.class, null, value);
    }
    // TypeWrapper{name='HoleShapeCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HoleShapeCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link HoleShapeCatalogue }{@code >}}
    */
    @XmlElementDecl( name = "HoleShapeCatalogue", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<HoleShapeCatalogue> createHoleShapeCatalogue( HoleShapeCatalogue value) {
        return new JAXBElement<HoleShapeCatalogue>( _HoleShapeCatalogue_QNAME, HoleShapeCatalogue.class, null, value);
    }
    // TypeWrapper{name='ParametricHole2D', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ParametricHole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='Hole2D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Hole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Hole2D }{@code >}}
    */
    @XmlElementDecl( name = "Hole2D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Hole2D> createHole2D( Hole2D value) {
        return new JAXBElement<Hole2D>( _Hole2D_QNAME, Hole2D.class, null, value);
    }
    // TypeWrapper{name='ParametricCircle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ParametricCircle_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ParametricCircle }{@code >}}
    */
    @XmlElementDecl( name = "ParametricCircle", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ParametricCircle> createParametricCircle( ParametricCircle value) {
        return new JAXBElement<ParametricCircle>( _ParametricCircle_QNAME, ParametricCircle.class, null, value);
    }
    // TypeWrapper{name='SymmetricalHole', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SymmetricalHole_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SymmetricalHole }{@code >}}
    */
    @XmlElementDecl( name = "SymmetricalHole", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SymmetricalHole> createSymmetricalHole( SymmetricalHole value) {
        return new JAXBElement<SymmetricalHole>( _SymmetricalHole_QNAME, SymmetricalHole.class, null, value);
    }
    // TypeWrapper{name='SuperElliptical', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SuperElliptical_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SuperElliptical }{@code >}}
    */
    @XmlElementDecl( name = "SuperElliptical", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SuperElliptical> createSuperElliptical( SuperElliptical value) {
        return new JAXBElement<SuperElliptical>( _SuperElliptical_QNAME, SuperElliptical.class, null, value);
    }
    // TypeWrapper{name='RectangularHole', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RectangularHole_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RectangularHole }{@code >}}
    */
    @XmlElementDecl( name = "RectangularHole", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RectangularHole> createRectangularHole( RectangularHole value) {
        return new JAXBElement<RectangularHole>( _RectangularHole_QNAME, RectangularHole.class, null, value);
    }
    // TypeWrapper{name='RectangularMickeyMouseEars', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RectangularMickeyMouseEars_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RectangularMickeyMouseEars }{@code >}}
    */
    @XmlElementDecl( name = "RectangularMickeyMouseEars", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RectangularMickeyMouseEars> createRectangularMickeyMouseEars( RectangularMickeyMouseEars value) {
        return new JAXBElement<RectangularMickeyMouseEars>( _RectangularMickeyMouseEars_QNAME, RectangularMickeyMouseEars.class, null, value);
    }
    // TypeWrapper{name='Material', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Material_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Material }{@code >}}
    */
    @XmlElementDecl( name = "Material", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Material> createMaterial( Material value) {
        return new JAXBElement<Material>( _Material_QNAME, Material.class, null, value);
    }
    // TypeWrapper{name='BarSection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BarSection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BarSection }{@code >}}
    */
    @XmlElementDecl( name = "BarSection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BarSection> createBarSection( BarSection value) {
        return new JAXBElement<BarSection>( _BarSection_QNAME, BarSection.class, null, value);
    }
    // TypeWrapper{name='BulbFlat', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BulbFlat_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulbFlat }{@code >}}
    */
    @XmlElementDecl( name = "BulbFlat", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulbFlat> createBulbFlat( BulbFlat value) {
        return new JAXBElement<BulbFlat>( _BulbFlat_QNAME, BulbFlat.class, null, value);
    }
    // TypeWrapper{name='FlatBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FlatBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlatBar }{@code >}}
    */
    @XmlElementDecl( name = "FlatBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlatBar> createFlatBar( FlatBar value) {
        return new JAXBElement<FlatBar>( _FlatBar_QNAME, FlatBar.class, null, value);
    }
    // TypeWrapper{name='LBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LBar }{@code >}}
    */
    @XmlElementDecl( name = "LBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LBar> createLBar( LBar value) {
        return new JAXBElement<LBar>( _LBar_QNAME, LBar.class, null, value);
    }
    // TypeWrapper{name='LBarOW', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LBarOW_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LBarOW }{@code >}}
    */
    @XmlElementDecl( name = "LBarOW", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LBarOW> createLBarOW( LBarOW value) {
        return new JAXBElement<LBarOW>( _LBarOW_QNAME, LBarOW.class, null, value);
    }
    // TypeWrapper{name='LBarOF', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LBarOF_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LBarOF }{@code >}}
    */
    @XmlElementDecl( name = "LBarOF", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LBarOF> createLBarOF( LBarOF value) {
        return new JAXBElement<LBarOF>( _LBarOF_QNAME, LBarOF.class, null, value);
    }
    // TypeWrapper{name='TBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link TBar }{@code >}}
    */
    @XmlElementDecl( name = "TBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<TBar> createTBar( TBar value) {
        return new JAXBElement<TBar>( _TBar_QNAME, TBar.class, null, value);
    }
    // TypeWrapper{name='UBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UBar }{@code >}}
    */
    @XmlElementDecl( name = "UBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UBar> createUBar( UBar value) {
        return new JAXBElement<UBar>( _UBar_QNAME, UBar.class, null, value);
    }
    // TypeWrapper{name='IBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='IBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link IBar }{@code >}}
    */
    @XmlElementDecl( name = "IBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<IBar> createIBar( IBar value) {
        return new JAXBElement<IBar>( _IBar_QNAME, IBar.class, null, value);
    }
    // TypeWrapper{name='ZBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ZBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ZBar }{@code >}}
    */
    @XmlElementDecl( name = "ZBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ZBar> createZBar( ZBar value) {
        return new JAXBElement<ZBar>( _ZBar_QNAME, ZBar.class, null, value);
    }
    // TypeWrapper{name='RoundBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RoundBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RoundBar }{@code >}}
    */
    @XmlElementDecl( name = "RoundBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RoundBar> createRoundBar( RoundBar value) {
        return new JAXBElement<RoundBar>( _RoundBar_QNAME, RoundBar.class, null, value);
    }
    // TypeWrapper{name='HalfRoundBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HalfRoundBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link HalfRoundBar }{@code >}}
    */
    @XmlElementDecl( name = "HalfRoundBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<HalfRoundBar> createHalfRoundBar( HalfRoundBar value) {
        return new JAXBElement<HalfRoundBar>( _HalfRoundBar_QNAME, HalfRoundBar.class, null, value);
    }
    // TypeWrapper{name='SquareBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SquareBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SquareBar }{@code >}}
    */
    @XmlElementDecl( name = "SquareBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SquareBar> createSquareBar( SquareBar value) {
        return new JAXBElement<SquareBar>( _SquareBar_QNAME, SquareBar.class, null, value);
    }
    // TypeWrapper{name='HexagonBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HexagonBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link HexagonBar }{@code >}}
    */
    @XmlElementDecl( name = "HexagonBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<HexagonBar> createHexagonBar( HexagonBar value) {
        return new JAXBElement<HexagonBar>( _HexagonBar_QNAME, HexagonBar.class, null, value);
    }
    // TypeWrapper{name='OctagonBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='OctagonBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link OctagonBar }{@code >}}
    */
    @XmlElementDecl( name = "OctagonBar", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<OctagonBar> createOctagonBar( OctagonBar value) {
        return new JAXBElement<OctagonBar>( _OctagonBar_QNAME, OctagonBar.class, null, value);
    }
    // TypeWrapper{name='Tube', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Tube_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Tube }{@code >}}
    */
    @XmlElementDecl( name = "Tube", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Tube> createTube( Tube value) {
        return new JAXBElement<Tube>( _Tube_QNAME, Tube.class, null, value);
    }
    // TypeWrapper{name='RectangularTube', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RectangularTube_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RectangularTube }{@code >}}
    */
    @XmlElementDecl( name = "RectangularTube", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RectangularTube> createRectangularTube( RectangularTube value) {
        return new JAXBElement<RectangularTube>( _RectangularTube_QNAME, RectangularTube.class, null, value);
    }
    // TypeWrapper{name='UserDefinedBarSection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UserDefinedBarSection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UserDefinedBarSection }{@code >}}
    */
    @XmlElementDecl( name = "UserDefinedBarSection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UserDefinedBarSection> createUserDefinedBarSection( UserDefinedBarSection value) {
        return new JAXBElement<UserDefinedBarSection>( _UserDefinedBarSection_QNAME, UserDefinedBarSection.class, null, value);
    }
    // TypeWrapper{name='SectionProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SectionProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SectionProperties }{@code >}}
    */
    @XmlElementDecl( name = "SectionProperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SectionProperties> createSectionProperties( SectionProperties value) {
        return new JAXBElement<SectionProperties>( _SectionProperties_QNAME, SectionProperties.class, null, value);
    }
    // TypeWrapper{name='UserDefinedParameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UserDefinedParameter_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UserDefinedParameter }{@code >}}
    */
    @XmlElementDecl( name = "UserDefinedParameter", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UserDefinedParameter> createUserDefinedParameter( UserDefinedParameter value) {
        return new JAXBElement<UserDefinedParameter>( _UserDefinedParameter_QNAME, UserDefinedParameter.class, null, value);
    }
    // TypeWrapper{name='BuilderInformation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BuilderInformation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BuilderInformation }{@code >}}
    */
    @XmlElementDecl( name = "BuilderInformation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BuilderInformation> createBuilderInformation( BuilderInformation value) {
        return new JAXBElement<BuilderInformation>( _BuilderInformation_QNAME, BuilderInformation.class, null, value);
    }
    // TypeWrapper{name='ShipDesignation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ShipDesignation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ShipDesignation }{@code >}}
    */
    @XmlElementDecl( name = "ShipDesignation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ShipDesignation> createShipDesignation( ShipDesignation value) {
        return new JAXBElement<ShipDesignation>( _ShipDesignation_QNAME, ShipDesignation.class, null, value);
    }
    // TypeWrapper{name='Quantity', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // TypeWrapper{name='DistanceTolerance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DistanceTolerance }{@code >}}
    */
    @XmlElementDecl( name = "DistanceTolerance", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DistanceTolerance> createDistanceTolerance( DistanceTolerance value) {
        return new JAXBElement<DistanceTolerance>( _DistanceTolerance_QNAME, DistanceTolerance.class, null, value);
    }
    // TypeWrapper{name='AngleTolerance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link AngleTolerance }{@code >}}
    */
    @XmlElementDecl( name = "AngleTolerance", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<AngleTolerance> createAngleTolerance( AngleTolerance value) {
        return new JAXBElement<AngleTolerance>( _AngleTolerance_QNAME, AngleTolerance.class, null, value);
    }
    // TypeWrapper{name='TonnageData', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TonnageData_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link TonnageData }{@code >}}
    */
    @XmlElementDecl( name = "TonnageData", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<TonnageData> createTonnageData( TonnageData value) {
        return new JAXBElement<TonnageData>( _TonnageData_QNAME, TonnageData.class, null, value);
    }
    // TypeWrapper{name='StatutoryData', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StatutoryData_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link StatutoryData }{@code >}}
    */
    @XmlElementDecl( name = "StatutoryData", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<StatutoryData> createStatutoryData( StatutoryData value) {
        return new JAXBElement<StatutoryData>( _StatutoryData_QNAME, StatutoryData.class, null, value);
    }
    // TypeWrapper{name='ClassificationData', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ClassData_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ClassificationData }{@code >}}
    */
    @XmlElementDecl( name = "ClassificationData", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ClassificationData> createClassificationData( ClassificationData value) {
        return new JAXBElement<ClassificationData>( _ClassificationData_QNAME, ClassificationData.class, null, value);
    }
    // TypeWrapper{name='ClassNotation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ClassNotation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ClassNotation }{@code >}}
    */
    @XmlElementDecl( name = "ClassNotation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ClassNotation> createClassNotation( ClassNotation value) {
        return new JAXBElement<ClassNotation>( _ClassNotation_QNAME, ClassNotation.class, null, value);
    }
    // TypeWrapper{name='Radius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Radius }{@code >}}
    */
    @XmlElementDecl( name = "Radius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Radius> createRadius( Radius value) {
        return new JAXBElement<Radius>( _Radius_QNAME, Radius.class, null, value);
    }
    // TypeWrapper{name='NetArea', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NetArea }{@code >}}
    */
    @XmlElementDecl( name = "NetArea", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NetArea> createNetArea( NetArea value) {
        return new JAXBElement<NetArea>( _NetArea_QNAME, NetArea.class, null, value);
    }
    // TypeWrapper{name='Area', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Area }{@code >}}
    */
    @XmlElementDecl( name = "Area", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Area> createArea( Area value) {
        return new JAXBElement<Area>( _Area_QNAME, Area.class, null, value);
    }
    // TypeWrapper{name='ArmLengthU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ArmLengthU }{@code >}}
    */
    @XmlElementDecl( name = "ArmLengthU", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ArmLengthU> createArmLengthU( ArmLengthU value) {
        return new JAXBElement<ArmLengthU>( _ArmLengthU_QNAME, ArmLengthU.class, null, value);
    }
    // TypeWrapper{name='ArmLengthV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ArmLengthV }{@code >}}
    */
    @XmlElementDecl( name = "ArmLengthV", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ArmLengthV> createArmLengthV( ArmLengthV value) {
        return new JAXBElement<ArmLengthV>( _ArmLengthV_QNAME, ArmLengthV.class, null, value);
    }
    // TypeWrapper{name='Unose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Unose }{@code >}}
    */
    @XmlElementDecl( name = "Unose", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Unose> createUnose( Unose value) {
        return new JAXBElement<Unose>( _Unose_QNAME, Unose.class, null, value);
    }
    // TypeWrapper{name='Vnose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Vnose }{@code >}}
    */
    @XmlElementDecl( name = "Vnose", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Vnose> createVnose( Vnose value) {
        return new JAXBElement<Vnose>( _Vnose_QNAME, Vnose.class, null, value);
    }
    // TypeWrapper{name='FreeEdgeRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FreeEdgeRadius }{@code >}}
    */
    @XmlElementDecl( name = "FreeEdgeRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FreeEdgeRadius> createFreeEdgeRadius( FreeEdgeRadius value) {
        return new JAXBElement<FreeEdgeRadius>( _FreeEdgeRadius_QNAME, FreeEdgeRadius.class, null, value);
    }
    // TypeWrapper{name='CopeHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CopeHeight }{@code >}}
    */
    @XmlElementDecl( name = "CopeHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CopeHeight> createCopeHeight( CopeHeight value) {
        return new JAXBElement<CopeHeight>( _CopeHeight_QNAME, CopeHeight.class, null, value);
    }
    // TypeWrapper{name='CopeRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CopeRadius }{@code >}}
    */
    @XmlElementDecl( name = "CopeRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CopeRadius> createCopeRadius( CopeRadius value) {
        return new JAXBElement<CopeRadius>( _CopeRadius_QNAME, CopeRadius.class, null, value);
    }
    // TypeWrapper{name='FlangeCutBackAngle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlangeCutBackAngle }{@code >}}
    */
    @XmlElementDecl( name = "FlangeCutBackAngle", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlangeCutBackAngle> createFlangeCutBackAngle( FlangeCutBackAngle value) {
        return new JAXBElement<FlangeCutBackAngle>( _FlangeCutBackAngle_QNAME, FlangeCutBackAngle.class, null, value);
    }
    // TypeWrapper{name='WebCutBackAngle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebCutBackAngle }{@code >}}
    */
    @XmlElementDecl( name = "WebCutBackAngle", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebCutBackAngle> createWebCutBackAngle( WebCutBackAngle value) {
        return new JAXBElement<WebCutBackAngle>( _WebCutBackAngle_QNAME, WebCutBackAngle.class, null, value);
    }
    // TypeWrapper{name='FlangeNoseHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlangeNoseHeight }{@code >}}
    */
    @XmlElementDecl( name = "FlangeNoseHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlangeNoseHeight> createFlangeNoseHeight( FlangeNoseHeight value) {
        return new JAXBElement<FlangeNoseHeight>( _FlangeNoseHeight_QNAME, FlangeNoseHeight.class, null, value);
    }
    // TypeWrapper{name='WebNoseHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebNoseHeight }{@code >}}
    */
    @XmlElementDecl( name = "WebNoseHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebNoseHeight> createWebNoseHeight( WebNoseHeight value) {
        return new JAXBElement<WebNoseHeight>( _WebNoseHeight_QNAME, WebNoseHeight.class, null, value);
    }
    // TypeWrapper{name='CutbackDistance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CutbackDistance }{@code >}}
    */
    @XmlElementDecl( name = "CutbackDistance", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CutbackDistance> createCutbackDistance( CutbackDistance value) {
        return new JAXBElement<CutbackDistance>( _CutbackDistance_QNAME, CutbackDistance.class, null, value);
    }
    // TypeWrapper{name='CopeLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CopeLength }{@code >}}
    */
    @XmlElementDecl( name = "CopeLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CopeLength> createCopeLength( CopeLength value) {
        return new JAXBElement<CopeLength>( _CopeLength_QNAME, CopeLength.class, null, value);
    }
    // TypeWrapper{name='DryWeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DryWeight }{@code >}}
    */
    @XmlElementDecl( name = "DryWeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DryWeight> createDryWeight( DryWeight value) {
        return new JAXBElement<DryWeight>( _DryWeight_QNAME, DryWeight.class, null, value);
    }
    // TypeWrapper{name='UpperRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UpperRadius }{@code >}}
    */
    @XmlElementDecl( name = "UpperRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UpperRadius> createUpperRadius( UpperRadius value) {
        return new JAXBElement<UpperRadius>( _UpperRadius_QNAME, UpperRadius.class, null, value);
    }
    // TypeWrapper{name='LowerRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LowerRadius }{@code >}}
    */
    @XmlElementDecl( name = "LowerRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LowerRadius> createLowerRadius( LowerRadius value) {
        return new JAXBElement<LowerRadius>( _LowerRadius_QNAME, LowerRadius.class, null, value);
    }
    // TypeWrapper{name='Tonnage', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Tonnage }{@code >}}
    */
    @XmlElementDecl( name = "Tonnage", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Tonnage> createTonnage( Tonnage value) {
        return new JAXBElement<Tonnage>( _Tonnage_QNAME, Tonnage.class, null, value);
    }
    // TypeWrapper{name='Width', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Width }{@code >}}
    */
    @XmlElementDecl( name = "Width", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Width> createWidth( Width value) {
        return new JAXBElement<Width>( _Width_QNAME, Width.class, null, value);
    }
    // TypeWrapper{name='Height', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Height }{@code >}}
    */
    @XmlElementDecl( name = "Height", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Height> createHeight( Height value) {
        return new JAXBElement<Height>( _Height_QNAME, Height.class, null, value);
    }
    // TypeWrapper{name='Thickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Thickness }{@code >}}
    */
    @XmlElementDecl( name = "Thickness", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Thickness> createThickness( Thickness value) {
        return new JAXBElement<Thickness>( _Thickness_QNAME, Thickness.class, null, value);
    }
    // TypeWrapper{name='DeadWeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DeadWeight }{@code >}}
    */
    @XmlElementDecl( name = "DeadWeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DeadWeight> createDeadWeight( DeadWeight value) {
        return new JAXBElement<DeadWeight>( _DeadWeight_QNAME, DeadWeight.class, null, value);
    }
    // TypeWrapper{name='WebThickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebThickness }{@code >}}
    */
    @XmlElementDecl( name = "WebThickness", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebThickness> createWebThickness( WebThickness value) {
        return new JAXBElement<WebThickness>( _WebThickness_QNAME, WebThickness.class, null, value);
    }
    // TypeWrapper{name='FlangeWidth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlangeWidth }{@code >}}
    */
    @XmlElementDecl( name = "FlangeWidth", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlangeWidth> createFlangeWidth( FlangeWidth value) {
        return new JAXBElement<FlangeWidth>( _FlangeWidth_QNAME, FlangeWidth.class, null, value);
    }
    // TypeWrapper{name='BulbAngle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulbAngle }{@code >}}
    */
    @XmlElementDecl( name = "BulbAngle", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulbAngle> createBulbAngle( BulbAngle value) {
        return new JAXBElement<BulbAngle>( _BulbAngle_QNAME, BulbAngle.class, null, value);
    }
    // TypeWrapper{name='BulbOuterRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulbOuterRadius }{@code >}}
    */
    @XmlElementDecl( name = "BulbOuterRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulbOuterRadius> createBulbOuterRadius( BulbOuterRadius value) {
        return new JAXBElement<BulbOuterRadius>( _BulbOuterRadius_QNAME, BulbOuterRadius.class, null, value);
    }
    // TypeWrapper{name='BulbInnerRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulbInnerRadius }{@code >}}
    */
    @XmlElementDecl( name = "BulbInnerRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulbInnerRadius> createBulbInnerRadius( BulbInnerRadius value) {
        return new JAXBElement<BulbInnerRadius>( _BulbInnerRadius_QNAME, BulbInnerRadius.class, null, value);
    }
    // TypeWrapper{name='BulbTopRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulbTopRadius }{@code >}}
    */
    @XmlElementDecl( name = "BulbTopRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulbTopRadius> createBulbTopRadius( BulbTopRadius value) {
        return new JAXBElement<BulbTopRadius>( _BulbTopRadius_QNAME, BulbTopRadius.class, null, value);
    }
    // TypeWrapper{name='BulbBottomRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BulbBottomRadius }{@code >}}
    */
    @XmlElementDecl( name = "BulbBottomRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BulbBottomRadius> createBulbBottomRadius( BulbBottomRadius value) {
        return new JAXBElement<BulbBottomRadius>( _BulbBottomRadius_QNAME, BulbBottomRadius.class, null, value);
    }
    // TypeWrapper{name='FilletRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FilletRadius }{@code >}}
    */
    @XmlElementDecl( name = "FilletRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FilletRadius> createFilletRadius( FilletRadius value) {
        return new JAXBElement<FilletRadius>( _FilletRadius_QNAME, FilletRadius.class, null, value);
    }
    // TypeWrapper{name='Diameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Diameter }{@code >}}
    */
    @XmlElementDecl( name = "Diameter", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Diameter> createDiameter( Diameter value) {
        return new JAXBElement<Diameter>( _Diameter_QNAME, Diameter.class, null, value);
    }
    // TypeWrapper{name='Contour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Contour }{@code >}}
    */
    @XmlElementDecl( name = "Contour", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Contour> createContour( Contour value) {
        return new JAXBElement<Contour>( _Contour_QNAME, Contour.class, null, value);
    }
    // TypeWrapper{name='Lpp', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Lpp }{@code >}}
    */
    @XmlElementDecl( name = "Lpp", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Lpp> createLpp( Lpp value) {
        return new JAXBElement<Lpp>( _Lpp_QNAME, Lpp.class, null, value);
    }
    // TypeWrapper{name='RuleLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RuleLength }{@code >}}
    */
    @XmlElementDecl( name = "RuleLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<RuleLength> createRuleLength( RuleLength value) {
        return new JAXBElement<RuleLength>( _RuleLength_QNAME, RuleLength.class, null, value);
    }
    // TypeWrapper{name='BlockCoefficient', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link BlockCoefficient }{@code >}}
    */
    @XmlElementDecl( name = "BlockCoefficient", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<BlockCoefficient> createBlockCoefficient( BlockCoefficient value) {
        return new JAXBElement<BlockCoefficient>( _BlockCoefficient_QNAME, BlockCoefficient.class, null, value);
    }
    // TypeWrapper{name='FP_Pos', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FPPos }{@code >}}
    */
    @XmlElementDecl( name = "FP_Pos", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FPPos> createFPPos( FPPos value) {
        return new JAXBElement<FPPos>( _FPPos_QNAME, FPPos.class, null, value);
    }
    // TypeWrapper{name='MouldedBreadth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MouldedBreadth }{@code >}}
    */
    @XmlElementDecl( name = "MouldedBreadth", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MouldedBreadth> createMouldedBreadth( MouldedBreadth value) {
        return new JAXBElement<MouldedBreadth>( _MouldedBreadth_QNAME, MouldedBreadth.class, null, value);
    }
    // TypeWrapper{name='MouldedDepth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MouldedDepth }{@code >}}
    */
    @XmlElementDecl( name = "MouldedDepth", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MouldedDepth> createMouldedDepth( MouldedDepth value) {
        return new JAXBElement<MouldedDepth>( _MouldedDepth_QNAME, MouldedDepth.class, null, value);
    }
    // TypeWrapper{name='ScantlingDraught', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ScantlingDraught }{@code >}}
    */
    @XmlElementDecl( name = "ScantlingDraught", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ScantlingDraught> createScantlingDraught( ScantlingDraught value) {
        return new JAXBElement<ScantlingDraught>( _ScantlingDraught_QNAME, ScantlingDraught.class, null, value);
    }
    // TypeWrapper{name='DesignSpeed', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DesignSpeed }{@code >}}
    */
    @XmlElementDecl( name = "DesignSpeed", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DesignSpeed> createDesignSpeed( DesignSpeed value) {
        return new JAXBElement<DesignSpeed>( _DesignSpeed_QNAME, DesignSpeed.class, null, value);
    }
    // TypeWrapper{name='FreeboardLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FreeboardLength }{@code >}}
    */
    @XmlElementDecl( name = "FreeboardLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FreeboardLength> createFreeboardLength( FreeboardLength value) {
        return new JAXBElement<FreeboardLength>( _FreeboardLength_QNAME, FreeboardLength.class, null, value);
    }
    // TypeWrapper{name='NormalBallastDraught', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NormalBallastDraught }{@code >}}
    */
    @XmlElementDecl( name = "NormalBallastDraught", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NormalBallastDraught> createNormalBallastDraught( NormalBallastDraught value) {
        return new JAXBElement<NormalBallastDraught>( _NormalBallastDraught_QNAME, NormalBallastDraught.class, null, value);
    }
    // TypeWrapper{name='HeavyBallastDraught', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link HeavyBallastDraught }{@code >}}
    */
    @XmlElementDecl( name = "HeavyBallastDraught", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<HeavyBallastDraught> createHeavyBallastDraught( HeavyBallastDraught value) {
        return new JAXBElement<HeavyBallastDraught>( _HeavyBallastDraught_QNAME, HeavyBallastDraught.class, null, value);
    }
    // TypeWrapper{name='SlammingDraughtEmptyFP', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SlammingDraughtEmptyFP }{@code >}}
    */
    @XmlElementDecl( name = "SlammingDraughtEmptyFP", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SlammingDraughtEmptyFP> createSlammingDraughtEmptyFP( SlammingDraughtEmptyFP value) {
        return new JAXBElement<SlammingDraughtEmptyFP>( _SlammingDraughtEmptyFP_QNAME, SlammingDraughtEmptyFP.class, null, value);
    }
    // TypeWrapper{name='SlammingDraughtFullFP', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SlammingDraughtFullFP }{@code >}}
    */
    @XmlElementDecl( name = "SlammingDraughtFullFP", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SlammingDraughtFullFP> createSlammingDraughtFullFP( SlammingDraughtFullFP value) {
        return new JAXBElement<SlammingDraughtFullFP>( _SlammingDraughtFullFP_QNAME, SlammingDraughtFullFP.class, null, value);
    }
    // TypeWrapper{name='LengthOfWaterline', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LengthOfWaterline }{@code >}}
    */
    @XmlElementDecl( name = "LengthOfWaterline", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<LengthOfWaterline> createLengthOfWaterline( LengthOfWaterline value) {
        return new JAXBElement<LengthOfWaterline>( _LengthOfWaterline_QNAME, LengthOfWaterline.class, null, value);
    }
    // TypeWrapper{name='FreeboardDeckHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FreeboardDeckHeight }{@code >}}
    */
    @XmlElementDecl( name = "FreeboardDeckHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FreeboardDeckHeight> createFreeboardDeckHeight( FreeboardDeckHeight value) {
        return new JAXBElement<FreeboardDeckHeight>( _FreeboardDeckHeight_QNAME, FreeboardDeckHeight.class, null, value);
    }
    // TypeWrapper{name='AP_Pos', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link APPos }{@code >}}
    */
    @XmlElementDecl( name = "AP_Pos", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<APPos> createAPPos( APPos value) {
        return new JAXBElement<APPos>( _APPos_QNAME, APPos.class, null, value);
    }
    // TypeWrapper{name='ZPosOfDeck', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ZPosOfDeck }{@code >}}
    */
    @XmlElementDecl( name = "ZPosOfDeck", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ZPosOfDeck> createZPosOfDeck( ZPosOfDeck value) {
        return new JAXBElement<ZPosOfDeck>( _ZPosOfDeck_QNAME, ZPosOfDeck.class, null, value);
    }
    // TypeWrapper{name='DeepestEquilibriumWL', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DeepestEquilibriumWL }{@code >}}
    */
    @XmlElementDecl( name = "DeepestEquilibriumWL", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DeepestEquilibriumWL> createDeepestEquilibriumWL( DeepestEquilibriumWL value) {
        return new JAXBElement<DeepestEquilibriumWL>( _DeepestEquilibriumWL_QNAME, DeepestEquilibriumWL.class, null, value);
    }
    // TypeWrapper{name='UpperDeckArea', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UpperDeckArea }{@code >}}
    */
    @XmlElementDecl( name = "UpperDeckArea", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UpperDeckArea> createUpperDeckArea( UpperDeckArea value) {
        return new JAXBElement<UpperDeckArea>( _UpperDeckArea_QNAME, UpperDeckArea.class, null, value);
    }
    // TypeWrapper{name='WaterPlaneArea', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WaterPlaneArea }{@code >}}
    */
    @XmlElementDecl( name = "WaterPlaneArea", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WaterPlaneArea> createWaterPlaneArea( WaterPlaneArea value) {
        return new JAXBElement<WaterPlaneArea>( _WaterPlaneArea_QNAME, WaterPlaneArea.class, null, value);
    }
    // TypeWrapper{name='ZPosDeckline', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ZPosDeckline }{@code >}}
    */
    @XmlElementDecl( name = "ZPosDeckline", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ZPosDeckline> createZPosDeckline( ZPosDeckline value) {
        return new JAXBElement<ZPosDeckline>( _ZPosDeckline_QNAME, ZPosDeckline.class, null, value);
    }
    // TypeWrapper{name='SpeedFactor', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SpeedFactor }{@code >}}
    */
    @XmlElementDecl( name = "SpeedFactor", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SpeedFactor> createSpeedFactor( SpeedFactor value) {
        return new JAXBElement<SpeedFactor>( _SpeedFactor_QNAME, SpeedFactor.class, null, value);
    }
    // TypeWrapper{name='MajorDiameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MajorDiameter }{@code >}}
    */
    @XmlElementDecl( name = "MajorDiameter", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MajorDiameter> createMajorDiameter( MajorDiameter value) {
        return new JAXBElement<MajorDiameter>( _MajorDiameter_QNAME, MajorDiameter.class, null, value);
    }
    // TypeWrapper{name='MinorDiameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link MinorDiameter }{@code >}}
    */
    @XmlElementDecl( name = "MinorDiameter", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<MinorDiameter> createMinorDiameter( MinorDiameter value) {
        return new JAXBElement<MinorDiameter>( _MinorDiameter_QNAME, MinorDiameter.class, null, value);
    }
    // TypeWrapper{name='Positions', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Positions_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Positions }{@code >}}
    */
    @XmlElementDecl( name = "Positions", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Positions> createPositions( Positions value) {
        return new JAXBElement<Positions>( _Positions_QNAME, Positions.class, null, value);
    }
    // TypeWrapper{name='StartPoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link StartPoint }{@code >}}
    */
    @XmlElementDecl( name = "StartPoint", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<StartPoint> createStartPoint( StartPoint value) {
        return new JAXBElement<StartPoint>( _StartPoint_QNAME, StartPoint.class, null, value);
    }
    // TypeWrapper{name='IntermediatePoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link IntermediatePoint }{@code >}}
    */
    @XmlElementDecl( name = "IntermediatePoint", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<IntermediatePoint> createIntermediatePoint( IntermediatePoint value) {
        return new JAXBElement<IntermediatePoint>( _IntermediatePoint_QNAME, IntermediatePoint.class, null, value);
    }
    // TypeWrapper{name='EndPoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EndPoint }{@code >}}
    */
    @XmlElementDecl( name = "EndPoint", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<EndPoint> createEndPoint( EndPoint value) {
        return new JAXBElement<EndPoint>( _EndPoint_QNAME, EndPoint.class, null, value);
    }
    // TypeWrapper{name='Offset', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Offset }{@code >}}
    */
    @XmlElementDecl( name = "Offset", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Offset> createOffset( Offset value) {
        return new JAXBElement<Offset>( _Offset_QNAME, Offset.class, null, value);
    }
    // TypeWrapper{name='FlangeThickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlangeThickness }{@code >}}
    */
    @XmlElementDecl( name = "FlangeThickness", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlangeThickness> createFlangeThickness( FlangeThickness value) {
        return new JAXBElement<FlangeThickness>( _FlangeThickness_QNAME, FlangeThickness.class, null, value);
    }
    // TypeWrapper{name='NeutralAxisU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NeutralAxisU }{@code >}}
    */
    @XmlElementDecl( name = "NeutralAxisU", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NeutralAxisU> createNeutralAxisU( NeutralAxisU value) {
        return new JAXBElement<NeutralAxisU>( _NeutralAxisU_QNAME, NeutralAxisU.class, null, value);
    }
    // TypeWrapper{name='NeutralAxisV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link NeutralAxisV }{@code >}}
    */
    @XmlElementDecl( name = "NeutralAxisV", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<NeutralAxisV> createNeutralAxisV( NeutralAxisV value) {
        return new JAXBElement<NeutralAxisV>( _NeutralAxisV_QNAME, NeutralAxisV.class, null, value);
    }
    // TypeWrapper{name='InertiaU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link InertiaU }{@code >}}
    */
    @XmlElementDecl( name = "InertiaU", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<InertiaU> createInertiaU( InertiaU value) {
        return new JAXBElement<InertiaU>( _InertiaU_QNAME, InertiaU.class, null, value);
    }
    // TypeWrapper{name='InertiaV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link InertiaV }{@code >}}
    */
    @XmlElementDecl( name = "InertiaV", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<InertiaV> createInertiaV( InertiaV value) {
        return new JAXBElement<InertiaV>( _InertiaV_QNAME, InertiaV.class, null, value);
    }
    // TypeWrapper{name='TorsionConstant', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link TorsionConstant }{@code >}}
    */
    @XmlElementDecl( name = "TorsionConstant", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<TorsionConstant> createTorsionConstant( TorsionConstant value) {
        return new JAXBElement<TorsionConstant>( _TorsionConstant_QNAME, TorsionConstant.class, null, value);
    }
    // TypeWrapper{name='ReferenceLocation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ReferenceLocation }{@code >}}
    */
    @XmlElementDecl( name = "ReferenceLocation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ReferenceLocation> createReferenceLocation( ReferenceLocation value) {
        return new JAXBElement<ReferenceLocation>( _ReferenceLocation_QNAME, ReferenceLocation.class, null, value);
    }
    // TypeWrapper{name='Displacement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Displacement }{@code >}}
    */
    @XmlElementDecl( name = "Displacement", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Displacement> createDisplacement( Displacement value) {
        return new JAXBElement<Displacement>( _Displacement_QNAME, Displacement.class, null, value);
    }
    // TypeWrapper{name='Density', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Density }{@code >}}
    */
    @XmlElementDecl( name = "Density", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Density> createDensity( Density value) {
        return new JAXBElement<Density>( _Density_QNAME, Density.class, null, value);
    }
    // TypeWrapper{name='YoungsModulus', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link YoungsModulus }{@code >}}
    */
    @XmlElementDecl( name = "YoungsModulus", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<YoungsModulus> createYoungsModulus( YoungsModulus value) {
        return new JAXBElement<YoungsModulus>( _YoungsModulus_QNAME, YoungsModulus.class, null, value);
    }
    // TypeWrapper{name='PoissonRatio', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link PoissonRatio }{@code >}}
    */
    @XmlElementDecl( name = "PoissonRatio", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<PoissonRatio> createPoissonRatio( PoissonRatio value) {
        return new JAXBElement<PoissonRatio>( _PoissonRatio_QNAME, PoissonRatio.class, null, value);
    }
    // TypeWrapper{name='YieldStress', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link YieldStress }{@code >}}
    */
    @XmlElementDecl( name = "YieldStress", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<YieldStress> createYieldStress( YieldStress value) {
        return new JAXBElement<YieldStress>( _YieldStress_QNAME, YieldStress.class, null, value);
    }
    // TypeWrapper{name='UltimateStress', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UltimateStress }{@code >}}
    */
    @XmlElementDecl( name = "UltimateStress", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UltimateStress> createUltimateStress( UltimateStress value) {
        return new JAXBElement<UltimateStress>( _UltimateStress_QNAME, UltimateStress.class, null, value);
    }
    // TypeWrapper{name='ThermalExpansionCoefficient', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ThermalExpansionCoefficient }{@code >}}
    */
    @XmlElementDecl( name = "ThermalExpansionCoefficient", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<ThermalExpansionCoefficient> createThermalExpansionCoefficient( ThermalExpansionCoefficient value) {
        return new JAXBElement<ThermalExpansionCoefficient>( _ThermalExpansionCoefficient_QNAME, ThermalExpansionCoefficient.class, null, value);
    }
    // TypeWrapper{name='OffsetU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link OffsetU }{@code >}}
    */
    @XmlElementDecl( name = "OffsetU", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<OffsetU> createOffsetU( OffsetU value) {
        return new JAXBElement<OffsetU>( _OffsetU_QNAME, OffsetU.class, null, value);
    }
    // TypeWrapper{name='OffsetV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link OffsetV }{@code >}}
    */
    @XmlElementDecl( name = "OffsetV", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<OffsetV> createOffsetV( OffsetV value) {
        return new JAXBElement<OffsetV>( _OffsetV_QNAME, OffsetV.class, null, value);
    }
    // TypeWrapper{name='WebDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link WebDirection }{@code >}}
    */
    @XmlElementDecl( name = "WebDirection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<WebDirection> createWebDirection( WebDirection value) {
        return new JAXBElement<WebDirection>( _WebDirection_QNAME, WebDirection.class, null, value);
    }
    // TypeWrapper{name='FlangeDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link FlangeDirection }{@code >}}
    */
    @XmlElementDecl( name = "FlangeDirection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<FlangeDirection> createFlangeDirection( FlangeDirection value) {
        return new JAXBElement<FlangeDirection>( _FlangeDirection_QNAME, FlangeDirection.class, null, value);
    }
    // TypeWrapper{name='Position', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Position }{@code >}}
    */
    @XmlElementDecl( name = "Position", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Position> createPosition( Position value) {
        return new JAXBElement<Position>( _Position_QNAME, Position.class, null, value);
    }
    // TypeWrapper{name='DistanceAbove', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DistanceAbove }{@code >}}
    */
    @XmlElementDecl( name = "DistanceAbove", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DistanceAbove> createDistanceAbove( DistanceAbove value) {
        return new JAXBElement<DistanceAbove>( _DistanceAbove_QNAME, DistanceAbove.class, null, value);
    }
    // TypeWrapper{name='DistanceBelow', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DistanceBelow }{@code >}}
    */
    @XmlElementDecl( name = "DistanceBelow", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<DistanceBelow> createDistanceBelow( DistanceBelow value) {
        return new JAXBElement<DistanceBelow>( _DistanceBelow_QNAME, DistanceBelow.class, null, value);
    }
    // TypeWrapper{name='Axis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Axis }{@code >}}
    */
    @XmlElementDecl( name = "Axis", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Axis> createAxis( Axis value) {
        return new JAXBElement<Axis>( _Axis_QNAME, Axis.class, null, value);
    }
    // TypeWrapper{name='Overshoot', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Overshoot }{@code >}}
    */
    @XmlElementDecl( name = "Overshoot", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Overshoot> createOvershoot( Overshoot value) {
        return new JAXBElement<Overshoot>( _Overshoot_QNAME, Overshoot.class, null, value);
    }
    // TypeWrapper{name='UDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UDirection }{@code >}}
    */
    @XmlElementDecl( name = "UDirection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<UDirection> createUDirection( UDirection value) {
        return new JAXBElement<UDirection>( _UDirection_QNAME, UDirection.class, null, value);
    }
    // TypeWrapper{name='VDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link VDirection }{@code >}}
    */
    @XmlElementDecl( name = "VDirection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<VDirection> createVDirection( VDirection value) {
        return new JAXBElement<VDirection>( _VDirection_QNAME, VDirection.class, null, value);
    }
    // TypeWrapper{name='Start', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Start }{@code >}}
    */
    @XmlElementDecl( name = "Start", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<Start> createStart( Start value) {
        return new JAXBElement<Start>( _Start_QNAME, Start.class, null, value);
    }
    // TypeWrapper{name='SectionOuterShape', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SectionOuterShape }{@code >}}
    */
    @XmlElementDecl( name = "SectionOuterShape", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SectionOuterShape> createSectionOuterShape( SectionOuterShape value) {
        return new JAXBElement<SectionOuterShape>( _SectionOuterShape_QNAME, SectionOuterShape.class, null, value);
    }
    // TypeWrapper{name='SectionInnerShape', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link SectionInnerShape }{@code >}}
    */
    @XmlElementDecl( name = "SectionInnerShape", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<SectionInnerShape> createSectionInnerShape( SectionInnerShape value) {
        return new JAXBElement<SectionInnerShape>( _SectionInnerShape_QNAME, SectionInnerShape.class, null, value);
    }
    // TypeWrapper{name='CustomProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CustomProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CustomProperties }{@code >}}
    */
    @XmlElementDecl( name = "CustomProperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CustomProperties> createCustomProperties( CustomProperties value) {
        return new JAXBElement<CustomProperties>( _CustomProperties_QNAME, CustomProperties.class, null, value);
    }
    // TypeWrapper{name='CustomProperty', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CustomProperty_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link CustomProperty }{@code >}}
    */
    @XmlElementDecl( name = "CustomProperty", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    public JAXBElement<CustomProperty> createCustomProperty( CustomProperty value) {
        return new JAXBElement<CustomProperty>( _CustomProperty_QNAME, CustomProperty.class, null, value);
    }
}
