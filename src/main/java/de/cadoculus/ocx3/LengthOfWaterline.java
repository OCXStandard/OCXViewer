
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>LengthOfWaterline</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The length of the waterline at T, Lwl.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// LengthOfWaterline https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LengthOfWaterline", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class LengthOfWaterline extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new LengthOfWaterline using the default unit '"u_milliMetres'
      */
      public LengthOfWaterline()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new LengthOfWaterline using the given value and default unit '"u_milliMetres'
      */
      public LengthOfWaterline(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new LengthOfWaterline using the given value and unit
      */
      public LengthOfWaterline(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
