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
 * <p>Java-Klasse für tLevelCrossingState.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLevelCrossingState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="closing"/>
 *     &lt;enumeration value="opening"/>
 *     &lt;enumeration value="closed"/>
 *     &lt;enumeration value="open"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLevelCrossingState")
@XmlEnum
public enum TLevelCrossingState {

    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),
    @XmlEnumValue("closing")
    CLOSING("closing"),
    @XmlEnumValue("opening")
    OPENING("opening"),
    @XmlEnumValue("closed")
    CLOSED("closed"),
    @XmlEnumValue("open")
    OPEN("open");
    private final String value;

    TLevelCrossingState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLevelCrossingState fromValue(String v) {
        for (TLevelCrossingState c: TLevelCrossingState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
