
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>Dimension</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element to express the dimension of a unit or quantity in terms of the SI base quantities length, mass, time, electric current, thermodynamic temperature, amount of substance, and luminous intensity.
 *  

*/
// Dimension urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// DimensionType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Dimension", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class Dimension extends DimensionType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Dimension() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
