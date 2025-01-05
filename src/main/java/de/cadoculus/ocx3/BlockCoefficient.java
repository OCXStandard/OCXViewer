
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BlockCoefficient</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The ratio of the moulded displacement volume to the volume of a block that has its length
 * 				equal to the length class, its breadth equal to the moulded breadth and its depth equal to the
 * 				scantlings draught (see ISO 10303-218, section 4.2.32.1).
 *  
 * This class is derived from Quantity_T, uses default unit u_dimbulb
*/
// BlockCoefficient https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BlockCoefficient", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class BlockCoefficient extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



      /**
      * Create a new BlockCoefficient using the default unit '"u_dimbulb'
      */
      public BlockCoefficient()  {
          super(Double.NaN, "u_dimbulb");
      }

      /**
      * Create a new BlockCoefficient using the given value and default unit '"u_dimbulb'
      */
      public BlockCoefficient(double value) {
         super(value, "u_dimbulb");
      }

      /**
      * Create a new BlockCoefficient using the given value and unit
      */
      public BlockCoefficient(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
