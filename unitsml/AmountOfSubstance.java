
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>AmountOfSubstance</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element containing the dimension of the quantity amount of substance.
 *  

*/
// AmountOfSubstance urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// AmountOfSubstanceType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "AmountOfSubstance", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class AmountOfSubstance extends AmountOfSubstanceType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public AmountOfSubstance() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
