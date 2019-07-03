package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 138 <br>
 * Type: Track To Train <br>
 * Description: Reversing Area Information <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Packet_138 extends TrackPacketDIR {

	// --------------------------
	// Reversing Area Information
	// --------------------------

	/** {@link ETCSVariables#D_STARTREVERSE} */
	@BitLength(15)
	@OrderIndex(3)
	public int D_STARTREVERSE = ETCSVariables.D_STARTREVERSE;

	/** {@link ETCSVariables#L_REVERSEAREA} */
	@BitLength(15)
	@OrderIndex(4)
	public int L_REVERSEAREA  = ETCSVariables.L_REVERSEAREA;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_138}
	 *
	 * @author Christopher Bernjus#
	 */
	public Packet_138() {
		super(138);
	}

	/**
	 * Constructs A {@link Packet_138}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param D_STARTREVERSE
	 *            {@link ETCSVariables#D_STARTREVERSE}
	 * @param L_REVERSEAREA
	 *            {@link ETCSVariables#L_REVERSEAREA}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_138(int Q_DIR, int D_STARTREVERSE, int L_REVERSEAREA) {
		super(138, Q_DIR);
		this.D_STARTREVERSE = D_STARTREVERSE;
		this.L_REVERSEAREA  = L_REVERSEAREA;
	}

}
