package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 135 <br>
 * Type: Track To Train <br>
 * Description: Stop Shunting On Desk Opening <br>
 * Transmitted By: Balise, Loop, RIU
 *
 * @author Christopher Bernjus
 */
public class Packet_135 extends TrackPacketDIR {

	// -----------------------------
	// Stop Shunting On Desk Opening
	// -----------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_135}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_135() {
		super(135);
	}

	/**
	 * Constructs A {@link Packet_135}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 */
	public Packet_135(int Q_DIR) {
		super(135, Q_DIR);
	}


	// Other Functions

	@Override
	public String toString() {
		return "Packet_135{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + '}';
	}

}
