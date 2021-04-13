package de.ibw.history.data;

import de.ibw.history.PositionData;
import de.ibw.history.TrackAndOccupationManager;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.positioned.elements.TrackArea;
import de.ibw.tms.ma.positioned.elements.TrackEdge;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyConnect;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologyFactory;
import de.ibw.util.DefaultRepo;
import de.ibw.util.ThreadedRepo;
import ebd.TescModul;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.railMl.rtm4rail.TApplicationDirection;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Routendatenverarbeitung innerhalb der smartLogic
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 2021-03-31
 */
public class ComposedRoute extends ArrayList<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> {

    // Waypoints auf einer Kante innerhalb einer DKW
    public DefaultRepo<TrackEdge, Waypoint> dkwWaypointRepo = new DefaultRepo<>();
    // Waypoints zwischen zwei TrackEdges je String id
    public DefaultRepo<Pair<String, String>, Waypoint> waypointsBetweentTwoTrackEdges = new DefaultRepo<>();


    // Diese Werte müssen bei jeder Route gesetzt werden, weil dann das Start und das Ende der Route bestimmt
    // Werden kann
    private SpotLocationIntrinsic lastSpot = null;
    private SpotLocationIntrinsic firstSpot = null;
    // Position of Train and Time of MA acceptance
    private PositionData startPosition = null;


    private BigDecimal dRouteLength = null;

    public void generateFromRoute(Route R) throws SmartLogicException {
        try{

            int iListCount = 0;
            TopologyGraph.Edge PreviousEdge = null;
            TopologyGraph.Edge LastEdge = null;
            TopologyGraph.Edge FirstEdge = null;
            TopologyGraph.Edge NextEdge = null;
            SpotLocationIntrinsic LastLocation = new SpotLocationIntrinsic();






            System.out.println(R.getElementListIds().size());

            System.out.println("check done");

            List<String> idList = R.getElementListIds();

            int iIdCount = idList.size();

            for(int i = 0; i < iIdCount; i++) {
                Pair<Route.TrackElementType, ITopological> TePair = null;

                String sId  = idList.get(i);

                TopologyGraph.Edge E =  PlanData.EdgeIdLookupRepo.getModel(sId);

                if(E == null){
                    System.err.println("Edge Element (ID: " + sId + ") cannot be Identified");

                    throw new NullPointerException("Edge Element cannot be Identifed: " + sId);
                }

                TePair = new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, E);

                if(i > 0) {
                    TePair = addWaypoint(this, E);
                }
                this.add(TePair);
                if(FirstEdge == null) FirstEdge = E;
                else if(NextEdge == null) NextEdge = E;

                PreviousEdge = LastEdge;
                LastEdge = E;

            }
            if(PreviousEdge != null) {
                if(!TopologyGraph.getNodeBetweenTwoEdges(PreviousEdge, LastEdge).equals(LastEdge.getRefNode())) {
                    LastLocation.setIntrinsicCoord(1 - R.getIntrinsicCoordOfTargetTrackEdge());
                } else {
                    LastLocation.setIntrinsicCoord(R.getIntrinsicCoordOfTargetTrackEdge());
                }
            } else LastLocation.setIntrinsicCoord(R.getIntrinsicCoordOfTargetTrackEdge());

            this.setLastSpot(LastLocation);



            //ArrayList<Waypoint> wayList = R.getAllWaypointsInOrder();
           /* Waypoint WayStart = wayList.get(0);
            Waypoint WayEnd = wayList.get(wayList.size() - 1);

            if (handleWaypontsOnOneTrail(requestedTrackElementList, WayStart, WayEnd)) {
                return requestedTrackElementList;
            }
            wayList.remove(WayStart);
            wayList.remove(WayEnd);
            iListCount = wayList.size();


            if(iListCount == 1) {
                //one Waypoint plus start and End
                return handle3Waypoints(requestedTrackElementList, wayList, WayStart, WayEnd);
            } else {
                handleWaypointsMore3Waypoints(requestedTrackElementList, iListCount, wayList, WayStart, WayEnd);
            }




            */


        } catch(Exception | SmartLogicException E) {
            E.printStackTrace();
            throw E;
        }
    }


    public PositionData getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(PositionData startPosition, int iTrainId) {
        this.startPosition = startPosition;
        MovableObject MO = MovableObject.ObjectRepo.getModel(new NID_ENGINE(iTrainId));
        try {
            ThreadedRepo<TrackEdge, ArrayList<Occupation>> VehicleMap =
                    TrackAndOccupationManager.getReadOnly(VehicleOccupation.class, MO);
            VehicleOccupation VO = (VehicleOccupation) VehicleMap.getAll().iterator().next().get(0);
            this.firstSpot = (SpotLocationIntrinsic) VO.getBegin().getLocation();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

    public SpotLocationIntrinsic getLastSpot() {
        return lastSpot;
    }

    public void setLastSpot(SpotLocationIntrinsic lastSpot) {
        this.lastSpot = lastSpot;
    }

    public SpotLocationIntrinsic getFirstSpot() {
        return firstSpot;
    }

    public void setFirstSpot(SpotLocationIntrinsic firstSpot) {
        this.firstSpot = firstSpot;
    }

    /**
     *
     * Berechnet Ausdehnung der gesamten Strecke
     * @return BigDecimal - Streckenausdehnug
     */
    public BigDecimal getRouteLength() throws SmartLogicException {
        guardLengthParams();


        if(dRouteLength != null) return dRouteLength;
        BigDecimal result = new BigDecimal("0");
        Iterator<Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological>> it = this.iterator();
        while(it.hasNext()) {
            Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> element = it.next();
            if(element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                TopologyGraph.Edge E = (TopologyGraph.Edge) element.getValue();
                result = result.add(BigDecimal.valueOf(E.dTopLength));
            }
        }
        try {
            this.dRouteLength = result.subtract(getLengthOfTrackAreasNotBetweenStartAndEnd(true, true));
        } catch(InvalidParameterException IPE) {
            IPE.printStackTrace();
            throw new SmartLogicException(IPE.getMessage());
        }
        return dRouteLength;
    }

    private TopologyGraph.Edge getLastTrackEdge(ComposedRoute requestedTrackElementList) {
        return (TopologyGraph.Edge) requestedTrackElementList.get(requestedTrackElementList.size() - 1).getRight();
    }

    private TopologyGraph.Edge replaceEdgeByEdgeContainingDigitalEnd(TopologyGraph.Edge e) {
        DefaultRepo<TopologyGraph.Node,DefaultRepo<TopologyGraph.Node,TopologyGraph.Edge>> cons = TopologyFactory.connections;
        TopologyGraph.Edge E1 = e;
        DefaultRepo<TopologyGraph.Node, TopologyGraph.Edge> connectionRepo = null;
        System.out.println();
        if(e.TopConnectFromB.equals(TopologyConnect.ENDE_BESTDIG)) {
            System.out.println(e.A.sOldPlanProNodeId);
            connectionRepo =  cons.getModel(e.A);
        } else if(e.TopConnectFromA.equals(TopologyConnect.ENDE_BESTDIG)) {
            System.out.println(e.B.sOldPlanProNodeId);
            connectionRepo =  cons.getModel(e.B);
        }
        if(connectionRepo == null) return e;
        E1 = connectionRepo.sortValues().get(0);
        return E1;
    }

    private void addDirectionState(TrackElementStatus dkwStateRequested, char c) {
        if(c == 'L') dkwStateRequested.statusList.add(TrackElementStatus.Status.LEFT);
        else if(c == 'R') dkwStateRequested.statusList.add(TrackElementStatus.Status.RIGHT);
    }

    private void guardDirection(char c) throws SmartLogicException {
        if(c != 'L' && c != 'R' ) throw new SmartLogicException("DKW direction must be 'L' or 'R', but is: " + c);
    }

    private void handleTrackEdgeOnDkw(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, MoveableTrackElement dkwElement) throws SmartLogicException {
        Waypoint W;
        TrackElementStatus DkwStateRequested = new TrackElementStatus();
        String sid = e.getRefId();
        String last2Char = sid.substring(sid.length() - 2);
        char c1 = last2Char.charAt(0);
        char c2 = last2Char.charAt(1);
        guardDirection(c1);
        guardDirection(c2);
        addDirectionState(DkwStateRequested, c1);
        addDirectionState(DkwStateRequested, c2);
        W = new Waypoint(dkwElement, DkwStateRequested);
        requestedTrackElementList.dkwWaypointRepo.update(e,W);
        return;
    }

    private boolean handleDkwLinkage(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge, MoveableTrackElement dkwElement) throws SmartLogicException {
        if(dkwElement != null) {
            try {
                handleTrackEdgeOnDkw(requestedTrackElementList, e, dkwElement);
            } catch (SmartLogicException Ex) {
                return false;
            }
            return true;
        } else {
            Waypoint W = requestedTrackElementList.dkwWaypointRepo.getModel(predecessorEdge);
            if(W != null) {
                // vorhergehende Switch war dkw sodass die dKW mit den Knoten zur zweiten kante verbunden ist.
                // die dkw ist bereits der Waypoint
                return true;
            }
        }
        return false;
    }

    private Pair<Route.TrackElementType, ITopological> addWaypoint(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e) throws SmartLogicException {
        if(requestedTrackElementList.isEmpty()) throw new InvalidParameterException("Predeceeding Edge is missing");
        TopologyGraph.Edge PredecessorEdge = getLastTrackEdge(requestedTrackElementList);
        TopologyGraph.Node N = null;
        Waypoint W;

        TopologyConnect E_Connect = null;
        TopologyConnect Predecessor_Connect = null;
        // Kreiskanten bedueten zwei Knoten die sich von zwei Kanten treffen können
        if(PredecessorEdge.A.equals(e.A) || PredecessorEdge.A.equals(e.B)) {
            N = PredecessorEdge.A;
            Predecessor_Connect = PredecessorEdge.TopConnectFromA;

            if(PredecessorEdge.A.equals(e.A)) {
                E_Connect = e.TopConnectFromA;
            } else {
                E_Connect = e.TopConnectFromB;
            }
        }
        if(PredecessorEdge.B.equals(e.A) || PredecessorEdge.B.equals(e.B)) {
            N = PredecessorEdge.B;
            Predecessor_Connect = PredecessorEdge.TopConnectFromB;
            if(PredecessorEdge.B.equals(e.A)) {
                E_Connect = e.TopConnectFromA;
            } else {
                E_Connect = e.TopConnectFromB;
            }
        }






        if(N == null) {

            PredecessorEdge = replaceEdgeByEdgeContainingDigitalEnd(PredecessorEdge);
            e = replaceEdgeByEdgeContainingDigitalEnd(e);
            if(PredecessorEdge.A.equals(e.A) || PredecessorEdge.A.equals(e.B)) {
                N = PredecessorEdge.A;
                Predecessor_Connect = PredecessorEdge.TopConnectFromA;

                if(PredecessorEdge.A.equals(e.A)) {
                    E_Connect = e.TopConnectFromA;
                } else {
                    E_Connect = e.TopConnectFromB;
                }
            }
            if(PredecessorEdge.B.equals(e.A) || PredecessorEdge.B.equals(e.B)) {
                N = PredecessorEdge.B;
                Predecessor_Connect = PredecessorEdge.TopConnectFromB;
                if(PredecessorEdge.B.equals(e.A)) {
                    E_Connect = e.TopConnectFromA;
                } else {
                    E_Connect = e.TopConnectFromB;
                }
            }



            if(N == null) {
                System.err.println();
                throw new SmartLogicException("Two Track-Edges cannot be connected by a Waypoint");
            }

        }

        // Wenn e zu einer DKW gehört DKW Waypoint speichern und return
        String sCheckIfdkwId = e.getRefId().replace("L", "").replace("R", "");

        MoveableTrackElement DkwElement = TescModul.MoveableTrackElementAccess.getDkwById(sCheckIfdkwId);
        if(handleDkwLinkage(requestedTrackElementList, e, PredecessorEdge, DkwElement)) {
            // DKW Waypoint added
            return new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, e);
        }



        // Wenn PredecessorEdge zu einer DKW gehört return




        String sSwitchId = ISwitchHandler.getNodeId(N);
        MoveableTrackElement SwitchElement = TescModul.MoveableTrackElementAccess.getElementById(sSwitchId);
        TrackElementStatus TES = new TrackElementStatus();

        if (handleTrackElementStatusInsertingWaypoint(requestedTrackElementList, e, PredecessorEdge, E_Connect, Predecessor_Connect, SwitchElement, TES))
            return new ImmutablePair<>(Route.TrackElementType.RAIL_TYPE, e);

        throw new SmartLogicException("Waypoint has to be found, but cannot");



    }

    private boolean handleTrackElementStatusInsertingWaypoint(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge, TopologyConnect e_Connect, TopologyConnect predecessor_Connect, MoveableTrackElement switchElement, TrackElementStatus TES) {
        switch (predecessor_Connect) {
            case RECHTS -> {
                TES.statusList.add(TrackElementStatus.Status.RIGHT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
            case LINKS -> {
                TES.statusList.add(TrackElementStatus.Status.LEFT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
        }
        switch (e_Connect) {
            case RECHTS -> {
                TES.statusList.add(TrackElementStatus.Status.RIGHT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
            case LINKS -> {
                TES.statusList.add(TrackElementStatus.Status.LEFT);
                insertWaypointInRouteRequested(requestedTrackElementList, e, predecessorEdge, switchElement, TES);
                return true;
            }
        }
        return false;
    }

    private void insertWaypointInRouteRequested(ComposedRoute requestedTrackElementList, TopologyGraph.Edge e, TopologyGraph.Edge predecessorEdge, MoveableTrackElement switchElement, TrackElementStatus TES) {
        Waypoint W;
        W = new Waypoint(switchElement, TES);
        Pair<String, String> key = new ImmutablePair<>(predecessorEdge.getRefId(), e.getRefId());
        Pair<String, String> keyReverse = new ImmutablePair<>(e.getRefId(), predecessorEdge.getRefId());
        requestedTrackElementList.waypointsBetweentTwoTrackEdges.update(key, W);
        requestedTrackElementList.waypointsBetweentTwoTrackEdges.update(keyReverse, W);

    }

    private void guardLengthParams() throws SmartLogicException {
        if(lastSpot == null)
            throw new SmartLogicException("The Last Spot on this Route has to be defined but it is null");
        if(firstSpot == null) {
            throw new SmartLogicException("The first Spot on this Route has to be defined but it is null");
        }
        if(firstSpot.getIntrinsicCoord() < 0.0d)
            throw new SmartLogicException("FirstSpot percentage must not be negative");
        if(lastSpot.getIntrinsicCoord() < 0.0d)
            throw new SmartLogicException("LastSport percentage must not be negative");
        if(firstSpot.getIntrinsicCoord() > 1.0d)
            throw new SmartLogicException("FirstSpot percentage must not be greater than 1");
        if(lastSpot.getIntrinsicCoord() > 1.0d)
            throw new SmartLogicException("LastSpot percentage must not be greater than 1");
    }



    private BigDecimal getLengthOfTrackAreasNotBetweenStartAndEnd(boolean withStart, boolean withEnd) throws InvalidParameterException {
        TopologyGraph.Edge StartEdge = null;
        TopologyGraph.Edge EndEdge = null;
        StartEdge = retrieveNextEdgeAfterGivenOne(null, false);
        EndEdge = retrieveNextEdgeAfterGivenOne(null, true);
        if(StartEdge == null) throw new InvalidParameterException("Route als Liste beinhaltet keine Kanten.");
        if(StartEdge == EndEdge) {

            BigDecimal routeFactor =
                    BigDecimal.valueOf(1.0d - (this.lastSpot.getIntrinsicCoord() - this.firstSpot.getIntrinsicCoord()));
            return BigDecimal.valueOf(StartEdge.dTopLength).multiply(routeFactor).abs();
        } else {

            BigDecimal result = new BigDecimal("0");
            if(withStart) {
                result = handleStart(StartEdge, result);
            }
            if(withEnd) {
                result = handleEnd(EndEdge, result);
            }
            return result;
        }
    }

    private BigDecimal handleEnd(TopologyGraph.Edge EndEdge, BigDecimal result) {
        BigDecimal routeFactor;
        TopologyGraph.Edge PrevEdge = retrieveNextEdgeAfterGivenOne(EndEdge, true);

        TopologyGraph.Node PrevNode = TopologyGraph.getNodeBetweenTwoEdges(EndEdge, PrevEdge);
        if(EndEdge.getRefNode().equals(PrevNode)) {
            // nominal Route
            routeFactor = new BigDecimal(1).subtract(BigDecimal.valueOf(lastSpot.getIntrinsicCoord()));
        } else routeFactor = BigDecimal.valueOf(lastSpot.getIntrinsicCoord());
        return result.add(routeFactor.multiply(BigDecimal.valueOf(EndEdge.dTopLength)));
    }

    private BigDecimal handleStart(TopologyGraph.Edge StartEdge, BigDecimal result) {
        BigDecimal routeFactor;
        TopologyGraph.Edge NextEdge = retrieveNextEdgeAfterGivenOne(StartEdge, false);

        TopologyGraph.Node NextNode = TopologyGraph.getNodeBetweenTwoEdges(StartEdge, NextEdge);
        if(StartEdge.getRefNode().equals(NextNode)) {
            // reversed Route
            routeFactor = new BigDecimal(1).subtract(BigDecimal.valueOf(firstSpot.getIntrinsicCoord()));


        } else routeFactor = BigDecimal.valueOf(firstSpot.getIntrinsicCoord());
        return result.add(routeFactor.multiply(BigDecimal.valueOf(StartEdge.dTopLength)));
    }

    /**
     * Zieht die erste topologische Kante die nicht die referenceEdge oder die erste Kante falls referenceEdge null ist
     * @param referenceEdge - referenzKnte
     * @param isPreviousMode - true : Suche ist reversed
     *                       - false : Suche von Start der Route
     * @return die gefundene Kante
     */
    private TopologyGraph.Edge retrieveNextEdgeAfterGivenOne(TopologyGraph.Edge referenceEdge, boolean isPreviousMode) {

        if(!isPreviousMode) {
            ListIterator<Pair<Route.TrackElementType, ITopological>> it = this.listIterator(0);

            while (it.hasNext()) {
                Pair<Route.TrackElementType, ITopological> element = it.next();
                if (element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                    TopologyGraph.Edge result = (TopologyGraph.Edge) element.getValue();
                    if(referenceEdge == null) return result;
                    if(result.equals(referenceEdge)) continue;
                    return result;
                }
            }
        } else {
            ListIterator<Pair<Route.TrackElementType, ITopological>> it = this.listIterator(this.size());

            while (it.hasPrevious()) {
                Pair<Route.TrackElementType, ITopological> element = it.previous();
                if (element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                    TopologyGraph.Edge result = (TopologyGraph.Edge) element.getValue();
                    if(referenceEdge == null) return result;
                    if(result.equals(referenceEdge)) continue;
                    return result;
                }
            }
        }
        throw new InvalidParameterException("Route not found an other Edge after the Edge referred");
    }


    /**
     * This route will be gone back referenced on lastSpot on the last Trackedge
     * @param lastSpot - end point beeing refered
     * @param dMeterGoBack - distance to go back onto route
     * @param i_QScale - Skala für Meterangaben
     * @return SpotLocationIntrinsic - Spot on route when gone back for "dMeterGoBack" meter
     * @throws SmartLogicException - distance gone back is longer than track section in scope of last spot
     */
    public SpotLocationIntrinsic getPositionGoBackFromEndOfTrack(SpotLocationIntrinsic lastSpot,
                                                                 ETCS_DISTANCE dMeterGoBack,
                                                                 int i_QScale) throws SmartLogicException {
        Q_SCALE QS = Q_SCALE.getScale(i_QScale);
        int i_Exponent = i_QScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        if( this.lastSpot == null) this.lastSpot = lastSpot;
        TopologyGraph.Edge LastEdge = (TopologyGraph.Edge) this.get(this.size() - 1).getRight();
        TopologyGraph.Edge CurrentEdge = LastEdge;
        // distance from TopologicalNode to Last Spot of Track
        BigDecimal d_lastSpotInTrack = getDistanceOfLastTopNodeToEndOfRoute();


        // distance from dp to overlap (overlap is last spot)
        BigDecimal d_Meter_Go_Back = new BigDecimal(dMeterGoBack.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent, MathContext.DECIMAL32));
        int index = 1;
        BigDecimal CurrentLength = d_lastSpotInTrack;
        BigDecimal percent_of_Track = new BigDecimal("0");
        while(d_Meter_Go_Back.compareTo(new BigDecimal(0)) > 0) {

            if(CurrentLength.compareTo(d_Meter_Go_Back) >= 0) {
                percent_of_Track = CurrentLength.subtract(d_Meter_Go_Back)
                        .divide(new BigDecimal(CurrentEdge.dTopLength), 14, RoundingMode.HALF_UP);
                break;
            } else {
                d_Meter_Go_Back = d_Meter_Go_Back.subtract(CurrentLength);
                index++;
            }



            if(this.size() - index < 0)
                throw new SmartLogicException("Route is not Long enough for going back: " + d_Meter_Go_Back.doubleValue());

            Pair<Route.TrackElementType, ITopological> CurrentElement = this.get(this.size() - index);
            while(!CurrentElement.getLeft().equals(Route.TrackElementType.RAIL_TYPE)) {
                index++;
                if(this.size() - index < 0)
                    throw new SmartLogicException("Route is not Long enough for going back: " + d_Meter_Go_Back.doubleValue());
                CurrentElement = this.get(this.size() - index);
            }
            CurrentEdge = (TopologyGraph.Edge) CurrentElement.getRight();
            CurrentLength = new BigDecimal(CurrentEdge.dTopLength);
        }
        SpotLocationIntrinsic Spot = new SpotLocationIntrinsic();
        Spot.setIntrinsicCoord(percent_of_Track.doubleValue());
        Spot.setNetElementRef(CurrentEdge.getId());
        return Spot;
    }

    @NotNull
    private BigDecimal getDistanceOfLastTopNodeToEndOfRoute() throws InvalidParameterException {

            TopologyGraph.Edge EndEdge = retrieveNextEdgeAfterGivenOne(null, true);
            TopologyGraph.Edge StartEdge = retrieveNextEdgeAfterGivenOne(null, false);
            if(StartEdge == EndEdge) {
                if(this.firstSpot.getIntrinsicCoord().compareTo(this.lastSpot.getIntrinsicCoord()) <= 0) {

                    return BigDecimal.valueOf(StartEdge.dTopLength).multiply(
                            BigDecimal.valueOf(this.lastSpot.getIntrinsicCoord()));
                } else return BigDecimal.valueOf(StartEdge.dTopLength).multiply(
                        BigDecimal.valueOf(1 - this.lastSpot.getIntrinsicCoord()));
            }

            BigDecimal diff = handleEnd(EndEdge, new BigDecimal("0"));
            return BigDecimal.valueOf(EndEdge.dTopLength).subtract(diff);



    }

    /**
     *
     * Die Meter-Angabe auf der Strecke erfolgen immer entlang der Route:
     *
     * @param dStartMeter - Beginn des Streckenabschnitts auf der Route
     *                    - dStartMeter ist eine Angebae der Lage vom nicht angefahrenen Knoten aus gemessen
     *
     *
     * @param dEndMeter - Ende des Streckenabschnitts auf der Route
     * @param i_QScale - Massfaktor
     * @param result - TrackArea dieser Berechnung
     * @return TrackArea - gibt berechnete Trackarea wieder zur&uuml;ck
     * throws SmartLogicException
     */
    public TrackArea createSubRoute(ETCS_DISTANCE dStartMeter,
                                    ETCS_DISTANCE dEndMeter,
                                    int i_QScale, TrackArea result) throws SmartLogicException {
        if(result == null) throw new SmartLogicException("Result is to be filled and must not be null");
        guardCreatingSubRoute(dStartMeter, dEndMeter, i_QScale);
        Q_SCALE QS = Q_SCALE.getScale(i_QScale);
        result.setApplicationDirection(TApplicationDirection.BOTH);




        int i_Exponent = i_QScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        BigDecimal d_Start_Meter = new BigDecimal(dStartMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent, MathContext.DECIMAL32));
        BigDecimal d_End_Meter = new BigDecimal(dEndMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent, MathContext.DECIMAL32));

        d_End_Meter = this.getRouteLength().subtract(d_End_Meter);

        //BigDecimal d_LengthOfSubroute = d_End_Meter.subtract(d_Start_Meter);


        // defines how many meters being iterater to find start edge
        BigDecimal d_Current = new BigDecimal(0);
        BigDecimal d_MeterTillEndOfSubroute = new BigDecimal(0);
        ArrayList<TrackEdgeSection> sections = new ArrayList<>();
        TopologyGraph.Edge StartEdge = null;
        TopologyGraph.Edge PrevEdge = null;
        for(int i = 0 ; i < this.size(); i++) {
            Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> Current = this.get(i);
            TopologyGraph.Edge CurrentEdge = (TopologyGraph.Edge) Current.getRight();

            Pair<de.ibw.tms.ma.Route.TrackElementType, ITopological> Next = null;
            TopologyGraph.Edge NextEdge = null;
            BigDecimal shortageOnCurrentEdge = null;
            if(i + 1 < this.size()) {
                Next = this.get(i + 1);
                NextEdge = (TopologyGraph.Edge) Next.getRight();
            } else {
                NextEdge = null;
            }
            if(i == 0 && this.size() == 1) {
                shortageOnCurrentEdge = getLengthOfTrackAreasNotBetweenStartAndEnd(true, true);
            } else if(i == 0) {
                shortageOnCurrentEdge = getLengthOfTrackAreasNotBetweenStartAndEnd(true, false);
            } else if (i == this.size() - 1) {
                shortageOnCurrentEdge = getLengthOfTrackAreasNotBetweenStartAndEnd(false, true);
            } else {
                shortageOnCurrentEdge = new BigDecimal(0);
            }
            BigDecimal realCurrentEdgeLength =
                    BigDecimal.valueOf(CurrentEdge.dTopLength).subtract(shortageOnCurrentEdge);
            BigDecimal d_Start = new BigDecimal(String.valueOf(d_Current));
            d_Current = d_Current.add(realCurrentEdgeLength);

            // Die Start Meter reichen in diese Kante d_Current hinein. Und die End-Meter sind noch nicht erreicht.
            if(d_Start_Meter.compareTo(d_Current) <= 0 && d_End_Meter.compareTo(d_Start) >= 0) {

                BigDecimal dBeginPercent = null;
                BigDecimal dEndPercent = null;
                if(CurrentEdge.dTopLength == 0) {
                    dBeginPercent = BigDecimal.valueOf(0);
                    dEndPercent = BigDecimal.valueOf(1);
                } else {
                    if(StartEdge == null) {
                        StartEdge = (TopologyGraph.Edge) Current.getRight();
                    }
                    boolean is_StartEdge = StartEdge == CurrentEdge;
                    if(StartEdge == CurrentEdge && NextEdge == null && PrevEdge == null) {
                        // Start-Kante ist die letzte Kante
                        if(firstSpot.getIntrinsicCoord().compareTo(lastSpot.getIntrinsicCoord()) == 0) {
                           dBeginPercent = BigDecimal.valueOf(firstSpot.getIntrinsicCoord());
                           dEndPercent = BigDecimal.valueOf(firstSpot.getIntrinsicCoord());
                        } else if( firstSpot.getIntrinsicCoord().compareTo(lastSpot.getIntrinsicCoord() ) < 0) {
                            // Zug fährt in nominaler richtung
                            dBeginPercent = getNominaStartIntrinsic(d_Start_Meter, d_Start,
                                    CurrentEdge, sections.isEmpty(), is_StartEdge);
                            dEndPercent = getNominalEndIntrinsic(d_End_Meter, d_Start, d_Current, CurrentEdge);
                        } else {
                            // Zug fährt reverse

                            dBeginPercent = getReversedStartIntrinsic(d_End_Meter, d_Start, d_Current, CurrentEdge);
                            dEndPercent = getReversedEndIntrinsic(d_Start_Meter, d_Start,
                                    CurrentEdge, sections.isEmpty(), is_StartEdge);
                        }
                    } else if (StartEdge == CurrentEdge && PrevEdge == null) {

                        // Route erstreckt sich übermehrere Kanten. Es wird gerade die Start-Kante untersucht.
                        TopologyGraph.Node NextNode;
                        try {
                            NextNode = TopologyGraph.getNodeBetweenTwoEdges(StartEdge, NextEdge);

                        } catch (InvalidParameterException IPE) {
                            throw new SmartLogicException("Subroute creation detected that " +
                                    "two Edges are not connected by a node");
                        }
                        if (StartEdge.getRefNode().equals(NextNode)) {
                            // Die Intrinsische Koordinate wird von NextNode aus gemessen. Das enspricht einer Reversed Zugfahrt.
                            dBeginPercent = getReversedStartIntrinsic(d_End_Meter, d_Start, d_Current, CurrentEdge);
                            dEndPercent = getReversedEndIntrinsic(d_Start_Meter, d_Start,
                                    CurrentEdge, sections.isEmpty(), is_StartEdge);
                        } else {
                            // Nominale Zugfahrt
                            dBeginPercent = getNominaStartIntrinsic(d_Start_Meter, d_Start,
                                    CurrentEdge, sections.isEmpty(), is_StartEdge);
                            dEndPercent = getNominalEndIntrinsic(d_End_Meter, d_Start, d_Current, CurrentEdge);
                        }
                    } else {
                        // keine Startkante UND es gab eine eine Start Intrinsic

                        TopologyGraph.Node PrevNode;
                        try {
                            PrevNode = TopologyGraph.getNodeBetweenTwoEdges(CurrentEdge, PrevEdge);

                        } catch (InvalidParameterException IPE) {
                            throw new SmartLogicException("Subroute creation detected that " +
                                    "two Edges are not connected by a node");
                        }
                        if (!CurrentEdge.getRefNode().equals(PrevNode)) {
                            // Die Intrinsische Koordinate wird von NextNode aus gemessen. Das enspricht einer Reversed Zugfahrt.
                            dBeginPercent = getReversedStartIntrinsic(d_End_Meter, d_Start, d_Current, CurrentEdge);
                            dEndPercent = getReversedEndIntrinsic(d_Start_Meter, d_Start,
                                    CurrentEdge, sections.isEmpty(), false);

                        } else {
                            // Nominale Zugfahrt
                            dBeginPercent = getNominaStartIntrinsic(d_Start_Meter, d_Start,
                                    CurrentEdge, sections.isEmpty(), is_StartEdge);
                            dEndPercent = getNominalEndIntrinsic(d_End_Meter, d_Start, d_Current, CurrentEdge);
                        }
                    }

                }
                SpotLocationIntrinsic beginLocation = new SpotLocationIntrinsic();
                beginLocation.setIntrinsicCoord(dBeginPercent.doubleValue());
                SpotLocationIntrinsic endLocation = new SpotLocationIntrinsic();
                endLocation.setIntrinsicCoord(dEndPercent.doubleValue());
                TrackEdgeSection TES = new TrackEdgeSection();
                TES.setTrackEdge(CurrentEdge);
                TES.setBegin(beginLocation);
                TES.setEnd(endLocation);
                sections.add(TES);


            } else {
                PrevEdge = (TopologyGraph.Edge) Current.getRight();
                continue;
            }
            PrevEdge = (TopologyGraph.Edge) Current.getRight();
        }
        result.setTrackEdgeSections(sections);
        return result;

    }

    @NotNull
    private BigDecimal getReversedStartIntrinsic(BigDecimal d_End_Meter, BigDecimal d_Start_Of_Track,
                                                 BigDecimal d_End_Of_Track, TopologyGraph.Edge currentEdge) {
        if(d_End_Meter.compareTo(d_End_Of_Track) >= 0) {
            // Ende ist nicht auf diesr Kante
            // return 0 % als Ende der Kante
            // das bedeutet seit dem Start, wird die Ganze Kante dem Subbereich angeordnet
            return new BigDecimal(0);
        }
        BigDecimal dEndPercent;

        TopologyGraph.Edge StartEdge = retrieveNextEdgeAfterGivenOne(null, false);
        if(StartEdge.equals(currentEdge)) {
            BigDecimal edgeEnd = BigDecimal.valueOf(currentEdge.dTopLength)
                    .multiply(BigDecimal.valueOf(firstSpot.getIntrinsicCoord()))
                    .subtract(d_End_Meter.subtract(d_Start_Of_Track));
            dEndPercent = edgeEnd.divide(BigDecimal.valueOf(currentEdge.dTopLength),
                    RoundingMode.HALF_UP);
        } else {
            BigDecimal dUnusedMetersAtStart = BigDecimal.valueOf(currentEdge.dTopLength)
                    .multiply(BigDecimal.valueOf(1 - firstSpot.getIntrinsicCoord()));

            dEndPercent = d_End_Meter.divide(BigDecimal.valueOf(currentEdge.dTopLength));
        }


        return BigDecimal.valueOf(1).subtract(dEndPercent);
    }

    @NotNull
    private BigDecimal getReversedEndIntrinsic(BigDecimal d_Start_Meter, BigDecimal d_Start_Of_Track,
                                               TopologyGraph.Edge currentEdge, boolean empty,
                                               boolean is_StartEdge) {
        BigDecimal startingSpot = new BigDecimal(1);
        BigDecimal dEndPercent;
        if(!empty) {
            // Bereich beginnt am Ende des Tracks
            return new BigDecimal(1);
        }
        if(is_StartEdge) {
            startingSpot = BigDecimal.valueOf(currentEdge.dTopLength)
                    .multiply(BigDecimal.valueOf(firstSpot.getIntrinsicCoord()));
            BigDecimal edgesStart =
                    startingSpot.subtract(d_Start_Meter.subtract(d_Start_Of_Track));
            dEndPercent = edgesStart.divide(BigDecimal.valueOf(currentEdge.dTopLength),
                    MathContext.DECIMAL32);
            return dEndPercent;
        } else {
            startingSpot = BigDecimal.valueOf(currentEdge.dTopLength);
        }


        BigDecimal edgesStart =
                startingSpot.subtract(d_Start_Meter.subtract(d_Start_Of_Track));
        dEndPercent = edgesStart.divide(BigDecimal.valueOf(currentEdge.dTopLength),
                MathContext.DECIMAL32);
        return dEndPercent;
    }

    @NotNull
    private BigDecimal getNominalEndIntrinsic(BigDecimal d_End_Meter, BigDecimal d_Start_Of_Track,
                                              BigDecimal d_End_Of_Track, TopologyGraph.Edge currentEdge) {
        if(d_End_Meter.compareTo(d_End_Of_Track) >= 0) {
            // Ende ist nicht auf diesr Kante
            // return 100 % als Ende der Kante
            // das bedeutet seit dem Start, wird die Ganze Kante dem Subbereich angeordnet
            return new BigDecimal(1);
        }
        BigDecimal dEndPercent;
        BigDecimal edgeEnd;
        TopologyGraph.Edge StartEdge = this.retrieveNextEdgeAfterGivenOne(null, false);
        if(StartEdge.equals(currentEdge)) {
            edgeEnd = BigDecimal.valueOf(currentEdge.dTopLength)
                    .multiply(BigDecimal.valueOf(firstSpot.getIntrinsicCoord()))
                    .add(d_End_Meter.subtract(d_Start_Of_Track));
        } else {
            edgeEnd = d_End_Meter.subtract(d_Start_Of_Track);
        }


        dEndPercent = edgeEnd.divide(BigDecimal.valueOf(currentEdge.dTopLength),
                RoundingMode.HALF_UP);
        return dEndPercent;
    }

    @NotNull
    private BigDecimal getNominaStartIntrinsic(BigDecimal d_Start_Meter, BigDecimal d_Start_Of_Track,
                                               TopologyGraph.Edge currentEdge, boolean empty,
                                               boolean is_StartEdge) {
        BigDecimal edgesStart = new BigDecimal(0);
        if(!empty) return new BigDecimal(0);
        if(!is_StartEdge) {
            edgesStart  = d_Start_Meter.subtract(d_Start_Of_Track);
        } else {
            TopologyGraph.Edge FirstEdge = this.retrieveNextEdgeAfterGivenOne(null, false);
            if(FirstEdge == currentEdge) {
                edgesStart =
                        BigDecimal.valueOf(currentEdge.dTopLength)
                                .multiply(BigDecimal.valueOf(firstSpot.getIntrinsicCoord()))
                                .add(d_Start_Meter.subtract(d_Start_Of_Track));
            } else {
                edgesStart = BigDecimal.valueOf(currentEdge.dTopLength)
                        .multiply(BigDecimal.valueOf(0)).add(d_Start_Meter.subtract(d_Start_Of_Track));
            }
        }
        BigDecimal dBeginPercent;

        dBeginPercent = edgesStart.divide(BigDecimal.valueOf(currentEdge.dTopLength),
                MathContext.DECIMAL32);
        return dBeginPercent;
    }

    private void guardCreatingSubRoute(ETCS_DISTANCE dStartMeter, ETCS_DISTANCE dEndMeter, int i_qScale) throws SmartLogicException {
        Q_SCALE QS = Q_SCALE.getScale(i_qScale);

        if(this.size() == 0) throw new InvalidParameterException("The Route has not any Edges");

        int i_Exponent = i_qScale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        if(dStartMeter == null) throw new InvalidParameterException("Start Meter must not be null");
        if(dEndMeter == null) throw new InvalidParameterException("End Meter must not be null");
        if(dStartMeter.sDistance < 0) throw new InvalidParameterException("Start Meter must not be negative");
        if(dEndMeter.sDistance < 0) throw new InvalidParameterException("End Meter must not be negative");

        BigDecimal start_meter = new BigDecimal(dStartMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent, MathContext.DECIMAL32));

        BigDecimal end_meter = new BigDecimal(dEndMeter.sDistance)
                .multiply(new BigDecimal(10).pow(i_Exponent, MathContext.DECIMAL32));


        BigDecimal RouteLength = this.getRouteLength();

        if(start_meter.compareTo(RouteLength) > 0)
            throw new InvalidParameterException("Start distance in Meter must not larger than Route Length");

        if(end_meter.compareTo(RouteLength) > 0)
            throw new InvalidParameterException("End distance in Meter must not larger than Route Length");







    }


}
