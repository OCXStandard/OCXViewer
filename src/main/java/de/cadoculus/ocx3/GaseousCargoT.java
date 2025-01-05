
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>GaseousCargo_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of Liquid cargo physical properties.
 *  

*/
// GaseousCargo_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "GaseousCargo_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class GaseousCargoT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='liquidState', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'liquidState' value serialised as  XML attribute.
    * <summary>
    * Set to True if the gaseous cargo is carried in a liquid state.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty LiquidState = new SimpleBooleanProperty();

    @XmlAttribute(name = "liquidState", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getLiquidState() {
        return this.LiquidState.get();
    };

    public void setLiquidState( boolean value) {
        this.LiquidState.set( value);

    }
    // end liquidState

    // AttributeWrapper{name='liquidCargoType', typeName='liquidCargoType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // liquidCargoType => TypeWrapper{name='liquidCargoType', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=true, baseTypeName='null', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    //     use LiquidCargoTypeEnum
    // Java Type , LiquidCargoTypeEnum Type Adapter !!!typeAdapter unmapped type liquidCargoType!!!
    /* The 'liquidCargoType' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of liquidCargoType as LiquidCargoTypeEnum (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? liquidCargoType
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<LiquidCargoTypeEnum> LiquidCargoType = new  javafx.beans.property.SimpleObjectProperty<LiquidCargoTypeEnum>();

    @XmlAttribute(name = "liquidCargoType", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "liquidCargoType")
    public LiquidCargoTypeEnum getLiquidCargoType() {
        return this.LiquidCargoType.get();
    };

    public void setLiquidCargoType( LiquidCargoTypeEnum value) {
        this.LiquidCargoType.set( value);

    }
    // end liquidCargoType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Density
    // PropertyWrapper{name='Density', typeName='Density', docu='null', type=Density, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Density', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Density' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Density> Density = new javafx.beans.property.SimpleObjectProperty<Density>();

    @XmlElement(name = "Density", required = true)
    public Density getDensity() {
        return this.Density.get();
    }
    public void setDensity( Density value) {
        this.Density.set( value);
    }




    // Property CarriagePressure
    // PropertyWrapper{name='CarriagePressure', typeName='CarriagePressure', docu='null', type=CarriagePressure, minOccurs=0, maxOccurs=1}
    // TypeWrapper{name='CarriagePressure', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Quantity_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CarriagePressure' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CarriagePressure> CarriagePressure = new javafx.beans.property.SimpleObjectProperty<CarriagePressure>();

    @XmlElement(name = "CarriagePressure", required = false)
    public CarriagePressure getCarriagePressure() {
        return this.CarriagePressure.get();
    }
    public void setCarriagePressure( CarriagePressure value) {
        this.CarriagePressure.set( value);
    }




    // end the properties serialised to elements




      public GaseousCargoT() {
          try {
          // attr liquidState with default value 'false', type boolean
           LiquidState.set( Boolean.parseBoolean("false"));
 

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
