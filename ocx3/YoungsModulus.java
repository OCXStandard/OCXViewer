
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>YoungsModulus</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The material elasticity modulus.
 *  
 * This class is derived from Quantity_T, uses default unit u_bar
*/
// YoungsModulus https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "YoungsModulus", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class YoungsModulus extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new YoungsModulus using the default unit '"u_bar'
      */
      public YoungsModulus()  {
          super(Double.NaN, "u_bar");
      }

      /**
      * Create a new YoungsModulus using the given value and default unit '"u_bar'
      */
      public YoungsModulus(double value) {
         super(value, "u_bar");
      }

      /**
      * Create a new YoungsModulus using the given value and unit
      */
      public YoungsModulus(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
