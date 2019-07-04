package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.Packet;
import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 2 <br>
 * Type: Track To Train <br>
 * Description: SR Authorisation <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Message_2 extends TrackMessage {

	// ----------------
	// SR Authorisation
	// ----------------

	/** {@link ETCSVariables#Q_SCALE} */
	@BitLength(2)
	@OrderIndex(5)
	public int Q_SCALE = ETCSVariables.Q_SCALE;

	/** {@link ETCSVariables#D_SR} */
	@BitLength(15)
	@OrderIndex(6)
	public int D_SR = ETCSVariables.D_SR;

	/** List Of Optional {@link TrainPacket}s */
	@OrderIndex(7)
	@ItemType(Packet.class)
	public List<TrainPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_2}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_2() { super(2); }

	/**
	 * Constructs A {@link Message_2}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_SR
	 *            {@link ETCSVariables#D_SR}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_2(long T_TRAIN, boolean M_ACK, int NID_LRBG, int Q_SCALE, int D_SR) {
		super(2, T_TRAIN, M_ACK, NID_LRBG);
		this.Q_SCALE = Q_SCALE;
		this.D_SR = D_SR;
	}
}
