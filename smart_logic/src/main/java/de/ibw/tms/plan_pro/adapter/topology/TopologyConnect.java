package de.ibw.tms.plan_pro.adapter.topology;

public enum TopologyConnect {

    ENDE("Ende"),
    ENDE_BESTDIG("Ende_Bestdig"),
    LINKS("Links"),
    RECHTS("Rechts"),
    SCHNITT("Schnitt"),
    SONSTIGE("sonstige"),
    SPITZE("Spitze"),
    VERBINDUNG("Verbindung");
    private final String value;

    TopologyConnect(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TopologyConnect fromValue(String v) {
        for (TopologyConnect c: TopologyConnect.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }


}
