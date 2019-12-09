package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 45 <br>
 * Type: Track To Train <br>
 * Description: Radio Network Registration <br>
 * Transmitted By: Balise, RBC, RIU
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Packet_45 extends TrackPacketDIR {

    // --------------------------
    // Radio Network Registration
    // --------------------------

    /** {@link ETCSVariables#NID_MN} */
    @BitLength(24)
    @OrderIndex(3)
    public int NID_MN = ETCSVariables.NID_MN;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_45}
     *
     * @author Christopher Bernjus
     */
    public Packet_45() { super(45); }

    /**
     * Constructs A {@link Packet_45}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param NID_MN
     *            {@link ETCSVariables#NID_MN}
     *
     * @author Christopher Bernjus
     */
    public Packet_45(int Q_DIR, int NID_MN) {
        super(45, Q_DIR);
        this.NID_MN = NID_MN;
    }
}
