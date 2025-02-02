
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import de.cadoculus.ocx3.impl.LocaleAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DocumentBase_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the abstract base class for the XML document defined in this schema.
 *  

*/
// DocumentBase_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DocumentBase_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class DocumentBaseT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='schemaVersion', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='3.0.0', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'schemaVersion' value serialised as  XML attribute.
    * <summary>
    * Current XML schema version (Format - x.y.z) x : Incremented for backward incompatible changes ( Ex - Adding a required attribute, etc.) y : Major backward compatible changes [ Ex - Adding a new node ,fixing major CRs,etc...] z : Minor backward compatible changes (Ex - adding an optional attribute, etc).</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> SchemaVersion = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "schemaVersion", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getSchemaVersion() {
        return this.SchemaVersion.get();
    };

    public void setSchemaVersion( String value) {
        this.SchemaVersion.set( value);

    }
    // end schemaVersion

    // AttributeWrapper{name='language', typeName='xs:language', targetNamespace='', required=false, defaultValue='en', fixedValue='null', referencedType='Object'}
    // 
    // xs:language => TypeWrapper{name='language', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use java.util.Locale
    // Java Type , java.util.Locale Type Adapter LocaleAdapter
    /* The 'language' value serialised as  XML attribute.
    * <summary>
    * Language used by the application.</summary>
    */
    // contains the String serialised form of xs:language as java.util.Locale ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<java.util.Locale> Language = new javafx.beans.property.SimpleObjectProperty<java.util.Locale>();

    @XmlAttribute(name = "language", required = false)
    @XmlSchemaType(name = "xs:language")
    @XmlJavaTypeAdapter( LocaleAdapter.class)
    public java.util.Locale getLanguage() {
        return this.Language.get();
    };

    public void setLanguage( java.util.Locale value) {
        this.Language.set( value);

    }
    // end language
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Header
    // PropertyWrapper{name='Header', typeName='Header', docu='null', type=Header, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Header', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Header_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Header' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Header> Header = new javafx.beans.property.SimpleObjectProperty<Header>();

    @XmlElement(name = "Header", required = true)
    public Header getHeader() {
        return this.Header.get();
    }
    public void setHeader( Header value) {
        this.Header.set( value);
    }




    // end the properties serialised to elements




      public DocumentBaseT() {
          try {

          // attr language with default value 'en', type java.util.Locale
           Language.set( new Locale("en"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
