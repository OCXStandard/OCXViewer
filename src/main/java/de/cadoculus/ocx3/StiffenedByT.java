
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>StiffenedBy_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the structural concept defining the stiffeners which belongs to a panel as a choice of a Stiffener or EdgeReinforcement.
 *  

*/
// StiffenedBy_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "StiffenedBy_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class StiffenedByT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Stiffener
    // PropertyWrapper{name='Stiffener', typeName='Stiffener', docu='null', type=Stiffener, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Stiffener', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Stiffener_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Stiffener' property serialised as  XML elemenmt.
    * 
    */

    private List<Stiffener> stiffeners = new ArrayList<>();

    public List<Stiffener> getStiffener() {
        return stiffeners;
    }




    // Property EdgeReinforcement
    // PropertyWrapper{name='EdgeReinforcement', typeName='EdgeReinforcement', docu='null', type=EdgeReinforcement, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='EdgeReinforcement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EdgeReinforcement_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'EdgeReinforcement' property serialised as  XML elemenmt.
    * 
    */

    private List<EdgeReinforcement> edgeReinforcements = new ArrayList<>();

    public List<EdgeReinforcement> getEdgeReinforcement() {
        return edgeReinforcements;
    }




    // end the properties serialised to elements




      public StiffenedByT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
