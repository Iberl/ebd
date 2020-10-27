package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 80 <br>
 * Type: Track To Train <br>
 * Description: Mode Profile Associated To An MA <br>
 * Transmitted By: Any <br>
 * Subclasses: MAMODE <br>
 * Elements: mode <br>
 * Lists: modes
 *
 * @author Christopher Bernjus
 */
public class Packet_80 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated MA Modes */
	public static class Packet_80_MAMode {

		/** {@link ETCSVariables#D_MAMODE} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_MAMODE     = ETCSVariables.D_MAMODE;

		/** {@link ETCSVariables#M_MAMODE} */
		@BitLength(2)
		@OrderIndex(1)
		public int M_MAMODE     = ETCSVariables.M_MAMODE;

		/** {@link ETCSVariables#V_MAMODE} */
		@BitLength(7)
		@OrderIndex(2)
		public int V_MAMODE     = ETCSVariables.V_MAMODE;

		/** {@link ETCSVariables#L_MAMODE} */
		@BitLength(15)
		@OrderIndex(3)
		public int L_MAMODE     = ETCSVariables.L_MAMODE;

		/** {@link ETCSVariables#L_ACKMAMODE} */
		@BitLength(15)
		@OrderIndex(4)
		public int L_ACKMAMODE  = ETCSVariables.L_ACKMAMODE;

		/** {@link ETCSVariables#Q_MAMODE} */
		@BitLength(1)
		@OrderIndex(5)
		public boolean Q_MAMODE = ETCSVariables.Q_MAMODE;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_80_MAMode}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_80_MAMode() {}

		/**
		 * Constructs A {@link Packet_80_MAMode}
		 *
		 * @param D_MAMODE
		 *            {@link ETCSVariables#D_MAMODE}
		 * @param M_MAMODE
		 *            {@link ETCSVariables#M_MAMODE}
		 * @param V_MAMODE
		 *            {@link ETCSVariables#V_MAMODE}
		 * @param L_MAMODE
		 *            {@link ETCSVariables#L_MAMODE}
		 * @param L_ACKMAMODE
		 *            {@link ETCSVariables#L_ACKMAMODE}
		 * @param Q_MAMODE
		 *            {@link ETCSVariables#Q_MAMODE}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_80_MAMode(int D_MAMODE, int M_MAMODE, int V_MAMODE, int L_MAMODE, int L_ACKMAMODE, boolean Q_MAMODE) {
			this.D_MAMODE    = D_MAMODE;
			this.M_MAMODE    = M_MAMODE;
			this.V_MAMODE    = V_MAMODE;
			this.L_MAMODE    = L_MAMODE;
			this.L_ACKMAMODE = L_ACKMAMODE;
			this.Q_MAMODE    = Q_MAMODE;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_80_MAMode that = (Packet_80_MAMode) object;
			return D_MAMODE == that.D_MAMODE && M_MAMODE == that.M_MAMODE && V_MAMODE == that.V_MAMODE && L_MAMODE == that.L_MAMODE &&
				   L_ACKMAMODE == that.L_ACKMAMODE && Q_MAMODE == that.Q_MAMODE;
		}

		@Override
		public String toString() {
			return "Packet_80_MAMode{"
				   + "D_MAMODE=" + D_MAMODE + ", M_MAMODE=" + M_MAMODE + ", V_MAMODE=" + V_MAMODE
				   + ", L_MAMODE=" + L_MAMODE + ", L_ACKMAMODE=" + L_ACKMAMODE + ", Q_MAMODE=" + Q_MAMODE
				   + '}';
		}

	}


	// --------------------------------
	// Mode Profile Associated To An MA
	// --------------------------------

	/** First {@link Packet_80_MAMode} */
	@OrderIndex(4)
	public Packet_80_MAMode mode = new Packet_80_MAMode();

	/** List Of Additional {@link Packet_80_MAMode}s */
	@OrderIndex(5)
	@ItemType(Packet_80_MAMode.class)
	public List<Packet_80_MAMode> modes = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_80}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_80() {
		super(80);
	}

	/**
	 * Constructs A {@link Packet_80}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param mode
	 *            {@link Packet_80_MAMode}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_80(int Q_DIR, int Q_SCALE, Packet_80_MAMode mode) {
		super(80, Q_DIR, Q_SCALE);
		this.mode = mode;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_80 packet_80 = (Packet_80) object;
		return Objects.equals(mode, packet_80.mode) && modes.equals(packet_80.modes);
	}

	@Override
	public String toString() {
		return "Packet_80{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", mode=" + mode.toString()
			   + ", modes=" + modes.toString()
			   + '}';
	}

}
