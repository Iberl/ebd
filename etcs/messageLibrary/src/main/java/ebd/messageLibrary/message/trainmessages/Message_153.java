package ebd.messageLibrary.message.trainmessages;

import ebd.messageLibrary.message.TrainMessage;
import ebd.messageLibrary.packet.trainpackets.PositionPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 153 <br>
 * Type: Train To Track <br>
 * Description: Radio Infill Request
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
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
	public PositionPacket PACKET_POSITION;


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
	 * @param PACKET_POSITION
	 *            {@link PositionPacket}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_153(long T_TRAIN, int NID_ENGINE, int NID_C, int NID_BG, boolean Q_INFILL, PositionPacket PACKET_POSITION) {
		super(153, T_TRAIN, NID_ENGINE);
		this.NID_C = NID_C;
		this.NID_BG = NID_BG;
		this.Q_INFILL = Q_INFILL;
		this.PACKET_POSITION = PACKET_POSITION;
	}
}
