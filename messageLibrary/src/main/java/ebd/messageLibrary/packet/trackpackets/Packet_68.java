package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 68 <br>
 * Type: Track To Train <br>
 * Description: Track Condition <br>
 * Transmitted By: Any <br>
 * Subclasses: Condition <br>
 * Elements: condition <br>
 * Lists: conditions
 *
 * @author Christopher Bernjus
 */
public class Packet_68 extends TrackPacketSCALE {

	/**Subclass For Handling Iterated Conditions */
	public static class Packet_68_Condition {

		/** {@link ETCSVariables#D_TRACKCOND} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_TRACKCOND = ETCSVariables.D_TRACKCOND;

		/** {@link ETCSVariables#L_TRACKCOND} */
		@BitLength(15)
		@OrderIndex(1)
		public int L_TRACKCOND = ETCSVariables.L_TRACKCOND;

		/** {@link ETCSVariables#M_TRACKCOND} */
		@BitLength(4)
		@OrderIndex(2)
		public int M_TRACKCOND = ETCSVariables.M_TRACKCOND;


        // Constructors

		/**
		 * Constructs An Empty {@link Packet_68_Condition}
		 *
		 * @author Christopher Bernjus
		 */
        public Packet_68_Condition() {}

		/**
		 * Constructs A {@link Packet_68_Condition}
		 *
		 * @param D_TRACKCOND
		 *            {@link ETCSVariables#D_TRACKCOND}
		 * @param L_TRACKCOND
		 *            {@link ETCSVariables#L_TRACKCOND}
		 * @param M_TRACKCOND
		 *            {@link ETCSVariables#M_TRACKCOND}
		 *
		 * @author Christopher Bernjus#
		 */
		public Packet_68_Condition(int D_TRACKCOND, int L_TRACKCOND, int M_TRACKCOND) {
        	this.D_TRACKCOND = D_TRACKCOND;
        	this.L_TRACKCOND = L_TRACKCOND;
        	this.M_TRACKCOND = M_TRACKCOND;
        }


        // Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_68_Condition that = (Packet_68_Condition) object;
			return D_TRACKCOND == that.D_TRACKCOND && L_TRACKCOND == that.L_TRACKCOND && M_TRACKCOND == that.M_TRACKCOND;
		}

		@Override
		public String toString() {
			return "Packet_68_Condition{"
				   + "D_TRACKCOND=" + D_TRACKCOND + ", L_TRACKCOND=" + L_TRACKCOND + ", M_TRACKCOND=" + M_TRACKCOND
				   + '}';
		}

	}

	// ---------------
    // Track Condition
	// ---------------

	/** {@link ETCSVariables#Q_TRACKINIT} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_TRACKINIT = ETCSVariables.Q_TRACKINIT;

		/** {@link ETCSVariables#D_TRACKINIT} */
		@BitLength(15)
		@OrderIndex(5)
		@IfTrue("Q_TRACKINIT")
		public int D_TRACKINIT     = ETCSVariables.D_TRACKINIT;

		/** First {@link Packet_68_Condition} */
		@OrderIndex(6)
		@IfFalse("Q_TRACKINIT")
	    public Packet_68_Condition condition = new Packet_68_Condition();

		/** List Of Additional {@link Packet_68_Condition}s */
		@OrderIndex(7)
		@ItemType(Packet_68_Condition.class)
		@IfFalse("Q_TRACKINIT")
		public List<Packet_68_Condition> conditions = new ArrayList<>();


    // Constructors

	/**
	 * Constructs An Empty {@link Packet_68}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_68() {
        super(68);
    }


	/**
	 * Constructs A {@link Packet_68}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param Q_TRACKINIT
	 * 			  {@link ETCSVariables#Q_TRACKINIT}
	 * @param D_TRACKINIT
	 * 			  {@link ETCSVariables#D_TRACKINIT}
	 * @param condition
	 *            {@link Packet_68_Condition}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_68(int Q_DIR, int Q_SCALE, boolean Q_TRACKINIT, int D_TRACKINIT, Packet_68_Condition condition) {
        super(68, Q_DIR, Q_SCALE);
        this.Q_TRACKINIT = Q_TRACKINIT;
        this.D_TRACKINIT = D_TRACKINIT;
        this.condition   = condition;
    }


    // Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_68 packet_68 = (Packet_68) object;
		return Q_TRACKINIT == packet_68.Q_TRACKINIT && D_TRACKINIT == packet_68.D_TRACKINIT && Objects.equals(condition, packet_68.condition) &&
			   conditions.equals(packet_68.conditions);
	}

	@Override
	public String toString() {
		return "Packet_68{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", Q_TRACKINIT=" + Q_TRACKINIT + ", D_TRACKINIT=" + D_TRACKINIT
			   + ", condition=" + condition.toString()
			   + ", conditions=" + conditions.toString()
			   + '}';
	}

}
