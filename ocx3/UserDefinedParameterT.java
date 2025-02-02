
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UserDefinedParameter_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  
 * This class is derived from Quantity_T, uses default unit u_dimbulb
*/
// UserDefinedParameter_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Quantity_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UserDefinedParameter_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class UserDefinedParameterT extends QuantityT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Description
    // PropertyWrapper{name='Description', typeName='xs:string', docu='null', type=string, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='string', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //  https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type true
    /* The 'Description' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> Description = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlElement(name = "Description", required = true)
    public String getDescription() {
        return this.Description.get();
    }
    public void setDescription( String value) {
        this.Description.set( value);
    }




    // end the properties serialised to elements



      /**
      * Create a new UserDefinedParameterT using the default unit '"u_dimbulb'
      */
      public UserDefinedParameterT()  {
          super(Double.NaN, "u_dimbulb");
      }

      /**
      * Create a new UserDefinedParameterT using the given value and default unit '"u_dimbulb'
      */
      public UserDefinedParameterT(double value) {
         super(value, "u_dimbulb");
      }

      /**
      * Create a new UserDefinedParameterT using the given value and unit
      */
      public UserDefinedParameterT(double value, de.cadoculus.unitsml.Unit unit)
      {
          super(value, unit);
      }


}
