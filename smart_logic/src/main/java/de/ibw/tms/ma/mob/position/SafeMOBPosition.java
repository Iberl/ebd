package de.ibw.tms.ma.mob.position;

import de.ibw.feed.Balise;
import de.ibw.history.data.ComposedRoute;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan_pro.adapter.CrossingSwitch;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.ma.positioned.elements.train.MaxSafeFrontEnd;
import de.ibw.tms.ma.positioned.elements.train.MinSafeRearEnd;
import de.ibw.tms.ma.positioned.elements.train.TrainPositionSpots;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import ebd.TescModul;
import ebd.rbc_tms.util.PositionInfo;
import org.jetbrains.annotations.NotNull;
import org.railMl.rtm4rail.TApplicationDirection;
import org.springframework.integration.leader.Candidate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sicherheitsraum einer Mobile
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.5
 * @since 2021-04-07
 *
 */
public class SafeMOBPosition extends MOBPositionClasses {
    public static final String CLASS_IDENTIFIER = "Safe_MOB_Position";

    private VehicleOccupation Occupation = null;

    public SafeMOBPosition() {
        super(CLASS_IDENTIFIER);

    }

    public VehicleOccupation getOccupation() {
        return Occupation;
    }

    public void setOccupation(VehicleOccupation occupation) {
        Occupation = occupation;
        occupation.setPosition(this);
        occupation.setApplicationDirection(this.getApplicationDirection());
        occupation.setTrackEdgeSections(this.getTrackEdgeSections());
    }

    /**
     * Generiert aus der Route ein Sub-Bereich wo sich das Vehicle aufhalten muss, die SafeMobPosition
     * @param dVehicleEndOffset- offset des Routenende den das Vehicle noch nicht befahren hat
     * @param Route - Die Route die diesem Vehicle zugesprochen wurde
     * @param distanceDiff - space the vehicle has trespassed the route since initial position report
     *                          the initial position report is part of the composed route and refered as start location
     *                          of the ma
     *                     den Bereich den das Vehicle seit den Reference-Positonreport der MA bereits
     *                     beschritten hat
     * @param iScale - 0: 0,1 meter Skalenma&szlig;
     *               - 1: 1 meter Einheit
     *               - 2: 10 meter Einheit
     * @throws SmartLogicException - Vehicle Position konnte nicht definiert werden
     */
    public void defineNewVehiclePosition(BigDecimal dVehicleEndOffset, ComposedRoute Route, ETCS_DISTANCE distanceDiff, int iScale) throws SmartLogicException {
        ETCS_DISTANCE d_vehicleEndDiff = new ETCS_DISTANCE();
        d_vehicleEndDiff.sDistance = dVehicleEndOffset.setScale(0, RoundingMode.HALF_DOWN).shortValueExact();
        SafeMOBPosition NewPosition = (SafeMOBPosition) Route.createSubRoute(distanceDiff, d_vehicleEndDiff, iScale, this);
        this.setTrackEdgeSections(NewPosition.getTrackEdgeSections());
        ArrayList<TrackEdgeSection> sections = new ArrayList<>(NewPosition.getTrackEdgeSections());
        TrackEdgeSection StartSection = sections.get(0);
        TrackEdgeSection EndSection = sections.get(sections.size() - 1);
        TrackEdge StartEdge = StartSection.getTrackEdge();
        TrackEdge EndEdge = EndSection.getTrackEdge();
        SpotLocationIntrinsic beginLocation = new SpotLocationIntrinsic();
        beginLocation.setNetElementRef(StartEdge.getId());
        beginLocation.setIntrinsicCoord(StartSection.getBegin().getIntrinsicCoord());
        SpotLocationIntrinsic endLocation = new SpotLocationIntrinsic();
        endLocation.setNetElementRef(EndEdge.getId());

        endLocation.setIntrinsicCoord(EndSection.getEnd().getIntrinsicCoord());
        MinSafeRearEnd begin = new MinSafeRearEnd();
        MaxSafeFrontEnd end = new MaxSafeFrontEnd();
        begin.setLocation(beginLocation);
        end.setLocation(endLocation);
        this.setBegin(begin);
        this.setEnd(end);
        this.setTrackEdgeSections(sections);
        this.setApplicationDirection(TApplicationDirection.BOTH);

    }


    @Override
    public void setBegin(TrainPositionSpots begin) {
        if(!begin.getName().equals(MinSafeRearEnd.CLASS_IDENTIFIER)) {
            throw new InvalidParameterException("Begin has to be of Type MinSafeRearEnd");
        }
        super.setBegin(begin);
    }

    @Override
    public void setEnd(TrainPositionSpots end) {
        if(!end.getName().equals(MaxSafeFrontEnd.CLASS_IDENTIFIER)) {
            throw new InvalidParameterException("End has to be of Type MinSafeFrontEnd");
        }
        super.setEnd(end);
    }

    /**
     * Erstellt eine Route fuer eine Vehicle-Occupation. Die Method wird nur fuer Mobile Objects benutzt,
     * die noch keine Route durch eine MA erhalten haben.
     * @param nid_engine - nid_id des betreffenden Mobile Objects
     * @param newOffset - offset in Meter zur Referenzbalise
     * @param position - der Position-Report der die Vehicle Occupation veraendert
     * @param isReverse - boolean, true -> vehicle Ende ragt zum Beispiel ueber die Referenzbalise hinaus und es
     *                  wird bei true der Ueberstand des Fahrzeugsendes uber die Balise bestimmt.
     * @return - eine Route, die in der smartLogic verarbeitet werde kann
     * @throws InvalidParameterException - Offset kann nicht berechnet werden
     * @throws SmartLogicException - Offset kann nicht berechnet werden
     */
    public ComposedRoute calcByOffset(NID_ENGINE nid_engine, BigDecimal newOffset, PositionInfo position,
                                      boolean isReverse) throws InvalidParameterException, SmartLogicException {
        Route R = new Route(null);
        ArrayList<String> edgesElementIds = new ArrayList<>();
        BigDecimal offsetPassed = new BigDecimal("0.0");
        int iLrbg = position.nid_lrbg;
        Balise B = Balise.baliseByNid_bg.getModel(iLrbg);
        if(B == null) throw new InvalidParameterException("Balise referred not available.");
        if(B.getTopPositionOfDataPoint() == null || B.getTopPositionOfDataPoint().getIdentitaet() == null ||
                B.getTopPositionOfDataPoint().getIdentitaet().getWert() == null) throw new InvalidParameterException("Balise " +
                "providing not enough information.");
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet()
                .getWert());
        if(E == null) throw new InvalidParameterException("Edge of Balise not found");
        if(E.A == null || E.B == null) throw new InvalidParameterException("Edge having not two Nodes set");
        String sEdgeElementId = E.getRefId();
        if(sEdgeElementId == null) throw new InvalidParameterException("Edges element-ID must not be null");
        boolean is_q_dlrbg_nominal = position.q_dlrbg != 0 && !isReverse; // 0 for reverse
        TopologyGraph.Node TargetNode = B.getNodeInDirectionOfBaliseGroup(is_q_dlrbg_nominal);
        BigDecimal baliseDistanceFromA = B.getBalisenPositionFromNodeA();
        BigDecimal distanceToNextNode = E.A == TargetNode ?
                baliseDistanceFromA : BigDecimal.valueOf(E.dTopLength).subtract(baliseDistanceFromA);
        offsetPassed = offsetPassed.add(distanceToNextNode);
        edgesElementIds.add(sEdgeElementId);
        while(offsetPassed.compareTo(newOffset) < 0 ) {
            if(TargetNode == null) throw new InvalidParameterException("Node in Route must not be null");
            TopologyConnect connectionOnTargetNode = E.getConnectionOnNode(TargetNode);
            checkIfConnectionIsValid(connectionOnTargetNode);
            String sSwitchId = ISwitchHandler.getNodeId(TargetNode);
            if(sSwitchId == null) throw new InvalidParameterException("Node Id of Target Node in Route must not be null");
            MoveableTrackElement SwitchElement = TescModul.MoveableTrackElementAccess.getElementById(sSwitchId);
            if(SwitchElement == null)
                throw new InvalidParameterException("Switch Element " + sSwitchId + ": of Target Node in Route must not be null");
            TrackElementStatus statusOfSwitch = SwitchElement.getCurrentStatus();
            if(statusOfSwitch == null)
                throw new InvalidParameterException("Status of Switch of Target Node must not be null");
            List<TrackElementStatus.Status> switchStatus = statusOfSwitch.statusList;
            if(switchStatus == null)
                throw new InvalidParameterException("Status List of Switch of Target Node must not be null or empty");
            int iSwitchStatusSize = switchStatus.size();
            if(iSwitchStatusSize == 0 || iSwitchStatusSize >= 3) {
                throw new InvalidParameterException("Status List Size is invalid: (" + iSwitchStatusSize + ")");
            }
            if(iSwitchStatusSize == 1) {
                TrackElementStatus.Status status = switchStatus.get(0);
                switch(status) {
                    case LEFT -> {
                        if(connectionOnTargetNode.equals(TopologyConnect.RECHTS)) {
                            throw new InvalidParameterException("Switch is turned Left but the train follows path right");
                        }

                    }
                    case RIGHT -> {
                        if(connectionOnTargetNode.equals(TopologyConnect.LINKS)) {
                            throw new InvalidParameterException("Switch is turned right but the train follows path left");
                        }
                    }
                    case UNKNOWN -> throw new InvalidParameterException("Switch " + sSwitchId + ": " +
                            "Status must not be unknown");

                }

                E = getNextEdge(E, TargetNode, status, connectionOnTargetNode);

            } else {

                boolean isEdgeFound = false;
                String sidSwitch = PlanData.SwitchIdRepo.getModel(TargetNode);
                if(sidSwitch == null) throw new InvalidParameterException("Target Node cannot be linked to SwitchId");
                CrossingSwitch CS = (CrossingSwitch) TargetNode.NodeImpl;
                List<CrossingSwitch> switchList = ISwitchHandler.getCrossingSwitches(CS.getAnlage());
                StringBuilder sRef = new StringBuilder(PlanData.getLinkNameToDKW(CS, switchList));
                sRef = new StringBuilder(sRef.toString().replace("AB", "").replace("CD", ""));
                for(TrackElementStatus.Status status : switchStatus) {
                    switch(status) {
                        case LEFT -> sRef.append("L");
                        case RIGHT -> sRef.append("R");
                        case UNKNOWN -> throw new InvalidParameterException("Switch Status must not be unknown");

                    }

                }

                ArrayList<TopologyGraph.Edge> nextEdges = new ArrayList<>();
                nextEdges.addAll(TargetNode.inEdges);
                nextEdges.addAll(TargetNode.outEdges);
                nextEdges.remove(E);
                for(TopologyGraph.Edge edgeCandidate : nextEdges) {
                    if(edgeCandidate.getRefId().equals(sRef.toString())) {
                        E = edgeCandidate;
                        isEdgeFound = true;
                        break;
                    }

                }
                if(!isEdgeFound) throw new InvalidParameterException("Edge Within DKW not found");



            }
            TargetNode = E.A.equals(TargetNode) ? E.B : E.A;
            offsetPassed = offsetPassed.add(BigDecimal.valueOf(E.dTopLength));
            sEdgeElementId = E.getRefId();
            if(sEdgeElementId == null) throw new InvalidParameterException("Edges element-ID must not be null");
            edgesElementIds.add(sEdgeElementId);
        }
        if(E.dTopLength == 0) throw new InvalidParameterException("Last Edge of route must not have a lenth 0");
        R.setElementListIds(edgesElementIds);
        BigDecimal spaceToNextNode = offsetPassed.subtract(newOffset);

        BigDecimal PercentOfRouteEndToNextNode = spaceToNextNode.divide(BigDecimal.valueOf(E.dTopLength), MathContext.DECIMAL32);
        BigDecimal OffsetOfRoute = BigDecimal.valueOf(1.0d).subtract(PercentOfRouteEndToNextNode);

        R.setIntrinsicCoordOfTargetTrackEdge(OffsetOfRoute.doubleValue());


        ComposedRoute CR = new ComposedRoute();
        try {
            CR.generateFromRoute(R, nid_engine.getId());
        } catch (SmartLogicException ignored) {

        }
        return CR;

    }

    private TopologyGraph.Edge getNextEdge(TopologyGraph.Edge e, TopologyGraph.Node targetNode,
                                           TrackElementStatus.Status status, TopologyConnect connectionOnTargetNode) {
        ArrayList<TopologyGraph.Edge> edges = new ArrayList<>();
        edges.addAll(targetNode.outEdges);
        edges.addAll(targetNode.inEdges);
        edges.remove(e);
        if(!connectionOnTargetNode.equals(TopologyConnect.SPITZE)) {
            // gesuchte Kante muss in die Spitze gehen
            return getEdgeWithConnect(targetNode, edges,TopologyConnect.SPITZE );
        } else {
            if(status.equals(TrackElementStatus.Status.LEFT)) {
                return getEdgeWithConnect(targetNode, edges,TopologyConnect.LINKS );
            } else {
                return getEdgeWithConnect(targetNode, edges,TopologyConnect.RECHTS );
            }
        }
    }

    @NotNull
    private TopologyGraph.Edge getEdgeWithConnect(TopologyGraph.Node targetNode, ArrayList<TopologyGraph.Edge> edges,
                                                  TopologyConnect connectionBeingSearched
    ) {
        TopologyGraph.Edge EndOfCalculation = null;
        for(TopologyGraph.Edge CandidatEdge : edges) {
            if(CandidatEdge.A.equals(targetNode)) {
                if (CandidatEdge.TopConnectFromA.equals(connectionBeingSearched)) {
                    if(CandidatEdge.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG)) {
                        EndOfCalculation = CandidatEdge;
                    } else return CandidatEdge;
                }
            } else {
                if(CandidatEdge.TopConnectFromB.equals(connectionBeingSearched)) {
                    if(CandidatEdge.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG)) {
                        EndOfCalculation = CandidatEdge;
                    } else return CandidatEdge;
                }

            }
        }
        if(EndOfCalculation == null) throw new InvalidParameterException("Edge with given Connect not found");
        return EndOfCalculation;
    }

    private void checkIfConnectionIsValid(TopologyConnect connectionOnTargetNode) {
        ArrayList<TopologyConnect> validConnection = new ArrayList<>();
        validConnection.add(TopologyConnect.SPITZE);
        validConnection.add(TopologyConnect.LINKS);
        validConnection.add(TopologyConnect.RECHTS);
        if(!validConnection.contains(connectionOnTargetNode)) {
            throw new InvalidParameterException("Target Node must have valid connection but has: " +
                    connectionOnTargetNode.toString());
        }
    }
}
