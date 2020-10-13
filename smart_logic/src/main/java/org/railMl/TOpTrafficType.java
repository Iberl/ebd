//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r tOpTrafficType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tOpTrafficType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="operational"/>
 *     &lt;enumeration value="shunting"/>
 *     &lt;enumeration value="freight"/>
 *     &lt;enumeration value="passenger"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tOpTrafficType")
@XmlEnum
public enum TOpTrafficType {


    /**
     * no passengers, no goods, just staff
     * 
     */
    @XmlEnumValue("operational")
    OPERATIONAL("operational"),
    @XmlEnumValue("shunting")
    SHUNTING("shunting"),
    @XmlEnumValue("freight")
    FREIGHT("freight"),
    @XmlEnumValue("passenger")
    PASSENGER("passenger");
    private final String value;

    TOpTrafficType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TOpTrafficType fromValue(String v) {
        for (TOpTrafficType c: TOpTrafficType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
