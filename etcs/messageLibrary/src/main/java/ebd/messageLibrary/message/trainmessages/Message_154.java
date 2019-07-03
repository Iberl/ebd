package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 154 <br>
 * Type: Train To Track <br>
 * Description: No Compatible Version Supported
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
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
}
