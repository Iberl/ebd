package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 27 <br>
 * Type: Track To Train <br>
 * Description: SH Refused
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_27 extends TrackMessage {

	// ----------
	// SH Refused
	// ----------

	/** {@link ETCSVariables#T_TRAIN} */
	@BitLength(32)
	@OrderIndex(5)
	public long T_TRAIN_RQST = ETCSVariables.T_TRAIN;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_27}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_27() { super(27); }

	/**
	 * Constructs A {@link Message_27}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param T_TRAIN_RQST
	 *            {@link ETCSVariables#T_TRAIN}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_27(long T_TRAIN, boolean M_ACK, int NID_LRBG, long T_TRAIN_RQST) {
		super(27, T_TRAIN, M_ACK, NID_LRBG);
		this.T_TRAIN_RQST = T_TRAIN_RQST;
	}
}
