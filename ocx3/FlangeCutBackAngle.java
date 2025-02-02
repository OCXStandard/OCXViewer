
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FlangeCutBackAngle</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Cut angle of stiffener flange.
 *  
 * This class is derived from Quantity_T, uses default unit u_degrees
*/
// FlangeCutBackAngle https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FlangeCutBackAngle", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class FlangeCutBackAngle extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new FlangeCutBackAngle using the default unit '"u_degrees'
      */
      public FlangeCutBackAngle()  {
          super(Double.NaN, "u_degrees");
      }

      /**
      * Create a new FlangeCutBackAngle using the given value and default unit '"u_degrees'
      */
      public FlangeCutBackAngle(double value) {
         super(value, "u_degrees");
      }

      /**
      * Create a new FlangeCutBackAngle using the given value and unit
      */
      public FlangeCutBackAngle(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
