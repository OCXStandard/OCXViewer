
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>WebStiffenerWithSingleBracket</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Connection configuration with one web stiffener with a single bracket connection.
 *  

*/
// WebStiffenerWithSingleBracket https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// WebStiffenerWithSingleBracket_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "WebStiffenerWithSingleBracket", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class WebStiffenerWithSingleBracket extends WebStiffenerWithSingleBracketT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public WebStiffenerWithSingleBracket() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
