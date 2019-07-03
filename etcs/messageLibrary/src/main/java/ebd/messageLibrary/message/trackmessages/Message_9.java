package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_80;
import ebd.messageLibrary.serialization.annotations.CanBeNull;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 9 <br>
 * Type: Track To Train <br>
 * Description: Request To Shorten MA <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Message_9 extends TrackMessage {

	// ---------------------
	// Request To Shorten MA
	// ---------------------

	/** {@link Packet_15} */
	@OrderIndex(5)
	public Packet_15 Packet_15;

	/** {@link Packet_80} */
	@OrderIndex(6)
	@CanBeNull
	public Packet_80 Packet_80;

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
	 * @param Packet_15
	 *            {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_9(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_15 Packet_15) {
		super(9, T_TRAIN, M_ACK, NID_LRBG);
		this.Packet_15 = Packet_15;
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
	 * @param Packet_15
	 *            {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_9(long T_TRAIN, boolean M_ACK, int NID_LRBG, Packet_15 Packet_15, Packet_80 Packet_80) {
		super(9, T_TRAIN, M_ACK, NID_LRBG);
		this.Packet_15 = Packet_15;
		this.Packet_80 = Packet_80;
	}

}
