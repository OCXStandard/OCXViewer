
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DesignSpeed</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The forward or service speed at which the ship is designed to operate (see ISO 10303-218,
 * 				section 4.2.32.2).
 *  
 * This class is derived from Quantity_T, uses default unit u_knots
*/
// DesignSpeed https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DesignSpeed", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class DesignSpeed extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new DesignSpeed using the default unit '"u_knots'
      */
      public DesignSpeed()  {
          super(Double.NaN, "u_knots");
      }

      /**
      * Create a new DesignSpeed using the given value and default unit '"u_knots'
      */
      public DesignSpeed(double value) {
         super(value, "u_knots");
      }

      /**
      * Create a new DesignSpeed using the given value and unit
      */
      public DesignSpeed(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
