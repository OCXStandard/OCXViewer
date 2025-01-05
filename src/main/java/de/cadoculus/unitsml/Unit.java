
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>Unit</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element for describing units. Use in containers UnitSet or directly incorporate into a host schema.
 *  

*/
// Unit urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// UnitType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Unit", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class Unit extends UnitType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Unit() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
