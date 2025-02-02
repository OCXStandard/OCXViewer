
package de.cadoculus.unitsml;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
*  The <code>UnitName</code> element
 * defined in namespace <code>urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18</code>.
* 
 * Element containing the unit name.
 *  

*/
// UnitName urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18
// NameType  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnitName", namespace = "urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18")
public  class UnitName extends NameType
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


      public UnitName() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
