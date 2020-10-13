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
 * <p>Java-Klasse für tTrainRelation.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainRelation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="endOfTrain"/>
 *     &lt;enumeration value="midOfTrain"/>
 *     &lt;enumeration value="headOfTrain"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainRelation")
@XmlEnum
public enum TTrainRelation {

    @XmlEnumValue("endOfTrain")
    END_OF_TRAIN("endOfTrain"),
    @XmlEnumValue("midOfTrain")
    MID_OF_TRAIN("midOfTrain"),
    @XmlEnumValue("headOfTrain")
    HEAD_OF_TRAIN("headOfTrain");
    private final String value;

    TTrainRelation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainRelation fromValue(String v) {
        for (TTrainRelation c: TTrainRelation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
