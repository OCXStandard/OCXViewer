
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>DimensionSet</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Container for dimensions.
 *  

*/
// DimensionSet urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// DimensionSetType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DimensionSet", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class DimensionSet extends DimensionSetType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public DimensionSet() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
