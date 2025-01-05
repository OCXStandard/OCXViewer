
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Penetration_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Structural concept of stiffener penetration configurations typically
 * 				used in shipbuilding.
 *  

*/
// Penetration_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ConnectionConfiguration_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Penetration_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PenetrationT extends ConnectionConfigurationT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='tightness', typeName='tightness', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // tightness => TypeWrapper{name='tightness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use TightnessEnum
    // Java Type , TightnessEnum Type Adapter !!!typeAdapter unmapped type tightness!!!
    /* The 'tightness' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of tightness as TightnessEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? tightness
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<TightnessEnum> Tightness = new  javafx.beans.property.SimpleObjectProperty<TightnessEnum>();

    @XmlAttribute(name = "tightness", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "tightness")
    public TightnessEnum getTightness() {
        return this.Tightness.get();
    };

    public void setTightness( TightnessEnum value) {
        this.Tightness.set( value);

    }
    // end tightness
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property SlotParameters
    // PropertyWrapper{name='SlotParameters', typeName='SlotParameters', docu='null', type=SlotParameters, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='SlotParameters', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SlotParameters_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SlotParameters' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SlotParameters> SlotParameters = new javafx.beans.property.SimpleObjectProperty<SlotParameters>();

    @XmlElement(name = "SlotParameters", required = false)
    public SlotParameters getSlotParameters() {
        return this.SlotParameters.get();
    }
    public void setSlotParameters( SlotParameters value) {
        this.SlotParameters.set( value);
    }




    // end the properties serialised to elements




      public PenetrationT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
