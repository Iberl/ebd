package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 41 <br>
 * Type: Track To Train <br>
 * Description: Train Accepted
 *
 * @author Christopher Bernjus
 */
public class Message_41 extends TrackMessage {

	// --------------
	// Train Accepted
	// --------------


	// Constructors

	/**
	 * Constructs A {@link Message_41}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_41() { super(41); }

	/**
	 * Constructs A {@link Message_41}
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
	public Message_41(long T_TRAIN, boolean M_ACK, int NID_LRBG) { super(41, T_TRAIN, M_ACK, NID_LRBG); }


	// Other Functions


	@Override
	public String toString() {
		return "Message_41{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + '}';
	}

}
