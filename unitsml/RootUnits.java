
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>RootUnits</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Container for defining derived units in terms of their root units. This allows a precise definition of a wide range of units. The goal is to improve interoperability among applications and databases which use derived units based on commonly encountered root units.
 *  

*/
// RootUnits urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// RootUnitsType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RootUnits", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class RootUnits extends RootUnitsType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public RootUnits() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
