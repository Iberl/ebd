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
 * <p>Java-Klasse für tGenericResetStrategyList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tGenericResetStrategyList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unconditionalReset"/>
 *     &lt;enumeration value="sweepRunWithoutConfirmation"/>
 *     &lt;enumeration value="sweepRunWithConfirmation"/>
 *     &lt;enumeration value="procedure"/>
 *     &lt;enumeration value="conditionalReset"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tGenericResetStrategyList")
@XmlEnum
public enum TGenericResetStrategyList {

    @XmlEnumValue("unconditionalReset")
    UNCONDITIONAL_RESET("unconditionalReset"),
    @XmlEnumValue("sweepRunWithoutConfirmation")
    SWEEP_RUN_WITHOUT_CONFIRMATION("sweepRunWithoutConfirmation"),
    @XmlEnumValue("sweepRunWithConfirmation")
    SWEEP_RUN_WITH_CONFIRMATION("sweepRunWithConfirmation"),
    @XmlEnumValue("procedure")
    PROCEDURE("procedure"),
    @XmlEnumValue("conditionalReset")
    CONDITIONAL_RESET("conditionalReset");
    private final String value;

    TGenericResetStrategyList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TGenericResetStrategyList fromValue(String v) {
        for (TGenericResetStrategyList c: TGenericResetStrategyList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
