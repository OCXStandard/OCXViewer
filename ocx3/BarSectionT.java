
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>BarSection_T</code> complex type
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * Type definition of the catalogue of rolled and welded cross-sections recognised by the
 * 				Society.
 *  

*/
// BarSection_T https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// DescriptionBase_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "BarSection_T", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public abstract class BarSectionT extends DescriptionBaseT
{

    // the properties serialised to attributes

    // AttributeWrapper{name='GUIDRef', typeName='ocx:guid', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', required=false, defaultValue='null', fixedValue='null', referencedType='Object'}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // ocx:guid => TypeWrapper{name='guid', isAbstract=false, isComplexType=false, isSimpleType=true, isEnumType=false, baseTypeName='null', targetNamespace='null', attributes=[], properties=[]}
    //     use String
    // Java Type , String Type Adapter !!!typeAdapter unmapped type ocx:guid!!!
    /* The 'GUIDRef' value serialised as  XML attribute.
    * 
    */
    // contains the String serialised form of ocx:guid as String (, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
        // ?? ocx:guid
    @XmlTransient
    public  javafx.beans.property.ObjectProperty<String> GUIDRef = new  javafx.beans.property.SimpleObjectProperty<String>();

    @XmlAttribute(name = "GUIDRef", required = false, namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
    @XmlSchemaType(name = "ocx:guid")
    public String getGUIDRef() {
        return this.GUIDRef.get();
    };

    public void setGUIDRef( String value) {
        this.GUIDRef.set( value);

    }
    // end GUIDRef
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // Property RectangularTube
    // PropertyWrapper{name='RectangularTube', typeName='RectangularTube', docu='null', type=RectangularTube, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='RectangularTube', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RectangularTube_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'RectangularTube' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<RectangularTube> RectangularTube = new javafx.beans.property.SimpleObjectProperty<RectangularTube>();

    @XmlElement(name = "RectangularTube", required = true)
    public RectangularTube getRectangularTube() {
        return this.RectangularTube.get();
    }
    public void setRectangularTube( RectangularTube value) {
        this.RectangularTube.set( value);
    }




    // Property OctagonBar
    // PropertyWrapper{name='OctagonBar', typeName='OctagonBar', docu='null', type=OctagonBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='OctagonBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='OctagonBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'OctagonBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<OctagonBar> OctagonBar = new javafx.beans.property.SimpleObjectProperty<OctagonBar>();

    @XmlElement(name = "OctagonBar", required = true)
    public OctagonBar getOctagonBar() {
        return this.OctagonBar.get();
    }
    public void setOctagonBar( OctagonBar value) {
        this.OctagonBar.set( value);
    }




    // Property SquareBar
    // PropertyWrapper{name='SquareBar', typeName='SquareBar', docu='null', type=SquareBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='SquareBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='SquareBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'SquareBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<SquareBar> SquareBar = new javafx.beans.property.SimpleObjectProperty<SquareBar>();

    @XmlElement(name = "SquareBar", required = true)
    public SquareBar getSquareBar() {
        return this.SquareBar.get();
    }
    public void setSquareBar( SquareBar value) {
        this.SquareBar.set( value);
    }




    // Property BulbFlat
    // PropertyWrapper{name='BulbFlat', typeName='BulbFlat', docu='null', type=BulbFlat, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='BulbFlat', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='BulbFlat_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'BulbFlat' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<BulbFlat> BulbFlat = new javafx.beans.property.SimpleObjectProperty<BulbFlat>();

    @XmlElement(name = "BulbFlat", required = true)
    public BulbFlat getBulbFlat() {
        return this.BulbFlat.get();
    }
    public void setBulbFlat( BulbFlat value) {
        this.BulbFlat.set( value);
    }




    // Property FlatBar
    // PropertyWrapper{name='FlatBar', typeName='FlatBar', docu='null', type=FlatBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='FlatBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='FlatBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'FlatBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<FlatBar> FlatBar = new javafx.beans.property.SimpleObjectProperty<FlatBar>();

    @XmlElement(name = "FlatBar", required = true)
    public FlatBar getFlatBar() {
        return this.FlatBar.get();
    }
    public void setFlatBar( FlatBar value) {
        this.FlatBar.set( value);
    }




    // Property UBar
    // PropertyWrapper{name='UBar', typeName='UBar', docu='null', type=UBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UBar> UBar = new javafx.beans.property.SimpleObjectProperty<UBar>();

    @XmlElement(name = "UBar", required = true)
    public UBar getUBar() {
        return this.UBar.get();
    }
    public void setUBar( UBar value) {
        this.UBar.set( value);
    }




    // Property IBar
    // PropertyWrapper{name='IBar', typeName='IBar', docu='null', type=IBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='IBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='IBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'IBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<IBar> IBar = new javafx.beans.property.SimpleObjectProperty<IBar>();

    @XmlElement(name = "IBar", required = true)
    public IBar getIBar() {
        return this.IBar.get();
    }
    public void setIBar( IBar value) {
        this.IBar.set( value);
    }




    // Property LBarOF
    // PropertyWrapper{name='LBarOF', typeName='LBarOF', docu='null', type=LBarOF, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='LBarOF', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LBarOF_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LBarOF' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LBarOF> LBarOF = new javafx.beans.property.SimpleObjectProperty<LBarOF>();

    @XmlElement(name = "LBarOF", required = true)
    public LBarOF getLBarOF() {
        return this.LBarOF.get();
    }
    public void setLBarOF( LBarOF value) {
        this.LBarOF.set( value);
    }




    // Property ZBar
    // PropertyWrapper{name='ZBar', typeName='ZBar', docu='null', type=ZBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='ZBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='ZBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'ZBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<ZBar> ZBar = new javafx.beans.property.SimpleObjectProperty<ZBar>();

    @XmlElement(name = "ZBar", required = true)
    public ZBar getZBar() {
        return this.ZBar.get();
    }
    public void setZBar( ZBar value) {
        this.ZBar.set( value);
    }




    // Property RoundBar
    // PropertyWrapper{name='RoundBar', typeName='RoundBar', docu='null', type=RoundBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='RoundBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='RoundBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'RoundBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<RoundBar> RoundBar = new javafx.beans.property.SimpleObjectProperty<RoundBar>();

    @XmlElement(name = "RoundBar", required = true)
    public RoundBar getRoundBar() {
        return this.RoundBar.get();
    }
    public void setRoundBar( RoundBar value) {
        this.RoundBar.set( value);
    }




    // Property LBar
    // PropertyWrapper{name='LBar', typeName='LBar', docu='null', type=LBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='LBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LBar> LBar = new javafx.beans.property.SimpleObjectProperty<LBar>();

    @XmlElement(name = "LBar", required = true)
    public LBar getLBar() {
        return this.LBar.get();
    }
    public void setLBar( LBar value) {
        this.LBar.set( value);
    }




    // Property TBar
    // PropertyWrapper{name='TBar', typeName='TBar', docu='null', type=TBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='TBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='TBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'TBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<TBar> TBar = new javafx.beans.property.SimpleObjectProperty<TBar>();

    @XmlElement(name = "TBar", required = true)
    public TBar getTBar() {
        return this.TBar.get();
    }
    public void setTBar( TBar value) {
        this.TBar.set( value);
    }




    // Property LBarOW
    // PropertyWrapper{name='LBarOW', typeName='LBarOW', docu='null', type=LBarOW, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='LBarOW', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='LBarOW_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'LBarOW' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<LBarOW> LBarOW = new javafx.beans.property.SimpleObjectProperty<LBarOW>();

    @XmlElement(name = "LBarOW", required = true)
    public LBarOW getLBarOW() {
        return this.LBarOW.get();
    }
    public void setLBarOW( LBarOW value) {
        this.LBarOW.set( value);
    }




    // Property HalfRoundBar
    // PropertyWrapper{name='HalfRoundBar', typeName='HalfRoundBar', docu='null', type=HalfRoundBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='HalfRoundBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HalfRoundBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'HalfRoundBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<HalfRoundBar> HalfRoundBar = new javafx.beans.property.SimpleObjectProperty<HalfRoundBar>();

    @XmlElement(name = "HalfRoundBar", required = true)
    public HalfRoundBar getHalfRoundBar() {
        return this.HalfRoundBar.get();
    }
    public void setHalfRoundBar( HalfRoundBar value) {
        this.HalfRoundBar.set( value);
    }




    // Property HexagonBar
    // PropertyWrapper{name='HexagonBar', typeName='HexagonBar', docu='null', type=HexagonBar, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='HexagonBar', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='HexagonBar_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'HexagonBar' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<HexagonBar> HexagonBar = new javafx.beans.property.SimpleObjectProperty<HexagonBar>();

    @XmlElement(name = "HexagonBar", required = true)
    public HexagonBar getHexagonBar() {
        return this.HexagonBar.get();
    }
    public void setHexagonBar( HexagonBar value) {
        this.HexagonBar.set( value);
    }




    // Property Tube
    // PropertyWrapper{name='Tube', typeName='Tube', docu='null', type=Tube, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='Tube', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='Tube_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'Tube' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<Tube> Tube = new javafx.beans.property.SimpleObjectProperty<Tube>();

    @XmlElement(name = "Tube", required = true)
    public Tube getTube() {
        return this.Tube.get();
    }
    public void setTube( Tube value) {
        this.Tube.set( value);
    }




    // Property UserDefinedBarSection
    // PropertyWrapper{name='UserDefinedBarSection', typeName='UserDefinedBarSection', docu='null', type=UserDefinedBarSection, minOccurs=1, maxOccurs=1}
    // TypeWrapper{name='UserDefinedBarSection', isAbstract=false, isComplexType=false, isSimpleType=false, isEnumType=false, baseTypeName='UserDefinedBarSection_T', targetNamespace='https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd', attributes=[], properties=[]}
    // https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
    // is simple type false
    /* The 'UserDefinedBarSection' property serialised as  XML elemenmt.
    * 
    */

    @XmlTransient
    public javafx.beans.property.ObjectProperty<UserDefinedBarSection> UserDefinedBarSection = new javafx.beans.property.SimpleObjectProperty<UserDefinedBarSection>();

    @XmlElement(name = "UserDefinedBarSection", required = true)
    public UserDefinedBarSection getUserDefinedBarSection() {
        return this.UserDefinedBarSection.get();
    }
    public void setUserDefinedBarSection( UserDefinedBarSection value) {
        this.UserDefinedBarSection.set( value);
    }




    // end the properties serialised to elements




      public BarSectionT() {
          try {

         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
