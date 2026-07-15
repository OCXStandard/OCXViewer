<?xml version="1.0" encoding="UTF-8"?>
<!--
    Example Schematron rules for OCX 3.1.0 files.

    These rules demonstrate the kind of business checks that go beyond what the
    XSD can express (value formats, cross references, conditional presence).

    IMPORTANT: the OCX namespace is version specific. These rules target OCX 3.1.0:
        https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd
    To check a file of another version (e.g. 3.2.0), copy this file and change the
    "ocx" namespace URI in the <sch:ns> element below to that version's namespace.
    If no rule fires at all, the rules file most likely does not match the file's
    OCX version.

    Verified against the files shipped in data/Schema310:
      - Invalidated/invalid_demo.3docx  -> fires the Panel, GUIDRef and tolerance rules
      - brackets.3docx (and the NAPA files) -> all rules pass
-->
<sch:schema xmlns:sch="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2">

    <sch:title>Example OCX 3.1.0 quality rules</sch:title>

    <sch:ns prefix="ocx" uri="https://3docx.org/fileadmin//ocx_schema//V310//OCX_Schema.xsd"/>
    <sch:ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>

    <sch:pattern id="vessel-basics">
        <sch:rule context="ocx:Vessel">
            <sch:assert test="@name and string-length(normalize-space(@name)) gt 0" role="error">
                The Vessel must have a non-empty name attribute.
            </sch:assert>
        </sch:rule>
    </sch:pattern>

    <sch:pattern id="panel-physical-properties">
        <sch:rule context="ocx:Panel">
            <sch:assert test="ocx:PhysicalProperties" role="warning">
                Panel <sch:value-of select="@name"/> has no PhysicalProperties (dry weight and
                centre of gravity); importers cannot verify the panel weight.
            </sch:assert>
        </sch:rule>
    </sch:pattern>

    <sch:pattern id="guid-format">
        <sch:rule context="*[@ocx:GUIDRef]">
            <sch:assert role="error"
                        test="matches(@ocx:GUIDRef, '^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$')">
                GUIDRef <sch:value-of select="@ocx:GUIDRef"/> is not a plain UUID; curly braces
                or a vendor specific format are not portable between systems.
            </sch:assert>
        </sch:rule>
    </sch:pattern>

    <sch:pattern id="tolerances">
        <sch:rule context="ocx:DistanceTolerance | ocx:AngleTolerance">
            <sch:assert role="error"
                        test="(@numericvalue castable as xs:double) and xs:double(@numericvalue) ge 0">
                <sch:name/> must have a non-negative numeric value, found
                "<sch:value-of select="@numericvalue"/>".
            </sch:assert>
        </sch:rule>
    </sch:pattern>

</sch:schema>
