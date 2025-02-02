
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SectionProperties_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Generic bar section properties.
 *  

*/
// SectionProperties_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SectionProperties_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SectionPropertiesT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Area
    // PropertyWrapper{name='Area', typeName='Area', docu='null', type=Area, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Area', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Area' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Area> Area = new javafx.beans.property.SimpleObjectProperty<Area>();

    @XmlElement(name = "Area", required = true)
    public Area getArea() {
        return this.Area.get();
    }
    public void setArea( Area value) {
        this.Area.set( value);
    }




    // Property NeutralAxisU
    // PropertyWrapper{name='NeutralAxisU', typeName='NeutralAxisU', docu='null', type=NeutralAxisU, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='NeutralAxisU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'NeutralAxisU' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<NeutralAxisU> NeutralAxisU = new javafx.beans.property.SimpleObjectProperty<NeutralAxisU>();

    @XmlElement(name = "NeutralAxisU", required = true)
    public NeutralAxisU getNeutralAxisU() {
        return this.NeutralAxisU.get();
    }
    public void setNeutralAxisU( NeutralAxisU value) {
        this.NeutralAxisU.set( value);
    }




    // Property NeutralAxisV
    // PropertyWrapper{name='NeutralAxisV', typeName='NeutralAxisV', docu='null', type=NeutralAxisV, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='NeutralAxisV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'NeutralAxisV' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<NeutralAxisV> NeutralAxisV = new javafx.beans.property.SimpleObjectProperty<NeutralAxisV>();

    @XmlElement(name = "NeutralAxisV", required = true)
    public NeutralAxisV getNeutralAxisV() {
        return this.NeutralAxisV.get();
    }
    public void setNeutralAxisV( NeutralAxisV value) {
        this.NeutralAxisV.set( value);
    }




    // Property InertiaU
    // PropertyWrapper{name='InertiaU', typeName='InertiaU', docu='null', type=InertiaU, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='InertiaU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'InertiaU' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<InertiaU> InertiaU = new javafx.beans.property.SimpleObjectProperty<InertiaU>();

    @XmlElement(name = "InertiaU", required = true)
    public InertiaU getInertiaU() {
        return this.InertiaU.get();
    }
    public void setInertiaU( InertiaU value) {
        this.InertiaU.set( value);
    }




    // Property InertiaV
    // PropertyWrapper{name='InertiaV', typeName='InertiaV', docu='null', type=InertiaV, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='InertiaV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'InertiaV' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<InertiaV> InertiaV = new javafx.beans.property.SimpleObjectProperty<InertiaV>();

    @XmlElement(name = "InertiaV", required = true)
    public InertiaV getInertiaV() {
        return this.InertiaV.get();
    }
    public void setInertiaV( InertiaV value) {
        this.InertiaV.set( value);
    }




    // Property TorsionConstant
    // PropertyWrapper{name='TorsionConstant', typeName='TorsionConstant', docu='null', type=TorsionConstant, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='TorsionConstant', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'TorsionConstant' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<TorsionConstant> TorsionConstant = new javafx.beans.property.SimpleObjectProperty<TorsionConstant>();

    @XmlElement(name = "TorsionConstant", required = false)
    public TorsionConstant getTorsionConstant() {
        return this.TorsionConstant.get();
    }
    public void setTorsionConstant( TorsionConstant value) {
        this.TorsionConstant.set( value);
    }




    // end the properties serialised to elements




      public SectionPropertiesT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
