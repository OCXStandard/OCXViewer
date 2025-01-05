
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ShipDesignation_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The different types of identification given to the ship in order that it can be
 * 				categorised by any shipping related organisation. It contains the minimal information which might
 * 				be available about the ship.
 *  

*/
// ShipDesignation_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ShipDesignation_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ShipDesignationT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='shipName', typeName='xs:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'shipName' value serialised as  XML attribute.
    * <summary>
    * The name of the ship assigned by the owner.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> ShipName = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "shipName", required = true)
    @XmlSchemaType(name = "xs:string")
    public String getShipName() {
        return this.ShipName.get();
    };

    public void setShipName( String value) {
        this.ShipName.set( value);

    }
    // end shipName

    // AttributeWrapper{name='callSign', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'callSign' value serialised as  XML attribute.
    * <summary>
    * The unique life-cycle identifier assigned to the ship by the flag state for radio
    * 					communication.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> CallSign = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "callSign", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getCallSign() {
        return this.CallSign.get();
    };

    public void setCallSign( String value) {
        this.CallSign.set( value);

    }
    // end callSign

    // AttributeWrapper{name='numberIMO', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'numberIMO' value serialised as  XML attribute.
    * <summary>
    * A unique identification of a vessel according to IMO resolution A.600(15). It is made of the three letters "IMO" front of the Lloydâ€™s Register number. This is a unique seven-digit number that is assigned to propelled, sea-going merchant ships of 100 GT and above upon keel laying (with some exceptions), see: IACS Procedural Requirements No. 11, IACS Procedure for Assigning Date of Build, 1996. https://www.imo.org/en/OurWork/IIIS/Pages/IMO-Identification-Number-Schemes.aspx: Information on IMO ship identification number scheme on the website of the IMO.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> NumberIMO = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "numberIMO", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getNumberIMO() {
        return this.NumberIMO.get();
    };

    public void setNumberIMO( String value) {
        this.NumberIMO.set( value);

    }
    // end numberIMO

    // AttributeWrapper{name='shipType', typeName='xs:string', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:string!!!
    /* The 'shipType' value serialised as  XML attribute.
    * <summary>
    * Optional string indicating the ship type.</summary>
    */
    // contains the String serialised form of xs:string as String ( default namespace)
        // ?? xs:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> ShipType = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "shipType", required = false)
    @XmlSchemaType(name = "xs:string")
    public String getShipType() {
        return this.ShipType.get();
    };

    public void setShipType( String value) {
        this.ShipType.set( value);

    }
    // end shipType
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ShipDesignationT() {
          try {




         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
