//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.16 um 04:27:51 PM CET 
//


package plan_pro.modell.balisentechnik_etcs._1_9_0;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMETCS_Knoten_Art_Sonstige .
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMETCS_Knoten_Art_Sonstige ">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Gleisabschluss"/>
 *     &lt;enumeration value="Grenze_Ausruestungsbereich"/>
 *     &lt;enumeration value="KrW"/>
 *     &lt;enumeration value="Streckenende"/>
 *     &lt;enumeration value="Streckenwechsel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMETCS_Knoten_Art_Sonstige ")
@XmlEnum
public enum ENUMETCSKnotenArtSonstige_0020 {

    @XmlEnumValue("Gleisabschluss")
    GLEISABSCHLUSS("Gleisabschluss"),
    @XmlEnumValue("Grenze_Ausruestungsbereich")
    GRENZE_AUSRUESTUNGSBEREICH("Grenze_Ausruestungsbereich"),
    @XmlEnumValue("KrW")
    KR_W("KrW"),
    @XmlEnumValue("Streckenende")
    STRECKENENDE("Streckenende"),
    @XmlEnumValue("Streckenwechsel")
    STRECKENWECHSEL("Streckenwechsel");
    private final String value;

    ENUMETCSKnotenArtSonstige_0020(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMETCSKnotenArtSonstige_0020 fromValue(String v) {
        for (ENUMETCSKnotenArtSonstige_0020 c: ENUMETCSKnotenArtSonstige_0020 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
