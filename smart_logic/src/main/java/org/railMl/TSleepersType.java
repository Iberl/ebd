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
 * <p>Java-Klasse für tSleepersType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tSleepersType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="composite"/>
 *     &lt;enumeration value="steel"/>
 *     &lt;enumeration value="concrete"/>
 *     &lt;enumeration value="wood"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tSleepersType")
@XmlEnum
public enum TSleepersType {

    @XmlEnumValue("composite")
    COMPOSITE("composite"),
    @XmlEnumValue("steel")
    STEEL("steel"),
    @XmlEnumValue("concrete")
    CONCRETE("concrete"),
    @XmlEnumValue("wood")
    WOOD("wood");
    private final String value;

    TSleepersType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSleepersType fromValue(String v) {
        for (TSleepersType c: TSleepersType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
