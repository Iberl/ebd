package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 52 <br>
 * Type: Track To Train <br>
 * Description: Permitted Braking Distance Information <br>
 * Transmitted By: Any <br>
 * Subclasses: BreakingInfo <br>
 * Elements: breakingInfo <br>
 * Lists: breakingInfos
 *
 * @author Christopher Bernjus
 */
public class Packet_52 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Breaking Infos */
	public static class Packet_52_BreakingInfo {

		/** {@link ETCSVariables#D_PBD} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_PBD       = ETCSVariables.D_PBD;

		/** {@link ETCSVariables#Q_GDIR} */
		@BitLength(1)
		@OrderIndex(1)
		public boolean Q_GDIR  = ETCSVariables.Q_GDIR;

		/** {@link ETCSVariables#G_PBDSR} */
		@BitLength(8)
		@OrderIndex(2)
		public int G_PBDSR     = ETCSVariables.G_PBDSR;

		/** {@link ETCSVariables#Q_PBDSR} */
		@BitLength(1)
		@OrderIndex(3)
		public boolean Q_PBDSR = ETCSVariables.Q_PBDSR;

		/** {@link ETCSVariables#D_PBDSR} */
		@BitLength(15)
		@OrderIndex(4)
		public int D_PBDSR     = ETCSVariables.D_PBDSR;

		/** {@link ETCSVariables#L_PBDSR} */
		@BitLength(15)
		@OrderIndex(5)
		public int L_PBDSR     = ETCSVariables.L_PBDSR;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_52_BreakingInfo}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_52_BreakingInfo() {}

		/**
		 * Constructs A {@link Packet_52_BreakingInfo}
		 *
		 * @param D_PBD
		 *            {@link ETCSVariables#D_PBD}
		 * @param Q_GDIR
		 *            {@link ETCSVariables#Q_GDIR}
		 * @param G_PBDSR
		 *            {@link ETCSVariables#G_PBDSR}
		 * @param Q_PBDSR
		 *            {@link ETCSVariables#Q_PBDSR}
		 * @param D_PBDSR
		 *            {@link ETCSVariables#D_PBDSR}
		 * @param L_PBDSR
		 *            {@link ETCSVariables#L_PBDSR}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_52_BreakingInfo(int D_PBD, boolean Q_GDIR, int G_PBDSR, boolean Q_PBDSR, int D_PBDSR, int L_PBDSR) {
			this.D_PBD   = D_PBD;
			this.Q_GDIR  = Q_GDIR;
			this.G_PBDSR = G_PBDSR;
			this.Q_PBDSR = Q_PBDSR;
			this.D_PBDSR = D_PBDSR;
			this.L_PBDSR = L_PBDSR;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_52_BreakingInfo that = (Packet_52_BreakingInfo) object;
			return D_PBD == that.D_PBD && Q_GDIR == that.Q_GDIR && G_PBDSR == that.G_PBDSR && Q_PBDSR == that.Q_PBDSR && D_PBDSR == that.D_PBDSR &&
				   L_PBDSR == that.L_PBDSR;
		}

		@Override
		public String toString() {
			return "Packet_52_BreakingInfo{"
				   + "D_PBD=" + D_PBD + ", Q_GDIR=" + Q_GDIR + ", G_PBDSR=" + G_PBDSR
				   + ", Q_PBDSR=" + Q_PBDSR + ", D_PBDSR=" + D_PBDSR + ", L_PBDSR=" + L_PBDSR
				   + '}';
		}

	}

	// --------------------------------------
	// Permitted Braking Distance Information
	// --------------------------------------

	/** {@link ETCSVariables#Q_TRACKINIT} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_TRACKINIT = ETCSVariables.Q_TRACKINIT;

		/** {@link ETCSVariables#D_TRACKINIT} */
		@BitLength(15)
		@OrderIndex(5)
		@IfTrue("Q_TRACKINIT")
		public int D_TRACKINIT     = ETCSVariables.D_TRACKINIT;

		/** First {@link Packet_52_BreakingInfo} */
		@OrderIndex(6)
		@IfFalse("Q_TRACKINIT")
		public Packet_52_BreakingInfo breakingInfo = new Packet_52_BreakingInfo();

		/** List Of {@link Packet_52_BreakingInfo}s */
		@OrderIndex(7)
		@ItemType(Packet_52_BreakingInfo.class)
		@IfFalse("Q_TRACKINIT")
		public List<Packet_52_BreakingInfo> breakingInfos = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_52}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_52() {
		super(52);
	}

	/**
	 * Constructs A {@link Packet_52}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param Q_TRACKINIT
	 *            {@link ETCSVariables#Q_TRACKINIT}
	 * @param D_TRACKINIT
	 *            {@link ETCSVariables#D_TRACKINIT}
	 * @param breakingInfo
	 *            {@link Packet_52_BreakingInfo}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_52(int Q_DIR, int Q_SCALE, boolean Q_TRACKINIT, int D_TRACKINIT, Packet_52_BreakingInfo breakingInfo) {
		super(52, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT  = Q_TRACKINIT;
		this.D_TRACKINIT  = D_TRACKINIT;
		this.breakingInfo = breakingInfo;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_52 packet_52 = (Packet_52) object;
		return Q_TRACKINIT == packet_52.Q_TRACKINIT && D_TRACKINIT == packet_52.D_TRACKINIT && Objects.equals(breakingInfo, packet_52.breakingInfo) &&
			   breakingInfos.equals(packet_52.breakingInfos);
	}

	@Override
	public String toString() {
		return "Packet_52{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", Q_TRACKINIT=" + Q_TRACKINIT + ", D_TRACKINIT=" + D_TRACKINIT
			   + ", breakingInfo=" + breakingInfo.toString()
			   + ", breakingInfos=" + breakingInfos.toString()
			   + '}';
	}

}
