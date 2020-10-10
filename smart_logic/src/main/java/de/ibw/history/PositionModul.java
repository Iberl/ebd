package de.ibw.history;

import de.ibw.feed.Balise;
import de.ibw.history.data.PositionEnterType;
import de.ibw.history.data.RouteDataSL;
import de.ibw.history.data.RouteMap;
import de.ibw.smart.logic.datatypes.BlockedArea;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;

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
    public void addPositionData(PositionData PD, PositionEnterType EnterType) {
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
        Balise B = Balise.baliseByNid_bg.getModel(iDistanceToBalise);
        if(B == null) throw new InvalidParameterException("Balise of Position Report not found");


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
            throw new NotImplementedException("");
        }

    }

    @NotNull
    private PositionData blockPossiblePosOfTrain(PositionData PD, Boolean isTrainMovingNominal, int iDistanceToBalise, Balise b, ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, ArrayList<BigDecimal> toVisitMeters) {
        TopologyGraph.Node N1;
        BigDecimal iToReserve = new BigDecimal(iDistanceToBalise);
        N1 = b.getNodeInDirectionOfBaliseGroup(isTrainMovingNominal);
        BigDecimal dDistanceFromA = b.getBalisenPositionFromNodeA();
        TopologyGraph.Edge E =
                PlanData.topGraph.EdgeRepo.get(b.getTopPositionOfDataPoint().getIdentitaet().getWert());
        if(E.B.equals(N1)) {
            BlockedArea StartArea = new BlockedArea(E, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M,
                    dDistanceFromA.intValue(), BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
            iToReserve = iToReserve.subtract(new BigDecimal(E.dTopLength).subtract(dDistanceFromA));
            PD.add(StartArea);
            if(iToReserve.compareTo(new BigDecimal("0")) <= 0) return PD;
            visitEdge(visitedEdgesList, toVisitEdgesList, N1, E, iToReserve);
        } else {
            BlockedArea StartArea = new BlockedArea(E, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M,
                    0, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M, dDistanceFromA.intValue());
            iToReserve = iToReserve.subtract(dDistanceFromA);
            PD.add(StartArea);
            if(iToReserve.compareTo(new BigDecimal("0")) <= 0) return PD;

            visitEdge(visitedEdgesList, toVisitEdgesList, N1, E, iToReserve);
        }

        while(!toVisitEdgesList.isEmpty()) {
            E = toVisitEdgesList.get(0);
            toVisitEdgesList.remove(0);
            BigDecimal tempToReserve = toVisitMeters.get(0);
            toVisitMeters.remove(0);
            tempToReserve.subtract(new BigDecimal(E.dTopLength));
            PD.add(new BlockedArea(E, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M, 0 ,
                    BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength));
            if(tempToReserve.compareTo(new BigDecimal("0")) <= 0) continue;
            else {
                visitEdge(visitedEdgesList, toVisitEdgesList, E.A, E, tempToReserve);
                visitEdge(visitedEdgesList, toVisitEdgesList, E.B, E, tempToReserve);
            }
        }
        return PD;
    }

    private void visitEdge(ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, TopologyGraph.Node n1, TopologyGraph.Edge e, BigDecimal iToReserve) {
        visitedEdgesList.add(e);
        Iterator<TopologyGraph.Edge> itEdges = n1.inEdges.iterator();
        Iterator<TopologyGraph.Edge> itEdges2 = n1.outEdges.iterator();
        // sucht Kanten, die noch nicht besucht wurden
        searchPath(visitedEdgesList, toVisitEdgesList, itEdges, iToReserve);
        searchPath(visitedEdgesList, toVisitEdgesList, itEdges2, iToReserve);
    }

    private void searchPath(ArrayList<TopologyGraph.Edge> visitedEdgesList, ArrayList<TopologyGraph.Edge> toVisitEdgesList, Iterator<TopologyGraph.Edge> itEdges, BigDecimal iToReserve) {
        while(itEdges.hasNext()) {
            TopologyGraph.Edge tempEdge = itEdges.next();
            if(!visitedEdgesList.contains(tempEdge)) {
                toVisitEdgesList.add(tempEdge);
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
        TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(sIdTopEdge);
        if(E == null) return false;
        BlockedArea RequestArea = new BlockedArea(E, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M,
                dFromRangeStart.intValue(), BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M, (int) dToRangeEnd.intValue());
        Iterator PosIterate = pd.iterator(); {
            while(PosIterate.hasNext()) {
                BlockedArea BA = (BlockedArea) PosIterate.next();
                if(BA.compareIfIntersection(RequestArea)) return true;
            }

        }
        return false;
    }
    private boolean checkIfPositionContainsTopEdge(PositionData pd, String sIdTopEdge) {
        TopologyGraph.Edge E = PlanData.topGraph.EdgeRepo.get(sIdTopEdge);
        if(E == null) return false;
        BlockedArea RequestArea = new BlockedArea(E, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M,
                0, BlockedArea.BLOCK_Q_SCALE.Q_SCALE_1M, (int) E.dTopLength);
        Iterator PosIterate = pd.iterator(); {
            while(PosIterate.hasNext()) {
                BlockedArea BA = (BlockedArea) PosIterate.next();
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
