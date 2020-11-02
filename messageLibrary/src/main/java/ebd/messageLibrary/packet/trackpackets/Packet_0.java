package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 0 <br>
 * Type: Track To Train <br>
 * Description: Virtual Balise Cover Marker <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
public class Packet_0 extends Packet {

	// ---------------------------
	// Virtual Balise Cover Marker
	// ---------------------------

	/** {@link ETCSVariables#NID_VBCMK} */
	@BitLength(6)
	@OrderIndex(1)
	public int NID_VBCMK = ETCSVariables.NID_VBCMK;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_0}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_0() {
		super(0);
	}

	/**
	 * Constructs A {@link Packet_0}
	 *
	 * @param NID_VBCMK
	 *            {@link ETCSVariables#NID_VBCMK}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_0(int NID_VBCMK) {
		super(0);
		this.NID_VBCMK = NID_VBCMK;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_0 packet_0 = (Packet_0) object;
		return NID_VBCMK == packet_0.NID_VBCMK;
	}

	@Override
	public String toString() {
		return "Packet_0{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", NID_VBCMK=" + NID_VBCMK
			   + '}';
	}

}