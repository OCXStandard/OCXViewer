
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CutbackDistance</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Distance from stiffener logical end position to the start of the web cutback.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// CutbackDistance https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CutbackDistance", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CutbackDistance extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new CutbackDistance using the default unit '"u_milliMetres'
      */
      public CutbackDistance()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new CutbackDistance using the given value and default unit '"u_milliMetres'
      */
      public CutbackDistance(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new CutbackDistance using the given value and unit
      */
      public CutbackDistance(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
