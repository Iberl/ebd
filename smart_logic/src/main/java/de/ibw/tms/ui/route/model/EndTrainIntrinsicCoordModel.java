package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.trackplan.ui.Route;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * Modell zum bestimmen des Ausmases der letzten Gleiskante
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-30
 *
 */
public class EndTrainIntrinsicCoordModel {

    private TopologyGraph.Edge LastEdge;
    private TopologyGraph.Edge PreviousEdge = null;
    private BigDecimal IntrinsicCoordSelected = BigDecimal.valueOf(0.0);
    private BigDecimal MinIntrinsicCoord;
    private BigDecimal MaxIntrinisicCoord;
    private RouteModel RM;
    private boolean isAbsoluteMode = true;
    private boolean isReverseMode = false;

    /**
     * Model zum Festelegen der Intrinsischen Koordinate
     * @param RouteMod - Die Route zu der die Koordinate bestimmt wird
     */
    public EndTrainIntrinsicCoordModel(RouteModel RouteMod) {
        RM = RouteMod;
        Route R = RM.getRoute();
        List<String> sEdges = R.getElementListIds();
        if(sEdges.size() >= 2) {
            // vorletzte Kante holen
            PreviousEdge = PlanData.EdgeIdLookupRepo.getModel(sEdges.get(sEdges.size() - 2));

        }
        LastEdge = PlanData.EdgeIdLookupRepo.getModel(sEdges.get(sEdges.size() - 1));
        setIntrinsicBounds();
    }

    private void setIntrinsicBounds() {
        if(PreviousEdge == null) {
            isAbsoluteMode = true;
            MinIntrinsicCoord = new BigDecimal("0.0");
            MaxIntrinisicCoord = new BigDecimal("1.0");
        } else {
            try {
                if(!TopologyGraph.getNodeBetweenTwoEdges(PreviousEdge,LastEdge).equals(LastEdge.getRefNode())){
                    // Zug kommt nicht vom Ref-Node der letzten Kante der Route
                    isReverseMode = true;
                    isAbsoluteMode = false;
                } else {
                    // Zum kommt vom Ref-Node
                    isReverseMode = false;
                    isAbsoluteMode = false;
                }
            } catch(InvalidParameterException IPE) {
                isAbsoluteMode = true;
            }
        }
        if(RM.getRoute() == null) {
            this.setIntrinsicCoordSelected(BigDecimal.valueOf(0));
        } else {
            this.setIntrinsicCoordSelected(BigDecimal.valueOf(RM.getRoute().getIntrinsicCoordOfTargetTrackEdge()));
        }

    }

    /**
     * gibt Knoten zurück der fuer die Intrinsische Koordinate die Bezugsrichtung darstellt
     * @return TopologyGraph.Node - Bezugsknoten der Intrinischen Koordinate
     */
    public TopologyGraph.Node getNodeBasedForIntrinsicCoord() {
        if(isAbsoluteMode || !isReverseMode) return LastEdge.getRefNode();
        // Referse Bezugsrichtung
        if(LastEdge.A.equals(LastEdge.getRefNode())) return LastEdge.B;
        return LastEdge.A;
    }

    /**
     * Wird vom Ref-Node oder von Zug-Richtung ausgegangen
     * @return true wenn nach dem Ref-Node ausgegangen wird
     *              - tritt auf wenn es nur eine Kante gibt
     *         false- Bezugsrichtung für Intrinsische Koordinate ist der Beginn-Knoten von dem der Zug einfaert.
     */
    public boolean isAbsoluteMode() {
        return isAbsoluteMode;
    }

    /**
     * Zug kommt im ReverseMode vom dem Ende der Kante, die nicht die Bezugsrichtung ist
     * @return - true: Ref-Node ist nicht die Einfahrt des Zuges auf die Kante
     *         - false Ref-Node und Zug-Einfahrt sind identisch
     */
    public boolean isReverseMode() {
        return isReverseMode;
    }



    public TopologyGraph.Edge getLastEdge() {
        return LastEdge;
    }

    public BigDecimal getIntrinsicCoordSelected() {
        return IntrinsicCoordSelected;
    }

    public void setIntrinsicCoordSelected(BigDecimal intrinsicCoordSelected) {
        IntrinsicCoordSelected = intrinsicCoordSelected;
    }
}
