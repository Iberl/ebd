package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 140 <br>
 * Type: Track To Train <br>
 * Description: Train Running Number From RBC <br>
 * Transmitted By: RBC
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Packet_140 extends TrackPacketDIR {

	// -----------------------------
	// Train Running Number From RBC
	// -----------------------------

	/** {@link ETCSVariables#NID_OPERATIONAL} */
	@BitLength(32)
	@OrderIndex(3)
	public int NID_OPERATIONAL = ETCSVariables.NID_OPERATIONAL;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_140}
	 *
	 * @author Christopher Bernjus#
	 */
	public Packet_140() {
		super(140);
	}

	/**
	 * Constructs A {@link Packet_140}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param NID_OPERATIONAL
	 *            {@link ETCSVariables#NID_OPERATIONAL}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_140(int Q_DIR, int NID_OPERATIONAL) {
		super(140, Q_DIR);
		this.NID_OPERATIONAL = NID_OPERATIONAL;
	}

}
