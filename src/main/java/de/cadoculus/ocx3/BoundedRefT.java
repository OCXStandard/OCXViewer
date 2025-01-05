
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BoundedRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type description
 *  

*/
// BoundedRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ReferenceBase_T  
// reference type BaseClass

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BoundedRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BoundedRefT extends ReferenceBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ContourBounds
    // PropertyWrapper{name='ContourBounds', typeName='ContourBounds', docu='null', type=ContourBounds, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ContourBounds', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ContourBounds_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ContourBounds' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ContourBounds> ContourBounds = new javafx.beans.property.SimpleObjectProperty<ContourBounds>();

    @XmlElement(name = "ContourBounds", required = false)
    public ContourBounds getContourBounds() {
        return this.ContourBounds.get();
    }
    public void setContourBounds( ContourBounds value) {
        this.ContourBounds.set( value);
    }




    // end the properties serialised to elements




      public BoundedRefT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
