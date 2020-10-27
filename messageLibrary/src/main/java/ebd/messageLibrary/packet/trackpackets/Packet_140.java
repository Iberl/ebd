package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.NumberOfDigits;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 140 <br>
 * Type: Track To Train <br>
 * Description: Train Running Number From RBC <br>
 * Transmitted By: RBC
 *
 * @author Christopher Bernjus
 */
public class Packet_140 extends TrackPacketDIR {

	// -----------------------------
	// Train Running Number From RBC
	// -----------------------------

	/** {@link ETCSVariables#NID_OPERATIONAL} */
	@NumberOfDigits(8)
	@OrderIndex(3)
	public BinaryCodedDecimal NID_OPERATIONAL = ETCSVariables.NID_OPERATIONAL;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_140}
	 *
	 * @author Christopher Bernjus#
	 */
	public Packet_140() {
		super(140);
	}

	/**
	 * Constructs A {@link Packet_140}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param NID_OPERATIONAL
	 *            {@link ETCSVariables#NID_OPERATIONAL}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_140(int Q_DIR, BinaryCodedDecimal NID_OPERATIONAL) {
		super(140, Q_DIR);
		this.NID_OPERATIONAL = NID_OPERATIONAL;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_140 that = (Packet_140) object;
		return Objects.equals(NID_OPERATIONAL, that.NID_OPERATIONAL);
	}

	@Override
	public String toString() {
		return "Packet_140{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", NID_OPERATIONAL=" + NID_OPERATIONAL.toString()
			   + '}';
	}

}
