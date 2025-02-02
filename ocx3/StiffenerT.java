
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Stiffener_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the Stiffener structure concept.
 *  

*/
// Stiffener_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// StructurePart_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Stiffener_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class StiffenerT extends StructurePartT
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
    // Property TraceLine
    // PropertyWrapper{name='TraceLine', typeName='TraceLine', docu='null', type=TraceLine, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='TraceLine', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TraceLine_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'TraceLine' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<TraceLine> TraceLine = new javafx.beans.property.SimpleObjectProperty<TraceLine>();

    @XmlElement(name = "TraceLine", required = true)
    public TraceLine getTraceLine() {
        return this.TraceLine.get();
    }
    public void setTraceLine( TraceLine value) {
        this.TraceLine.set( value);
    }




    // Property MaterialRef
    // PropertyWrapper{name='MaterialRef', typeName='MaterialRef', docu='null', type=MaterialRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='MaterialRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='MaterialRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'MaterialRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<MaterialRef> MaterialRef = new javafx.beans.property.SimpleObjectProperty<MaterialRef>();

    @XmlElement(name = "MaterialRef", required = true)
    public MaterialRef getMaterialRef() {
        return this.MaterialRef.get();
    }
    public void setMaterialRef( MaterialRef value) {
        this.MaterialRef.set( value);
    }




    // Property SectionRef
    // PropertyWrapper{name='SectionRef', typeName='SectionRef', docu='null', type=SectionRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SectionRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SectionRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SectionRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SectionRef> SectionRef = new javafx.beans.property.SimpleObjectProperty<SectionRef>();

    @XmlElement(name = "SectionRef", required = true)
    public SectionRef getSectionRef() {
        return this.SectionRef.get();
    }
    public void setSectionRef( SectionRef value) {
        this.SectionRef.set( value);
    }




    // Property Inclination
    // PropertyWrapper{name='Inclination', typeName='Inclination', docu='null', type=Inclination, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Inclination', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Inclination_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Inclination' property serialised as  XML elemenmt.
    * 
    */

    private List<Inclination> inclinations = new ArrayList<>();

    public List<Inclination> getInclination() {
        return inclinations;
    }




    // Property EndCutEnd1
    // PropertyWrapper{name='EndCutEnd1', typeName='EndCutEnd1', docu='null', type=EndCutEnd1, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='EndCutEnd1', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EndCut_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'EndCutEnd1' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<EndCutEnd1> EndCutEnd1 = new javafx.beans.property.SimpleObjectProperty<EndCutEnd1>();

    @XmlElement(name = "EndCutEnd1", required = false)
    public EndCutEnd1 getEndCutEnd1() {
        return this.EndCutEnd1.get();
    }
    public void setEndCutEnd1( EndCutEnd1 value) {
        this.EndCutEnd1.set( value);
    }




    // Property EndCutEnd2
    // PropertyWrapper{name='EndCutEnd2', typeName='EndCutEnd2', docu='null', type=EndCutEnd2, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='EndCutEnd2', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EndCut_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'EndCutEnd2' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<EndCutEnd2> EndCutEnd2 = new javafx.beans.property.SimpleObjectProperty<EndCutEnd2>();

    @XmlElement(name = "EndCutEnd2", required = false)
    public EndCutEnd2 getEndCutEnd2() {
        return this.EndCutEnd2.get();
    }
    public void setEndCutEnd2( EndCutEnd2 value) {
        this.EndCutEnd2.set( value);
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




    // Property ConnectionConfiguration
    // PropertyWrapper{name='ConnectionConfiguration', typeName='ConnectionConfiguration', docu='null', type=ConnectionConfiguration, minOccurs=0, maxOccurs=2}
    // TypeWrapper{name='ConnectionConfiguration', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ConnectionConfiguration_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ConnectionConfiguration' property serialised as  XML elemenmt.
    * 
    */

    private List<ConnectionConfiguration> connectionConfigurations = new ArrayList<>();

    public List<ConnectionConfiguration> getConnectionConfiguration() {
        return connectionConfigurations;
    }




    // Property Penetration
    // PropertyWrapper{name='Penetration', typeName='Penetration', docu='null', type=Penetration, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='Penetration', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Penetration_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Penetration' property serialised as  XML elemenmt.
    * 
    */

    private List<Penetration> penetrations = new ArrayList<>();

    public List<Penetration> getPenetration() {
        return penetrations;
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




      public StiffenerT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
