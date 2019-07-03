package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 3 <br>
 * Type: Track To Train <br>
 * Description: Movement Authority <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Message_3 extends TrackMessage {

	// ------------------
	// Movement Authority
	// ------------------

	/** {@link Packet_15} */
	@OrderIndex(5)
	public Packet_15 Packet_15;

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
	 * @param Packet_15
	 *            {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_3(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_15 Packet_15) {
		super(3, T_TRAIN, M_ACK, NID_LRBG);
		this.Packet_15 = Packet_15;
	}
}
