package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 155 <br>
 * Type: Train To Track <br>
 * Description: Initiation Of A Communication Session
 *
 * @author Christopher Bernjus
 */
public class Message_155 extends TrainMessage {

	// -------------------------------------
	// Initiation Of A Communication Session
	// -------------------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_155}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_155() { super(155); }

	/**
	 * Constructs A {@link Message_155}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_155(long T_TRAIN, int NID_ENGINE) { super(155, T_TRAIN, NID_ENGINE); }


	// Other Functions

	@Override
	public String toString() {
		return "Message_155{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + '}';
	}

}
