
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Equipment_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the Equipment element.
 *  

*/
// Equipment_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Equipment_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class EquipmentT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ExternalGeometryRef
    // PropertyWrapper{name='ExternalGeometryRef', typeName='ExternalGeometryRef', docu='null', type=ExternalGeometryRef, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ExternalGeometryRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ExternalGeometryRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ExternalGeometryRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ExternalGeometryRef> ExternalGeometryRef = new javafx.beans.property.SimpleObjectProperty<ExternalGeometryRef>();

    @XmlElement(name = "ExternalGeometryRef", required = false)
    public ExternalGeometryRef getExternalGeometryRef() {
        return this.ExternalGeometryRef.get();
    }
    public void setExternalGeometryRef( ExternalGeometryRef value) {
        this.ExternalGeometryRef.set( value);
    }




    // end the properties serialised to elements




      public EquipmentT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
