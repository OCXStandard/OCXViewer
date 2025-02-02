
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>LuminousIntensity</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element containing the dimension of the quantity luminous intensity.
 *  

*/
// LuminousIntensity urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// LuminousIntensityType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LuminousIntensity", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class LuminousIntensity extends LuminousIntensityType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public LuminousIntensity() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
