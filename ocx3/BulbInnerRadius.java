
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BulbInnerRadius</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The inner radius of the bulb.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// BulbInnerRadius https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BulbInnerRadius", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class BulbInnerRadius extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new BulbInnerRadius using the default unit '"u_milliMetres'
      */
      public BulbInnerRadius()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new BulbInnerRadius using the given value and default unit '"u_milliMetres'
      */
      public BulbInnerRadius(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new BulbInnerRadius using the given value and unit
      */
      public BulbInnerRadius(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
