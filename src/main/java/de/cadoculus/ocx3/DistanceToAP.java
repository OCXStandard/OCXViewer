
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DistanceToAP</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The offset of frame zero (#0) from the After Perpendicular (AP). The default is zero
 * 				offset (#0 is located at AP)
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// DistanceToAP https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DistanceToAP", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class DistanceToAP extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new DistanceToAP using the default unit '"u_milliMetres'
      */
      public DistanceToAP()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new DistanceToAP using the given value and default unit '"u_milliMetres'
      */
      public DistanceToAP(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new DistanceToAP using the given value and unit
      */
      public DistanceToAP(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
