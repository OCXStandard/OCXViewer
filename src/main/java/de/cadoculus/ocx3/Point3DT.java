
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import de.cadoculus.ocx3.impl.DoubleListAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import javafx.collections.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Point3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a compact definition of a point in 3D space composed of a list of 3 X,
 * 				Y and Z coordinate values all of same unit given by the unit ID.
 *  

*/
// Point3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Point3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Point3DT extends BaseClass
{

    // the properties serialised to attributes

    // AttributeWrapper{name='coordinates', typeName='ocx:doubleListType', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // ocx:doubleListType => TypeWrapper{name='doubleListType', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use List<Double>
    // Java Type , List<Double> Type Adapter DoubleListAdapter
    /* The 'coordinates' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of ocx:doubleListType as List<Double> (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlTransient
    public ObservableList<Double> Coordinates = FXCollections.observableArrayList();

    @XmlAttribute(name = "coordinates", required = true, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "ocx:doubleListType")
    @XmlJavaTypeAdapter( DoubleListAdapter.class)
    public List<Double> getCoordinates() {
        return this.Coordinates;
    };

    public void setCoordinates( List<Double> value) {
        this.Coordinates.clear();
        this.Coordinates.addAll( value );

    }
    // end coordinates

    // AttributeWrapper{name='unit', typeName='xs:IDREF', targetNamespace='', required=true, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:IDREF => TypeWrapper{name='IDREF', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type xs:IDREF!!!
    /* The 'unit' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of xs:IDREF as String ( default namespace)
    @XmlTransient
    public javafx.beans.property.ObjectProperty<String> UnitId = new javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "unit", required = true)
    @XmlSchemaType(name = "xs:IDREF")
    public String getUnitId() {
        return this.UnitId.get();
    };

    public void setUnitId( String value) {
        this.UnitId.set( value);

    }
    // end unit
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public Point3DT() {
          try {


         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
