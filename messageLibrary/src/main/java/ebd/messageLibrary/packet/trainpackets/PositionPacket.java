package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.*;

import static ebd.messageLibrary.util.ETCSVariables.M_LEVEL_NTC;
import static ebd.messageLibrary.util.ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER;
import static ebd.messageLibrary.util.ETCSVariables.Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE;

/**
 * Superclass For Packet_0 And Packet_1
 *
 * Type: Train To Track
 *
 * @author Christopher Bernjus
 */
//TODO REMOVE ORDER LENGTH
@OrderLength(16)
public abstract class PositionPacket extends TrainPacket {

	// ---------------------------------
	// Superclass For Position Reporting
	// ---------------------------------

	/** {@link ETCSVariables#Q_SCALE} */
	@BitLength(2)
	@OrderIndex(2)
	public int Q_SCALE      = ETCSVariables.Q_SCALE;

	/** {@link ETCSVariables#NID_LRBG} */
	@BitLength(24)
	@OrderIndex(3)
	public int NID_LRBG     = ETCSVariables.NID_LRBG;

	/** {@link ETCSVariables#D_LRBG} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_LRBG       = ETCSVariables.D_LRBG;

	/** {@link ETCSVariables#Q_DIRLRBG} */
	@BitLength(2)
	@OrderIndex(5)
	public int Q_DIRLRBG    = ETCSVariables.Q_DIRLRBG;

	/** {@link ETCSVariables#Q_DLRBG} */
	@BitLength(2)
	@OrderIndex(6)
	public int Q_DLRBG      = ETCSVariables.Q_DLRBG;

	/** {@link ETCSVariables#L_DOUBTOVER} */
	@BitLength(15)
	@OrderIndex(7)
	public int L_DOUBTOVER  = ETCSVariables.L_DOUBTOVER;

	/** {@link ETCSVariables#L_DOUBTUNDER} */
	@BitLength(15)
	@OrderIndex(8)
	public int L_DOUBTUNDER = ETCSVariables.L_DOUBTUNDER;

	/** {@link ETCSVariables#Q_LENGTH} */
	@BitLength(2)
	@OrderIndex(9)
	public int Q_LENGTH     = ETCSVariables.Q_LENGTH;

		/** {@link ETCSVariables#L_TRAININIT} */
		@BitLength(15)
		@OrderIndex(10)
		@IfOneOf(field = "Q_LENGTH", values = {Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE, Q_LENGTH_CONFIRMED_BY_DRIVER})
		public int L_TRAININIT  = ETCSVariables.L_TRAININIT;

	/** {@link ETCSVariables#V_TRAIN} */
	@BitLength(7)
	@OrderIndex(11)
	public int V_TRAIN      = ETCSVariables.V_TRAIN;

	/** {@link ETCSVariables#Q_DIRTRAIN} */
	@BitLength(2)
	@OrderIndex(12)
	public int Q_DIRTRAIN   = ETCSVariables.Q_DIRTRAIN;

	/** {@link ETCSVariables#M_MODE} */
	@BitLength(4)
	@OrderIndex(13)
	public int M_MODE       = ETCSVariables.M_MODE;

	/** {@link ETCSVariables#M_LEVEL} */
	@BitLength(3)
	@OrderIndex(14)
	public int M_LEVEL      = ETCSVariables.M_LEVEL;

		/** {@link ETCSVariables#NID_NTC} */
		@BitLength(8)
		@OrderIndex(15)
		@IfEqual(field = "M_LEVEL", value = M_LEVEL_NTC)
		public int NID_NTC      = ETCSVariables.NID_NTC;


	// Constructors

	/**
	 * Constructs An Empty {@link PositionPacket}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	protected PositionPacket(int NID_PACKET) {
		super(NID_PACKET);
	}

	/**
	 * Constructs A {@link PositionPacket}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
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
	 *            {@link ETCSVariables#L_TRAININIT}
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
	public PositionPacket(int NID_PACKET, int Q_SCALE, int NID_LRBG, int D_LRBG, int Q_DIRLRBG, int Q_DLRBG,
	                      int L_DOUBTOVER, int L_DOUBTUNDER, int Q_LENGTH, int L_TRAININIT,
	                      int V_TRAIN, int Q_DIRTRAIN, int M_MODE, int M_LEVEL, int NID_NTC) {
		super(NID_PACKET);
		this.Q_SCALE      = Q_SCALE;
		this.NID_LRBG     = NID_LRBG;
		this.D_LRBG       = D_LRBG;
		this.Q_DIRLRBG    = Q_DIRLRBG;
		this.Q_DLRBG      = Q_DLRBG;
		this.L_DOUBTOVER  = L_DOUBTOVER;
		this.L_DOUBTUNDER = L_DOUBTUNDER;
		this.Q_LENGTH     = Q_LENGTH;
		this.L_TRAININIT  = L_TRAININIT;
		this.V_TRAIN      = V_TRAIN;
		this.Q_DIRTRAIN   = Q_DIRTRAIN;
		this.M_MODE       = M_MODE;
		this.M_LEVEL      = M_LEVEL;
		this.NID_NTC      = NID_NTC;
	}

}
