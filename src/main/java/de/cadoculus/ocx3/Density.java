
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Density</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The material density.
 *  
 * This class is derived from Quantity_T, uses default unit u_kg_m3
*/
// Density https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Density", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Density extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new Density using the default unit '"u_kg_m3'
      */
      public Density()  {
          super(Double.NaN, "u_kg_m3");
      }

      /**
      * Create a new Density using the given value and default unit '"u_kg_m3'
      */
      public Density(double value) {
         super(value, "u_kg_m3");
      }

      /**
      * Create a new Density using the given value and unit
      */
      public Density(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
