
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import de.cadoculus.ocx3.impl.LocalDateAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BuilderInformation_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// BuilderInformation_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BuilderInformation_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BuilderInformationT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='yard', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'yard' value serialised as  XML attribute.
    * <summary>
    * Name of the construction yard.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Yard = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "yard", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getYard() {
        return this.Yard.get();
    };

    public void setYard( String value) {
        this.Yard.set( value);

    }
    // end yard

    // AttributeWrapper{name='designer', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'designer' value serialised as  XML attribute.
    * <summary>
    * The name of the designer of the vessel.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Designer = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "designer", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getDesigner() {
        return this.Designer.get();
    };

    public void setDesigner( String value) {
        this.Designer.set( value);

    }
    // end designer

    // AttributeWrapper{name='owner', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'owner' value serialised as  XML attribute.
    * <summary>
    * Contractor of the vessel.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Owner = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "owner", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getOwner() {
        return this.Owner.get();
    };

    public void setOwner( String value) {
        this.Owner.set( value);

    }
    // end owner

    // AttributeWrapper{name='yearOfBuild', typeName='xs:date', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:date => TypeWrapper{name='date', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use java.time.temporal.Temporal
    // Java Type , java.time.temporal.Temporal Type Adapter LocalDateAdapter
    /* The 'yearOfBuild' value serialised as  XML attribute.
    * <summary>
    * Keel laying date.</summary>
    */
    // contains the String serialised form of xs:date as java.time.temporal.Temporal ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<java.time.temporal.Temporal> YearOfBuild = new javafx.beans.property.SimpleObjectProperty<java.time.temporal.Temporal>();

    @XmlAttribute(name = "yearOfBuild", required = false)
    @XmlSchemaType(name = "xs:date")
    @XmlJavaTypeAdapter( LocalDateAdapter.class)
    public java.time.temporal.Temporal getYearOfBuild() {
        return this.YearOfBuild.get();
    };

    public void setYearOfBuild( java.time.temporal.Temporal value) {
        this.YearOfBuild.set( value);

    }
    // end yearOfBuild
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public BuilderInformationT() {
          try {




         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
