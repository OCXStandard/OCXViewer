
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>LiquidCargo</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Liquid cargo properties, reference is made to ISO 10303-215:2004. A liquid cargo is a type
 * 				of Cargo whose natural condition is a non-solid, non-gaseous liquid state.
 *  

*/
// LiquidCargo https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// LiquidCargo_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LiquidCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class LiquidCargo extends LiquidCargoT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public LiquidCargo() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
