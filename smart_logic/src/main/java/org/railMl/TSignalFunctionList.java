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
 * <p>Java-Klasse für tSignalFunctionList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tSignalFunctionList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="main"/>
 *     &lt;enumeration value="repeater"/>
 *     &lt;enumeration value="distant"/>
 *     &lt;enumeration value="shunting"/>
 *     &lt;enumeration value="barrage"/>
 *     &lt;enumeration value="block"/>
 *     &lt;enumeration value="junction"/>
 *     &lt;enumeration value="exit"/>
 *     &lt;enumeration value="intermediateStop"/>
 *     &lt;enumeration value="intermediate"/>
 *     &lt;enumeration value="entry"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tSignalFunctionList")
@XmlEnum
public enum TSignalFunctionList {

    @XmlEnumValue("main")
    MAIN("main"),
    @XmlEnumValue("repeater")
    REPEATER("repeater"),
    @XmlEnumValue("distant")
    DISTANT("distant"),
    @XmlEnumValue("shunting")
    SHUNTING("shunting"),
    @XmlEnumValue("barrage")
    BARRAGE("barrage"),
    @XmlEnumValue("block")
    BLOCK("block"),
    @XmlEnumValue("junction")
    JUNCTION("junction"),
    @XmlEnumValue("exit")
    EXIT("exit"),
    @XmlEnumValue("intermediateStop")
    INTERMEDIATE_STOP("intermediateStop"),
    @XmlEnumValue("intermediate")
    INTERMEDIATE("intermediate"),
    @XmlEnumValue("entry")
    ENTRY("entry");
    private final String value;

    TSignalFunctionList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSignalFunctionList fromValue(String v) {
        for (TSignalFunctionList c: TSignalFunctionList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
