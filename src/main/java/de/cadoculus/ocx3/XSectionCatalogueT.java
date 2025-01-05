
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>XSectionCatalogue_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the cross-section types for stiffeners and their properties recognised
 * 				by the Society.
 *  

*/
// XSectionCatalogue_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// NamedEntity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "XSectionCatalogue_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class XSectionCatalogueT extends NamedEntityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property BarSection
    // PropertyWrapper{name='BarSection', typeName='BarSection', docu='null', type=BarSection, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='BarSection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BarSection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BarSection' property serialised as  XML elemenmt.
    * 
    */

    private List<BarSection> barSections = new ArrayList<>();

    public List<BarSection> getBarSection() {
        return barSections;
    }




    // end the properties serialised to elements




      public XSectionCatalogueT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
