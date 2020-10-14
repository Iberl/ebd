//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.medien_und_trassen._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMTrasse_Nutzer.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMTrasse_Nutzer">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DB_Energie"/>
 *     &lt;enumeration value="DB_KT"/>
 *     &lt;enumeration value="DB_Netz"/>
 *     &lt;enumeration value="DB_StuS"/>
 *     &lt;enumeration value="Dritte"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="unbekannt"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMTrasse_Nutzer")
@XmlEnum
public enum ENUMTrasseNutzer {

    @XmlEnumValue("DB_Energie")
    DB_ENERGIE("DB_Energie"),
    DB_KT("DB_KT"),
    @XmlEnumValue("DB_Netz")
    DB_NETZ("DB_Netz"),
    @XmlEnumValue("DB_StuS")
    DB_STU_S("DB_StuS"),
    @XmlEnumValue("Dritte")
    DRITTE("Dritte"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("unbekannt")
    UNBEKANNT("unbekannt");
    private final String value;

    ENUMTrasseNutzer(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMTrasseNutzer fromValue(String v) {
        for (ENUMTrasseNutzer c: ENUMTrasseNutzer.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
