package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_11;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 129 <br>
 * Type: Train To Track <br>
 * Description: Validated Train Data
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_129 extends TrainMessage {

	// --------------------
	// Validated Train Data
	// --------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket PACKET_POSITION;

	/** {@link Packet_11} */
	@OrderIndex(5)
	public Packet_11 PACKET_11;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_129}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_129() {
		super(129);
	}

	/**
	 * Constructs A {@link Message_129}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 * @param PACKET_11
	 *            {@link Packet_11}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_129(long T_TRAIN, int NID_ENGINE, PositionPacket PACKET_POSITION, Packet_11 PACKET_11) {
		super(129, T_TRAIN, NID_ENGINE);
		this.PACKET_POSITION = PACKET_POSITION;
		this.PACKET_11       = PACKET_11;
	}
}
