package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_12;
import ebd.messageLibrary.packet.trackpackets.Packet_136;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 37 <br>
 * Type: Track To Train <br>
 * Description: Infill MA <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Message_37 extends TrackMessage {

	// ---------
	// Infill MA
	// ---------

	/** {@link Packet_136} */
	@OrderIndex(5)
	public Packet_136 Packet_136;

	/** {@link Packet_12} */
	@OrderIndex(6)
	public Packet_12 Packet_12;

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
	 * @param Packet_136
	 *            {@link Packet_136}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_37(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_136 Packet_136, Packet_12 Packet_12) {
		super(37, T_TRAIN, M_ACK, NID_LRBG);
		this.Packet_136 = Packet_136;
		this.Packet_12 = Packet_12;
	}
}
