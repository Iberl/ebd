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
 * <p>Java-Klasse f�r tDetectedObject.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tDetectedObject">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="wheel"/>
 *     &lt;enumeration value="train"/>
 *     &lt;enumeration value="endOfTrain"/>
 *     &lt;enumeration value="axle"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDetectedObject")
@XmlEnum
public enum TDetectedObject {

    @XmlEnumValue("wheel")
    WHEEL("wheel"),
    @XmlEnumValue("train")
    TRAIN("train"),
    @XmlEnumValue("endOfTrain")
    END_OF_TRAIN("endOfTrain"),
    @XmlEnumValue("axle")
    AXLE("axle");
    private final String value;

    TDetectedObject(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDetectedObject fromValue(String v) {
        for (TDetectedObject c: TDetectedObject.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
