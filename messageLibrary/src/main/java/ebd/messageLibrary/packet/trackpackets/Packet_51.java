package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 51 <br>
 * Type: Track To Train <br>
 * Description: Axle Load Speed Profile <br>
 * Transmitted By: Any <br>
 * Subclasses: Restriction, Axleload <br>
 * Elements: restriction <br>
 * Lists: restrictions
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Packet_51 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Axleloads */
	@OrderLength(2)
	public static class Packet_51_Axleload {

		/** {@link ETCSVariables#M_AXLELOADCAT} */
		@BitLength(7)
		@OrderIndex(0)
		public int M_AXLELOADCAT = ETCSVariables.M_AXLELOADCAT;

		/** {@link ETCSVariables#V_AXLELOAD} */
		@BitLength(7)
		@OrderIndex(1)
		public int V_AXLELOAD = ETCSVariables.V_AXLELOAD;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_51_Axleload}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_51_Axleload() {}

		/**
		 * Constructs A {@link Packet_51_Axleload}
		 *
		 * @param M_AXLELOADCAT
		 *            {@link ETCSVariables#M_AXLELOADCAT}
		 * @param V_AXLELOAD
		 *            {@link ETCSVariables#V_AXLELOAD}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_51_Axleload(int M_AXLELOADCAT, int V_AXLELOAD) {
			this.M_AXLELOADCAT = M_AXLELOADCAT;
			this.V_AXLELOAD    = V_AXLELOAD;
		}

	}

	/**
	 * Subclass For Handling Iterated Restrictions <br>
	 * Lists: axleloads
	 */
	@OrderLength(4)
	public static class Packet_51_Restriction {

		/** {@link ETCSVariables#D_AXLELOAD} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_AXLELOAD = ETCSVariables.D_AXLELOAD;

		/** {@link ETCSVariables#L_AXLELOAD} */
		@BitLength(15)
		@OrderIndex(1)
		public int L_AXLELOAD = ETCSVariables.L_AXLELOAD;

		/** {@link ETCSVariables#Q_FRONT} */
		@BitLength(1)
		@OrderIndex(2)
		public boolean Q_FRONT = ETCSVariables.Q_FRONT;

		/** List Of {@link Packet_51_Axleload} */
		@OrderIndex(3)
		@ItemType(Packet_51_Axleload.class)
		public List<Packet_51_Axleload> axleloads = new ArrayList<>();


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_51_Restriction}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_51_Restriction() {}

		/**
		 * Constructs A {@link Packet_51_Restriction}
		 *
		 * @param D_AXLELOAD
		 *            {@link ETCSVariables#D_AXLELOAD}
		 * @param L_AXLELOAD
		 *            {@link ETCSVariables#L_AXLELOAD}
		 * @param Q_FRONT
		 *            {@link ETCSVariables#Q_FRONT}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_51_Restriction(int D_AXLELOAD, int L_AXLELOAD, boolean Q_FRONT) {
			this.D_AXLELOAD = D_AXLELOAD;
			this.L_AXLELOAD = L_AXLELOAD;
			this.Q_FRONT    = Q_FRONT;
		}

	}


	// -----------------------
	// Axle Load Speed Profile
	// -----------------------

	/** {@link ETCSVariables#Q_TRACKINIT} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_TRACKINIT = ETCSVariables.Q_TRACKINIT;

		/** {@link ETCSVariables#D_TRACKINIT} */
		@BitLength(15)
		@OrderIndex(5)
		@IfTrue("Q_TRACKINIT")
		public int D_TRACKINIT     = ETCSVariables.D_TRACKINIT;


		/** First {@link Packet_51_Restriction} */
		@OrderIndex(6)
		@IfFalse("Q_TRACKINIT")
		public Packet_51_Restriction restriction = new Packet_51_Restriction();

		/** List Of Additional {@link Packet_51_Restriction}s */
		@OrderIndex(7)
		@ItemType(Packet_51_Restriction.class)
		@IfFalse("Q_TRACKINIT")
		public List<Packet_51_Restriction> restrictions = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_51}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_51() {
		super(51);
	}

	/**
	 * Constructs A {@link Packet_51}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param Q_TRACKINIT
	 *            {@link ETCSVariables#Q_TRACKINIT}
	 * @param D_TRACKINIT
	 *            {@link ETCSVariables#D_TRACKINIT}
	 * @param restriction
	 *            {@link Packet_51_Restriction}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_51(int Q_DIR, int Q_SCALE, boolean Q_TRACKINIT, int D_TRACKINIT, Packet_51_Restriction restriction) {
		super(51, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT = Q_TRACKINIT;
		this.D_TRACKINIT = D_TRACKINIT;
		this.restriction = restriction;
	}

}
