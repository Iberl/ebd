//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.flankenschutz._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMZwieschutz_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMZwieschutz_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="echt"/>
 *     &lt;enumeration value="echt_eigen"/>
 *     &lt;enumeration value="eigen"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMZwieschutz_Art")
@XmlEnum
public enum ENUMZwieschutzArt {

    @XmlEnumValue("echt")
    ECHT("echt"),
    @XmlEnumValue("echt_eigen")
    ECHT_EIGEN("echt_eigen"),
    @XmlEnumValue("eigen")
    EIGEN("eigen");
    private final String value;

    ENUMZwieschutzArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMZwieschutzArt fromValue(String v) {
        for (ENUMZwieschutzArt c: ENUMZwieschutzArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}