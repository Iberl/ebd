package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 64 <br>
 * Type: Track To Train <br>
 * Description: Inhibition Of Revocable TSRs From Balise in L2/3 <br>
 * Transmitted By: RBC
 *
 * @author Christopher Bernjus
 */
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


    // Other Functions

    @Override
    public String toString() {
        return "Packet_64{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + '}';
    }

}
