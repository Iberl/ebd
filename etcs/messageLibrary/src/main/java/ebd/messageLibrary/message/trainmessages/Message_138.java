package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 138 <br>
 * Type: Train To Track <br>
 * Description: Request To Shorten MA Is Rejected <br>
 * Note: Second T_TRAIN Variable is named T_TRAIN_RQST
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Message_138 extends TrainMessage {

	// ---------------------------------
	// Request To Shorten MA Is Rejected
	// ---------------------------------

	/** {@link ETCSVariables#T_TRAIN} */
	@BitLength(32)
	@OrderIndex(4)
	public long T_TRAIN_RQST = ETCSVariables.T_TRAIN;

	/** {@link PositionPacket} */
	@OrderIndex(5)
	public PositionPacket PACKET_POSITION;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_138}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_138() { super(138); }

	/**
	 * Constructs A {@link Message_138}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param T_TRAIN_RQST
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_138(long T_TRAIN, int NID_ENGINE, long T_TRAIN_RQST, PositionPacket PACKET_POSITION) {
		super(138, T_TRAIN, NID_ENGINE);
		this.T_TRAIN_RQST = T_TRAIN_RQST;
		this.PACKET_POSITION = PACKET_POSITION;
	}
}
