package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 0 <br>
 * Type: Train To Track <br>
 * Description: Position Report <br>
 * Transmitted To: RBC, RIU
 * @author Christopher Bernjus
 */
public class Packet_0 extends PositionPacket {

	// ---------------
	// Position Report
	// ---------------


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
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
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
	public Packet_0(int Q_SCALE, int NID_LRBG, int D_LRBG, int Q_DIRLRBG, int Q_DLRBG,
	                int L_DOUBTOVER, int L_DOUBTUNDER, int Q_LENGTH, int L_TRAININIT,
	                int V_TRAIN, int Q_DIRTRAIN, int M_MODE, int M_LEVEL, int NID_NTC) {
		super(0, Q_SCALE, NID_LRBG, D_LRBG, Q_DIRLRBG, Q_DLRBG,
		L_DOUBTOVER, L_DOUBTUNDER, Q_LENGTH, L_TRAININIT,
		V_TRAIN, Q_DIRTRAIN, M_MODE, M_LEVEL, NID_NTC);
	}


	// Other Functions

	@Override
	public String toString() {
		return "Packet_0{"
               + "NID_PACKET=" + NID_PACKET
               + ", L_PACKET=" + L_PACKET
               + ", Q_SCALE=" + Q_SCALE + ", NID_LRBG=" + NID_LRBG + ", D_LRBG=" + D_LRBG
               + ", Q_DIRLRBG=" + Q_DIRLRBG + ", Q_DLRBG=" + Q_DLRBG + ", L_DOUBTOVER=" + L_DOUBTOVER
               + ", L_DOUBTUNDER=" + L_DOUBTUNDER + ", Q_LENGTH=" + Q_LENGTH
               + ", L_TRAININIT=" + L_TRAININT + ", V_TRAIN=" + V_TRAIN + ", Q_DIRTRAIN=" + Q_DIRTRAIN
               + ", M_MODE=" + M_MODE + ", M_LEVEL=" + M_LEVEL + ", NID_NTC=" + NID_NTC
               + '}';
	}

}
