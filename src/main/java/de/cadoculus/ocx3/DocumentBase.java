
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The abstract <code>DocumentBase</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Abstract base class for the XML document defined in this schema.
 *  

*/
// DocumentBase https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DocumentBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DocumentBase", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class DocumentBase extends DocumentBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public DocumentBase() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
