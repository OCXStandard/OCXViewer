
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SlammingDraughtEmptyFP</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The design slamming draught at FP (all ballast tanks empty), Tf-e.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// SlammingDraughtEmptyFP https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SlammingDraughtEmptyFP", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class SlammingDraughtEmptyFP extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new SlammingDraughtEmptyFP using the default unit '"u_milliMetres'
      */
      public SlammingDraughtEmptyFP()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new SlammingDraughtEmptyFP using the given value and default unit '"u_milliMetres'
      */
      public SlammingDraughtEmptyFP(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new SlammingDraughtEmptyFP using the given value and unit
      */
      public SlammingDraughtEmptyFP(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
