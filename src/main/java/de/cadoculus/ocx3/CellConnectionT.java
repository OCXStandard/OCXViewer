
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CellConnection_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition for connecting cells to a compartment.
 *  

*/
// CellConnection_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CellConnection_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CellConnectionT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CellRef
    // PropertyWrapper{name='CellRef', typeName='CellRef', docu='null', type=CellRef, minOccurs=2, maxOccurs=2}
    // TypeWrapper{name='CellRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CellRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CellRef' property serialised as  XML elemenmt.
    * 
    */

    private List<CellRef> cellRefs = new ArrayList<>();

    public List<CellRef> getCellRef() {
        return cellRefs;
    }




    // end the properties serialised to elements




      public CellConnectionT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
