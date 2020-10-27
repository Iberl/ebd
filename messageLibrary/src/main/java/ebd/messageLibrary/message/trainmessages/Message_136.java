package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 136 <br>
 * Type: Train To Track <br>
 * Description: Train Position Report <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_136 extends TrainMessage {

	// ---------------------
	// Train Position Report
	// ---------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket positionPacket = new Packet_0();

	/** List Of Optional {@link TrainPacket}s */
	@OrderIndex(5)
	@ItemType(TrainPacket.class)
	public List<TrainPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_136}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_136() { super(136); }

	/**
	 * Constructs A {@link Message_136}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param positionPacket
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_136(long T_TRAIN, int NID_ENGINE, PositionPacket positionPacket) {
		super(136, T_TRAIN, NID_ENGINE);
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_136 that = (Message_136) object;
		return Objects.equals(positionPacket, that.positionPacket) && packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_136{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", positionPacket=" + positionPacket.toString()
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
