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

public class CrossoverModel {




    public static DefaultRepo<TopologyGraph.Node, CrossoverModel> CrossoverRepo = new DefaultRepo<>();
    public static DefaultRepo<ControlledTrackElement, CrossoverModel> BranchToCrossoverModelRepo = new DefaultRepo<>();

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


    public CrossoverModel(TopologyGraph.Node node, TopologyConnect topConnect, SingleSlip railWaySlip, BranchingSwitch railWaySwitch) {
        Node = node;
        TopConnect = topConnect;
        RailWaySlip = railWaySlip;
        RailWaySwitch = railWaySwitch;
        CrossoverRepo.update(node, this);
        // Maps an Branching element in UI to this Branch Model
        BranchToCrossoverModelRepo.update(railWaySlip.getRemotePoint(),this);



    }


    public void createPositionedRelation() {
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
        this.RailWaySlip.setOutputRelation(PosRelationA);


    }

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

    public SingleSlip getRailWaySlip() {
        return RailWaySlip;
    }
}
