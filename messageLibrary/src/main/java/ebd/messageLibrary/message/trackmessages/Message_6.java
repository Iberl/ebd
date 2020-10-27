package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 6 <br>
 * Type: Track To Train <br>
 * Description: Recognition Of Exit From TRIP Mode
 *
 * @author Christopher Bernjus
 */
public class Message_6 extends TrackMessage {

	// ----------------------------------
	// Recognition Of Exit From TRIP Mode
	// ----------------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_6}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_6() {
		super(6);
	}

	/**
	 * Constructs A {@link Message_6}
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
	public Message_6(long T_TRAIN, boolean M_ACK, int NID_LRBG) {
		super(6, T_TRAIN, M_ACK, NID_LRBG);
	}


	// Other Functions

	@Override
	public String toString() {
		return "Message_6{"
			   + ", NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + "M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + '}';
	}

}
