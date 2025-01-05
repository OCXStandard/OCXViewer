
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BulkCargo_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of dry cargo properties, reference is made to ISO 10303-215:2004.
 *  

*/
// BulkCargo_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BulkCargo_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BulkCargoT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='bulkCargoType', typeName='bulkCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // bulkCargoType => TypeWrapper{name='bulkCargoType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use BulkCargoTypeEnum
    // Java Type , BulkCargoTypeEnum Type Adapter !!!typeAdapter unmapped type bulkCargoType!!!
    /* The 'bulkCargoType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of bulkCargoType as BulkCargoTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? bulkCargoType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<BulkCargoTypeEnum> BulkCargoType = new  javafx.beans.property.SimpleObjectProperty<BulkCargoTypeEnum>();

    @XmlAttribute(name = "bulkCargoType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "bulkCargoType")
    public BulkCargoTypeEnum getBulkCargoType() {
        return this.BulkCargoType.get();
    };

    public void setBulkCargoType( BulkCargoTypeEnum value) {
        this.BulkCargoType.set( value);

    }
    // end bulkCargoType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property StowageFactor
    // PropertyWrapper{name='StowageFactor', typeName='StowageFactor', docu='null', type=StowageFactor, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='StowageFactor', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'StowageFactor' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<StowageFactor> StowageFactor = new javafx.beans.property.SimpleObjectProperty<StowageFactor>();

    @XmlElement(name = "StowageFactor", required = false)
    public StowageFactor getStowageFactor() {
        return this.StowageFactor.get();
    }
    public void setStowageFactor( StowageFactor value) {
        this.StowageFactor.set( value);
    }




    // Property Permeability
    // PropertyWrapper{name='Permeability', typeName='Permeability', docu='null', type=Permeability, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='Permeability', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Permeability' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Permeability> Permeability = new javafx.beans.property.SimpleObjectProperty<Permeability>();

    @XmlElement(name = "Permeability", required = false)
    public Permeability getPermeability() {
        return this.Permeability.get();
    }
    public void setPermeability( Permeability value) {
        this.Permeability.set( value);
    }




    // Property AngleOfRepose
    // PropertyWrapper{name='AngleOfRepose', typeName='AngleOfRepose', docu='null', type=AngleOfRepose, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='AngleOfRepose', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'AngleOfRepose' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<AngleOfRepose> AngleOfRepose = new javafx.beans.property.SimpleObjectProperty<AngleOfRepose>();

    @XmlElement(name = "AngleOfRepose", required = false)
    public AngleOfRepose getAngleOfRepose() {
        return this.AngleOfRepose.get();
    }
    public void setAngleOfRepose( AngleOfRepose value) {
        this.AngleOfRepose.set( value);
    }




    // end the properties serialised to elements




      public BulkCargoT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
