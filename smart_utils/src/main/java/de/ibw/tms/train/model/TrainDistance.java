package de.ibw.tms.train.model;
/**
 * Abstand des Zuges von einem Knoten einer Topologischen Kante.
 * Der Zug sollte sich auf dieser Kante befinden.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class TrainDistance {
    private boolean isfromA;
    private double dDistance1;
    private double dDistance2;

    /**
     * Generiert ein Abstand von einem Topologischen Knoten, der referenzierten Kante
     * @param isA boolean - Gibt an ob A der referenzierte Knoten ist oder B
     * @param d1 double Abstand zum Heck des Zuges
     * @param d2 double Abstand zur Zugnase
     */
    public TrainDistance(boolean isA, double d1, double d2) {
        this.isfromA = isA;
        this.dDistance1 = d1;
        this.dDistance2 = d2;

    }

    /**
     * Wird Abstand von Knoten a dann (true) gemessen oder von b dann (false
     * @return boolean
     */
    public boolean isIsfromA() {
        return isfromA;
    }

    /**
     * Abstand vom Heck des Zuges zum Referenzknoten
     * @return double
     */
    public double getdDistance1() {
        return dDistance1;
    }

    /**
     * Abstand von der Zugnase zum Referenzknoten
     * @return double
     */
    public double getdDistance2() {
        return dDistance2;
    }
}
