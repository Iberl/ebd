package de.ibw.history;

import de.ibw.feed.Balise;
import de.ibw.history.data.PositionEnterType;
import de.ibw.history.data.ComposedRoute;
import de.ibw.history.data.RouteMap;
import de.ibw.smart.logic.EventBusManager;
import de.ibw.smart.logic.exceptions.SmartLogicException;
import de.ibw.smart.logic.intf.SmartLogic;
import de.ibw.tms.etcs.ETCS_DISTANCE;
import de.ibw.tms.etcs.Q_SCALE;
import de.ibw.tms.ma.MovementAuthority;
import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ma.location.SpotLocationIntrinsic;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.mob.position.MOBPosition;
import de.ibw.tms.ma.mob.position.SafeMOBPosition;
import de.ibw.tms.ma.occupation.MAOccupation;
import de.ibw.tms.ma.occupation.Occupation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.positioned.elements.TrackEdgeSection;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.plan_pro.adapter.topology.intf.ITopological;
import de.ibw.util.ThreadedRepo;
import de.ibw.util.UtilFunction;
import ebd.internal.util.PositionInfo;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.railMl.rtm4rail.TApplicationDirection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Dieses Modul verwaltet Positionsdaten und macht diese zentral abrufbar.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 1.1.12
 * @since 2021-07-09
 */
public class PositionModul implements IPositionModul {
     public static String POSITION_MODUL = "POSITION-MODUL";
     private static final Logger log = LoggerFactory.getLogger(PositionModul.class);

     private CopyOnWriteArrayList<PositionData> positionModuls = new CopyOnWriteArrayList<>();
     private ThreadedRepo<Integer, PositionData> CurrentPositionsByNidId = new ThreadedRepo<>();
     private RouteMap routeByNidId = new RouteMap();
     private Boolean isRbcTimeFiltering = null;
     private EventBusManager EBM = null;


     long lFrom = 0L;
     long lTo = 0L;

    private Collection<PositionData> filterTime(Collection<PositionData> data) {
        if(isRbcTimeFiltering == null) return new CopyOnWriteArrayList<>(data);
        Collection<PositionData> results = new CopyOnWriteArrayList<>();
        for(PositionData PosDat : data) {
            if(posDataIsAccepted(PosDat)) {
                results.add(PosDat);
            }
        }
        return results;
    }

    private boolean posDataIsAccepted(PositionData posDat) {
        if(isRbcTimeFiltering == null) return true;
        if(isRbcTimeFiltering) {
            if(lFrom <= posDat.getRbc_timestamp() && posDat.getRbc_timestamp() <= lTo) {
                return true;
            }
        } else {
            if(lFrom <= posDat.getReceived_timestamp() && posDat.getReceived_timestamp() <= lTo) {
                return true;
            }
        }
        return false;

    }

    private volatile static PositionModul instance = null;

    /**
     * Singleton f&uuml;r dieses Modul
     * @return PositionModul
     */
    public static synchronized PositionModul getInstance() {
        if(instance == null) {
            instance = new PositionModul();
            instance.EBM = EventBusManager.RootEventBusManger;
        }
        return instance;
    }

    public static void setInstance(PositionModul instance) {
        PositionModul.instance = instance;
    }

    /**
     * Nimmt ein Positionsdatum auf und aktualisiert Occupations
     * @param PD - {@link PositionData}  - Postionsangabe die aufgenommen wird
     */
    public synchronized void addPositionData(PositionData PD, PositionEnterType EnterType) throws InvalidParameterException {
        if(PD == null) throw new InvalidParameterException("Position Data must not be Null");
        BigDecimal trainLengthMeter = null;
        // Abstand vom ende der MA zur Zugspitze bei forwardfahrt
        BigDecimal dVehicleEndOffset = new BigDecimal(0);

        PositionInfo Position = PD.getPos();
        // WORKAROUND 4 TESTS
        Position.q_dlrbg = 1;

        
        savePositionReport(PD);
        if(Position.l_trainint != null) {
            trainLengthMeter = BigDecimal.valueOf(Position.l_trainint);
        } else {
            throw new InvalidParameterException("Train not supported: No Length information");
        }

        ComposedRoute Route = this.getRouteOfNidEngine(PD.getNid_engine());
        NID_ENGINE nid_engine = new NID_ENGINE(PD.getNid_engine());

        if(Route != null) {
            // Existing Ma Route
            PositionData StartPositionOnMa = Route.getStartPosition();
            PositionInfo MaPositionInfo = StartPositionOnMa.getPos();
            if(MaPositionInfo == null) throw new InvalidParameterException("MA is invalid");
            if(Position.nid_lrbg == MaPositionInfo.nid_lrbg) {
                handleSameBaliseGroup(trainLengthMeter, dVehicleEndOffset, Position, Route, nid_engine, MaPositionInfo);

            } else {
                throw new InvalidParameterException("Referred Balise Change not supported");
            }
        } else {

            SafeMOBPosition SafePosition = new SafeMOBPosition();



            int iNewPosExponent = getExponent(Position.q_scale);
            BigDecimal NewOffset =
                    new BigDecimal(Position.d_lrbg).multiply(new BigDecimal(10).pow(iNewPosExponent, MathContext.DECIMAL32));

            try {
                // Position existing
                if(MovableObject.ObjectRepo.containsKey(nid_engine)) return;


                Route = SafePosition.calcByOffset(nid_engine, NewOffset, Position, false);

                ETCS_DISTANCE distanceDiff = new ETCS_DISTANCE();
                ETCS_DISTANCE distanceEndDif = new ETCS_DISTANCE();
                distanceEndDif.sDistance = 0;
                if(Route.getFirstSpot() == null) {
                    EBM.log("Route not having first spot", SmartLogic.getsModuleId(POSITION_MODUL));
                    try {

                        dVehicleEndOffset = NewOffset.subtract(trainLengthMeter);
                        if (dVehicleEndOffset.compareTo(BigDecimal.valueOf(0.0d)) < 0) {

                            EBM.log("TrainId " + nid_engine.getId() +
                                            ": Route merged with preceding reverse Route",
                                    SmartLogic.getsModuleId(POSITION_MODUL));

                            ComposedRoute reverseRoute = SafePosition.calcByOffset(nid_engine, dVehicleEndOffset.negate(),
                                    Position, true);



                            if(!Route.isReverseSightDir()) {

//                            EBM.log("Route before merge: " + Route.getRouteLength(),
//                                    SmartLogic.getsModuleId(POSITION_MODUL));
                                Route.mergeWithPrecedingReverseRoute(reverseRoute);
                                EBM.log("TrainId " + nid_engine.getId() + ": " +
                                                " Route after merge: " + Route.getRouteLength(),
                                        SmartLogic.getsModuleId(POSITION_MODUL));
                            } else {
                                Route.mergeWithPrecedingReverseRoute(reverseRoute);

                                Route.setReverseSightDir(true);
                            }
                            if(Route.getRouteLength().subtract(BigDecimal.valueOf(Position.l_trainint).abs())
                                    .compareTo(BigDecimal.valueOf(1.0d)) > 0) {
                                String errMsg = "TrainId " + nid_engine.getId() + ": having length: " +
                                        Route.getRouteLength() + " but shall have length: "  + Position.l_trainint;
                                   System.err.println(errMsg);
                                EBM.log("ERROR:" + errMsg, SmartLogic.getsModuleId(POSITION_MODUL));
                            }


                        } else {
                            Route = handleShortage(dVehicleEndOffset, Position, Route, nid_engine, SafePosition);
                        }


                    } catch (SmartLogicException e) {
                        e.printStackTrace();
                        throw new InvalidParameterException(e.getMessage());
                    }
                } else {
                    EBM.log("TrainId " + nid_engine.getId() + ": Route having first spot: "
                                    + Route.getRouteLength(),
                            SmartLogic.getsModuleId(POSITION_MODUL));
                }


                int iScale = 1;
                EBM.log("TrainId " + nid_engine.getId() + ": " +
                                " Route at set safe new Vehicle Position merge: " + Route.getRouteLength(),
                        SmartLogic.getsModuleId(POSITION_MODUL));
                safeNewVehiclePosition(new BigDecimal(0), Route, nid_engine, SafePosition, distanceDiff, iScale, true);
            } catch (SmartLogicException e) {
                e.printStackTrace();
            }


            /*VehicleOccupation VO = VehicleOccupation.generateVehicleOccupation(Position, nid_engine, SafePosition,
                    sectionList, begin, end);
            //MAOccupation maOcc = new MAOccupation();

            TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                    VehicleOccupation.class, VO);*/


        }

        try {
            PD = handleMovementAuthorities(PD, EnterType);
        } catch (SmartLogicException e) {
            e.printStackTrace();
        }

    }

    @NotNull
    private ComposedRoute handleShortage(BigDecimal dVehicleEndOffset, PositionInfo Position, ComposedRoute Route, NID_ENGINE nid_engine, SafeMOBPosition SafePosition) throws SmartLogicException {
        EBM.log("Route removing nominal from Beginning",
                SmartLogic.getsModuleId(POSITION_MODUL));
        ComposedRoute nominalRouteToBegin = SafePosition.calcByOffset(nid_engine, dVehicleEndOffset,
                Position, false);
//                            EBM.log("Length (Nominal Route To Begin): " + nominalRouteToBegin.getRouteLength(),
//                                    SmartLogic.getsModuleId(POSITION_MODUL));
//                            EBM.log("Route before removing: " + Route.getRouteLength(),
//                                    SmartLogic.getsModuleId(POSITION_MODUL));

        if(!Route.isReverseSightDir()) {

            Route.removeRouteNominalFromBegin(nominalRouteToBegin);
        } else {
            Route = handleReverseRemoval(Route, nominalRouteToBegin);
        }
        EBM.log("Route after removing: " + Route.getRouteLength(),
                SmartLogic.getsModuleId(POSITION_MODUL));
        return Route;
    }

    @NotNull
    private ComposedRoute handleReverseRemoval(ComposedRoute Route, ComposedRoute nominalRouteToBegin) {
        Route.removeRouteNominalFromBegin(nominalRouteToBegin);

        Route.setReverseSightDir(true);
        return Route;
    }

    private void savePositionReport(PositionData PD) {
        PositionData NewestData = CurrentPositionsByNidId.getModel(PD.getNid_engine());
        log("Update occupation of MOB " + PD.getNid_engine());
        if(NewestData == null) {
            log("No occupation of MOB " + PD.getNid_engine() + "-> create new occupation");

            CurrentPositionsByNidId.update(PD.getNid_engine(), PD);
            log("Occupation for MOB " + PD.getNid_engine() + "-> successfuly created");

        } else {

            if(NewestData.getRbc_timestamp() < PD.getRbc_timestamp()) {
                log("Occupation of MOB " + PD.getNid_engine() + " existing -> update occupation");
                CurrentPositionsByNidId.update(PD.getNid_engine(), PD);
                log("Occupation for MOB " + PD.getNid_engine() + "-> successfuly updated");

            }
        }

        positionModuls.add(PD);
    }

    private void safeNewVehiclePosition(BigDecimal dVehicleEndOffset, ComposedRoute Route, NID_ENGINE nid_engine,
                                        SafeMOBPosition NewPosition, ETCS_DISTANCE distanceDiff, int iScale, boolean isInit) {
        SpotLocationIntrinsic beginSpot = null;
        SpotLocationIntrinsic endSpot = null;
        try {

            System.out.println("Vehicle End Offset " + dVehicleEndOffset);
            NewPosition.defineNewVehiclePosition(dVehicleEndOffset, Route, distanceDiff, iScale, nid_engine, isInit);
            beginSpot = (SpotLocationIntrinsic) NewPosition.getBegin().getLocation();
            endSpot = (SpotLocationIntrinsic) NewPosition.getEnd().getLocation();

        } catch (SmartLogicException e) {
            e.printStackTrace();
            throw new InvalidParameterException(e.getMessage());
        }
        PositionData CurrentPosition = this.getCurrentPosition(nid_engine.getId());
        MOBPosition newMobPosition = new MOBPosition(NewPosition);
        MovableObject train = MovableObject.ObjectRepo.getModel(nid_engine);
        ETCS_DISTANCE NoEndOffset = new ETCS_DISTANCE();
        NoEndOffset.sDistance = 0;
        if(train == null) {
            train = new MovableObject(nid_engine,newMobPosition);
        } else  { train.setPosition(newMobPosition); }
        VehicleOccupation occupationGenerated =
                VehicleOccupation.generateVehicleOccupation(CurrentPosition.getPos(), nid_engine, NewPosition,
                        (ArrayList<TrackEdgeSection>) NewPosition.getTrackEdgeSections(), beginSpot, endSpot);
        NewPosition.setOccupation(occupationGenerated);
        TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                VehicleOccupation.class, occupationGenerated);
    }


    private void handleSameBaliseGroup(BigDecimal trainLengthMeter, BigDecimal dVehicleEndOffset, PositionInfo Position, ComposedRoute Route, NID_ENGINE nid_engine, PositionInfo MaPositionInfo) {
        MAOccupation MaSmalled;
        BigDecimal diff;
        SafeMOBPosition NewPosition = new SafeMOBPosition();
        int iMaQscale = MaPositionInfo.q_scale;
        int iMaExponent = getExponent(iMaQscale);
        int iNewPosExponent = getExponent(Position.q_scale);
        BigDecimal NewOffset =
                new BigDecimal(Position.d_lrbg).multiply(new BigDecimal(10).pow(iNewPosExponent, MathContext.DECIMAL32));
        BigDecimal OldOffset =
                new BigDecimal(MaPositionInfo.d_lrbg).multiply(new BigDecimal(10).pow(iMaExponent, MathContext.DECIMAL32));

        diff = NewOffset.subtract(OldOffset).abs();
        ETCS_DISTANCE distanceDiff = new ETCS_DISTANCE();
        distanceDiff.sDistance = 0;
        ETCS_DISTANCE distanceEndDif = new ETCS_DISTANCE();
        distanceEndDif.sDistance = 0;
        if(trainLengthMeter != null) {
            try {
                //dVehicleEndOffset = Route.getRouteLength().subtract(diff).subtract(trainLengthMeter);
                dVehicleEndOffset = Route.getRouteLength().subtract(diff);
            } catch (SmartLogicException e) {
                e.printStackTrace();
                throw new InvalidParameterException(e.getMessage());
            }
        }

        int iScale = 1;
        try {
            distanceDiff.sDistance = diff.setScale(0, RoundingMode.HALF_DOWN).shortValueExact();
        } catch(ArithmeticException AE) {
            distanceDiff.sDistance = diff.divide(BigDecimal.valueOf(10)).setScale(0, RoundingMode.HALF_DOWN).shortValueExact();
            iScale = 2;
        }
        MovableObject train = MovableObject.ObjectRepo.getModel(nid_engine);
        ETCS_DISTANCE NoEndOffset = new ETCS_DISTANCE();
        NoEndOffset.sDistance = 0;
        if(diff.compareTo(trainLengthMeter) > 0) {
            distanceDiff.sDistance = (short) (distanceDiff.sDistance - trainLengthMeter.intValueExact());
            safeNewVehiclePosition(dVehicleEndOffset, Route, nid_engine, NewPosition, distanceDiff, iScale, false);
        }
        MaSmalled = new MAOccupation();

        MovementAuthority MA = new MovementAuthority();
        train.setMA(MA);
        MaSmalled.setMA(MA);
        MaSmalled.setApplicationDirection(TApplicationDirection.BOTH);
        try {
            MaSmalled = (MAOccupation) Route.createSubRoute(distanceDiff, NoEndOffset, iScale, MaSmalled);
        } catch (SmartLogicException e) {
            e.printStackTrace();
            throw new InvalidParameterException(e.getMessage());
        }

            System.out.println("Train: " + nid_engine.getId() + " Smalled MA having Length (m) : " +
                    MaSmalled.getMeterLength() + "distance: " + distanceDiff.sDistance);
            if(MaSmalled.getMeterLength().compareTo(BigDecimal.valueOf(0.1d)) < 0) {
                TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.RemoveOperation,
                        MAOccupation.class, MaSmalled);
            } else {
                TrackAndOccupationManager.startOperation(TrackAndOccupationManager.Operations.StoreOperation,
                        MAOccupation.class, MaSmalled);
            }
    }



    private int getExponent(int iMaQscale) {
        Q_SCALE QS = Q_SCALE.getScale(iMaQscale);
        int i_Exponent = iMaQscale - 1;
        if(QS.equals(Q_SCALE.SPARE)) {
            i_Exponent = 1;
        }
        return i_Exponent;
    }

    public void log(String sMsg) {
        try {
            EventBusManager.registerOrGetBus(1, false)
                    .log(sMsg,
                            SmartLogic.getsModuleId(POSITION_MODUL));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PositionData handleMovementAuthorities(PositionData pd, PositionEnterType enterType) throws SmartLogicException {
        ComposedRoute Route = this.getRouteOfNidEngine(pd.getNid_engine());
        if(enterType == null) {
            return pd;
        }
        if(enterType.equals(PositionEnterType.OTHER_ENTERING_TYPE)) {
            return pd;
        } else if(enterType.equals(PositionEnterType.ENTERED_VIA_POSITION_REPORT)) {
            return evaluatePositionReport(Route, pd);
        } else return pd;


    }

    private PositionData evaluatePositionReport(ComposedRoute route, PositionData PD) throws SmartLogicException {
        Boolean isTrainMovingNominal = null;
        int iDistanceToBalise = PD.getPos().d_lrbg;

        int iNidLrbg = PD.getPos().nid_lrbg;
        Balise B = Balise.baliseByNid_bg.getModel(iNidLrbg);
        if(B == null) throw new InvalidParameterException("Balise of Position Report not found");
        BigDecimal dTrainLength = UtilFunction.getTrainLength(PD.getPos());

        if(route == null) {
            // keine MA zum Zug der Position-Data
            // sicherheitshalber sämtliche Gleise sperren
            //return blockAllTrailsAffected(PD, isTrainMovingNominal, iDistanceToBalise, B);
            return PD;

        } else {
            if(route.getRouteLength().compareTo(dTrainLength) < 0) {
                return evaluatePositionReport(null, PD);
            }
            return PD;
            //return calcOccupationOLD(route, PD, iDistanceToBalise, B, dTrainLength);

            //TopologyGraph.Node N1 =


            //if(E.B.equals(N1)) {



            /*
            while(it.hasNext()) {
                Pair<Route.TrackElementType, TrackElement> OneElement = it.next();
                if(OneElement.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                    continue;
                } else if(OneElement.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {

                } else throw new NotImplementedException("TrackElementType not supported yet.");

            }*/
        }

    }

    @NotNull
    private PositionData calcOccupationOLD(ComposedRoute route, PositionData PD, int iDistanceToBalise, Balise B, BigDecimal dTrainLength) throws SmartLogicException {
        Boolean isTrainMovingNominal;
        Iterator<Pair<Route.TrackElementType, ITopological>> it = route.iterator();
        try {
            TopologyGraph.Edge E =
                    PlanData.topGraph.edgeRepo.get(B.getTopPositionOfDataPoint().getIdentitaet().getWert());
            if (it.hasNext()) {
                TopologyGraph.Edge Ed = (TopologyGraph.Edge) it.next().getValue();
                // Routenbeginn passt nicht zur Balise => ohne Route auswerten
                if (Ed == null || E == null) return evaluatePositionReport(null, PD);
                if(!E.equals(Ed)) return evaluatePositionReport(null, PD);
            }
            switch (PD.getPos().q_dirtrain) {
                case 0: {
                    VehicleOccupation EvaluatedOccupation = null;
                    isTrainMovingNominal = false;
                    BigDecimal tempDistance = new BigDecimal("0");
                    BigDecimal StartDistance = new BigDecimal(iDistanceToBalise).subtract(dTrainLength);
                    BigDecimal EndDistance = new BigDecimal(iDistanceToBalise);
                    TopologyGraph.Node N = B.getNodeInDirectionOfBaliseGroup(isTrainMovingNominal);
                    if (it.hasNext()) {
                        Pair<Route.TrackElementType, ITopological> RouteNode = it.next();
                        if(RouteNode.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                            if(N.equals(RouteNode.getValue())) {
                                if(route.getRouteLength().compareTo(BigDecimal.valueOf(iDistanceToBalise))>= 0) {
                                    BigDecimal CurrentDistance = new
                                            BigDecimal(E.dTopLength).subtract(B.getBalisenPositionFromNodeA());

                                    while(StartDistance.compareTo(CurrentDistance) >= 0) {
                                        tempDistance = BigDecimal.valueOf(CurrentDistance.doubleValue());

                                        Pair<Route.TrackElementType, ITopological> Element = it.next();
                                        if(Element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                                            E = (TopologyGraph.Edge) Element.getValue();
                                            CurrentDistance.add(BigDecimal.valueOf(E.dTopLength));
                                        }

                                    }
                                    TopologyGraph.Edge StartEdge = E;
                                    BigDecimal dDistanceFromA = StartDistance.subtract(tempDistance);
                                    CurrentDistance = CurrentDistance.add(BigDecimal.valueOf(E.dTopLength));
                                    while(CurrentDistance.compareTo(EndDistance) < 0) {
                                        tempDistance = new BigDecimal(CurrentDistance.doubleValue());




                                        VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                dDistanceFromA.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                (int) E.dTopLength);
                                        PD.mergeOtherOccupationIntoThis(VO);
                                        Pair<Route.TrackElementType, ITopological> Element = it.next();
                                        if(Element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                                            E = (TopologyGraph.Edge) Element.getValue();
                                            CurrentDistance.add(BigDecimal.valueOf(E.dTopLength));
                                        }


                                    }
                                    BigDecimal dEndDistance = EndDistance.subtract(tempDistance);
                                    if(E.equals(StartEdge)) {
                                        VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                dDistanceFromA.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                dEndDistance.intValue());
                                        PD.mergeOtherOccupationIntoThis(VO);

                                    } else {
                                        VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                0, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                dEndDistance.intValue());
                                        PD.mergeOtherOccupationIntoThis(VO);

                                    }
                                    return PD;


                                } else return evaluatePositionReport(null, PD);
                            } else return evaluatePositionReport(null, PD);
                        } else {
                            return evaluatePositionReport(null, PD);
                        }
                    } else {
                        BigDecimal endDistanceFromA = B.getBalisenPositionFromNodeA().add(
                                new BigDecimal(iDistanceToBalise)
                        );
                        if(new BigDecimal(E.dTopLength).compareTo(endDistanceFromA) >= 0) {
                            VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                    B.getBalisenPositionFromNodeA().intValue(),
                                    Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, endDistanceFromA.intValue());
                            PD.mergeOtherOccupationIntoThis(VO);

                            return PD;
                        } else return evaluatePositionReport(null, PD);
                    }

                }
                case 1: {
                    isTrainMovingNominal = true;
                    TopologyGraph.Node N = B.getNodeInDirectionOfBaliseGroup(isTrainMovingNominal);
                }
                default: {
                    // Beweungsrichtung unbekannt => ohne Route auswerten
                    return evaluatePositionReport(null, PD);
                }
            }
        } catch(Exception E) {
            return evaluatePositionReport(null, PD);
        }
    }

    @NotNull
    private PositionData blockAllTrailsAffected(PositionData PD, Boolean isTrainMovingNominal, int iDistanceToBalise, Balise B) {
        ArrayList<TopologyGraph.Edge> visitedEdgesList = new ArrayList<>();
        ArrayList<TopologyGraph.Edge> toVisitEdgesList = new ArrayList<>();
        ArrayList<BigDecimal> toVisitMeters = new ArrayList<>();

        switch (PD.getPos().q_dirtrain) {
            case 0: {
                isTrainMovingNominal = false;
                return blockPossiblePosOfTrain(PD, isTrainMovingNominal, iDistanceToBalise, B, visitedEdgesList, toVisitEdgesList, toVisitMeters);

            }
            case 1: {
                isTrainMovingNominal = true;
                return blockPossiblePosOfTrain(PD, isTrainMovingNominal, iDistanceToBalise, B, visitedEdgesList, toVisitEdgesList, toVisitMeters);
            }
            default: {
                PD = blockPossiblePosOfTrain(PD, true, iDistanceToBalise, B, visitedEdgesList, toVisitEdgesList, toVisitMeters);
                return blockPossiblePosOfTrain(PD, isTrainMovingNominal, iDistanceToBalise, B, visitedEdgesList, toVisitEdgesList, toVisitMeters);

            }
        }
    }

    @NotNull
    private PositionData blockPossiblePosOfTrain(PositionData PD, Boolean isTrainMovingNominal, int iDistanceToBalise, Balise b, ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, ArrayList<BigDecimal> toVisitMeters) {
        PositionData PD1 = handleBaliseEdge(PD, isTrainMovingNominal, iDistanceToBalise, b, visitedEdgesList, toVisitEdgesList, toVisitMeters);
        if (PD1 != null) return PD1;
        TopologyGraph.Edge E;

        while(!toVisitEdgesList.isEmpty()) {
            E = toVisitEdgesList.get(0);
            toVisitEdgesList.remove(0);
            BigDecimal tempToReserve = toVisitMeters.get(0);
            toVisitMeters.remove(0);
            tempToReserve.subtract(new BigDecimal(E.dTopLength));
            VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, 0 ,
                    Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
            PD.mergeOtherOccupationIntoThis(VO);

            if(tempToReserve.compareTo(new BigDecimal("0")) <= 0) continue;
            else {
                visitEdge(visitedEdgesList, toVisitEdgesList, E.A, E, tempToReserve, toVisitMeters);
                visitEdge(visitedEdgesList, toVisitEdgesList, E.B, E, tempToReserve, toVisitMeters);
            }
        }
        return PD;
    }

    @Nullable
    private PositionData handleBaliseEdge(PositionData PD, Boolean isTrainMovingNominal, int iDistanceToBalise, Balise b, ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, ArrayList<BigDecimal> toVisitMeters) {
        TopologyGraph.Node N1;
        BigDecimal iToReserve = new BigDecimal(iDistanceToBalise);
        N1 = b.getNodeInDirectionOfBaliseGroup(isTrainMovingNominal);
        BigDecimal dDistanceFromA = b.getBalisenPositionFromNodeA();
        TopologyGraph.Edge E =
                PlanData.topGraph.edgeRepo.get(b.getTopPositionOfDataPoint().getIdentitaet().getWert());
        if(E.B.equals(N1)) {
            VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                    dDistanceFromA.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
            PD.mergeOtherOccupationIntoThis(VO);
            iToReserve = iToReserve.subtract(new BigDecimal(E.dTopLength).subtract(dDistanceFromA));
            if(iToReserve.compareTo(new BigDecimal("0")) <= 0) return PD;

            visitEdge(visitedEdgesList, toVisitEdgesList, N1, E, iToReserve, toVisitMeters);
        } else {
            VehicleOccupation VO = new VehicleOccupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                    0, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, dDistanceFromA.intValue());
            PD.mergeOtherOccupationIntoThis(VO);
            iToReserve = iToReserve.subtract(dDistanceFromA);
            //PD.add(StartArea);
            if(iToReserve.compareTo(new BigDecimal("0")) <= 0) return PD;
            toVisitMeters.add(iToReserve);
            visitEdge(visitedEdgesList, toVisitEdgesList, N1, E, iToReserve, toVisitMeters);
        }
        return null;
    }

    private void visitEdge(ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, TopologyGraph.Node n1, TopologyGraph.Edge e, BigDecimal iToReserve, ArrayList<BigDecimal> toVisitMeters) {
        visitedEdgesList.add(e);
        Iterator<TopologyGraph.Edge> itEdges = n1.inEdges.iterator();
        Iterator<TopologyGraph.Edge> itEdges2 = n1.outEdges.iterator();
        // sucht Kanten, die noch nicht besucht wurden
        searchPath(visitedEdgesList, toVisitEdgesList, itEdges, iToReserve , toVisitMeters);
        searchPath(visitedEdgesList, toVisitEdgesList, itEdges2, iToReserve, toVisitMeters);
    }

    private void searchPath(ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, Iterator<TopologyGraph.Edge> itEdges, BigDecimal iToReserve, ArrayList<BigDecimal> toVisitMeters) {
        while(itEdges.hasNext()) {
            TopologyGraph.Edge tempEdge = itEdges.next();
            if(!visitedEdgesList.contains(tempEdge)) {
                toVisitEdgesList.add(tempEdge);
                toVisitMeters.add(iToReserve);
            }
        }
    }

    public void updateCurrentRoute(int iNidEngineId, ComposedRoute R) {
        this.routeByNidId.update(iNidEngineId, R);
    }

    public ComposedRoute getRouteOfNidEngine(int iNidEngineId) {
        return this.routeByNidId.getModel(iNidEngineId);
    }

    /**
     * Gibt aktuelle Positionsangaben aller Z&uuml;ge wider
     * @return Collection - Positionsangaben
     */
    @Override
    public Collection<PositionData> getCurrentPositions() {

           return filterTime(CurrentPositionsByNidId.getAll());

    }

    /**
     * Gibt aktuelle Position des angeforderten Zuges wider
     * @param iNidEngine - Id des angeforderten Zuges
     * @return PositionData
     */
    @Override
    public PositionData getCurrentPosition(int iNidEngine) {
        PositionData PD =  CurrentPositionsByNidId.getModel(iNidEngine);
        if(posDataIsAccepted(PD)) {
            return PD;
        }
        return null;
    }


    @Override
    /**
     * @deprecated
     */
    public Collection<PositionData> getCurrentPositions(Integer iNidEngine, String sIdTopEdge, BigDecimal dFromRangeStart, BigDecimal dToRangeEnd) {
        if(hasRangeFilter(dFromRangeStart, dToRangeEnd)) {
            if (dFromRangeStart.compareTo(dToRangeEnd) > 0)
                throw new InvalidParameterException("Start after End Range");
        }
        Collection<PositionData> results = getCurrentPositions();
        if(iNidEngine != null) {
            PositionData PD = getCurrentPosition(iNidEngine);
            if(PD == null) {
                return new CopyOnWriteArrayList<>();
            } else {
               results.removeAll(results);
               results.add(PD);
            }
        }
        if(sIdTopEdge != null && !hasRangeFilter(dFromRangeStart, dToRangeEnd)) {
            // Positionsdatum entfernene wenn die Kante nicht gefunden wurde
            // filtert alle Position, die die Kante mit der Id sIdTopEdge nicht beinhalten
            results.removeIf(PD -> !checkIfPositionContainsTopEdge(PD,sIdTopEdge));
        }
        if(hasRangeFilter(dFromRangeStart, dToRangeEnd)) {
            if(dFromRangeStart.compareTo(dToRangeEnd) > 0) throw new InvalidParameterException("Start after End Range");
            // entfernt alle daten, die keine Schnittfläche zwischen Anfrage und Tatsächlichen Positionsangabe haben
            //results.removeIf(PD -> !checkIfPositionContainsTopEdge(PD, sIdTopEdge, dFromRangeStart, dToRangeEnd));
        }
        return results;

    }



    public boolean hasRangeFilter(BigDecimal dFromRangeStart, BigDecimal dToRangeEnd) {
        return dFromRangeStart != null && dToRangeEnd != null;
    }

    /**
     * @deprecated
     * @param pd
     * @param sIdTopEdge
     * @param dFromRangeStart
     * @param dToRangeEnd
     * @return
     */
    private boolean checkIfPositionContainsTopEdge(PositionData pd, String sIdTopEdge, BigDecimal dFromRangeStart, BigDecimal dToRangeEnd) {
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(sIdTopEdge);
        if(E == null) return false;
        Occupation RequestArea = new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                dFromRangeStart.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) dToRangeEnd.intValue(), Occupation.CLASS_IDENTIFIER);
        return false;
    }

    /**
     * @deprecated
     * @param pd
     * @param sIdTopEdge
     * @return
     */
    private boolean checkIfPositionContainsTopEdge(PositionData pd, String sIdTopEdge) {
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(sIdTopEdge);
        if(E == null) return false;
        Occupation RequestArea = new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                0, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength, Occupation.CLASS_IDENTIFIER);
        return false;
    }

    @Override
    public Collection<PositionData> getAllPositions() {
        return filterTime(this.positionModuls);
    }

    @Override
    public Collection<PositionData> getAllPositions(int iNidEngine) {
        Collection<PositionData> data = getAllPositions();
        data.removeIf(PD -> PD.getNid_engine() != iNidEngine);
        return data;
    }





    @Override
    /**
     * @deprecated
     */
    public Collection<PositionData> getAllPositions(Integer iNidEngine, String sIdTopEdge, BigDecimal dFromRangeStart, BigDecimal dToRangeEnd) {
        Collection<PositionData> data = getAllPositions();
        if(iNidEngine != null) {
            data = getAllPositions(iNidEngine);
        }
        if(sIdTopEdge != null && !hasRangeFilter(dFromRangeStart, dToRangeEnd)) {
            data.removeIf(PD -> !checkIfPositionContainsTopEdge(PD, sIdTopEdge));
        }
        if(hasRangeFilter(dFromRangeStart, dToRangeEnd)) {
            if(dFromRangeStart.compareTo(dToRangeEnd) > 0) throw new InvalidParameterException("Start after End Range");
            // entfernt alle daten nach range End
            data.removeIf(PD -> !checkIfPositionContainsTopEdge(PD, sIdTopEdge, dFromRangeStart, dToRangeEnd));
        }
        return data;
    }

    @Deprecated
    @Override
    /**
     * has to be synchronised
     */
    public void setTimeFilter(boolean bIsRbc, long lFrom, long lTo) {
        this.isRbcTimeFiltering = bIsRbc;
        this.lFrom = lFrom;
        this.lTo = lTo;
    }

    @Override
    public void resetTimeFilter() {
        this.isRbcTimeFiltering = null;
        this.lFrom = 0L;
        this.lTo = 0L;
    }
}
