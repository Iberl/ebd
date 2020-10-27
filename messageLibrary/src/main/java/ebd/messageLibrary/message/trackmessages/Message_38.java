package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.util.ETCSVariables;

import static ebd.messageLibrary.util.ETCSVariables.NID_LRBG_UNKNOWN;
import static ebd.messageLibrary.util.ETCSVariables.T_TRAIN_UNKNOWN;

/**
 * ID: 38 <br>
 * Type: Track To Train <br>
 * Description: Initiation Of A Communication Session
 *
 * @author Christopher Bernjus
 */
public class Message_38 extends TrackMessage {

	// -------------------------------------
	// Initiation Of A Communication Session
	// -------------------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_38}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_38() { super(38, T_TRAIN_UNKNOWN, false, NID_LRBG_UNKNOWN); }

	/**
	 * Constructs A {@link Message_38}
	 *
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_38(boolean M_ACK) { super(38, T_TRAIN_UNKNOWN, M_ACK, NID_LRBG_UNKNOWN); }


	// Other Functions

	@Override
	public String toString() {
		return "Message_38{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + '}';
	}

}
