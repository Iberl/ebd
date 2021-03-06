package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 43 <br>
 * Type: Track To Train <br>
 * Description: SoM Position Report Confirmed By RBC
 *
 * @author Christopher Bernjus
 */
public class Message_43 extends TrackMessage {

	// ------------------------------------
	// SoM Position Report Confirmed By RBC
	// ------------------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_43}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_43() { super(43); }

	/**
	 * Constructs A {@link Message_43}
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
	public Message_43(long T_TRAIN, boolean M_ACK, int NID_LRBG) { super(43, T_TRAIN, M_ACK, NID_LRBG); }


	// Other Functions


	@Override
	public String toString() {
		return "Message_43{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + '}';
	}

}
