
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ControlPtList_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// ControlPtList_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ControlPtList_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ControlPtListT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ControlPoint
    // PropertyWrapper{name='ControlPoint', typeName='ControlPoint', docu='null', type=ControlPoint, minOccurs=2, maxOccurs=100}
    // TypeWrapper{name='ControlPoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ControlPoint_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ControlPoint' property serialised as  XML elemenmt.
    * 
    */

    private List<ControlPoint> controlPoints = new ArrayList<>();

    public List<ControlPoint> getControlPoint() {
        return controlPoints;
    }




    // end the properties serialised to elements




      public ControlPtListT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
