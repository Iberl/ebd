//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basisobjekte._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBestandsrelevanz.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBestandsrelevanz">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Bestandsdaten"/>
 *     &lt;enumeration value="Bestandsdokumentation"/>
 *     &lt;enumeration value="dauerhaft"/>
 *     &lt;enumeration value="nein"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBestandsrelevanz")
@XmlEnum
public enum ENUMBestandsrelevanz {

    @XmlEnumValue("Bestandsdaten")
    BESTANDSDATEN("Bestandsdaten"),
    @XmlEnumValue("Bestandsdokumentation")
    BESTANDSDOKUMENTATION("Bestandsdokumentation"),
    @XmlEnumValue("dauerhaft")
    DAUERHAFT("dauerhaft"),
    @XmlEnumValue("nein")
    NEIN("nein");
    private final String value;

    ENUMBestandsrelevanz(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBestandsrelevanz fromValue(String v) {
        for (ENUMBestandsrelevanz c: ENUMBestandsrelevanz.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
