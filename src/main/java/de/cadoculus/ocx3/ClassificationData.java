
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ClassificationData</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Information that specifies design and intended performance characteristics of the ship in
 * 				accordance with classification society rules and statutory regulations (see ISO 10303-218, section
 * 				4.2.36).
 *  

*/
// ClassificationData https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ClassData_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ClassificationData", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ClassificationData extends ClassDataT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ClassificationData() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
