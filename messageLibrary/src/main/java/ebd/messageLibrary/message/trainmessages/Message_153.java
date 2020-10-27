package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.Objects;

/**
 * ID: 153 <br>
 * Type: Train To Track <br>
 * Description: Radio Infill Request
 *
 * @author Christopher Bernjus
 */
public class Message_153 extends TrainMessage {

	// --------------------
	// Radio Infill Request
	// --------------------

	/** {@link ETCSVariables#NID_C} */
	@BitLength(10)
	@OrderIndex(4)
	public int NID_C = ETCSVariables.NID_C;

	/** {@link ETCSVariables#NID_BG} */
	@BitLength(14)
	@OrderIndex(5)
	public int NID_BG = ETCSVariables.NID_BG;

	/** {@link ETCSVariables#Q_INFILL} */
	@BitLength(1)
	@OrderIndex(6)
	public boolean Q_INFILL = ETCSVariables.Q_INFILL;

	/** {@link PositionPacket} */
	@OrderIndex(7)
	public PositionPacket positionPacket = new Packet_0();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_153}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_153() { super(153); }

	/**
	 * Constructs A {@link Message_153}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param NID_ENGINE
	 *            {@link ETCSVariables#NID_ENGINE}
	 * @param NID_C
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_BG
	 *            {@link ETCSVariables#NID_BG}
	 * @param Q_INFILL
	 *            {@link ETCSVariables#Q_INFILL}
	 * @param positionPacket
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_153(long T_TRAIN, int NID_ENGINE, int NID_C, int NID_BG, boolean Q_INFILL, PositionPacket positionPacket) {
		super(153, T_TRAIN, NID_ENGINE);
		this.NID_C = NID_C;
		this.NID_BG = NID_BG;
		this.Q_INFILL = Q_INFILL;
		this.positionPacket = positionPacket;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_153 that = (Message_153) object;
		return NID_C == that.NID_C && NID_BG == that.NID_BG && Q_INFILL == that.Q_INFILL && Objects.equals(positionPacket, that.positionPacket);
	}

	@Override
	public String toString() {
		return "Message_153{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", NID_ENGINE=" + NID_ENGINE
			   + ", NID_C=" + NID_C + ", NID_BG=" + NID_BG + ", Q_INFILL=" + Q_INFILL
			   + ", positionPacket=" + positionPacket.toString()
			   + '}';
	}

}
