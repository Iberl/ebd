//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:06:07 PM CEST 
//


package org.railMl.rtm4rail;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tDescriptionLevel.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tDescriptionLevel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Micro"/>
 *     &lt;enumeration value="Meso"/>
 *     &lt;enumeration value="Macro"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDescriptionLevel")
@XmlEnum
public enum TDescriptionLevel {

    @XmlEnumValue("Micro")
    MICRO("Micro"),
    @XmlEnumValue("Meso")
    MESO("Meso"),
    @XmlEnumValue("Macro")
    MACRO("Macro");
    private final String value;

    TDescriptionLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDescriptionLevel fromValue(String v) {
        for (TDescriptionLevel c: TDescriptionLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
