
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>TonnageData_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The information pertinent to the tonnage of the ship.
 *  

*/
// TonnageData_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "TonnageData_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class TonnageDataT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Tonnage
    // PropertyWrapper{name='Tonnage', typeName='Tonnage', docu='null', type=Tonnage, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Tonnage', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Tonnage' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Tonnage> Tonnage = new javafx.beans.property.SimpleObjectProperty<Tonnage>();

    @XmlElement(name = "Tonnage", required = true)
    public Tonnage getTonnage() {
        return this.Tonnage.get();
    }
    public void setTonnage( Tonnage value) {
        this.Tonnage.set( value);
    }




    // Property DeadWeight
    // PropertyWrapper{name='DeadWeight', typeName='DeadWeight', docu='null', type=DeadWeight, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='DeadWeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DeadWeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DeadWeight> DeadWeight = new javafx.beans.property.SimpleObjectProperty<DeadWeight>();

    @XmlElement(name = "DeadWeight", required = true)
    public DeadWeight getDeadWeight() {
        return this.DeadWeight.get();
    }
    public void setDeadWeight( DeadWeight value) {
        this.DeadWeight.set( value);
    }




    // end the properties serialised to elements




      public TonnageDataT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
