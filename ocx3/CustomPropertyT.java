
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CustomProperty_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// CustomProperty_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CustomProperty_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CustomPropertyT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:ID => TypeWrapper{name='ID', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:ID!!!
    /* The 'id' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:ID as String ( default namespace)
        // ?? xs:ID
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Id = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "xs:ID")
    public String getId() {
        return this.Id.get();
    };

    public void setId( String value) {
        this.Id.set( value);

    }
    // end id

    // AttributeWrapper{name='name', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'name' value serialised as  XML attribute.
    * <summary>
    * Property  name.</summary>
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

    // AttributeWrapper{name='value', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'value' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Value = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "value", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getValue() {
        return this.Value.get();
    };

    public void setValue( String value) {
        this.Value.set( value);

    }
    // end value

    // AttributeWrapper{name='unit', typeName='xs:IDREF', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:IDREF => TypeWrapper{name='IDREF', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:IDREF!!!
    /* The 'unit' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:IDREF as String ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> UnitId = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "unit", required = false)
    @XmlSchemaType(name = "xs:IDREF")
    public String getUnitId() {
        return this.UnitId.get();
    };

    public void setUnitId( String value) {
        this.UnitId.set( value);

    }
    // end unit
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Description
    // PropertyWrapper{name='Description', typeName='string', docu='null', type=string, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //  https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type true
    /* The 'Description' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> Description = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlElement(name = "Description", required = false)
    public String getDescription() {
        return this.Description.get();
    }
    public void setDescription( String value) {
        this.Description.set( value);
    }




    // end the properties serialised to elements




      public CustomPropertyT() {
          try {




         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
