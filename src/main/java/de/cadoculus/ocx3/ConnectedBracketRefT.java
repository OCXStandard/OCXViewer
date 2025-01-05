
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ConnectedBracketRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a connected bracket part of a ConnectionConfiguration.
 *  

*/
// ConnectedBracketRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// BracketRef_T  
// reference type BaseClass

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ConnectedBracketRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ConnectedBracketRefT extends BracketRefT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='position', typeName='position', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // position => TypeWrapper{name='position', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use PositionEnum
    // Java Type , PositionEnum Type Adapter !!!typeAdapter unmapped type position!!!
    /* The 'position' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of position as PositionEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? position
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<PositionEnum> Position = new  javafx.beans.property.SimpleObjectProperty<PositionEnum>();

    @XmlAttribute(name = "position", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "position")
    public PositionEnum getPosition() {
        return this.Position.get();
    };

    public void setPosition( PositionEnum value) {
        this.Position.set( value);

    }
    // end position
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ConnectedBracketRefT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
