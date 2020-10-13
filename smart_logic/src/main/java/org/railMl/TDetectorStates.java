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
 * <p>Java-Klasse für tDetectorStates.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tDetectorStates">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="inactive"/>
 *     &lt;enumeration value="deactivated"/>
 *     &lt;enumeration value="activated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDetectorStates")
@XmlEnum
public enum TDetectorStates {

    @XmlEnumValue("inactive")
    INACTIVE("inactive"),
    @XmlEnumValue("deactivated")
    DEACTIVATED("deactivated"),
    @XmlEnumValue("activated")
    ACTIVATED("activated");
    private final String value;

    TDetectorStates(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDetectorStates fromValue(String v) {
        for (TDetectorStates c: TDetectorStates.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
