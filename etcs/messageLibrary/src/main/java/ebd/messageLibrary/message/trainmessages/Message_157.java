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
 * ID: 157 <br>
 * Type: Train To Track <br>
 * Description: Text Message Acknowledged By Driver <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Message_157 extends TrainMessage {

	// -------------------
	// SoM Position Report
	// -------------------

	/** {@link ETCSVariables#Q_STATUS} */
	@BitLength(2)
	@OrderIndex(4)
	public int Q_STATUS = ETCSVariables.Q_STATUS;

	/** {@link PositionPacket} */
	@OrderIndex(5)
	public PositionPacket PACKET_POSITION;

	/** List Of Optional {@link TrainPacket}s */
	@OrderIndex(6)
	@ItemType(TrainPacket.class)
	public List<TrainPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_157}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_157() {
		super(157);
	}

	/**
	 * Constructs An Empty {@link Message_157}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param Q_STATUS
	 *            {@link ETCSVariables#Q_STATUS}
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 */
	public Message_157(long T_TRAIN, int NID_ENGINE, int Q_STATUS, PositionPacket PACKET_POSITION) {
		super(157, T_TRAIN, NID_ENGINE);
		this.Q_STATUS = Q_STATUS;
		this.PACKET_POSITION = PACKET_POSITION;
	}
}
