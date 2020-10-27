package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_12;
import ebd.messageLibrary.packet.trackpackets.Packet_136;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 37 <br>
 * Type: Track To Train <br>
 * Description: Infill MA <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_37 extends TrackMessage {

	// ---------
	// Infill MA
	// ---------

	/** {@link Packet_136} */
	@OrderIndex(5)
	public Packet_136 packet_136 = new Packet_136();

	/** {@link Packet_12} */
	@OrderIndex(6)
	public Packet_12 packet_12 = new Packet_12();

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(7)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_37}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_37() { super(37); }

	/**
	 * Constructs A {@link Message_37}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param packet_136
	 *            {@link Packet_136}
	 * @param packet_12
	 * 			  {@link Packet_12}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_37(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_136 packet_136, Packet_12 packet_12) {
		super(37, T_TRAIN, M_ACK, NID_LRBG);
		this.packet_136 = packet_136;
		this.packet_12 = packet_12;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_37 that = (Message_37) object;
		return Objects.equals(packet_136, that.packet_136) && Objects.equals(packet_12, that.packet_12) && packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_37{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", packet_136=" + packet_136.toString()
			   + ", packet_12=" + packet_12.toString()
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
