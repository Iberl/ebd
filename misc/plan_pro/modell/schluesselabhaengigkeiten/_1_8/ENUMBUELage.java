//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.schluesselabhaengigkeiten._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBUE_Lage.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Lage">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="geoeffnet"/>
 *     &lt;enumeration value="geschlossen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBUE_Lage")
@XmlEnum
public enum ENUMBUELage {

    @XmlEnumValue("geoeffnet")
    GEOEFFNET("geoeffnet"),
    @XmlEnumValue("geschlossen")
    GESCHLOSSEN("geschlossen");
    private final String value;

    ENUMBUELage(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUELage fromValue(String v) {
        for (ENUMBUELage c: ENUMBUELage.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
