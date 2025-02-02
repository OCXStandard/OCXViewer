
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.*;

import de.cadoculus.ocx3.impl.*;

/**
*  The <code>DesignView_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition.
 *  

*/
// DesignView_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "DesignView_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class DesignViewT extends DescriptionBaseT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property VesselRef
    // PropertyWrapper{name='VesselRef', typeName='VesselRef', docu='null', type=VesselRef, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='VesselRef', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='VesselRef_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'VesselRef' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<VesselRef> VesselRef = new javafx.beans.property.SimpleObjectProperty<VesselRef>();

    @XmlElement(name = "VesselRef", required = true)
    public VesselRef getVesselRef() {
        return this.VesselRef.get();
    }
    public void setVesselRef( VesselRef value) {
        this.VesselRef.set( value);
    }




    // Property OccurrenceGroup
    // PropertyWrapper{name='OccurrenceGroup', typeName='OccurrenceGroup', docu='null', type=OccurrenceGroup, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='OccurrenceGroup', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='OccurrenceGroup_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OccurrenceGroup' property serialised as  XML elemenmt.
    * 
    */

    private List<OccurrenceGroup> occurrenceGroups = new ArrayList<>();

    public List<OccurrenceGroup> getOccurrenceGroup() {
        return occurrenceGroups;
    }




    // Property Occurrence
    // PropertyWrapper{name='Occurrence', typeName='Occurrence', docu='null', type=Occurrence, minOccurs=1, maxOccurs=100}
    // TypeWrapper{name='Occurrence', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Occurrence_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Occurrence' property serialised as  XML elemenmt.
    * 
    */

    private List<Occurrence> occurrences = new ArrayList<>();

    public List<Occurrence> getOccurrence() {
        return occurrences;
    }




    // end the properties serialised to elements




      public DesignViewT() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
