//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.schluesselabhaengigkeiten._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBedienung_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBedienung_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="aussen"/>
 *     &lt;enumeration value="aussen_Awanst"/>
 *     &lt;enumeration value="innen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBedienung_Art")
@XmlEnum
public enum ENUMBedienungArt {

    @XmlEnumValue("aussen")
    AUSSEN("aussen"),
    @XmlEnumValue("aussen_Awanst")
    AUSSEN_AWANST("aussen_Awanst"),
    @XmlEnumValue("innen")
    INNEN("innen");
    private final String value;

    ENUMBedienungArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBedienungArt fromValue(String v) {
        for (ENUMBedienungArt c: ENUMBedienungArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
