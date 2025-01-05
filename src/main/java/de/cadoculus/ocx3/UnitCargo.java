
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UnitCargo</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The UnitCargo type is intended for spaces carrying a type of dry cargo that that is packed
 * 				or comprises discrete units that can be loaded and stored individually on the ship. Ref. is made to ISO
 * 				10303-215:2004.
 *  

*/
// UnitCargo https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// UnitCargo_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitCargo", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class UnitCargo extends UnitCargoT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public UnitCargo() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
