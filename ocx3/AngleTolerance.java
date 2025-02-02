
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>AngleTolerance</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Absolute angular tolerance measure used by the exporting application when defining
 * 				geometry.
 *  
 * This class is derived from Quantity_T, uses default unit u_degrees
*/
// AngleTolerance https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "AngleTolerance", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class AngleTolerance extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new AngleTolerance using the default unit '"u_degrees'
      */
      public AngleTolerance()  {
          super(Double.NaN, "u_degrees");
      }

      /**
      * Create a new AngleTolerance using the given value and default unit '"u_degrees'
      */
      public AngleTolerance(double value) {
         super(value, "u_degrees");
      }

      /**
      * Create a new AngleTolerance using the given value and unit
      */
      public AngleTolerance(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
