
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CylindricalAxes_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Cylindrical reference system.
 *  

*/
// CylindricalAxes_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CylindricalAxes_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CylindricalAxesT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property RadialCylinder
    // PropertyWrapper{name='RadialCylinder', typeName='RadialCylinder', docu='null', type=RadialCylinder, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='RadialCylinder', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RadialCylinder_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'RadialCylinder' property serialised as  XML elemenmt.
    * 
    */

    private List<RadialCylinder> radialCylinders = new ArrayList<>();

    public List<RadialCylinder> getRadialCylinder() {
        return radialCylinders;
    }




    // end the properties serialised to elements




      public CylindricalAxesT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
