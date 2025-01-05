
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ClassNotation_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of ClassNotation.
 *  

*/
// ClassNotation_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ClassNotation_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ClassNotationT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='hull', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'hull' value serialised as  XML attribute.
    * <summary>
    * The notation given to the hull of the ship by the classification society as a result
    * 					of its approval activities done on the hull.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Hull = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "hull", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getHull() {
        return this.Hull.get();
    };

    public void setHull( String value) {
        this.Hull.set( value);

    }
    // end hull

    // AttributeWrapper{name='machinery', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'machinery' value serialised as  XML attribute.
    * <summary>
    * The notation given to the machinery on the ship by the classification society as a
    * 					result of its approval activities done on the machinery.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Machinery = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "machinery", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getMachinery() {
        return this.Machinery.get();
    };

    public void setMachinery( String value) {
        this.Machinery.set( value);

    }
    // end machinery

    // AttributeWrapper{name='iceClass', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'iceClass' value serialised as  XML attribute.
    * <summary>
    * The type of class notation given to the ship indicating the ice conditions in which
    * 					the ship has been approved to operate.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> IceClass = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "iceClass", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getIceClass() {
        return this.IceClass.get();
    };

    public void setIceClass( String value) {
        this.IceClass.set( value);

    }
    // end iceClass

    // AttributeWrapper{name='serviceArea', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'serviceArea' value serialised as  XML attribute.
    * <summary>
    * The area or route in which the ship operates. NOTE: This may include information about
    * 					waterway, wave, weather and wind conditions. .</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> ServiceArea = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "serviceArea", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getServiceArea() {
        return this.ServiceArea.get();
    };

    public void setServiceArea( String value) {
        this.ServiceArea.set( value);

    }
    // end serviceArea

    // AttributeWrapper{name='serviceFactor', typeName='xs:double', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'serviceFactor' value serialised as  XML attribute.
    * <summary>
    * The service area of the ship and the waves that occur in that area. The service factor
    * 					should be in the range of 0.5 to 1.0.</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty ServiceFactor = new SimpleDoubleProperty();

    @XmlAttribute(name = "serviceFactor", required = false)
    @XmlSchemaType(name = "xs:double")
    public double getServiceFactor() {
        return this.ServiceFactor.get();
    };

    public void setServiceFactor( double value) {
        this.ServiceFactor.set( value);

    }
    // end serviceFactor

    // AttributeWrapper{name='additionalNotations', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'additionalNotations' value serialised as  XML attribute.
    * <summary>
    * Additional notations assigned by the society.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> AdditionalNotations = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "additionalNotations", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getAdditionalNotations() {
        return this.AdditionalNotations.get();
    };

    public void setAdditionalNotations( String value) {
        this.AdditionalNotations.set( value);

    }
    // end additionalNotations
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ClassNotationT() {
          try {






         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
