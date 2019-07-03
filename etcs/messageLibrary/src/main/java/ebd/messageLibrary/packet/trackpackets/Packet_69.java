package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 69 <br>
 * Type: Track To Train <br>
 * Description: Track Condition Station Platforms <br>
 * Transmitted By: Any <br>
 * Subclasses: Platform <br>
 * Elements: platform <br>
 * Lists: platforms
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Packet_69 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Platforms */
	@OrderLength(4)
	public static class Packet_69_Platform {

		/** {@link ETCSVariables#D_TRACKCOND} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_TRACKCOND = ETCSVariables.D_TRACKCOND;

		/** {@link ETCSVariables#L_TRACKCOND} */
		@BitLength(15)
		@OrderIndex(1)
		public int L_TRACKCOND = ETCSVariables.L_TRACKCOND;

		/** {@link ETCSVariables#M_PLATFORM} */
		@BitLength(4)
		@OrderIndex(2)
		public int M_PLATFORM  = ETCSVariables.M_PLATFORM;

		/** {@link ETCSVariables#Q_PLATFORM} */
		@BitLength(2)
		@OrderIndex(3)
		public int Q_PLATFORM  = ETCSVariables.Q_PLATFORM;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_69_Platform}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_69_Platform() {}

		/**
		 * Constructs A {@link Packet_69_Platform}
		 *
		 * @param D_TRACKCOND
		 *            {@link ETCSVariables#D_TRACKCOND}
		 * @param L_TRACKCOND
		 *            {@link ETCSVariables#L_TRACKCOND}
		 * @param M_PLATFORM
		 *            {@link ETCSVariables#M_PLATFORM}
		 * @param Q_PLATFORM
		 *            {@link ETCSVariables#Q_PLATFORM}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_69_Platform(int D_TRACKCOND, int L_TRACKCOND, int M_PLATFORM, int Q_PLATFORM) {
			this.D_TRACKCOND = D_TRACKCOND;
			this.L_TRACKCOND = L_TRACKCOND;
			this.M_PLATFORM  = M_PLATFORM;
			this.Q_PLATFORM  = Q_PLATFORM;
		}

	}


	// ---------------------------------
	// Track Condition Station Platforms
	// ---------------------------------

	/** {@link ETCSVariables#Q_TRACKINIT} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_TRACKINIT = ETCSVariables.Q_TRACKINIT;

		/** {@link ETCSVariables#D_TRACKINIT} */
		@BitLength(15)
		@OrderIndex(5)
		@IfTrue("Q_TRACKINIT")
		public int D_TRACKINIT     = ETCSVariables.D_TRACKINIT;

		/** First {@link Packet_69_Platform} */
		@OrderIndex(6)
		@IfFalse("Q_TRACKINIT")
		public Packet_69_Platform platform = new Packet_69_Platform();

		/** List Of Additional {@link Packet_69_Platform}s */
		@OrderIndex(7)
		@ItemType(Packet_69_Platform.class)
		@IfFalse("Q_TRACKINIT")
		public List<Packet_69_Platform> platforms = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_69}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_69() {
		super(69);
	}

	/**
	 * Consturcts A {@link Packet_69} With An Empty Profile
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
	public Packet_69(int Q_DIR, int Q_SCALE, int D_TRACKINIT) {
		super(69, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT = false;
		this.D_TRACKINIT = D_TRACKINIT;
	}

	/**
	 * Constructs A {@link Packet_69} With Possible Profiles
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param platform
	 *            {@link Packet_69_Platform}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_69(int Q_DIR, int Q_SCALE, Packet_69_Platform platform) {
		super(69, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT = true;
		this.platform    = platform;
	}

}
