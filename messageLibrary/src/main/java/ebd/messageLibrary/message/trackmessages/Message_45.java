package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 45 <br>
 * Type: Track To Train <br>
 * Description: Assignment Of Coordinate System
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_45 extends TrackMessage {

	// -------------------------------
	// Assignment Of Coordinate System
	// -------------------------------

	/** {@link ETCSVariables#Q_ORIENTATION} */
	@OrderIndex(5)
	public boolean Q_ORIENTATION = ETCSVariables.Q_ORIENTATION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_45}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_45() { super(45); }

	/**
	 * Constructs A {@link Message_45}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param Q_ORIENTATION
	 *            {@link ETCSVariables#Q_ORIENTATION}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_45(long T_TRAIN, boolean M_ACK, int NID_LRBG, boolean Q_ORIENTATION) {
		super(45, T_TRAIN, M_ACK, NID_LRBG);
		this.Q_ORIENTATION = Q_ORIENTATION;
	}
}
