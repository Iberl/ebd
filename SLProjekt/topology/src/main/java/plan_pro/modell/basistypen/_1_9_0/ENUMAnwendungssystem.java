//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.basistypen._1_9_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMAnwendungssystem.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMAnwendungssystem">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ESG"/>
 *     &lt;enumeration value="GNT"/>
 *     &lt;enumeration value="L2"/>
 *     &lt;enumeration value="L2oS"/>
 *     &lt;enumeration value="LZB"/>
 *     &lt;enumeration value="ohne"/>
 *     &lt;enumeration value="PZB"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="ZBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMAnwendungssystem")
@XmlEnum
public enum ENUMAnwendungssystem {

    ESG("ESG"),
    GNT("GNT"),
    @XmlEnumValue("L2")
    L_2("L2"),
    @XmlEnumValue("L2oS")
    L_2_O_S("L2oS"),
    LZB("LZB"),
    @XmlEnumValue("ohne")
    OHNE("ohne"),
    PZB("PZB"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    ZBS("ZBS");
    private final String value;

    ENUMAnwendungssystem(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMAnwendungssystem fromValue(String v) {
        for (ENUMAnwendungssystem c: ENUMAnwendungssystem.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
