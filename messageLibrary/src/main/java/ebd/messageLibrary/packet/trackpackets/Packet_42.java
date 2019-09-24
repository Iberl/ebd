package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 42 <br>
 * Type: Track To Train <br>
 * Description: Session Management <br>
 * Transmitted By: Balise, RBC
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Packet_42 extends TrackPacketDIR {

    // ------------------
    // Session Management
    // ------------------

    /** {@link ETCSVariables#Q_RBC} */
    @BitLength(1)
    @OrderIndex(3)
    public boolean Q_RBC = ETCSVariables.Q_RBC;

    /**
     * {@link ETCSVariables#NID_C}
     * Not Relevant If NID_RBC Has Value NID_RBC_LAST_KNOWN
     */
    @BitLength(10)
    @OrderIndex(4)
    public int NID_C = ETCSVariables.NID_C;

    /** {@link ETCSVariables#NID_RBC} */
    @BitLength(14)
    @OrderIndex(5)
    public int NID_RBC = ETCSVariables.NID_RBC;

    /**
     * {@link ETCSVariables#NID_RADIO}
     * Not Relevant If NID_RBC Has Value NID_RBC_LAST_KNOWN
     */
    @BitLength(64)
    @OrderIndex(6)
    public long NID_RADIO = ETCSVariables.NID_RADIO;

    /** {@link ETCSVariables#Q_SLEEPSESSION} */
    @BitLength(1)
    @OrderIndex(7)
    public boolean Q_SLEEPSESSION = ETCSVariables.Q_SLEEPSESSION;


    // Constructors

    /**
     * Constructs An Empty {@link Packet_42}
     */
    public Packet_42() { super(42); }

    /**
     * Constructs A {@link Packet_42}
     *
     * @param Q_DIR
     *            {@link ETCSVariables#Q_DIR}
     * @param Q_RBC
     *            {@link ETCSVariables#Q_RBC}
     * @param NID_C
     *            {@link ETCSVariables#NID_C}
     * @param NID_RBC
     *            {@link ETCSVariables#NID_RBC}
     * @param NID_RADIO
     *            {@link ETCSVariables#NID_RADIO}
     * @param Q_SLEEPSESSION
     *            {@link ETCSVariables#Q_SLEEPSESSION}
     */
    public Packet_42(int Q_DIR, boolean Q_RBC, int NID_C, int NID_RBC, long NID_RADIO, boolean Q_SLEEPSESSION) {
        super(42, Q_DIR);
        this.Q_RBC = Q_RBC;
        this.NID_C = NID_C;
        this.NID_RBC = NID_RBC;
        this.NID_RADIO = NID_RADIO;
        this.Q_SLEEPSESSION = Q_SLEEPSESSION;
    }
}
