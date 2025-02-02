
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>StatutoryData_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of vessel data related to the flag state.
 *  

*/
// StatutoryData_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "StatutoryData_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class StatutoryDataT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='portRegistration', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'portRegistration' value serialised as  XML attribute.
    * <summary>
    * The national home port of the ship. The port of registration lies within the
    * 					jurisdiction of the flag state (see ISO 10303-215, section 4.2.142.5).</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> PortRegistration = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "portRegistration", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getPortRegistration() {
        return this.PortRegistration.get();
    };

    public void setPortRegistration( String value) {
        this.PortRegistration.set( value);

    }
    // end portRegistration

    // AttributeWrapper{name='flagState', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'flagState' value serialised as  XML attribute.
    * <summary>
    * The national authority with which the ship is registered (see ISO 10303-215, section
    * 					4.2.142.3).</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> FlagState = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "flagState", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getFlagState() {
        return this.FlagState.get();
    };

    public void setFlagState( String value) {
        this.FlagState.set( value);

    }
    // end flagState
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public StatutoryDataT() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
