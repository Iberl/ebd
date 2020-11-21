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
 * <p>Java-Klasse für tTrainType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="freight"/>
 *     &lt;enumeration value="tiltingPassenger"/>
 *     &lt;enumeration value="passenger"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainType")
@XmlEnum
public enum TTrainType {

    @XmlEnumValue("freight")
    FREIGHT("freight"),
    @XmlEnumValue("tiltingPassenger")
    TILTING_PASSENGER("tiltingPassenger"),
    @XmlEnumValue("passenger")
    PASSENGER("passenger");
    private final String value;

    TTrainType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainType fromValue(String v) {
        for (TTrainType c: TTrainType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
