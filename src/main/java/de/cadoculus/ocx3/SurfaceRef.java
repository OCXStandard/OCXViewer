
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SurfaceRef</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The reference to a Surface geometry which is shared between more than one part.
 *  

*/
// SurfaceRef https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// SurfaceRef_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SurfaceRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class SurfaceRef extends SurfaceRefT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public SurfaceRef() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
