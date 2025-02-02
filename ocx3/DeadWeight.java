
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DeadWeight</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The weight of the passengers, crew, cargo, stores, ballast, fresh water, fuel oil, and
 * 				other consumables being carried by a ship (see ISO 10303-215, section 4.2.74).
 *  
 * This class is derived from Quantity_T, uses default unit u_kg
*/
// DeadWeight https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DeadWeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class DeadWeight extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new DeadWeight using the default unit '"u_kg'
      */
      public DeadWeight()  {
          super(Double.NaN, "u_kg");
      }

      /**
      * Create a new DeadWeight using the given value and default unit '"u_kg'
      */
      public DeadWeight(double value) {
         super(value, "u_kg");
      }

      /**
      * Create a new DeadWeight using the given value and unit
      */
      public DeadWeight(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
