package ebd.messageLibrary.packet;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.*;

/**
 * Superclass For All Track To Train Packets
 *
 * @author Christopher Bernjus
 */
public abstract class TrackPacket extends Packet {

	// --------------------------------
	// Superclass For All Track Packets
	// --------------------------------

	/** {@link ETCSVariables#L_PACKET} */
	@BitLength(13)
	@OrderIndex(2)
	public int L_PACKET = ETCSVariables.L_PACKET;


	// Constructors

	/**
	 * Constructs A {@link TrackPacket}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	protected TrackPacket(int NID_PACKET) {
		super(NID_PACKET);
	}

}
