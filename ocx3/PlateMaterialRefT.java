
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PlateMaterialRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// PlateMaterialRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// CatalogueRef_T  
// reference type MaterialT

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PlateMaterialRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PlateMaterialRefT extends CatalogueRefT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='refType', typeName='refType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='ocx:Material', referencedType='Object'}
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
    // Property Thickness
    // PropertyWrapper{name='Thickness', typeName='Thickness', docu='null', type=Thickness, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Thickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Thickness' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Thickness> Thickness = new javafx.beans.property.SimpleObjectProperty<Thickness>();

    @XmlElement(name = "Thickness", required = true)
    public Thickness getThickness() {
        return this.Thickness.get();
    }
    public void setThickness( Thickness value) {
        this.Thickness.set( value);
    }




    // end the properties serialised to elements




      public PlateMaterialRefT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
