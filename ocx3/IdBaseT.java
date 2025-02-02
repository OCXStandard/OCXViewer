
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>IdBase_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Abstract base type for all types which need to carry an ID.
 *  

*/
// IdBase_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "IdBase_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class IdBaseT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:ID => TypeWrapper{name='ID', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:ID!!!
    /* The 'id' value serialised as  XML attribute.
    * <summary>
    * An identifier for an element unique within the scope of the XML file. Each id must be
    * 					unique within a document. The attribute uses the standard XML 1.0 ID type as defined in the XML
    * 					Schema specification. This attribute is required in many OCX XML elements and an application should
    * 					generate them automatically.</summary>
    */
    // contains the String serialised form of xs:ID as String ( default namespace)
        // ?? xs:ID
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Id = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "xs:ID")
    public String getId() {
        return this.Id.get();
    };

    public void setId( String value) {
        this.Id.set( value);

    }
    // end id
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CustomProperties
    // PropertyWrapper{name='CustomProperties', typeName='CustomProperties', docu='null', type=CustomProperties, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='CustomProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CustomProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CustomProperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CustomProperties> CustomProperties = new javafx.beans.property.SimpleObjectProperty<CustomProperties>();

    @XmlElement(name = "CustomProperties", required = false)
    public CustomProperties getCustomProperties() {
        return this.CustomProperties.get();
    }
    public void setCustomProperties( CustomProperties value) {
        this.CustomProperties.set( value);
    }




    // end the properties serialised to elements




      public IdBaseT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
