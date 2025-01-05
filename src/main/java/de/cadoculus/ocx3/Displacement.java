
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Displacement</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The Radius displacement outside the original corner of the rectangle. If left out (or set
 * 				to zero), the radius passes through the original corner of the rectangle.
 *  
 * This class is derived from Quantity_T, uses default unit u_litres
*/
// Displacement https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Displacement", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Displacement extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Displacement using the default unit '"u_litres'
      */
      public Displacement()  {
          super(Double.NaN, "u_litres");
      }

      /**
      * Create a new Displacement using the given value and default unit '"u_litres'
      */
      public Displacement(double value) {
         super(value, "u_litres");
      }

      /**
      * Create a new Displacement using the given value and unit
      */
      public Displacement(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
