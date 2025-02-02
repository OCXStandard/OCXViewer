
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>OccurrenceGroup_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition
 *  

*/
// OccurrenceGroup_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "OccurrenceGroup_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class OccurrenceGroupT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='id', typeName='xs:ID', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:ID => TypeWrapper{name='ID', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:ID!!!
    /* The 'id' value serialised as  XML attribute.
    * <summary>
    * An identifier for an element unique within the scope of the XML file. Each id must be unique within a document. The attribute uses the standard XML 1.0 ID type as defined in the XML Schema specification. This attribute is required in many OCX XML elements and an application should generate them automatically.</summary>
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
    * The name of the node.</summary>
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

    // AttributeWrapper{name='type', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'type' value serialised as  XML attribute.
    * <summary>
    * The occurrence group design/product view type</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Type = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "type", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getType() {
        return this.Type.get();
    };

    public void setType( String value) {
        this.Type.set( value);

    }
    // end type
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Occurrence
    // PropertyWrapper{name='Occurrence', typeName='Occurrence', docu='null', type=Occurrence, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Occurrence', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Occurrence_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Occurrence' property serialised as  XML elemenmt.
    * 
    */

    private List<Occurrence> occurrences = new ArrayList<>();

    public List<Occurrence> getOccurrence() {
        return occurrences;
    }




    // Property OccurrenceGroup
    // PropertyWrapper{name='OccurrenceGroup', typeName='OccurrenceGroup', docu='null', type=OccurrenceGroup, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='OccurrenceGroup', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='OccurrenceGroup_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OccurrenceGroup' property serialised as  XML elemenmt.
    * 
    */

    private List<OccurrenceGroup> occurrenceGroups = new ArrayList<>();

    public List<OccurrenceGroup> getOccurrenceGroup() {
        return occurrenceGroups;
    }




    // end the properties serialised to elements




      public OccurrenceGroupT() {
          try {



         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
