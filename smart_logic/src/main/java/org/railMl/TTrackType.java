//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.10.13 um 12:01:23 PM CEST 
//


package org.railMl;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für tTrackType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="tTrackType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mainTrack"/>
 *     &lt;enumeration value="secondaryTrack"/>
 *     &lt;enumeration value="sidingTrack"/>
 *     &lt;enumeration value="connectingTrack"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tTrackType")
@XmlEnum
public enum TTrackType {


    /**
     * CH: Hauptgleis (signalisiertes Gleis)
     * CZ: Hlavní kolej
     * DE: durchgehendes Hauptgleis
     * NL: Hoofdspoorweg
     * NO: hovedspor
     * 
     */
    @XmlEnumValue("mainTrack")
    MAIN_TRACK("mainTrack"),

    /**
     * CZ: Spojovací kolej
     * DE: nicht-durchgehendes Hauptgleis
     * NL: Lokaalspoorweg
     * NO: øvrige
     * 
     */
    @XmlEnumValue("secondaryTrack")
    SECONDARY_TRACK("secondaryTrack"),

    /**
     * CH: Nebengleis (nicht-signalisiertes Gleis)
     * CZ: Manipulacní koleje
     * DE: Nebengleis
     * NL: Raccordement
     * NO: Sidespor
     * 
     */
    @XmlEnumValue("sidingTrack")
    SIDING_TRACK("sidingTrack"),

    /**
     * CZ: Kolejová spojka
     * DE: Gleisverbindung
     * NO: øvrige
     * 
     */
    @XmlEnumValue("connectingTrack")
    CONNECTING_TRACK("connectingTrack");
    private final String value;

    TTrackType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTrackType fromValue(String v) {
        for (TTrackType c: TTrackType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
