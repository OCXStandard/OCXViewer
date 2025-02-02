
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SuperElliptical_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a super-elliptical hole. It can also describe a true ellipse.
 *  

*/
// SuperElliptical_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ParametricHole2D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SuperElliptical_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SuperEllipticalT extends ParametricHole2DT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='exponent', typeName='xs:double', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'exponent' value serialised as  XML attribute.
    * <summary>
    * The exponent of the super ellipse equation (x/Height)**e + (y/Width)**e = 1. If e=2.5 the result is a super ellipse while e=2.0 results in a normal ellipse.</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty Exponent = new SimpleDoubleProperty();

    @XmlAttribute(name = "exponent", required = true)
    @XmlSchemaType(name = "xs:double")
    public double getExponent() {
        return this.Exponent.get();
    };

    public void setExponent( double value) {
        this.Exponent.set( value);

    }
    // end exponent
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




    // end the properties serialised to elements




      public SuperEllipticalT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
