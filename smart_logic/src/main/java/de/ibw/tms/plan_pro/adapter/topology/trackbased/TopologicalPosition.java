package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import java.math.BigDecimal;
/**
 * Speichert topologische Positionsdaten mit Gleis-Id und Topologischen Abstand zum Knoten A
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-10-09
 */
public class TopologicalPosition {
    /**
     * PlanPro-String-Id der Topologischen Kante
     */
    private String sIdTopEdge;

    /**
     * Distanz zum A Knoten der Topologischen Kante mit Id sIdTopEdge
     */
    private BigDecimal dDistanceToTopNodeA;

    public TopologicalPosition(String sIdTopEdge, BigDecimal dDistanceToTopNodeA) {
        this.sIdTopEdge = sIdTopEdge;
        this.dDistanceToTopNodeA = dDistanceToTopNodeA;
    }

    public String getsIdTopEdge() {
        return sIdTopEdge;
    }

    public BigDecimal getdDistanceToTopNodeA() {
        return dDistanceToTopNodeA;
    }
}
