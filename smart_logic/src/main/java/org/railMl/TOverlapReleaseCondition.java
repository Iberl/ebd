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
 * <p>Java-Klasse für tOverlapReleaseCondition.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tOverlapReleaseCondition">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="trainInitiatedTrigger"/>
 *     &lt;enumeration value="startTimerAfterVacating"/>
 *     &lt;enumeration value="startTimerUponOccupation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tOverlapReleaseCondition")
@XmlEnum
public enum TOverlapReleaseCondition {

    @XmlEnumValue("trainInitiatedTrigger")
    TRAIN_INITIATED_TRIGGER("trainInitiatedTrigger"),
    @XmlEnumValue("startTimerAfterVacating")
    START_TIMER_AFTER_VACATING("startTimerAfterVacating"),
    @XmlEnumValue("startTimerUponOccupation")
    START_TIMER_UPON_OCCUPATION("startTimerUponOccupation");
    private final String value;

    TOverlapReleaseCondition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TOverlapReleaseCondition fromValue(String v) {
        for (TOverlapReleaseCondition c: TOverlapReleaseCondition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
