
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Start</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The location of Frame 0 in the frame table.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// Start https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Start", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Start extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Start using the default unit '"u_milliMetres'
      */
      public Start()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new Start using the given value and default unit '"u_milliMetres'
      */
      public Start(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new Start using the given value and unit
      */
      public Start(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
