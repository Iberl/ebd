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
 * <p>Java-Klasse für tElementProjectionSymbolOrientation.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tElementProjectionSymbolOrientation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="left"/>
 *     &lt;enumeration value="down"/>
 *     &lt;enumeration value="right"/>
 *     &lt;enumeration value="up"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tElementProjectionSymbolOrientation")
@XmlEnum
public enum TElementProjectionSymbolOrientation {


    /**
     * icon or symbol turned 90 degrees left
     * 
     */
    @XmlEnumValue("left")
    LEFT("left"),

    /**
     * the icon or symbol is turned 180 degrees
     * 
     */
    @XmlEnumValue("down")
    DOWN("down"),

    /**
     * icon or symbol turned 90 degrees right
     * 
     */
    @XmlEnumValue("right")
    RIGHT("right"),

    /**
     * standard orientation of icon or symbol
     * 
     */
    @XmlEnumValue("up")
    UP("up");
    private final String value;

    TElementProjectionSymbolOrientation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TElementProjectionSymbolOrientation fromValue(String v) {
        for (TElementProjectionSymbolOrientation c: TElementProjectionSymbolOrientation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
