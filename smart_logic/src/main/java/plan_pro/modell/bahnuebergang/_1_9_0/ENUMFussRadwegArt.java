//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.bahnuebergang._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFuss_Radweg_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFuss_Radweg_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Fuss_Radweg_abgesetzt"/>
 *     &lt;enumeration value="Fuss_Radweg_parallel"/>
 *     &lt;enumeration value="Fussweg_abgesetzt"/>
 *     &lt;enumeration value="Fussweg_parallel"/>
 *     &lt;enumeration value="Radweg_abgesetzt"/>
 *     &lt;enumeration value="Radweg_parallel"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFuss_Radweg_Art")
@XmlEnum
public enum ENUMFussRadwegArt {

    @XmlEnumValue("Fuss_Radweg_abgesetzt")
    FUSS_RADWEG_ABGESETZT("Fuss_Radweg_abgesetzt"),
    @XmlEnumValue("Fuss_Radweg_parallel")
    FUSS_RADWEG_PARALLEL("Fuss_Radweg_parallel"),
    @XmlEnumValue("Fussweg_abgesetzt")
    FUSSWEG_ABGESETZT("Fussweg_abgesetzt"),
    @XmlEnumValue("Fussweg_parallel")
    FUSSWEG_PARALLEL("Fussweg_parallel"),
    @XmlEnumValue("Radweg_abgesetzt")
    RADWEG_ABGESETZT("Radweg_abgesetzt"),
    @XmlEnumValue("Radweg_parallel")
    RADWEG_PARALLEL("Radweg_parallel"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMFussRadwegArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFussRadwegArt fromValue(String v) {
        for (ENUMFussRadwegArt c: ENUMFussRadwegArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
