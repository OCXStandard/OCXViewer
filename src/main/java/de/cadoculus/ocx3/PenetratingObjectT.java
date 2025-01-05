
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PenetratingObject_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a penetrated structural object.
 *  

*/
// PenetratingObject_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PenetratingObject_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PenetratingObjectT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property PlateRef
    // PropertyWrapper{name='PlateRef', typeName='PlateRef', docu='null', type=PlateRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PlateRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PlateRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PlateRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PlateRef> PlateRef = new javafx.beans.property.SimpleObjectProperty<PlateRef>();

    @XmlElement(name = "PlateRef", required = true)
    public PlateRef getPlateRef() {
        return this.PlateRef.get();
    }
    public void setPlateRef( PlateRef value) {
        this.PlateRef.set( value);
    }




    // Property SlotParameters
    // PropertyWrapper{name='SlotParameters', typeName='SlotParameters', docu='null', type=SlotParameters, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SlotParameters', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SlotParameters_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SlotParameters' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SlotParameters> SlotParameters = new javafx.beans.property.SimpleObjectProperty<SlotParameters>();

    @XmlElement(name = "SlotParameters", required = true)
    public SlotParameters getSlotParameters() {
        return this.SlotParameters.get();
    }
    public void setSlotParameters( SlotParameters value) {
        this.SlotParameters.set( value);
    }




    // end the properties serialised to elements




      public PenetratingObjectT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
