
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>InertiaU</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Moment of inertia around NeutralAxisU.
 *  
 * This class is derived from Quantity_T, uses default unit u_kg_m2
*/
// InertiaU https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "InertiaU", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class InertiaU extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new InertiaU using the default unit '"u_kg_m2'
      */
      public InertiaU()  {
          super(Double.NaN, "u_kg_m2");
      }

      /**
      * Create a new InertiaU using the given value and default unit '"u_kg_m2'
      */
      public InertiaU(double value) {
         super(value, "u_kg_m2");
      }

      /**
      * Create a new InertiaU using the given value and unit
      */
      public InertiaU(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
