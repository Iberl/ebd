package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 181 <br>
 * Type: Track To Train <br>
 * Description: Generic LS Function Marker <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
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
        super(181, Q_DIR);
    }


    // Other Functions


    @Override
    public String toString() {
        return "Packet_181{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + '}';
    }

}
