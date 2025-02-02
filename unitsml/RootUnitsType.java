
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

/**
*  The <code>RootUnitsType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for the container for defining derived units in terms of their root units. This allows a precise definition of a wide range of units. The goal is to improve interoperability among applications and databases which use derived units based on commonly encountered base units.
 *  

*/
// RootUnitsType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RootUnitsType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class RootUnitsType extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property EnumeratedRootUnit
    // PropertyWrapper{name='EnumeratedRootUnit', typeName='EnumeratedRootUnit', docu='null', type=EnumeratedRootUnit, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='EnumeratedRootUnit', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EnumeratedRootUnitType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'EnumeratedRootUnit' property serialised as  XML elemenmt.
    * 
    */

    private List<EnumeratedRootUnit> enumeratedRootUnits = new ArrayList<>();

    public List<EnumeratedRootUnit> getEnumeratedRootUnit() {
        return enumeratedRootUnits;
    }




    // end the properties serialised to elements




      public RootUnitsType() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
