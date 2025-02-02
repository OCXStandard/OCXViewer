
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SweepLength</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The sweep length used to extrude a surface from a base curve.
 *  
 * This class is derived from Quantity_T, uses default unit !!!no default unit configured for SweepLength!!!
*/
// SweepLength https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SweepLength", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class SweepLength extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new SweepLength using the default unit '"!!!no default unit configured for SweepLength!!!'
      */
      public SweepLength()  {
          super(Double.NaN, "!!!no default unit configured for SweepLength!!!");
      }

      /**
      * Create a new SweepLength using the given value and default unit '"!!!no default unit configured for SweepLength!!!'
      */
      public SweepLength(double value) {
         super(value, "!!!no default unit configured for SweepLength!!!");
      }

      /**
      * Create a new SweepLength using the given value and unit
      */
      public SweepLength(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
