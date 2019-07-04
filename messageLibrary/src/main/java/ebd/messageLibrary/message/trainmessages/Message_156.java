package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 156 <br>
 * Type: Train To Track <br>
 * Description: Termination Of A Communication Session
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Message_156 extends TrainMessage {

	// --------------------------------------
	// Termination Of A Communication Session
	// --------------------------------------


	// Constructor

	/**
	 * Constructs An Empty {@link Message_156}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_156() { super(156); }

	/**
	 * Constructs A {@link Message_156}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_156(long T_TRAIN, int NID_ENGINE) { super(156, T_TRAIN, NID_ENGINE); }
}
