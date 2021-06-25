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
 * <p>Java-Klasse f�r ENUMUebertragungsweg_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMUebertragungsweg_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bahnuebergang"/>
 *     &lt;enumeration value="Diagnose"/>
 *     &lt;enumeration value="ESTW"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMUebertragungsweg_Art")
@XmlEnum
public enum ENUMUebertragungswegArt {

    @XmlEnumValue("Bahnuebergang")
    BAHNUEBERGANG("Bahnuebergang"),
    @XmlEnumValue("Diagnose")
    DIAGNOSE("Diagnose"),
    ESTW("ESTW"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    ZBS("ZBS");
    private final String value;

    ENUMUebertragungswegArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMUebertragungswegArt fromValue(String v) {
        for (ENUMUebertragungswegArt c: ENUMUebertragungswegArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
