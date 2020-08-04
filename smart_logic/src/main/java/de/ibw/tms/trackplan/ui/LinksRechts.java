package de.ibw.tms.trackplan.ui;

public enum LinksRechts {
    LINKS("links"),
    RECHTS("rechts");
    private final String value;

    LinksRechts(String value) {
        this.value = value;
    }
    public static LinksRechts fromValue(String v) {
        for (LinksRechts c: LinksRechts.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
