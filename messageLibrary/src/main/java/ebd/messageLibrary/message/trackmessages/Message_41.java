package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 41 <br>
 * Type: Track To Train <br>
 * Description: Train Accepted
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
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
}
