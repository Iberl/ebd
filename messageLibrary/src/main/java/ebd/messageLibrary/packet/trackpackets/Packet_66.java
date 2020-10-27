package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 66 <br>
 * Type: Track To Train <br>
 * Description: Temporary Speed Restriction Revocation <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
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


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        Packet_66 packet_66 = (Packet_66) object;
        return NID_TSR == packet_66.NID_TSR;
    }

    @Override
    public String toString() {
        return "Packet_66{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + ", NID_TSR=" + NID_TSR
               + '}';
    }

}
