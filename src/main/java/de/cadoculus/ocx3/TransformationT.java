
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Transformation_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition for a Local (Orthogonal) Axis System.
 *  

*/
// Transformation_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Transformation_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class TransformationT extends BaseClass
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




    // Property PrimaryAxis
    // PropertyWrapper{name='PrimaryAxis', typeName='PrimaryAxis', docu='null', type=PrimaryAxis, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PrimaryAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PrimaryAxis' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PrimaryAxis> PrimaryAxis = new javafx.beans.property.SimpleObjectProperty<PrimaryAxis>();

    @XmlElement(name = "PrimaryAxis", required = true)
    public PrimaryAxis getPrimaryAxis() {
        return this.PrimaryAxis.get();
    }
    public void setPrimaryAxis( PrimaryAxis value) {
        this.PrimaryAxis.set( value);
    }




    // Property SecondaryAxis
    // PropertyWrapper{name='SecondaryAxis', typeName='SecondaryAxis', docu='null', type=SecondaryAxis, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SecondaryAxis', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Vector3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SecondaryAxis' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SecondaryAxis> SecondaryAxis = new javafx.beans.property.SimpleObjectProperty<SecondaryAxis>();

    @XmlElement(name = "SecondaryAxis", required = true)
    public SecondaryAxis getSecondaryAxis() {
        return this.SecondaryAxis.get();
    }
    public void setSecondaryAxis( SecondaryAxis value) {
        this.SecondaryAxis.set( value);
    }




    // end the properties serialised to elements




      public TransformationT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
