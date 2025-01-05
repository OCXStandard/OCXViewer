
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FillingHeight</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The filling_height specifies the maximum height for filling of the tank compartment.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// FillingHeight https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FillingHeight", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class FillingHeight extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new FillingHeight using the default unit '"u_milliMetres'
      */
      public FillingHeight()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new FillingHeight using the given value and default unit '"u_milliMetres'
      */
      public FillingHeight(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new FillingHeight using the given value and unit
      */
      public FillingHeight(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
