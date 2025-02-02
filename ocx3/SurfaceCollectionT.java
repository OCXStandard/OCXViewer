
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>SurfaceCollection_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// SurfaceCollection_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SurfaceCollection_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class SurfaceCollectionT extends DescriptionBaseT
{

    // the properties serialised to attributes

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
    // Property Surface
    // PropertyWrapper{name='Surface', typeName='Surface', docu='null', type=Surface, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Surface', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Surface' property serialised as  XML elemenmt.
    * 
    */

    private List<Surface> surfaces = new ArrayList<>();

    public List<Surface> getSurface() {
        return surfaces;
    }




    // end the properties serialised to elements




      public SurfaceCollectionT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
