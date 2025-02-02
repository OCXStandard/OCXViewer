
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SplitBy_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Structural concepts defining the subdivision of a panel into plates
 * 				split by one or more seams.
 *  

*/
// SplitBy_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SplitBy_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SplitByT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Seam
    // PropertyWrapper{name='Seam', typeName='Seam', docu='null', type=Seam, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Seam', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Seam_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Seam' property serialised as  XML elemenmt.
    * 
    */

    private List<Seam> seams = new ArrayList<>();

    public List<Seam> getSeam() {
        return seams;
    }




    // end the properties serialised to elements




      public SplitByT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
