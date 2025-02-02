
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>Line3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of a straight line defined by two points.
 *  

*/
// Line3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "Line3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class Line3DT extends Curve3DT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property StartPoint
    // PropertyWrapper{name='StartPoint', typeName='StartPoint', docu='null', type=StartPoint, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='StartPoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'StartPoint' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<StartPoint> StartPoint = new javafx.beans.property.SimpleObjectProperty<StartPoint>();

    @XmlElement(name = "StartPoint", required = true)
    public StartPoint getStartPoint() {
        return this.StartPoint.get();
    }
    public void setStartPoint( StartPoint value) {
        this.StartPoint.set( value);
    }




    // Property EndPoint
    // PropertyWrapper{name='EndPoint', typeName='EndPoint', docu='null', type=EndPoint, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='EndPoint', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Point3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'EndPoint' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<EndPoint> EndPoint = new javafx.beans.property.SimpleObjectProperty<EndPoint>();

    @XmlElement(name = "EndPoint", required = true)
    public EndPoint getEndPoint() {
        return this.EndPoint.get();
    }
    public void setEndPoint( EndPoint value) {
        this.EndPoint.set( value);
    }




    // end the properties serialised to elements




      public Line3DT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
