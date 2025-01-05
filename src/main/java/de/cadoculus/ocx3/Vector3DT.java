
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import de.cadoculus.ocx3.impl.DoubleListAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import javafx.collections.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Vector3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a unit vector.
 *  

*/
// Vector3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Vector3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Vector3DT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='direction', typeName='ocx:doubleListType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // ocx:doubleListType => TypeWrapper{name='doubleListType', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use List<Double>
    // Java Type , List<Double> Type Adapter DoubleListAdapter
    /* The 'direction' value serialised as  XML attribute.
    * <summary>
    * The unit vector components.</summary>
    */
    // contains the String serialised form of ocx:doubleListType as List<Double> (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlTransient
    public ObservableList<Double> Direction = FXCollections.observableArrayList();

    @XmlAttribute(name = "direction", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "ocx:doubleListType")
    @XmlJavaTypeAdapter( DoubleListAdapter.class)
    public List<Double> getDirection() {
        return this.Direction;
    };

    public void setDirection( List<Double> value) {
        this.Direction.clear();
        this.Direction.addAll( value );

    }
    // end direction
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Vector3DT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
