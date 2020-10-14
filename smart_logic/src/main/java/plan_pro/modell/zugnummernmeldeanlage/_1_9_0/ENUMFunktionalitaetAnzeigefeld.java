//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.zugnummernmeldeanlage._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFunktionalitaet_Anzeigefeld.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFunktionalitaet_Anzeigefeld">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anbiete_Annahmefeld"/>
 *     &lt;enumeration value="Meldeort"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Spiegelfeld"/>
 *     &lt;enumeration value="Stapelfeld"/>
 *     &lt;enumeration value="Voranzeigefeld"/>
 *     &lt;enumeration value="Wandelfeld"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFunktionalitaet_Anzeigefeld")
@XmlEnum
public enum ENUMFunktionalitaetAnzeigefeld {

    @XmlEnumValue("Anbiete_Annahmefeld")
    ANBIETE_ANNAHMEFELD("Anbiete_Annahmefeld"),
    @XmlEnumValue("Meldeort")
    MELDEORT("Meldeort"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Spiegelfeld")
    SPIEGELFELD("Spiegelfeld"),
    @XmlEnumValue("Stapelfeld")
    STAPELFELD("Stapelfeld"),
    @XmlEnumValue("Voranzeigefeld")
    VORANZEIGEFELD("Voranzeigefeld"),
    @XmlEnumValue("Wandelfeld")
    WANDELFELD("Wandelfeld");
    private final String value;

    ENUMFunktionalitaetAnzeigefeld(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFunktionalitaetAnzeigefeld fromValue(String v) {
        for (ENUMFunktionalitaetAnzeigefeld c: ENUMFunktionalitaetAnzeigefeld.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
