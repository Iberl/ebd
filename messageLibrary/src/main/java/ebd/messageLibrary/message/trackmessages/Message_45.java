package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 45 <br>
 * Type: Track To Train <br>
 * Description: Assignment Of Coordinate System
 *
 * @author Christopher Bernjus
 */
public class Message_45 extends TrackMessage {

	// -------------------------------
	// Assignment Of Coordinate System
	// -------------------------------

	/** {@link ETCSVariables#Q_ORIENTATION} */
	@BitLength(1)
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


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_45 that = (Message_45) object;
		return Q_ORIENTATION == that.Q_ORIENTATION;
	}

	@Override
	public String toString() {
		return "Message_45{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", Q_ORIENTATION=" + Q_ORIENTATION
			   + '}';
	}

}
