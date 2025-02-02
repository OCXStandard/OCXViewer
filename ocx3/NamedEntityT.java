
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>NamedEntity_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Abstract base element for all elements that needs to carry a mandatory name.
 *  

*/
// NamedEntity_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// IdBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "NamedEntity_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class NamedEntityT extends IdBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'name' value serialised as  XML attribute.
    * <summary>
    * An mandatory descriptive or display name.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Name = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getName() {
        return this.Name.get();
    };

    public void setName( String value) {
        this.Name.set( value);

    }
    // end name
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Description
    // PropertyWrapper{name='Description', typeName='xs:string', docu='null', type=string, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //  https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type true
    /* The 'Description' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> Description = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlElement(name = "Description", required = false)
    public String getDescription() {
        return this.Description.get();
    }
    public void setDescription( String value) {
        this.Description.set( value);
    }




    // end the properties serialised to elements




      public NamedEntityT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
