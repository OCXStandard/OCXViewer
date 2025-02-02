
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CoordinateSystem</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A right-handed orthogonal Cartesian coordinate system. Used to define the vessel
 * 				coordinate system definition., either in world coordinates (mandatory) or as additional local systems if
 * 				necessary.
 *  

*/
// CoordinateSystem https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// CoordinateSystem_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CoordinateSystem", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CoordinateSystem extends CoordinateSystemT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public CoordinateSystem() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
