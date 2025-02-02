
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CutBy_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of  a structural concept defining a cut-out in a surface defined by a parametric hole or a set of generic trim curves.
 *  

*/
// CutBy_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CutBy_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CutByT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Hole2DContour
    // PropertyWrapper{name='Hole2DContour', typeName='Hole2DContour', docu='null', type=Hole2DContour, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Hole2DContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Hole2DContour_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Hole2DContour' property serialised as  XML elemenmt.
    * 
    */

    private List<Hole2DContour> hole2DContours = new ArrayList<>();

    public List<Hole2DContour> getHole2DContour() {
        return hole2DContours;
    }




    // Property InnerContour
    // PropertyWrapper{name='InnerContour', typeName='InnerContour', docu='null', type=InnerContour, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='InnerContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'InnerContour' property serialised as  XML elemenmt.
    * 
    */

    private List<InnerContour> innerContours = new ArrayList<>();

    public List<InnerContour> getInnerContour() {
        return innerContours;
    }




    // end the properties serialised to elements




      public CutByT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
