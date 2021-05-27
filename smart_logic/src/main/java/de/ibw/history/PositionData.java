package de.ibw.history;

import de.ibw.tms.ma.occupation.VehicleOccupation;
import ebd.internal.util.PositionInfo;
import ebd.internal.util.TrainInfo;

import java.util.Date;

/**
 * Speichert Positionsdaten aus Positionreport mit Gleis-Id und Topologischen Abstand zum Knoten A
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-11-06
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
     * @deprecated
     * @param VehicleOcc
     */
    public void mergeOtherOccupationIntoThis(VehicleOccupation VehicleOcc) {
        /*List<TrackEdgeSection> sectionList = this.getTrackEdgeSections();
        List<TrackEdgeSection> otherSections = VehicleOcc.getTrackEdgeSections();
        if(otherSections == null) throw new InvalidParameterException("Sections must be defined");
        if(sectionList == null) sectionList = new ArrayList<>();
        if(sectionList.size() == 0) {
            this.setTrackEdgeSections(otherSections);
            return;
        }
        sectionList.addAll(otherSections);
        */

    }



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
}
