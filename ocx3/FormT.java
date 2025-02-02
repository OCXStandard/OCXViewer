
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Form_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Abstract base type definition of the Form element.
 *  

*/
// Form_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Form_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class FormT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property DistanceTolerance
    // PropertyWrapper{name='DistanceTolerance', typeName='DistanceTolerance', docu='null', type=DistanceTolerance, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='DistanceTolerance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DistanceTolerance' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DistanceTolerance> DistanceTolerance = new javafx.beans.property.SimpleObjectProperty<DistanceTolerance>();

    @XmlElement(name = "DistanceTolerance", required = true)
    public DistanceTolerance getDistanceTolerance() {
        return this.DistanceTolerance.get();
    }
    public void setDistanceTolerance( DistanceTolerance value) {
        this.DistanceTolerance.set( value);
    }




    // Property AngleTolerance
    // PropertyWrapper{name='AngleTolerance', typeName='AngleTolerance', docu='null', type=AngleTolerance, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='AngleTolerance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'AngleTolerance' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<AngleTolerance> AngleTolerance = new javafx.beans.property.SimpleObjectProperty<AngleTolerance>();

    @XmlElement(name = "AngleTolerance", required = true)
    public AngleTolerance getAngleTolerance() {
        return this.AngleTolerance.get();
    }
    public void setAngleTolerance( AngleTolerance value) {
        this.AngleTolerance.set( value);
    }




    // end the properties serialised to elements




      public FormT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
