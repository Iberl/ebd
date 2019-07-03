package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 141 <br>
 * Type: Track To Train <br>
 * Description: Default Gradient For Temporary Speed Restriction <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Packet_141 extends TrackPacketDIR {

	// ------------------------------------------------
	// Default Gradient For Temporary Speed Restriction
	// ------------------------------------------------

	/** {@link ETCSVariables#Q_GDIR} */
	@BitLength(1)
	@OrderIndex(3)
	public boolean Q_GDIR = ETCSVariables.Q_GDIR;

	/** {@link ETCSVariables#G_TSR} */
	@BitLength(8)
	@OrderIndex(4)
	public int G_TSR      = ETCSVariables.G_TSR;


	// Constructor

	/**
	 * Constructs An Empty {@link Packet_141}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_141() {
		super(141);
	}

	/**
	 * Constructs A {@link Packet_141}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_GDIR
	 *            {@link ETCSVariables#Q_GDIR}
	 * @param G_TSR
	 *            {@link ETCSVariables#G_TSR}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_141(int Q_DIR, boolean Q_GDIR, int G_TSR) {
		super(141, Q_DIR);
		this.Q_GDIR = Q_GDIR;
		this.G_TSR  = G_TSR;
	}

}
