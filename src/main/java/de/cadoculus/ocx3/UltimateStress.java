
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UltimateStress</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The material ultimate stress.
 *  
 * This class is derived from Quantity_T, uses default unit u_newton_milleMetres2
*/
// UltimateStress https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UltimateStress", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class UltimateStress extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new UltimateStress using the default unit '"u_newton_milleMetres2'
      */
      public UltimateStress()  {
          super(Double.NaN, "u_newton_milleMetres2");
      }

      /**
      * Create a new UltimateStress using the given value and default unit '"u_newton_milleMetres2'
      */
      public UltimateStress(double value) {
         super(value, "u_newton_milleMetres2");
      }

      /**
      * Create a new UltimateStress using the given value and unit
      */
      public UltimateStress(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
