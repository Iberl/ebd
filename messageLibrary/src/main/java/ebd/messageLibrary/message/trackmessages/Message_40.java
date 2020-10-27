package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 40 <br>
 * Type: Track To Train <br>
 * Description: Train Rejected
 *
 * @author Christopher Bernjus
 */
public class Message_40 extends TrackMessage {

	// --------------
	// Train Rejected
	// --------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_40}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_40() { super(40); }

	/**
	 * Constructs A {@link Message_40}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_40(long T_TRAIN, boolean M_ACK, int NID_LRBG) { super(40, T_TRAIN, M_ACK, NID_LRBG); }


	// Other Functions


	@Override
	public String toString() {
		return "Message_40{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + '}';
	}

}
