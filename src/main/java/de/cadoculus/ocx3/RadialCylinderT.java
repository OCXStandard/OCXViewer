
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>RadialCylinder_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Cylindrical reference system.
 *  

*/
// RadialCylinder_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RadialCylinder_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class RadialCylinderT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
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




      public RadialCylinderT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
