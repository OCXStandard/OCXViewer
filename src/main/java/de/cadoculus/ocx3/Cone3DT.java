
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Cone3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the Cone surface defined by origin, radius and position of the cone
 * 				tip.
 *  

*/
// Cone3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Surface_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Cone3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Cone3DT extends SurfaceT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
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




    // Property Tip
    // PropertyWrapper{name='Tip', typeName='Tip', docu='null', type=Tip, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Tip', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Tip' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Tip> Tip = new javafx.beans.property.SimpleObjectProperty<Tip>();

    @XmlElement(name = "Tip", required = true)
    public Tip getTip() {
        return this.Tip.get();
    }
    public void setTip( Tip value) {
        this.Tip.set( value);
    }




    // Property BaseRadius
    // PropertyWrapper{name='BaseRadius', typeName='BaseRadius', docu='null', type=BaseRadius, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='BaseRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BaseRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BaseRadius> BaseRadius = new javafx.beans.property.SimpleObjectProperty<BaseRadius>();

    @XmlElement(name = "BaseRadius", required = true)
    public BaseRadius getBaseRadius() {
        return this.BaseRadius.get();
    }
    public void setBaseRadius( BaseRadius value) {
        this.BaseRadius.set( value);
    }




    // Property TipRadius
    // PropertyWrapper{name='TipRadius', typeName='TipRadius', docu='null', type=TipRadius, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='TipRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'TipRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<TipRadius> TipRadius = new javafx.beans.property.SimpleObjectProperty<TipRadius>();

    @XmlElement(name = "TipRadius", required = false)
    public TipRadius getTipRadius() {
        return this.TipRadius.get();
    }
    public void setTipRadius( TipRadius value) {
        this.TipRadius.set( value);
    }




    // end the properties serialised to elements




      public Cone3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
