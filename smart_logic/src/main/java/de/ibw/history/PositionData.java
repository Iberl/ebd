package de.ibw.history;

import de.ibw.util.ThreadedRepo;
import ebd.rbc_tms.util.PositionInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Speichert Positionsdaten aus Positionreport mit Gleis-Id und Topologischen Abstand zum Knoten A
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-09-30
 */
public class PositionData {
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

    /**
     * PlanPro-String-Id der Topologischen Kante
     */
    private String sIdTopEdge;

    /**
     * Distanz zum A Knoten der Topologischen Kante mit Id sIdTopEdge
     */
    private BigDecimal dDistanceToTopNodeA;

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


    public void setRbc_timestamp(long rbc_timestamp) {
        this.rbc_timestamp = rbc_timestamp;
    }

    public void setsIdTopEdge(String sIdTopEdge) {
        this.sIdTopEdge = sIdTopEdge;
    }

    public void setdDistanceToTopNodeA(BigDecimal dDistanceToTopNodeA) {
        this.dDistanceToTopNodeA = dDistanceToTopNodeA;
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

    public String getsIdTopEdge() {
        return sIdTopEdge;
    }

    public BigDecimal getdDistanceToTopNodeA() {
        return dDistanceToTopNodeA;
    }
}
