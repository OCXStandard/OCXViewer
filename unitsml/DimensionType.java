
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;

/**
*  The <code>DimensionType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for dimension.
 *  

*/
// DimensionType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DimensionType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class DimensionType extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='dimensionless', typeName='xsd:boolean', targetNamespace='', required=false, defaultValue='0', fixedValue='null', referencedType='Object'}
    // 
    // xsd:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xsd:boolean!!!
    /* The 'dimensionless' value serialised as  XML attribute.
    * <summary>
    * Boolean to designate that a quantity or unit is dimensionless.</summary>
    */
    // contains the String serialised form of xsd:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty Dimensionless = new SimpleBooleanProperty();

    @XmlAttribute(name = "dimensionless", required = false)
    @XmlSchemaType(name = "xsd:boolean")
    public boolean getDimensionless() {
        return this.Dimensionless.get();
    };

    public void setDimensionless( boolean value) {
        this.Dimensionless.set( value);

    }
    // end dimensionless

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
    // Property Length
    // PropertyWrapper{name='Length', typeName='Length', docu='null', type=Length, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Length', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LengthType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'Length' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Length> Length = new javafx.beans.property.SimpleObjectProperty<Length>();

    @XmlElement(name = "Length", required = false)
    public Length getLength() {
        return this.Length.get();
    }
    public void setLength( Length value) {
        this.Length.set( value);
    }




    // Property Mass
    // PropertyWrapper{name='Mass', typeName='Mass', docu='null', type=Mass, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Mass', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='MassType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'Mass' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Mass> Mass = new javafx.beans.property.SimpleObjectProperty<Mass>();

    @XmlElement(name = "Mass", required = false)
    public Mass getMass() {
        return this.Mass.get();
    }
    public void setMass( Mass value) {
        this.Mass.set( value);
    }




    // Property Time
    // PropertyWrapper{name='Time', typeName='Time', docu='null', type=Time, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Time', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TimeType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'Time' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Time> Time = new javafx.beans.property.SimpleObjectProperty<Time>();

    @XmlElement(name = "Time", required = false)
    public Time getTime() {
        return this.Time.get();
    }
    public void setTime( Time value) {
        this.Time.set( value);
    }




    // Property ElectricCurrent
    // PropertyWrapper{name='ElectricCurrent', typeName='ElectricCurrent', docu='null', type=ElectricCurrent, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ElectricCurrent', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ElectricCurrentType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'ElectricCurrent' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ElectricCurrent> ElectricCurrent = new javafx.beans.property.SimpleObjectProperty<ElectricCurrent>();

    @XmlElement(name = "ElectricCurrent", required = false)
    public ElectricCurrent getElectricCurrent() {
        return this.ElectricCurrent.get();
    }
    public void setElectricCurrent( ElectricCurrent value) {
        this.ElectricCurrent.set( value);
    }




    // Property ThermodynamicTemperature
    // PropertyWrapper{name='ThermodynamicTemperature', typeName='ThermodynamicTemperature', docu='null', type=ThermodynamicTemperature, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ThermodynamicTemperature', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ThermodynamicTemperatureType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'ThermodynamicTemperature' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ThermodynamicTemperature> ThermodynamicTemperature = new javafx.beans.property.SimpleObjectProperty<ThermodynamicTemperature>();

    @XmlElement(name = "ThermodynamicTemperature", required = false)
    public ThermodynamicTemperature getThermodynamicTemperature() {
        return this.ThermodynamicTemperature.get();
    }
    public void setThermodynamicTemperature( ThermodynamicTemperature value) {
        this.ThermodynamicTemperature.set( value);
    }




    // Property AmountOfSubstance
    // PropertyWrapper{name='AmountOfSubstance', typeName='AmountOfSubstance', docu='null', type=AmountOfSubstance, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='AmountOfSubstance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='AmountOfSubstanceType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'AmountOfSubstance' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<AmountOfSubstance> AmountOfSubstance = new javafx.beans.property.SimpleObjectProperty<AmountOfSubstance>();

    @XmlElement(name = "AmountOfSubstance", required = false)
    public AmountOfSubstance getAmountOfSubstance() {
        return this.AmountOfSubstance.get();
    }
    public void setAmountOfSubstance( AmountOfSubstance value) {
        this.AmountOfSubstance.set( value);
    }




    // Property LuminousIntensity
    // PropertyWrapper{name='LuminousIntensity', typeName='LuminousIntensity', docu='null', type=LuminousIntensity, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='LuminousIntensity', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LuminousIntensityType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18 urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
    // is simple type false
    /* The 'LuminousIntensity' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LuminousIntensity> LuminousIntensity = new javafx.beans.property.SimpleObjectProperty<LuminousIntensity>();

    @XmlElement(name = "LuminousIntensity", required = false)
    public LuminousIntensity getLuminousIntensity() {
        return this.LuminousIntensity.get();
    }
    public void setLuminousIntensity( LuminousIntensity value) {
        this.LuminousIntensity.set( value);
    }




    // end the properties serialised to elements




      public DimensionType() {
          try {
          // attr dimensionless with default value '0', type boolean
           Dimensionless.set( Boolean.parseBoolean("0"));
 

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
