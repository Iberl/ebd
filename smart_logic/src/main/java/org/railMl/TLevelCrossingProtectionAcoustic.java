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
 * <p>Java-Klasse für tLevelCrossingProtectionAcoustic.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingProtectionAcoustic">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="bell"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingProtectionAcoustic")
@XmlEnum
public enum TLevelCrossingProtectionAcoustic {


    /**
     * no acoustic level crossing protection
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * acoustic level crossing protection with a bell
     * 
     */
    @XmlEnumValue("bell")
    BELL("bell");
    private final String value;

    TLevelCrossingProtectionAcoustic(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingProtectionAcoustic fromValue(String v) {
        for (TLevelCrossingProtectionAcoustic c: TLevelCrossingProtectionAcoustic.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
