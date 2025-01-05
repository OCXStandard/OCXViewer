
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ZPosOfDeck</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Z coordinate of the bulkhead deck.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// ZPosOfDeck https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ZPosOfDeck", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ZPosOfDeck extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new ZPosOfDeck using the default unit '"u_milliMetres'
      */
      public ZPosOfDeck()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new ZPosOfDeck using the given value and default unit '"u_milliMetres'
      */
      public ZPosOfDeck(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new ZPosOfDeck using the given value and unit
      */
      public ZPosOfDeck(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
