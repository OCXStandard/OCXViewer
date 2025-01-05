
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SurfaceCollection</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A collection of any number of surfaces. The surfaces have to be connected (no dis-joint surfaces). Most typically the SurfaceCollection will include the outer shell geometry definition of the vessel.
 *  

*/
// SurfaceCollection https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// SurfaceCollection_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SurfaceCollection", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class SurfaceCollection extends SurfaceCollectionT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public SurfaceCollection() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
