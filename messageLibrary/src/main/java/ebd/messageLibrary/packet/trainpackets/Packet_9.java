package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 9 <br>
 * Type: Train To Track <br>
 * Description: Level 2/3 Transition Information <br>
 * Transmitted To: RBC
 * @author Christopher Bernjus
 */
public class Packet_9 extends TrainPacket {

	// --------------------------------
	// Level 2/3 Transition Information
	// --------------------------------

	/** {@link ETCSVariables#NID_LTRBG}*/
	@BitLength(24)
	@OrderIndex(2)
	public int NID_LTRBG = ETCSVariables.NID_LTRBG;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_9}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_9() {
		super(9);
	}

	/**
	 * Constructs A {@link Packet_9}
	 *
	 * @param NID_LTRBG
	 *            {@link ETCSVariables#NID_LTRBG}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_9(int NID_LTRBG) {
		super(9);
		this.NID_LTRBG = NID_LTRBG;
	}


	// Other Functions

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;
		Packet_9 packet_9 = (Packet_9) o;
		return NID_LTRBG == packet_9.NID_LTRBG;
	}

	@Override
	public String toString() {
		return "Packet_9{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", L_PACKET=" + L_PACKET
			   + ", NID_LTRBG=" + NID_LTRBG
			   + '}';
	}

}
