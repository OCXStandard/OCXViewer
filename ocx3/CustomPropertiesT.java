
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CustomProperties_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// CustomProperties_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CustomProperties_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CustomPropertiesT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CustomProperty
    // PropertyWrapper{name='CustomProperty', typeName='CustomProperty', docu='null', type=CustomProperty, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='CustomProperty', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CustomProperty_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CustomProperty' property serialised as  XML elemenmt.
    * 
    */

    private List<CustomProperty> customPropertys = new ArrayList<>();

    public List<CustomProperty> getCustomProperty() {
        return customPropertys;
    }




    // end the properties serialised to elements




      public CustomPropertiesT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
