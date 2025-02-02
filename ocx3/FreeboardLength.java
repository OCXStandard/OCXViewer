
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FreeboardLength</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The free-board length of the Vessel, Lll.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// FreeboardLength https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FreeboardLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class FreeboardLength extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new FreeboardLength using the default unit '"u_milliMetres'
      */
      public FreeboardLength()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new FreeboardLength using the given value and default unit '"u_milliMetres'
      */
      public FreeboardLength(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new FreeboardLength using the given value and unit
      */
      public FreeboardLength(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
