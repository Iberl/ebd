package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 137 <br>
 * Type: Track To Train <br>
 * Description: Stop If In Staff Responsible <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
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

}
