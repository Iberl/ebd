//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.signale._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBedienart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBedienart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="wb"/>
 *     &lt;enumeration value="wb_zb"/>
 *     &lt;enumeration value="zb"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBedienart")
@XmlEnum
public enum ENUMBedienart {

    @XmlEnumValue("wb")
    WB("wb"),
    @XmlEnumValue("wb_zb")
    WB_ZB("wb_zb"),
    @XmlEnumValue("zb")
    ZB("zb");
    private final String value;

    ENUMBedienart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBedienart fromValue(String v) {
        for (ENUMBedienart c: ENUMBedienart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
