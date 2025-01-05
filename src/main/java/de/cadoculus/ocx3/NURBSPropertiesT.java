
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>NURBSProperties_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a class defining the properties of the NURBS curve.
 *  

*/
// NURBSProperties_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "NURBSProperties_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class NURBSPropertiesT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='degree', typeName='xs:int', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:int => TypeWrapper{name='int', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use int
    // Java Type , int Type Adapter !!!typeAdapter unmapped type xs:int!!!
    /* The 'degree' value serialised as  XML attribute.
    * <summary>
    * B-spline degree p is the highest exponent used in the polynomial basis function. The
    * 					B-spline order is always p+1. Defined as p = m - n - 1 if not given explicitly where m is the number
    * 					of knots and n is the number of control points.</summary>
    */
    // contains the String serialised form of xs:int as int ( default namespace)
    @XmlTransient
    public IntegerProperty Degree = new SimpleIntegerProperty();

    @XmlAttribute(name = "degree", required = true)
    @XmlSchemaType(name = "xs:int")
    public int getDegree() {
        return this.Degree.get();
    };

    public void setDegree( int value) {
        this.Degree.set( value);

    }
    // end degree

    // AttributeWrapper{name='numCtrlPts', typeName='xs:long', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:long => TypeWrapper{name='long', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use long
    // Java Type , long Type Adapter !!!typeAdapter unmapped type xs:long!!!
    /* The 'numCtrlPts' value serialised as  XML attribute.
    * <summary>
    * Number of control points in the curve direction or the surface grid u or v
    * 					direction.</summary>
    */
    // contains the String serialised form of xs:long as long ( default namespace)
    @XmlTransient
    public LongProperty NumCtrlPts = new SimpleLongProperty();

    @XmlAttribute(name = "numCtrlPts", required = true)
    @XmlSchemaType(name = "xs:long")
    public long getNumCtrlPts() {
        return this.NumCtrlPts.get();
    };

    public void setNumCtrlPts( long value) {
        this.NumCtrlPts.set( value);

    }
    // end numCtrlPts

    // AttributeWrapper{name='numKnots', typeName='xs:long', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:long => TypeWrapper{name='long', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use long
    // Java Type , long Type Adapter !!!typeAdapter unmapped type xs:long!!!
    /* The 'numKnots' value serialised as  XML attribute.
    * <summary>
    * numKnots: m=(p+n-1) numbers, where p is the polynomial basis degree and n is the
    * 					number of control points.</summary>
    */
    // contains the String serialised form of xs:long as long ( default namespace)
    @XmlTransient
    public LongProperty NumKnots = new SimpleLongProperty();

    @XmlAttribute(name = "numKnots", required = true)
    @XmlSchemaType(name = "xs:long")
    public long getNumKnots() {
        return this.NumKnots.get();
    };

    public void setNumKnots( long value) {
        this.NumKnots.set( value);

    }
    // end numKnots

    // AttributeWrapper{name='form', typeName='curveForm_enum', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='Open', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // curveForm_enum => TypeWrapper{name='curveForm_enum', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use CurveForm_enumEnum
    // Java Type , CurveForm_enumEnum Type Adapter !!!typeAdapter unmapped type curveForm_enum!!!
    /* The 'form' value serialised as  XML attribute.
    * <summary>
    * The NURBS curve form (Open, Closed, or Periodic).</summary>
    */
    // contains the String serialised form of curveForm_enum as CurveForm_enumEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? curveForm_enum
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<CurveForm_enumEnum> Form = new  javafx.beans.property.SimpleObjectProperty<CurveForm_enumEnum>();

    @XmlAttribute(name = "form", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "curveForm_enum")
    public CurveForm_enumEnum getForm() {
        return this.Form.get();
    };

    public void setForm( CurveForm_enumEnum value) {
        this.Form.set( value);

    }
    // end form

    // AttributeWrapper{name='isRational', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'isRational' value serialised as  XML attribute.
    * <summary>
    * The default is non-rational basis functions (isRational=false). Rational refers to the
    * 					underlying mathematical representation. This property allows NURBS to represent exact conics (such
    * 					as parabolic curves, circles, and ellipses) in addition to free-form curves. To define conical curve
    * 					types set isRational=true.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty IsRational = new SimpleBooleanProperty();

    @XmlAttribute(name = "isRational", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getIsRational() {
        return this.IsRational.get();
    };

    public void setIsRational( boolean value) {
        this.IsRational.set( value);

    }
    // end isRational
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public NURBSPropertiesT() {
          try {



          // attr form with default value 'Open', type CurveForm_enumEnum
           Form.set(CurveForm_enumEnum.parse("Open"));
 
          // attr isRational with default value 'false', type boolean
           IsRational.set( Boolean.parseBoolean("false"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
