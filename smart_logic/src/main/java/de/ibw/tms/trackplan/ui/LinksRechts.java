package de.ibw.tms.trackplan.ui;
/**
 * Verwaltet Lage zum Gleis in Bahnh&ouml;fen
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
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
