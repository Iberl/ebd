package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfTrue;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 180 <br>
 * Type: Track To Train <br>
 * Description: LSSMA Display Toggle Order <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Packet_180 extends TrackPacketDIR {

    // --------------------------
    // LSSMA Display Toggle Order
    // --------------------------

    /** {@link ETCSVariables#Q_LSSMA} */
    @BitLength(1)
    @OrderIndex(3)
    public boolean Q_LSSMA = ETCSVariables.Q_LSSMA;

    /** {@link ETCSVariables#T_LSSMA} */
    @BitLength(8)
    @OrderIndex(4)
    @IfTrue("Q_LSSMA")
    public int T_LSSMA = ETCSVariables.T_LSSMA;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_180}
     *
     * @author Christopher Bernjus
     */
    public Packet_180() { super(180); }

    /**
     * Constructs A {@link Packet_180}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_LSSMA
     *            {@link ETCSVariables#Q_LSSMA}
     * @param T_LSSMA
     *            {@link ETCSVariables#T_LSSMA}
     *
     * @author Christopher Bernjus
     */
    public Packet_180(int Q_DIR, boolean Q_LSSMA, int T_LSSMA) {
        super(180, Q_DIR);
        this.Q_LSSMA = Q_LSSMA;
        this.T_LSSMA = T_LSSMA;
    }
}
