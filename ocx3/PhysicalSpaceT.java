
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PhysicalSpace_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the concept of a physical compartment representing a closed volume
 * 				(space) defined by enclosing structure panels.
 *  

*/
// PhysicalSpace_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PhysicalSpace_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PhysicalSpaceT extends EntityBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='compartmentPurpose', typeName='compartmentPurpose', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // compartmentPurpose => TypeWrapper{name='compartmentPurpose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use CompartmentPurposeEnum
    // Java Type , CompartmentPurposeEnum Type Adapter !!!typeAdapter unmapped type compartmentPurpose!!!
    /* The 'compartmentPurpose' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of compartmentPurpose as CompartmentPurposeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? compartmentPurpose
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<CompartmentPurposeEnum> CompartmentPurpose = new  javafx.beans.property.SimpleObjectProperty<CompartmentPurposeEnum>();

    @XmlAttribute(name = "compartmentPurpose", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "compartmentPurpose")
    public CompartmentPurposeEnum getCompartmentPurpose() {
        return this.CompartmentPurpose.get();
    };

    public void setCompartmentPurpose( CompartmentPurposeEnum value) {
        this.CompartmentPurpose.set( value);

    }
    // end compartmentPurpose
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CompartmentProperties
    // PropertyWrapper{name='CompartmentProperties', typeName='CompartmentProperties', docu='null', type=CompartmentProperties, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CompartmentProperties', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CompartmentProperties_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CompartmentProperties' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CompartmentProperties> CompartmentProperties = new javafx.beans.property.SimpleObjectProperty<CompartmentProperties>();

    @XmlElement(name = "CompartmentProperties", required = true)
    public CompartmentProperties getCompartmentProperties() {
        return this.CompartmentProperties.get();
    }
    public void setCompartmentProperties( CompartmentProperties value) {
        this.CompartmentProperties.set( value);
    }




    // Property Cell
    // PropertyWrapper{name='Cell', typeName='Cell', docu='null', type=Cell, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Cell', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Cell_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Cell' property serialised as  XML elemenmt.
    * 
    */

    private List<Cell> cells = new ArrayList<>();

    public List<Cell> getCell() {
        return cells;
    }




    // Property CrossFlow
    // PropertyWrapper{name='CrossFlow', typeName='CrossFlow', docu='null', type=CrossFlow, minOccurs=0, maxOccurs=100}
    // TypeWrapper{name='CrossFlow', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='IdBase_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[PropertyWrapper{name='CellConnection', typeName='CellConnection', docu='null', type=CellConnection, minOccurs=1, maxOccurs=1}]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CrossFlow' property serialised as  XML elemenmt.
    * 
    */

    private List<CrossFlow> crossFlows = new ArrayList<>();

    public List<CrossFlow> getCrossFlow() {
        return crossFlows;
    }




    // Property ExternalGeometryRef
    // PropertyWrapper{name='ExternalGeometryRef', typeName='ExternalGeometryRef', docu='null', type=ExternalGeometryRef, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='ExternalGeometryRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ExternalGeometryRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ExternalGeometryRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ExternalGeometryRef> ExternalGeometryRef = new javafx.beans.property.SimpleObjectProperty<ExternalGeometryRef>();

    @XmlElement(name = "ExternalGeometryRef", required = false)
    public ExternalGeometryRef getExternalGeometryRef() {
        return this.ExternalGeometryRef.get();
    }
    public void setExternalGeometryRef( ExternalGeometryRef value) {
        this.ExternalGeometryRef.set( value);
    }




    // end the properties serialised to elements




      public PhysicalSpaceT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
