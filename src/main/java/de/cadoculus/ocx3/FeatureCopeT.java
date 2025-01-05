
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FeatureCope_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Cope parameters.
 *  

*/
// FeatureCope_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FeatureCope_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class FeatureCopeT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CopeRadius
    // PropertyWrapper{name='CopeRadius', typeName='CopeRadius', docu='null', type=CopeRadius, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CopeRadius', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CopeRadius' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CopeRadius> CopeRadius = new javafx.beans.property.SimpleObjectProperty<CopeRadius>();

    @XmlElement(name = "CopeRadius", required = true)
    public CopeRadius getCopeRadius() {
        return this.CopeRadius.get();
    }
    public void setCopeRadius( CopeRadius value) {
        this.CopeRadius.set( value);
    }




    // Property CopeLength
    // PropertyWrapper{name='CopeLength', typeName='CopeLength', docu='null', type=CopeLength, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='CopeLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CopeLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CopeLength> CopeLength = new javafx.beans.property.SimpleObjectProperty<CopeLength>();

    @XmlElement(name = "CopeLength", required = false)
    public CopeLength getCopeLength() {
        return this.CopeLength.get();
    }
    public void setCopeLength( CopeLength value) {
        this.CopeLength.set( value);
    }




    // Property CopeHeight
    // PropertyWrapper{name='CopeHeight', typeName='CopeHeight', docu='null', type=CopeHeight, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='CopeHeight', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CopeHeight' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CopeHeight> CopeHeight = new javafx.beans.property.SimpleObjectProperty<CopeHeight>();

    @XmlElement(name = "CopeHeight", required = false)
    public CopeHeight getCopeHeight() {
        return this.CopeHeight.get();
    }
    public void setCopeHeight( CopeHeight value) {
        this.CopeHeight.set( value);
    }




    // end the properties serialised to elements




      public FeatureCopeT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
