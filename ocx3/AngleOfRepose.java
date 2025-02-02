
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>AngleOfRepose</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The natural angle of repose specifies the angle naturally subtended with the horizontal by
 * 				the upper surface of the conic pile, made by the bulk cargo when loaded into a hold by a chute using
 * 				gravity alone.
 *  
 * This class is derived from Quantity_T, uses default unit u_degrees
*/
// AngleOfRepose https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "AngleOfRepose", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class AngleOfRepose extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new AngleOfRepose using the default unit '"u_degrees'
      */
      public AngleOfRepose()  {
          super(Double.NaN, "u_degrees");
      }

      /**
      * Create a new AngleOfRepose using the given value and default unit '"u_degrees'
      */
      public AngleOfRepose(double value) {
         super(value, "u_degrees");
      }

      /**
      * Create a new AngleOfRepose using the given value and unit
      */
      public AngleOfRepose(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
