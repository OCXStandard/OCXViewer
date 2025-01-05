
package de.cadoculus.unitsml;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
*  The <code>SymbolType</code> complex type
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Type for symbols.  Used in units, quantities, and prefixes.
 *  

*/
// SymbolType urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "SymbolType", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public abstract class SymbolType extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='type', typeName='xsd:string', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xsd:string => TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xsd:string!!!
    /* The 'type' value serialised as  XML attribute.
    * <summary>
    * Type of symbol representation.  Examples include ASCII, unicode, HTML, and MathML.</summary>
    */
    // contains the String serialised form of xsd:string as String ( default namespace)
        // ?? xsd:string
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> Type = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "type", required = true)
    @XmlSchemaType(name = "xsd:string")
    public String getType() {
        return this.Type.get();
    };

    public void setType( String value) {
        this.Type.set( value);

    }
    // end type
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public SymbolType() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
