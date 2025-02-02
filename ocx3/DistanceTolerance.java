
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DistanceTolerance</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Absolute tolerance measure used by the exporting application when defining geometry.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// DistanceTolerance https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DistanceTolerance", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class DistanceTolerance extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new DistanceTolerance using the default unit '"u_milliMetres'
      */
      public DistanceTolerance()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new DistanceTolerance using the given value and default unit '"u_milliMetres'
      */
      public DistanceTolerance(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new DistanceTolerance using the given value and unit
      */
      public DistanceTolerance(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
