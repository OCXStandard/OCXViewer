
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>RectangularMickeyMouseEars</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A rectangular hole with corner radii in the form of Mickey Mouse ears.
 *  

*/
// RectangularMickeyMouseEars https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// RectangularMickeyMouseEars_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RectangularMickeyMouseEars", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class RectangularMickeyMouseEars extends RectangularMickeyMouseEarsT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public RectangularMickeyMouseEars() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
