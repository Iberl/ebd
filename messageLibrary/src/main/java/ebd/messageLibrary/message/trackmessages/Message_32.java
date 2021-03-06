package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 32 <br>
 * Type: Track To Train <br>
 * Description: RBC/RIU System Version
 *
 * @author Christopher Bernjus
 */
public class Message_32 extends TrackMessage {

	// ----------------------
	// RBC/RIU System Version
	// ----------------------

	/** {@link ETCSVariables#M_VERSION} */
	@BitLength(7)
	@OrderIndex(5)
	public int M_VERSION = ETCSVariables.M_VERSION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_32}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_32() { super(32); }

	/**
	 * Constructs A {@link Message_32}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param M_VERSION
	 *            {@link ETCSVariables#M_VERSION}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_32(long T_TRAIN, boolean M_ACK, int NID_LRBG, int M_VERSION) {
		super(32, T_TRAIN, M_ACK, NID_LRBG);
		this.M_VERSION = M_VERSION;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_32 that = (Message_32) object;
		return M_VERSION == that.M_VERSION;
	}

	@Override
	public String toString() {
		return "Message_32{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", M_VERSION=" + M_VERSION
			   + '}';
	}

}
