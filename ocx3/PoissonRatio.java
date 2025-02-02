
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PoissonRatio</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The material Poisson's ration.
 *  
 * This class is derived from Quantity_T, uses default unit u_dimbulb
*/
// PoissonRatio https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PoissonRatio", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class PoissonRatio extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new PoissonRatio using the default unit '"u_dimbulb'
      */
      public PoissonRatio()  {
          super(Double.NaN, "u_dimbulb");
      }

      /**
      * Create a new PoissonRatio using the given value and default unit '"u_dimbulb'
      */
      public PoissonRatio(double value) {
         super(value, "u_dimbulb");
      }

      /**
      * Create a new PoissonRatio using the given value and unit
      */
      public PoissonRatio(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
