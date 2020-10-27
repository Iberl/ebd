package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 16 <br>
 * Type: Track To Train <br>
 * Description: Repositioning Information <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
public class Packet_16 extends TrackPacketSCALE {

    // -------------------------
    // Repositioning Information
    // -------------------------

    /** {@link ETCSVariables#L_SECTION} */
    @BitLength(15)
    @OrderIndex(4)
    public int L_SECTION = ETCSVariables.L_SECTION;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_6}
     *
     * @author Christopher Bernjus#
     */
    public Packet_16() { super(16); }

    /**
     * Constructs A {@link Packet_6}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_SCALE
     *            {@link ETCSVariables#Q_SCALE}
     * @param L_SECTION
     *            {@link ETCSVariables#L_SECTION}
     *
     * @author Christopher Bernjus
     */
    public Packet_16(int Q_DIR, int Q_SCALE, int L_SECTION) {
        super(16, Q_DIR, Q_SCALE);
        this.L_SECTION = L_SECTION;
    }


    // Other Functions

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        Packet_16 packet_16 = (Packet_16) object;
        return L_SECTION == packet_16.L_SECTION;
    }

    @Override
    public String toString() {
        return "Packet_16{"
               + "NID_PACKET=" + NID_PACKET
               + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
               + ", Q_SCALE=" + Q_SCALE
               + ", L_SECTION=" + L_SECTION
               + '}';
    }

}
