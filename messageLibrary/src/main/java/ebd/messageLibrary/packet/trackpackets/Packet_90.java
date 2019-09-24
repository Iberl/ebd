package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfTrue;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 66 <br>
 * Type: Track To Train <br>
 * Description: Track Ahead Free Up To L2/3 Transition Location <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Packet_90 extends TrackPacketDIR {

    // -----------------------------------------------
    // Track Ahead Free Up To L2/3 Transition Location
    // -----------------------------------------------

    /** {@link ETCSVariables#Q_NEWCOUNTRY} */
    @BitLength(1)
    @OrderIndex(3)
    public boolean Q_NEWCOUNTRY = ETCSVariables.Q_NEWCOUNTRY;

    /** {@link ETCSVariables#NID_C} */
    @BitLength(10)
    @OrderIndex(4)
    @IfTrue("Q_NEWCOUNTRY")
    public int NID_C = ETCSVariables.NID_C;

    /** {@link ETCSVariables#NID_BG} */
    @BitLength(14)
    @OrderIndex(5)
    public int NID_BG = ETCSVariables.NID_BG;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_90}
     *
     * @author Christopher Bernjus
     */
    public Packet_90() { super(90); }

    /**
     * Constructs A {@link Packet_90}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_NEWCOUNTRY
     *            {@link ETCSVariables#Q_NEWCOUNTRY}
     * @param NID_C
     *            {@link ETCSVariables#NID_C}
     * @param NID_BG
     *            {@link ETCSVariables#NID_BG}
     *
     * @author Christopher Bernjus
     */
    public Packet_90(int Q_DIR, boolean Q_NEWCOUNTRY, int NID_C, int NID_BG) {
        super(90, Q_DIR);
        this.Q_NEWCOUNTRY = Q_NEWCOUNTRY;
        this.NID_C = NID_C;
        this.NID_BG = NID_BG;
    }
}
