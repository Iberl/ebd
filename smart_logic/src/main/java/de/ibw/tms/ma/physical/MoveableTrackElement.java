package de.ibw.tms.ma.physical;

import de.ibw.rtm.intf.IRTMEntityLocation;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.positioned.elements.AllocationSection;
import de.ibw.tms.ma.positioned.elements.DriveProtectionSection;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan.NodeInformation;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import org.railMl.rtm4rail.TApplicationDirection;
import plan_pro.modell.basisobjekte._1_9_0.CPunktObjektTOPKante;
import plan_pro.modell.signale._1_9_0.CSignal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * Stellbare Elemente wie Weichen
 */
public class MoveableTrackElement extends ControlledElement {
    public static final String CLASS_IDENTIFIER = "Moveable_Track_Element";

    private static ArrayList<TrackElementStatus> DefaultEwStates;
    private static ArrayList<TrackElementStatus> DefaultDkwStates;


    public static ArrayList<TrackElementStatus> getEwPossibleStates() {
        if(DefaultEwStates == null) {
            DefaultEwStates = new ArrayList<>();
            ArrayList<TrackElementStatus.Status> basicStatus = new ArrayList<>();
            basicStatus.add(TrackElementStatus.Status.UNKNOWN);
            basicStatus.add(TrackElementStatus.Status.LEFT);
            basicStatus.add(TrackElementStatus.Status.RIGHT);

            for(TrackElementStatus.Status Stat : basicStatus) {
                TrackElementStatus S = new TrackElementStatus();
                S.statusList.add(Stat);
                DefaultEwStates.add(S);
            }
        }
        return DefaultEwStates;

    }

    public static ArrayList<TrackElementStatus> getDkwPossibleStates() {
        if(DefaultDkwStates == null) {
            DefaultDkwStates = new ArrayList<>();
            ArrayList<TrackElementStatus.Status> basicStatus = new ArrayList<>();

            basicStatus.add(TrackElementStatus.Status.LEFT);
            basicStatus.add(TrackElementStatus.Status.RIGHT);
            TrackElementStatus UnknownState = new TrackElementStatus();
            UnknownState.statusList.add(0, TrackElementStatus.Status.UNKNOWN);
            UnknownState.statusList.add(1, TrackElementStatus.Status.UNKNOWN);
            DefaultDkwStates.add(UnknownState);
            for(TrackElementStatus.Status S1 : basicStatus) {
                for(TrackElementStatus.Status S2 : basicStatus) {
                    TrackElementStatus State = new TrackElementStatus();
                    State.statusList.add(0, S1);
                    State.statusList.add(1, S2);
                    DefaultDkwStates.add(State);
                }
            }

        }
        return DefaultDkwStates;
    }


    /**
     * Generiert einen Bewegbares Track-Elment
     * @param sLabel
     * @param operationTime int - in ms
     * @param ChaBeginn
     * @param ChaEnd
     * @param locationList - z.B. Intrinsische Koordinaten
     * @param Switch - Composit PlanPro Object
     * @return MoveableTrackElement
     */
    public static MoveableTrackElement genmMoveableElementFactory(String sLabel, int operationTime, Chainage ChaBeginn, Chainage ChaEnd,
                                                                  List<IRTMEntityLocation> locationList,
                                                                  ArrayList<TrackElementStatus> listOfPossibleStatus,
                                                                  TrackElementStatus Current, CrossingSwitch Switch) {
        guardOpTime(operationTime);
        return new MoveableTrackElement(sLabel, operationTime,ChaBeginn, ChaEnd, locationList, listOfPossibleStatus,
            Current, Switch);
    }

    /**
     * Validiert Operation Time of Moveable Track Elements
     * @param operationTime - int in ms
     */
    public static void guardOpTime(int operationTime) {
        if (operationTime <= 0) throw new InvalidParameterException("Operation Time of Element must be greater zero");
    }


    private int operationTime;
    private ArrayList<TrackElementStatus> listOfPossibleStatus;
    private TrackElementStatus currentStatus;
    private TrackElementStatus requestedStatus;
    private DriveProtectionSection protectionSection;
    private AllocationSection allocationSection;



    private MoveableTrackElement(String sLabel, int operationTime, Chainage ChaBeginn, Chainage ChaEnd,
                                 List<IRTMEntityLocation> locationList,
                                 ArrayList<TrackElementStatus> listOfPossibleStatus,
                                 TrackElementStatus Current,
                                 CrossingSwitch Switch) {
        super(CLASS_IDENTIFIER);
        this.setLabel(sLabel);
        this.operationTime = operationTime;
        this.setChainageBeginn(ChaBeginn);
        this.setChainageEnd(ChaEnd);
        this.setLocationList(locationList);
        this.setListOfPossibleStatus(listOfPossibleStatus);
        this.setCurrentStatus(Current);
        this.setDriveProtectionSection(Switch);
        this.setAllocationSectionAsDriveProtectionSection();
    }

    private void setAllocationSectionAsDriveProtectionSection() {
        allocationSection = new AllocationSection();
        allocationSection.setApplicationDirection(TApplicationDirection.BOTH);
        allocationSection.setTrackEdgeSections(new ArrayList<>(protectionSection.getTrackEdgeSections()));
    }

    private void setDriveProtectionSection(CrossingSwitch CS) {
        if(CS == null) throw new InvalidParameterException("CS must not be null");
        DriveProtectionSection DS = new DriveProtectionSection();
        CSignal Sig = CS.getSignal();
        ArrayList<TrackEdgeSection> protectedSections = new ArrayList<>();
        ArrayList<TopologyGraph.Edge> edges = new ArrayList<>();
        if(Sig == null) {
            protectAllEdgesOfSwitch(CS, edges);
        } else {
            for (CPunktObjektTOPKante CTopKante : Sig.getPunktObjektTOPKante()) {
               TopologyGraph.Edge E =  PlanData.topGraph.edgeRepo.get(CTopKante.getIDTOPKante().getWert());
               if(E == null) {
                   System.out.print("Edge ID of Signal cannot be found.");
                   protectAllEdgesOfSwitch(CS, edges);
                   break;
               } else {
                   edges.add(E);
               }
            }

        }

        protectEdge(protectedSections, edges, CS, Sig);
        DS.setTrackEdgeSections(protectedSections);
        DS.setApplicationDirection(TApplicationDirection.BOTH);
        this.protectionSection = DS;
    }

    private void protectAllEdgesOfSwitch(CrossingSwitch CS, ArrayList<TopologyGraph.Edge> edges) {
        String ebdSwitchID = null;
        System.err.println("No Grenzzeichen, so whole Edges are Protected " +
                CS.getEbdTitle(0, false, true));

        NodeInformation NiToProtect = getNodesForSwitch(CS);
        for(TopologyGraph.Node N : NiToProtect) {
            for(TopologyGraph.Edge E : N.inEdges) {
                if(!edges.contains(E)) edges.add(E);
            }
            for(TopologyGraph.Edge E : N.outEdges) {
                if(!edges.contains(E)) edges.add(E);
            }
        }
    }

    private NodeInformation getNodesForSwitch(CrossingSwitch CS) {
        String ebdSwitchID;
        ebdSwitchID = CS.getEbdTitle(0,false, true);
        NodeInformation NiToProtect = ISwitchHandler.getNodeInfoBySwitchId(ebdSwitchID);
        return NiToProtect;
    }

    private void protectEdge(ArrayList<TrackEdgeSection> protectedSections, ArrayList<TopologyGraph.Edge> edges, CrossingSwitch CS, CSignal Sig) {
        for(TopologyGraph.Edge E : edges) {
            System.out.println("Protect Edge: " + E.getRefId());
            if (E == null) continue;
            double dStart = 0.0d;
            double dEnd = 1.0d;
            if(Sig != null) {
                BigDecimal insecureAreaRelativeToEdge = null;
                try {
                    insecureAreaRelativeToEdge = CS.getInsecureRangeRelative(E);
                    NodeInformation NiToProtect = getNodesForSwitch(CS);
                    if(NiToProtect == null) {
                        throw new SmartLogicException("Switch with ID is not in scope: "
                                + CS.getEbdTitle(0,false, true));
                    }
                    for(TopologyGraph.Node N : NiToProtect) {

                        if(E.A.equals(N) ) {
                            dEnd = insecureAreaRelativeToEdge.divide(new BigDecimal(E.dTopLength), 14, RoundingMode.HALF_UP)
                                    .doubleValue();
                            if(!E.A.equals(E.getRefNode())) {
                                dStart = 1 - dEnd;
                                dEnd = 1.0d;
                            }
                            break;
                        } else if(E.B.equals(N)) {
                            BigDecimal TotalEdgeLength =  new BigDecimal(E.dTopLength);

                            dStart = insecureAreaRelativeToEdge
                                    .divide(TotalEdgeLength, 14, RoundingMode.HALF_DOWN).doubleValue();
                            dEnd = 1.0d;
                            if(!E.A.equals(E.getRefNode())) {
                               dEnd = 1 - dStart;
                               dStart = 0.0d;
                            }
                            break;
                        }

                    }
                } catch(SmartLogicException Ex) {
                    Ex.printStackTrace();

                }

            }

            SpotLocationIntrinsic BeginLoc = new SpotLocationIntrinsic();
            BeginLoc.setIntrinsicCoord(dStart);
            BeginLoc.setNetElementRef(E.getId());
            SpotLocationIntrinsic EndLoc = new SpotLocationIntrinsic();
            EndLoc.setIntrinsicCoord(dEnd);
            EndLoc.setNetElementRef(E.getId());
            TrackEdgeSection TES = new TrackEdgeSection();
            TES.setTrackEdge(E);
            TES.setBegin(BeginLoc);
            TES.setEnd(EndLoc);
            protectedSections.add(TES);
        }
    }

    public DriveProtectionSection getProtectionSection() {
        return protectionSection;
    }

    public int getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(int operationTime) {
        guardOpTime(operationTime);
        this.operationTime = operationTime;
    }

    public ArrayList<TrackElementStatus> getListOfPossibleStatus() {
        return listOfPossibleStatus;
    }

    public void setListOfPossibleStatus(ArrayList<TrackElementStatus> listOfPossibleStatus) {
        this.listOfPossibleStatus = listOfPossibleStatus;
    }

    public TrackElementStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(TrackElementStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public TrackElementStatus getRequestedStatus() {
        return requestedStatus;
    }

    public void setRequestedStatus(TrackElementStatus requestedStatus) {
        this.requestedStatus = requestedStatus;
    }
}
