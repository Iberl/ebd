package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 134 <br>
 * Type: Track To Train <br>
 * Description: EOLM Packet <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(9)
public class Packet_134 extends TrackPacketSCALE {

    // -----------
    // EOLM Packet
    // -----------

    /** {@link ETCSVariables#NID_LOOP} */
    @BitLength(14)
    @OrderIndex(4)
    public int NID_LOOP = ETCSVariables.NID_LOOP;

    /** {@link ETCSVariables#D_LOOP} */
    @BitLength(14)
    @OrderIndex(5)
    public int D_LOOP = ETCSVariables.D_LOOP;

    /** {@link ETCSVariables#L_LOOP} */
    @BitLength(14)
    @OrderIndex(6)
    public int L_LOOP = ETCSVariables.L_LOOP;

    /** {@link ETCSVariables#Q_LOOPDIR} */
    @BitLength(1)
    @OrderIndex(7)
    public boolean Q_LOOPDIR = ETCSVariables.Q_LOOPDIR;

    /** {@link ETCSVariables#Q_SSCODE} */
    @BitLength(4)
    @OrderIndex(8)
    public int Q_SSCODE = ETCSVariables.Q_SSCODE;


    // Constructors

    // Constructors

    /**
     * Constructs An Empty {@link Packet_134}
     *
     * @author Christopher Bernjus
     */
    public Packet_134() { super(134); }

    /**
     * Construct A {@link Packet_134}
     *
     *  @param Q_DIR
     *             {@link ETCSVariables#Q_DIR}
     * 	@param Q_SCALE
     * 	           {@link ETCSVariables#Q_SCALE}
     * @param NID_LOOP
     * 	           {@link ETCSVariables#NID_LOOP}
     * @param D_LOOP
     * 	           {@link ETCSVariables#D_LOOP}
     * @param L_LOOP
     * 	           {@link ETCSVariables#L_LOOP}
     * @param Q_LOOPDIR
     * 	           {@link ETCSVariables#Q_LOOPDIR}
     * @param Q_SSCODE
     * 	           {@link ETCSVariables#Q_SSCODE}
     *
     * @author Christopher Bernjus
     */
    public Packet_134(int Q_DIR, int Q_SCALE, int NID_LOOP, int D_LOOP, int L_LOOP, boolean Q_LOOPDIR, int Q_SSCODE) {
        super(134, Q_DIR, Q_SCALE);
        this.NID_LOOP = NID_LOOP;
        this.D_LOOP = D_LOOP;
        this.L_LOOP = L_LOOP;
        this.Q_LOOPDIR = Q_LOOPDIR;
        this.Q_SSCODE = Q_SSCODE;
    }

}
