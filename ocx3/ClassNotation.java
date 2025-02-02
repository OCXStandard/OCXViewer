
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ClassNotation</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The notations given to the hull and machinery of the Ship by the classification society as
 * 				a result of its approval activities during the design, manufacture and in-service maintenance of the
 * 				ship (see ISO 10303-218, section 4.2.35).
 *  

*/
// ClassNotation https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ClassNotation_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ClassNotation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ClassNotation extends ClassNotationT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ClassNotation() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
