
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>StructureRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// StructureRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ReferenceBase_T  
// reference type BaseClass

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "StructureRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class StructureRefT extends ReferenceBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property StiffenerRef
    // PropertyWrapper{name='StiffenerRef', typeName='StiffenerRef', docu='null', type=StiffenerRef, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='StiffenerRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StiffenerRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'StiffenerRef' property serialised as  XML elemenmt.
    * 
    */

    private List<StiffenerRef> stiffenerRefs = new ArrayList<>();

    public List<StiffenerRef> getStiffenerRef() {
        return stiffenerRefs;
    }




    // end the properties serialised to elements




      public StructureRefT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
