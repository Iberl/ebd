package de.ibw.tms.plan.elements;

import de.ibw.tms.ma.physical.ControlledTrackElement;
import de.ibw.tms.ma.physical.SingleSlip;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.ma.topologie.PositionedRelation;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.DefaultRepo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Branching Switch ein Modell einer Weiche Logischer Art.
 * Verbindet das Geographische Modell der Weiche {@link BranchingSwitch} mit dem Topologischen {@link de.ibw.tms.plan_pro.adapter.topology.TopologyGraph.Node}
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class CrossoverModel {

    /**
     * Ein Repository das einen topologischen Knoten als key hat und diese Vermittlung als Value widergibt.
     */
    public static DefaultRepo<TopologyGraph.Node, CrossoverModel> CrossoverRepo = new DefaultRepo<>();
    /**
     * Ein Repository das den Schlupf als key hat und diese Vermittlung als Value widergibt.
     */
    public static DefaultRepo<ControlledTrackElement, CrossoverModel> BranchToCrossoverModelRepo = new DefaultRepo<>();

    /**
     * Factory Method dieser Vermittlung
     * @param node {@link TopologyGraph.Node } - Topologische Knoten
     * @param topConnect - {@link TopologyConnect} Anschlussart an diese Weiche - Rechts-Links oder Spitze
     * @param railWaySlip {@link SingleSlip} - Schlupf dieser weiche
     * @param railWaySwitch {@link BranchingSwitch} - Geographische Model der Weiche
     */
    public static void createCrossoverModel(TopologyGraph.Node node, TopologyConnect topConnect, SingleSlip railWaySlip, BranchingSwitch railWaySwitch) {
        new CrossoverModel(node, topConnect, railWaySlip, railWaySwitch);
    }

    private TopologyGraph.Node Node;
    private TopologyConnect TopConnect;
    private SingleSlip RailWaySlip;
    private BranchingSwitch RailWaySwitch;
    private PositionedRelation PosRelationA;
    private PositionedRelation PosRelationB;
    private Rail PeekRail = null;


    private CrossoverModel(TopologyGraph.Node node, TopologyConnect topConnect, SingleSlip railWaySlip, BranchingSwitch railWaySwitch) {
        Node = node;
        TopConnect = topConnect;
        RailWaySlip = railWaySlip;
        RailWaySwitch = railWaySwitch;
        CrossoverRepo.update(node, this);
        // Maps an Branching element in UI to this Branch Model
        BranchToCrossoverModelRepo.update(railWaySlip.getRemotePoint(),this);



    }

    /**
     * Verlinkt die Gleise mit dieser Weiche
     */
    public void createPositionedRelation() {
        boolean isIndex_0_RightPosition = false;
        HashSet<TopologyGraph.Edge> edges = this.Node.inEdges;
        ArrayList<TopologyGraph.Edge> notPeekEdges = null;
        edges.addAll(this.Node.outEdges);
        notPeekEdges = new ArrayList<>(edges);
        TopologyGraph.Edge PeekEdge = getPeekEdge(edges);
        PeekRail = PeekEdge.getRail();
        this.RailWaySwitch.setPeekRail(PeekRail);
        this.RailWaySwitch.setNode(this.getNode());
        notPeekEdges.remove(PeekEdge);
        Rail RailA = notPeekEdges.get(0).getRail();
        Rail RailB = notPeekEdges.get(1).getRail();
        try {
            isIndex_0_RightPosition = checkCrossingSwitchIsFirstRight(notPeekEdges);
        } catch (Exception e) {
            e.printStackTrace();
            isIndex_0_RightPosition = true;
        }


        PosRelationA = new PositionedRelation();
        PosRelationA.createPositionedRelation((TrackElement) this.RailWaySwitch.getBranchingPoint(),
                PeekRail.getTrailModel(), RailA.getTrailModel(), true, PlanData.vmax, ApplicationDirection.BOTH,
                    new TrackElementStatus()
            );
        PosRelationB = new PositionedRelation();
        PosRelationB.createPositionedRelation((TrackElement) this.RailWaySwitch.getBranchingPoint(),
                PeekRail.getTrailModel(), RailB.getTrailModel(), true, PlanData.vmax, ApplicationDirection.BOTH,
                new TrackElementStatus()
        );
        List<PositionedRelation> list = new ArrayList<PositionedRelation>();
        list.add(PosRelationA);
        list.add(PosRelationB);
        this.RailWaySlip.updatePositionedRelation(list);
        if(isIndex_0_RightPosition) {
            this.RailWaySlip.getRemotePoint().setRightPosition(PosRelationA);
            this.RailWaySlip.getRemotePoint().setLeftPosition(PosRelationB);
        } else {
            this.RailWaySlip.getRemotePoint().setRightPosition(PosRelationB);
            this.RailWaySlip.getRemotePoint().setLeftPosition(PosRelationA);
        }
        this.RailWaySlip.setOutputRelation(PosRelationA);


    }

    private boolean checkCrossingSwitchIsFirstRight(ArrayList<TopologyGraph.Edge> notPeekEdges) throws Exception {
        TopologyGraph.Node N = this.Node;
        TopologyGraph.Edge E =  notPeekEdges.get(0);
            if(E.A.equals(N)) {
                if(E.TopConnectFromA.equals(TopologyConnect.RECHTS)) return true;
                else return false;
            } else {
                if(E.TopConnectFromB.equals(TopologyConnect.RECHTS)) return false;
                else return true;
            }



    }




    /**
     * Gibt die Topologische Weiche wider
     * @return TopologyGraph.Node - Widergabe des Knoten
     */
    public TopologyGraph.Node getNode() {
        return Node;
    }

    private TopologyGraph.Edge getPeekEdge(HashSet<TopologyGraph.Edge> edges) {
        for(TopologyGraph.Edge E: edges) {
            if(E.A == this.Node && E.TopConnectFromA.equals(TopologyConnect.SPITZE)) {
                return E;
            }
            if(E.B == this.Node && E.TopConnectFromB.equals(TopologyConnect.SPITZE)) {
                return E;
            }
        }
        throw new InvalidParameterException("No Peek found. Maybe no Crossroad");

    }

    /**
     * Gibt den Schlupf der Weiche wider
     * @return SingleSlip - Schlupf dieser Weiche
     */
    public SingleSlip getRailWaySlip() {
        return RailWaySlip;
    }
}
