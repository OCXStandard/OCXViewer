
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ExternalGeometryRef_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// ExternalGeometryRef_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type BaseClass

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ExternalGeometryRef_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ExternalGeometryRefT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='externalRef', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'externalRef' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> ExternalRef = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "externalRef", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getExternalRef() {
        return this.ExternalRef.get();
    };

    public void setExternalRef( String value) {
        this.ExternalRef.set( value);

    }
    // end externalRef

    // AttributeWrapper{name='geometryFormat', typeName='geometryFormat', targetNamespace='', required=true, defaultValue='null', fixedValue='.stp', referencedType='Object'}
    // 
    // geometryFormat => TypeWrapper{name='geometryFormat', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use GeometryFormatEnum
    // Java Type , GeometryFormatEnum Type Adapter !!!typeAdapter unmapped type geometryFormat!!!
    /* The 'geometryFormat' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of geometryFormat as GeometryFormatEnum ( default namespace)
        // ?? geometryFormat
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<GeometryFormatEnum> GeometryFormat = new  javafx.beans.property.SimpleObjectProperty<GeometryFormatEnum>();

    @XmlAttribute(name = "geometryFormat", required = true)
    @XmlSchemaType(name = "geometryFormat")
    public GeometryFormatEnum getGeometryFormat() {
        return this.GeometryFormat.get();
    };

    public void setGeometryFormat( GeometryFormatEnum value) {
        this.GeometryFormat.set( value);

    }
    // end geometryFormat
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ExternalGeometryRefT() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
