package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 138 <br>
 * Type: Track To Train <br>
 * Description: Reversing Area Information <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
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


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_138 that = (Packet_138) object;
		return D_STARTREVERSE == that.D_STARTREVERSE && L_REVERSEAREA == that.L_REVERSEAREA;
	}

	@Override
	public String toString() {
		return "Packet_138{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", D_STARTREVERSE=" + D_STARTREVERSE + ", L_REVERSEAREA=" + L_REVERSEAREA
			   + '}';
	}

}
