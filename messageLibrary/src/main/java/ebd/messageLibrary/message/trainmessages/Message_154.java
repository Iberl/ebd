package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 154 <br>
 * Type: Train To Track <br>
 * Description: No Compatible Version Supported
 *
 * @author Christopher Bernjus
 */
public class Message_154 extends TrainMessage {

	// -------------------------------
	// No Compatible Version Supported
	// -------------------------------


	// Constructors

	/**
	 * Constructs An Empty {@link Message_154}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_154() { super(154); }

	/**
	 * Constructs A {@link Message_154}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_154(long T_TRAIN, int NID_ENGINE) { super(154, T_TRAIN, NID_ENGINE); }


	// Other Functions

	@Override
	public String toString() {
		return "Message_154{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + '}';
	}

}
