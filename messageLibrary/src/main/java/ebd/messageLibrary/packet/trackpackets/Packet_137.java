package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 137 <br>
 * Type: Track To Train <br>
 * Description: Stop If In Staff Responsible <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
public class Packet_137 extends TrackPacketDIR {

	// ----------------------------
	// Stop If In Staff Responsible
	// ----------------------------

	/** {@link ETCSVariables#Q_SRSTOP} */
	@BitLength(1)
	@OrderIndex(3)
	public boolean Q_SRSTOP = ETCSVariables.Q_SRSTOP;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_137}
	 *
	 * @author Christopher Bernjus#
	 */
	public Packet_137() {
		super(137);
	}

	/**
	 * Constructs A {@link Packet_137}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SRSTOP
	 *            {@link ETCSVariables#Q_SRSTOP}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_137(int Q_DIR, boolean Q_SRSTOP) {
		super(137, Q_DIR);
		this.Q_SRSTOP = Q_SRSTOP;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_137 that = (Packet_137) object;
		return Q_SRSTOP == that.Q_SRSTOP;
	}

	@Override
	public String toString() {
		return "Packet_137{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SRSTOP=" + Q_SRSTOP
			   + '}';
	}

}
