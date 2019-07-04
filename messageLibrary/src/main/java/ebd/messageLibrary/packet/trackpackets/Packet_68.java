package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

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
@OrderLength(8)
public class Packet_68 extends TrackPacketSCALE {

	/**Subclass For Handling Iterated Conditions */
	@OrderLength(3)
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
	 * Consturcts A {@link Packet_68} With An Empty Profile
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_TRACKINIT
	 *            {@link ETCSVariables#D_TRACKINIT}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_68(int Q_DIR, int Q_SCALE, int D_TRACKINIT) {
        super(68, Q_DIR, Q_SCALE);
        this.Q_TRACKINIT = false;
        this.D_TRACKINIT = D_TRACKINIT;
    }

	/**
	 * Constructs A {@link Packet_68} With Possible Profiles
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param condition
	 *            {@link Packet_68_Condition}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_68(int Q_DIR, int Q_SCALE, Packet_68_Condition condition) {
        super(68, Q_DIR, Q_SCALE);
        this.Q_TRACKINIT = true;
        this.condition   = condition;
    }

}
