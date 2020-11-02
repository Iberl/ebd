package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_80;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OptionalPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 9 <br>
 * Type: Track To Train <br>
 * Description: Request To Shorten MA <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_9 extends TrackMessage {

	// ---------------------
	// Request To Shorten MA
	// ---------------------

	/** {@link Packet_15} */
	@OrderIndex(5)
	public Packet_15 packet_15 = new Packet_15();

	/** {@link Packet_80} */
	@OrderIndex(6)
	@OptionalPacket
	public Packet_80 packet_80;

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(7)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_9}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_9() { super(9); }

	/**
	 * Constructs A {@link Message_9}
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
	public Message_9(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_15 packet_15) {
		super(9, T_TRAIN, M_ACK, NID_LRBG);
		this.packet_15 = packet_15;
	}

	/**
	 * Constructs A {@link Message_9} with an optional {@link Packet_80}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param packet_15
	 *            {@link Packet_15}
	 * @param packet_80
	 * 			  {@link Packet_80}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_9(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_15 packet_15, Packet_80 packet_80) {
		super(9, T_TRAIN, M_ACK, NID_LRBG);
		this.packet_15 = packet_15;
		this.packet_80 = packet_80;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_9 message_9 = (Message_9) object;
		return Objects.equals(packet_15, message_9.packet_15) && Objects.equals(packet_80, message_9.packet_80) &&
			   packets.equals(message_9.packets);
	}

	@Override
	public String toString() {
		return "Message_9{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", packet_15=" + packet_15.toString()
			   + ", packet_80=" + (packet_80 == null ? "null" : packet_80.toString())
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
