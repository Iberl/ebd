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
 * <p>Java-Klasse f�r ENUMSignal_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSignal_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="andere"/>
 *     &lt;enumeration value="Hauptsignal"/>
 *     &lt;enumeration value="Hauptsperrsignal"/>
 *     &lt;enumeration value="Mehrabschnittssignal"/>
 *     &lt;enumeration value="Mehrabschnittssperrsignal"/>
 *     &lt;enumeration value="Sperrsignal"/>
 *     &lt;enumeration value="Vorsignal"/>
 *     &lt;enumeration value="Vorsignalwiederholer"/>
 *     &lt;enumeration value="Zugdeckungssignal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSignal_Art")
@XmlEnum
public enum ENUMSignalArt {

    @XmlEnumValue("andere")
    ANDERE("andere"),
    @XmlEnumValue("Hauptsignal")
    HAUPTSIGNAL("Hauptsignal"),
    @XmlEnumValue("Hauptsperrsignal")
    HAUPTSPERRSIGNAL("Hauptsperrsignal"),
    @XmlEnumValue("Mehrabschnittssignal")
    MEHRABSCHNITTSSIGNAL("Mehrabschnittssignal"),
    @XmlEnumValue("Mehrabschnittssperrsignal")
    MEHRABSCHNITTSSPERRSIGNAL("Mehrabschnittssperrsignal"),
    @XmlEnumValue("Sperrsignal")
    SPERRSIGNAL("Sperrsignal"),
    @XmlEnumValue("Vorsignal")
    VORSIGNAL("Vorsignal"),
    @XmlEnumValue("Vorsignalwiederholer")
    VORSIGNALWIEDERHOLER("Vorsignalwiederholer"),
    @XmlEnumValue("Zugdeckungssignal")
    ZUGDECKUNGSSIGNAL("Zugdeckungssignal");
    private final String value;

    ENUMSignalArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSignalArt fromValue(String v) {
        for (ENUMSignalArt c: ENUMSignalArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
