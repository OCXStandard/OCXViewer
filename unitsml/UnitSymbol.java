
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
*  The <code>UnitSymbol</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element containing various unit symbols.  Examples include Aring (ASCII), Å (HTML).
 *  

*/
// UnitSymbol urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// SymbolType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitSymbol", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class UnitSymbol extends SymbolType
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements



    @XmlTransient
    public StringProperty Name = new SimpleStringProperty();


    @XmlElement
    public String getName() {
        return this.Name.get();
    };

    public void setName( String value) {
        this.Name.set( value);
    }


    @XmlTransient
    public StringProperty Lang = new SimpleStringProperty();
    @XmlAttribute(name="lang", namespace = "http://www.w3.org/XML/1998/namespace")
    public String getLang() {
        return this.Lang.get();
    };

    public void setLang( String value) {
        this.Lang.set( value);
    }



      public UnitSymbol() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
