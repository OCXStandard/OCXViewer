
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SlammingDraughtFullFP</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The Vessel draught at FP used when calculation design slamming loads (all ballast tanks
 * 				full), Tf-f.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// SlammingDraughtFullFP https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SlammingDraughtFullFP", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class SlammingDraughtFullFP extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new SlammingDraughtFullFP using the default unit '"u_milliMetres'
      */
      public SlammingDraughtFullFP()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new SlammingDraughtFullFP using the given value and default unit '"u_milliMetres'
      */
      public SlammingDraughtFullFP(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new SlammingDraughtFullFP using the given value and unit
      */
      public SlammingDraughtFullFP(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
