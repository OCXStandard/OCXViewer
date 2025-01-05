
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CarriagePressure</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The CarriagePressure specifies the required pressure of the compartment in which the cargo
 * 				is to be carried.
 *  
 * This class is derived from Quantity_T, uses default unit u_bar
*/
// CarriagePressure https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CarriagePressure", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CarriagePressure extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new CarriagePressure using the default unit '"u_bar'
      */
      public CarriagePressure()  {
          super(Double.NaN, "u_bar");
      }

      /**
      * Create a new CarriagePressure using the given value and default unit '"u_bar'
      */
      public CarriagePressure(double value) {
         super(value, "u_bar");
      }

      /**
      * Create a new CarriagePressure using the given value and unit
      */
      public CarriagePressure(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
