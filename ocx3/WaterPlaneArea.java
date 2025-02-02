
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>WaterPlaneArea</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The area of water-plane forward 0.2 L at scantling draught Td.
 *  
 * This class is derived from Quantity_T, uses default unit u_metres2
*/
// WaterPlaneArea https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "WaterPlaneArea", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class WaterPlaneArea extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new WaterPlaneArea using the default unit '"u_metres2'
      */
      public WaterPlaneArea()  {
          super(Double.NaN, "u_metres2");
      }

      /**
      * Create a new WaterPlaneArea using the given value and default unit '"u_metres2'
      */
      public WaterPlaneArea(double value) {
         super(value, "u_metres2");
      }

      /**
      * Create a new WaterPlaneArea using the given value and unit
      */
      public WaterPlaneArea(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
