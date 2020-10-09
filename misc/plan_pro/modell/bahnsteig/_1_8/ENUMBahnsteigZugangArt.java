//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnsteig._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBahnsteig_Zugang_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBahnsteig_Zugang_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aufzug"/>
 *     &lt;enumeration value="Rampe"/>
 *     &lt;enumeration value="Treppe"/>
 *     &lt;enumeration value="Resi"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBahnsteig_Zugang_Art")
@XmlEnum
public enum ENUMBahnsteigZugangArt {

    @XmlEnumValue("Aufzug")
    AUFZUG("Aufzug"),
    @XmlEnumValue("Rampe")
    RAMPE("Rampe"),
    @XmlEnumValue("Treppe")
    TREPPE("Treppe"),
    @XmlEnumValue("Resi")
    RESI("Resi");
    private final String value;

    ENUMBahnsteigZugangArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBahnsteigZugangArt fromValue(String v) {
        for (ENUMBahnsteigZugangArt c: ENUMBahnsteigZugangArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
