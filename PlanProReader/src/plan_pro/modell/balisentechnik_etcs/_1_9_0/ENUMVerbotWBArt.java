//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMVerbot_WB_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMVerbot_WB_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Betriebsbremsung"/>
 *     &lt;enumeration value="vollst�ndig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMVerbot_WB_Art")
@XmlEnum
public enum ENUMVerbotWBArt {

    @XmlEnumValue("Betriebsbremsung")
    BETRIEBSBREMSUNG("Betriebsbremsung"),
    @XmlEnumValue("vollstaendig")
    VOLLSTAENDIG("vollstaendig");
    private final String value;

    ENUMVerbotWBArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMVerbotWBArt fromValue(String v) {
        for (ENUMVerbotWBArt c: ENUMVerbotWBArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
