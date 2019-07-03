package ebd.messageLibrary.packet;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.*;

/**
 * Superclass For All Train To Track Packets
 *
 * @author Christopher Bernjus
 */
public abstract class TrainPacket extends Packet {

	// --------------------------------
	// Superclass For All Train Packets
	// --------------------------------

	/** {@link ETCSVariables#L_PACKET} */
	@BitLength(13)
	@OrderIndex(1)
	public int L_PACKET = ETCSVariables.L_PACKET;


	// Constructors

	/**
	 * Constructs A {@link TrainPacket}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	protected TrainPacket(int NID_PACKET) {
		super(NID_PACKET);
	}

}
