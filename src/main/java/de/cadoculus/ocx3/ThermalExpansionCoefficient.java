
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ThermalExpansionCoefficient</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The material thermal expansion coefficient.
 *  
 * This class is derived from Quantity_T, uses default unit u_per_kelvin
*/
// ThermalExpansionCoefficient https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ThermalExpansionCoefficient", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ThermalExpansionCoefficient extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new ThermalExpansionCoefficient using the default unit '"u_per_kelvin'
      */
      public ThermalExpansionCoefficient()  {
          super(Double.NaN, "u_per_kelvin");
      }

      /**
      * Create a new ThermalExpansionCoefficient using the given value and default unit '"u_per_kelvin'
      */
      public ThermalExpansionCoefficient(double value) {
         super(value, "u_per_kelvin");
      }

      /**
      * Create a new ThermalExpansionCoefficient using the given value and unit
      */
      public ThermalExpansionCoefficient(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
