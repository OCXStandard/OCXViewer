
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PhysicalProperties_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of physical properties of structure objects (weight and centre of
 * 				gravity).
 *  

*/
// PhysicalProperties_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PhysicalProperties_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PhysicalPropertiesT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property DryWeight
    // PropertyWrapper{name='DryWeight', typeName='DryWeight', docu='null', type=DryWeight, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='DryWeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DryWeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DryWeight> DryWeight = new javafx.beans.property.SimpleObjectProperty<DryWeight>();

    @XmlElement(name = "DryWeight", required = true)
    public DryWeight getDryWeight() {
        return this.DryWeight.get();
    }
    public void setDryWeight( DryWeight value) {
        this.DryWeight.set( value);
    }




    // Property CenterOfGravity
    // PropertyWrapper{name='CenterOfGravity', typeName='CenterOfGravity', docu='null', type=CenterOfGravity, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CenterOfGravity', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CenterOfGravity' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CenterOfGravity> CenterOfGravity = new javafx.beans.property.SimpleObjectProperty<CenterOfGravity>();

    @XmlElement(name = "CenterOfGravity", required = true)
    public CenterOfGravity getCenterOfGravity() {
        return this.CenterOfGravity.get();
    }
    public void setCenterOfGravity( CenterOfGravity value) {
        this.CenterOfGravity.set( value);
    }




    // end the properties serialised to elements




      public PhysicalPropertiesT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
