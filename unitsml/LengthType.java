
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.*;

/**
*  The <code>LengthType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type of the quantity length.
 *  

*/
// LengthType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "LengthType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class LengthType extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='powerNumerator', typeName='xsd:byte', targetNamespace='', required=false, defaultValue='1', fixedValue='null', referencedType='Object'}
    // 
    // xsd:byte => TypeWrapper{name='byte', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use int
    // Java Type , int Type Adapter !!!typeAdapter unmapped type xsd:byte!!!
    /* The 'powerNumerator' value serialised as  XML attribute.
    * <summary>
    * An integer exponent of the unit.</summary>
    */
    // contains the String serialised form of xsd:byte as int ( default namespace)
    @XmlTransient
    public IntegerProperty PowerNumerator = new SimpleIntegerProperty();

    @XmlAttribute(name = "powerNumerator", required = false)
    @XmlSchemaType(name = "xsd:byte")
    public int getPowerNumerator() {
        return this.PowerNumerator.get();
    };

    public void setPowerNumerator( int value) {
        this.PowerNumerator.set( value);

    }
    // end powerNumerator

    // AttributeWrapper{name='symbol', typeName='xsd:token', targetNamespace='', required=false, defaultValue='null', fixedValue='L', referencedType='Object'}
    // 
    // xsd:token => TypeWrapper{name='token', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xsd:token!!!
    /* The 'symbol' value serialised as  XML attribute.
    * <summary>
    * Symbol of the quantity length.</summary>
    */
    // contains the String serialised form of xsd:token as String ( default namespace)
        // ?? xsd:token
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Symbol = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "symbol", required = false)
    @XmlSchemaType(name = "xsd:token")
    public String getSymbol() {
        return this.Symbol.get();
    };

    public void setSymbol( String value) {
        this.Symbol.set( value);

    }
    // end symbol
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public LengthType() {
          try {
          // attr powerNumerator with default value '1', type int
           PowerNumerator.set( Integer.parseInt("1"));
 

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
