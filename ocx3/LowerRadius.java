
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>LowerRadius</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The lower radius of an opening or slot.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// LowerRadius https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LowerRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class LowerRadius extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new LowerRadius using the default unit '"u_milliMetres'
      */
      public LowerRadius()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new LowerRadius using the given value and default unit '"u_milliMetres'
      */
      public LowerRadius(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new LowerRadius using the given value and unit
      */
      public LowerRadius(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
