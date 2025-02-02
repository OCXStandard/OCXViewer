
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Cell_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the structural concept of a cell defining a part of a compartment
 * 				(physical space).
 *  

*/
// Cell_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// GeometryRepresentation_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Cell_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CellT extends GeometryRepresentationT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CellBoundary
    // PropertyWrapper{name='CellBoundary', typeName='CellBoundary', docu='null', type=CellBoundary, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='CellBoundary', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CellBoundary_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CellBoundary' property serialised as  XML elemenmt.
    * 
    */

    private List<CellBoundary> cellBoundarys = new ArrayList<>();

    public List<CellBoundary> getCellBoundary() {
        return cellBoundarys;
    }




    // end the properties serialised to elements




      public CellT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
