//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBaubereich_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBaubereich_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ausgebaut"/>
 *     &lt;enumeration value="Baugleis"/>
 *     &lt;enumeration value="gesperrt"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBaubereich_Art")
@XmlEnum
public enum ENUMBaubereichArt {

    @XmlEnumValue("ausgebaut")
    AUSGEBAUT("ausgebaut"),
    @XmlEnumValue("Baugleis")
    BAUGLEIS("Baugleis"),
    @XmlEnumValue("gesperrt")
    GESPERRT("gesperrt"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMBaubereichArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBaubereichArt fromValue(String v) {
        for (ENUMBaubereichArt c: ENUMBaubereichArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
