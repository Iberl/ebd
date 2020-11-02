package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 3 <br>
 * Type: Track To Train <br>
 * Description: Movement Authority <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_3 extends TrackMessage {

	// ------------------
	// Movement Authority
	// ------------------

	/** {@link Packet_15} */
	@OrderIndex(5)
	public Packet_15 packet_15 = new Packet_15();

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(6)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_3}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_3() { super(3); }

	/**
	 * Constructs A {@link Message_3}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param packet_15
	 *            {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_3(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_15 packet_15) {
		super(3, T_TRAIN, M_ACK, NID_LRBG);
		this.packet_15 = packet_15;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_3 message_3 = (Message_3) object;
		return Objects.equals(packet_15, message_3.packet_15) && packets.equals(message_3.packets);
	}

	@Override
	public String toString() {
		return "Message_3{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", packet_15=" + packet_15.toString()
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
