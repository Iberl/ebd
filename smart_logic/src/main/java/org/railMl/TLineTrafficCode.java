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
 * <p>Java-Klasse für tLineTrafficCode.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tLineTrafficCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="F1600"/>
 *     &lt;enumeration value="F1520"/>
 *     &lt;enumeration value="F4"/>
 *     &lt;enumeration value="F3"/>
 *     &lt;enumeration value="F2"/>
 *     &lt;enumeration value="F1"/>
 *     &lt;enumeration value="P1600"/>
 *     &lt;enumeration value="P1520"/>
 *     &lt;enumeration value="P6"/>
 *     &lt;enumeration value="P5"/>
 *     &lt;enumeration value="P4"/>
 *     &lt;enumeration value="P3"/>
 *     &lt;enumeration value="P2"/>
 *     &lt;enumeration value="P1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tLineTrafficCode")
@XmlEnum
public enum TLineTrafficCode {

    @XmlEnumValue("F1600")
    F_1600("F1600"),
    @XmlEnumValue("F1520")
    F_1520("F1520"),
    @XmlEnumValue("F4")
    F_4("F4"),
    @XmlEnumValue("F3")
    F_3("F3"),
    @XmlEnumValue("F2")
    F_2("F2"),
    @XmlEnumValue("F1")
    F_1("F1"),
    @XmlEnumValue("P1600")
    P_1600("P1600"),
    @XmlEnumValue("P1520")
    P_1520("P1520"),
    @XmlEnumValue("P6")
    P_6("P6"),
    @XmlEnumValue("P5")
    P_5("P5"),
    @XmlEnumValue("P4")
    P_4("P4"),
    @XmlEnumValue("P3")
    P_3("P3"),
    @XmlEnumValue("P2")
    P_2("P2"),
    @XmlEnumValue("P1")
    P_1("P1");
    private final String value;

    TLineTrafficCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TLineTrafficCode fromValue(String v) {
        for (TLineTrafficCode c: TLineTrafficCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
