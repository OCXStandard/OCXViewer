
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SlotParameters_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the SlotParameters for a slot cut-out typically used in shipbuilding.
 *  

*/
// SlotParameters_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SlotParameters_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SlotParametersT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='asymmetric', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='true', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'asymmetric' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty Asymmetric = new SimpleBooleanProperty();

    @XmlAttribute(name = "asymmetric", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getAsymmetric() {
        return this.Asymmetric.get();
    };

    public void setAsymmetric( boolean value) {
        this.Asymmetric.set( value);

    }
    // end asymmetric

    // AttributeWrapper{name='slotType', typeName='slotType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='Open', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // slotType => TypeWrapper{name='slotType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use SlotTypeEnum
    // Java Type , SlotTypeEnum Type Adapter !!!typeAdapter unmapped type slotType!!!
    /* The 'slotType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of slotType as SlotTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? slotType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<SlotTypeEnum> SlotType = new  javafx.beans.property.SimpleObjectProperty<SlotTypeEnum>();

    @XmlAttribute(name = "slotType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "slotType")
    public SlotTypeEnum getSlotType() {
        return this.SlotType.get();
    };

    public void setSlotType( SlotTypeEnum value) {
        this.SlotType.set( value);

    }
    // end slotType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Height
    // PropertyWrapper{name='Height', typeName='Height', docu='null', type=Height, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Height', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Height' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Height> Height = new javafx.beans.property.SimpleObjectProperty<Height>();

    @XmlElement(name = "Height", required = true)
    public Height getHeight() {
        return this.Height.get();
    }
    public void setHeight( Height value) {
        this.Height.set( value);
    }




    // Property Width
    // PropertyWrapper{name='Width', typeName='Width', docu='null', type=Width, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Width', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Width' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Width> Width = new javafx.beans.property.SimpleObjectProperty<Width>();

    @XmlElement(name = "Width", required = true)
    public Width getWidth() {
        return this.Width.get();
    }
    public void setWidth( Width value) {
        this.Width.set( value);
    }




    // Property UpperRadius
    // PropertyWrapper{name='UpperRadius', typeName='UpperRadius', docu='null', type=UpperRadius, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UpperRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UpperRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UpperRadius> UpperRadius = new javafx.beans.property.SimpleObjectProperty<UpperRadius>();

    @XmlElement(name = "UpperRadius", required = true)
    public UpperRadius getUpperRadius() {
        return this.UpperRadius.get();
    }
    public void setUpperRadius( UpperRadius value) {
        this.UpperRadius.set( value);
    }




    // Property ConnectionLength
    // PropertyWrapper{name='ConnectionLength', typeName='ConnectionLength', docu='null', type=ConnectionLength, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ConnectionLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ConnectionLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ConnectionLength> ConnectionLength = new javafx.beans.property.SimpleObjectProperty<ConnectionLength>();

    @XmlElement(name = "ConnectionLength", required = false)
    public ConnectionLength getConnectionLength() {
        return this.ConnectionLength.get();
    }
    public void setConnectionLength( ConnectionLength value) {
        this.ConnectionLength.set( value);
    }




    // Property LowerRadius
    // PropertyWrapper{name='LowerRadius', typeName='LowerRadius', docu='null', type=LowerRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='LowerRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LowerRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LowerRadius> LowerRadius = new javafx.beans.property.SimpleObjectProperty<LowerRadius>();

    @XmlElement(name = "LowerRadius", required = false)
    public LowerRadius getLowerRadius() {
        return this.LowerRadius.get();
    }
    public void setLowerRadius( LowerRadius value) {
        this.LowerRadius.set( value);
    }




    // Property LugPlateRef
    // PropertyWrapper{name='LugPlateRef', typeName='LugPlateRef', docu='null', type=LugPlateRef, minOccurs=0, maxOccurs=2}
    // TypeWrapper{name='LugPlateRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LugPlaterRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='ConnectionLength', typeName='ConnectionLength', docu='null', type=ConnectionLength, minOccurs=1, maxOccurs=1}, PropertyWrapper{name='DistanceAbove', typeName='DistanceAbove', docu='null', type=DistanceAbove, minOccurs=1, maxOccurs=1}]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LugPlateRef' property serialised as  XML elemenmt.
    * 
    */

    private List<LugPlateRef> lugPlateRefs = new ArrayList<>();

    public List<LugPlateRef> getLugPlateRef() {
        return lugPlateRefs;
    }




    // end the properties serialised to elements




      public SlotParametersT() {
          try {
          // attr asymmetric with default value 'true', type boolean
           Asymmetric.set( Boolean.parseBoolean("true"));
 
          // attr slotType with default value 'Open', type SlotTypeEnum
           SlotType.set(SlotTypeEnum.parse("Open"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
