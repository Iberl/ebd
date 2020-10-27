package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.NumberOfDigits;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 143 <br>
 * Type: Track To Train <br>
 * Description: Session Management With Neighbouring Radio Infill Unit <br>
 * Transmitted By: RIU
 *
 * @author Christopher Bernjus
 */
public class Packet_143 extends TrackPacketDIR {

	// ------------------------------------------------------
	// Session Management With Neighbouring Radio Infill Unit
	// ------------------------------------------------------

	/** {@link ETCSVariables#Q_RIU} */
	@BitLength(1)
	@OrderIndex(3)
	public boolean Q_RIU = ETCSVariables.Q_RIU;

	/** {@link ETCSVariables#NID_C} */
	@BitLength(10)
	@OrderIndex(4)
	public int NID_C = ETCSVariables.NID_C;

	/** {@link ETCSVariables#NID_RIU} */
	@BitLength(14)
	@OrderIndex(5)
	public int NID_RIU = ETCSVariables.NID_RIU;

	/** {@link ETCSVariables#NID_RADIO} */
	@NumberOfDigits(16)
	@OrderIndex(6)
	public BinaryCodedDecimal NID_RADIO = ETCSVariables.NID_RADIO;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_143}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_143() {
		super(143);
	}

	/**
	 * Constructs A {@link Packet_143}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_RIU
	 *            {@link ETCSVariables#Q_RIU}
	 * @param NID_C
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_RIU
	 *            {@link ETCSVariables#NID_RIU}
	 * @param NID_RADIO
	 *            {@link ETCSVariables#NID_RADIO}
	 */
	public Packet_143(int Q_DIR, boolean Q_RIU, int NID_C, int NID_RIU, BinaryCodedDecimal NID_RADIO) {
		super(143, Q_DIR);
		this.Q_RIU = Q_RIU;
		this.NID_C = NID_C;
		this.NID_RIU = NID_RIU;
		this.NID_RADIO = NID_RADIO;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_143 that = (Packet_143) object;
		return Q_RIU == that.Q_RIU && NID_C == that.NID_C && NID_RIU == that.NID_RIU && Objects.equals(NID_RADIO, that.NID_RADIO);
	}

	@Override
	public String toString() {
		return "Packet_143{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_RIU=" + Q_RIU + ", NID_C=" + NID_C + ", NID_RIU=" + NID_RIU
			   + ", NID_RADIO=" + NID_RADIO.toString()
			   + '}';
	}

}
