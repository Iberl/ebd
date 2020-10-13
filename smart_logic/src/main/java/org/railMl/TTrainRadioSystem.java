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
 * <p>Java-Klasse für tTrainRadioSystem.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainRadioSystem">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="analogDistantRadio"/>
 *     &lt;enumeration value="analogLocalRadio"/>
 *     &lt;enumeration value="otherDigitalRadio"/>
 *     &lt;enumeration value="GSM-R"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainRadioSystem")
@XmlEnum
public enum TTrainRadioSystem {

    @XmlEnumValue("analogDistantRadio")
    ANALOG_DISTANT_RADIO("analogDistantRadio"),
    @XmlEnumValue("analogLocalRadio")
    ANALOG_LOCAL_RADIO("analogLocalRadio"),
    @XmlEnumValue("otherDigitalRadio")
    OTHER_DIGITAL_RADIO("otherDigitalRadio"),
    @XmlEnumValue("GSM-R")
    GSM_R("GSM-R");
    private final String value;

    TTrainRadioSystem(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainRadioSystem fromValue(String v) {
        for (TTrainRadioSystem c: TTrainRadioSystem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
