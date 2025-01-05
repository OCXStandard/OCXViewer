
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ApplicationRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// ApplicationRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ReferenceBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ApplicationRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ApplicationRefT extends ReferenceBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='externalRef', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'externalRef' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> ExternalRef = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "externalRef", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getExternalRef() {
        return this.ExternalRef.get();
    };

    public void setExternalRef( String value) {
        this.ExternalRef.set( value);

    }
    // end externalRef
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ApplicationRefT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
