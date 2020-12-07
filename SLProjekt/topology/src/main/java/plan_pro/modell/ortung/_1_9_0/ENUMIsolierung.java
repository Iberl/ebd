//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMIsolierung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMIsolierung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="einschienig_L"/>
 *     &lt;enumeration value="einschienig_R"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="zweischienig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMIsolierung")
@XmlEnum
public enum ENUMIsolierung {

    @XmlEnumValue("einschienig_L")
    EINSCHIENIG_L("einschienig_L"),
    @XmlEnumValue("einschienig_R")
    EINSCHIENIG_R("einschienig_R"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("zweischienig")
    ZWEISCHIENIG("zweischienig");
    private final String value;

    ENUMIsolierung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMIsolierung fromValue(String v) {
        for (ENUMIsolierung c: ENUMIsolierung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
