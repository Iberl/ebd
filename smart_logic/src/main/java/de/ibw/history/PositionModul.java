package de.ibw.history;

import de.ibw.history.data.RouteDataSL;
import de.ibw.history.data.RouteMap;
import de.ibw.smart.logic.datatypes.BlockedArea;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.util.ThreadedRepo;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
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
    public void addPositionData(PositionData PD) {
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
