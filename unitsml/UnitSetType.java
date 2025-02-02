
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

import java.util.*;

/**
*  The <code>UnitSetType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for the unit container.
 *  

*/
// UnitSetType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitSetType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class UnitSetType extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Unit
    // PropertyWrapper{name='Unit', typeName='Unit', docu='null', type=Unit, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Unit', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'Unit' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public ObservableList<Unit> Units = new SimpleListProperty<>();

    @XmlElement(name = "Unit", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public List<Unit> getUnits() {
        return Units;
    }

    public void setUnits(List<Unit> value) {
        Units.clear();
        value.forEach(Units::add);

    }

    // end the properties serialised to elements




      public UnitSetType() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
