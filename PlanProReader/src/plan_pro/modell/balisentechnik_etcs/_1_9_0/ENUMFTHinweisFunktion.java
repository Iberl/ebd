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
 * <p>Java-Klasse f�r ENUMFT_Hinweis_Funktion.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFT_Hinweis_Funktion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ortung"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZBS Ende"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFT_Hinweis_Funktion")
@XmlEnum
public enum ENUMFTHinweisFunktion {

    @XmlEnumValue("Ortung")
    ORTUNG("Ortung"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("ZBS Ende")
    ZBS_ENDE("ZBS Ende");
    private final String value;

    ENUMFTHinweisFunktion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFTHinweisFunktion fromValue(String v) {
        for (ENUMFTHinweisFunktion c: ENUMFTHinweisFunktion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
