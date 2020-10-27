package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
public class Packet_69 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Platforms */
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


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_69_Platform that = (Packet_69_Platform) object;
			return D_TRACKCOND == that.D_TRACKCOND && L_TRACKCOND == that.L_TRACKCOND && M_PLATFORM == that.M_PLATFORM &&
				   Q_PLATFORM == that.Q_PLATFORM;
		}

		@Override
		public String toString() {
			return "Packet_69_Platform{"
				   + "D_TRACKCOND=" + D_TRACKCOND + ", L_TRACKCOND=" + L_TRACKCOND
				   + ", M_PLATFORM=" + M_PLATFORM + ", Q_PLATFORM=" + Q_PLATFORM
				   + '}';
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
	 * Constructs A {@link Packet_69} With Possible Profiles
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param Q_TRACKINIT
	 * 			  {@link ETCSVariables#Q_TRACKINIT}
	 * @param D_TRACKINIT
	 * 			  {@link ETCSVariables#D_TRACKINIT}
	 * @param platform
	 *            {@link Packet_69_Platform}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_69(int Q_DIR, int Q_SCALE, boolean Q_TRACKINIT, int D_TRACKINIT, Packet_69_Platform platform) {
		super(69, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT = Q_TRACKINIT;
		this.D_TRACKINIT = D_TRACKINIT;
		this.platform    = platform;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_69 packet_69 = (Packet_69) object;
		return Q_TRACKINIT == packet_69.Q_TRACKINIT && D_TRACKINIT == packet_69.D_TRACKINIT && Objects.equals(platform, packet_69.platform) &&
			   platforms.equals(packet_69.platforms);
	}

	@Override
	public String toString() {
		return "Packet_69{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", Q_TRACKINIT=" + Q_TRACKINIT + ", D_TRACKINIT=" + D_TRACKINIT
			   + ", platform=" + platform.toString()
			   + ", platforms=" + platforms.toString()
			   + '}';
	}

}
