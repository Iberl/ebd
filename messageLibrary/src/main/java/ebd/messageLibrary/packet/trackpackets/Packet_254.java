package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 254 <br>
 * Type: Track To Train <br>
 * Description: Default Balise, Loop Or RIU Information <br>
 * Transmitted By: Balise, Loop, RIU
 *
 * @author Christopher Bernjus
 */
@OrderLength(3)
public class Packet_254 extends TrackPacketDIR {

    // ---------------------------------------
    // Default Balise, Loop Or RIU Information
    // ---------------------------------------


    // Constructors

    /**
     * Constructs An Empty {@link Packet_254}
     *
     * @author Christopher Bernjus
     */
    public Packet_254() { super(254); }

    /**
     * Constructs A {@link Packet_254}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     *
     * @author Christopher Bernjus
     */
    public Packet_254(int Q_DIR) {
        super(254, Q_DIR);
    }
}
