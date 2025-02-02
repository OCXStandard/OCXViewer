
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>AirPipeHeight</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The AirpipeHeight specifies height from the baseline to the top of the air pipe, if any.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// AirPipeHeight https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "AirPipeHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class AirPipeHeight extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new AirPipeHeight using the default unit '"u_milliMetres'
      */
      public AirPipeHeight()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new AirPipeHeight using the given value and default unit '"u_milliMetres'
      */
      public AirPipeHeight(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new AirPipeHeight using the given value and unit
      */
      public AirPipeHeight(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
