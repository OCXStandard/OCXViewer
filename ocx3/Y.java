
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Y</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The Y component of a vector or a position. The value is a Quantity carrying a unit
 * 				definition.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// Y https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Y", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Y extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Y using the default unit '"u_milliMetres'
      */
      public Y()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new Y using the given value and default unit '"u_milliMetres'
      */
      public Y(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new Y using the given value and unit
      */
      public Y(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
