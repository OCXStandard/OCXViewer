
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Bracket_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Structural concept of brackets used in shipbuilding.
 *  

*/
// Bracket_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// StructurePart_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Bracket_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BracketT extends StructurePartT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='functionType', typeName='functionType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
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

    @XmlAttribute(name = "functionType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "functionType")
    public FunctionTypeEnum getFunctionType() {
        return this.FunctionType.get();
    };

    public void setFunctionType( FunctionTypeEnum value) {
        this.FunctionType.set( value);

    }
    // end functionType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property BracketParameters
    // PropertyWrapper{name='BracketParameters', typeName='BracketParameters', docu='null', type=BracketParameters, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='BracketParameters', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BracketParameters_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BracketParameters' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BracketParameters> BracketParameters = new javafx.beans.property.SimpleObjectProperty<BracketParameters>();

    @XmlElement(name = "BracketParameters", required = true)
    public BracketParameters getBracketParameters() {
        return this.BracketParameters.get();
    }
    public void setBracketParameters( BracketParameters value) {
        this.BracketParameters.set( value);
    }




    // Property PlateMaterial
    // PropertyWrapper{name='PlateMaterial', typeName='PlateMaterial', docu='null', type=PlateMaterial, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PlateMaterial', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PlateMaterialRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PlateMaterial' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PlateMaterial> PlateMaterial = new javafx.beans.property.SimpleObjectProperty<PlateMaterial>();

    @XmlElement(name = "PlateMaterial", required = true)
    public PlateMaterial getPlateMaterial() {
        return this.PlateMaterial.get();
    }
    public void setPlateMaterial( PlateMaterial value) {
        this.PlateMaterial.set( value);
    }




    // Property Offset
    // PropertyWrapper{name='Offset', typeName='Offset', docu='null', type=Offset, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Offset', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Offset' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Offset> Offset = new javafx.beans.property.SimpleObjectProperty<Offset>();

    @XmlElement(name = "Offset", required = false)
    public Offset getOffset() {
        return this.Offset.get();
    }
    public void setOffset( Offset value) {
        this.Offset.set( value);
    }




    // Property OuterContour
    // PropertyWrapper{name='OuterContour', typeName='OuterContour', docu='null', type=OuterContour, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='OuterContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OuterContour' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<OuterContour> OuterContour = new javafx.beans.property.SimpleObjectProperty<OuterContour>();

    @XmlElement(name = "OuterContour", required = true)
    public OuterContour getOuterContour() {
        return this.OuterContour.get();
    }
    public void setOuterContour( OuterContour value) {
        this.OuterContour.set( value);
    }




    // Property UnboundedGeometry
    // PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='UnboundedGeometry', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnboundedGeometry_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UnboundedGeometry' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UnboundedGeometry> UnboundedGeometry = new javafx.beans.property.SimpleObjectProperty<UnboundedGeometry>();

    @XmlElement(name = "UnboundedGeometry", required = false)
    public UnboundedGeometry getUnboundedGeometry() {
        return this.UnboundedGeometry.get();
    }
    public void setUnboundedGeometry( UnboundedGeometry value) {
        this.UnboundedGeometry.set( value);
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




    // Property InnerContour
    // PropertyWrapper{name='InnerContour', typeName='InnerContour', docu='null', type=InnerContour, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='InnerContour', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'InnerContour' property serialised as  XML elemenmt.
    * 
    */

    private List<InnerContour> innerContours = new ArrayList<>();

    public List<InnerContour> getInnerContour() {
        return innerContours;
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




    // end the properties serialised to elements




      public BracketT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
