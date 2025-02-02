
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Overshoot</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The overshoot of the flange beyond the web. Shall be included in the Width..
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// Overshoot https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Overshoot", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Overshoot extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Overshoot using the default unit '"u_milliMetres'
      */
      public Overshoot()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new Overshoot using the given value and default unit '"u_milliMetres'
      */
      public Overshoot(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new Overshoot using the given value and unit
      */
      public Overshoot(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
