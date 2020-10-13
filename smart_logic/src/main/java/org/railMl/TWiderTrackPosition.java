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
 * <p>Java-Klasse für tWiderTrackPosition.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tWiderTrackPosition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="above"/>
 *     &lt;enumeration value="right"/>
 *     &lt;enumeration value="left"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tWiderTrackPosition")
@XmlEnum
public enum TWiderTrackPosition {

    @XmlEnumValue("above")
    ABOVE("above"),
    @XmlEnumValue("right")
    RIGHT("right"),
    @XmlEnumValue("left")
    LEFT("left");
    private final String value;

    TWiderTrackPosition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TWiderTrackPosition fromValue(String v) {
        for (TWiderTrackPosition c: TWiderTrackPosition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
