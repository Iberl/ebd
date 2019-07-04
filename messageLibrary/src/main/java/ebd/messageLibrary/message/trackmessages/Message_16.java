package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 16 <br>
 * Type: Track To Train <br>
 * Description: Unconditional Emergency Stop
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_16 extends TrackMessage {

	// ----------------------------
	// Unconditional Emergency Stop
	// ----------------------------

	/** {@link ETCSVariables#NID_EM} */
	@BitLength(4)
	@OrderIndex(5)
	public int NID_EM = ETCSVariables.NID_EM;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_16}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_16() { super(16); }

	/**
	 * Constructs A {@link Message_16}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param NID_EM
	 *            {@link ETCSVariables#NID_EM}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_16(long T_TRAIN, boolean M_ACK, int NID_LRBG, int NID_EM) {
		super(16, T_TRAIN, M_ACK, NID_LRBG);
		this.NID_EM = NID_EM;
	}
}
