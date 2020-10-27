package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 67 <br>
 * Type: Track To Train <br>
 * Description: Track Condition Big Metal Masses <br>
 * Transmitted By: Balise <br>
 * Subclasses: Condition <br>
 * Elements: condition <br>
 * Lists: conditions
 *
 * @author Christopher Bernjus
 */
public class Packet_67 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Track Conditions */
	public static class Packet_67_Condition {

		/** {@link ETCSVariables#D_TRACKCOND} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_TRACKCOND = ETCSVariables.D_TRACKCOND;

		/** {@link ETCSVariables#L_TRACKCOND} */
		@BitLength(15)
		@OrderIndex(1)
		public int L_TRACKCOND = ETCSVariables.L_TRACKCOND;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_67_Condition}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_67_Condition() { }

		/**
		 * Constructs A {@link Packet_67_Condition}
		 *
		 * @param D_TRACKCOND
		 *            {@link ETCSVariables#D_TRACKCOND}
		 * @param L_TRACKCOND
		 *            {@link ETCSVariables#L_TRACKCOND}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_67_Condition(int D_TRACKCOND, int L_TRACKCOND) {
			this.D_TRACKCOND = D_TRACKCOND;
			this.L_TRACKCOND = L_TRACKCOND;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_67_Condition that = (Packet_67_Condition) object;
			return D_TRACKCOND == that.D_TRACKCOND && L_TRACKCOND == that.L_TRACKCOND;
		}

		@Override
		public String toString() {
			return "Packet_67_Condition{"
				   + "D_TRACKCOND=" + D_TRACKCOND + ", L_TRACKCOND=" + L_TRACKCOND
				   + '}';
		}

	}

	// --------------------------------
	// Track Condition Big Metal Masses
	// --------------------------------


	/** {@link Packet_67_Condition} */
	@OrderIndex(4)
	public Packet_67_Condition condition = new Packet_67_Condition();

	/** {@link Packet_67_Condition} */
	@OrderIndex(5)
	@ItemType(Packet_67_Condition.class)
	public List<Packet_67_Condition> conditions = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_67}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_67() {
		super(67);
	}

	/**
	 * Constructs An Empty {@link Packet_67}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param condition
	 *            {@link Packet_67_Condition}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_67(int Q_DIR, int Q_SCALE, Packet_67_Condition condition) {
		super(67, Q_DIR, Q_SCALE);
		this.condition = condition;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_67 packet_67 = (Packet_67) object;
		return Objects.equals(condition, packet_67.condition) && conditions.equals(packet_67.conditions);
	}

	@Override
	public String toString() {
		return "Packet_67{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", condition=" + condition.toString()
			   + ", conditions=" + conditions.toString()
			   + '}';
	}

}
