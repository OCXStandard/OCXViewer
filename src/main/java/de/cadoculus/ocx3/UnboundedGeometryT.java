
package de.cadoculus.ocx3;

import de.cadoculus.ocx3.impl.BaseClass;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>UnboundedGeometry_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of an unbounded surface geometry of the parent element.
 *  

*/
// UnboundedGeometry_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
//   
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "UnboundedGeometry_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class UnboundedGeometryT extends BaseClass
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Surface
    // PropertyWrapper{name='Surface', typeName='Surface', docu='null', type=Surface, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Surface', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Surface_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Surface' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Surface> Surface = new javafx.beans.property.SimpleObjectProperty<Surface>();

    @XmlElement(name = "Surface", required = true)
    public Surface getSurface() {
        return this.Surface.get();
    }
    public void setSurface( Surface value) {
        this.Surface.set( value);
    }




    // Property GridRef
    // PropertyWrapper{name='GridRef', typeName='GridRef', docu='null', type=GridRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='GridRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='GridRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'GridRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<GridRef> GridRef = new javafx.beans.property.SimpleObjectProperty<GridRef>();

    @XmlElement(name = "GridRef", required = true)
    public GridRef getGridRef() {
        return this.GridRef.get();
    }
    public void setGridRef( GridRef value) {
        this.GridRef.set( value);
    }




    // Property SurfaceRef
    // PropertyWrapper{name='SurfaceRef', typeName='SurfaceRef', docu='null', type=SurfaceRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SurfaceRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SurfaceRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SurfaceRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SurfaceRef> SurfaceRef = new javafx.beans.property.SimpleObjectProperty<SurfaceRef>();

    @XmlElement(name = "SurfaceRef", required = true)
    public SurfaceRef getSurfaceRef() {
        return this.SurfaceRef.get();
    }
    public void setSurfaceRef( SurfaceRef value) {
        this.SurfaceRef.set( value);
    }




    // end the properties serialised to elements




      public UnboundedGeometryT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
