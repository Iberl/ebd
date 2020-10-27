package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.Packet_11;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 129 <br>
 * Type: Train To Track <br>
 * Description: Validated Train Data
 *
 * @author Christopher Bernjus
 */
public class Message_129 extends TrainMessage {

	// --------------------
	// Validated Train Data
	// --------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket positionPacket = new Packet_0();

	/** {@link Packet_11} */
	@OrderIndex(5)
	public Packet_11 packet_11 = new Packet_11();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_129}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_129() {
		super(129);
	}

	/**
	 * Constructs A {@link Message_129}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param positionPacket
	 *            {@link PositionPacket}
	 * @param packet_11
	 *            {@link Packet_11}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_129(long T_TRAIN, int NID_ENGINE, PositionPacket positionPacket, Packet_11 packet_11) {
		super(129, T_TRAIN, NID_ENGINE);
		this.positionPacket = positionPacket;
		this.packet_11 = packet_11;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_129 that = (Message_129) object;
		return Objects.equals(positionPacket, that.positionPacket) && Objects.equals(packet_11, that.packet_11);
	}

	@Override
	public String toString() {
		return "Message_129{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", positionPacket=" + positionPacket.toString()
			   + ", packet_11=" + packet_11.toString()
			   + '}';
	}

}
