
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>EdgeReinforcement_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// EdgeReinforcement_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// StructurePart_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "EdgeReinforcement_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class EdgeReinforcementT extends StructurePartT
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




    // Property EdgeCurveRef
    // PropertyWrapper{name='EdgeCurveRef', typeName='EdgeCurveRef', docu='null', type=EdgeCurveRef, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='EdgeCurveRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='EdgeCurveRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'EdgeCurveRef' property serialised as  XML elemenmt.
    * 
    */

    private List<EdgeCurveRef> edgeCurveRefs = new ArrayList<>();

    public List<EdgeCurveRef> getEdgeCurveRef() {
        return edgeCurveRefs;
    }




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




    // end the properties serialised to elements




      public EdgeReinforcementT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
