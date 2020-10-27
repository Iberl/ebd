package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 1 <br>
 * Type: Train To Track <br>
 * Description: Position Report Based On Two Balise Groups <br>
 * Transmitted To: RBC, RIU
 *
 * @author Christopher Bernjus
 */
public class Packet_1 extends PositionPacket {

	// ------------------------------------------
	// Position Report Based On Two Balise Groups
	// ------------------------------------------

	/** {@link ETCSVariables#NID_PRVLRBG} */
	@BitLength(24)
	@OrderIndex(4)
	public int NID_PRVLRBG = ETCSVariables.NID_PRVLRBG;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_1}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_1() {
		super(1);
	}

	/**
	 * Constructs A {@link Packet_1}
	 *
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param NID_PRVLRBG
	 *            {@link ETCSVariables#NID_PRVLRBG}
	 * @param D_LRBG
	 *            {@link ETCSVariables#D_LRBG}
	 * @param Q_DIRLRBG
	 *            {@link ETCSVariables#Q_DIRLRBG}
	 * @param Q_DLRBG
	 *            {@link ETCSVariables#Q_DLRBG}
	 * @param L_DOUBTOVER
	 *            {@link ETCSVariables#L_DOUBTOVER}
	 * @param L_DOUBTUNDER
	 *            {@link ETCSVariables#L_DOUBTUNDER}
	 * @param Q_LENGTH
	 *            {@link ETCSVariables#Q_LENGTH}
	 * @param L_TRAININIT
	 *            {@link ETCSVariables#L_TRAININT}
	 * @param V_TRAIN
	 *            {@link ETCSVariables#V_TRAIN}
	 * @param Q_DIRTRAIN
	 *            {@link ETCSVariables#Q_DIRTRAIN}
	 * @param M_MODE
	 *            {@link ETCSVariables#M_MODE}
	 * @param M_LEVEL
	 *            {@link ETCSVariables#M_LEVEL}
	 * @param NID_NTC
	 *            {@link ETCSVariables#NID_NTC}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_1(int Q_SCALE, int NID_LRBG, int NID_PRVLRBG, int D_LRBG, int Q_DIRLRBG, int Q_DLRBG,
	                int L_DOUBTOVER, int L_DOUBTUNDER, int Q_LENGTH, int L_TRAININIT,
	                int V_TRAIN, int Q_DIRTRAIN, int M_MODE, int M_LEVEL, int NID_NTC) {
		super(1, Q_SCALE, NID_LRBG, D_LRBG, Q_DIRLRBG, Q_DLRBG,
				L_DOUBTOVER, L_DOUBTUNDER, Q_LENGTH, L_TRAININIT,
				V_TRAIN, Q_DIRTRAIN, M_MODE, M_LEVEL, NID_NTC);
		this.NID_PRVLRBG = NID_PRVLRBG;
	}


	// Other Functions

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;
		Packet_1 packet_1 = (Packet_1) o;
		return NID_PRVLRBG == packet_1.NID_PRVLRBG;
	}

	@Override
	public String toString() {
		return "Packet_1{"
               + "NID_PACKET=" + NID_PACKET
               + ", L_PACKET=" + L_PACKET
               + ", NID_PRVLRBG=" + NID_PRVLRBG + ", Q_SCALE=" + Q_SCALE + ", NID_LRBG=" + NID_LRBG
               + ", D_LRBG=" + D_LRBG + ", Q_DIRLRBG=" + Q_DIRLRBG + ", Q_DLRBG=" + Q_DLRBG
               + ", L_DOUBTOVER=" + L_DOUBTOVER + ", L_DOUBTUNDER=" + L_DOUBTUNDER + ", Q_LENGTH=" + Q_LENGTH
               + ", L_TRAININIT=" + L_TRAININT + ", V_TRAIN=" + V_TRAIN + ", Q_DIRTRAIN=" + Q_DIRTRAIN
               + ", M_MODE=" + M_MODE + ", M_LEVEL=" + M_LEVEL + ", NID_NTC=" + NID_NTC
               + '}';
	}

}
