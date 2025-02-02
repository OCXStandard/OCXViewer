
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>TorsionConstant</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The torsional constant is calculated from the cross-section and determines the torsional
 * 				rigidity together with the shear modulus.
 *  
 * This class is derived from Quantity_T, uses default unit u_milliMetres4
*/
// TorsionConstant https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "TorsionConstant", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class TorsionConstant extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new TorsionConstant using the default unit '"u_milliMetres4'
      */
      public TorsionConstant()  {
          super(Double.NaN, "u_milliMetres4");
      }

      /**
      * Create a new TorsionConstant using the given value and default unit '"u_milliMetres4'
      */
      public TorsionConstant(double value) {
         super(value, "u_milliMetres4");
      }

      /**
      * Create a new TorsionConstant using the given value and unit
      */
      public TorsionConstant(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
