package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfTrue;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 6 <br>
 * Type: Track To Train <br>
 * Description: Virtual Balise Cover Order <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Packet_6 extends TrackPacketDIR {

    // --------------------------
    // Virtual Balise Cover Order
    // --------------------------

    /** {@link ETCSVariables#Q_VBCO} */
    @BitLength(1)
    @OrderIndex(3)
    public boolean Q_VBCO = ETCSVariables.Q_VBCO;

    /** {@link ETCSVariables#NID_VBCMK} */
    @BitLength(6)
    @OrderIndex(4)
    public int NID_VBCMK = ETCSVariables.NID_VBCMK;

    /** {@link ETCSVariables#NID_C} */
    @BitLength(10)
    @OrderIndex(5)
    public int NID_C = ETCSVariables.NID_C;

    /** {@link ETCSVariables#T_VBC} */
    @BitLength(8)
    @OrderIndex(6)
    @IfTrue("Q_VBCO")
    public int T_VBC = ETCSVariables.T_VBC;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_6}
     *
     * @author Christopher Bernjus#
     */
    public Packet_6() { super(6); }

    /**
     * Constructs A {@link Packet_6}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_VBCO
     *            {@link ETCSVariables#Q_VBCO}
     * @param NID_VBCMK
     *            {@link ETCSVariables#NID_VBCMK}
     * @param NID_C
     *            {@link ETCSVariables#NID_C}
     * @param T_VBC
     *            {@link ETCSVariables#T_VBC}
     *
     * @author Christopher Bernjus#
     */
    public Packet_6(int Q_DIR, boolean Q_VBCO, int NID_VBCMK, int NID_C, int T_VBC) {
        super(6, Q_DIR);
        this.Q_VBCO    = Q_VBCO;
        this.NID_VBCMK = NID_VBCMK;
        this.NID_C     = NID_C;
        this.T_VBC     = T_VBC;
    }
}
