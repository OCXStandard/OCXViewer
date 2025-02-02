
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Panel_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Structural concept of shipbuilding panels. Panels can typically be
 * 				composed of plates, seams and stiffeners.
 *  

*/
// Panel_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Panel_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PanelT extends EntityBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // functionType => TypeWrapper{name='functionType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use FunctionTypeEnum
    // Java Type , FunctionTypeEnum Type Adapter !!!typeAdapter unmapped type functionType!!!
    /* The 'functionType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of functionType as FunctionTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? functionType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<FunctionTypeEnum> FunctionType = new  javafx.beans.property.SimpleObjectProperty<FunctionTypeEnum>();

    @XmlAttribute(name = "functionType", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "functionType")
    public FunctionTypeEnum getFunctionType() {
        return this.FunctionType.get();
    };

    public void setFunctionType( FunctionTypeEnum value) {
        this.FunctionType.set( value);

    }
    // end functionType

    // AttributeWrapper{name='tightness', typeName='tightness', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // tightness => TypeWrapper{name='tightness', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use TightnessEnum
    // Java Type , TightnessEnum Type Adapter !!!typeAdapter unmapped type tightness!!!
    /* The 'tightness' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of tightness as TightnessEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? tightness
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<TightnessEnum> Tightness = new  javafx.beans.property.SimpleObjectProperty<TightnessEnum>();

    @XmlAttribute(name = "tightness", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "tightness")
    public TightnessEnum getTightness() {
        return this.Tightness.get();
    };

    public void setTightness( TightnessEnum value) {
        this.Tightness.set( value);

    }
    // end tightness
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property UnboundedGeometry
    // PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UnboundedGeometry', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnboundedGeometry_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UnboundedGeometry' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UnboundedGeometry> UnboundedGeometry = new javafx.beans.property.SimpleObjectProperty<UnboundedGeometry>();

    @XmlElement(name = "UnboundedGeometry", required = true)
    public UnboundedGeometry getUnboundedGeometry() {
        return this.UnboundedGeometry.get();
    }
    public void setUnboundedGeometry( UnboundedGeometry value) {
        this.UnboundedGeometry.set( value);
    }




    // Property LimitedBy
    // PropertyWrapper{name='LimitedBy', typeName='LimitedBy', docu='null', type=LimitedBy, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='LimitedBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LimitedBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LimitedBy' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LimitedBy> LimitedBy = new javafx.beans.property.SimpleObjectProperty<LimitedBy>();

    @XmlElement(name = "LimitedBy", required = true)
    public LimitedBy getLimitedBy() {
        return this.LimitedBy.get();
    }
    public void setLimitedBy( LimitedBy value) {
        this.LimitedBy.set( value);
    }




    // Property ComposedOf
    // PropertyWrapper{name='ComposedOf', typeName='ComposedOf', docu='null', type=ComposedOf, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ComposedOf', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ComposedOf_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ComposedOf' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ComposedOf> ComposedOf = new javafx.beans.property.SimpleObjectProperty<ComposedOf>();

    @XmlElement(name = "ComposedOf", required = true)
    public ComposedOf getComposedOf() {
        return this.ComposedOf.get();
    }
    public void setComposedOf( ComposedOf value) {
        this.ComposedOf.set( value);
    }




    // Property PhysicalProperties
    // PropertyWrapper{name='PhysicalProperties', typeName='PhysicalProperties', docu='null', type=PhysicalProperties, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='PhysicalProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PhysicalProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PhysicalProperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PhysicalProperties> PhysicalProperties = new javafx.beans.property.SimpleObjectProperty<PhysicalProperties>();

    @XmlElement(name = "PhysicalProperties", required = false)
    public PhysicalProperties getPhysicalProperties() {
        return this.PhysicalProperties.get();
    }
    public void setPhysicalProperties( PhysicalProperties value) {
        this.PhysicalProperties.set( value);
    }




    // Property OuterContour
    // PropertyWrapper{name='OuterContour', typeName='OuterContour', docu='null', type=OuterContour, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='OuterContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OuterContour' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<OuterContour> OuterContour = new javafx.beans.property.SimpleObjectProperty<OuterContour>();

    @XmlElement(name = "OuterContour", required = false)
    public OuterContour getOuterContour() {
        return this.OuterContour.get();
    }
    public void setOuterContour( OuterContour value) {
        this.OuterContour.set( value);
    }




    // Property StiffenedBy
    // PropertyWrapper{name='StiffenedBy', typeName='StiffenedBy', docu='null', type=StiffenedBy, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='StiffenedBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='StiffenedBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'StiffenedBy' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<StiffenedBy> StiffenedBy = new javafx.beans.property.SimpleObjectProperty<StiffenedBy>();

    @XmlElement(name = "StiffenedBy", required = false)
    public StiffenedBy getStiffenedBy() {
        return this.StiffenedBy.get();
    }
    public void setStiffenedBy( StiffenedBy value) {
        this.StiffenedBy.set( value);
    }




    // Property SplitBy
    // PropertyWrapper{name='SplitBy', typeName='SplitBy', docu='null', type=SplitBy, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='SplitBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SplitBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SplitBy' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SplitBy> SplitBy = new javafx.beans.property.SimpleObjectProperty<SplitBy>();

    @XmlElement(name = "SplitBy", required = false)
    public SplitBy getSplitBy() {
        return this.SplitBy.get();
    }
    public void setSplitBy( SplitBy value) {
        this.SplitBy.set( value);
    }




    // Property CutBy
    // PropertyWrapper{name='CutBy', typeName='CutBy', docu='null', type=CutBy, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='CutBy', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CutBy_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CutBy' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CutBy> CutBy = new javafx.beans.property.SimpleObjectProperty<CutBy>();

    @XmlElement(name = "CutBy", required = false)
    public CutBy getCutBy() {
        return this.CutBy.get();
    }
    public void setCutBy( CutBy value) {
        this.CutBy.set( value);
    }




    // end the properties serialised to elements




      public PanelT() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
