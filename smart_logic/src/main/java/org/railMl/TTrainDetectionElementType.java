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
 * <p>Java-Klasse für tTrainDetectionElementType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrainDetectionElementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="axleCounter"/>
 *     &lt;enumeration value="axleCountingCircuit"/>
 *     &lt;enumeration value="clearancePoint"/>
 *     &lt;enumeration value="insulatedRailJoint"/>
 *     &lt;enumeration value="trackCircuit"/>
 *     &lt;enumeration value="virtualClearancePoint"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrainDetectionElementType")
@XmlEnum
public enum TTrainDetectionElementType {

    @XmlEnumValue("axleCounter")
    AXLE_COUNTER("axleCounter"),
    @XmlEnumValue("axleCountingCircuit")
    AXLE_COUNTING_CIRCUIT("axleCountingCircuit"),
    @XmlEnumValue("clearancePoint")
    CLEARANCE_POINT("clearancePoint"),
    @XmlEnumValue("insulatedRailJoint")
    INSULATED_RAIL_JOINT("insulatedRailJoint"),
    @XmlEnumValue("trackCircuit")
    TRACK_CIRCUIT("trackCircuit"),
    @XmlEnumValue("virtualClearancePoint")
    VIRTUAL_CLEARANCE_POINT("virtualClearancePoint");
    private final String value;

    TTrainDetectionElementType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrainDetectionElementType fromValue(String v) {
        for (TTrainDetectionElementType c: TTrainDetectionElementType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
