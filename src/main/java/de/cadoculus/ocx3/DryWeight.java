
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DryWeight</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The total dry weight of the parent member.
 *  
 * This class is derived from Quantity_T, uses default unit u_kg
*/
// DryWeight https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DryWeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class DryWeight extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new DryWeight using the default unit '"u_kg'
      */
      public DryWeight()  {
          super(Double.NaN, "u_kg");
      }

      /**
      * Create a new DryWeight using the given value and default unit '"u_kg'
      */
      public DryWeight(double value) {
         super(value, "u_kg");
      }

      /**
      * Create a new DryWeight using the given value and unit
      */
      public DryWeight(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
