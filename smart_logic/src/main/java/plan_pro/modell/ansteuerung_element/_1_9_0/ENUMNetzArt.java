//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ansteuerung_element._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMNetz_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMNetz_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="geschlossen"/>
 *     &lt;enumeration value="KISA"/>
 *     &lt;enumeration value="offen"/>
 *     &lt;enumeration value="SBI_intern"/>
 *     &lt;enumeration value="SG"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMNetz_Art")
@XmlEnum
public enum ENUMNetzArt {

    @XmlEnumValue("geschlossen")
    GESCHLOSSEN("geschlossen"),
    KISA("KISA"),
    @XmlEnumValue("offen")
    OFFEN("offen"),
    @XmlEnumValue("SBI_intern")
    SBI_INTERN("SBI_intern"),
    SG("SG"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMNetzArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMNetzArt fromValue(String v) {
        for (ENUMNetzArt c: ENUMNetzArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
