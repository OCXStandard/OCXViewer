
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>StructurePart_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the abstract base class for structure objects representing structure
 * 				concepts.
 *  

*/
// StructurePart_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "StructurePart_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class StructurePartT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property PhysicalProperties
    // PropertyWrapper{name='PhysicalProperties', typeName='PhysicalProperties', docu='null', type=PhysicalProperties, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PhysicalProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PhysicalProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PhysicalProperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PhysicalProperties> PhysicalProperties = new javafx.beans.property.SimpleObjectProperty<PhysicalProperties>();

    @XmlElement(name = "PhysicalProperties", required = true)
    public PhysicalProperties getPhysicalProperties() {
        return this.PhysicalProperties.get();
    }
    public void setPhysicalProperties( PhysicalProperties value) {
        this.PhysicalProperties.set( value);
    }




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




      public StructurePartT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
