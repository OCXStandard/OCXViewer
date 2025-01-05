
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PrincipalParticulars_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the main vessel particulars required by the Society.
 *  

*/
// PrincipalParticulars_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PrincipalParticulars_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PrincipalParticularsT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='hasDeadweightLessThan', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'hasDeadweightLessThan' value serialised as  XML attribute.
    * <summary>
    * The ship has dead-weight less than 50000 tonnes (boolean).</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty HasDeadweightLessThan = new SimpleBooleanProperty();

    @XmlAttribute(name = "hasDeadweightLessThan", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getHasDeadweightLessThan() {
        return this.HasDeadweightLessThan.get();
    };

    public void setHasDeadweightLessThan( boolean value) {
        this.HasDeadweightLessThan.set( value);

    }
    // end hasDeadweightLessThan

    // AttributeWrapper{name='hasBilgeKeel', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'hasBilgeKeel' value serialised as  XML attribute.
    * <summary>
    * Whether the vessel has a bilge keel or not.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty HasBilgeKeel = new SimpleBooleanProperty();

    @XmlAttribute(name = "hasBilgeKeel", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getHasBilgeKeel() {
        return this.HasBilgeKeel.get();
    };

    public void setHasBilgeKeel( boolean value) {
        this.HasBilgeKeel.set( value);

    }
    // end hasBilgeKeel

    // AttributeWrapper{name='numberOfDecksAbove', typeName='xs:int', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:int => TypeWrapper{name='int', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use int
    // Java Type , int Type Adapter !!!typeAdapter unmapped type xs:int!!!
    /* The 'numberOfDecksAbove' value serialised as  XML attribute.
    * <summary>
    * Number of decks above 0.7 D from baseline.</summary>
    */
    // contains the String serialised form of xs:int as int ( default namespace)
    @XmlTransient
    public IntegerProperty NumberOfDecksAbove = new SimpleIntegerProperty();

    @XmlAttribute(name = "numberOfDecksAbove", required = false)
    @XmlSchemaType(name = "xs:int")
    public int getNumberOfDecksAbove() {
        return this.NumberOfDecksAbove.get();
    };

    public void setNumberOfDecksAbove( int value) {
        this.NumberOfDecksAbove.set( value);

    }
    // end numberOfDecksAbove

    // AttributeWrapper{name='freeboardType', typeName='freeboardType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='A', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // freeboardType => TypeWrapper{name='freeboardType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use FreeboardTypeEnum
    // Java Type , FreeboardTypeEnum Type Adapter !!!typeAdapter unmapped type freeboardType!!!
    /* The 'freeboardType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of freeboardType as FreeboardTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? freeboardType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<FreeboardTypeEnum> FreeboardType = new  javafx.beans.property.SimpleObjectProperty<FreeboardTypeEnum>();

    @XmlAttribute(name = "freeboardType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "freeboardType")
    public FreeboardTypeEnum getFreeboardType() {
        return this.FreeboardType.get();
    };

    public void setFreeboardType( FreeboardTypeEnum value) {
        this.FreeboardType.set( value);

    }
    // end freeboardType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Lpp
    // PropertyWrapper{name='Lpp', typeName='Lpp', docu='null', type=Lpp, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Lpp', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Lpp' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Lpp> Lpp = new javafx.beans.property.SimpleObjectProperty<Lpp>();

    @XmlElement(name = "Lpp", required = true)
    public Lpp getLpp() {
        return this.Lpp.get();
    }
    public void setLpp( Lpp value) {
        this.Lpp.set( value);
    }




    // Property RuleLength
    // PropertyWrapper{name='RuleLength', typeName='RuleLength', docu='null', type=RuleLength, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='RuleLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'RuleLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<RuleLength> RuleLength = new javafx.beans.property.SimpleObjectProperty<RuleLength>();

    @XmlElement(name = "RuleLength", required = true)
    public RuleLength getRuleLength() {
        return this.RuleLength.get();
    }
    public void setRuleLength( RuleLength value) {
        this.RuleLength.set( value);
    }




    // Property BlockCoefficient
    // PropertyWrapper{name='BlockCoefficient', typeName='BlockCoefficient', docu='null', type=BlockCoefficient, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='BlockCoefficient', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BlockCoefficient' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BlockCoefficient> BlockCoefficient = new javafx.beans.property.SimpleObjectProperty<BlockCoefficient>();

    @XmlElement(name = "BlockCoefficient", required = true)
    public BlockCoefficient getBlockCoefficient() {
        return this.BlockCoefficient.get();
    }
    public void setBlockCoefficient( BlockCoefficient value) {
        this.BlockCoefficient.set( value);
    }




    // Property FP_Pos
    // PropertyWrapper{name='FP_Pos', typeName='FP_Pos', docu='null', type=FP_Pos, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='FP_Pos', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FP_Pos' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FPPos> FPPos = new javafx.beans.property.SimpleObjectProperty<FPPos>();

    @XmlElement(name = "FP_Pos", required = true)
    public FPPos getFPPos() {
        return this.FPPos.get();
    }
    public void setFPPos( FPPos value) {
        this.FPPos.set( value);
    }




    // Property MouldedBreadth
    // PropertyWrapper{name='MouldedBreadth', typeName='MouldedBreadth', docu='null', type=MouldedBreadth, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MouldedBreadth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MouldedBreadth' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MouldedBreadth> MouldedBreadth = new javafx.beans.property.SimpleObjectProperty<MouldedBreadth>();

    @XmlElement(name = "MouldedBreadth", required = true)
    public MouldedBreadth getMouldedBreadth() {
        return this.MouldedBreadth.get();
    }
    public void setMouldedBreadth( MouldedBreadth value) {
        this.MouldedBreadth.set( value);
    }




    // Property MouldedDepth
    // PropertyWrapper{name='MouldedDepth', typeName='MouldedDepth', docu='null', type=MouldedDepth, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MouldedDepth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MouldedDepth' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MouldedDepth> MouldedDepth = new javafx.beans.property.SimpleObjectProperty<MouldedDepth>();

    @XmlElement(name = "MouldedDepth", required = true)
    public MouldedDepth getMouldedDepth() {
        return this.MouldedDepth.get();
    }
    public void setMouldedDepth( MouldedDepth value) {
        this.MouldedDepth.set( value);
    }




    // Property ScantlingDraught
    // PropertyWrapper{name='ScantlingDraught', typeName='ScantlingDraught', docu='null', type=ScantlingDraught, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ScantlingDraught', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ScantlingDraught' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ScantlingDraught> ScantlingDraught = new javafx.beans.property.SimpleObjectProperty<ScantlingDraught>();

    @XmlElement(name = "ScantlingDraught", required = true)
    public ScantlingDraught getScantlingDraught() {
        return this.ScantlingDraught.get();
    }
    public void setScantlingDraught( ScantlingDraught value) {
        this.ScantlingDraught.set( value);
    }




    // Property DesignSpeed
    // PropertyWrapper{name='DesignSpeed', typeName='DesignSpeed', docu='null', type=DesignSpeed, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='DesignSpeed', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DesignSpeed' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DesignSpeed> DesignSpeed = new javafx.beans.property.SimpleObjectProperty<DesignSpeed>();

    @XmlElement(name = "DesignSpeed", required = true)
    public DesignSpeed getDesignSpeed() {
        return this.DesignSpeed.get();
    }
    public void setDesignSpeed( DesignSpeed value) {
        this.DesignSpeed.set( value);
    }




    // Property FreeboardLength
    // PropertyWrapper{name='FreeboardLength', typeName='FreeboardLength', docu='null', type=FreeboardLength, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='FreeboardLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FreeboardLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FreeboardLength> FreeboardLength = new javafx.beans.property.SimpleObjectProperty<FreeboardLength>();

    @XmlElement(name = "FreeboardLength", required = true)
    public FreeboardLength getFreeboardLength() {
        return this.FreeboardLength.get();
    }
    public void setFreeboardLength( FreeboardLength value) {
        this.FreeboardLength.set( value);
    }




    // Property NormalBallastDraught
    // PropertyWrapper{name='NormalBallastDraught', typeName='NormalBallastDraught', docu='null', type=NormalBallastDraught, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='NormalBallastDraught', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'NormalBallastDraught' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<NormalBallastDraught> NormalBallastDraught = new javafx.beans.property.SimpleObjectProperty<NormalBallastDraught>();

    @XmlElement(name = "NormalBallastDraught", required = false)
    public NormalBallastDraught getNormalBallastDraught() {
        return this.NormalBallastDraught.get();
    }
    public void setNormalBallastDraught( NormalBallastDraught value) {
        this.NormalBallastDraught.set( value);
    }




    // Property HeavyBallastDraught
    // PropertyWrapper{name='HeavyBallastDraught', typeName='HeavyBallastDraught', docu='null', type=HeavyBallastDraught, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='HeavyBallastDraught', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'HeavyBallastDraught' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<HeavyBallastDraught> HeavyBallastDraught = new javafx.beans.property.SimpleObjectProperty<HeavyBallastDraught>();

    @XmlElement(name = "HeavyBallastDraught", required = false)
    public HeavyBallastDraught getHeavyBallastDraught() {
        return this.HeavyBallastDraught.get();
    }
    public void setHeavyBallastDraught( HeavyBallastDraught value) {
        this.HeavyBallastDraught.set( value);
    }




    // Property SlammingDraughtEmptyFP
    // PropertyWrapper{name='SlammingDraughtEmptyFP', typeName='SlammingDraughtEmptyFP', docu='null', type=SlammingDraughtEmptyFP, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='SlammingDraughtEmptyFP', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SlammingDraughtEmptyFP' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SlammingDraughtEmptyFP> SlammingDraughtEmptyFP = new javafx.beans.property.SimpleObjectProperty<SlammingDraughtEmptyFP>();

    @XmlElement(name = "SlammingDraughtEmptyFP", required = false)
    public SlammingDraughtEmptyFP getSlammingDraughtEmptyFP() {
        return this.SlammingDraughtEmptyFP.get();
    }
    public void setSlammingDraughtEmptyFP( SlammingDraughtEmptyFP value) {
        this.SlammingDraughtEmptyFP.set( value);
    }




    // Property SlammingDraughtFullFP
    // PropertyWrapper{name='SlammingDraughtFullFP', typeName='SlammingDraughtFullFP', docu='null', type=SlammingDraughtFullFP, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='SlammingDraughtFullFP', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SlammingDraughtFullFP' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SlammingDraughtFullFP> SlammingDraughtFullFP = new javafx.beans.property.SimpleObjectProperty<SlammingDraughtFullFP>();

    @XmlElement(name = "SlammingDraughtFullFP", required = false)
    public SlammingDraughtFullFP getSlammingDraughtFullFP() {
        return this.SlammingDraughtFullFP.get();
    }
    public void setSlammingDraughtFullFP( SlammingDraughtFullFP value) {
        this.SlammingDraughtFullFP.set( value);
    }




    // Property LengthOfWaterline
    // PropertyWrapper{name='LengthOfWaterline', typeName='LengthOfWaterline', docu='null', type=LengthOfWaterline, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='LengthOfWaterline', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LengthOfWaterline' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LengthOfWaterline> LengthOfWaterline = new javafx.beans.property.SimpleObjectProperty<LengthOfWaterline>();

    @XmlElement(name = "LengthOfWaterline", required = false)
    public LengthOfWaterline getLengthOfWaterline() {
        return this.LengthOfWaterline.get();
    }
    public void setLengthOfWaterline( LengthOfWaterline value) {
        this.LengthOfWaterline.set( value);
    }




    // Property FreeboardDeckHeight
    // PropertyWrapper{name='FreeboardDeckHeight', typeName='FreeboardDeckHeight', docu='null', type=FreeboardDeckHeight, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FreeboardDeckHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FreeboardDeckHeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FreeboardDeckHeight> FreeboardDeckHeight = new javafx.beans.property.SimpleObjectProperty<FreeboardDeckHeight>();

    @XmlElement(name = "FreeboardDeckHeight", required = false)
    public FreeboardDeckHeight getFreeboardDeckHeight() {
        return this.FreeboardDeckHeight.get();
    }
    public void setFreeboardDeckHeight( FreeboardDeckHeight value) {
        this.FreeboardDeckHeight.set( value);
    }




    // Property AP_Pos
    // PropertyWrapper{name='AP_Pos', typeName='AP_Pos', docu='null', type=AP_Pos, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='AP_Pos', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'AP_Pos' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<APPos> APPos = new javafx.beans.property.SimpleObjectProperty<APPos>();

    @XmlElement(name = "AP_Pos", required = false)
    public APPos getAPPos() {
        return this.APPos.get();
    }
    public void setAPPos( APPos value) {
        this.APPos.set( value);
    }




    // Property ZPosOfDeck
    // PropertyWrapper{name='ZPosOfDeck', typeName='ZPosOfDeck', docu='null', type=ZPosOfDeck, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ZPosOfDeck', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ZPosOfDeck' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ZPosOfDeck> ZPosOfDeck = new javafx.beans.property.SimpleObjectProperty<ZPosOfDeck>();

    @XmlElement(name = "ZPosOfDeck", required = false)
    public ZPosOfDeck getZPosOfDeck() {
        return this.ZPosOfDeck.get();
    }
    public void setZPosOfDeck( ZPosOfDeck value) {
        this.ZPosOfDeck.set( value);
    }




    // Property DeepestEquilibriumWL
    // PropertyWrapper{name='DeepestEquilibriumWL', typeName='DeepestEquilibriumWL', docu='null', type=DeepestEquilibriumWL, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='DeepestEquilibriumWL', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'DeepestEquilibriumWL' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<DeepestEquilibriumWL> DeepestEquilibriumWL = new javafx.beans.property.SimpleObjectProperty<DeepestEquilibriumWL>();

    @XmlElement(name = "DeepestEquilibriumWL", required = false)
    public DeepestEquilibriumWL getDeepestEquilibriumWL() {
        return this.DeepestEquilibriumWL.get();
    }
    public void setDeepestEquilibriumWL( DeepestEquilibriumWL value) {
        this.DeepestEquilibriumWL.set( value);
    }




    // Property UpperDeckArea
    // PropertyWrapper{name='UpperDeckArea', typeName='UpperDeckArea', docu='null', type=UpperDeckArea, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='UpperDeckArea', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UpperDeckArea' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UpperDeckArea> UpperDeckArea = new javafx.beans.property.SimpleObjectProperty<UpperDeckArea>();

    @XmlElement(name = "UpperDeckArea", required = false)
    public UpperDeckArea getUpperDeckArea() {
        return this.UpperDeckArea.get();
    }
    public void setUpperDeckArea( UpperDeckArea value) {
        this.UpperDeckArea.set( value);
    }




    // Property WaterPlaneArea
    // PropertyWrapper{name='WaterPlaneArea', typeName='WaterPlaneArea', docu='null', type=WaterPlaneArea, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='WaterPlaneArea', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'WaterPlaneArea' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<WaterPlaneArea> WaterPlaneArea = new javafx.beans.property.SimpleObjectProperty<WaterPlaneArea>();

    @XmlElement(name = "WaterPlaneArea", required = false)
    public WaterPlaneArea getWaterPlaneArea() {
        return this.WaterPlaneArea.get();
    }
    public void setWaterPlaneArea( WaterPlaneArea value) {
        this.WaterPlaneArea.set( value);
    }




    // Property ZPosDeckline
    // PropertyWrapper{name='ZPosDeckline', typeName='ZPosDeckline', docu='null', type=ZPosDeckline, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ZPosDeckline', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ZPosDeckline' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ZPosDeckline> ZPosDeckline = new javafx.beans.property.SimpleObjectProperty<ZPosDeckline>();

    @XmlElement(name = "ZPosDeckline", required = false)
    public ZPosDeckline getZPosDeckline() {
        return this.ZPosDeckline.get();
    }
    public void setZPosDeckline( ZPosDeckline value) {
        this.ZPosDeckline.set( value);
    }




    // Property SpeedFactor
    // PropertyWrapper{name='SpeedFactor', typeName='SpeedFactor', docu='null', type=SpeedFactor, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='SpeedFactor', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SpeedFactor' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SpeedFactor> SpeedFactor = new javafx.beans.property.SimpleObjectProperty<SpeedFactor>();

    @XmlElement(name = "SpeedFactor", required = false)
    public SpeedFactor getSpeedFactor() {
        return this.SpeedFactor.get();
    }
    public void setSpeedFactor( SpeedFactor value) {
        this.SpeedFactor.set( value);
    }




    // end the properties serialised to elements




      public PrincipalParticularsT() {
          try {



          // attr freeboardType with default value 'A', type FreeboardTypeEnum
           FreeboardType.set(FreeboardTypeEnum.parse("A"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
