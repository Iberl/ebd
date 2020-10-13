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
 * <p>Java-Klasse für tSignalConstructionType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tSignalConstructionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="pole"/>
 *     &lt;enumeration value="board"/>
 *     &lt;enumeration value="virtual"/>
 *     &lt;enumeration value="semaphore"/>
 *     &lt;enumeration value="light"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tSignalConstructionType")
@XmlEnum
public enum TSignalConstructionType {


    /**
     * the signal aspect is expressed via a color code painted on the pole
     * 
     */
    @XmlEnumValue("pole")
    POLE("pole"),

    /**
     * a board is a panel that expresses one (unchangeable) signal aspect
     * 
     */
    @XmlEnumValue("board")
    BOARD("board"),

    /**
     * the signal does not exist physically as infrastructure component, but only virtually
     * 
     */
    @XmlEnumValue("virtual")
    VIRTUAL("virtual"),

    /**
     * a signal, where the signal aspect is expressed by the position of its movable arms
     * 
     */
    @XmlEnumValue("semaphore")
    SEMAPHORE("semaphore"),

    /**
     * a signal with lamps
     * 
     */
    @XmlEnumValue("light")
    LIGHT("light");
    private final String value;

    TSignalConstructionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSignalConstructionType fromValue(String v) {
        for (TSignalConstructionType c: TSignalConstructionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
