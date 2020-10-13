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
 * <p>Java-Klasse für tDetectorLayout.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tDetectorLayout">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="tripleLoop"/>
 *     &lt;enumeration value="singleSensor"/>
 *     &lt;enumeration value="singleLoop"/>
 *     &lt;enumeration value="railCircuitStandAlone"/>
 *     &lt;enumeration value="doubleSensor"/>
 *     &lt;enumeration value="doubleLoop"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDetectorLayout")
@XmlEnum
public enum TDetectorLayout {

    @XmlEnumValue("tripleLoop")
    TRIPLE_LOOP("tripleLoop"),
    @XmlEnumValue("singleSensor")
    SINGLE_SENSOR("singleSensor"),
    @XmlEnumValue("singleLoop")
    SINGLE_LOOP("singleLoop"),
    @XmlEnumValue("railCircuitStandAlone")
    RAIL_CIRCUIT_STAND_ALONE("railCircuitStandAlone"),
    @XmlEnumValue("doubleSensor")
    DOUBLE_SENSOR("doubleSensor"),
    @XmlEnumValue("doubleLoop")
    DOUBLE_LOOP("doubleLoop");
    private final String value;

    TDetectorLayout(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDetectorLayout fromValue(String v) {
        for (TDetectorLayout c: TDetectorLayout.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
