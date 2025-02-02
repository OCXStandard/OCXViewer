
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UnitCargo_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of dry cargo properties, reference is made to ISO 10303-215:2004.
 *  

*/
// UnitCargo_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitCargo_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class UnitCargoT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='unitCargoType', typeName='unitCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // unitCargoType => TypeWrapper{name='unitCargoType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use UnitCargoTypeEnum
    // Java Type , UnitCargoTypeEnum Type Adapter !!!typeAdapter unmapped type unitCargoType!!!
    /* The 'unitCargoType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of unitCargoType as UnitCargoTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? unitCargoType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<UnitCargoTypeEnum> UnitCargoType = new  javafx.beans.property.SimpleObjectProperty<UnitCargoTypeEnum>();

    @XmlAttribute(name = "unitCargoType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "unitCargoType")
    public UnitCargoTypeEnum getUnitCargoType() {
        return this.UnitCargoType.get();
    };

    public void setUnitCargoType( UnitCargoTypeEnum value) {
        this.UnitCargoType.set( value);

    }
    // end unitCargoType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public UnitCargoT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
