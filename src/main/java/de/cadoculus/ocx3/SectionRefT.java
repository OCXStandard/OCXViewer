
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SectionRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// SectionRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// CatalogueRef_T  
// reference type BarSection

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SectionRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SectionRefT extends CatalogueRefT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:BarSection', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // refType => TypeWrapper{name='refType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use RefTypeEnum
    // Java Type , RefTypeEnum Type Adapter !!!typeAdapter unmapped type refType!!!
    /* The 'refType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of refType as RefTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? refType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<RefTypeEnum> RefType = new  javafx.beans.property.SimpleObjectProperty<RefTypeEnum>();

    @XmlAttribute(name = "refType", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "refType")
    public RefTypeEnum getRefType() {
        return this.RefType.get();
    };

    public void setRefType( RefTypeEnum value) {
        this.RefType.set( value);

    }
    // end refType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property OffsetU
    // PropertyWrapper{name='OffsetU', typeName='OffsetU', docu='null', type=OffsetU, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='OffsetU', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OffsetU' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<OffsetU> OffsetU = new javafx.beans.property.SimpleObjectProperty<OffsetU>();

    @XmlElement(name = "OffsetU", required = true)
    public OffsetU getOffsetU() {
        return this.OffsetU.get();
    }
    public void setOffsetU( OffsetU value) {
        this.OffsetU.set( value);
    }




    // Property OffsetV
    // PropertyWrapper{name='OffsetV', typeName='OffsetV', docu='null', type=OffsetV, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='OffsetV', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OffsetV' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<OffsetV> OffsetV = new javafx.beans.property.SimpleObjectProperty<OffsetV>();

    @XmlElement(name = "OffsetV", required = true)
    public OffsetV getOffsetV() {
        return this.OffsetV.get();
    }
    public void setOffsetV( OffsetV value) {
        this.OffsetV.set( value);
    }




    // end the properties serialised to elements




      public SectionRefT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
