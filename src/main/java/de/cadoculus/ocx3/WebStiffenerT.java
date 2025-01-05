
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>WebStiffener_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Web stiffener with single bracket connection.
 *  

*/
// WebStiffener_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "WebStiffener_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class WebStiffenerT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property WebStiffenerRef
    // PropertyWrapper{name='WebStiffenerRef', typeName='WebStiffenerRef', docu='null', type=WebStiffenerRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='WebStiffenerRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='WebStiffenerRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'WebStiffenerRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<WebStiffenerRef> WebStiffenerRef = new javafx.beans.property.SimpleObjectProperty<WebStiffenerRef>();

    @XmlElement(name = "WebStiffenerRef", required = true)
    public WebStiffenerRef getWebStiffenerRef() {
        return this.WebStiffenerRef.get();
    }
    public void setWebStiffenerRef( WebStiffenerRef value) {
        this.WebStiffenerRef.set( value);
    }




    // end the properties serialised to elements




      public WebStiffenerT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
