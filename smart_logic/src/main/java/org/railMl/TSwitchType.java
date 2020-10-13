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
 * <p>Java-Klasse für tSwitchType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tSwitchType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="doubleSwitchCrossing"/>
 *     &lt;enumeration value="insideCurvedSwitch"/>
 *     &lt;enumeration value="ordinarySwitch"/>
 *     &lt;enumeration value="outsideCurvedSwitch"/>
 *     &lt;enumeration value="singleSwitchCrossing"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tSwitchType")
@XmlEnum
public enum TSwitchType {

    @XmlEnumValue("doubleSwitchCrossing")
    DOUBLE_SWITCH_CROSSING("doubleSwitchCrossing"),
    @XmlEnumValue("insideCurvedSwitch")
    INSIDE_CURVED_SWITCH("insideCurvedSwitch"),
    @XmlEnumValue("ordinarySwitch")
    ORDINARY_SWITCH("ordinarySwitch"),
    @XmlEnumValue("outsideCurvedSwitch")
    OUTSIDE_CURVED_SWITCH("outsideCurvedSwitch"),
    @XmlEnumValue("singleSwitchCrossing")
    SINGLE_SWITCH_CROSSING("singleSwitchCrossing");
    private final String value;

    TSwitchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TSwitchType fromValue(String v) {
        for (TSwitchType c: TSwitchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
