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
 * <p>Java-Klasse f�r ENUMSchalter.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMSchalter">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Schalter_ein_aus"/>
 *     &lt;enumeration value="Schluesselschalter_DB_21"/>
 *     &lt;enumeration value="Schluesselschalter_Vierkant"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Vorbereitungsmeldung"/>
 *     &lt;enumeration value="Zustimmungstaste"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMSchalter")
@XmlEnum
public enum ENUMSchalter {

    @XmlEnumValue("Schalter_ein_aus")
    SCHALTER_EIN_AUS("Schalter_ein_aus"),
    @XmlEnumValue("Schluesselschalter_DB_21")
    SCHLUESSELSCHALTER_DB_21("Schluesselschalter_DB_21"),
    @XmlEnumValue("Schluesselschalter_Vierkant")
    SCHLUESSELSCHALTER_VIERKANT("Schluesselschalter_Vierkant"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Vorbereitungsmeldung")
    VORBEREITUNGSMELDUNG("Vorbereitungsmeldung"),
    @XmlEnumValue("Zustimmungstaste")
    ZUSTIMMUNGSTASTE("Zustimmungstaste");
    private final String value;

    ENUMSchalter(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMSchalter fromValue(String v) {
        for (ENUMSchalter c: ENUMSchalter.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
