
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Arrangement_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the vessel arrangement (of compartments).
 *  

*/
// Arrangement_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Arrangement_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ArrangementT extends DescriptionBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Compartment
    // PropertyWrapper{name='Compartment', typeName='Compartment', docu='null', type=Compartment, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Compartment', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Compartment_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Compartment' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Compartment> Compartment = new javafx.beans.property.SimpleObjectProperty<Compartment>();

    @XmlElement(name = "Compartment", required = true)
    public Compartment getCompartment() {
        return this.Compartment.get();
    }
    public void setCompartment( Compartment value) {
        this.Compartment.set( value);
    }




    // Property PhysicalSpace
    // PropertyWrapper{name='PhysicalSpace', typeName='PhysicalSpace', docu='null', type=PhysicalSpace, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PhysicalSpace', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PhysicalSpace_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PhysicalSpace' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PhysicalSpace> PhysicalSpace = new javafx.beans.property.SimpleObjectProperty<PhysicalSpace>();

    @XmlElement(name = "PhysicalSpace", required = true)
    public PhysicalSpace getPhysicalSpace() {
        return this.PhysicalSpace.get();
    }
    public void setPhysicalSpace( PhysicalSpace value) {
        this.PhysicalSpace.set( value);
    }




    // end the properties serialised to elements




      public ArrangementT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
