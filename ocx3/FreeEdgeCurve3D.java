
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FreeEdgeCurve3D</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A single Curve3D or a collection of continuous non-closed Curve3D types which are used to
 * 				represent a free edge of a panel or plate in shipbuilding.
 *  

*/
// FreeEdgeCurve3D https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// FreeEdgeCurve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FreeEdgeCurve3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class FreeEdgeCurve3D extends FreeEdgeCurve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public FreeEdgeCurve3D() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
