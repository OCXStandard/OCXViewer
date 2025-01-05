
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Cylinder3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the cylindrical surface defined by root point, axis direction, radius
 * 				and height.
 *  

*/
// Cylinder3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Surface_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Cylinder3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Cylinder3DT extends SurfaceT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Origin
    // PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Origin', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Origin' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Origin> Origin = new javafx.beans.property.SimpleObjectProperty<Origin>();

    @XmlElement(name = "Origin", required = true)
    public Origin getOrigin() {
        return this.Origin.get();
    }
    public void setOrigin( Origin value) {
        this.Origin.set( value);
    }




    // Property Axis
    // PropertyWrapper{name='Axis', typeName='Axis', docu='null', type=Axis, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Axis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Axis' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Axis> Axis = new javafx.beans.property.SimpleObjectProperty<Axis>();

    @XmlElement(name = "Axis", required = true)
    public Axis getAxis() {
        return this.Axis.get();
    }
    public void setAxis( Axis value) {
        this.Axis.set( value);
    }




    // Property Radius
    // PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Radius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Radius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Radius> Radius = new javafx.beans.property.SimpleObjectProperty<Radius>();

    @XmlElement(name = "Radius", required = true)
    public Radius getRadius() {
        return this.Radius.get();
    }
    public void setRadius( Radius value) {
        this.Radius.set( value);
    }




    // Property Height
    // PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Height', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Height' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Height> Height = new javafx.beans.property.SimpleObjectProperty<Height>();

    @XmlElement(name = "Height", required = true)
    public Height getHeight() {
        return this.Height.get();
    }
    public void setHeight( Height value) {
        this.Height.set( value);
    }




    // end the properties serialised to elements




      public Cylinder3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
