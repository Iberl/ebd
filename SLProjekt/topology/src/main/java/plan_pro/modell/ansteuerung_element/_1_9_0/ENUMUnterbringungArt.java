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
 * <p>Java-Klasse f�r ENUMUnterbringung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMUnterbringung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Antrieb"/>
 *     &lt;enumeration value="keine"/>
 *     &lt;enumeration value="Schaltschrank_Schaltkasten"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Tafel"/>
 *     &lt;enumeration value="Gebaeude"/>
 *     &lt;enumeration value="Schalthaus"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMUnterbringung_Art")
@XmlEnum
public enum ENUMUnterbringungArt {

    @XmlEnumValue("Antrieb")
    ANTRIEB("Antrieb"),
    @XmlEnumValue("keine")
    KEINE("keine"),
    @XmlEnumValue("Schaltschrank_Schaltkasten")
    SCHALTSCHRANK_SCHALTKASTEN("Schaltschrank_Schaltkasten"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Tafel")
    TAFEL("Tafel"),
    @XmlEnumValue("Gebaeude")
    GEBAEUDE("Gebaeude"),
    @XmlEnumValue("Schalthaus")
    SCHALTHAUS("Schalthaus");
    private final String value;

    ENUMUnterbringungArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMUnterbringungArt fromValue(String v) {
        for (ENUMUnterbringungArt c: ENUMUnterbringungArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
