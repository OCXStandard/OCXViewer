
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CopeLength</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The length of the cope. (The default is CopeLength=CopeRadius)
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// CopeLength https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CopeLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CopeLength extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new CopeLength using the default unit '"u_milliMetres'
      */
      public CopeLength()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new CopeLength using the given value and default unit '"u_milliMetres'
      */
      public CopeLength(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new CopeLength using the given value and unit
      */
      public CopeLength(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
