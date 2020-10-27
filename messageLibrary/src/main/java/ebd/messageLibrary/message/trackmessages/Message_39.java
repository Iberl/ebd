package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.util.ETCSVariables;

import static ebd.messageLibrary.util.ETCSVariables.M_ACK_NOT_REQUIRED;

/**
 * ID: 39 <br>
 * Type: Track To Train <br>
 * Description: Acknowledgement Of Termination Of A Communication Session
 *
 * @author Christopher Bernjus
 */
public class Message_39 extends TrackMessage {

	// ---------------------------------------------------------
	// Acknowledgement Of Termination Of A Communication Session
	// ---------------------------------------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_39}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_39() { super(39); }

	/**
	 * Constructs A {@link Message_39}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_39(long T_TRAIN, int NID_LRBG) { super(39, T_TRAIN, M_ACK_NOT_REQUIRED , NID_LRBG); }


	// Other Functions

	@Override
	public String toString() {
		return "Message_39{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + '}';
	}

}
