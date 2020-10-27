package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 130 <br>
 * Type: Train To Track <br>
 * Description: Request For Shunting
 *
 * @author Christopher Bernjus
 */
public class Message_130 extends TrainMessage {

	// --------------------
	// Request For Shunting
	// --------------------

	/** {@link PositionPacket} */
	@OrderIndex(4)
	public PositionPacket positionPacket;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_130}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_130() {
		super(130);
	}

	/**
	 * Constructs A {@link Message_130}
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
	public Message_130(long T_TRAIN, int NID_ENGINE, PositionPacket positionPacket) {
		super(130, T_TRAIN, NID_ENGINE);
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_130 that = (Message_130) object;
		return Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_130{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
