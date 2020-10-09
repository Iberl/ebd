//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMFMA_Komponente_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMFMA_Komponente_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Isolierstoss_zweischienig"/>
 *     &lt;enumeration value="Isolierstoss_einschienig"/>
 *     &lt;enumeration value="elektrischer_Trennstoss"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMFMA_Komponente_Art")
@XmlEnum
public enum ENUMFMAKomponenteArt {

    @XmlEnumValue("Isolierstoss_zweischienig")
    ISOLIERSTOSS_ZWEISCHIENIG("Isolierstoss_zweischienig"),
    @XmlEnumValue("Isolierstoss_einschienig")
    ISOLIERSTOSS_EINSCHIENIG("Isolierstoss_einschienig"),
    @XmlEnumValue("elektrischer_Trennstoss")
    ELEKTRISCHER_TRENNSTOSS("elektrischer_Trennstoss");
    private final String value;

    ENUMFMAKomponenteArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMFMAKomponenteArt fromValue(String v) {
        for (ENUMFMAKomponenteArt c: ENUMFMAKomponenteArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
