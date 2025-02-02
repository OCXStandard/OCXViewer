
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Permeability</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The permeability specifies the amount by which the Cargo takes up water.
 *  
 * This class is derived from Quantity_T, uses default unit u_dimbulb
*/
// Permeability https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Permeability", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Permeability extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Permeability using the default unit '"u_dimbulb'
      */
      public Permeability()  {
          super(Double.NaN, "u_dimbulb");
      }

      /**
      * Create a new Permeability using the given value and default unit '"u_dimbulb'
      */
      public Permeability(double value) {
         super(value, "u_dimbulb");
      }

      /**
      * Create a new Permeability using the given value and unit
      */
      public Permeability(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
