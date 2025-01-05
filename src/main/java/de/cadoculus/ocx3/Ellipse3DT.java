
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Ellipse3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of An ellipse in 3D space.
 *  

*/
// Ellipse3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Ellipse3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Ellipse3DT extends Curve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Center
    // PropertyWrapper{name='Center', typeName='Center', docu='null', type=Center, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Center', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Center' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Center> Center = new javafx.beans.property.SimpleObjectProperty<Center>();

    @XmlElement(name = "Center", required = true)
    public Center getCenter() {
        return this.Center.get();
    }
    public void setCenter( Center value) {
        this.Center.set( value);
    }




    // Property MajorDiameter
    // PropertyWrapper{name='MajorDiameter', typeName='MajorDiameter', docu='null', type=MajorDiameter, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MajorDiameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MajorDiameter' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MajorDiameter> MajorDiameter = new javafx.beans.property.SimpleObjectProperty<MajorDiameter>();

    @XmlElement(name = "MajorDiameter", required = true)
    public MajorDiameter getMajorDiameter() {
        return this.MajorDiameter.get();
    }
    public void setMajorDiameter( MajorDiameter value) {
        this.MajorDiameter.set( value);
    }




    // Property MinorDiameter
    // PropertyWrapper{name='MinorDiameter', typeName='MinorDiameter', docu='null', type=MinorDiameter, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MinorDiameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MinorDiameter' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MinorDiameter> MinorDiameter = new javafx.beans.property.SimpleObjectProperty<MinorDiameter>();

    @XmlElement(name = "MinorDiameter", required = true)
    public MinorDiameter getMinorDiameter() {
        return this.MinorDiameter.get();
    }
    public void setMinorDiameter( MinorDiameter value) {
        this.MinorDiameter.set( value);
    }




    // Property MajorAxis
    // PropertyWrapper{name='MajorAxis', typeName='MajorAxis', docu='null', type=MajorAxis, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MajorAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MajorAxis' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MajorAxis> MajorAxis = new javafx.beans.property.SimpleObjectProperty<MajorAxis>();

    @XmlElement(name = "MajorAxis", required = true)
    public MajorAxis getMajorAxis() {
        return this.MajorAxis.get();
    }
    public void setMajorAxis( MajorAxis value) {
        this.MajorAxis.set( value);
    }




    // Property MinorAxis
    // PropertyWrapper{name='MinorAxis', typeName='MinorAxis', docu='null', type=MinorAxis, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MinorAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MinorAxis' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MinorAxis> MinorAxis = new javafx.beans.property.SimpleObjectProperty<MinorAxis>();

    @XmlElement(name = "MinorAxis", required = true)
    public MinorAxis getMinorAxis() {
        return this.MinorAxis.get();
    }
    public void setMinorAxis( MinorAxis value) {
        this.MinorAxis.set( value);
    }




    // Property Normal
    // PropertyWrapper{name='Normal', typeName='Normal', docu='null', type=Normal, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Normal', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Normal' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Normal> Normal = new javafx.beans.property.SimpleObjectProperty<Normal>();

    @XmlElement(name = "Normal", required = false)
    public Normal getNormal() {
        return this.Normal.get();
    }
    public void setNormal( Normal value) {
        this.Normal.set( value);
    }




    // end the properties serialised to elements




      public Ellipse3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
