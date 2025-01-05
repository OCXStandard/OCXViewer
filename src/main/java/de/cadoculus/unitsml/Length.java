
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>Length</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element containing the dimension of the quantity length.
 *  

*/
// Length urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// LengthType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Length", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class Length extends LengthType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Length() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
