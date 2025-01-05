package de.cadoculus.ocx3;
import jakarta.xml.bind.annotation.*;
/**
 * The 'functionType' enumeration.
 */
// functionType https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
@XmlType(name = " functionType")
@XmlEnum(String.class)
public enum  FunctionTypeEnum {
    @XmlEnumValue("GotUnknownValue") UNKNOWN_VALUE,
    @XmlEnumValue("BRACKET") BRACKET,
    @XmlEnumValue("BRACKET: End bracket") BRACKETCOLONBLANKENDBLANKBRACKET,
    @XmlEnumValue("BRACKET: Tripping") BRACKETCOLONBLANKTRIPPING,
    @XmlEnumValue("CASING") CASING,
    @XmlEnumValue("CASING: Engine room") CASINGCOLONBLANKENGINEBLANKROOM,
    @XmlEnumValue("DECK") DECK,
    @XmlEnumValue("DECK: Accommodation deck") DECKCOLONBLANKACCOMMODATIONBLANKDECK,
    @XmlEnumValue("DECK: Cargo deck") DECKCOLONBLANKCARGOBLANKDECK,
    @XmlEnumValue("DECK: Cross deck") DECKCOLONBLANKCROSSBLANKDECK,
    @XmlEnumValue("DECK: Cross ties") DECKCOLONBLANKCROSSBLANKTIES,
    @XmlEnumValue("DECK: Floor") DECKCOLONBLANKFLOOR,
    @XmlEnumValue("DECK: Weather deck") DECKCOLONBLANKWEATHERBLANKDECK,
    @XmlEnumValue("DECK: Forecastle deck") DECKCOLONBLANKFORECASTLEBLANKDECK,
    @XmlEnumValue("DECK: Freeboard deck") DECKCOLONBLANKFREEBOARDBLANKDECK,
    @XmlEnumValue("DECK: Girder") DECKCOLONBLANKGIRDER,
    @XmlEnumValue("DECK: Inner bottom deck") DECKCOLONBLANKINNERBLANKBOTTOMBLANKDECK,
    @XmlEnumValue("DECK: Platform deck") DECKCOLONBLANKPLATFORMBLANKDECK,
    @XmlEnumValue("DECK: Poop deck") DECKCOLONBLANKPOOPBLANKDECK,
    @XmlEnumValue("DECK: Strength deck") DECKCOLONBLANKSTRENGTHBLANKDECK,
    @XmlEnumValue("DECK: Superstructure deck") DECKCOLONBLANKSUPERSTRUCTUREBLANKDECK,
    @XmlEnumValue("DECK: Trunk deck") DECKCOLONBLANKTRUNKBLANKDECK,
    @XmlEnumValue("DECK: Tween deck") DECKCOLONBLANKTWEENBLANKDECK,
    @XmlEnumValue("DECK: Wheelhouse deck") DECKCOLONBLANKWHEELHOUSEBLANKDECK,
    @XmlEnumValue("FOUNDATION") FOUNDATION,
    @XmlEnumValue("FOUNDATION: Engine") FOUNDATIONCOLONBLANKENGINE,
    @XmlEnumValue("HATCHWAY_COAMING") HATCHWAY_COAMING,
    @XmlEnumValue("HATCHWAY_COAMING: End coaming") HATCHWAY_COAMINGCOLONBLANKENDBLANKCOAMING,
    @XmlEnumValue("HATCHWAY_COAMING: Side coaming") HATCHWAY_COAMINGCOLONBLANKSIDEBLANKCOAMING,
    @XmlEnumValue("HATCH_COVER") HATCH_COVER,
    @XmlEnumValue("HATCH_COVER: Hatch top") HATCH_COVERCOLONBLANKHATCHBLANKTOP,
    @XmlEnumValue("LONGITUDINAL") LONGITUDINAL,
    @XmlEnumValue("LONGITUDINAL: Bulkhead") LONGITUDINALCOLONBLANKBULKHEAD,
    @XmlEnumValue("LONGITUDINAL: Centerline bulkhead") LONGITUDINALCOLONBLANKCENTERLINEBLANKBULKHEAD,
    @XmlEnumValue("LONGITUDINAL: Girder") LONGITUDINALCOLONBLANKGIRDER,
    @XmlEnumValue("LONGITUDINAL: Centerline girder") LONGITUDINALCOLONBLANKCENTERLINEBLANKGIRDER,
    @XmlEnumValue("LONGITUDINAL: Centerline side girder") LONGITUDINALCOLONBLANKCENTERLINEBLANKSIDEBLANKGIRDER,
    @XmlEnumValue("LONGITUDINAL: Double bottom") LONGITUDINALCOLONBLANKDOUBLEBLANKBOTTOM,
    @XmlEnumValue("LONGITUDINAL: Top tank") LONGITUDINALCOLONBLANKTOPBLANKTANK,
    @XmlEnumValue("LONGITUDINAL: Hopper side lower") LONGITUDINALCOLONBLANKHOPPERBLANKSIDEBLANKLOWER,
    @XmlEnumValue("LONGITUDINAL: Hopper side upper") LONGITUDINALCOLONBLANKHOPPERBLANKSIDEBLANKUPPER,
    @XmlEnumValue("LONGITUDINAL: Inner bottom") LONGITUDINALCOLONBLANKINNERBLANKBOTTOM,
    @XmlEnumValue("LONGITUDINAL: Lower stool bottom plate") LONGITUDINALCOLONBLANKLOWERBLANKSTOOLBLANKBOTTOMBLANKPLATE,
    @XmlEnumValue("LONGITUDINAL: Lower stool top plate") LONGITUDINALCOLONBLANKLOWERBLANKSTOOLBLANKTOPBLANKPLATE,
    @XmlEnumValue("LONGITUDINAL: Lower stool") LONGITUDINALCOLONBLANKLOWERBLANKSTOOL,
    @XmlEnumValue("LONGITUDINAL: Side girder") LONGITUDINALCOLONBLANKSIDEBLANKGIRDER,
    @XmlEnumValue("LONGITUDINAL: Stringer") LONGITUDINALCOLONBLANKSTRINGER,
    @XmlEnumValue("LONGITUDINAL: Side stringer") LONGITUDINALCOLONBLANKSIDEBLANKSTRINGER,
    @XmlEnumValue("LONGITUDINAL: Skeg") LONGITUDINALCOLONBLANKSKEG,
    @XmlEnumValue("LONGITUDINAL: Upper stool") LONGITUDINALCOLONBLANKUPPERBLANKSTOOL,
    @XmlEnumValue("LONGITUDINAL: Wash bulkhead") LONGITUDINALCOLONBLANKWASHBLANKBULKHEAD,
    @XmlEnumValue("PLATING: Lug") PLATINGCOLONBLANKLUG,
    @XmlEnumValue("PLATING: Gusset") PLATINGCOLONBLANKGUSSET,
    @XmlEnumValue("PLATING: Shedder") PLATINGCOLONBLANKSHEDDER,
    @XmlEnumValue("SHEER_STRAKE") SHEER_STRAKE,
    @XmlEnumValue("SHELL") SHELL,
    @XmlEnumValue("SHELL: Bilge keel") SHELLCOLONBLANKBILGEBLANKKEEL,
    @XmlEnumValue("SHELL: Bilge strake") SHELLCOLONBLANKBILGEBLANKSTRAKE,
    @XmlEnumValue("SHELL: Bottom shell") SHELLCOLONBLANKBOTTOMBLANKSHELL,
    @XmlEnumValue("SHELL: Bulwark shell") SHELLCOLONBLANKBULWARKBLANKSHELL,
    @XmlEnumValue("SHELL: Inner bottom shell") SHELLCOLONBLANKINNERBLANKBOTTOMBLANKSHELL,
    @XmlEnumValue("SHELL: Inner side shell") SHELLCOLONBLANKINNERBLANKSIDEBLANKSHELL,
    @XmlEnumValue("SHELL: Superstructure side") SHELLCOLONBLANKSUPERSTRUCTUREBLANKSIDE,
    @XmlEnumValue("SUPERSTRUCTURE") SUPERSTRUCTURE,
    @XmlEnumValue("SUPERSTRUCTURE: Deckhouse aft") SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKAFT,
    @XmlEnumValue("SUPERSTRUCTURE: Deckhouse front") SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKFRONT,
    @XmlEnumValue("SUPERSTRUCTURE: Deckhouse side") SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKSIDE,
    @XmlEnumValue("SUPERSTRUCTURE: Deckhouse top") SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKTOP,
    @XmlEnumValue("SUPERSTRUCTURE: Side") SUPERSTRUCTURECOLONBLANKSIDE,
    @XmlEnumValue("TRANSVERSAL") TRANSVERSAL,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD") TRANSVERSAL_BULKHEAD,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Accommodation") TRANSVERSAL_BULKHEADCOLONBLANKACCOMMODATION,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Aft peak") TRANSVERSAL_BULKHEADCOLONBLANKAFTBLANKPEAK,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Collision") TRANSVERSAL_BULKHEADCOLONBLANKCOLLISION,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Corrugated") TRANSVERSAL_BULKHEADCOLONBLANKCORRUGATED,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Lower stool") TRANSVERSAL_BULKHEADCOLONBLANKLOWERBLANKSTOOL,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Partial") TRANSVERSAL_BULKHEADCOLONBLANKPARTIAL,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Upper stool") TRANSVERSAL_BULKHEADCOLONBLANKUPPERBLANKSTOOL,
    @XmlEnumValue("TRANSVERSAL_BULKHEAD: Wash") TRANSVERSAL_BULKHEADCOLONBLANKWASH,
    @XmlEnumValue("UNDEFINED: Miscellaneous") UNDEFINEDCOLONBLANKMISCELLANEOUS,
    @XmlEnumValue("VERTICAL") VERTICAL,
    @XmlEnumValue("WEB_FRAME") WEB_FRAME,
    @XmlEnumValue("WEB_FRAME: Bilge") WEB_FRAMECOLONBLANKBILGE,
    @XmlEnumValue("WEB_FRAME: Deck transverse frame") WEB_FRAMECOLONBLANKDECKBLANKTRANSVERSEBLANKFRAME,
    @XmlEnumValue("WEB_FRAME: Floor frame") WEB_FRAMECOLONBLANKFLOORBLANKFRAME,
    @XmlEnumValue("WEB_FRAME: General web-frame") WEB_FRAMECOLONBLANKGENERALBLANKWEBTILDEFRAME,
    @XmlEnumValue("WEB_FRAME: Horizontal") WEB_FRAMECOLONBLANKHORIZONTAL,
    @XmlEnumValue("WEB_FRAME: Vertical") WEB_FRAMECOLONBLANKVERTICAL,
    @XmlEnumValue("WEB_FRAME: Main frame") WEB_FRAMECOLONBLANKMAINBLANKFRAME,
    @XmlEnumValue("WEB_FRAME: Topside tank") WEB_FRAMECOLONBLANKTOPSIDEBLANKTANK,
    @XmlEnumValue("WEB_FRAME: Side") WEB_FRAMECOLONBLANKSIDE,
    @XmlEnumValue("WEB_FRAME: Tween deck frame") WEB_FRAMECOLONBLANKTWEENBLANKDECKBLANKFRAME
;

   public static FunctionTypeEnum parse(String value) {
        if ( value==null || value.equals("")) {
            return UNKNOWN_VALUE;
        }
        if ( "BRACKET".equals( value ) ) { return BRACKET;}
        if ( "BRACKET: End bracket".equals( value ) ) { return BRACKETCOLONBLANKENDBLANKBRACKET;}
        if ( "BRACKET: Tripping".equals( value ) ) { return BRACKETCOLONBLANKTRIPPING;}
        if ( "CASING".equals( value ) ) { return CASING;}
        if ( "CASING: Engine room".equals( value ) ) { return CASINGCOLONBLANKENGINEBLANKROOM;}
        if ( "DECK".equals( value ) ) { return DECK;}
        if ( "DECK: Accommodation deck".equals( value ) ) { return DECKCOLONBLANKACCOMMODATIONBLANKDECK;}
        if ( "DECK: Cargo deck".equals( value ) ) { return DECKCOLONBLANKCARGOBLANKDECK;}
        if ( "DECK: Cross deck".equals( value ) ) { return DECKCOLONBLANKCROSSBLANKDECK;}
        if ( "DECK: Cross ties".equals( value ) ) { return DECKCOLONBLANKCROSSBLANKTIES;}
        if ( "DECK: Floor".equals( value ) ) { return DECKCOLONBLANKFLOOR;}
        if ( "DECK: Weather deck".equals( value ) ) { return DECKCOLONBLANKWEATHERBLANKDECK;}
        if ( "DECK: Forecastle deck".equals( value ) ) { return DECKCOLONBLANKFORECASTLEBLANKDECK;}
        if ( "DECK: Freeboard deck".equals( value ) ) { return DECKCOLONBLANKFREEBOARDBLANKDECK;}
        if ( "DECK: Girder".equals( value ) ) { return DECKCOLONBLANKGIRDER;}
        if ( "DECK: Inner bottom deck".equals( value ) ) { return DECKCOLONBLANKINNERBLANKBOTTOMBLANKDECK;}
        if ( "DECK: Platform deck".equals( value ) ) { return DECKCOLONBLANKPLATFORMBLANKDECK;}
        if ( "DECK: Poop deck".equals( value ) ) { return DECKCOLONBLANKPOOPBLANKDECK;}
        if ( "DECK: Strength deck".equals( value ) ) { return DECKCOLONBLANKSTRENGTHBLANKDECK;}
        if ( "DECK: Superstructure deck".equals( value ) ) { return DECKCOLONBLANKSUPERSTRUCTUREBLANKDECK;}
        if ( "DECK: Trunk deck".equals( value ) ) { return DECKCOLONBLANKTRUNKBLANKDECK;}
        if ( "DECK: Tween deck".equals( value ) ) { return DECKCOLONBLANKTWEENBLANKDECK;}
        if ( "DECK: Wheelhouse deck".equals( value ) ) { return DECKCOLONBLANKWHEELHOUSEBLANKDECK;}
        if ( "FOUNDATION".equals( value ) ) { return FOUNDATION;}
        if ( "FOUNDATION: Engine".equals( value ) ) { return FOUNDATIONCOLONBLANKENGINE;}
        if ( "HATCHWAY_COAMING".equals( value ) ) { return HATCHWAY_COAMING;}
        if ( "HATCHWAY_COAMING: End coaming".equals( value ) ) { return HATCHWAY_COAMINGCOLONBLANKENDBLANKCOAMING;}
        if ( "HATCHWAY_COAMING: Side coaming".equals( value ) ) { return HATCHWAY_COAMINGCOLONBLANKSIDEBLANKCOAMING;}
        if ( "HATCH_COVER".equals( value ) ) { return HATCH_COVER;}
        if ( "HATCH_COVER: Hatch top".equals( value ) ) { return HATCH_COVERCOLONBLANKHATCHBLANKTOP;}
        if ( "LONGITUDINAL".equals( value ) ) { return LONGITUDINAL;}
        if ( "LONGITUDINAL: Bulkhead".equals( value ) ) { return LONGITUDINALCOLONBLANKBULKHEAD;}
        if ( "LONGITUDINAL: Centerline bulkhead".equals( value ) ) { return LONGITUDINALCOLONBLANKCENTERLINEBLANKBULKHEAD;}
        if ( "LONGITUDINAL: Girder".equals( value ) ) { return LONGITUDINALCOLONBLANKGIRDER;}
        if ( "LONGITUDINAL: Centerline girder".equals( value ) ) { return LONGITUDINALCOLONBLANKCENTERLINEBLANKGIRDER;}
        if ( "LONGITUDINAL: Centerline side girder".equals( value ) ) { return LONGITUDINALCOLONBLANKCENTERLINEBLANKSIDEBLANKGIRDER;}
        if ( "LONGITUDINAL: Double bottom".equals( value ) ) { return LONGITUDINALCOLONBLANKDOUBLEBLANKBOTTOM;}
        if ( "LONGITUDINAL: Top tank".equals( value ) ) { return LONGITUDINALCOLONBLANKTOPBLANKTANK;}
        if ( "LONGITUDINAL: Hopper side lower".equals( value ) ) { return LONGITUDINALCOLONBLANKHOPPERBLANKSIDEBLANKLOWER;}
        if ( "LONGITUDINAL: Hopper side upper".equals( value ) ) { return LONGITUDINALCOLONBLANKHOPPERBLANKSIDEBLANKUPPER;}
        if ( "LONGITUDINAL: Inner bottom".equals( value ) ) { return LONGITUDINALCOLONBLANKINNERBLANKBOTTOM;}
        if ( "LONGITUDINAL: Lower stool bottom plate".equals( value ) ) { return LONGITUDINALCOLONBLANKLOWERBLANKSTOOLBLANKBOTTOMBLANKPLATE;}
        if ( "LONGITUDINAL: Lower stool top plate".equals( value ) ) { return LONGITUDINALCOLONBLANKLOWERBLANKSTOOLBLANKTOPBLANKPLATE;}
        if ( "LONGITUDINAL: Lower stool".equals( value ) ) { return LONGITUDINALCOLONBLANKLOWERBLANKSTOOL;}
        if ( "LONGITUDINAL: Side girder".equals( value ) ) { return LONGITUDINALCOLONBLANKSIDEBLANKGIRDER;}
        if ( "LONGITUDINAL: Stringer".equals( value ) ) { return LONGITUDINALCOLONBLANKSTRINGER;}
        if ( "LONGITUDINAL: Side stringer".equals( value ) ) { return LONGITUDINALCOLONBLANKSIDEBLANKSTRINGER;}
        if ( "LONGITUDINAL: Skeg".equals( value ) ) { return LONGITUDINALCOLONBLANKSKEG;}
        if ( "LONGITUDINAL: Upper stool".equals( value ) ) { return LONGITUDINALCOLONBLANKUPPERBLANKSTOOL;}
        if ( "LONGITUDINAL: Wash bulkhead".equals( value ) ) { return LONGITUDINALCOLONBLANKWASHBLANKBULKHEAD;}
        if ( "PLATING: Lug".equals( value ) ) { return PLATINGCOLONBLANKLUG;}
        if ( "PLATING: Gusset".equals( value ) ) { return PLATINGCOLONBLANKGUSSET;}
        if ( "PLATING: Shedder".equals( value ) ) { return PLATINGCOLONBLANKSHEDDER;}
        if ( "SHEER_STRAKE".equals( value ) ) { return SHEER_STRAKE;}
        if ( "SHELL".equals( value ) ) { return SHELL;}
        if ( "SHELL: Bilge keel".equals( value ) ) { return SHELLCOLONBLANKBILGEBLANKKEEL;}
        if ( "SHELL: Bilge strake".equals( value ) ) { return SHELLCOLONBLANKBILGEBLANKSTRAKE;}
        if ( "SHELL: Bottom shell".equals( value ) ) { return SHELLCOLONBLANKBOTTOMBLANKSHELL;}
        if ( "SHELL: Bulwark shell".equals( value ) ) { return SHELLCOLONBLANKBULWARKBLANKSHELL;}
        if ( "SHELL: Inner bottom shell".equals( value ) ) { return SHELLCOLONBLANKINNERBLANKBOTTOMBLANKSHELL;}
        if ( "SHELL: Inner side shell".equals( value ) ) { return SHELLCOLONBLANKINNERBLANKSIDEBLANKSHELL;}
        if ( "SHELL: Superstructure side".equals( value ) ) { return SHELLCOLONBLANKSUPERSTRUCTUREBLANKSIDE;}
        if ( "SUPERSTRUCTURE".equals( value ) ) { return SUPERSTRUCTURE;}
        if ( "SUPERSTRUCTURE: Deckhouse aft".equals( value ) ) { return SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKAFT;}
        if ( "SUPERSTRUCTURE: Deckhouse front".equals( value ) ) { return SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKFRONT;}
        if ( "SUPERSTRUCTURE: Deckhouse side".equals( value ) ) { return SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKSIDE;}
        if ( "SUPERSTRUCTURE: Deckhouse top".equals( value ) ) { return SUPERSTRUCTURECOLONBLANKDECKHOUSEBLANKTOP;}
        if ( "SUPERSTRUCTURE: Side".equals( value ) ) { return SUPERSTRUCTURECOLONBLANKSIDE;}
        if ( "TRANSVERSAL".equals( value ) ) { return TRANSVERSAL;}
        if ( "TRANSVERSAL_BULKHEAD".equals( value ) ) { return TRANSVERSAL_BULKHEAD;}
        if ( "TRANSVERSAL_BULKHEAD: Accommodation".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKACCOMMODATION;}
        if ( "TRANSVERSAL_BULKHEAD: Aft peak".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKAFTBLANKPEAK;}
        if ( "TRANSVERSAL_BULKHEAD: Collision".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKCOLLISION;}
        if ( "TRANSVERSAL_BULKHEAD: Corrugated".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKCORRUGATED;}
        if ( "TRANSVERSAL_BULKHEAD: Lower stool".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKLOWERBLANKSTOOL;}
        if ( "TRANSVERSAL_BULKHEAD: Partial".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKPARTIAL;}
        if ( "TRANSVERSAL_BULKHEAD: Upper stool".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKUPPERBLANKSTOOL;}
        if ( "TRANSVERSAL_BULKHEAD: Wash".equals( value ) ) { return TRANSVERSAL_BULKHEADCOLONBLANKWASH;}
        if ( "UNDEFINED: Miscellaneous".equals( value ) ) { return UNDEFINEDCOLONBLANKMISCELLANEOUS;}
        if ( "VERTICAL".equals( value ) ) { return VERTICAL;}
        if ( "WEB_FRAME".equals( value ) ) { return WEB_FRAME;}
        if ( "WEB_FRAME: Bilge".equals( value ) ) { return WEB_FRAMECOLONBLANKBILGE;}
        if ( "WEB_FRAME: Deck transverse frame".equals( value ) ) { return WEB_FRAMECOLONBLANKDECKBLANKTRANSVERSEBLANKFRAME;}
        if ( "WEB_FRAME: Floor frame".equals( value ) ) { return WEB_FRAMECOLONBLANKFLOORBLANKFRAME;}
        if ( "WEB_FRAME: General web-frame".equals( value ) ) { return WEB_FRAMECOLONBLANKGENERALBLANKWEBTILDEFRAME;}
        if ( "WEB_FRAME: Horizontal".equals( value ) ) { return WEB_FRAMECOLONBLANKHORIZONTAL;}
        if ( "WEB_FRAME: Vertical".equals( value ) ) { return WEB_FRAMECOLONBLANKVERTICAL;}
        if ( "WEB_FRAME: Main frame".equals( value ) ) { return WEB_FRAMECOLONBLANKMAINBLANKFRAME;}
        if ( "WEB_FRAME: Topside tank".equals( value ) ) { return WEB_FRAMECOLONBLANKTOPSIDEBLANKTANK;}
        if ( "WEB_FRAME: Side".equals( value ) ) { return WEB_FRAMECOLONBLANKSIDE;}
        if ( "WEB_FRAME: Tween deck frame".equals( value ) ) { return WEB_FRAMECOLONBLANKTWEENBLANKDECKBLANKFRAME;}
        return UNKNOWN_VALUE;
   }

}
