
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import de.cadoculus.ocx3.impl.LocalDateTimeAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Header_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition for the Header information for an XML instance.
 *  

*/
// Header_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Header_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class HeaderT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='time_stamp', typeName='xs:dateTime', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:dateTime => TypeWrapper{name='dateTime', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use java.time.temporal.Temporal
    // Java Type , java.time.temporal.Temporal Type Adapter LocalDateTimeAdapter
    /* The 'time_stamp' value serialised as  XML attribute.
    * <summary>
    * Time stamp of the instance.</summary>
    */
    // contains the String serialised form of xs:dateTime as java.time.temporal.Temporal ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<java.time.temporal.Temporal> TimeStamp = new javafx.beans.property.SimpleObjectProperty<java.time.temporal.Temporal>();

    @XmlAttribute(name = "time_stamp", required = true)
    @XmlSchemaType(name = "xs:dateTime")
    @XmlJavaTypeAdapter( LocalDateTimeAdapter.class)
    public java.time.temporal.Temporal getTimeStamp() {
        return this.TimeStamp.get();
    };

    public void setTimeStamp( java.time.temporal.Temporal value) {
        this.TimeStamp.set( value);

    }
    // end time_stamp

    // AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'name' value serialised as  XML attribute.
    * <summary>
    * Name of the XML instance.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Name = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getName() {
        return this.Name.get();
    };

    public void setName( String value) {
        this.Name.set( value);

    }
    // end name

    // AttributeWrapper{name='author', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'author' value serialised as  XML attribute.
    * <summary>
    * Name of author.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Author = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "author", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getAuthor() {
        return this.Author.get();
    };

    public void setAuthor( String value) {
        this.Author.set( value);

    }
    // end author

    // AttributeWrapper{name='originating_system', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'originating_system' value serialised as  XML attribute.
    * <summary>
    * Name of originating system or application.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> OriginatingSystem = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "originating_system", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getOriginatingSystem() {
        return this.OriginatingSystem.get();
    };

    public void setOriginatingSystem( String value) {
        this.OriginatingSystem.set( value);

    }
    // end originating_system

    // AttributeWrapper{name='organization', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'organization' value serialised as  XML attribute.
    * <summary>
    * Name of originating organization.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Organization = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "organization", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getOrganization() {
        return this.Organization.get();
    };

    public void setOrganization( String value) {
        this.Organization.set( value);

    }
    // end organization

    // AttributeWrapper{name='application_version', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'application_version' value serialised as  XML attribute.
    * <summary>
    * Version of originating application.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> ApplicationVersion = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "application_version", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getApplicationVersion() {
        return this.ApplicationVersion.get();
    };

    public void setApplicationVersion( String value) {
        this.ApplicationVersion.set( value);

    }
    // end application_version

    // AttributeWrapper{name='documentation', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'documentation' value serialised as  XML attribute.
    * <summary>
    * Documentation of the content of the XML file.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Documentation = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "documentation", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getDocumentation() {
        return this.Documentation.get();
    };

    public void setDocumentation( String value) {
        this.Documentation.set( value);

    }
    // end documentation
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public HeaderT() {
          try {







         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
