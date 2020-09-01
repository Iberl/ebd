//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.bahnuebergang._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMBUE_Sicherungsart.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Sicherungsart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A_und_Lf"/>
 *     &lt;enumeration value="A_und_Sprechverbindung"/>
 *     &lt;enumeration value="Lz"/>
 *     &lt;enumeration value="LzH"/>
 *     &lt;enumeration value="LzH_2F"/>
 *     &lt;enumeration value="LzH_F"/>
 *     &lt;enumeration value="LzHH"/>
 *     &lt;enumeration value="LzV"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="P_und_Lf"/>
 *     &lt;enumeration value="schluesselabhaengig"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Ue"/>
 *     &lt;enumeration value="Ue_und_P"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBUE_Sicherungsart")
@XmlEnum
public enum ENUMBUESicherungsart {

    @XmlEnumValue("A_und_Lf")
    A_UND_LF("A_und_Lf"),
    @XmlEnumValue("A_und_Sprechverbindung")
    A_UND_SPRECHVERBINDUNG("A_und_Sprechverbindung"),
    @XmlEnumValue("Lz")
    LZ("Lz"),
    @XmlEnumValue("LzH")
    LZ_H("LzH"),
    @XmlEnumValue("LzH_2F")
    LZ_H_2_F("LzH_2F"),
    @XmlEnumValue("LzH_F")
    LZ_H_F("LzH_F"),
    @XmlEnumValue("LzHH")
    LZ_HH("LzHH"),
    @XmlEnumValue("LzV")
    LZ_V("LzV"),
    P("P"),
    @XmlEnumValue("P_und_Lf")
    P_UND_LF("P_und_Lf"),
    @XmlEnumValue("schluesselabhaengig")
    SCHLUESSELABHAENGIG("schluesselabhaengig"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Ue")
    UE("Ue"),
    @XmlEnumValue("Ue_und_P")
    UE_UND_P("Ue_und_P");
    private final String value;

    ENUMBUESicherungsart(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUESicherungsart fromValue(String v) {
        for (ENUMBUESicherungsart c: ENUMBUESicherungsart.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
