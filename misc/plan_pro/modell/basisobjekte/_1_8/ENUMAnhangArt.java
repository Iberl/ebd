//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.01.07 um 02:16:09 PM CET 
//


package modell.basisobjekte._1_8;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r ENUMAnhang_Art.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="ENUMAnhang_Art">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Abnahmeniederschrift"/>
 *     &lt;enumeration value="Anbindung_IB2"/>
 *     &lt;enumeration value="Anbindung_IB3"/>
 *     &lt;enumeration value="BAST"/>
 *     &lt;enumeration value="BELU"/>
 *     &lt;enumeration value="Benutzeroberflaeche"/>
 *     &lt;enumeration value="Bestaetig_Gleichstellung"/>
 *     &lt;enumeration value="Bestaetig_Qualitaetspruefung"/>
 *     &lt;enumeration value="Bestaetig_Uebernahme"/>
 *     &lt;enumeration value="Freigabe_Bvb"/>
 *     &lt;enumeration value="Genehmigung_AG_Bh_Bhv"/>
 *     &lt;enumeration value="Material_Besonders"/>
 *     &lt;enumeration value="Uebertragungswegeplan"/>
 *     &lt;enumeration value="DWS"/>
 *     &lt;enumeration value="Erlaeuterungsbericht"/>
 *     &lt;enumeration value="Planverzeichnis"/>
 *     &lt;enumeration value="Pruefbericht"/>
 *     &lt;enumeration value="Regelwerksstand_Besonders"/>
 *     &lt;enumeration value="VzG"/>
 *     &lt;enumeration value="ZN_Raumplan_Bedienraum"/>
 *     &lt;enumeration value="ZN_Raumplan_Rechnerraum"/>
 *     &lt;enumeration value="GEO"/>
 *     &lt;enumeration value="INA"/>
 *     &lt;enumeration value="Moebelaufstellplan_Aufriss"/>
 *     &lt;enumeration value="Moebelaufstellplan_Grundriss"/>
 *     &lt;enumeration value="Monitoraufteilung"/>
 *     &lt;enumeration value="Raumplan_Bedienraeume"/>
 *     &lt;enumeration value="Raumplan_Rechnerraeume"/>
 *     &lt;enumeration value="Richtungssinn"/>
 *     &lt;enumeration value="sonstige"/>
 *     &lt;enumeration value="Steuerbezirksuebersicht"/>
 *     &lt;enumeration value="UiG"/>
 *     &lt;enumeration value="Vorgabe"/>
 *     &lt;enumeration value="Vorgabe_GBT"/>
 *     &lt;enumeration value="ZiE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ENUMAnhang_Art")
@XmlEnum
public enum ENUMAnhangArt {

    @XmlEnumValue("Abnahmeniederschrift")
    ABNAHMENIEDERSCHRIFT("Abnahmeniederschrift"),
    @XmlEnumValue("Anbindung_IB2")
    ANBINDUNG_IB_2("Anbindung_IB2"),
    @XmlEnumValue("Anbindung_IB3")
    ANBINDUNG_IB_3("Anbindung_IB3"),
    BAST("BAST"),
    BELU("BELU"),
    @XmlEnumValue("Benutzeroberflaeche")
    BENUTZEROBERFLAECHE("Benutzeroberflaeche"),
    @XmlEnumValue("Bestaetig_Gleichstellung")
    BESTAETIG_GLEICHSTELLUNG("Bestaetig_Gleichstellung"),
    @XmlEnumValue("Bestaetig_Qualitaetspruefung")
    BESTAETIG_QUALITAETSPRUEFUNG("Bestaetig_Qualitaetspruefung"),
    @XmlEnumValue("Bestaetig_Uebernahme")
    BESTAETIG_UEBERNAHME("Bestaetig_Uebernahme"),
    @XmlEnumValue("Freigabe_Bvb")
    FREIGABE_BVB("Freigabe_Bvb"),
    @XmlEnumValue("Genehmigung_AG_Bh_Bhv")
    GENEHMIGUNG_AG_BH_BHV("Genehmigung_AG_Bh_Bhv"),
    @XmlEnumValue("Material_Besonders")
    MATERIAL_BESONDERS("Material_Besonders"),
    @XmlEnumValue("Uebertragungswegeplan")
    UEBERTRAGUNGSWEGEPLAN("Uebertragungswegeplan"),
    DWS("DWS"),
    @XmlEnumValue("Erlaeuterungsbericht")
    ERLAEUTERUNGSBERICHT("Erlaeuterungsbericht"),
    @XmlEnumValue("Planverzeichnis")
    PLANVERZEICHNIS("Planverzeichnis"),
    @XmlEnumValue("Pruefbericht")
    PRUEFBERICHT("Pruefbericht"),
    @XmlEnumValue("Regelwerksstand_Besonders")
    REGELWERKSSTAND_BESONDERS("Regelwerksstand_Besonders"),
    @XmlEnumValue("VzG")
    VZ_G("VzG"),
    @XmlEnumValue("ZN_Raumplan_Bedienraum")
    ZN_RAUMPLAN_BEDIENRAUM("ZN_Raumplan_Bedienraum"),
    @XmlEnumValue("ZN_Raumplan_Rechnerraum")
    ZN_RAUMPLAN_RECHNERRAUM("ZN_Raumplan_Rechnerraum"),
    GEO("GEO"),
    INA("INA"),
    @XmlEnumValue("Moebelaufstellplan_Aufriss")
    MOEBELAUFSTELLPLAN_AUFRISS("Moebelaufstellplan_Aufriss"),
    @XmlEnumValue("Moebelaufstellplan_Grundriss")
    MOEBELAUFSTELLPLAN_GRUNDRISS("Moebelaufstellplan_Grundriss"),
    @XmlEnumValue("Monitoraufteilung")
    MONITORAUFTEILUNG("Monitoraufteilung"),
    @XmlEnumValue("Raumplan_Bedienraeume")
    RAUMPLAN_BEDIENRAEUME("Raumplan_Bedienraeume"),
    @XmlEnumValue("Raumplan_Rechnerraeume")
    RAUMPLAN_RECHNERRAEUME("Raumplan_Rechnerraeume"),
    @XmlEnumValue("Richtungssinn")
    RICHTUNGSSINN("Richtungssinn"),
    @XmlEnumValue("sonstige")
    SONSTIGE("sonstige"),
    @XmlEnumValue("Steuerbezirksuebersicht")
    STEUERBEZIRKSUEBERSICHT("Steuerbezirksuebersicht"),
    @XmlEnumValue("UiG")
    UI_G("UiG"),
    @XmlEnumValue("Vorgabe")
    VORGABE("Vorgabe"),
    @XmlEnumValue("Vorgabe_GBT")
    VORGABE_GBT("Vorgabe_GBT"),
    @XmlEnumValue("ZiE")
    ZI_E("ZiE");
    private final String value;

    ENUMAnhangArt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ENUMAnhangArt fromValue(String v) {
        for (ENUMAnhangArt c: ENUMAnhangArt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
