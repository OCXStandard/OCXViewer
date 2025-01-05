
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>LocalCartesian</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * To specify a Local (Orthogonal) Axis System Origin and two of the local X,Y,Z axis need to
 * 				be specified. When used to specify a Plane the XY (UV) plane is considered. Optional if the coordinate
 * 				system is referring to the global coordinate frame (world coordinates)
 *  

*/
// LocalCartesian https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Transformation_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LocalCartesian", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class LocalCartesian extends TransformationT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public LocalCartesian() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
