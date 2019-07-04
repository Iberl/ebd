package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 150 <br>
 * Type: Train To Track <br>
 * Description: End Of Mission
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Message_150 extends TrainMessage {

	// --------------
	// End Of Mission
	// --------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket PACKET_POSITION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_150}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_150() {
		super(150);
	}

	/**
	 * Constructs A {@link Message_150}
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
	public Message_150(long T_TRAIN, int NID_ENGINE, PositionPacket PACKET_POSITION) {
		super(150, T_TRAIN, NID_ENGINE);
		this.PACKET_POSITION = PACKET_POSITION;
	}


}
