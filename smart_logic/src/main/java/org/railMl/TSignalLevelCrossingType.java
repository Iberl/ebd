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
 * <p>Java-Klasse für tSignalLevelCrossingType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tSignalLevelCrossingType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="supervision"/>
 *     &lt;enumeration value="activating"/>
 *     &lt;enumeration value="announcing"/>
 *     &lt;enumeration value="whistle"/>
 *     &lt;enumeration value="bell"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tSignalLevelCrossingType")
@XmlEnum
public enum TSignalLevelCrossingType {


    /**
     * final level crossing supervision signal that is located immediately before the level crossing.
     * 
     */
    @XmlEnumValue("supervision")
    SUPERVISION("supervision"),

    /**
     * Notice (board) indicating the activation point at technically secured level crossings (with warning light and/or barrier).
     * 
     */
    @XmlEnumValue("activating")
    ACTIVATING("activating"),

    /**
     * Announcement signal which indicates the state of the technical safety at technically secured level crossings (with warning light and/or barrier).
     * 
     */
    @XmlEnumValue("announcing")
    ANNOUNCING("announcing"),

    /**
     * Whistle board, as a command to the driver to activate the engine whistle.
     * 
     */
    @XmlEnumValue("whistle")
    WHISTLE("whistle"),

    /**
     * Bell board as a request to the driver to switch on the engine bell
     * 
     */
    @XmlEnumValue("bell")
    BELL("bell");
    private final String value;

    TSignalLevelCrossingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSignalLevelCrossingType fromValue(String v) {
        for (TSignalLevelCrossingType c: TSignalLevelCrossingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
