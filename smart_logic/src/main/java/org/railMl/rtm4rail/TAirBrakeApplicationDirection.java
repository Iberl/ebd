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
 * <p>Java-Klasse für tAirBrakeApplicationDirection.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tAirBrakeApplicationDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="N/A"/>
 *     &lt;enumeration value="G"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tAirBrakeApplicationDirection")
@XmlEnum
public enum TAirBrakeApplicationDirection {


    /**
     * Rapid
     * 
     */
    R("R"),

    /**
     * Passenger
     * 
     */
    P("P"),
    @XmlEnumValue("N/A")
    N_A("N/A"),

    /**
     * Goods
     * 
     */
    G("G");
    private final String value;

    TAirBrakeApplicationDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TAirBrakeApplicationDirection fromValue(String v) {
        for (TAirBrakeApplicationDirection c: TAirBrakeApplicationDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
