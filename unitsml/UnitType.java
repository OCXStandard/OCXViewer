
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

/**
*  The <code>UnitType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for the unit.
 *  

*/
// UnitType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class UnitType extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='dimensionURL', typeName='xsd:anyURI', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xsd:anyURI => TypeWrapper{name='anyURI', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xsd:anyURI!!!
    /* The 'dimensionURL' value serialised as  XML attribute.
    * <summary>
    * URL to a representation of the unit or quantity in terms of the 7 SI base dimensions.</summary>
    */
    // contains the String serialised form of xsd:anyURI as String ( default namespace)
        // ?? xsd:anyURI
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> DimensionURL = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "dimensionURL", required = false)
    @XmlSchemaType(name = "xsd:anyURI")
    public String getDimensionURL() {
        return this.DimensionURL.get();
    };

    public void setDimensionURL( String value) {
        this.DimensionURL.set( value);

    }
    // end dimensionURL

    // AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:ID => TypeWrapper{name='ID', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:ID!!!
    /* The 'id' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:ID as String (, namespace = "http://www.w3.org/XML/1998/namespace")
        // ?? xs:ID
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Id = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "id", required = true, namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlSchemaType(name = "xs:ID")
    public String getId() {
        return this.Id.get();
    };

    public void setId( String value) {
        this.Id.set( value);

    }
    // end id
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property UnitName
    // PropertyWrapper{name='UnitName', typeName='UnitName', docu='null', type=UnitName, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='UnitName', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NameType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'UnitName' property serialised as  XML elemenmt.
    * 
    */

    private List<UnitName> unitNames = new ArrayList<>();

    public List<UnitName> getUnitName() {
        return unitNames;
    }




    // Property UnitSymbol
    // PropertyWrapper{name='UnitSymbol', typeName='UnitSymbol', docu='null', type=UnitSymbol, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='UnitSymbol', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SymbolType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'UnitSymbol' property serialised as  XML elemenmt.
    * 
    */

    private List<UnitSymbol> unitSymbols = new ArrayList<>();

    public List<UnitSymbol> getUnitSymbol() {
        return unitSymbols;
    }




    // Property RootUnits
    // PropertyWrapper{name='RootUnits', typeName='RootUnits', docu='null', type=RootUnits, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='RootUnits', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RootUnitsType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'RootUnits' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<RootUnits> RootUnits = new javafx.beans.property.SimpleObjectProperty<RootUnits>();

    @XmlElement(name = "RootUnits", required = false)
    public RootUnits getRootUnits() {
        return this.RootUnits.get();
    }
    public void setRootUnits( RootUnits value) {
        this.RootUnits.set( value);
    }




    // end the properties serialised to elements




      public UnitType() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
