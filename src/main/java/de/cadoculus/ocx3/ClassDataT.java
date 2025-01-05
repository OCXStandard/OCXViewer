
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ClassData_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the main vessel data including Class Notation required by the
 * 				Classification Society.
 *  

*/
// ClassData_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ClassData_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ClassDataT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='identification', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'identification' value serialised as  XML attribute.
    * <summary>
    * The classification society specific identifier to a ship, typically the design ID.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Identification = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "identification", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getIdentification() {
        return this.Identification.get();
    };

    public void setIdentification( String value) {
        this.Identification.set( value);

    }
    // end identification

    // AttributeWrapper{name='newbuildingSocietyName', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'newbuildingSocietyName' value serialised as  XML attribute.
    * <summary>
    * The common name of the class society relevant for operating the ship. Needs only to be specified when @newbuildingSociety = OTHER				.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> NewbuildingSocietyName = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "newbuildingSocietyName", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getNewbuildingSocietyName() {
        return this.NewbuildingSocietyName.get();
    };

    public void setNewbuildingSocietyName( String value) {
        this.NewbuildingSocietyName.set( value);

    }
    // end newbuildingSocietyName

    // AttributeWrapper{name='societyName', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'societyName' value serialised as  XML attribute.
    * <summary>
    * The common name of the class society relevant for operating the ship. Needs only to be specified when @society = OTHER				.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> SocietyName = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "societyName", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getSocietyName() {
        return this.SocietyName.get();
    };

    public void setSocietyName( String value) {
        this.SocietyName.set( value);

    }
    // end societyName

    // AttributeWrapper{name='newbuildingSociety', typeName='classificationSociety', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // classificationSociety => TypeWrapper{name='classificationSociety', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use ClassificationSocietyEnum
    // Java Type , ClassificationSocietyEnum Type Adapter !!!typeAdapter unmapped type classificationSociety!!!
    /* The 'newbuildingSociety' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of classificationSociety as ClassificationSocietyEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? classificationSociety
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<ClassificationSocietyEnum> NewbuildingSociety = new  javafx.beans.property.SimpleObjectProperty<ClassificationSocietyEnum>();

    @XmlAttribute(name = "newbuildingSociety", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "classificationSociety")
    public ClassificationSocietyEnum getNewbuildingSociety() {
        return this.NewbuildingSociety.get();
    };

    public void setNewbuildingSociety( ClassificationSocietyEnum value) {
        this.NewbuildingSociety.set( value);

    }
    // end newbuildingSociety

    // AttributeWrapper{name='society', typeName='classificationSociety', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // classificationSociety => TypeWrapper{name='classificationSociety', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use ClassificationSocietyEnum
    // Java Type , ClassificationSocietyEnum Type Adapter !!!typeAdapter unmapped type classificationSociety!!!
    /* The 'society' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of classificationSociety as ClassificationSocietyEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? classificationSociety
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<ClassificationSocietyEnum> Society = new  javafx.beans.property.SimpleObjectProperty<ClassificationSocietyEnum>();

    @XmlAttribute(name = "society", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "classificationSociety")
    public ClassificationSocietyEnum getSociety() {
        return this.Society.get();
    };

    public void setSociety( ClassificationSocietyEnum value) {
        this.Society.set( value);

    }
    // end society
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property PrincipalParticulars
    // PropertyWrapper{name='PrincipalParticulars', typeName='PrincipalParticulars', docu='null', type=PrincipalParticulars, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='PrincipalParticulars', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='PrincipalParticulars_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'PrincipalParticulars' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<PrincipalParticulars> PrincipalParticulars = new javafx.beans.property.SimpleObjectProperty<PrincipalParticulars>();

    @XmlElement(name = "PrincipalParticulars", required = true)
    public PrincipalParticulars getPrincipalParticulars() {
        return this.PrincipalParticulars.get();
    }
    public void setPrincipalParticulars( PrincipalParticulars value) {
        this.PrincipalParticulars.set( value);
    }




    // Property ClassNotation
    // PropertyWrapper{name='ClassNotation', typeName='ClassNotation', docu='null', type=ClassNotation, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ClassNotation', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ClassNotation_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ClassNotation' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ClassNotation> ClassNotation = new javafx.beans.property.SimpleObjectProperty<ClassNotation>();

    @XmlElement(name = "ClassNotation", required = false)
    public ClassNotation getClassNotation() {
        return this.ClassNotation.get();
    }
    public void setClassNotation( ClassNotation value) {
        this.ClassNotation.set( value);
    }




    // end the properties serialised to elements




      public ClassDataT() {
          try {





         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
