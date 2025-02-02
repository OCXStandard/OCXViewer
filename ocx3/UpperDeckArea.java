
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UpperDeckArea</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Projected area of upper deck forward 0.2 L.
 *  
 * This class is derived from Quantity_T, uses default unit u_metres2
*/
// UpperDeckArea https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UpperDeckArea", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class UpperDeckArea extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new UpperDeckArea using the default unit '"u_metres2'
      */
      public UpperDeckArea()  {
          super(Double.NaN, "u_metres2");
      }

      /**
      * Create a new UpperDeckArea using the given value and default unit '"u_metres2'
      */
      public UpperDeckArea(double value) {
         super(value, "u_metres2");
      }

      /**
      * Create a new UpperDeckArea using the given value and unit
      */
      public UpperDeckArea(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
