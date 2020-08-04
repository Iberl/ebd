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
 * <p>Java-Klasse f�r ENUMBefestigung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBefestigung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fundament"/>
 *     &lt;enumeration value="Pfosten"/>
 *     &lt;enumeration value="Schienenfuss"/>
 *     &lt;enumeration value="Mast"/>
 *     &lt;enumeration value="Rahmen"/>
 *     &lt;enumeration value="Signal_Anordnung_Arbeitsbuehne"/>
 *     &lt;enumeration value="Signal_Anordnung_Mast"/>
 *     &lt;enumeration value="Signal_Anordnung_Sonstige"/>
 *     &lt;enumeration value="Signalausleger"/>
 *     &lt;enumeration value="Signalbruecke"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBefestigung_Art")
@XmlEnum
public enum ENUMBefestigungArt {

    @XmlEnumValue("Fundament")
    FUNDAMENT("Fundament"),
    @XmlEnumValue("Pfosten")
    PFOSTEN("Pfosten"),
    @XmlEnumValue("Schienenfuss")
    SCHIENENFUSS("Schienenfuss"),
    @XmlEnumValue("Mast")
    MAST("Mast"),
    @XmlEnumValue("Rahmen")
    RAHMEN("Rahmen"),
    @XmlEnumValue("Signal_Anordnung_Arbeitsbuehne")
    SIGNAL_ANORDNUNG_ARBEITSBUEHNE("Signal_Anordnung_Arbeitsbuehne"),
    @XmlEnumValue("Signal_Anordnung_Mast")
    SIGNAL_ANORDNUNG_MAST("Signal_Anordnung_Mast"),
    @XmlEnumValue("Signal_Anordnung_Sonstige")
    SIGNAL_ANORDNUNG_SONSTIGE("Signal_Anordnung_Sonstige"),
    @XmlEnumValue("Signalausleger")
    SIGNALAUSLEGER("Signalausleger"),
    @XmlEnumValue("Signalbruecke")
    SIGNALBRUECKE("Signalbruecke"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMBefestigungArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBefestigungArt fromValue(String v) {
        for (ENUMBefestigungArt c: ENUMBefestigungArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
