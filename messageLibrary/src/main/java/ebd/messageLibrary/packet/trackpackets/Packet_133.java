package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.NumberOfDigits;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.BinaryCodedDecimal;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 133 <br>
 * Type: Track To Train <br>
 * Description: Radio Infill Area Information <br>
 * Transmitted By: Balise
 *
 * @author Christopher Bernjus
 */
public class Packet_133 extends TrackPacketSCALE {

	// -----------------------------
	// Radio Infill Area Information
	// -----------------------------

	/** {@link ETCSVariables#Q_RIU} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_RIU = ETCSVariables.Q_RIU;

	/** {@link ETCSVariables#NID_C} */
	@BitLength(10)
	@OrderIndex(5)
	public int NID_C_RIU = ETCSVariables.NID_C;

	/** {@link ETCSVariables#NID_RIU} */
	@BitLength(14)
	@OrderIndex(6)
	public int NID_RIU = ETCSVariables.NID_RIU;

	/** {@link ETCSVariables#NID_RADIO} */
	@NumberOfDigits(16)
	@OrderIndex(7)
	public BinaryCodedDecimal NID_RADIO = ETCSVariables.NID_RADIO;

	/** {@link ETCSVariables#D_INFILL} */
	@BitLength(15)
	@OrderIndex(8)
	public int D_INFILL = ETCSVariables.D_INFILL;

	/** {@link ETCSVariables#NID_C} */
	@BitLength(10)
	@OrderIndex(9)
	public int NID_C_BG = ETCSVariables.NID_C;

	/** {@link ETCSVariables#NID_BG} */
	@BitLength(14)
	@OrderIndex(10)
	public int NID_BG = ETCSVariables.NID_BG;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_133}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_133() {
		super(133);
	}

	/**
	 * Constructs A {@link Packet_133}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param Q_RIU
	 *            {@link ETCSVariables#Q_RIU}
	 * @param NID_C_RIU
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_RIU
	 *            {@link ETCSVariables#NID_RIU}
	 * @param NID_RADIO
	 *            {@link ETCSVariables#NID_RADIO}
	 * @param D_INFILL
	 *            {@link ETCSVariables#D_INFILL}
	 * @param NID_C_BG
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_BG
	 *            {@link ETCSVariables#NID_BG}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_133(int Q_DIR, int Q_SCALE, boolean Q_RIU, int NID_C_RIU, int NID_RIU, BinaryCodedDecimal NID_RADIO, int D_INFILL, int NID_C_BG, int NID_BG) {
		super(133, Q_DIR, Q_SCALE);
		this.Q_RIU = Q_RIU;
		this.NID_C_RIU = NID_C_RIU;
		this.NID_RIU = NID_RIU;
		this.NID_RADIO = NID_RADIO;
		this.D_INFILL = D_INFILL;
		this.NID_C_BG = NID_C_BG;
		this.NID_BG = NID_BG;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_133 that = (Packet_133) object;
		return Q_RIU == that.Q_RIU && NID_C_RIU == that.NID_C_RIU && NID_RIU == that.NID_RIU && D_INFILL == that.D_INFILL &&
			   NID_C_BG == that.NID_C_BG && NID_BG == that.NID_BG && Objects.equals(NID_RADIO, that.NID_RADIO);
	}

	@Override
	public String toString() {
		return "Packet_133{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", Q_RIU=" + Q_RIU + ", NID_C_RIU=" + NID_C_RIU + ", NID_RIU=" + NID_RIU
			   + ", NID_RADIO=" + NID_RADIO.toString()
			   + ", D_INFILL=" + D_INFILL + ", NID_C_BG=" + NID_C_BG + ", NID_BG=" + NID_BG
			   + '}';
	}

}
