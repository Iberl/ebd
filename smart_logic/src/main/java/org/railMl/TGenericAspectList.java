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
 * <p>Java-Klasse für tGenericAspectList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tGenericAspectList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="warning"/>
 *     &lt;enumeration value="supplementary"/>
 *     &lt;enumeration value="restriction"/>
 *     &lt;enumeration value="proceed"/>
 *     &lt;enumeration value="limitedProceed"/>
 *     &lt;enumeration value="informative"/>
 *     &lt;enumeration value="combinedProceed"/>
 *     &lt;enumeration value="closed"/>
 *     &lt;enumeration value="caution"/>
 *     &lt;enumeration value="callOn"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tGenericAspectList")
@XmlEnum
public enum TGenericAspectList {

    @XmlEnumValue("warning")
    WARNING("warning"),
    @XmlEnumValue("supplementary")
    SUPPLEMENTARY("supplementary"),
    @XmlEnumValue("restriction")
    RESTRICTION("restriction"),
    @XmlEnumValue("proceed")
    PROCEED("proceed"),
    @XmlEnumValue("limitedProceed")
    LIMITED_PROCEED("limitedProceed"),
    @XmlEnumValue("informative")
    INFORMATIVE("informative"),
    @XmlEnumValue("combinedProceed")
    COMBINED_PROCEED("combinedProceed"),
    @XmlEnumValue("closed")
    CLOSED("closed"),
    @XmlEnumValue("caution")
    CAUTION("caution"),
    @XmlEnumValue("callOn")
    CALL_ON("callOn");
    private final String value;

    TGenericAspectList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGenericAspectList fromValue(String v) {
        for (TGenericAspectList c: TGenericAspectList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
