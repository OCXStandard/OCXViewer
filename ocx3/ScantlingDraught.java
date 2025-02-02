
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ScantlingDraught</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Design draught moulded, fully loaded condition, Td. The summer load draught used by the
 * 				classification society in its calculations for structural integrity and strength (see ISO 10303-218,
 * 				section 4.2.32.6).
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// ScantlingDraught https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ScantlingDraught", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ScantlingDraught extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new ScantlingDraught using the default unit '"u_milliMetres'
      */
      public ScantlingDraught()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new ScantlingDraught using the given value and default unit '"u_milliMetres'
      */
      public ScantlingDraught(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new ScantlingDraught using the given value and unit
      */
      public ScantlingDraught(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
