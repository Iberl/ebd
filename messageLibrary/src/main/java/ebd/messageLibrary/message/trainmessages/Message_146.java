package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 146 <br>
 * Type: Train To Track <br>
 * Description: Acknowledgement <br>
 * Note: Second T_TRAIN Variable is named T_TRAIN_MSG
 *
 * @author Christopher Bernjus
 */
public class Message_146 extends TrainMessage {

	// ---------------
	// Acknowledgement
	// ---------------

	/** {@link ETCSVariables#T_TRAIN} */
	@BitLength(32)
	@OrderIndex(4)
	public long T_TRAIN_MSG = ETCSVariables.T_TRAIN;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_146}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_146() { super(146); }

	/**
	 * Constructs A {@link Message_146}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param T_TRAIN_MSG
	 *            {@link ETCSVariables#T_TRAIN}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_146(long T_TRAIN, int NID_ENGINE, long T_TRAIN_MSG) {
		super(146, T_TRAIN, NID_ENGINE);
		this.T_TRAIN_MSG = T_TRAIN_MSG;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_146 that = (Message_146) object;
		return T_TRAIN_MSG == that.T_TRAIN_MSG;
	}

	@Override
	public String toString() {
		return "Message_146{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", T_TRAIN_MSG=" + T_TRAIN_MSG
			   + '}';
	}

}
