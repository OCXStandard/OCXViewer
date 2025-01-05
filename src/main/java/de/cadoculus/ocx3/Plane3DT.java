
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Plane3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a Planar surface defined by Root Point and Normal.
 *  

*/
// Plane3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Surface_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Plane3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Plane3DT extends SurfaceT
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




    // Property Normal
    // PropertyWrapper{name='Normal', typeName='Normal', docu='null', type=Normal, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Normal', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Normal' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Normal> Normal = new javafx.beans.property.SimpleObjectProperty<Normal>();

    @XmlElement(name = "Normal", required = true)
    public Normal getNormal() {
        return this.Normal.get();
    }
    public void setNormal( Normal value) {
        this.Normal.set( value);
    }




    // Property UDirection
    // PropertyWrapper{name='UDirection', typeName='UDirection', docu='null', type=UDirection, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='UDirection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UDirection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UDirection> UDirection = new javafx.beans.property.SimpleObjectProperty<UDirection>();

    @XmlElement(name = "UDirection", required = false)
    public UDirection getUDirection() {
        return this.UDirection.get();
    }
    public void setUDirection( UDirection value) {
        this.UDirection.set( value);
    }




    // Property LimitedBy
    // PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='LimitedBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LimitedBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LimitedBy' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LimitedBy> LimitedBy = new javafx.beans.property.SimpleObjectProperty<LimitedBy>();

    @XmlElement(name = "LimitedBy", required = false)
    public LimitedBy getLimitedBy() {
        return this.LimitedBy.get();
    }
    public void setLimitedBy( LimitedBy value) {
        this.LimitedBy.set( value);
    }




    // end the properties serialised to elements




      public Plane3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
