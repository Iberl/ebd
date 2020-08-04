//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMSpannung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSpannung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AC 110"/>
 *     &lt;enumeration value="AC 230"/>
 *     &lt;enumeration value="AC 400"/>
 *     &lt;enumeration value="DC 110"/>
 *     &lt;enumeration value="DC 136"/>
 *     &lt;enumeration value="DC 24"/>
 *     &lt;enumeration value="DC 36"/>
 *     &lt;enumeration value="DC 48"/>
 *     &lt;enumeration value="DC 60"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSpannung_Art")
@XmlEnum
public enum ENUMSpannungArt {

    @XmlEnumValue("AC 110")
    AC_110("AC 110"),
    @XmlEnumValue("AC 230")
    AC_230("AC 230"),
    @XmlEnumValue("AC 400")
    AC_400("AC 400"),
    @XmlEnumValue("DC 110")
    DC_110("DC 110"),
    @XmlEnumValue("DC 136")
    DC_136("DC 136"),
    @XmlEnumValue("DC 24")
    DC_24("DC 24"),
    @XmlEnumValue("DC 36")
    DC_36("DC 36"),
    @XmlEnumValue("DC 48")
    DC_48("DC 48"),
    @XmlEnumValue("DC 60")
    DC_60("DC 60");
    private final String value;

    ENUMSpannungArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSpannungArt fromValue(String v) {
        for (ENUMSpannungArt c: ENUMSpannungArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
