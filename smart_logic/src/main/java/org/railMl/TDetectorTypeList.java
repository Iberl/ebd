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
 * <p>Java-Klasse für tDetectorTypeList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tDetectorTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="weighing"/>
 *     &lt;enumeration value="loadingGauge"/>
 *     &lt;enumeration value="landSlide"/>
 *     &lt;enumeration value="intrusion"/>
 *     &lt;enumeration value="hotWheelBox"/>
 *     &lt;enumeration value="gas"/>
 *     &lt;enumeration value="flatWheel"/>
 *     &lt;enumeration value="fire"/>
 *     &lt;enumeration value="doors"/>
 *     &lt;enumeration value="derailment"/>
 *     &lt;enumeration value="cranks"/>
 *     &lt;enumeration value="avalanche"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tDetectorTypeList")
@XmlEnum
public enum TDetectorTypeList {

    @XmlEnumValue("weighing")
    WEIGHING("weighing"),
    @XmlEnumValue("loadingGauge")
    LOADING_GAUGE("loadingGauge"),
    @XmlEnumValue("landSlide")
    LAND_SLIDE("landSlide"),
    @XmlEnumValue("intrusion")
    INTRUSION("intrusion"),
    @XmlEnumValue("hotWheelBox")
    HOT_WHEEL_BOX("hotWheelBox"),
    @XmlEnumValue("gas")
    GAS("gas"),
    @XmlEnumValue("flatWheel")
    FLAT_WHEEL("flatWheel"),
    @XmlEnumValue("fire")
    FIRE("fire"),
    @XmlEnumValue("doors")
    DOORS("doors"),
    @XmlEnumValue("derailment")
    DERAILMENT("derailment"),
    @XmlEnumValue("cranks")
    CRANKS("cranks"),
    @XmlEnumValue("avalanche")
    AVALANCHE("avalanche");
    private final String value;

    TDetectorTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TDetectorTypeList fromValue(String v) {
        for (TDetectorTypeList c: TDetectorTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
