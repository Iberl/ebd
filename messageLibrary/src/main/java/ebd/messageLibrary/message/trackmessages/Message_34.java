package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.Signed;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 34 <br>
 * Type: Track To Train <br>
 * Description: Track Ahead Free Request
 *
 * @author Christopher Bernjus
 */
public class Message_34 extends TrackMessage {

	// ------------------------
	// Track Ahead Free Request
	// ------------------------

	/** {@link ETCSVariables#Q_SCALE} */
	@BitLength(2)
	@OrderIndex(5)
	public int Q_SCALE = ETCSVariables.Q_SCALE;

	/** {@link ETCSVariables#D_REF} */
	@BitLength(16)
	@OrderIndex(6)
	@Signed
	public int D_REF = ETCSVariables.D_REF;

	/** {@link ETCSVariables#Q_DIR} */
	@BitLength(2)
	@OrderIndex(7)
	public int Q_DIR = ETCSVariables.Q_DIR;

	/** {@link ETCSVariables#D_TAFDISPLAY} */
	@BitLength(15)
	@OrderIndex(8)
	public int D_TAFDISPLAY = ETCSVariables.D_TAFDISPLAY;

	/** {@link ETCSVariables#L_TAFDISPLAY} */
	@BitLength(15)
	@OrderIndex(9)
	public int L_TAFDISPLAY = ETCSVariables.L_TAFDISPLAY;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_34}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_34() { super(34); }

	/**
	 * Constructs A {@link Message_34}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_REF
	 *            {@link ETCSVariables#D_REF}
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param D_TAFDISPLAY
	 *            {@link ETCSVariables#D_TAFDISPLAY}
	 * @param L_TAFDISPLAY
	 *            {@link ETCSVariables#L_TAFDISPLAY}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_34(long T_TRAIN, boolean M_ACK, int NID_LRBG, int Q_SCALE, int D_REF, int Q_DIR, int D_TAFDISPLAY, int L_TAFDISPLAY) {
		super(34, T_TRAIN, M_ACK, NID_LRBG);
		this.Q_SCALE = Q_SCALE;
		this.D_REF = D_REF;
		this.Q_DIR = Q_DIR;
		this.D_TAFDISPLAY = D_TAFDISPLAY;
		this.L_TAFDISPLAY = L_TAFDISPLAY;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_34 that = (Message_34) object;
		return Q_SCALE == that.Q_SCALE && D_REF == that.D_REF && Q_DIR == that.Q_DIR && D_TAFDISPLAY == that.D_TAFDISPLAY &&
			   L_TAFDISPLAY == that.L_TAFDISPLAY;
	}

	@Override
	public String toString() {
		return "Message_34{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", Q_SCALE=" + Q_SCALE + ", D_REF=" + D_REF + ", Q_DIR=" + Q_DIR
			   + ", D_TAFDISPLAY=" + D_TAFDISPLAY + ", L_TAFDISPLAY=" + L_TAFDISPLAY
			   + '}';
	}

}
