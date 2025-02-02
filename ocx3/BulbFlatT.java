
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BulbFlat_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * BulbFlat type.
 *  

*/
// BulbFlat_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BulbFlat_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BulbFlatT extends BaseClass
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




    // Property FlangeWidth
    // PropertyWrapper{name='FlangeWidth', typeName='FlangeWidth', docu='null', type=FlangeWidth, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='FlangeWidth', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlangeWidth' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlangeWidth> FlangeWidth = new javafx.beans.property.SimpleObjectProperty<FlangeWidth>();

    @XmlElement(name = "FlangeWidth", required = false)
    public FlangeWidth getFlangeWidth() {
        return this.FlangeWidth.get();
    }
    public void setFlangeWidth( FlangeWidth value) {
        this.FlangeWidth.set( value);
    }




    // Property BulbAngle
    // PropertyWrapper{name='BulbAngle', typeName='BulbAngle', docu='null', type=BulbAngle, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='BulbAngle', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BulbAngle' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BulbAngle> BulbAngle = new javafx.beans.property.SimpleObjectProperty<BulbAngle>();

    @XmlElement(name = "BulbAngle", required = false)
    public BulbAngle getBulbAngle() {
        return this.BulbAngle.get();
    }
    public void setBulbAngle( BulbAngle value) {
        this.BulbAngle.set( value);
    }




    // Property BulbOuterRadius
    // PropertyWrapper{name='BulbOuterRadius', typeName='BulbOuterRadius', docu='null', type=BulbOuterRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='BulbOuterRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BulbOuterRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BulbOuterRadius> BulbOuterRadius = new javafx.beans.property.SimpleObjectProperty<BulbOuterRadius>();

    @XmlElement(name = "BulbOuterRadius", required = false)
    public BulbOuterRadius getBulbOuterRadius() {
        return this.BulbOuterRadius.get();
    }
    public void setBulbOuterRadius( BulbOuterRadius value) {
        this.BulbOuterRadius.set( value);
    }




    // Property BulbInnerRadius
    // PropertyWrapper{name='BulbInnerRadius', typeName='BulbInnerRadius', docu='null', type=BulbInnerRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='BulbInnerRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BulbInnerRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BulbInnerRadius> BulbInnerRadius = new javafx.beans.property.SimpleObjectProperty<BulbInnerRadius>();

    @XmlElement(name = "BulbInnerRadius", required = false)
    public BulbInnerRadius getBulbInnerRadius() {
        return this.BulbInnerRadius.get();
    }
    public void setBulbInnerRadius( BulbInnerRadius value) {
        this.BulbInnerRadius.set( value);
    }




    // Property BulbTopRadius
    // PropertyWrapper{name='BulbTopRadius', typeName='BulbTopRadius', docu='null', type=BulbTopRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='BulbTopRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BulbTopRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BulbTopRadius> BulbTopRadius = new javafx.beans.property.SimpleObjectProperty<BulbTopRadius>();

    @XmlElement(name = "BulbTopRadius", required = false)
    public BulbTopRadius getBulbTopRadius() {
        return this.BulbTopRadius.get();
    }
    public void setBulbTopRadius( BulbTopRadius value) {
        this.BulbTopRadius.set( value);
    }




    // Property BulbBottomRadius
    // PropertyWrapper{name='BulbBottomRadius', typeName='BulbBottomRadius', docu='null', type=BulbBottomRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='BulbBottomRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BulbBottomRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BulbBottomRadius> BulbBottomRadius = new javafx.beans.property.SimpleObjectProperty<BulbBottomRadius>();

    @XmlElement(name = "BulbBottomRadius", required = false)
    public BulbBottomRadius getBulbBottomRadius() {
        return this.BulbBottomRadius.get();
    }
    public void setBulbBottomRadius( BulbBottomRadius value) {
        this.BulbBottomRadius.set( value);
    }




    // end the properties serialised to elements




      public BulbFlatT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
