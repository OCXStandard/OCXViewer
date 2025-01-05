
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>EdgeReinforcement</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * An EdgeReinforcement is used as a faceplate or edge reinforcement for a Panel, Plate or Bracket. The EdgeReinforcement is composed of a BarSection (usually a flat bar profile) and is attached to a FreeEdgeCurve which is part of the Panel or Plate LimitedBy. The EdgeReinforcement can reference one or more limits for the Panel/Plate/Bracket. At the same time the EdgeReinforcement provides its own TraceLine to determine the actual extent of the reinforcement.
 *  

*/
// EdgeReinforcement https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EdgeReinforcement_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "EdgeReinforcement", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class EdgeReinforcement extends EdgeReinforcementT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public EdgeReinforcement() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
