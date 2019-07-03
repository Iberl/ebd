package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 132 <br>
 * Type: Track To Train <br>
 * Description: Danger for Shunting Information <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Packet_132 extends TrackPacketDIR {

	// -------------------------------
	// Danger for Shunting Information
	// -------------------------------

	/** {@link ETCSVariables#Q_ASPECT} */
	@BitLength(1)
	@OrderIndex(3)
	public boolean Q_ASPECT = ETCSVariables.Q_ASPECT;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_132}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_132() {
		super(132);
	}

	/**
	 * Constructs A {@link Packet_132}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_ASPECT
	 *            {@link ETCSVariables#Q_ASPECT}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_132(int Q_DIR, boolean Q_ASPECT) {
		super(132, Q_DIR);
		this.Q_ASPECT = Q_ASPECT;
	}

}
