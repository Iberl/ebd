//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMHp_Ersatzstecker.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMHp_Ersatzstecker">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Abhaengigkeit_aufgehoben"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMHp_Ersatzstecker")
@XmlEnum
public enum ENUMHpErsatzstecker {

    @XmlEnumValue("Abhaengigkeit_aufgehoben")
    ABHAENGIGKEIT_AUFGEHOBEN("Abhaengigkeit_aufgehoben"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMHpErsatzstecker(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMHpErsatzstecker fromValue(String v) {
        for (ENUMHpErsatzstecker c: ENUMHpErsatzstecker.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
