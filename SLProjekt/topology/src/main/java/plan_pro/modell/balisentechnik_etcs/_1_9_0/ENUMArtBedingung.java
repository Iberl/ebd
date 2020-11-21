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
 * <p>Java-Klasse f�r ENUMArt_Bedingung.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMArt_Bedingung">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Default"/>
 *     &lt;enumeration value="Festdaten"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="St�rtelegramm"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMArt_Bedingung")
@XmlEnum
public enum ENUMArtBedingung {

    @XmlEnumValue("Default")
    DEFAULT("Default"),
    @XmlEnumValue("Festdaten")
    FESTDATEN("Festdaten"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Stoertelegramm")
    STOERTELEGRAMM("Stoertelegramm");
    private final String value;

    ENUMArtBedingung(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMArtBedingung fromValue(String v) {
        for (ENUMArtBedingung c: ENUMArtBedingung.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
