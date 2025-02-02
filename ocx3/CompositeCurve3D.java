
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CompositeCurve3D</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The concept of a composite curve composed of a collection of Line3D, CircumArc3D and/or NURBS segments. Curves are sorted end to end and have C0 continuity across each segment in the CompositeCurve3D definition.
 *  

*/
// CompositeCurve3D https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// CompositeCurve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CompositeCurve3D", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CompositeCurve3D extends CompositeCurve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public CompositeCurve3D() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
