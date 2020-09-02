//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.geodaten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMHSystem.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMHSystem">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DHHN_12"/>
 *     &lt;enumeration value="DHHN_85"/>
 *     &lt;enumeration value="DHHN_92"/>
 *     &lt;enumeration value="HN_56"/>
 *     &lt;enumeration value="HN_76"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMHSystem")
@XmlEnum
public enum ENUMHSystem {

    DHHN_12("DHHN_12"),
    DHHN_85("DHHN_85"),
    DHHN_92("DHHN_92"),
    HN_56("HN_56"),
    HN_76("HN_76"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMHSystem(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMHSystem fromValue(String v) {
        for (ENUMHSystem c: ENUMHSystem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
