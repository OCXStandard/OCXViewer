
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>MaterialCatalogue_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the material types used and their properties recognised by the
 * 				Society.
 *  

*/
// MaterialCatalogue_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "MaterialCatalogue_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class MaterialCatalogueT extends DescriptionBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Material
    // PropertyWrapper{name='Material', typeName='Material', docu='null', type=Material, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Material', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Material_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Material' property serialised as  XML elemenmt.
    * 
    */

    private List<Material> materials = new ArrayList<>();

    public List<Material> getMaterial() {
        return materials;
    }




    // end the properties serialised to elements




      public MaterialCatalogueT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
