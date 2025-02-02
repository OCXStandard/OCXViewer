
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ComposedOf_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// ComposedOf_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ComposedOf_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ComposedOfT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Plate
    // PropertyWrapper{name='Plate', typeName='Plate', docu='null', type=Plate, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Plate', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Plate_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Plate' property serialised as  XML elemenmt.
    * 
    */

    private List<Plate> plates = new ArrayList<>();

    public List<Plate> getPlate() {
        return plates;
    }




    // Property Bracket
    // PropertyWrapper{name='Bracket', typeName='Bracket', docu='null', type=Bracket, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Bracket', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Bracket_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Bracket' property serialised as  XML elemenmt.
    * 
    */

    private List<Bracket> brackets = new ArrayList<>();

    public List<Bracket> getBracket() {
        return brackets;
    }




    // Property Pillar
    // PropertyWrapper{name='Pillar', typeName='Pillar', docu='null', type=Pillar, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Pillar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Pillar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Pillar' property serialised as  XML elemenmt.
    * 
    */

    private List<Pillar> pillars = new ArrayList<>();

    public List<Pillar> getPillar() {
        return pillars;
    }




    // end the properties serialised to elements




      public ComposedOfT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
