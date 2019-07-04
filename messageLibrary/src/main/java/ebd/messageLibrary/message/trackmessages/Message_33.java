package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 33 <br>
 * Type: Track To Train <br>
 * Description: MA With Shifted Location Reference <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Message_33 extends TrackMessage {

	// ----------------------------------
	// MA With Shifted Location Reference
	// ----------------------------------

	/** {@link ETCSVariables#D_REF} */
	@BitLength(16)
	@OrderIndex(5)
	@Signed
	public int D_REF = ETCSVariables.D_REF;

	/** {@link Packet_15} */
	@OrderIndex(6)
	public Packet_15 Packet_15;

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(7)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Message_33}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_33() { super(33); }

	/**
	 * Constructs A {@link Message_33}
	 *
	 * @param T_TRAIN
	 *            {@link ETCSVariables#T_TRAIN}
	 * @param M_ACK
	 *            {@link ETCSVariables#M_ACK}
	 * @param NID_LRBG
	 *            {@link ETCSVariables#NID_LRBG}
	 * @param D_REF
	 *            {@link ETCSVariables#D_REF}
	 * @param Packet_15
	 *            {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_33(long T_TRAIN, boolean M_ACK, int NID_LRBG, int D_REF, Packet_15 Packet_15) {
		super(33, T_TRAIN, M_ACK, NID_LRBG);
		this.D_REF = D_REF;
		this.Packet_15 = Packet_15;
	}
}
