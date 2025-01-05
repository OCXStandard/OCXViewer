
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>RuleLength</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Rule (scantling) length, L. A length measurement for the ship that is defined in
 * 				classification society rules (see ISO 10303-218, section 4.2.32.4).
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// RuleLength https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RuleLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class RuleLength extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new RuleLength using the default unit '"u_milliMetres'
      */
      public RuleLength()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new RuleLength using the given value and default unit '"u_milliMetres'
      */
      public RuleLength(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new RuleLength using the given value and unit
      */
      public RuleLength(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
