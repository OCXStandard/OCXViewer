
package de.cadoculus.unitsml;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


// objectFactoryJava.ftl
/**
* This object contains factory methods for each
* Java content interface and Java element interface
* generated in the com.prostep.opdm.ship.ocx  package.
* <p>An ObjectFactory allows you to programatically
* construct new instances of the Java representation
* for XML content. The Java representation of XML
* content can consist of schema derived interfaces
* and classes representing the binding of schema
* type definitions, element declarations and model
* groups.  Factory methods for each of these are
* provided in this class.
*/
@XmlRegistry
public class ObjectFactory {

    private final static QName _UnitsML_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "UnitsML");
    private final static QName _UnitSet_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "UnitSet");
    private final static QName _Unit_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "Unit");
    private final static QName _UnitName_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "UnitName");
    private final static QName _UnitSymbol_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "UnitSymbol");
    private final static QName _RootUnits_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "RootUnits");
    private final static QName _EnumeratedRootUnit_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "EnumeratedRootUnit");
    private final static QName _DimensionSet_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "DimensionSet");
    private final static QName _Dimension_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "Dimension");
    private final static QName _Length_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "Length");
    private final static QName _Mass_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "Mass");
    private final static QName _Time_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "Time");
    private final static QName _ElectricCurrent_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "ElectricCurrent");
    private final static QName _ThermodynamicTemperature_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "ThermodynamicTemperature");
    private final static QName _AmountOfSubstance_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "AmountOfSubstance");
    private final static QName _LuminousIntensity_QNAME = new QName( "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "LuminousIntensity");

    /**
    * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.dnv.data
    *
    */
    public ObjectFactory() {
    }

    // skip abstract type UnitsMLType
    // skip abstract type UnitSetType
    // skip abstract type UnitType
    // skip abstract type RootUnitsType
    // skip abstract type EnumeratedRootUnitType
    // skip abstract type DimensionSetType
    // skip abstract type DimensionType
    // skip abstract type LengthType
    // skip abstract type MassType
    // skip abstract type TimeType
    // skip abstract type ElectricCurrentType
    // skip abstract type ThermodynamicTemperatureType
    // skip abstract type AmountOfSubstanceType
    // skip abstract type LuminousIntensityType
    // skip abstract type NameType
    // skip abstract type SymbolType
        public UnitsML createUnitsML() { return new UnitsML(); }
        public UnitSet createUnitSet() { return new UnitSet(); }
        public Unit createUnit() { return new Unit(); }
        public UnitName createUnitName() { return new UnitName(); }
        public UnitSymbol createUnitSymbol() { return new UnitSymbol(); }
        public RootUnits createRootUnits() { return new RootUnits(); }
        public EnumeratedRootUnit createEnumeratedRootUnit() { return new EnumeratedRootUnit(); }
        public DimensionSet createDimensionSet() { return new DimensionSet(); }
        public Dimension createDimension() { return new Dimension(); }
        public Length createLength() { return new Length(); }
        public Mass createMass() { return new Mass(); }
        public Time createTime() { return new Time(); }
        public ElectricCurrent createElectricCurrent() { return new ElectricCurrent(); }
        public ThermodynamicTemperature createThermodynamicTemperature() { return new ThermodynamicTemperature(); }
        public AmountOfSubstance createAmountOfSubstance() { return new AmountOfSubstance(); }
        public LuminousIntensity createLuminousIntensity() { return new LuminousIntensity(); }

    // TypeWrapper{name='UnitsMLType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[PropertyWrapper{name='UnitSet', typeName='UnitSet', docu='null', type=UnitSet, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='DimensionSet', typeName='DimensionSet', docu='null', type=DimensionSet, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='UnitSetType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[PropertyWrapper{name='Unit', typeName='Unit', docu='null', type=Unit, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='UnitType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='dimensionURL', typeName='xsd:anyURI', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='UnitName', typeName='UnitName', docu='null', type=UnitName, minOccurs=1, maxOccurs=100}, PropertyWrapper{name='UnitSymbol', typeName='UnitSymbol', docu='null', type=UnitSymbol, minOccurs=0, maxOccurs=100}, PropertyWrapper{name='RootUnits', typeName='RootUnits', docu='null', type=RootUnits, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='RootUnitsType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[PropertyWrapper{name='EnumeratedRootUnit', typeName='EnumeratedRootUnit', docu='null', type=EnumeratedRootUnit, minOccurs=0, maxOccurs=100}]}
    // TypeWrapper{name='EnumeratedRootUnitType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='sourceURL', typeName='xsd:anyURI', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='prefix', typeName='prefix', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='unit', typeName='unit', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='DimensionSetType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[PropertyWrapper{name='Dimension', typeName='Dimension', docu='null', type=Dimension, minOccurs=1, maxOccurs=100}]}
    // TypeWrapper{name='DimensionType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='dimensionless', typeName='xsd:boolean', targetNamespace='', required=false, defaultValue='0', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[PropertyWrapper{name='Length', typeName='Length', docu='null', type=Length, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Mass', typeName='Mass', docu='null', type=Mass, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='Time', typeName='Time', docu='null', type=Time, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ElectricCurrent', typeName='ElectricCurrent', docu='null', type=ElectricCurrent, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='ThermodynamicTemperature', typeName='ThermodynamicTemperature', docu='null', type=ThermodynamicTemperature, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='AmountOfSubstance', typeName='AmountOfSubstance', docu='null', type=AmountOfSubstance, minOccurs=0, maxOccurs=1}, PropertyWrapper{name='LuminousIntensity', typeName='LuminousIntensity', docu='null', type=LuminousIntensity, minOccurs=0, maxOccurs=1}]}
    // TypeWrapper{name='LengthType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='L', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='MassType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='M', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='TimeType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='T', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ElectricCurrentType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='I', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='ThermodynamicTemperatureType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='Θ', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='AmountOfSubstanceType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='N', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='LuminousIntensityType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}, AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='J', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='NameType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    // TypeWrapper{name='SymbolType', isAbstract=false, isComplexType=true, isSimpleType=false, isEnumType=false, baseTypeName='null', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[AttributeWrapper{name='type', typeName='xsd:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}], properties=[]}
    // TypeWrapper{name='UnitsML', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitsMLType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UnitsML }{@code >}}
    */
    @XmlElementDecl( name = "UnitsML", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<UnitsML> createUnitsML( UnitsML value) {
        return new JAXBElement<UnitsML>( _UnitsML_QNAME, UnitsML.class, null, value);
    }
    // TypeWrapper{name='UnitSet', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitSetType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UnitSet }{@code >}}
    */
    @XmlElementDecl( name = "UnitSet", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<UnitSet> createUnitSet( UnitSet value) {
        return new JAXBElement<UnitSet>( _UnitSet_QNAME, UnitSet.class, null, value);
    }
    // TypeWrapper{name='Unit', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnitType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Unit }{@code >}}
    */
    @XmlElementDecl( name = "Unit", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<Unit> createUnit( Unit value) {
        return new JAXBElement<Unit>( _Unit_QNAME, Unit.class, null, value);
    }
    // TypeWrapper{name='UnitName', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='NameType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UnitName }{@code >}}
    */
    @XmlElementDecl( name = "UnitName", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<UnitName> createUnitName( UnitName value) {
        return new JAXBElement<UnitName>( _UnitName_QNAME, UnitName.class, null, value);
    }
    // TypeWrapper{name='UnitSymbol', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SymbolType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link UnitSymbol }{@code >}}
    */
    @XmlElementDecl( name = "UnitSymbol", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<UnitSymbol> createUnitSymbol( UnitSymbol value) {
        return new JAXBElement<UnitSymbol>( _UnitSymbol_QNAME, UnitSymbol.class, null, value);
    }
    // TypeWrapper{name='RootUnits', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RootUnitsType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link RootUnits }{@code >}}
    */
    @XmlElementDecl( name = "RootUnits", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<RootUnits> createRootUnits( RootUnits value) {
        return new JAXBElement<RootUnits>( _RootUnits_QNAME, RootUnits.class, null, value);
    }
    // TypeWrapper{name='EnumeratedRootUnit', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EnumeratedRootUnitType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link EnumeratedRootUnit }{@code >}}
    */
    @XmlElementDecl( name = "EnumeratedRootUnit", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<EnumeratedRootUnit> createEnumeratedRootUnit( EnumeratedRootUnit value) {
        return new JAXBElement<EnumeratedRootUnit>( _EnumeratedRootUnit_QNAME, EnumeratedRootUnit.class, null, value);
    }
    // TypeWrapper{name='DimensionSet', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DimensionSetType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link DimensionSet }{@code >}}
    */
    @XmlElementDecl( name = "DimensionSet", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<DimensionSet> createDimensionSet( DimensionSet value) {
        return new JAXBElement<DimensionSet>( _DimensionSet_QNAME, DimensionSet.class, null, value);
    }
    // TypeWrapper{name='Dimension', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='DimensionType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Dimension }{@code >}}
    */
    @XmlElementDecl( name = "Dimension", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<Dimension> createDimension( Dimension value) {
        return new JAXBElement<Dimension>( _Dimension_QNAME, Dimension.class, null, value);
    }
    // TypeWrapper{name='Length', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LengthType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Length }{@code >}}
    */
    @XmlElementDecl( name = "Length", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<Length> createLength( Length value) {
        return new JAXBElement<Length>( _Length_QNAME, Length.class, null, value);
    }
    // TypeWrapper{name='Mass', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='MassType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Mass }{@code >}}
    */
    @XmlElementDecl( name = "Mass", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<Mass> createMass( Mass value) {
        return new JAXBElement<Mass>( _Mass_QNAME, Mass.class, null, value);
    }
    // TypeWrapper{name='Time', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TimeType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link Time }{@code >}}
    */
    @XmlElementDecl( name = "Time", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<Time> createTime( Time value) {
        return new JAXBElement<Time>( _Time_QNAME, Time.class, null, value);
    }
    // TypeWrapper{name='ElectricCurrent', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ElectricCurrentType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ElectricCurrent }{@code >}}
    */
    @XmlElementDecl( name = "ElectricCurrent", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<ElectricCurrent> createElectricCurrent( ElectricCurrent value) {
        return new JAXBElement<ElectricCurrent>( _ElectricCurrent_QNAME, ElectricCurrent.class, null, value);
    }
    // TypeWrapper{name='ThermodynamicTemperature', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ThermodynamicTemperatureType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link ThermodynamicTemperature }{@code >}}
    */
    @XmlElementDecl( name = "ThermodynamicTemperature", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<ThermodynamicTemperature> createThermodynamicTemperature( ThermodynamicTemperature value) {
        return new JAXBElement<ThermodynamicTemperature>( _ThermodynamicTemperature_QNAME, ThermodynamicTemperature.class, null, value);
    }
    // TypeWrapper{name='AmountOfSubstance', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='AmountOfSubstanceType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link AmountOfSubstance }{@code >}}
    */
    @XmlElementDecl( name = "AmountOfSubstance", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<AmountOfSubstance> createAmountOfSubstance( AmountOfSubstance value) {
        return new JAXBElement<AmountOfSubstance>( _AmountOfSubstance_QNAME, AmountOfSubstance.class, null, value);
    }
    // TypeWrapper{name='LuminousIntensity', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LuminousIntensityType', targetNamespace='urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18', attributes=[], properties=[]}
    /**
     * Create an instance of {@link JAXBElement}{@code <}{@link LuminousIntensity }{@code >}}
    */
    @XmlElementDecl( name = "LuminousIntensity", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
    public JAXBElement<LuminousIntensity> createLuminousIntensity( LuminousIntensity value) {
        return new JAXBElement<LuminousIntensity>( _LuminousIntensity_QNAME, LuminousIntensity.class, null, value);
    }
}
