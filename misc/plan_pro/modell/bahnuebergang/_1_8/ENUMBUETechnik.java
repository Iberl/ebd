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
 * <p>Java-Klasse f�r ENUMBUE_Technik.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMBUE_Technik">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Anrufschranke"/>
 *     &lt;enumeration value="BUEP_93"/>
 *     &lt;enumeration value="BUES_72D"/>
 *     &lt;enumeration value="BUES_72Z"/>
 *     &lt;enumeration value="BUES2000"/>
 *     &lt;enumeration value="EBUET_80"/>
 *     &lt;enumeration value="EBUET_80_VB"/>
 *     &lt;enumeration value="FUE_58"/>
 *     &lt;enumeration value="FUE_60"/>
 *     &lt;enumeration value="HL_64_B"/>
 *     &lt;enumeration value="HL_64_C"/>
 *     &lt;enumeration value="HS_64_B"/>
 *     &lt;enumeration value="HS_64_C"/>
 *     &lt;enumeration value="keine"/>
 *     &lt;enumeration value="LO1"/>
 *     &lt;enumeration value="LO1_57"/>
 *     &lt;enumeration value="NE_BUE_90"/>
 *     &lt;enumeration value="RBUET"/>
 *     &lt;enumeration value="SIMIS_LC"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMBUE_Technik")
@XmlEnum
public enum ENUMBUETechnik {

    @XmlEnumValue("Anrufschranke")
    ANRUFSCHRANKE("Anrufschranke"),
    BUEP_93("BUEP_93"),
    @XmlEnumValue("BUES_72D")
    BUES_72_D("BUES_72D"),
    @XmlEnumValue("BUES_72Z")
    BUES_72_Z("BUES_72Z"),
    @XmlEnumValue("BUES2000")
    BUES_2000("BUES2000"),
    EBUET_80("EBUET_80"),
    EBUET_80_VB("EBUET_80_VB"),
    FUE_58("FUE_58"),
    FUE_60("FUE_60"),
    HL_64_B("HL_64_B"),
    HL_64_C("HL_64_C"),
    HS_64_B("HS_64_B"),
    HS_64_C("HS_64_C"),
    @XmlEnumValue("keine")
    KEINE("keine"),
    @XmlEnumValue("LO1")
    LO_1("LO1"),
    @XmlEnumValue("LO1_57")
    LO_1_57("LO1_57"),
    NE_BUE_90("NE_BUE_90"),
    RBUET("RBUET"),
    SIMIS_LC("SIMIS_LC"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMBUETechnik(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMBUETechnik fromValue(String v) {
        for (ENUMBUETechnik c: ENUMBUETechnik.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
