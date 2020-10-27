package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 150 <br>
 * Type: Train To Track <br>
 * Description: End Of Mission
 *
 * @author Christopher Bernjus
 */
public class Message_150 extends TrainMessage {

	// --------------
	// End Of Mission
	// --------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket positionPacket = new Packet_0();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_150}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_150() {
		super(150);
	}

	/**
	 * Constructs A {@link Message_150}
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
	public Message_150(long T_TRAIN, int NID_ENGINE, PositionPacket positionPacket) {
		super(150, T_TRAIN, NID_ENGINE);
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_150 that = (Message_150) object;
		return Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_150{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
