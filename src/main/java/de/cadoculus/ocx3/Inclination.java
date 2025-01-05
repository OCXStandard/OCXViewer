
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Inclination</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The inclination of the cross-section of a stiffener or a pillar along its trace line. A
 * 				vector pair giving the local orientation of the web and flange directions at the point given by the
 * 				Position element. The FlangeDirection is optional and not necessary for a symmetrical cross-section.
 * 				Only one inclination is necessary for a non-twisted (straight) stiffener or pillar.
 *  

*/
// Inclination https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Inclination_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Inclination", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class Inclination extends InclinationT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Inclination() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
