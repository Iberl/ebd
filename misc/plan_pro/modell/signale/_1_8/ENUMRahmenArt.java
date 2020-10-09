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
 * <p>Java-Klasse f�r ENUMRahmen_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMRahmen_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bezeichnungsschild"/>
 *     &lt;enumeration value="Blechtafel"/>
 *     &lt;enumeration value="Keramikkoerper"/>
 *     &lt;enumeration value="Schirm"/>
 *     &lt;enumeration value="Zusatzanzeiger"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMRahmen_Art")
@XmlEnum
public enum ENUMRahmenArt {

    @XmlEnumValue("Bezeichnungsschild")
    BEZEICHNUNGSSCHILD("Bezeichnungsschild"),
    @XmlEnumValue("Blechtafel")
    BLECHTAFEL("Blechtafel"),
    @XmlEnumValue("Keramikkoerper")
    KERAMIKKOERPER("Keramikkoerper"),
    @XmlEnumValue("Schirm")
    SCHIRM("Schirm"),
    @XmlEnumValue("Zusatzanzeiger")
    ZUSATZANZEIGER("Zusatzanzeiger"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMRahmenArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMRahmenArt fromValue(String v) {
        for (ENUMRahmenArt c: ENUMRahmenArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
