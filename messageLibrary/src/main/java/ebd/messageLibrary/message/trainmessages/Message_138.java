package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 138 <br>
 * Type: Train To Track <br>
 * Description: Request To Shorten MA Is Rejected <br>
 * Note: Second T_TRAIN Variable is named T_TRAIN_RQST
 *
 * @author Christopher Bernjus
 */
public class Message_138 extends TrainMessage {

	// ---------------------------------
	// Request To Shorten MA Is Rejected
	// ---------------------------------

	/** {@link ETCSVariables#T_TRAIN} */
	@BitLength(32)
	@OrderIndex(4)
	public long T_TRAIN_RQST = ETCSVariables.T_TRAIN;

	/** {@link PositionPacket} */
	@OrderIndex(5)
	public PositionPacket positionPacket = new Packet_0();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_138}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_138() { super(138); }

	/**
	 * Constructs A {@link Message_138}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param T_TRAIN_RQST
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param positionPacket
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_138(long T_TRAIN, int NID_ENGINE, long T_TRAIN_RQST, PositionPacket positionPacket) {
		super(138, T_TRAIN, NID_ENGINE);
		this.T_TRAIN_RQST = T_TRAIN_RQST;
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_138 that = (Message_138) object;
		return T_TRAIN_RQST == that.T_TRAIN_RQST && Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_138{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", T_TRAIN_RQST=" + T_TRAIN_RQST
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
