
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>InertiaV</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Moment of inertia around NeutralAxisV.
 *  
 * This class is derived from Quantity_T, uses default unit u_kg_m2
*/
// InertiaV https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "InertiaV", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class InertiaV extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new InertiaV using the default unit '"u_kg_m2'
      */
      public InertiaV()  {
          super(Double.NaN, "u_kg_m2");
      }

      /**
      * Create a new InertiaV using the given value and default unit '"u_kg_m2'
      */
      public InertiaV(double value) {
         super(value, "u_kg_m2");
      }

      /**
      * Create a new InertiaV using the given value and unit
      */
      public InertiaV(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
