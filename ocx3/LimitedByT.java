
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>LimitedBy_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the LimitedBy (reference to limiting objects forming a closed contour
 * 				of the parent element).
 *  

*/
// LimitedBy_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LimitedBy_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class LimitedByT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property FreeEdgeCurve3D
    // PropertyWrapper{name='FreeEdgeCurve3D', typeName='FreeEdgeCurve3D', docu='null', type=FreeEdgeCurve3D, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='FreeEdgeCurve3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FreeEdgeCurve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FreeEdgeCurve3D' property serialised as  XML elemenmt.
    * 
    */

    private List<FreeEdgeCurve3D> freeEdgeCurve3Ds = new ArrayList<>();

    public List<FreeEdgeCurve3D> getFreeEdgeCurve3D() {
        return freeEdgeCurve3Ds;
    }




    // Property BoundedRef
    // PropertyWrapper{name='BoundedRef', typeName='BoundedRef', docu='null', type=BoundedRef, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='BoundedRef', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BoundedRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BoundedRef' property serialised as  XML elemenmt.
    * 
    */

    private List<BoundedRef> boundedRefs = new ArrayList<>();

    public List<BoundedRef> getBoundedRef() {
        return boundedRefs;
    }




    // end the properties serialised to elements




      public LimitedByT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
