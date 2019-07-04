package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 158 <br>
 * Type: Train To Track <br>
 * Description: Text Message Acknowledged By Driver
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_158 extends TrainMessage {

	// -----------------------------------
	// Text Message Acknowledged By Driver
	// -----------------------------------

	/** {@link ETCSVariables#NID_TEXTMESSAGE} */
	@BitLength(8)
	@OrderIndex(4)
	public int NID_TEXTMESSAGE = ETCSVariables.NID_TEXTMESSAGE;

	/** {@link PositionPacket} */
	@OrderIndex(5)
	public PositionPacket PACKET_POSITION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_158}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_158() { super(158); }

	/**
	 * Constructs A {@link Message_158}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param NID_TEXTMESSAGE
	 *            {@link ETCSVariables#NID_TEXTMESSAGE}
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 */
	public Message_158(long T_TRAIN, int NID_ENGINE, int NID_TEXTMESSAGE, PositionPacket PACKET_POSITION) {
		super(158, T_TRAIN, NID_ENGINE);
		this.NID_TEXTMESSAGE = NID_TEXTMESSAGE;
		this.PACKET_POSITION = PACKET_POSITION;
	}
}
