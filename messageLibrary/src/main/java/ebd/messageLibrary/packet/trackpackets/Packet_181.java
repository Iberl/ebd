package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 181 <br>
 * Type: Track To Train <br>
 * Description: Generic LS Function Marker <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(3)
public class Packet_181 extends TrackPacketDIR {

    // --------------------------
    // Generic LS Function Marker
    // --------------------------


    // Constructors

    /**
     * Constructs An Empty {@link Packet_181}
     *
     * @author Christopher Bernjus
     */
    public Packet_181() { super(181); }

    /**
     * Constructs A {@link Packet_181}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     *
     * @author Christopher Bernjus
     */
    public Packet_181(int Q_DIR) {
        super(180, Q_DIR);
    }
}
