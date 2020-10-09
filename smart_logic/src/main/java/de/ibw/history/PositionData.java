package de.ibw.history;

import de.ibw.smart.logic.datatypes.BlockedArea;
import de.ibw.tms.plan_pro.adapter.topology.trackbased.TopologicalPosition;
import ebd.rbc_tms.util.PositionInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Speichert Positionsdaten aus Positionreport mit Gleis-Id und Topologischen Abstand zum Knoten A
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-09-30
 */
public class PositionData extends ArrayList<BlockedArea> implements List<BlockedArea> {
    /** Timestamp Of Message Creation */
    private long rbc_timestamp;

    /** Timestamp Received */
    private long received_timestamp;

    /** ETCSVariables#NID_ENGINE */
    private int nid_engine;

    /**
     * Positionsangaben vom RBC
     */
    private PositionInfo Pos;


    private TopologicalPosition TrainHeadPosition;

    private TopologicalPosition TrainEndPosition;




    public long getRbc_timestamp() {
        return rbc_timestamp;
    }

    public long getReceived_timestamp() {
        return received_timestamp;
    }

    public PositionData(long rbc_timestamp, long received_timestamp, int nid_engine, PositionInfo pos) {
        this.rbc_timestamp = rbc_timestamp;
        this.received_timestamp = received_timestamp;
        this.nid_engine = nid_engine;
        Pos = pos;
    }


    public void setTrainHeadPosition(TopologicalPosition trainHeadPosition) {
        TrainHeadPosition = trainHeadPosition;
    }

    public void setTrainEndPosition(TopologicalPosition trainEndPosition) {
        TrainEndPosition = trainEndPosition;
    }

    public void setRbc_timestamp(long rbc_timestamp) {
        this.rbc_timestamp = rbc_timestamp;
    }


    public Date getRbcTimestamp() {
        return new Date(rbc_timestamp);
    }

    public Date getReceivedTimeStamp() {
        return new Date(received_timestamp);
    }

    public int getNid_engine() {
        return nid_engine;
    }

    public PositionInfo getPos() {
        return Pos;
    }

    public TopologicalPosition getTrainHeadPosition() {
        return TrainHeadPosition;
    }

    public TopologicalPosition getTrainEndPosition() {
        return TrainEndPosition;
    }
}
