
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>MouldedBreadth</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The moulded breadth of the Vessel, B.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// MouldedBreadth https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "MouldedBreadth", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class MouldedBreadth extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new MouldedBreadth using the default unit '"u_milliMetres'
      */
      public MouldedBreadth()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new MouldedBreadth using the given value and default unit '"u_milliMetres'
      */
      public MouldedBreadth(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new MouldedBreadth using the given value and unit
      */
      public MouldedBreadth(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
