
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Area</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The bar section area.
 *  
 * This class is derived from Quantity_T, uses default unit u_metres2
*/
// Area https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Area", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Area extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Area using the default unit '"u_metres2'
      */
      public Area()  {
          super(Double.NaN, "u_metres2");
      }

      /**
      * Create a new Area using the given value and default unit '"u_metres2'
      */
      public Area(double value) {
         super(value, "u_metres2");
      }

      /**
      * Create a new Area using the given value and unit
      */
      public Area(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
