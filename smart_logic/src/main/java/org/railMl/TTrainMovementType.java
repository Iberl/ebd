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
 * <p>Java-Klasse für tTrainMovementType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainMovementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="shunting"/>
 *     &lt;enumeration value="allTrains"/>
 *     &lt;enumeration value="passengerTrains"/>
 *     &lt;enumeration value="freightTrains"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainMovementType")
@XmlEnum
public enum TTrainMovementType {

    @XmlEnumValue("shunting")
    SHUNTING("shunting"),
    @XmlEnumValue("allTrains")
    ALL_TRAINS("allTrains"),
    @XmlEnumValue("passengerTrains")
    PASSENGER_TRAINS("passengerTrains"),
    @XmlEnumValue("freightTrains")
    FREIGHT_TRAINS("freightTrains");
    private final String value;

    TTrainMovementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainMovementType fromValue(String v) {
        for (TTrainMovementType c: TTrainMovementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
