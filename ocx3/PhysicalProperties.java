
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PhysicalProperties</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Basic physical properties of structure objects (weight and centre of gravity). These properties are provided by the exporting application and can be used as a quality measure by the receiving application to ensure correctness of the import.
 *  

*/
// PhysicalProperties https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// PhysicalProperties_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PhysicalProperties", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class PhysicalProperties extends PhysicalPropertiesT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public PhysicalProperties() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
