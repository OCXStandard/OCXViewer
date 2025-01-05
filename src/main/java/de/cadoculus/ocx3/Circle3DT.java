
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Circle3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a circle in 3D space.
 *  

*/
// Circle3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Circle3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Circle3DT extends Curve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Diameter
    // PropertyWrapper{name='Diameter', typeName='Diameter', docu='null', type=Diameter, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Diameter', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Diameter' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Diameter> Diameter = new javafx.beans.property.SimpleObjectProperty<Diameter>();

    @XmlElement(name = "Diameter", required = true)
    public Diameter getDiameter() {
        return this.Diameter.get();
    }
    public void setDiameter( Diameter value) {
        this.Diameter.set( value);
    }




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




    // Property Normal
    // PropertyWrapper{name='Normal', typeName='Normal', docu='null', type=Normal, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Normal', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Normal' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Normal> Normal = new javafx.beans.property.SimpleObjectProperty<Normal>();

    @XmlElement(name = "Normal", required = true)
    public Normal getNormal() {
        return this.Normal.get();
    }
    public void setNormal( Normal value) {
        this.Normal.set( value);
    }




    // end the properties serialised to elements




      public Circle3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
