package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 159 <br>
 * Type: Train To Track <br>
 * Description: Session Established <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(5)
public class Message_159 extends TrainMessage {

	// -------------------
	// Session Established
	// -------------------

	/** List Of Optional {@link TrainPacket}s */
	@OrderIndex(4)
	@ItemType(TrainPacket.class)
	public List<TrainPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_159}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_159() { super(159); }

	/**
	 * Constructs A {@link Message_159}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_159(long T_TRAIN, int NID_ENGINE) { super(159, T_TRAIN, NID_ENGINE); }

}
