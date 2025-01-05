
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ReferencePlane_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the concept of a reference plane which is typically used to define an
 * 				unbounded geometry.
 *  

*/
// ReferencePlane_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ReferencePlane_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ReferencePlaneT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ReferencePlaneT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
