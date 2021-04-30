//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bedienung._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMMelder.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMMelder">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anforderungsempfang"/>
 *     &lt;enumeration value="Anzeige_Betriebszustand"/>
 *     &lt;enumeration value="Leuchtmelder_ZP_10"/>
 *     &lt;enumeration value="Leuchtmelder_ZP_9"/>
 *     &lt;enumeration value="Signalanforderung_empfangen"/>
 *     &lt;enumeration value="Signalfahrtmelder"/>
 *     &lt;enumeration value="Signalhaltmelder"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Sperrmelder"/>
 *     &lt;enumeration value="Vorbereitungsmeldung"/>
 *     &lt;enumeration value="Weichenmelder"/>
 *     &lt;enumeration value="Zielmelder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMMelder")
@XmlEnum
public enum ENUMMelder {

    @XmlEnumValue("Anforderungsempfang")
    ANFORDERUNGSEMPFANG("Anforderungsempfang"),
    @XmlEnumValue("Anzeige_Betriebszustand")
    ANZEIGE_BETRIEBSZUSTAND("Anzeige_Betriebszustand"),
    @XmlEnumValue("Leuchtmelder_ZP_10")
    LEUCHTMELDER_ZP_10("Leuchtmelder_ZP_10"),
    @XmlEnumValue("Leuchtmelder_ZP_9")
    LEUCHTMELDER_ZP_9("Leuchtmelder_ZP_9"),
    @XmlEnumValue("Signalanforderung_empfangen")
    SIGNALANFORDERUNG_EMPFANGEN("Signalanforderung_empfangen"),
    @XmlEnumValue("Signalfahrtmelder")
    SIGNALFAHRTMELDER("Signalfahrtmelder"),
    @XmlEnumValue("Signalhaltmelder")
    SIGNALHALTMELDER("Signalhaltmelder"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Sperrmelder")
    SPERRMELDER("Sperrmelder"),
    @XmlEnumValue("Vorbereitungsmeldung")
    VORBEREITUNGSMELDUNG("Vorbereitungsmeldung"),
    @XmlEnumValue("Weichenmelder")
    WEICHENMELDER("Weichenmelder"),
    @XmlEnumValue("Zielmelder")
    ZIELMELDER("Zielmelder");
    private final String value;

    ENUMMelder(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMMelder fromValue(String v) {
        for (ENUMMelder c: ENUMMelder.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
