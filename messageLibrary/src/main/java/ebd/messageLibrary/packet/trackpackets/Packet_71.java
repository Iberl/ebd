package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 71 <br>
 * Type: Track To Train <br>
 * Description: Adhesion Factor <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Packet_71 extends TrackPacketSCALE {

	// ---------------
    // Adhesion Factor
	// ---------------

	/** {@link ETCSVariables#D_ADHESION} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_ADHESION     = ETCSVariables.D_ADHESION;

	/** {@link ETCSVariables#L_ADHESION} */
	@BitLength(15)
	@OrderIndex(5)
	public int L_ADHESION     = ETCSVariables.L_ADHESION;

	/** {@link ETCSVariables#M_ADHESION} */
	@BitLength(1)
	@OrderIndex(6)
	public boolean M_ADHESION = ETCSVariables.M_ADHESION;


    // Constructors

	/**
	 * Constructs An Empty {@link Packet_71}
	 *
	 * @author Christopher Bernjus
	 */
    Packet_71() {
        super(71);
    }

	/**
	 * Constructs A {@link Packet_71}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_ADHESION
	 *            {@link ETCSVariables#D_ADHESION}
	 * @param L_ADHESION
	 *            {@link ETCSVariables#L_ADHESION}
	 * @param M_ADHESION
	 *            {@link ETCSVariables#M_ADHESION}
	 *
	 * @author Christopher Bernjus
	 */
    Packet_71(int Q_DIR, int Q_SCALE, int D_ADHESION, int L_ADHESION, boolean M_ADHESION) {
        super(71, Q_DIR, Q_SCALE);
        this.D_ADHESION = D_ADHESION;
        this.L_ADHESION = L_ADHESION;
        this.M_ADHESION = M_ADHESION;
    }

}
