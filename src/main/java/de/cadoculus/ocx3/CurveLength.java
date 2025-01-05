
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CurveLength</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The curve length computed by the sending application. Used to verify geometry reconstruction.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres
*/
// CurveLength https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CurveLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CurveLength extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new CurveLength using the default unit '"u_milliMetres'
      */
      public CurveLength()  {
          super(Double.NaN, "u_milliMetres");
      }

      /**
      * Create a new CurveLength using the given value and default unit '"u_milliMetres'
      */
      public CurveLength(double value) {
         super(value, "u_milliMetres");
      }

      /**
      * Create a new CurveLength using the given value and unit
      */
      public CurveLength(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
