
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CrossFlow</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Concept to specify cross flow between Cells making up a Compartment. This enables the modelling of cells that are not adjacent but are connected by a piping system and part of the same Compartment.
 *  

*/
// CrossFlow https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// IdBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CrossFlow", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class CrossFlow extends IdBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property CellConnection
    // PropertyWrapper{name='CellConnection', typeName='CellConnection', docu='null', type=CellConnection, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='CellConnection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='CellConnection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'CellConnection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<CellConnection> CellConnection = new javafx.beans.property.SimpleObjectProperty<CellConnection>();

    @XmlElement(name = "CellConnection", required = true)
    public CellConnection getCellConnection() {
        return this.CellConnection.get();
    }
    public void setCellConnection( CellConnection value) {
        this.CellConnection.set( value);
    }




    // end the properties serialised to elements




      public CrossFlow() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
