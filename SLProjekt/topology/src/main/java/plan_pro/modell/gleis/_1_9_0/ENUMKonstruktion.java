//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.gleis._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMKonstruktion.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMKonstruktion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Feste_Fahrbahn"/>
 *     &lt;enumeration value="Schutzschiene_links"/>
 *     &lt;enumeration value="Schutzschiene_rechts"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMKonstruktion")
@XmlEnum
public enum ENUMKonstruktion {

    @XmlEnumValue("Feste_Fahrbahn")
    FESTE_FAHRBAHN("Feste_Fahrbahn"),
    @XmlEnumValue("Schutzschiene_links")
    SCHUTZSCHIENE_LINKS("Schutzschiene_links"),
    @XmlEnumValue("Schutzschiene_rechts")
    SCHUTZSCHIENE_RECHTS("Schutzschiene_rechts"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMKonstruktion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMKonstruktion fromValue(String v) {
        for (ENUMKonstruktion c: ENUMKonstruktion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
