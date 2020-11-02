package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.NumberOfDigits;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 5 <br>
 * Type: Train To Track <br>
 * Description: Train Running Number <br>
 * Transmitted To: RBC
 * @author Christopher Bernjus
 */
public class Packet_5 extends TrainPacket {

	// --------------------
	// Train Running Number
	// --------------------

	/** {@link ebd.messageLibrary.util.ETCSVariables#NID_OPERATIONAL}*/
	@NumberOfDigits(8)
	@OrderIndex(2)
	public BinaryCodedDecimal NID_OPERATIONAL = ETCSVariables.NID_OPERATIONAL;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_5}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_5() {
		super(5);
	}

	/**
	 * Constructs A {@link Packet_5}
	 *
	 * @param NID_OPERATIONAL
	 *            {@link ETCSVariables#NID_OPERATIONAL}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_5(BinaryCodedDecimal NID_OPERATIONAL) {
		super(5);
		this.NID_OPERATIONAL = NID_OPERATIONAL;
	}


	// Other Functions

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;
		Packet_5 packet_5 = (Packet_5) o;
		return Objects.equals(NID_OPERATIONAL, packet_5.NID_OPERATIONAL);
	}

	@Override
	public String toString() {
		return "Packet_5{"
				+ "NID_PACKET=" + NID_PACKET
				+ ", L_PACKET=" + L_PACKET
				+ ", NID_OPERATIONAL=" + NID_OPERATIONAL.toString()
				+ '}';
	}

}
