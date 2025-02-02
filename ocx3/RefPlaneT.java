
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>RefPlane_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a reference plane used to define unbounded planar geometry.
 *  

*/
// RefPlane_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RefPlane_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class RefPlaneT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ReferenceLocation
    // PropertyWrapper{name='ReferenceLocation', typeName='ReferenceLocation', docu='null', type=ReferenceLocation, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ReferenceLocation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ReferenceLocation' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ReferenceLocation> ReferenceLocation = new javafx.beans.property.SimpleObjectProperty<ReferenceLocation>();

    @XmlElement(name = "ReferenceLocation", required = true)
    public ReferenceLocation getReferenceLocation() {
        return this.ReferenceLocation.get();
    }
    public void setReferenceLocation( ReferenceLocation value) {
        this.ReferenceLocation.set( value);
    }




    // end the properties serialised to elements




      public RefPlaneT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
