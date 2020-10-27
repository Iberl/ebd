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
 * ID: 157 <br>
 * Type: Train To Track <br>
 * Description: Text Message Acknowledged By Driver <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
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
	public PositionPacket positionPacket = new Packet_0();

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
	 * @param positionPacket
	 *            {@link PositionPacket}
	 */
	public Message_157(long T_TRAIN, int NID_ENGINE, int Q_STATUS, PositionPacket positionPacket) {
		super(157, T_TRAIN, NID_ENGINE);
		this.Q_STATUS = Q_STATUS;
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_157 that = (Message_157) object;
		return Q_STATUS == that.Q_STATUS && Objects.equals(positionPacket, that.positionPacket) && packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_157{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", Q_STATUS=" + Q_STATUS
			   + ", positionPacket=" + positionPacket.toString()
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
