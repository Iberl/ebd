package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 2 <br>
 * Type: Track To Train <br>
 * Description: System Version Order <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
public class Packet_2 extends TrackPacketDIR {

	// --------------------
	// System Version Order
	// --------------------

	/** {@link ETCSVariables#M_VERSION} */
	@BitLength(7)
	@OrderIndex(3)
	public int M_VERSION = ETCSVariables.M_VERSION;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_2}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_2() {
		super(2);
	}

	/**
	 * Constructs A {@link Packet_2}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param M_VERSION
	 *            {@link ETCSVariables#M_VERSION}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_2(int Q_DIR, int M_VERSION) {
		super(2, Q_DIR);
		this.M_VERSION = M_VERSION;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_2 packet_2 = (Packet_2) object;
		return M_VERSION == packet_2.M_VERSION;
	}

	@Override
	public String toString() {
		return "Packet_2{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", M_VERSION=" + M_VERSION
			   + "}";
	}

}
