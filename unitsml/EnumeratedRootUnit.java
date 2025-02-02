
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>EnumeratedRootUnit</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element for a root unit (from an extensive enumerated list) allowing an optional prefix and power. E.g., mm^2
 *  

*/
// EnumeratedRootUnit urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// EnumeratedRootUnitType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "EnumeratedRootUnit", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class EnumeratedRootUnit extends EnumeratedRootUnitType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public EnumeratedRootUnit() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
