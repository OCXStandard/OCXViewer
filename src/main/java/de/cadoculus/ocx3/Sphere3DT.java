
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Sphere3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a Spherical surface defined by origin and radius.
 *  

*/
// Sphere3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Surface_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Sphere3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Sphere3DT extends SurfaceT
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




    // end the properties serialised to elements




      public Sphere3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
