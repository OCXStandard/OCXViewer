
package de.cadoculus.ocx3;

import de.cadoculus.unitsml.UnitsML;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ocxXML_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Root type of the schema.
 *  

*/
// ocxXML_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DocumentBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ocxXML_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class OcxXMLT extends DocumentBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Vessel
    // PropertyWrapper{name='Vessel', typeName='Vessel', docu='null', type=Vessel, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Vessel', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vessel_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Vessel' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Vessel> Vessel = new javafx.beans.property.SimpleObjectProperty<Vessel>();

    @XmlElement(name = "Vessel", required = true)
    public Vessel getVessel() {
        return this.Vessel.get();
    }
    public void setVessel( Vessel value) {
        this.Vessel.set( value);
    }




    // Property ClassCatalogue
    // PropertyWrapper{name='ClassCatalogue', typeName='ClassCatalogue', docu='null', type=ClassCatalogue, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ClassCatalogue', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ClassCatalogue_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ClassCatalogue' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ClassCatalogue> ClassCatalogue = new javafx.beans.property.SimpleObjectProperty<ClassCatalogue>();

    @XmlElement(name = "ClassCatalogue", required = true)
    public ClassCatalogue getClassCatalogue() {
        return this.ClassCatalogue.get();
    }
    public void setClassCatalogue( ClassCatalogue value) {
        this.ClassCatalogue.set( value);
    }




    // Property ProcessLayer
    // PropertyWrapper{name='ProcessLayer', typeName='ProcessLayer', docu='null', type=ProcessLayer, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ProcessLayer', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ProcessLayer_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ProcessLayer' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ProcessLayer> ProcessLayer = new javafx.beans.property.SimpleObjectProperty<ProcessLayer>();

    @XmlElement(name = "ProcessLayer", required = false)
    public ProcessLayer getProcessLayer() {
        return this.ProcessLayer.get();
    }
    public void setProcessLayer( ProcessLayer value) {
        this.ProcessLayer.set( value);
    }




    // Property UnitsML
    // PropertyWrapper{name='UnitsML', typeName='UnitsML', docu='null', type=UnitsML, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UnitsML', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitsMLType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UnitsML' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<de.cadoculus.unitsml.UnitsML> UnitsML = new javafx.beans.property.SimpleObjectProperty<UnitsML>();

    @XmlElement(name = "UnitsML", required = true, namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public UnitsML getUnitsML() {
        return this.UnitsML.get();
    }
    public void setUnitsML( UnitsML value) {
        this.UnitsML.set( value);
    }




    // Property Equipments
    // PropertyWrapper{name='Equipments', typeName='Equipments', docu='null', type=Equipments, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Equipments', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Equipments_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Equipments' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Equipments> Equipments = new javafx.beans.property.SimpleObjectProperty<Equipments>();

    @XmlElement(name = "Equipments", required = false)
    public Equipments getEquipments() {
        return this.Equipments.get();
    }
    public void setEquipments( Equipments value) {
        this.Equipments.set( value);
    }




    // end the properties serialised to elements




      public OcxXMLT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
