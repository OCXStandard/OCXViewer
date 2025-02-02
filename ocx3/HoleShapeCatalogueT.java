
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>HoleShapeCatalogue_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the geometry used to describe the shape of a hole.
 *  

*/
// HoleShapeCatalogue_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "HoleShapeCatalogue_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class HoleShapeCatalogueT extends DescriptionBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Hole2D
    // PropertyWrapper{name='Hole2D', typeName='Hole2D', docu='null', type=Hole2D, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Hole2D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Hole2D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Hole2D' property serialised as  XML elemenmt.
    * 
    */

    private List<Hole2D> hole2Ds = new ArrayList<>();

    public List<Hole2D> getHole2D() {
        return hole2Ds;
    }




    // end the properties serialised to elements




      public HoleShapeCatalogueT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
