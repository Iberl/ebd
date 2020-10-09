//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.weichen_und_gleissperren._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMGleissperrensignal.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMGleissperrensignal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="innenbeleuchtet_beidseitig"/>
 *     &lt;enumeration value="innenbeleuchtet_einseitig"/>
 *     &lt;enumeration value="reflektierend_beidseitig"/>
 *     &lt;enumeration value="reflektierend_einseitig"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMGleissperrensignal")
@XmlEnum
public enum ENUMGleissperrensignal {

    @XmlEnumValue("innenbeleuchtet_beidseitig")
    INNENBELEUCHTET_BEIDSEITIG("innenbeleuchtet_beidseitig"),
    @XmlEnumValue("innenbeleuchtet_einseitig")
    INNENBELEUCHTET_EINSEITIG("innenbeleuchtet_einseitig"),
    @XmlEnumValue("reflektierend_beidseitig")
    REFLEKTIEREND_BEIDSEITIG("reflektierend_beidseitig"),
    @XmlEnumValue("reflektierend_einseitig")
    REFLEKTIEREND_EINSEITIG("reflektierend_einseitig");
    private final String value;

    ENUMGleissperrensignal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMGleissperrensignal fromValue(String v) {
        for (ENUMGleissperrensignal c: ENUMGleissperrensignal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
