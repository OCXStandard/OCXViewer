
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Transformation</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A concept specifying a local (orthogonal) axis system. The Origin and two of the local
 * 				X,Y,Z axis have to be specified. When used to specify a Plane the XY (UV) plane is considered. The third
 * 				axis is found by the cross product of the primary and secondary axis.
 *  

*/
// Transformation https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Transformation_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Transformation", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Transformation extends TransformationT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Transformation() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
