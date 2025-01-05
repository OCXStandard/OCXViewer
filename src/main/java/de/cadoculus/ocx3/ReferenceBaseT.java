
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ReferenceBase_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// ReferenceBase_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ReferenceBase_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ReferenceBaseT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='localRef', typeName='xs:IDREF', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:IDREF => TypeWrapper{name='IDREF', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:IDREF!!!
    /* The 'localRef' value serialised as  XML attribute.
    * <summary>
    * A reference to a unique ID within the scope of this XML file. Either a localRef or a GUIDRef shall be provided, or both. The schema will check this by the assertion: test="(@localRef and not(@ocx:GUIDRef)) or (not(@localRef) and @ocx:GUIDRef) or (@localRef and @ocx:GUIDRef)".</summary>
    */
    // contains the String serialised form of xs:IDREF as String ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> LocalRef = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "localRef", required = false)
    @XmlSchemaType(name = "xs:IDREF")
    public String getLocalRef() {
        return this.LocalRef.get();
    };

    public void setLocalRef( String value) {
        this.LocalRef.set( value);

    }
    // end localRef

    // AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // ocx:guid => TypeWrapper{name='guid', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type ocx:guid!!!
    /* The 'GUIDRef' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of ocx:guid as String (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? ocx:guid
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> GUIDRef = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "GUIDRef", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "ocx:guid")
    public String getGUIDRef() {
        return this.GUIDRef.get();
    };

    public void setGUIDRef( String value) {
        this.GUIDRef.set( value);

    }
    // end GUIDRef
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ReferenceBaseT() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
