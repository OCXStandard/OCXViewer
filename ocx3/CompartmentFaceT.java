
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>CompartmentFace_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the face of a compartment defined by a surface boundary.
 *  

*/
// CompartmentFace_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// EntityBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "CompartmentFace_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class CompartmentFaceT extends EntityBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property UnboundedGeometry
    // PropertyWrapper{name='UnboundedGeometry', typeName='UnboundedGeometry', docu='null', type=UnboundedGeometry, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UnboundedGeometry', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UnboundedGeometry_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UnboundedGeometry' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UnboundedGeometry> UnboundedGeometry = new javafx.beans.property.SimpleObjectProperty<UnboundedGeometry>();

    @XmlElement(name = "UnboundedGeometry", required = true)
    public UnboundedGeometry getUnboundedGeometry() {
        return this.UnboundedGeometry.get();
    }
    public void setUnboundedGeometry( UnboundedGeometry value) {
        this.UnboundedGeometry.set( value);
    }




    // Property FaceBoundaryCurve
    // PropertyWrapper{name='FaceBoundaryCurve', typeName='FaceBoundaryCurve', docu='null', type=FaceBoundaryCurve, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='FaceBoundaryCurve', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Contour3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FaceBoundaryCurve' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FaceBoundaryCurve> FaceBoundaryCurve = new javafx.beans.property.SimpleObjectProperty<FaceBoundaryCurve>();

    @XmlElement(name = "FaceBoundaryCurve", required = true)
    public FaceBoundaryCurve getFaceBoundaryCurve() {
        return this.FaceBoundaryCurve.get();
    }
    public void setFaceBoundaryCurve( FaceBoundaryCurve value) {
        this.FaceBoundaryCurve.set( value);
    }




    // end the properties serialised to elements




      public CompartmentFaceT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
