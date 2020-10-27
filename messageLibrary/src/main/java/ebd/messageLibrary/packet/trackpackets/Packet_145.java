package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 145 <br>
 * Type: Track To Train <br>
 * Description: Inhibition Of Balise Group Message Consistency Reaction <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
public class Packet_145 extends TrackPacketDIR {

    // -------------------------------------------------------
    // Inhibition Of Balise Group Message Consistency Reaction
    // -------------------------------------------------------


    // Constructors

    /**
     * Constructs An Empty {@link Packet_145}
     *
     * @author Christopher Bernjus
     */
    public Packet_145() { super(145); }

    /**
     * Constructs A {@link Packet_145}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     */
    public Packet_145(int Q_DIR) {
        super(145, Q_DIR);
    }


    // Other Functions

    @Override
    public String toString() {
        return "Packet_145{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + '}';
    }

}
