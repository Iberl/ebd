package ebd.messageLibrary.message.trackmessages;

import ebd.messageLibrary.message.TrackMessage;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.Signed;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 33 <br>
 * Type: Track To Train <br>
 * Description: MA With Shifted Location Reference <br>
 * Lists: packets
 *
 * @author Christopher Bernjus
 */
public class Message_33 extends TrackMessage {

	// ----------------------------------
	// MA With Shifted Location Reference
	// ----------------------------------

	/** {@link ETCSVariables#Q_SCALE} */
	@BitLength(2)
	@OrderIndex(5)
	public int Q_SCALE = ETCSVariables.Q_SCALE;

	/** {@link ETCSVariables#D_REF} */
	@BitLength(16)
	@OrderIndex(6)
	@Signed
	public int D_REF = ETCSVariables.D_REF;

	/** {@link Packet_15} */
	@OrderIndex(7)
	public Packet_15 packet_15 = new Packet_15();

	/** List Of Optional {@link TrackPacket}s */
	@OrderIndex(8)
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
	 * @param Q_SCALE
	 * 			  {@link ETCSVariables#Q_SCALE}
	 * @param D_REF
	 *            {@link ETCSVariables#D_REF}
	 * @param packet_15
	 *            {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Message_33(long T_TRAIN, boolean M_ACK, int NID_LRBG, int Q_SCALE, int D_REF, Packet_15 packet_15) {
		super(33, T_TRAIN, M_ACK, NID_LRBG);
		this.Q_SCALE = Q_SCALE;
		this.D_REF = D_REF;
		this.packet_15 = packet_15;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Message_33 that = (Message_33) object;
		return D_REF == that.D_REF && Objects.equals(packet_15, that.packet_15) && packets.equals(that.packets);
	}

	@Override
	public String toString() {
		return "Message_33{"
			   + "NID_MESSAGE=" + NID_MESSAGE + ", L_MESSAGE=" + L_MESSAGE + ", T_TRAIN=" + T_TRAIN
			   + ", M_ACK=" + M_ACK + ", NID_LRBG=" + NID_LRBG
			   + ", Q_SCALE=" + Q_SCALE + ", D_REF=" + D_REF
			   + ", packet_15=" + packet_15.toString()
			   + ", packets=" + packets.toString()
			   + '}';
	}

}
