//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bedienung._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMOberflaeche_Bildart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMOberflaeche_Bildart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BERUE"/>
 *     &lt;enumeration value="Lupe"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMOberflaeche_Bildart")
@XmlEnum
public enum ENUMOberflaecheBildart {

    BERUE("BERUE"),
    @XmlEnumValue("Lupe")
    LUPE("Lupe");
    private final String value;

    ENUMOberflaecheBildart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMOberflaecheBildart fromValue(String v) {
        for (ENUMOberflaecheBildart c: ENUMOberflaecheBildart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
