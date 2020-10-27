package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 24 <br>
 * Type: Track To Train <br>
 * Description: General Message <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_24 extends TrackMessage {

	// ---------------
	// General Message
	// ---------------

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(5)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_24}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_24() { super(24); }

	/**
	 * Constructs A {@link Message_24}
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
	public Message_24(long T_TRAIN, boolean M_ACK, int NID_LRBG) { super(24, T_TRAIN, M_ACK, NID_LRBG); }


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_24 that = (Message_24) object;
		return packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_24{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
