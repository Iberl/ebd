package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 66 <br>
 * Type: Track To Train <br>
 * Description: Temporary Speed Restriction Revocation <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Packet_66 extends TrackPacketDIR {

    // --------------------------------------
    // Temporary Speed Restriction Revocation
    // --------------------------------------

    /** {@link ETCSVariables#NID_TSR} */
    @BitLength(8)
    @OrderIndex(3)
    public int NID_TSR = ETCSVariables.NID_TSR;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_66}
     *
     * @author Christopher Bernjus
     */
    public Packet_66() { super(66); }

    /**
     * Constructs A {@link Packet_66}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param NID_TSR
     *            {@link ETCSVariables#NID_TSR}
     *
     * @author Christopher Bernjus
     */
    public Packet_66(int Q_DIR, int NID_TSR) {
        super(66, Q_DIR);
        this.NID_TSR = NID_TSR;
    }
}
