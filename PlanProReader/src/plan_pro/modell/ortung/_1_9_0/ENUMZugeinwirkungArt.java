//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.ortung._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMZugeinwirkung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMZugeinwirkung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Doppel_Schleife"/>
 *     &lt;enumeration value="Doppel_Sensor"/>
 *     &lt;enumeration value="Dreifach_Schleife"/>
 *     &lt;enumeration value="Einfach_Schleife"/>
 *     &lt;enumeration value="Einfach_Sensor"/>
 *     &lt;enumeration value="Isolierte_Schiene_alleinstehend"/>
 *     &lt;enumeration value="Isolierte_Schiene_FMA_Anlage_mitbenutzt"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMZugeinwirkung_Art")
@XmlEnum
public enum ENUMZugeinwirkungArt {

    @XmlEnumValue("Doppel_Schleife")
    DOPPEL_SCHLEIFE("Doppel_Schleife"),
    @XmlEnumValue("Doppel_Sensor")
    DOPPEL_SENSOR("Doppel_Sensor"),
    @XmlEnumValue("Dreifach_Schleife")
    DREIFACH_SCHLEIFE("Dreifach_Schleife"),
    @XmlEnumValue("Einfach_Schleife")
    EINFACH_SCHLEIFE("Einfach_Schleife"),
    @XmlEnumValue("Einfach_Sensor")
    EINFACH_SENSOR("Einfach_Sensor"),
    @XmlEnumValue("Isolierte_Schiene_alleinstehend")
    ISOLIERTE_SCHIENE_ALLEINSTEHEND("Isolierte_Schiene_alleinstehend"),
    @XmlEnumValue("Isolierte_Schiene_FMA_Anlage_mitbenutzt")
    ISOLIERTE_SCHIENE_FMA_ANLAGE_MITBENUTZT("Isolierte_Schiene_FMA_Anlage_mitbenutzt"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMZugeinwirkungArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMZugeinwirkungArt fromValue(String v) {
        for (ENUMZugeinwirkungArt c: ENUMZugeinwirkungArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
