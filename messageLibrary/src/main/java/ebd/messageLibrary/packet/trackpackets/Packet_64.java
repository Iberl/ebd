package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 64 <br>
 * Type: Track To Train <br>
 * Description: Inhibition Of Revocable TSRs From Balise in L2/3 <br>
 * Transmitted By: RBC
 *
 * @author Christopher Bernjus
 */
@OrderLength(3)
public class Packet_64 extends TrackPacketDIR {

    // ------------------------------------------------
    // Inhibition Of Revocable TSRs From Balise in L2/3
    // ------------------------------------------------


    // Constructors

    /**
     * Constructs An Empty {@link Packet_64}
     *
     * @author Christopher Bernjus
     */
    public Packet_64() { super(64); }

    /**
     * Constructs A {@link Packet_64}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     *
     * @author Christopher Bernjus
     */
    public Packet_64(int Q_DIR) {
        super(64, Q_DIR);
    }
}
