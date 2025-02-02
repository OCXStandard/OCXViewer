
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>RectangularMickeyMouseEars_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * A hole where the two circular parts have unequal radii.
 *  

*/
// RectangularMickeyMouseEars_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ParametricHole2D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RectangularMickeyMouseEars_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class RectangularMickeyMouseEarsT extends ParametricHole2DT
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




    // Property Radius
    // PropertyWrapper{name='Radius', typeName='Radius', docu='null', type=Radius, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Radius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Radius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Radius> Radius = new javafx.beans.property.SimpleObjectProperty<Radius>();

    @XmlElement(name = "Radius", required = true)
    public Radius getRadius() {
        return this.Radius.get();
    }
    public void setRadius( Radius value) {
        this.Radius.set( value);
    }




    // Property Displacement
    // PropertyWrapper{name='Displacement', typeName='Displacement', docu='null', type=Displacement, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Displacement', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Displacement' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Displacement> Displacement = new javafx.beans.property.SimpleObjectProperty<Displacement>();

    @XmlElement(name = "Displacement", required = false)
    public Displacement getDisplacement() {
        return this.Displacement.get();
    }
    public void setDisplacement( Displacement value) {
        this.Displacement.set( value);
    }




    // end the properties serialised to elements




      public RectangularMickeyMouseEarsT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
