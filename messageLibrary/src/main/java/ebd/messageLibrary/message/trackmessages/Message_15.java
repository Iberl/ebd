package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.Signed;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 15 <br>
 * Type: Track To Train <br>
 * Description: Conditional Emergency Stop
 *
 * @author Christopher Bernjus
 */
public class Message_15 extends TrackMessage {

	// --------------------------
	// Conditional Emergency Stop
	// --------------------------

	/** {@link ETCSVariables#NID_EM} */
	@BitLength(4)
	@OrderIndex(5)
	public int NID_EM = ETCSVariables.NID_EM;

	/** {@link ETCSVariables#Q_SCALE}] */
	@BitLength(2)
	@OrderIndex(6)
	public int Q_SCALE = ETCSVariables.Q_SCALE;

	/** {@link ETCSVariables#D_REF} */
	@BitLength(16)
	@OrderIndex(7)
	@Signed
	public int D_REF = ETCSVariables.D_REF;

	/** {@link ETCSVariables#Q_DIR} */
	@BitLength(2)
	@OrderIndex(8)
	public int Q_DIR = ETCSVariables.Q_DIR;

	/** {@link ETCSVariables#D_EMERGENCYSTOP} */
	@BitLength(15)
	@OrderIndex(9)
	public int D_EMERGENCYSTOP = ETCSVariables.D_EMERGENCYSTOP;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_15() {
		super(15);
	}

	/**
	 * Constructs A {@link Message_15}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param NID_EM
	 *            {@link ETCSVariables#NID_EM}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_REF
	 *            {@link ETCSVariables#D_REF}
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param D_EMERGENCYSTOP
	 *            {@link ETCSVariables#D_EMERGENCYSTOP}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_15(long T_TRAIN, boolean M_ACK, int NID_LRBG, int NID_EM, int Q_SCALE, int D_REF, int Q_DIR, int D_EMERGENCYSTOP) {
		super(15, T_TRAIN, M_ACK, NID_LRBG);
		this.NID_EM = NID_EM;
		this.Q_SCALE = Q_SCALE;
		this.D_REF = D_REF;
		this.Q_DIR = Q_DIR;
		this.D_EMERGENCYSTOP = D_EMERGENCYSTOP;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_15 that = (Message_15) object;
		return NID_EM == that.NID_EM && Q_SCALE == that.Q_SCALE && D_REF == that.D_REF && Q_DIR == that.Q_DIR &&
			   D_EMERGENCYSTOP == that.D_EMERGENCYSTOP;
	}

	@Override
	public String toString() {
		return "Message_15{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", NID_EM=" + NID_EM + ", Q_SCALE=" + Q_SCALE + ", D_REF=" + D_REF + ", Q_DIR=" + Q_DIR
			   + ", D_EMERGENCYSTOP=" + D_EMERGENCYSTOP
			   + '}';
	}

}
