
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>TBar_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// TBar_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "TBar_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class TBarT extends BaseClass
{

    // the properties serialised to attributes
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




    // Property WebThickness
    // PropertyWrapper{name='WebThickness', typeName='WebThickness', docu='null', type=WebThickness, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='WebThickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'WebThickness' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<WebThickness> WebThickness = new javafx.beans.property.SimpleObjectProperty<WebThickness>();

    @XmlElement(name = "WebThickness", required = true)
    public WebThickness getWebThickness() {
        return this.WebThickness.get();
    }
    public void setWebThickness( WebThickness value) {
        this.WebThickness.set( value);
    }




    // Property FlangeThickness
    // PropertyWrapper{name='FlangeThickness', typeName='FlangeThickness', docu='null', type=FlangeThickness, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='FlangeThickness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeThickness' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeThickness> FlangeThickness = new javafx.beans.property.SimpleObjectProperty<FlangeThickness>();

    @XmlElement(name = "FlangeThickness", required = true)
    public FlangeThickness getFlangeThickness() {
        return this.FlangeThickness.get();
    }
    public void setFlangeThickness( FlangeThickness value) {
        this.FlangeThickness.set( value);
    }




    // end the properties serialised to elements




      public TBarT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
