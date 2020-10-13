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
 * <p>Java-Klasse für tMaxTrainCurrentOperation.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tMaxTrainCurrentOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="standstill"/>
 *     &lt;enumeration value="driving"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tMaxTrainCurrentOperation")
@XmlEnum
public enum TMaxTrainCurrentOperation {

    @XmlEnumValue("standstill")
    STANDSTILL("standstill"),
    @XmlEnumValue("driving")
    DRIVING("driving");
    private final String value;

    TMaxTrainCurrentOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TMaxTrainCurrentOperation fromValue(String v) {
        for (TMaxTrainCurrentOperation c: TMaxTrainCurrentOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
