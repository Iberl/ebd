package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfEqual;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ebd.messageLibrary.util.ETCSVariables.M_LEVEL_NTC;

/**
 * ID: 41 <br>
 * Type: Track To Train <br>
 * Description: Level Transition Order <br>
 * Transmitted By: Any <br>
 * Subclasses: Level <br>
 * Element: level <br>
 * Lists: levels
 *
 * @author Christopher Bernjus
 */
public class Packet_41 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Levels */
	public static class Packet_41_Level {

		/** {@link ETCSVariables#M_LEVELTR} */
		@BitLength(3)
		@OrderIndex(0)
		public int M_LEVELTR = ETCSVariables.M_LEVELTR;

			/** {@link ETCSVariables#NID_NTC} */
			@BitLength(8)
			@OrderIndex(1)
			@IfEqual(field = "M_LEVELTR", value = M_LEVEL_NTC)
			public int NID_NTC = ETCSVariables.NID_NTC;

		/** {@link ETCSVariables#L_ACKLEVELTR} */
		@BitLength(15)
		@OrderIndex(2)
		public int L_ACKLEVELTR = ETCSVariables.L_ACKLEVELTR;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_41_Level}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_41_Level() {}

		/**
		 * Constructs A {@link Packet_41_Level}
		 *
		 * @param M_LEVELTR
		 *            {@link ETCSVariables#M_LEVELTR}
		 * @param NID_NTC
		 *            {@link ETCSVariables#NID_NTC}
		 * @param L_ACKLEVELTR
		 *            {@link ETCSVariables#L_ACKLEVELTR}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_41_Level(int M_LEVELTR, int NID_NTC, int L_ACKLEVELTR) {
			this.M_LEVELTR    = M_LEVELTR;
			this.NID_NTC      = NID_NTC;
			this.L_ACKLEVELTR = L_ACKLEVELTR;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_41_Level that = (Packet_41_Level) object;
			return M_LEVELTR == that.M_LEVELTR && NID_NTC == that.NID_NTC && L_ACKLEVELTR == that.L_ACKLEVELTR;
		}

		@Override
		public String toString() {
			return "Packet_41_Level{"
				   + "M_LEVELTR=" + M_LEVELTR + ", NID_NTC=" + NID_NTC + ", L_ACKLEVELTR=" + L_ACKLEVELTR
				   + '}';
		}

	}


	// ----------------------
    // Level Transition Order
	// ----------------------

	/** {@link ETCSVariables#D_LEVELTR} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_LEVELTR = ETCSVariables.D_LEVELTR;

	/** First {@link Packet_41_Level} */
    @OrderIndex(5)
	public Packet_41_Level level = new Packet_41_Level();

	/** List Of Additional {@link Packet_41_Level}s */
    @OrderIndex(6)
    @ItemType(Packet_41_Level.class)
	public List<Packet_41_Level> levels = new ArrayList<>();


    // Constructors

	/**
	 * Constructs An Empty {@link Packet_41}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_41() {
        super(41);
    }

	/**
	 * Constructs A {@link Packet_41}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_LEVELTR
	 *            {@link ETCSVariables#D_LEVELTR}
	 * @param level
	 *            {@link Packet_41_Level}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_41(int Q_DIR, int Q_SCALE,
              int D_LEVELTR, Packet_41_Level level) {
        super(41, Q_DIR, Q_SCALE);
        this.D_LEVELTR = D_LEVELTR;
        this.level     = level;
    }


    // Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_41 packet_41 = (Packet_41) object;
		return D_LEVELTR == packet_41.D_LEVELTR && Objects.equals(level, packet_41.level) && levels.equals(packet_41.levels);
	}

	@Override
	public String toString() {
		return "Packet_41{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", D_LEVELTR=" + D_LEVELTR
			   + ", level=" + level.toString()
			   + ", levels=" + levels.toString()
			   + '}';
	}

}
