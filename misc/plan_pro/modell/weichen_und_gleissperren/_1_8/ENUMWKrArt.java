//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.weichen_und_gleissperren._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMW_Kr_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMW_Kr_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ABW"/>
 *     &lt;enumeration value="DKW"/>
 *     &lt;enumeration value="DW"/>
 *     &lt;enumeration value="EKW"/>
 *     &lt;enumeration value="EW"/>
 *     &lt;enumeration value="Flachkreuzung"/>
 *     &lt;enumeration value="IBW"/>
 *     &lt;enumeration value="Klothoidenweiche"/>
 *     &lt;enumeration value="Kr"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMW_Kr_Art")
@XmlEnum
public enum ENUMWKrArt {

    ABW("ABW"),
    DKW("DKW"),
    DW("DW"),
    EKW("EKW"),
    EW("EW"),
    @XmlEnumValue("Flachkreuzung")
    FLACHKREUZUNG("Flachkreuzung"),
    IBW("IBW"),
    @XmlEnumValue("Klothoidenweiche")
    KLOTHOIDENWEICHE("Klothoidenweiche"),
    @XmlEnumValue("Kr")
    KR("Kr"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMWKrArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMWKrArt fromValue(String v) {
        for (ENUMWKrArt c: ENUMWKrArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
