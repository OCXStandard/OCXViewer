
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Contour3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The geometry of a closed contour limiting a surface, represented by a set of trim curves or a closed curve primitive. The contour curve must form a closed curve.
 *  

*/
// Contour3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Contour3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Contour3DT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Curve3D
    // PropertyWrapper{name='Curve3D', typeName='Curve3D', docu='null', type=Curve3D, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Curve3D', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Curve3D' property serialised as  XML elemenmt.
    * 
    */

    private List<Curve3D> curve3Ds = new ArrayList<>();

    public List<Curve3D> getCurve3D() {
        return curve3Ds;
    }




    // end the properties serialised to elements




      public Contour3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
