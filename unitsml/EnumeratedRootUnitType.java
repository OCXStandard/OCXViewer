
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;

/**
*  The <code>EnumeratedRootUnitType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for the element for a root unit (from an extensive enumerated list) allowing an optional prefix and power. E.g., mm^2
 *  

*/
// EnumeratedRootUnitType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "EnumeratedRootUnitType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class EnumeratedRootUnitType extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='sourceURL', typeName='xsd:anyURI', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xsd:anyURI => TypeWrapper{name='anyURI', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xsd:anyURI!!!
    /* The 'sourceURL' value serialised as  XML attribute.
    * <summary>
    * Relevant URL for available information.</summary>
    */
    // contains the String serialised form of xsd:anyURI as String ( default namespace)
        // ?? xsd:anyURI
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> SourceURL = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "sourceURL", required = false)
    @XmlSchemaType(name = "xsd:anyURI")
    public String getSourceURL() {
        return this.SourceURL.get();
    };

    public void setSourceURL( String value) {
        this.SourceURL.set( value);

    }
    // end sourceURL

    // AttributeWrapper{name='prefix', typeName='prefix', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // prefix => TypeWrapper{name='prefix', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    //     use PrefixEnum
    // Java Type , PrefixEnum Type Adapter !!!typeAdapter unmapped type prefix!!!
    /* The 'prefix' value serialised as  XML attribute.
    * <summary>
    * Prefix identifier; e.g., m, k, M, G.  [Enumeration order is by prefix magnitude (Y to y) followed by binary prefixes.]</summary>
    */
    // contains the String serialised form of prefix as PrefixEnum ( default namespace)
        // ?? prefix
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<PrefixEnum> Prefix = new  javafx.beans.property.SimpleObjectProperty<PrefixEnum>();

    @XmlAttribute(name = "prefix", required = false)
    @XmlSchemaType(name = "prefix")
    public PrefixEnum getPrefix() {
        return this.Prefix.get();
    };

    public void setPrefix( PrefixEnum value) {
        this.Prefix.set( value);

    }
    // end prefix

    // AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}
    // 
    // xsd:byte => TypeWrapper{name='byte', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use int
    // Java Type , int Type Adapter !!!typeAdapter unmapped type xsd:byte!!!
    /* The 'powerNumerator' value serialised as  XML attribute.
    * <summary>
    * An integer exponent of the unit.</summary>
    */
    // contains the String serialised form of xsd:byte as int ( default namespace)
    @XmlTransient
    public IntegerProperty PowerNumerator = new SimpleIntegerProperty();

    @XmlAttribute(name = "powerNumerator", required = false)
    @XmlSchemaType(name = "xsd:byte")
    public int getPowerNumerator() {
        return this.PowerNumerator.get();
    };

    public void setPowerNumerator( int value) {
        this.PowerNumerator.set( value);

    }
    // end powerNumerator

    // AttributeWrapper{name='unit', typeName='unit', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // unit => TypeWrapper{name='unit', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    //     use UnitEnum
    // Java Type , UnitEnum Type Adapter !!!typeAdapter unmapped type unit!!!
    /* The 'unit' value serialised as  XML attribute.
    * <summary>
    * Unit identifier; the enumerated list is basically English unit names in lowercase, with a few upper case exceptions, e.g., 32F, mmHg, pH.</summary>
    */
    // contains the String serialised form of unit as UnitEnum ( default namespace)
        // ?? unit
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<UnitEnum> UnitId = new  javafx.beans.property.SimpleObjectProperty<UnitEnum>();

    @XmlAttribute(name = "unit", required = true)
    @XmlSchemaType(name = "unit")
    public UnitEnum getUnitId() {
        return this.UnitId.get();
    };

    public void setUnitId( UnitEnum value) {
        this.UnitId.set( value);

    }
    // end unit
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public EnumeratedRootUnitType() {
          try {


          // attr powerNumerator with default value '1', type int
           PowerNumerator.set( Integer.parseInt("1"));
 

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
