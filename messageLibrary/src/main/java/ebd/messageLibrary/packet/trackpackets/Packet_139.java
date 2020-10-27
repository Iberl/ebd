package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 139 <br>
 * Type: Track To Train <br>
 * Description: Reversing Supervision Information <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
public class Packet_139 extends TrackPacketDIR {

	// ---------------------------------
	// Reversing Supervision Information
	// ---------------------------------

	/** {@link ETCSVariables#D_REVERSE} */
	@BitLength(15)
	@OrderIndex(3)
	public int D_REVERSE = ETCSVariables.D_REVERSE;

	/** {@link ETCSVariables#V_REVERSE} */
	@BitLength(7)
	@OrderIndex(4)
	public int V_REVERSE = ETCSVariables.V_REVERSE;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_139}
	 *
	 * @author Christopher Bernjus#
	 */
	public Packet_139() {
		super(139);
	}

	/**
	 * Constructs A {@link Packet_139}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param D_REVERSE
	 *            {@link ETCSVariables#D_REVERSE}
	 * @param V_REVERSE
	 *            {@link ETCSVariables#V_REVERSE}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_139(int Q_DIR, int D_REVERSE, int V_REVERSE) {
		super(139, Q_DIR);
		this.D_REVERSE = D_REVERSE;
		this.V_REVERSE = V_REVERSE;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_139 that = (Packet_139) object;
		return D_REVERSE == that.D_REVERSE && V_REVERSE == that.V_REVERSE;
	}

	@Override
	public String toString() {
		return "Packet_139{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", D_REVERSE=" + D_REVERSE + ", V_REVERSE=" + V_REVERSE
			   + '}';
	}

}
