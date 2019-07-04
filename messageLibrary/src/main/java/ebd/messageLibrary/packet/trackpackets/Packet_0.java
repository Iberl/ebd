package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.packet.Packet;

/**
 * ID: 0 <br>
 * Type: Track To Train <br>
 * Description: Virtual Balise Cover Marker <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
@OrderLength(2)
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

}