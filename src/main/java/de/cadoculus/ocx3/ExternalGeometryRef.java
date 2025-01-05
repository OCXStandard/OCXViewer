
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ExternalGeometryRef</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The ExternalGeometryRef element is used to point to an external geometry representation of the parent entity (e.g. Plate, Stiffener, Bracket, Member).
 *  

*/
// ExternalGeometryRef https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ExternalGeometryRef_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ExternalGeometryRef", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class ExternalGeometryRef extends ExternalGeometryRefT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ExternalGeometryRef() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
