package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 15 <br>
 * Type: Track To Train <br>
 * Description: Level 2/3 Movement Authority <br>
 * Transmitted By: RBC <br>
 * Subclasses: Section <br>
 * Elements: endsection <br>
 * Lists: sections
 *
 * @author Christopher Bernjus
 */
@OrderLength(19)
public class Packet_15 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Sections */
	//TODO CHECK STATIC INNER CLASSES
	@OrderLength(4)
	public static class Packet_15_Section {

		/** {@link ETCSVariables#L_SECTION} */
		@BitLength(15)
		@OrderIndex(0)
		public int L_SECTION          = ETCSVariables.L_SECTION;

		/** {@link ETCSVariables#Q_SECTIONTIMER} */
		@BitLength(1)
		@OrderIndex(1)
		public boolean Q_SECTIONTIMER = ETCSVariables.Q_SECTIONTIMER;

			/** {@link ETCSVariables#T_SECTIONTIMER} */
			@BitLength(10)
			@OrderIndex(2)
			@IfTrue("Q_SECTIONTIMER")
			public int T_SECTIONTIMER        = ETCSVariables.T_SECTIONTIMER;

			/** {@link ETCSVariables#D_SECTIONTIMERSTOPLOC} */
			@BitLength(15)
			@OrderIndex(3)
			@IfTrue("Q_SECTIONTIMER")
			public int D_SECTIONTIMERSTOPLOC = ETCSVariables.D_SECTIONTIMERSTOPLOC;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_15_Section}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_15_Section() {}

		/**
		 * Constructs A {@link Packet_15_Section}
		 *
		 * @param L_SECTION
		 *            {@link ETCSVariables#L_SECTION}
		 * @param Q_SECTIONTIMER
		 *            {@link ETCSVariables#Q_SECTIONTIMER}
		 * @param T_SECTIONTIMER
		 *            {@link ETCSVariables#T_SECTIONTIMER}
		 * @param D_SECTIONTIMERSTOPLOC
		 *            {@link ETCSVariables#D_SECTIONTIMERSTOPLOC}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_15_Section(int L_SECTION, boolean Q_SECTIONTIMER, int T_SECTIONTIMER, int D_SECTIONTIMERSTOPLOC) {
			this.L_SECTION             = L_SECTION;
			this.Q_SECTIONTIMER        = Q_SECTIONTIMER;
			this.T_SECTIONTIMER        = T_SECTIONTIMER;
			this.D_SECTIONTIMERSTOPLOC = D_SECTIONTIMERSTOPLOC;
		}

	}


	// ----------------------------
	// Level 2/3 Movement Authority
	// ----------------------------

	/** {@link ETCSVariables#V_LOA} */
	@BitLength(7)
	@OrderIndex(4)
	public int V_LOA = ETCSVariables.V_LOA;

	/** {@link ETCSVariables#T_LOA} */
	@BitLength(10)
	@OrderIndex(5)
	public int T_LOA = ETCSVariables.T_LOA;

	/** List Of {@link Packet_15_Section}s */
	@OrderIndex(6)
	@ItemType(Packet_15_Section.class)
	public List<Packet_15_Section> sections = new ArrayList<>();

	/** Endsection / Last {@link Packet_15_Section} */
	@OrderIndex(7)
	public Packet_15_Section endsection = new Packet_15_Section();


	/** {@link ETCSVariables#Q_ENDTIMER} */
	@BitLength(1)
	@OrderIndex(8)
	public boolean Q_ENDTIMER = ETCSVariables.Q_ENDTIMER;

		/** {@link ETCSVariables#T_ENDTIMER} */
		@BitLength(10)
		@OrderIndex(9)
		@IfTrue("Q_ENDTIMER")
		public int T_ENDTIMER         = ETCSVariables.T_ENDTIMER;

		/** {@link ETCSVariables#D_ENDTIMERSTARTLOC} */
		@BitLength(15)
		@OrderIndex(10)
		@IfTrue("Q_ENDTIMER")
		public int D_ENDTIMERSTARTLOC = ETCSVariables.D_ENDTIMERSTARTLOC;


	/** {@link ETCSVariables#Q_DANGERPOINT} */
	@BitLength(1)
	@OrderIndex(11)
	public boolean Q_DANGERPOINT = ETCSVariables.Q_DANGERPOINT;

		/** {@link ETCSVariables#D_DP} */
		@BitLength(15)
		@OrderIndex(12)
		@IfTrue("Q_DANGERPOINT")
		public int D_DP              = ETCSVariables.D_DP;

		/** {@link ETCSVariables#V_RELEASEDP} */
		@BitLength(7)
		@OrderIndex(13)
		@IfTrue("Q_DANGERPOINT")
		public int V_RELEASEDP       = ETCSVariables.V_RELEASEDP;


	/** {@link ETCSVariables#Q_OVERLAP} */
	@BitLength(1)
	@OrderIndex(14)
	public boolean Q_OVERLAP = ETCSVariables.Q_OVERLAP;

		/** {@link ETCSVariables#D_STARTOL} */
		@BitLength(15)
		@OrderIndex(15)
		@IfTrue("Q_OVERLAP")
		public int D_STARTOL     = ETCSVariables.D_STARTOL;

		/** {@link ETCSVariables#T_OL} */
		@BitLength(10)
		@OrderIndex(16)
		@IfTrue("Q_OVERLAP")
		public int T_OL          = ETCSVariables.T_OL;

		/** {@link ETCSVariables#D_OL} */
		@BitLength(15)
		@OrderIndex(17)
		@IfTrue("Q_OVERLAP")
		public int D_OL          = ETCSVariables.D_OL;

		/** {@link ETCSVariables#V_RELEASEOL} */
		@BitLength(7)
		@OrderIndex(18)
		@IfTrue("Q_OVERLAP")
		public int V_RELEASEOL   = ETCSVariables.V_RELEASEOL;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_15}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_15() {
		super(15);
	}

	/**
	 * Constructs A {@link Packet_15}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param V_LOA
	 *            {@link ETCSVariables#V_LOA}
	 * @param T_LOA
	 *            {@link ETCSVariables#T_LOA}
	 * @param endsection
	 *            {@link Packet_15_Section}
	 * @param Q_ENDTIMER
	 *            {@link ETCSVariables#Q_ENDTIMER}
	 * @param T_ENDTIMER
	 *            {@link ETCSVariables#T_ENDTIMER}
	 * @param D_ENDTIMERSTARTLOC
	 *            {@link ETCSVariables#D_ENDTIMERSTARTLOC}
	 * @param Q_DANGERPOINT
	 *            {@link ETCSVariables#Q_DANGERPOINT}
	 * @param D_DP
	 *            {@link ETCSVariables#D_DP}
	 * @param V_RELEASEDP
	 *            {@link ETCSVariables#V_RELEASEDP}
	 * @param Q_OVERLAP
	 *            {@link ETCSVariables#Q_OVERLAP}
	 * @param D_STARTOL
	 *            {@link ETCSVariables#D_STARTOL}
	 * @param T_OL
	 *            {@link ETCSVariables#T_OL}
	 * @param D_OL
	 *            {@link ETCSVariables#D_OL}
	 * @param V_RELEASEOL
	 *            {@link ETCSVariables#V_RELEASEOL}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_15(int Q_DIR, int Q_SCALE, int V_LOA, int T_LOA,
	                 Packet_15_Section endsection,
	                 boolean Q_ENDTIMER, int T_ENDTIMER, int D_ENDTIMERSTARTLOC,
	                 boolean Q_DANGERPOINT, int D_DP, int V_RELEASEDP,
	                 boolean Q_OVERLAP, int D_STARTOL, int T_OL, int D_OL, int V_RELEASEOL) {
		super(15, Q_DIR, Q_SCALE);
		this.V_LOA              = V_LOA;
		this.T_LOA              = T_LOA;
		this.endsection         = endsection;
		this.Q_ENDTIMER         = Q_ENDTIMER;
		this.T_ENDTIMER         = T_ENDTIMER;
		this.D_ENDTIMERSTARTLOC = D_ENDTIMERSTARTLOC;
		this.Q_DANGERPOINT      = Q_DANGERPOINT;
		this.D_DP               = D_DP;
		this.V_RELEASEDP        = V_RELEASEDP;
		this.Q_OVERLAP          = Q_OVERLAP;
		this.D_STARTOL          = D_STARTOL;
		this.T_OL               = T_OL;
		this.D_OL               = D_OL;
		this.V_RELEASEOL        = V_RELEASEOL;
	}


}
