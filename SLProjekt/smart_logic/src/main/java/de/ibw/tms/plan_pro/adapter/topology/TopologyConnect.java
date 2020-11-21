package de.ibw.tms.plan_pro.adapter.topology;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Dieses Enum beschreibt welche Knoten-Konnektoren es geben kann
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
@XmlEnum
public enum TopologyConnect {

    ENDE("Ende"),
    ENDE_BESTDIG("Ende_Bestdig"),
    LINKS("Links"),
    RECHTS("Rechts"),
    SCHNITT("Schnitt"),
    SONSTIGE("sonstige"),
    SPITZE("Spitze"),
    VERBINDUNG("Verbindung");
    @XmlTransient
    private final String value;

    TopologyConnect(String v) {
        value = v;
    }

    /**
     * Gesetzter Wert des Enums als String
     * @return String
     */
    public String value() {
        return value;
    }

    /**
     * Zum Einlesen aus PlanPro-Gegenpart
     * @param v {@link String} - zum Einlesen
     * @return TopologyConnect - das Enum zum Eingabe-String
     */
    public static TopologyConnect fromValue(String v) {
        for (TopologyConnect c: TopologyConnect.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }


}
