//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basistypen._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMRegionalbereich.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMRegionalbereich">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Mitte"/>
 *     &lt;enumeration value="Nord"/>
 *     &lt;enumeration value="Ost"/>
 *     &lt;enumeration value="S�d"/>
 *     &lt;enumeration value="S�dost"/>
 *     &lt;enumeration value="S�dwest"/>
 *     &lt;enumeration value="West"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMRegionalbereich")
@XmlEnum
public enum ENUMRegionalbereich {

    @XmlEnumValue("Mitte")
    MITTE("Mitte"),
    @XmlEnumValue("Nord")
    NORD("Nord"),
    @XmlEnumValue("Ost")
    OST("Ost"),
    @XmlEnumValue("Sued")
    SUED("Sued"),
    @XmlEnumValue("Suedost")
    SUEDOST("Suedost"),
    @XmlEnumValue("Suedwest")
    SUEDWEST("Suedwest"),
    @XmlEnumValue("West")
    WEST("West");
    private final String value;

    ENUMRegionalbereich(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMRegionalbereich fromValue(String v) {
        for (ENUMRegionalbereich c: ENUMRegionalbereich.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
