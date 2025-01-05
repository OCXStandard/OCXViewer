
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>StowageFactor</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The StowageFactor specifies the average specific volume for a dry cargo. The stowage
 * 				factor is usually expressed as the volume in cubic meters that is occupied by one metric ton of the
 * 				cargo.
 *  
 * This class is derived from Quantity_T, uses default unit u_m3_ton
*/
// StowageFactor https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "StowageFactor", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class StowageFactor extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new StowageFactor using the default unit '"u_m3_ton'
      */
      public StowageFactor()  {
          super(Double.NaN, "u_m3_ton");
      }

      /**
      * Create a new StowageFactor using the given value and default unit '"u_m3_ton'
      */
      public StowageFactor(double value) {
         super(value, "u_m3_ton");
      }

      /**
      * Create a new StowageFactor using the given value and unit
      */
      public StowageFactor(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
