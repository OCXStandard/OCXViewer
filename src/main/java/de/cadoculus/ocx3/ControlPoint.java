
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ControlPoint</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A NURBS control point composed of a weight and spatial position.
 *  

*/
// ControlPoint https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ControlPoint_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ControlPoint", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ControlPoint extends ControlPointT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ControlPoint() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
