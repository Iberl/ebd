package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 132 <br>
 * Type: Train To Track <br>
 * Description: MA Request <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Message_132 extends TrainMessage {

	// ----------
	// MA Request
	// ----------

	/** {@link ETCSVariables#Q_MARQSTREASON} */
	@BitLength(5)
	@OrderIndex(4)
	public int Q_MARQSTREASON = ETCSVariables.Q_MARQSTREASON;

	/** {@link PositionPacket} */
	@OrderIndex(5)
	public PositionPacket PACKET_POSITION;

	/** List Of Optional {@link TrainPacket}s */
	@OrderIndex(6)
	@ItemType(TrainPacket.class)
	public List<TrainPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_132}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_132() {
		super(132);
	}

	/**
	 * Constructs A {@link Message_132}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param Q_MARQSTREASON
	 *            {@link ETCSVariables#Q_MARQSTREASON}
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_132(long T_TRAIN, int NID_ENGINE, int Q_MARQSTREASON, PositionPacket PACKET_POSITION) {
		super(132, T_TRAIN, NID_ENGINE);
		this.Q_MARQSTREASON  = Q_MARQSTREASON;
		this.PACKET_POSITION = PACKET_POSITION;
	}

}
