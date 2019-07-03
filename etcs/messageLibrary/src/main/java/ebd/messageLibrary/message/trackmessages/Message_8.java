package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 8 <br>
 * Type: Track To Train <br>
 * Description: Acknowledgement Of Train Data
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_8 extends TrackMessage {

	// -----------------------------
	// Acknowledgement Of Train Data
	// -----------------------------

	/** {@link ETCSVariables#T_TRAIN} */
	@BitLength(32)
	@OrderIndex(5)
	public long T_TRAIN_MSG = ETCSVariables.T_TRAIN;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_8}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_8() { super(8); }

	/**
	 * Constructs A {@link Message_8}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param T_TRAIN_MSG
	 *            {@link ETCSVariables#T_TRAIN}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_8(long T_TRAIN, boolean M_ACK, int NID_LRBG, long T_TRAIN_MSG) {
		super(8, T_TRAIN, M_ACK, NID_LRBG);
		this.T_TRAIN_MSG = T_TRAIN_MSG;
	}
}
