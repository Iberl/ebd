package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 16 <br>
 * Type: Track To Train <br>
 * Description: Unconditional Emergency Stop
 *
 * @author Christopher Bernjus
 */
public class Message_16 extends TrackMessage {

	// ----------------------------
	// Unconditional Emergency Stop
	// ----------------------------

	/** {@link ETCSVariables#NID_EM} */
	@BitLength(4)
	@OrderIndex(5)
	public int NID_EM = ETCSVariables.NID_EM;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_16}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_16() { super(16); }

	/**
	 * Constructs A {@link Message_16}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param NID_EM
	 *            {@link ETCSVariables#NID_EM}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_16(long T_TRAIN, boolean M_ACK, int NID_LRBG, int NID_EM) {
		super(16, T_TRAIN, M_ACK, NID_LRBG);
		this.NID_EM = NID_EM;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_16 that = (Message_16) object;
		return NID_EM == that.NID_EM;
	}

	@Override
	public String toString() {
		return "Message_16{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", NID_EM=" + NID_EM
			   + '}';
	}

}
