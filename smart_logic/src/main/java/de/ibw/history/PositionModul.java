package de.ibw.history;

import de.ibw.util.ThreadedRepo;
import ebd.globalUtils.position.Position;

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
            if(lFrom < posDat.getRbc_timestamp() && posDat.getRbc_timestamp() < lTo) {
                return true;
            }
        } else {
            if(lFrom < posDat.getReceived_timestamp() && posDat.getReceived_timestamp() < lTo) {
                return true;
            }
        }
        return false;

    }

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

    @Override
    public Collection<PositionData> getCurrentPositions() {

           return filterTime(CurrentPositionsByNidId.getAll());

    }

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
        if(dFromRangeStart != null && dToRangeEnd != null) {
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
        if(sIdTopEdge != null) {
            results.removeIf(PD -> !PD.getsIdTopEdge().equals(sIdTopEdge));
        }
        if(dFromRangeStart != null && dToRangeEnd != null) {
            if(dFromRangeStart.compareTo(dToRangeEnd) > 0) throw new InvalidParameterException("Start after End Range");
            // entfernt alle daten nach range End
            results.removeIf(PD -> dToRangeEnd.compareTo(PD.getdDistanceToTopNodeA()) < 0);
            // entfernt alle daten vor range beginn
            results.removeIf(PD -> PD.getdDistanceToTopNodeA().compareTo(dFromRangeStart) < 0);
        }
        return results;

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
        if(sIdTopEdge != null) {
            data.removeIf(PD -> !PD.getsIdTopEdge().equals(sIdTopEdge));
        }
        if(dFromRangeStart != null && dToRangeEnd != null) {
            if(dFromRangeStart.compareTo(dToRangeEnd) > 0) throw new InvalidParameterException("Start after End Range");
            // entfernt alle daten nach range End
            data.removeIf(PD -> dToRangeEnd.compareTo(PD.getdDistanceToTopNodeA()) < 0);
            // entfernt alle daten vor range beginn
            data.removeIf(PD -> PD.getdDistanceToTopNodeA().compareTo(dFromRangeStart) < 0);
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
