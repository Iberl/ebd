package ebd.trainData.util.dataConstructs;

import ebd.messageLibrary.packet.trackpackets.Packet_58;

import java.util.List;

/**
 * Data construct to contain both the incremental distances and the associated reference location id,
 * see {@link ebd.messageLibrary.util.ETCSVariables#NID_LRBG}.
 */
public class IncrPosRprtDist {

    private String refLocID;

    /**
     * Distances in [m]
     */
    private List<Packet_58.Packet_58_Interval> incrementalDistances;

    /**
     * Data construct to contain both the incremental distances and the associated reference location id,
     * see {@link ebd.messageLibrary.util.ETCSVariables#NID_LRBG}.
     *
     * @param refLocID reference location ID
     * @param incrementalDistances A list of the distances
     */
    public IncrPosRprtDist(String refLocID, List<Packet_58.Packet_58_Interval> incrementalDistances) {
        this.refLocID = refLocID;
        this.incrementalDistances = incrementalDistances;
    }
}
