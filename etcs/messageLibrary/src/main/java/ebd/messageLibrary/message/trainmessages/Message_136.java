package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 136 <br>
 * Type: Train To Track <br>
 * Description: Train Position Report <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_136 extends TrainMessage {

	// ---------------------
	// Train Position Report
	// ---------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket PACKET_POSITION;

	/** List Of Optional {@link TrainPacket}s */
	@OrderIndex(5)
	@ItemType(TrainPacket.class)
	public List<TrainPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_136}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_136() { super(136); }

	/**
	 * Constructs A {@link Message_136}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_136(long T_TRAIN, int NID_ENGINE, PositionPacket PACKET_POSITION) {
		super(136, T_TRAIN, NID_ENGINE);
		this.PACKET_POSITION = PACKET_POSITION;
	}
}
