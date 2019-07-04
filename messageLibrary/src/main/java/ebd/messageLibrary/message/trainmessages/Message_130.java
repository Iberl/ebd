package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 130 <br>
 * Type: Train To Track <br>
 * Description: Request For Shunting
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Message_130 extends TrainMessage {

	// --------------------
	// Request For Shunting
	// --------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket PACKET_POSITION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_130}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_130() {
		super(130);
	}

	/**
	 * Constructs A {@link Message_130}
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
	public Message_130(long T_TRAIN, int NID_ENGINE, PositionPacket PACKET_POSITION) {
		super(130, T_TRAIN, NID_ENGINE);
		this.PACKET_POSITION = PACKET_POSITION;
	}

}
