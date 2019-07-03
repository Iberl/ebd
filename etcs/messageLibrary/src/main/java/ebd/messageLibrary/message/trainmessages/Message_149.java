package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 149 <br>
 * Type: Train To Track <br>
 * Description: Track Ahead Free Granted
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Message_149 extends TrainMessage {

	// ------------------------
	// Track Ahead Free Granted
	// ------------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket PACKET_POSITION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_149}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_149() { super(149); }

	/**
	 * Constructs A {@link Message_149}
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
	public Message_149(long T_TRAIN, int NID_ENGINE, PositionPacket PACKET_POSITION) {
		super(149, T_TRAIN, NID_ENGINE);
		this.PACKET_POSITION = PACKET_POSITION;
	}


}
