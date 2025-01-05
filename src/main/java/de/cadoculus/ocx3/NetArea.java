
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>NetArea</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The net plate area computed by the sending application. The NetArea is the net area of the plate representing the actual plate contour and cut-outs removing material from the plate:
 * 				NetAra*t*density = DryWeight
 *  
 * This class is derived from Quantity_T, uses default unit u_metres2
*/
// NetArea https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "NetArea", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class NetArea extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new NetArea using the default unit '"u_metres2'
      */
      public NetArea()  {
          super(Double.NaN, "u_metres2");
      }

      /**
      * Create a new NetArea using the given value and default unit '"u_metres2'
      */
      public NetArea(double value) {
         super(value, "u_metres2");
      }

      /**
      * Create a new NetArea using the given value and unit
      */
      public NetArea(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
