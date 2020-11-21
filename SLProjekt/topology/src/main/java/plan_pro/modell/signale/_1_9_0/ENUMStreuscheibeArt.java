//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMStreuscheibe_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMStreuscheibe_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LED"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="HRL"/>
 *     &lt;enumeration value="HG"/>
 *     &lt;enumeration value="HN"/>
 *     &lt;enumeration value="ORL"/>
 *     &lt;enumeration value="VRL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMStreuscheibe_Art")
@XmlEnum
public enum ENUMStreuscheibeArt {

    LED("LED"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    HRL("HRL"),
    HG("HG"),
    HN("HN"),
    ORL("ORL"),
    VRL("VRL");
    private final String value;

    ENUMStreuscheibeArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMStreuscheibeArt fromValue(String v) {
        for (ENUMStreuscheibeArt c: ENUMStreuscheibeArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
