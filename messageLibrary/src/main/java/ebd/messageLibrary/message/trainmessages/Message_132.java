package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 132 <br>
 * Type: Train To Track <br>
 * Description: MA Request <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
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
	public PositionPacket positionPacket = new Packet_0();

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
	 * @param positionPacket
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_132(long T_TRAIN, int NID_ENGINE, int Q_MARQSTREASON, PositionPacket positionPacket) {
		super(132, T_TRAIN, NID_ENGINE);
		this.Q_MARQSTREASON  = Q_MARQSTREASON;
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_132 that = (Message_132) object;
		return Q_MARQSTREASON == that.Q_MARQSTREASON && Objects.equals(positionPacket, that.positionPacket) && packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_132{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", Q_MARQSTREASON=" + Q_MARQSTREASON
			   + ", positionPacket=" + positionPacket.toString()
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
