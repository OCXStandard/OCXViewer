package de.cadoculus.ocx3.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.persistence.oxm.NamespacePrefixMapper;
/**
 * Implementation of {@link NamespacePrefixMapper} that maps the schema
 * namespaces more to readable names. Used by the jaxb marshaller. Requires
 * setting the property "com.sun.xml.bind.namespacePrefixMapper" to an instance
 * of this class.
 * <p>
 * Requires dependency on JAXB implementation jars
 * </p>
 */
public class DefaultNamespaceMapper extends NamespacePrefixMapper {

    private Map<String, String> namespaceMap = new HashMap<>();

    /**
     * Create mappings.
     */
    public DefaultNamespaceMapper() {
        namespaceMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        namespaceMap.put("https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd", "ocx");
        namespaceMap.put("urn:oasis:names:tc:unitsml:schema:xsd:UnitsMLSchema_lite-0.9.18", "unitsml");
    }

    /* (non-Javadoc)
     * Returning null when not found based on spec.
     * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
     */
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        return namespaceMap.getOrDefault(namespaceUri, suggestion);
    }
}