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
 * <p>Java-Klasse für tIxlInterfaceLocationTypeList.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tIxlInterfaceLocationTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="atStationBorder"/>
 *     &lt;enumeration value="onOpenLine"/>
 *     &lt;enumeration value="inStation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tIxlInterfaceLocationTypeList")
@XmlEnum
public enum TIxlInterfaceLocationTypeList {

    @XmlEnumValue("atStationBorder")
    AT_STATION_BORDER("atStationBorder"),
    @XmlEnumValue("onOpenLine")
    ON_OPEN_LINE("onOpenLine"),
    @XmlEnumValue("inStation")
    IN_STATION("inStation");
    private final String value;

    TIxlInterfaceLocationTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TIxlInterfaceLocationTypeList fromValue(String v) {
        for (TIxlInterfaceLocationTypeList c: TIxlInterfaceLocationTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
