package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 149 <br>
 * Type: Train To Track <br>
 * Description: Track Ahead Free Granted
 *
 * @author Christopher Bernjus
 */
public class Message_149 extends TrainMessage {

	// ------------------------
	// Track Ahead Free Granted
	// ------------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket positionPacket = new Packet_0();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_149}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_149() { super(149); }

	/**
	 * Constructs A {@link Message_149}
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
	public Message_149(long T_TRAIN, int NID_ENGINE, PositionPacket positionPacket) {
		super(149, T_TRAIN, NID_ENGINE);
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_149 that = (Message_149) object;
		return Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_149{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
