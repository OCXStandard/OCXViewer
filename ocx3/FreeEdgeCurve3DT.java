
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>FreeEdgeCurve3D_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The type definition of a free edge defined by a collection of non-closed Curve3D types.
 *  

*/
// FreeEdgeCurve3D_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Curve3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "FreeEdgeCurve3D_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class FreeEdgeCurve3DT extends Curve3DT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='isUVSpace', typeName='xs:boolean', targetNamespace='', required=false, defaultValue='false', fixedValue='null', referencedType='Object'}
    // 
    // xs:boolean => TypeWrapper{name='boolean', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use boolean
    // Java Type , boolean Type Adapter !!!typeAdapter unmapped type xs:boolean!!!
    /* The 'isUVSpace' value serialised as  XML attribute.
    * <summary>
    * Default is "false". Set this attribute to true if the FreeEdgeCurve is
    * 							represented by coordinates in the UV space. This should only be used when a FreeEdgeCurve is
    * 							used to trim NURBS surface patches where the trim curve is only used to trim the underlying
    * 							surface. When the curve is given in UV space, the X,Y point coordinates are replaced with
    * 							the U,V coordinates. In this case the Z coordinate should be set to zero. The Z coordinate
    * 							will not be used by the importing application.</summary>
    */
    // contains the String serialised form of xs:boolean as boolean ( default namespace)
    @XmlTransient
    public BooleanProperty IsUVSpace = new SimpleBooleanProperty();

    @XmlAttribute(name = "isUVSpace", required = false)
    @XmlSchemaType(name = "xs:boolean")
    public boolean getIsUVSpace() {
        return this.IsUVSpace.get();
    };

    public void setIsUVSpace( boolean value) {
        this.IsUVSpace.set( value);

    }
    // end isUVSpace
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property Curve3D
    // PropertyWrapper{name='Curve3D', typeName='Curve3D', docu='null', type=Curve3D, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Curve3D', isAbstract=true, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Curve3D_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Curve3D' property serialised as  XML elemenmt.
    * 
    */

    private List<Curve3D> curve3Ds = new ArrayList<>();

    public List<Curve3D> getCurve3D() {
        return curve3Ds;
    }




    // end the properties serialised to elements




      public FreeEdgeCurve3DT() {
          try {
          // attr isUVSpace with default value 'false', type boolean
           IsUVSpace.set( Boolean.parseBoolean("false"));
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
