//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tContactStripMaterial.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tContactStripMaterial">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="sinteredCopper"/>
 *     &lt;enumeration value="copperCladCarbon"/>
 *     &lt;enumeration value="carbonCladdedCopper"/>
 *     &lt;enumeration value="carbonAdditiveMaterial"/>
 *     &lt;enumeration value="impregnatedCarbon"/>
 *     &lt;enumeration value="copperAlloy"/>
 *     &lt;enumeration value="copperSteel"/>
 *     &lt;enumeration value="plainCarbon"/>
 *     &lt;enumeration value="copper"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tContactStripMaterial")
@XmlEnum
public enum TContactStripMaterial {

    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("sinteredCopper")
    SINTERED_COPPER("sinteredCopper"),
    @XmlEnumValue("copperCladCarbon")
    COPPER_CLAD_CARBON("copperCladCarbon"),
    @XmlEnumValue("carbonCladdedCopper")
    CARBON_CLADDED_COPPER("carbonCladdedCopper"),
    @XmlEnumValue("carbonAdditiveMaterial")
    CARBON_ADDITIVE_MATERIAL("carbonAdditiveMaterial"),
    @XmlEnumValue("impregnatedCarbon")
    IMPREGNATED_CARBON("impregnatedCarbon"),
    @XmlEnumValue("copperAlloy")
    COPPER_ALLOY("copperAlloy"),
    @XmlEnumValue("copperSteel")
    COPPER_STEEL("copperSteel"),
    @XmlEnumValue("plainCarbon")
    PLAIN_CARBON("plainCarbon"),
    @XmlEnumValue("copper")
    COPPER("copper");
    private final String value;

    TContactStripMaterial(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TContactStripMaterial fromValue(String v) {
        for (TContactStripMaterial c: TContactStripMaterial.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
