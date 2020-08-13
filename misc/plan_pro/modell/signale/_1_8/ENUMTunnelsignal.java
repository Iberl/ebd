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
 * <p>Java-Klasse f�r ENUMTunnelsignal.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTunnelsignal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="nein"/>
 *     &lt;enumeration value="ohne_Dauernachtschaltung"/>
 *     &lt;enumeration value="mit_Dauernachtschaltung"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTunnelsignal")
@XmlEnum
public enum ENUMTunnelsignal {

    @XmlEnumValue("nein")
    NEIN("nein"),
    @XmlEnumValue("ohne_Dauernachtschaltung")
    OHNE_DAUERNACHTSCHALTUNG("ohne_Dauernachtschaltung"),
    @XmlEnumValue("mit_Dauernachtschaltung")
    MIT_DAUERNACHTSCHALTUNG("mit_Dauernachtschaltung");
    private final String value;

    ENUMTunnelsignal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTunnelsignal fromValue(String v) {
        for (ENUMTunnelsignal c: ENUMTunnelsignal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
