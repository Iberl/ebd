//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.signale._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBeleuchtet.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBeleuchtet">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="angestrahlt"/>
 *     &lt;enumeration value="innenbeleuchtet"/>
 *     &lt;enumeration value="nein"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBeleuchtet")
@XmlEnum
public enum ENUMBeleuchtet {

    @XmlEnumValue("angestrahlt")
    ANGESTRAHLT("angestrahlt"),
    @XmlEnumValue("innenbeleuchtet")
    INNENBELEUCHTET("innenbeleuchtet"),
    @XmlEnumValue("nein")
    NEIN("nein");
    private final String value;

    ENUMBeleuchtet(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBeleuchtet fromValue(String v) {
        for (ENUMBeleuchtet c: ENUMBeleuchtet.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
