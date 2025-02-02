
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The abstract <code>Quantity</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Abstract base class for all types with values carrying a Unit : Q = v * u.
 *  
 * This class is derived from Quantity_T, uses default unit !!!no default unit configured for Quantity!!!
*/
// Quantity https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Quantity", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Quantity extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Quantity using the default unit '"!!!no default unit configured for Quantity!!!'
      */
      public Quantity()  {
          super(Double.NaN, "!!!no default unit configured for Quantity!!!");
      }

      /**
      * Create a new Quantity using the given value and default unit '"!!!no default unit configured for Quantity!!!'
      */
      public Quantity(double value) {
         super(value, "!!!no default unit configured for Quantity!!!");
      }

      /**
      * Create a new Quantity using the given value and unit
      */
      public Quantity(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
