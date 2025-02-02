
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

/**
*  The <code>DimensionSetType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for the dimension container.
 *  

*/
// DimensionSetType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DimensionSetType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class DimensionSetType extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Dimension
    // PropertyWrapper{name='Dimension', typeName='Dimension', docu='null', type=Dimension, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Dimension', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DimensionType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'Dimension' property serialised as  XML elemenmt.
    * 
    */

    private List<Dimension> dimensions = new ArrayList<>();

    public List<Dimension> getDimension() {
        return dimensions;
    }




    // end the properties serialised to elements




      public DimensionSetType() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
