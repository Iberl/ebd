package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 65 <br>
 * Type: Track To Train <br>
 * Description: Tempory Speed Restriction <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
@OrderLength(9)
public class Packet_65 extends TrackPacketSCALE {

    // -------------------------
    // Tempory Speed Restriction
    // -------------------------

	/** {@link ETCSVariables#NID_TSR} */
	@BitLength(8)
	@OrderIndex(4)
	public int NID_TSR     = ETCSVariables.NID_TSR;

	/** {@link ETCSVariables#D_TSR} */
	@BitLength(15)
	@OrderIndex(5)
	public int D_TSR       = ETCSVariables.D_TSR;

	/** {@link ETCSVariables#L_TSR} */
	@BitLength(15)
	@OrderIndex(6)
	public int L_TSR       = ETCSVariables.L_TSR;

	/** {@link ETCSVariables#Q_FRONT} */
	@BitLength(1)
	@OrderIndex(7)
	public boolean Q_FRONT = ETCSVariables.Q_FRONT;

	/** {@link ETCSVariables#V_TSR} */
	@BitLength(7)
	@OrderIndex(8)
	public int V_TSR       = ETCSVariables.V_TSR;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_65}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_65() {
        super(65);
    }

	/**
	 * Constructs A {@link Packet_65}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param NID_TSR
	 *            {@link ETCSVariables#NID_TSR}
	 * @param D_TSR
	 *            {@link ETCSVariables#D_TSR}
	 * @param L_TSR
	 *            {@link ETCSVariables#L_TSR}
	 * @param Q_FRONT
	 *            {@link ETCSVariables#Q_FRONT}
	 * @param V_TSR
	 *            {@link ETCSVariables#V_TSR}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_65(int Q_DIR, int Q_SCALE,
              int NID_TSR, int D_TSR, int L_TSR, boolean Q_FRONT, int V_TSR) {
        super(65, Q_DIR, Q_SCALE);
        this.NID_TSR = NID_TSR;
        this.D_TSR   = D_TSR;
        this.L_TSR   = L_TSR;
        this.Q_FRONT = Q_FRONT;
        this.V_TSR   = V_TSR;
    }

}
