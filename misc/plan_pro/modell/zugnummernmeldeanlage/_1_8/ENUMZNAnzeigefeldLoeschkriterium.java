//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.zugnummernmeldeanlage._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMZN_Anzeigefeld_Loeschkriterium.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMZN_Anzeigefeld_Loeschkriterium">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="automatisch_nach_30_s"/>
 *     &lt;enumeration value="Fahrstrasse_aufgeloest"/>
 *     &lt;enumeration value="Fortschaltung_beim_Nachbarn"/>
 *     &lt;enumeration value="haendisch"/>
 *     &lt;enumeration value="Rueckblock_eingegangen"/>
 *     &lt;enumeration value="sonstige"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMZN_Anzeigefeld_Loeschkriterium")
@XmlEnum
public enum ENUMZNAnzeigefeldLoeschkriterium {

    @XmlEnumValue("automatisch_nach_30_s")
    AUTOMATISCH_NACH_30_S("automatisch_nach_30_s"),
    @XmlEnumValue("Fahrstrasse_aufgeloest")
    FAHRSTRASSE_AUFGELOEST("Fahrstrasse_aufgeloest"),
    @XmlEnumValue("Fortschaltung_beim_Nachbarn")
    FORTSCHALTUNG_BEIM_NACHBARN("Fortschaltung_beim_Nachbarn"),
    @XmlEnumValue("haendisch")
    HAENDISCH("haendisch"),
    @XmlEnumValue("Rueckblock_eingegangen")
    RUECKBLOCK_EINGEGANGEN("Rueckblock_eingegangen"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige");
    private final String value;

    ENUMZNAnzeigefeldLoeschkriterium(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMZNAnzeigefeldLoeschkriterium fromValue(String v) {
        for (ENUMZNAnzeigefeldLoeschkriterium c: ENUMZNAnzeigefeldLoeschkriterium.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
