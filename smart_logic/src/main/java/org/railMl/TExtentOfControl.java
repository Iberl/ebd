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
 * <p>Java-Klasse für tExtentOfControl.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tExtentOfControl">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="steeringOnly"/>
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="notificationOnly"/>
 *     &lt;enumeration value="fullControl"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tExtentOfControl")
@XmlEnum
public enum TExtentOfControl {

    @XmlEnumValue("steeringOnly")
    STEERING_ONLY("steeringOnly"),
    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("notificationOnly")
    NOTIFICATION_ONLY("notificationOnly"),
    @XmlEnumValue("fullControl")
    FULL_CONTROL("fullControl");
    private final String value;

    TExtentOfControl(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TExtentOfControl fromValue(String v) {
        for (TExtentOfControl c: TExtentOfControl.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
