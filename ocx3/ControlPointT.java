
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;
import java.text.NumberFormat;
import javafx.beans.property.*;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>ControlPoint_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * 
 *  

*/
// ControlPoint_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// Point3D_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ControlPoint_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class ControlPointT extends Point3DT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='weight', typeName='xs:double', targetNamespace='', required=false, defaultValue='1.0', fixedValue='null', referencedType='Object'}
    // 
    // xs:double => TypeWrapper{name='double', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use double
    // Java Type , double Type Adapter !!!typeAdapter unmapped type xs:double!!!
    /* The 'weight' value serialised as  XML attribute.
    * <summary>
    * The weight associated with the control point. The weight is 1.0 if not given
    * 					(default).</summary>
    */
    // contains the String serialised form of xs:double as double ( default namespace)
    @XmlTransient
    public DoubleProperty Weight = new SimpleDoubleProperty();

    @XmlAttribute(name = "weight", required = false)
    @XmlSchemaType(name = "xs:double")
    public double getWeight() {
        return this.Weight.get();
    };

    public void setWeight( double value) {
        this.Weight.set( value);

    }
    // end weight
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public ControlPointT() {
          try {
          // attr weight with default value '1.0', type double
           Weight.set( NumberFormat.getNumberInstance(Locale.ENGLISH).parse("1.0").doubleValue());
 
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
