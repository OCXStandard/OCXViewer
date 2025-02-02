
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Curve3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the abstract base class for any 3D curve.
 *  

*/
// Curve3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// GeometryRepresentation_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Curve3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Curve3DT extends GeometryRepresentationT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='is2D', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'is2D' value serialised as  XML attribute.
    * <summary>
    * Set to True if the Curve3D is given in 2D space.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty Is2D = new SimpleBooleanProperty();

    @XmlAttribute(name = "is2D", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getIs2D() {
        return this.Is2D.get();
    };

    public void setIs2D( boolean value) {
        this.Is2D.set( value);

    }
    // end is2D
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CurveLength
    // PropertyWrapper{name='CurveLength', typeName='CurveLength', docu='null', type=CurveLength, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CurveLength', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CurveLength' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CurveLength> CurveLength = new javafx.beans.property.SimpleObjectProperty<CurveLength>();

    @XmlElement(name = "CurveLength", required = true)
    public CurveLength getCurveLength() {
        return this.CurveLength.get();
    }
    public void setCurveLength( CurveLength value) {
        this.CurveLength.set( value);
    }




    // end the properties serialised to elements




      public Curve3DT() {
          try {
          // attr is2D with default value 'false', type boolean
           Is2D.set( Boolean.parseBoolean("false"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
