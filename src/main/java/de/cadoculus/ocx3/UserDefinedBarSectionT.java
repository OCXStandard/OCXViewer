
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UserDefinedBarSection_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// UserDefinedBarSection_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UserDefinedBarSection_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class UserDefinedBarSectionT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='numberOfParameters', typeName='xs:int', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:int => TypeWrapper{name='int', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use int
    // Java Type , int Type Adapter !!!typeAdapter unmapped type xs:int!!!
    /* The 'numberOfParameters' value serialised as  XML attribute.
    * <summary>
    * Number of additional user-defined properties included in the definition.</summary>
    */
    // contains the String serialised form of xs:int as int ( default namespace)
    @XmlTransient
    public IntegerProperty NumberOfParameters = new SimpleIntegerProperty();

    @XmlAttribute(name = "numberOfParameters", required = false)
    @XmlSchemaType(name = "xs:int")
    public int getNumberOfParameters() {
        return this.NumberOfParameters.get();
    };

    public void setNumberOfParameters( int value) {
        this.NumberOfParameters.set( value);

    }
    // end numberOfParameters
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property SectionProperties
    // PropertyWrapper{name='SectionProperties', typeName='SectionProperties', docu='null', type=SectionProperties, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SectionProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SectionProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SectionProperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SectionProperties> SectionProperties = new javafx.beans.property.SimpleObjectProperty<SectionProperties>();

    @XmlElement(name = "SectionProperties", required = true)
    public SectionProperties getSectionProperties() {
        return this.SectionProperties.get();
    }
    public void setSectionProperties( SectionProperties value) {
        this.SectionProperties.set( value);
    }




    // end the properties serialised to elements




      public UserDefinedBarSectionT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
