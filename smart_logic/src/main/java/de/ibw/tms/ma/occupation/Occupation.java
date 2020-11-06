package de.ibw.tms.ma.occupation;

import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.positioned.elements.TrackArea;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.UtilFunction;
import org.railMl.rtm4rail.TApplicationDirection;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.signale._1_9_0.CSignal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Diese Klasse stellt Blockierte Gleisabschnitte dar.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class Occupation extends TrackArea {
    public static final String CLASS_IDENTIFIER = "Occupation";


    /**
     * Checkt diese Area (zum Beispiel als eine Balise mit Datenpunktbereich) ob sie sich im Grenzbereich einer Weiche sich befindet
     * @return ArrayList - Liste von Grenzbereichbetretungen - meist nur 0 oder 1 Elemente
     */
    public ArrayList<Occupation> getListOfEdgeLimits() {
        ArrayList<Occupation> resultArea = new ArrayList<>();
        if(Edge == null) return resultArea;
        if(checkIfBlockedAreaReachingToCrossoverLimits(this,Edge, Edge.A, true)) {
            resultArea.add(new Occupation(Edge.A, Edge.A.TopNodeId));
        }
        if(checkIfBlockedAreaReachingToCrossoverLimits(this,Edge, Edge.B, false)) {
            resultArea.add(new Occupation(Edge.B, Edge.B.TopNodeId));
        }
        return resultArea;
    }

    /**
     * Dieser Datentyp ist die Einheit der zugeordneten Distanzen von 10CM , 1M und 10M kann verwendet werden
     */
    public enum BLOCK_Q_SCALE {

        Q_SCALE_10CM(0), Q_SCALE_1M(1), Q_SCALE_10M(2);

        private final int iScaleValue;

        BLOCK_Q_SCALE (int i_scale) {
            this.iScaleValue = i_scale;
        }

        public int getiScaleValue() {
            return iScaleValue;
        }
    }

    /**
     * Single Element beeing blocked
     * it can not a track and an element be blocked in one Blocked Area
     */
    private PositioningNetElement BlockedElement;

    /**
     * Node Id of Single Element beeing blocked
     */
    private String sIdOfElement;




    public Occupation(String sName) {
        super(sName);

    }




    /**
     * Dieser Konstruktor instanziiiert eine Sperrzone auf einer Kante E von einem Startpunkt bis zu einem Endpunkt
     * @param E Edge beeing blocked
     * @param Start_Ma - Q_Scale Start
     * @param d_A_to_Block_Start - Distance a to Ma- or Block-Start
     * @param End_Ma - Q_Scale End
     * @param d_A_to_Block_End - Distence to Ma- or Block-End
     */
    public Occupation(TopologyGraph.Edge E, BLOCK_Q_SCALE Start_Ma, int d_A_to_Block_Start, BLOCK_Q_SCALE End_Ma,
                      int d_A_to_Block_End,String sOccname) {
        super(sOccname);
        initOccupation(E, Start_Ma, d_A_to_Block_Start, End_Ma, d_A_to_Block_End);

    }

    public void initOccupation(TopologyGraph.Edge e, BLOCK_Q_SCALE start_Ma, int d_A_to_Block_Start, BLOCK_Q_SCALE end_Ma, int d_A_to_Block_End) {
        this.setApplicationDirection(TApplicationDirection.BOTH);
        TrackEdgeSection EdgeSection = new TrackEdgeSection();
        SpotLocationIntrinsic begin = new SpotLocationIntrinsic();
        SpotLocationIntrinsic end = new SpotLocationIntrinsic();
        initEdgeSections(e, start_Ma, d_A_to_Block_Start, end_Ma, d_A_to_Block_End, EdgeSection, begin, end);
    }

    public void initEdgeSections(TopologyGraph.Edge e, BLOCK_Q_SCALE start_Ma, int d_A_to_Block_Start, BLOCK_Q_SCALE end_Ma, int d_A_to_Block_End, TrackEdgeSection edgeSection, SpotLocationIntrinsic begin, SpotLocationIntrinsic end) {
        begin.setIntrinsicCoord(UtilFunction.generateIntrinsic(e.dTopLength, start_Ma, d_A_to_Block_Start));
        end.setIntrinsicCoord(UtilFunction.generateIntrinsic(e.dTopLength, end_Ma, d_A_to_Block_End));
        defineOccupatedSection(e, edgeSection, begin, end);
        List<TrackEdgeSection> edgeList = new ArrayList<>();
        edgeList.add(edgeSection);

        this.setTrackEdgeSections(edgeList);
    }

    public void defineOccupatedSection(TopologyGraph.Edge e, TrackEdgeSection edgeSection, SpotLocationIntrinsic begin, SpotLocationIntrinsic end) {
        edgeSection.setTrackEdge(e);
        edgeSection.setBegin(begin);
        edgeSection.setEnd(end);
    }


    /**
     * Pr&uuml;ft ob sid blockiert ist.
     * @param sId
     * @return boolean if is locked
     */
    public boolean isSidBlocked(String sId) {
        if (this.sIdOfElement == null) return false;
        else return this.sIdOfElement.equals(sId);
    }

    /**
     * Vergleicht gefahren Punkte zweier BlockedAreas
     * @param OtherArea {@link Occupation} Vergleichsobjekt
     * @return boolean - gibt an ob Gefahrenpunkte bestehen
     */
    public boolean compareIfIntersection(Occupation OtherArea) {
            
        if(this.Edge == null) {
                // both are no RailsType
                TopologyGraph.Node thisNode = (TopologyGraph.Node) this.BlockedElement;
                TopologyGraph.Node N2 = (TopologyGraph.Node) OtherArea.BlockedElement;
                // same -> then there oul be an intersection on node
                return thisNode.TopNodeId.equals(N2.TopNodeId);

            } else {

                if(!this.Edge.sId.equals(OtherArea.Edge.sId)) return false;
                else return this.intersects(this, OtherArea);


            }
    }


    private boolean handleNotHavingSameType(Occupation otherArea) {
        Occupation EdgeArea = null;
        TopologyGraph.Edge E = null;
        TopologyGraph.Node N = null;
        if(this.Edge == null) {
            E = otherArea.Edge;
            N = (TopologyGraph.Node) this.BlockedElement;
            EdgeArea = otherArea;
        } else {
            E = this.Edge;
            N = (TopologyGraph.Node) otherArea.BlockedElement;
            EdgeArea = this;
        }
        // checkIf Connected By A is null if there is no connection
        Boolean checkIfConnectedByA = checkifConnectedByA(E, N);
        if(checkIfConnectedByA == null) return false; // no Intersection
        try {
            if (checkIfBlockedAreaReachingToCrossoverLimits(EdgeArea, E, N, checkIfConnectedByA))
                return true; // Weichenabschnitt belegt intersection true

        } catch(Exception Except) {
            return true;
        }
        return false;
    }

    /**
     * Pr&uuml;ft ob die Straße zu einem Grenzsignal einer Weiche reicht
     * @param edgeArea {@link Occupation} - der blockierte Bereich
     * @param e TopologyGraph.Edge - die Kante selbst
     * @param n TopologyGraph.Node - der Knoten der auf ein Grenzsignal gepr&uuml;ft wird
     * @param checkIfConnectedByA - Boolean, ob a oder b geprüft wird
     * @return boolean ob ein Grenzsignalbereich betreten wird
     */
    private boolean checkIfBlockedAreaReachingToCrossoverLimits(Occupation edgeArea, TopologyGraph.Edge e, TopologyGraph.Node n, Boolean checkIfConnectedByA) {
        CrossingSwitch CS = (CrossingSwitch) n.NodeImpl;
        if(CS == null) return false;

        CSignal Sig = CS.getSignal();
        BigDecimal dSigDistanceToA;
        for(CPunktObjektTOPKante CTopKante : Sig.getPunktObjektTOPKante()) {
            if(CTopKante.getIDTOPKante().getWert().equals(e.sId)) {
                Occupation BA = CS.getInsecureAreAtGivenEdge(e);


                if(BA.compareIfIntersection(edgeArea)) return true;
            }
        }
        return false;
    }

    private Boolean checkifConnectedByA(TopologyGraph.Edge e, TopologyGraph.Node n) {
        if(e.A == n) return true;
        if(e.B == n) return false;
        return null;

    }

    private boolean intersects(Occupation occupation, Occupation otherArea) {

        int iStart1 = (int) (occupation.d_from_PointA_of_GeoEdge_to_BlockStartMa * Math.pow(10, occupation.q_scale_block_To_StartMa.getiScaleValue()-1));
        int iEnd1 = (int) (occupation.d_from_PointA_of_GeoEdge_to_BlockEndMa * Math.pow(10, occupation.q_scale_block_To_EndMa.getiScaleValue()-1) );
        int iStart2 = (int) (otherArea.d_from_PointA_of_GeoEdge_to_BlockStartMa * Math.pow(10, otherArea.q_scale_block_To_StartMa.getiScaleValue()-1));
        int iEnd2 = (int) (otherArea.d_from_PointA_of_GeoEdge_to_BlockEndMa * Math.pow(10, otherArea.q_scale_block_To_EndMa.getiScaleValue()-1));

        if(((iStart1 >= iStart2 || iEnd1 >= iStart2) && (iStart2 >= iStart1 || iEnd2 >= iStart1))) {
            System.out.println("iStart1: " + iStart1);
            System.out.println("iEnd1: " + iEnd1);
            System.out.println("iStart2: " + iStart2);
            System.out.println("iEnd2: " + iEnd2);

            return true;
        };
        return false;

    }

    private boolean check4BeeingSameTrackElementType(Occupation otherArea) {
        if(this.Edge == null && otherArea.Edge != null) return false;
        if(otherArea != null && otherArea.Edge == null) return false;
        return true;
        // returns true when its same rail or both ar not a rail

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occupation that = (Occupation) o;
        return d_from_PointA_of_GeoEdge_to_BlockStartMa == that.d_from_PointA_of_GeoEdge_to_BlockStartMa &&
                d_from_PointA_of_GeoEdge_to_BlockEndMa == that.d_from_PointA_of_GeoEdge_to_BlockEndMa &&
                Objects.equals(sIdOfElement, that.sIdOfElement) &&
                q_scale_block_To_StartMa == that.q_scale_block_To_StartMa &&
                q_scale_block_To_EndMa == that.q_scale_block_To_EndMa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sIdOfElement, q_scale_block_To_StartMa, d_from_PointA_of_GeoEdge_to_BlockStartMa, q_scale_block_To_EndMa, d_from_PointA_of_GeoEdge_to_BlockEndMa);
    }
}
