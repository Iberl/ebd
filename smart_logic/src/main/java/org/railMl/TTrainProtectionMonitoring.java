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
 * <p>Java-Klasse für tTrainProtectionMonitoring.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainProtectionMonitoring">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="continuous"/>
 *     &lt;enumeration value="intermittent"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainProtectionMonitoring")
@XmlEnum
public enum TTrainProtectionMonitoring {

    @XmlEnumValue("continuous")
    CONTINUOUS("continuous"),
    @XmlEnumValue("intermittent")
    INTERMITTENT("intermittent"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    TTrainProtectionMonitoring(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainProtectionMonitoring fromValue(String v) {
        for (TTrainProtectionMonitoring c: TTrainProtectionMonitoring.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
