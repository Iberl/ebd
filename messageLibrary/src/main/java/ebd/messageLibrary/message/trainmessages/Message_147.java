package ebd.messageLibrary.message.trainmessages;


import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 147 <br>
 * Type: Train To Track <br>
 * Description: Acknowledgement of Emergency Stop
 * @author Christopher Bernjus
 */
public class Message_147 extends TrainMessage {

	// ---------------------------------
	// Acknowledgement of Emergency Stop
	// ---------------------------------

	/** {@link ETCSVariables#NID_EM} */
	@BitLength(4)
	@OrderIndex(4)
	public int NID_EM = ETCSVariables.NID_EM;

	/** {@link ETCSVariables#Q_EMERGENCYSTOP} */
	@BitLength(2)
	@OrderIndex(5)
	public int Q_EMERGENCYSTOP = ETCSVariables.Q_EMERGENCYSTOP;

	/** {@link PositionPacket} */
	@OrderIndex(6)
	public PositionPacket positionPacket;


	// Constructors

	/**
	 * Constructs An Empty {@link Message_147}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_147() { super(147); }

	/**
	 * Constructs A {@link Message_147}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param NID_EM
	 *            {@link ETCSVariables#NID_EM}
	 * @param Q_EMERGENCYSTOP
	 *            {@link ETCSVariables#Q_EMERGENCYSTOP}
	 * @param positionPacket
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_147(long T_TRAIN, int NID_ENGINE, int NID_EM, int Q_EMERGENCYSTOP, PositionPacket positionPacket) {
		super(147, T_TRAIN, NID_ENGINE);
		this.NID_EM = NID_EM;
		this.Q_EMERGENCYSTOP = Q_EMERGENCYSTOP;
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_147 that = (Message_147) object;
		return NID_EM == that.NID_EM && Q_EMERGENCYSTOP == that.Q_EMERGENCYSTOP && Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_147{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", NID_EM=" + NID_EM + ", Q_EMERGENCYSTOP=" + Q_EMERGENCYSTOP
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
