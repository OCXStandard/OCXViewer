
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Vessel_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the Vessel asset subject to Classification.
 *  

*/
// Vessel_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Form_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Vessel_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class VesselT extends FormT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CoordinateSystem
    // PropertyWrapper{name='CoordinateSystem', typeName='CoordinateSystem', docu='null', type=CoordinateSystem, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='CoordinateSystem', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CoordinateSystem_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CoordinateSystem' property serialised as  XML elemenmt.
    * 
    */

    private List<CoordinateSystem> coordinateSystems = new ArrayList<>();

    public List<CoordinateSystem> getCoordinateSystem() {
        return coordinateSystems;
    }




    // Property ClassificationData
    // PropertyWrapper{name='ClassificationData', typeName='ClassificationData', docu='null', type=ClassificationData, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ClassificationData', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ClassData_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ClassificationData' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ClassificationData> ClassificationData = new javafx.beans.property.SimpleObjectProperty<ClassificationData>();

    @XmlElement(name = "ClassificationData", required = true)
    public ClassificationData getClassificationData() {
        return this.ClassificationData.get();
    }
    public void setClassificationData( ClassificationData value) {
        this.ClassificationData.set( value);
    }




    // Property BuilderInformation
    // PropertyWrapper{name='BuilderInformation', typeName='BuilderInformation', docu='null', type=BuilderInformation, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='BuilderInformation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BuilderInformation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BuilderInformation' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BuilderInformation> BuilderInformation = new javafx.beans.property.SimpleObjectProperty<BuilderInformation>();

    @XmlElement(name = "BuilderInformation", required = false)
    public BuilderInformation getBuilderInformation() {
        return this.BuilderInformation.get();
    }
    public void setBuilderInformation( BuilderInformation value) {
        this.BuilderInformation.set( value);
    }




    // Property TonnageData
    // PropertyWrapper{name='TonnageData', typeName='TonnageData', docu='null', type=TonnageData, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='TonnageData', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TonnageData_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'TonnageData' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<TonnageData> TonnageData = new javafx.beans.property.SimpleObjectProperty<TonnageData>();

    @XmlElement(name = "TonnageData", required = false)
    public TonnageData getTonnageData() {
        return this.TonnageData.get();
    }
    public void setTonnageData( TonnageData value) {
        this.TonnageData.set( value);
    }




    // Property StatutoryData
    // PropertyWrapper{name='StatutoryData', typeName='StatutoryData', docu='null', type=StatutoryData, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='StatutoryData', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StatutoryData_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'StatutoryData' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<StatutoryData> StatutoryData = new javafx.beans.property.SimpleObjectProperty<StatutoryData>();

    @XmlElement(name = "StatutoryData", required = false)
    public StatutoryData getStatutoryData() {
        return this.StatutoryData.get();
    }
    public void setStatutoryData( StatutoryData value) {
        this.StatutoryData.set( value);
    }




    // Property ShipDesignation
    // PropertyWrapper{name='ShipDesignation', typeName='ShipDesignation', docu='null', type=ShipDesignation, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ShipDesignation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ShipDesignation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ShipDesignation' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ShipDesignation> ShipDesignation = new javafx.beans.property.SimpleObjectProperty<ShipDesignation>();

    @XmlElement(name = "ShipDesignation", required = false)
    public ShipDesignation getShipDesignation() {
        return this.ShipDesignation.get();
    }
    public void setShipDesignation( ShipDesignation value) {
        this.ShipDesignation.set( value);
    }




    // Property DesignView
    // PropertyWrapper{name='DesignView', typeName='DesignView', docu='null', type=DesignView, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='DesignView', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DesignView_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DesignView' property serialised as  XML elemenmt.
    * 
    */

    private List<DesignView> designViews = new ArrayList<>();

    public List<DesignView> getDesignView() {
        return designViews;
    }




    // Property Arrangement
    // PropertyWrapper{name='Arrangement', typeName='Arrangement', docu='null', type=Arrangement, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Arrangement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Arrangement_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Arrangement' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Arrangement> Arrangement = new javafx.beans.property.SimpleObjectProperty<Arrangement>();

    @XmlElement(name = "Arrangement", required = false)
    public Arrangement getArrangement() {
        return this.Arrangement.get();
    }
    public void setArrangement( Arrangement value) {
        this.Arrangement.set( value);
    }




    // Property ReferenceSurfaces
    // PropertyWrapper{name='ReferenceSurfaces', typeName='ReferenceSurfaces', docu='null', type=ReferenceSurfaces, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ReferenceSurfaces', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ReferenceSurfaces_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ReferenceSurfaces' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ReferenceSurfaces> ReferenceSurfaces = new javafx.beans.property.SimpleObjectProperty<ReferenceSurfaces>();

    @XmlElement(name = "ReferenceSurfaces", required = false)
    public ReferenceSurfaces getReferenceSurfaces() {
        return this.ReferenceSurfaces.get();
    }
    public void setReferenceSurfaces( ReferenceSurfaces value) {
        this.ReferenceSurfaces.set( value);
    }




    // Property Panel
    // PropertyWrapper{name='Panel', typeName='Panel', docu='null', type=Panel, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Panel', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Panel_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Panel' property serialised as  XML elemenmt.
    * 
    */




    private List<Panel> panels = new ArrayList<>();

    public List<Panel> getPanel() {
        return panels;
    }




    // Property Plate
    // PropertyWrapper{name='Plate', typeName='Plate', docu='null', type=Plate, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Plate', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Plate_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Plate' property serialised as  XML elemenmt.
    * 
    */

    private List<Plate> plates = new ArrayList<>();

    public List<Plate> getPlate() {
        return plates;
    }




    // Property Stiffener
    // PropertyWrapper{name='Stiffener', typeName='Stiffener', docu='null', type=Stiffener, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Stiffener', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Stiffener_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Stiffener' property serialised as  XML elemenmt.
    * 
    */

    private List<Stiffener> stiffeners = new ArrayList<>();

    public List<Stiffener> getStiffener() {
        return stiffeners;
    }




    // Property Bracket
    // PropertyWrapper{name='Bracket', typeName='Bracket', docu='null', type=Bracket, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Bracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Bracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Bracket' property serialised as  XML elemenmt.
    * 
    */

    private List<Bracket> brackets = new ArrayList<>();

    public List<Bracket> getBracket() {
        return brackets;
    }




    // Property Member
    // PropertyWrapper{name='Member', typeName='Member', docu='null', type=Member, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Member', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Member_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Member' property serialised as  XML elemenmt.
    * 
    */

    private List<Member> members = new ArrayList<>();

    public List<Member> getMember() {
        return members;
    }




    // end the properties serialised to elements




      public VesselT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
