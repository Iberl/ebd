package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.*;

/**
 * Superclass For All Track To Train Packets
 *
 * @author Christopher Bernjus
 */
public abstract class TrackPacketDIR extends TrackPacket {

	// --------------------------------
	// Superclass For All Track Packets
	// --------------------------------

	/** {@link ETCSVariables#Q_DIR} */
	@BitLength(2)
	@OrderIndex(1)
	public int Q_DIR    = ETCSVariables.Q_DIR;


	// Constructors

	/**
	 * Constructs An Empty {@link TrackPacketDIR}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	public TrackPacketDIR(int NID_PACKET) {
		super(NID_PACKET);
	}

	/**
	 * Constructs A {@link TrackPacketDIR} with {code Q_DIR} information
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 *
	 * @author Christopher Bernjus
	 */
	protected TrackPacketDIR(int NID_PACKET, int Q_DIR) {
		super(NID_PACKET);
		this.Q_DIR = Q_DIR;
	}

}
