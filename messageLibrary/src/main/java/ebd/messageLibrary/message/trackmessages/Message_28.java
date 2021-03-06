package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 28 <br>
 * Type: Track To Train <br>
 * Description: SH Accepted <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_28 extends TrackMessage {

	// -----------
	// SH Accepted
	// -----------

	/** {@link ETCSVariables#T_TRAIN} */
	@BitLength(32)
	@OrderIndex(5)
	public long T_TRAIN_RQST = ETCSVariables.T_TRAIN;

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(6)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_28}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_28() { super(28); }

	/**
	 * Constructs A {@link Message_28}
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
	public Message_28(long T_TRAIN, boolean M_ACK, int NID_LRBG, long T_TRAIN_RQST) {
		super(28, T_TRAIN, M_ACK, NID_LRBG);
		this.T_TRAIN_RQST = T_TRAIN_RQST;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_28 that = (Message_28) object;
		return T_TRAIN_RQST == that.T_TRAIN_RQST && packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_28{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", T_TRAIN_RQST=" + T_TRAIN_RQST
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
