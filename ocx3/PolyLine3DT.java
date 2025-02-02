
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>PolyLine3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a 3D curve defined by a list of 3D points composing a list of linear segments.
 *  

*/
// PolyLine3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "PolyLine3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class PolyLine3DT extends Curve3DT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='isClosed', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'isClosed' value serialised as  XML attribute.
    * <summary>
    * If set to true, the PolyLine3D forms a closed contour. The default is false.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty IsClosed = new SimpleBooleanProperty();

    @XmlAttribute(name = "isClosed", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getIsClosed() {
        return this.IsClosed.get();
    };

    public void setIsClosed( boolean value) {
        this.IsClosed.set( value);

    }
    // end isClosed
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Point3D
    // PropertyWrapper{name='Point3D', typeName='Point3D', docu='null', type=Point3D, minOccurs=2, maxOccurs=100}
    // TypeWrapper{name='Point3D', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Point3D' property serialised as  XML elemenmt.
    * 
    */

    private List<Point3D> point3Ds = new ArrayList<>();

    public List<Point3D> getPoint3D() {
        return point3Ds;
    }




    // end the properties serialised to elements




      public PolyLine3DT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
