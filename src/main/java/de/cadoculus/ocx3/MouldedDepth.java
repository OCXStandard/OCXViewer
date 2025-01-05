
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>MouldedDepth</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The moulded depth of the Vessel, D.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// MouldedDepth https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "MouldedDepth", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class MouldedDepth extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new MouldedDepth using the default unit '"u_milliMetres'
      */
      public MouldedDepth()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new MouldedDepth using the given value and default unit '"u_milliMetres'
      */
      public MouldedDepth(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new MouldedDepth using the given value and unit
      */
      public MouldedDepth(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
