
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>UnitsMLType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * ComplexType for the root element of an UnitsML document.
 *  

*/
// UnitsMLType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitsMLType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class UnitsMLType extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property UnitSet
    // PropertyWrapper{name='UnitSet', typeName='UnitSet', docu='null', type=UnitSet, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='UnitSet', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitSetType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'UnitSet' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UnitSet> UnitSet = new javafx.beans.property.SimpleObjectProperty<UnitSet>();

    @XmlElement(name = "UnitSet", required = false)
    public UnitSet getUnitSet() {
        return this.UnitSet.get();
    }
    public void setUnitSet( UnitSet value) {
        this.UnitSet.set( value);
    }




    // Property DimensionSet
    // PropertyWrapper{name='DimensionSet', typeName='DimensionSet', docu='null', type=DimensionSet, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='DimensionSet', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DimensionSetType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'DimensionSet' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DimensionSet> DimensionSet = new javafx.beans.property.SimpleObjectProperty<DimensionSet>();

    @XmlElement(name = "DimensionSet", required = false)
    public DimensionSet getDimensionSet() {
        return this.DimensionSet.get();
    }
    public void setDimensionSet( DimensionSet value) {
        this.DimensionSet.set( value);
    }




    // end the properties serialised to elements




      public UnitsMLType() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
