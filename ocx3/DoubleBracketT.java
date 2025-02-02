
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DoubleBracket_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of DoubleBracket connection.
 *  

*/
// DoubleBracket_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DoubleBracket_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class DoubleBracketT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ConnectedBracketRef
    // PropertyWrapper{name='ConnectedBracketRef', typeName='ConnectedBracketRef', docu='null', type=ConnectedBracketRef, minOccurs=2, maxOccurs=2}
    // TypeWrapper{name='ConnectedBracketRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ConnectedBracketRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ConnectedBracketRef' property serialised as  XML elemenmt.
    * 
    */

    private List<ConnectedBracketRef> connectedBracketRefs = new ArrayList<>();

    public List<ConnectedBracketRef> getConnectedBracketRef() {
        return connectedBracketRefs;
    }




    // end the properties serialised to elements




      public DoubleBracketT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
