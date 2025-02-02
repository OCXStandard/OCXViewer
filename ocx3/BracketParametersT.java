
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BracketParameters_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Common parameters defining bracket configurations used in
 * 				shipbuilding.
 *  

*/
// BracketParameters_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BracketParameters_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BracketParametersT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='numberOfSupports', typeName='xs:int', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:int => TypeWrapper{name='int', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use int
    // Java Type , int Type Adapter !!!typeAdapter unmapped type xs:int!!!
    /* The 'numberOfSupports' value serialised as  XML attribute.
    * <summary>
    * Number of supported (welded) bracket edges.</summary>
    */
    // contains the String serialised form of xs:int as int ( default namespace)
    @XmlTransient
    public IntegerProperty NumberOfSupports = new SimpleIntegerProperty();

    @XmlAttribute(name = "numberOfSupports", required = false)
    @XmlSchemaType(name = "xs:int")
    public int getNumberOfSupports() {
        return this.NumberOfSupports.get();
    };

    public void setNumberOfSupports( int value) {
        this.NumberOfSupports.set( value);

    }
    // end numberOfSupports

    // AttributeWrapper{name='hasEdgeReinforcement', typeName='xs:boolean', targetNamespace='', required=true, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'hasEdgeReinforcement' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty HasEdgeReinforcement = new SimpleBooleanProperty();

    @XmlAttribute(name = "hasEdgeReinforcement", required = true)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getHasEdgeReinforcement() {
        return this.HasEdgeReinforcement.get();
    };

    public void setHasEdgeReinforcement( boolean value) {
        this.HasEdgeReinforcement.set( value);

    }
    // end hasEdgeReinforcement

    // AttributeWrapper{name='reinforcementType', typeName='reinforcementType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // reinforcementType => TypeWrapper{name='reinforcementType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use ReinforcementTypeEnum
    // Java Type , ReinforcementTypeEnum Type Adapter !!!typeAdapter unmapped type reinforcementType!!!
    /* The 'reinforcementType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of reinforcementType as ReinforcementTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? reinforcementType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<ReinforcementTypeEnum> ReinforcementType = new  javafx.beans.property.SimpleObjectProperty<ReinforcementTypeEnum>();

    @XmlAttribute(name = "reinforcementType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "reinforcementType")
    public ReinforcementTypeEnum getReinforcementType() {
        return this.ReinforcementType.get();
    };

    public void setReinforcementType( ReinforcementTypeEnum value) {
        this.ReinforcementType.set( value);

    }
    // end reinforcementType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property ArmLengthU
    // PropertyWrapper{name='ArmLengthU', typeName='ArmLengthU', docu='null', type=ArmLengthU, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ArmLengthU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ArmLengthU' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ArmLengthU> ArmLengthU = new javafx.beans.property.SimpleObjectProperty<ArmLengthU>();

    @XmlElement(name = "ArmLengthU", required = true)
    public ArmLengthU getArmLengthU() {
        return this.ArmLengthU.get();
    }
    public void setArmLengthU( ArmLengthU value) {
        this.ArmLengthU.set( value);
    }




    // Property ArmLengthV
    // PropertyWrapper{name='ArmLengthV', typeName='ArmLengthV', docu='null', type=ArmLengthV, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ArmLengthV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ArmLengthV' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ArmLengthV> ArmLengthV = new javafx.beans.property.SimpleObjectProperty<ArmLengthV>();

    @XmlElement(name = "ArmLengthV", required = true)
    public ArmLengthV getArmLengthV() {
        return this.ArmLengthV.get();
    }
    public void setArmLengthV( ArmLengthV value) {
        this.ArmLengthV.set( value);
    }




    // Property UDirection
    // PropertyWrapper{name='UDirection', typeName='UDirection', docu='null', type=UDirection, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UDirection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UDirection> UDirection = new javafx.beans.property.SimpleObjectProperty<UDirection>();

    @XmlElement(name = "UDirection", required = true)
    public UDirection getUDirection() {
        return this.UDirection.get();
    }
    public void setUDirection( UDirection value) {
        this.UDirection.set( value);
    }




    // Property VDirection
    // PropertyWrapper{name='VDirection', typeName='VDirection', docu='null', type=VDirection, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='VDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'VDirection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<VDirection> VDirection = new javafx.beans.property.SimpleObjectProperty<VDirection>();

    @XmlElement(name = "VDirection", required = true)
    public VDirection getVDirection() {
        return this.VDirection.get();
    }
    public void setVDirection( VDirection value) {
        this.VDirection.set( value);
    }




    // Property Origin
    // PropertyWrapper{name='Origin', typeName='Origin', docu='null', type=Origin, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Origin', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Origin' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Origin> Origin = new javafx.beans.property.SimpleObjectProperty<Origin>();

    @XmlElement(name = "Origin", required = true)
    public Origin getOrigin() {
        return this.Origin.get();
    }
    public void setOrigin( Origin value) {
        this.Origin.set( value);
    }




    // Property Unose
    // PropertyWrapper{name='Unose', typeName='Unose', docu='null', type=Unose, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Unose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Unose' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Unose> Unose = new javafx.beans.property.SimpleObjectProperty<Unose>();

    @XmlElement(name = "Unose", required = false)
    public Unose getUnose() {
        return this.Unose.get();
    }
    public void setUnose( Unose value) {
        this.Unose.set( value);
    }




    // Property Vnose
    // PropertyWrapper{name='Vnose', typeName='Vnose', docu='null', type=Vnose, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Vnose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Vnose' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Vnose> Vnose = new javafx.beans.property.SimpleObjectProperty<Vnose>();

    @XmlElement(name = "Vnose", required = false)
    public Vnose getVnose() {
        return this.Vnose.get();
    }
    public void setVnose( Vnose value) {
        this.Vnose.set( value);
    }




    // Property FreeEdgeRadius
    // PropertyWrapper{name='FreeEdgeRadius', typeName='FreeEdgeRadius', docu='null', type=FreeEdgeRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FreeEdgeRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FreeEdgeRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FreeEdgeRadius> FreeEdgeRadius = new javafx.beans.property.SimpleObjectProperty<FreeEdgeRadius>();

    @XmlElement(name = "FreeEdgeRadius", required = false)
    public FreeEdgeRadius getFreeEdgeRadius() {
        return this.FreeEdgeRadius.get();
    }
    public void setFreeEdgeRadius( FreeEdgeRadius value) {
        this.FreeEdgeRadius.set( value);
    }




    // Property FeatureCope
    // PropertyWrapper{name='FeatureCope', typeName='FeatureCope', docu='null', type=FeatureCope, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FeatureCope', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FeatureCope_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FeatureCope' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FeatureCope> FeatureCope = new javafx.beans.property.SimpleObjectProperty<FeatureCope>();

    @XmlElement(name = "FeatureCope", required = false)
    public FeatureCope getFeatureCope() {
        return this.FeatureCope.get();
    }
    public void setFeatureCope( FeatureCope value) {
        this.FeatureCope.set( value);
    }




    // Property FlangeEdgeReinforcement
    // PropertyWrapper{name='FlangeEdgeReinforcement', typeName='FlangeEdgeReinforcement', docu='null', type=FlangeEdgeReinforcement, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FlangeEdgeReinforcement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FlangeEdgeReinforcement_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeEdgeReinforcement' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeEdgeReinforcement> FlangeEdgeReinforcement = new javafx.beans.property.SimpleObjectProperty<FlangeEdgeReinforcement>();

    @XmlElement(name = "FlangeEdgeReinforcement", required = false)
    public FlangeEdgeReinforcement getFlangeEdgeReinforcement() {
        return this.FlangeEdgeReinforcement.get();
    }
    public void setFlangeEdgeReinforcement( FlangeEdgeReinforcement value) {
        this.FlangeEdgeReinforcement.set( value);
    }




    // end the properties serialised to elements




      public BracketParametersT() {
          try {

          // attr hasEdgeReinforcement with default value 'false', type boolean
           HasEdgeReinforcement.set( Boolean.parseBoolean("false"));
 

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
