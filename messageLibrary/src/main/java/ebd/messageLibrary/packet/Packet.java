package ebd.messageLibrary.packet;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.NotToBeDeserialized;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * Superclass For All Packets
 *
 * @author Christopher Bernjus
 */
public abstract class Packet {

	// -------------------------
	// Superclass Of All Packets
	// -------------------------

	/** {@link ETCSVariables#NID_PACKET} */
	@BitLength(8)
	@OrderIndex(0)
	@NotToBeDeserialized
	public int NID_PACKET;


	// Constructor

	/**
	 * Constructs A {@link Packet}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	protected Packet(int NID_PACKET) {
		this.NID_PACKET = NID_PACKET;
	}

}