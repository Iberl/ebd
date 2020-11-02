package de.ibw.history;

import de.ibw.feed.Balise;
import de.ibw.history.data.PositionEnterType;
import de.ibw.history.data.RouteDataSL;
import de.ibw.history.data.RouteMap;
import de.ibw.smart.logic.datatypes.Occupation;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.physical.ITrackElement;
import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.plan.elements.interfaces.ITrack;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;
import de.ibw.util.UtilFunction;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
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
 * @version 0.4
 * @since 2020-09-30
 */
public class PositionModul implements IPositionModul {
     private CopyOnWriteArrayList<PositionData> positionModuls = new CopyOnWriteArrayList<>();
     private ThreadedRepo<Integer, PositionData> CurrentPositionsByNidId = new ThreadedRepo<>();
     private RouteMap routeByNidId = new RouteMap();
     private Boolean isRbcTimeFiltering = null;

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

    private static PositionModul instance = null;

    /**
     * Singleton f&uuml;r dieses Modul
     * @return PositionModul
     */
    public static PositionModul getInstance() {
        if(instance == null) {
            instance = new PositionModul();
        }
        return instance;
    }

    /**
     * Nimmt ein Positionsdatum auf
     * @param PD - {@link PositionData}  - Postionsangabe die aufgenommen wird
     */
    public synchronized void addPositionData(PositionData PD, PositionEnterType EnterType) {
        if(PD == null) throw new NullPointerException("Position Data must not be Null");
        PD = handleMovementAuthorities(PD, EnterType);
        PositionData NewestData = CurrentPositionsByNidId.getModel(PD.getNid_engine());
        if(NewestData == null) {
            CurrentPositionsByNidId.update(PD.getNid_engine(), PD);

        } else {
            if(NewestData.getRbc_timestamp() < PD.getRbc_timestamp()) {
                CurrentPositionsByNidId.update(PD.getNid_engine(), PD);
            }
        }
        positionModuls.add(PD);
    }

    private PositionData handleMovementAuthorities(PositionData pd, PositionEnterType enterType) {
        RouteDataSL Route = this.getRouteOfNidEngine(pd.getNid_engine());
        if(enterType == null) {
            return pd;
        }
        if(enterType.equals(PositionEnterType.OTHER_ENTERING_TYPE)) {
            return pd;
        } else if(enterType.equals(PositionEnterType.ENTERED_VIA_POSITION_REPORT)) {
            return evaluatePositionReport(Route, pd);
        } else return pd;


    }

    private PositionData evaluatePositionReport(RouteDataSL route, PositionData PD) {
        Boolean isTrainMovingNominal = null;
        int iDistanceToBalise = PD.getPos().d_lrbg;

        int iNidLrbg = PD.getPos().nid_lrbg;
        Balise B = Balise.baliseByNid_bg.getModel(iNidLrbg);
        if(B == null) throw new InvalidParameterException("Balise of Position Report not found");
        BigDecimal dTrainLength = UtilFunction.getTrainLength(PD.getPos());

        if(route == null) {
            // keine MA zum Zug der Position-Data
            // sicherheitshalber sämtliche Gleise sperren
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


        } else {
            if(route.getRouteLength().compareTo(dTrainLength) < 0) {
                return evaluatePositionReport(null, PD);
            }
            Iterator<Pair<Route.TrackElementType, TrackElement>> it = route.iterator();
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
                        isTrainMovingNominal = false;
                        BigDecimal tempDistance = new BigDecimal("0");
                        BigDecimal StartDistance = new BigDecimal(iDistanceToBalise).subtract(dTrainLength);
                        BigDecimal EndDistance = new BigDecimal(iDistanceToBalise);
                        TopologyGraph.Node N = B.getNodeInDirectionOfBaliseGroup(isTrainMovingNominal);
                        if (it.hasNext()) {
                            Pair<Route.TrackElementType, TrackElement> RouteNode = it.next();
                            if(RouteNode.getKey().equals(Route.TrackElementType.CROSSOVER_TYPE)) {
                                if(N.equals(RouteNode.getValue())) {
                                    if(route.getRouteLength().compareTo(BigDecimal.valueOf(iDistanceToBalise))>= 0) {
                                        BigDecimal CurrentDistance = new
                                                BigDecimal(E.dTopLength).subtract(B.getBalisenPositionFromNodeA());

                                        while(StartDistance.compareTo(CurrentDistance) >= 0) {
                                            tempDistance = new BigDecimal(CurrentDistance.doubleValue());

                                            Pair<Route.TrackElementType, TrackElement> Element = it.next();
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
                                            PD.add(new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                    dDistanceFromA.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                    (int) E.dTopLength));
                                            Pair<Route.TrackElementType, TrackElement> Element = it.next();
                                            if(Element.getKey().equals(Route.TrackElementType.RAIL_TYPE)) {
                                                E = (TopologyGraph.Edge) Element.getValue();
                                                CurrentDistance.add(BigDecimal.valueOf(E.dTopLength));
                                            }


                                        }
                                        BigDecimal dEndDistance = EndDistance.subtract(tempDistance);
                                        if(E.equals(StartEdge)) {
                                            PD.add(new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                    dDistanceFromA.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                    dEndDistance.intValue()));
                                        } else {
                                            PD.add(new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                    0, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                                    dEndDistance.intValue()));
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
                                PD.add(new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                                        B.getBalisenPositionFromNodeA().intValue(),
                                        Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, endDistanceFromA.intValue()));
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
            PD.add(new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, 0 ,
                    Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength));
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
            Occupation StartArea = new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                    dDistanceFromA.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
            iToReserve = iToReserve.subtract(new BigDecimal(E.dTopLength).subtract(dDistanceFromA));
            PD.add(StartArea);
            if(iToReserve.compareTo(new BigDecimal("0")) <= 0) return PD;

            visitEdge(visitedEdgesList, toVisitEdgesList, N1, E, iToReserve, toVisitMeters);
        } else {
            Occupation StartArea = new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                    0, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, dDistanceFromA.intValue());
            iToReserve = iToReserve.subtract(dDistanceFromA);
            PD.add(StartArea);
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

    public void updateCurrentRoute(int iNidEngineId, RouteDataSL R) {
        this.routeByNidId.update(iNidEngineId, R);
    }

    public RouteDataSL getRouteOfNidEngine(int iNidEngineId) {
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
            results.removeIf(PD -> !checkIfPositionContainsTopEdge(PD, sIdTopEdge, dFromRangeStart, dToRangeEnd));


        }
        return results;

    }



    public boolean hasRangeFilter(BigDecimal dFromRangeStart, BigDecimal dToRangeEnd) {
        return dFromRangeStart != null && dToRangeEnd != null;
    }
    private boolean checkIfPositionContainsTopEdge(PositionData pd, String sIdTopEdge, BigDecimal dFromRangeStart, BigDecimal dToRangeEnd) {
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(sIdTopEdge);
        if(E == null) return false;
        Occupation RequestArea = new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                dFromRangeStart.intValue(), Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) dToRangeEnd.intValue());
        Iterator PosIterate = pd.iterator(); {
            while(PosIterate.hasNext()) {
                Occupation BA = (Occupation) PosIterate.next();
                if(BA.compareIfIntersection(RequestArea)) return true;
            }

        }
        return false;
    }
    private boolean checkIfPositionContainsTopEdge(PositionData pd, String sIdTopEdge) {
        TopologyGraph.Edge E = PlanData.topGraph.edgeRepo.get(sIdTopEdge);
        if(E == null) return false;
        Occupation RequestArea = new Occupation(E, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M,
                0, Occupation.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
        Iterator PosIterate = pd.iterator(); {
            while(PosIterate.hasNext()) {
                Occupation BA = (Occupation) PosIterate.next();
                if(BA.compareIfIntersection(RequestArea)) return true;
            }

        }
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

    @Override
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
