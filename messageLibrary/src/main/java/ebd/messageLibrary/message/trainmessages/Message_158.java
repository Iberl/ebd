package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 158 <br>
 * Type: Train To Track <br>
 * Description: Text Message Acknowledged By Driver
 *
 * @author Christopher Bernjus
 */
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
	public PositionPacket positionPacket = new Packet_0();


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
	 * @param positionPacket
	 *            {@link PositionPacket}
	 */
	public Message_158(long T_TRAIN, int NID_ENGINE, int NID_TEXTMESSAGE, PositionPacket positionPacket) {
		super(158, T_TRAIN, NID_ENGINE);
		this.NID_TEXTMESSAGE = NID_TEXTMESSAGE;
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_158 that = (Message_158) object;
		return NID_TEXTMESSAGE == that.NID_TEXTMESSAGE && Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_158{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", NID_TEXTMESSAGE=" + NID_TEXTMESSAGE
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
