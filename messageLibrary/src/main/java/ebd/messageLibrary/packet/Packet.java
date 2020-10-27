package ebd.messageLibrary.packet;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.NotToBeDeserialized;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

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


	// Other Functions

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Packet packet = (Packet) o;
		return NID_PACKET == packet.NID_PACKET;
	}

	@Override
	public int hashCode() {
		return Objects.hash(NID_PACKET);
	}
}