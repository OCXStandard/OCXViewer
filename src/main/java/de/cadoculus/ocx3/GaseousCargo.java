
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>GaseousCargo</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Liquid cargo properties, reference is made to ISO 10303-215:2004. A Gaseous cargo is a
 * 				type of Cargo that has a natural condition of a non-solid, non-liquid
 * 				gaseous state.
 *  

*/
// GaseousCargo https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// GaseousCargo_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "GaseousCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class GaseousCargo extends GaseousCargoT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public GaseousCargo() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
