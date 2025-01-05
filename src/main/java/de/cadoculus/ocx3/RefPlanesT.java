
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>RefPlanes_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Frame table position definition.
 *  

*/
// RefPlanes_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// ReferencePlane_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "RefPlanes_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class RefPlanesT extends ReferencePlaneT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='isMainSystem', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='true', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'isMainSystem' value serialised as  XML attribute.
    * <summary>
    * True if this is the main reference system definition.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty IsMainSystem = new SimpleBooleanProperty();

    @XmlAttribute(name = "isMainSystem", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getIsMainSystem() {
        return this.IsMainSystem.get();
    };

    public void setIsMainSystem( boolean value) {
        this.IsMainSystem.set( value);

    }
    // end isMainSystem
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property RefPlane
    // PropertyWrapper{name='RefPlane', typeName='RefPlane', docu='null', type=RefPlane, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='RefPlane', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RefPlane_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'RefPlane' property serialised as  XML elemenmt.
    * 
    */

    private List<RefPlane> refPlanes = new ArrayList<>();

    public List<RefPlane> getRefPlane() {
        return refPlanes;
    }




    // end the properties serialised to elements




      public RefPlanesT() {
          try {
          // attr isMainSystem with default value 'true', type boolean
           IsMainSystem.set( Boolean.parseBoolean("true"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
