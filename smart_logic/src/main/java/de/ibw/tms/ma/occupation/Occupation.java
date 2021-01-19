package de.ibw.tms.ma.occupation;

import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.net.elements.PositioningNetElement;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.positioned.elements.TrackArea;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.UtilFunction;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.TApplicationDirection;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.signale._1_9_0.CSignal;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
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
     * @Deprecated
     * Checkt diese Area (zum Beispiel als eine Balise mit Datenpunktbereich) ob sie sich im Grenzbereich einer Weiche sich befindet
     * @return ArrayList - Liste von Grenzbereichbetretungen - meist nur 0 oder 1 Elemente
     */
    public ArrayList<Occupation> getListOfEdgeLimits() {
        ArrayList<Occupation> resultArea = new ArrayList<>();
        /*if(Edge == null) return resultArea;
        if(checkIfBlockedAreaReachingToCrossoverLimits(this,Edge, Edge.A, true)) {
            resultArea.add(new Occupation(Edge.A, Edge.A.TopNodeId));
        }
        if(checkIfBlockedAreaReachingToCrossoverLimits(this,Edge, Edge.B, false)) {
            resultArea.add(new Occupation(Edge.B, Edge.B.TopNodeId));
        }*/
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

    }

    public void defineOccupatedSection(TopologyGraph.Edge e, TrackEdgeSection edgeSection, SpotLocationIntrinsic begin, SpotLocationIntrinsic end) {
        edgeSection.setTrackEdge(e);
        edgeSection.setBegin(begin);
        edgeSection.setEnd(end);
        List<TrackEdgeSection> edgeList = new ArrayList<>();
        edgeList.add(edgeSection);

        this.setTrackEdgeSections(edgeList);
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
        if(this instanceof MTERouteOccupation) {
            if(OtherArea instanceof MTERouteOccupation) {
                return compareMTE((MTERouteOccupation) OtherArea);
            } else return false;
        }
        List<TrackEdgeSection> tesList = this.getTrackEdgeSections();
        List<TrackEdgeSection> otherList = OtherArea.getTrackEdgeSections();
        if(tesList == null || otherList == null)
            throw new InvalidParameterException("Section Edges-List must not be null");
        if(tesList.size() == 0 || otherList.size() == 0) return false;
        for(TrackEdgeSection ThisSection : tesList) {
            for(TrackEdgeSection OtherSection : otherList) {
                if(ThisSection == null || OtherSection == null)
                    throw new InvalidParameterException("Sections must not be null");

                if(this.intersects(ThisSection, OtherSection)) return true;
            }
        }
        return false;


    }

    private boolean compareMTE(MTERouteOccupation otherArea) {
        MoveableTrackElement thisElement = ((MTERouteOccupation)this).getElement();
        return otherArea.getElement().equals(thisElement);

    }

    /**
     * @deprecated
     * @param otherArea
     * @return
     */
    private boolean handleNotHavingSameType(Occupation otherArea) {
        throw new NotImplementedException("Deprecated");
        /*Occupation EdgeArea = null;
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
        return false;*/
    }

    /**
     * @deprecated
     * Pr&uuml;ft ob die Straße zu einem Grenzsignal einer Weiche reicht
     * @param edgeArea {@link Occupation} - der blockierte Bereich
     * @param e TopologyGraph.Edge - die Kante selbst
     * @param n TopologyGraph.Node - der Knoten der auf ein Grenzsignal gepr&uuml;ft wird
     * @param checkIfConnectedByA - Boolean, ob a oder b geprüft wird
     * @return boolean ob ein Grenzsignalbereich betreten wird
     */
    private boolean checkIfBlockedAreaReachingToCrossoverLimits(Occupation edgeArea, TopologyGraph.Edge e, TopologyGraph.Node n, Boolean checkIfConnectedByA) {
       throw new NotImplementedException("deprecated");
        /*
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

         */
    }

    private Boolean checkifConnectedByA(TopologyGraph.Edge e, TopologyGraph.Node n) {
        if(e.A == n) return true;
        if(e.B == n) return false;
        return null;

    }

    private boolean intersects(TrackEdgeSection ThisSection, TrackEdgeSection OtherSection) {
        TrackEdge ThisEdge = ThisSection.getTrackEdge();
        TrackEdge OtherEdge = OtherSection.getTrackEdge();
        if(ThisEdge == null || OtherEdge == null) throw new InvalidParameterException("Edges must not be null");
        if(!ThisEdge.equals(OtherEdge)) return false;

        double iStart1 = ThisSection.getBegin().getIntrinsicCoord();
        double iEnd1 = ThisSection.getEnd().getIntrinsicCoord();
        double iStart2 = OtherSection.getBegin().getIntrinsicCoord();
        double iEnd2 = OtherSection.getEnd().getIntrinsicCoord();

        if(((iStart1 >= iStart2 || iEnd1 >= iStart2) && (iStart2 >= iStart1 || iEnd2 >= iStart1))) {
            System.out.println("iStart1: " + iStart1);
            System.out.println("iEnd1: " + iEnd1);
            System.out.println("iStart2: " + iStart2);
            System.out.println("iEnd2: " + iEnd2);

            return true;
        };
        return false;

    }

    /**
     * @deprecated
     * @param otherArea
     * @return
     */
    private boolean check4BeeingSameTrackElementType(Occupation otherArea) {
        throw new NotImplementedException("deprecated");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occupation that = (Occupation) o;
        return (that.getTrackEdgeSections().equals(((Occupation) o).getTrackEdgeSections()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getTrackEdgeSections());
    }
}
