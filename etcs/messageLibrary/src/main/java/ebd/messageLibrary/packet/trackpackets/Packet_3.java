package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;


/**
 * ID: 3 <br>
 * Type: Track To Train <br>
 * Description: National Values <br>
 * Transmitted By: Balise, RBC <br>
 * Subclasses: Area, KV_Speed_Step, Integrated_Correction_Factor, KR_Length_Step <br>
 * Elements: area, speed_step, integrated_correction_factor, length_step <br>
 * Lists: areas, speed_steps, integrated_correction_factors, length_steps
 *
 * @author Christopher Bernjus
 */
@OrderLength(41)
public class Packet_3 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated National Areas */
	@OrderLength(1)
	public static class Packet_3_Area {

		/** {@link ETCSVariables#NID_C} */
		@BitLength(10)
		@OrderIndex(0)
		public int NID_C = ETCSVariables.NID_C;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_3_Area}
		 *
		 * @author Christopher Bernjus
		 */
		Packet_3_Area() {}

		/**
		 * Constructs An Empty {@link Packet_3_Area}
		 *
		 * @param NID_C
		 *            {@link ETCSVariables#NID_C}
		 *
		 * @author Christopher Bernjus
		 */
		Packet_3_Area(int NID_C) {
			this.NID_C = NID_C;
		}

	}

	/**
	 * Subclass For Handling Iterated Speed Steps of the Kv Factor <br>
	 * Naming: M_NVKVINT12 with relation to A_NVP12 (instead of M_NVKVINT) <br>
	 * Naming: M_NVKVINT23 with relation to A_NVP23 (instead of M_NVKVINT)
	 */
	@OrderLength(3)
	public static class Packet_3_KV_Speed_Step {

		/** {@link ETCSVariables#V_NVKVINT} */
		@BitLength(7)
		@OrderIndex(0)
		public int V_NVKVINT = ETCSVariables.V_NVKVINT;

		/** {@link ETCSVariables#M_NVKVINT} <br>
		 * Correction Factor if max. Emergency Brake Deceleration is lower than A_NVP12 */
		@BitLength(7)
		@OrderIndex(1)
		public int M_NVKVINT12 = ETCSVariables.M_NVKVINT;

			/** {@link ETCSVariables#M_NVKVINT} <br>
			 * Correction Factor if max. Emergency Brake Deceleration is higher than A_NVP23 */
			@BitLength(7)
			@OrderIndex(2)
			public int M_NVKVINT23 = ETCSVariables.M_NVKVINT;


		// Constructors

		public Packet_3_KV_Speed_Step() { }

		public Packet_3_KV_Speed_Step(int V_NVKVINT, int M_NVKVINT12, int M_NVKVINT23) {
			this.V_NVKVINT   = V_NVKVINT;
			this.M_NVKVINT12 = M_NVKVINT12;
			this.M_NVKVINT23 = M_NVKVINT23;
		}
	}

	/**
	 * Subclass For Handling Iterated Integrated Correction Factors <br>
	 * Elements: speed_step <br>
	 * Lists: speed_steps
	 */
	@OrderLength(5)
	public static class Packet_3_Integrated_Correction_Factor {

		/** {@link ETCSVariables#Q_NVKVINTSET} */
		@BitLength(2)
		@OrderIndex(0)
		public int Q_NVKVINTSET = ETCSVariables.Q_NVKVINTSET;

			/** {@link ETCSVariables#A_NVP12} */
			@IfEqual(field = "Q_NVKVINTSET", value = 1)
			@BitLength(6)
			@OrderIndex(1)
			public int A_NVP12 = ETCSVariables.A_NVP12;

			/** {@link ETCSVariables#A_NVP23} */
			@IfEqual(field = "Q_NVKVINTSET", value = 1)
			@BitLength(6)
			@OrderIndex(2)
			public int A_NVP23 = ETCSVariables.A_NVP23;


		/** First {@link Packet_3_KV_Speed_Step}*/
		@OrderIndex(3)
		public Packet_3_KV_Speed_Step speed_step = new Packet_3_KV_Speed_Step();

		/** List Of {@link Packet_3_KV_Speed_Step}s */
		@OrderIndex(4)
		@ItemType(Packet_3_KV_Speed_Step.class)
		public List<Packet_3_KV_Speed_Step> speed_steps = new ArrayList<>();


		// Constructors

		public Packet_3_Integrated_Correction_Factor() {
		}

		public Packet_3_Integrated_Correction_Factor(int Q_NVKVINTSET, int A_NVP12, int A_NVP23, Packet_3_KV_Speed_Step speed_step) {
			this.Q_NVKVINTSET = Q_NVKVINTSET;
			this.A_NVP12 = A_NVP12;
			this.A_NVP23 = A_NVP23;
			this.speed_step = speed_step;
		}
	}

	/** Subclass For Handling Iterated Length Steps of the Kr Factor */
	@OrderLength(2)
	public static class Packet_3_KR_Length_Step {

		/** {@link ETCSVariables#L_NVKRINT} */
		@BitLength(5)
		@OrderIndex(0)
		public int L_NVKRINT = ETCSVariables.L_NVKRINT;

		/** {@link ETCSVariables#M_NVKRINT} */
		@BitLength(5)
		@OrderIndex(1)
		public int M_NVKRINT = ETCSVariables.M_NVKRINT;


		// Constructors

		public Packet_3_KR_Length_Step() {
		}

		public Packet_3_KR_Length_Step(int L_NVKRINT, int M_NVKRINT) {
			this.L_NVKRINT = L_NVKRINT;
			this.M_NVKRINT = M_NVKRINT;
		}
	}


	// ---------------
	// National Values
	// ---------------

	/** {@link ETCSVariables#D_VALIDNV} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_VALIDNV = ETCSVariables.D_VALIDNV;

	/** First {@link @Packet_3_Area} */
	@OrderIndex(5)
	public Packet_3_Area area = new Packet_3_Area();

	/** List of {@link Packet_3_Area}s */
	@OrderIndex(6)
	@ItemType(Packet_3_Area.class)
	public List<Packet_3_Area> areas = new ArrayList<>();

	/** {@link ETCSVariables#V_NVSHUNT} */
	@BitLength(7)
	@OrderIndex(7)
	public int V_NVSHUNT = ETCSVariables.V_NVSHUNT;

	/** {@link ETCSVariables#V_NVSTFF} */
	@BitLength(7)
	@OrderIndex(8)
	public int V_NVSTFF = ETCSVariables.V_NVSTFF;

	/** {@link ETCSVariables#V_NVONSIGHT} */
	@BitLength(7)
	@OrderIndex(9)
	public int V_NVONSIGHT = ETCSVariables.V_NVONSIGHT;

	/** {@link ETCSVariables#V_NVLIMSUPERV} */
	@BitLength(7)
	@OrderIndex(10)
	public int V_NVLIMSUPERV = ETCSVariables.V_NVLIMSUPERV;

	/** {@link ETCSVariables#V_NVUNFIT} */
	@BitLength(7)
	@OrderIndex(11)
	public int V_NVUNFIT = ETCSVariables.V_NVUNFIT;

	/** {@link ETCSVariables#V_NVREL} */
	@BitLength(7)
	@OrderIndex(12)
	public int V_NVREL = ETCSVariables.V_NVREL;

	/** {@link ETCSVariables#D_NVROLL} */
	@BitLength(15)
	@OrderIndex(13)
	public int D_NVROLL = ETCSVariables.D_NVROLL;

	/** {@link ETCSVariables#Q_NVSBTSMPERM} */
	@BitLength(1)
	@OrderIndex(14)
	public boolean Q_NVSBTSMPERM = ETCSVariables.Q_NVSBTSMPERM;

	/** {@link ETCSVariables#Q_NVEMRRLS} */
	@BitLength(1)
	@OrderIndex(15)
	public boolean Q_NVEMRRLS = ETCSVariables.Q_NVEMRRLS;

	/** {@link ETCSVariables#Q_NVGUIPERM} */
	@BitLength(1)
	@OrderIndex(16)
	public boolean Q_NVGUIPERM = ETCSVariables.Q_NVGUIPERM;

	/** {@link ETCSVariables#Q_NVSBFBPERM} */
	@BitLength(1)
	@OrderIndex(17)
	public boolean Q_NVSBFBPERM = ETCSVariables.Q_NVSBFBPERM;

	/** {@link ETCSVariables#Q_NVINHSMICPERM} */
	@BitLength(1)
	@OrderIndex(18)
	public boolean Q_NVINHSMICPERM = ETCSVariables.Q_NVINHSMICPERM;

	/** {@link ETCSVariables#V_NVALLOWOVTRP} */
	@BitLength(7)
	@OrderIndex(19)
	public int V_NVALLOWOVTRP = ETCSVariables.V_NVALLOWOVTRP;

	/** {@link ETCSVariables#V_NVSUPOVTRP} */
	@BitLength(7)
	@OrderIndex(20)
	public int V_NVSUPOVTRP = ETCSVariables.V_NVSUPOVTRP;

	/** {@link ETCSVariables#D_NVOVTRP} */
	@BitLength(15)
	@OrderIndex(21)
	public int D_NVOVTRP = ETCSVariables.D_NVOVTRP;

	/** {@link ETCSVariables#T_NVOVTRP} */
	@BitLength(8)
	@OrderIndex(22)
	public int T_NVOVTRP = ETCSVariables.T_NVOVTRP;

	/** {@link ETCSVariables#D_NVPOTRP} */
	@BitLength(15)
	@OrderIndex(23)
	public int D_NVPOTRP = ETCSVariables.D_NVPOTRP;

	/** {@link ETCSVariables#M_NVCONTACT} */
	@BitLength(2)
	@OrderIndex(24)
	public int M_NVCONTACT = ETCSVariables.M_NVCONTACT;

	/** {@link ETCSVariables#T_NVCONTACT} */
	@BitLength(8)
	@OrderIndex(25)
	public int T_NVCONTACT = ETCSVariables.T_NVCONTACT;

	/** {@link ETCSVariables#M_NVDERUN} */
	@BitLength(1)
	@OrderIndex(26)
	public boolean M_NVDERUN = ETCSVariables.M_NVDERUN;

	/** {@link ETCSVariables#D_NVSTFF} */
	@BitLength(15)
	@OrderIndex(27)
	public int D_NVSTFF = ETCSVariables.D_NVSTFF;

	/** {@link ETCSVariables#Q_NVDRIVER_ADHES} */
	@BitLength(1)
	@OrderIndex(28)
	public boolean Q_NVDRIVER_ADHES = ETCSVariables.Q_NVDRIVER_ADHES;

	/** {@link ETCSVariables#A_NVMAXREDADH1} */
	@BitLength(6)
	@OrderIndex(29)
	public int A_NVMAXREDADH1 = ETCSVariables.A_NVMAXREDADH1;

	/** {@link ETCSVariables#A_NVMAXREDADH2} */
	@BitLength(6)
	@OrderIndex(30)
	public int A_NVMAXREDADH2 = ETCSVariables.A_NVMAXREDADH2;

	/** {@link ETCSVariables#A_NVMAXREDADH3} */
	@BitLength(6)
	@OrderIndex(31)
	public int A_NVMAXREDADH3 = ETCSVariables.A_NVMAXREDADH3;

	/** {@link ETCSVariables#Q_NVLOCACC} */
	@BitLength(6)
	@OrderIndex(32)
	public int Q_NVLOCACC = ETCSVariables.Q_NVLOCACC;

	/** {@link ETCSVariables#M_NVAVADH} */
	@BitLength(5)
	@OrderIndex(33)
	public int M_NVAVADH = ETCSVariables.M_NVAVADH;

	/** {@link ETCSVariables#M_NVEBCL} */
	@BitLength(4)
	@OrderIndex(34)
	public int M_NVEBCL = ETCSVariables.M_NVEBCL;

	/** {@link ETCSVariables#Q_NVKINT} */
	@BitLength(1)
	@OrderIndex(35)
	public boolean Q_NVKINT = ETCSVariables.Q_NVKINT;

		/** First {@link Packet_3_Integrated_Correction_Factor} */
		@OrderIndex(36)
		@IfTrue("Q_NVKINT")
		public Packet_3_Integrated_Correction_Factor integrated_correction_factor = new Packet_3_Integrated_Correction_Factor();

		/** List Of {@link Packet_3_Integrated_Correction_Factor}s */
		@OrderIndex(37)
		@ItemType(Packet_3_Integrated_Correction_Factor.class)
		@IfTrue("Q_NVKINT")
		public List<Packet_3_Integrated_Correction_Factor> integrated_correction_factors = new ArrayList<>();

		/** First {@link Packet_3_KR_Length_Step} */
		@OrderIndex(38)
		@IfTrue("Q_NVKINT")
		public Packet_3_KR_Length_Step length_step = new Packet_3_KR_Length_Step();

		/** List Of {@link Packet_3_KR_Length_Step}s */
		@OrderIndex(39)
		@ItemType(Packet_3_KR_Length_Step.class)
		@IfTrue("Q_NVKINT")
		public List<Packet_3_KR_Length_Step> length_steps = new ArrayList<>();

		/** {@link ETCSVariables#M_NVKTINT} */
		@IfTrue("Q_NVKINT")
		@BitLength(5)
		@OrderIndex(40)
		public int M_NVKTINT = ETCSVariables.M_NVKTINT;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_3}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_3() {
		super(3);
	}

	/**
	 * Constructs A {@link Packet_3} without Integrated Correction Factors
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_VALIDNV
	 *            {@link ETCSVariables#D_VALIDNV}
	 * @param area
	 *            {@link Packet_3_Area}
	 * @param V_NVSHUNT
	 *            {@link ETCSVariables#V_NVSHUNT}
	 * @param V_NVSTFF
	 *            {@link ETCSVariables#V_NVSTFF}
	 * @param V_NVONSIGHT
	 *            {@link ETCSVariables#V_NVONSIGHT}
	 * @param V_NVLIMSUPERV
	 *            {@link ETCSVariables#V_NVLIMSUPERV}
	 * @param V_NVUNFIT
	 *            {@link ETCSVariables#V_NVUNFIT}
	 * @param V_NVREL
	 *            {@link ETCSVariables#V_NVREL}
	 * @param D_NVROLL
	 *            {@link ETCSVariables#D_NVROLL}
	 * @param Q_NVSBTSMPERM
	 *            {@link ETCSVariables#Q_NVSBFBPERM}
	 * @param Q_NVEMRRLS
	 *            {@link ETCSVariables#Q_NVEMRRLS}
	 * @param Q_NVGUIPERM
	 *            {@link ETCSVariables#Q_NVGUIPERM}
	 * @param Q_NVSBFBPERM
	 *            {@link ETCSVariables#Q_NVSBFBPERM}
	 * @param Q_NVINHSMICPERM
	 *            {@link ETCSVariables#Q_NVINHSMICPERM}
	 * @param V_NVALLOWOVTRP
	 *            {@link ETCSVariables#V_NVALLOWOVTRP}
	 * @param V_NVSUPOVTRP
	 *            {@link ETCSVariables#V_NVSUPOVTRP}
	 * @param D_NVOVTRP
	 *            {@link ETCSVariables#D_NVOVTRP}
	 * @param T_NVOVTRP
	 *            {@link ETCSVariables#T_NVOVTRP}
	 * @param D_NVPOTRP
	 *            {@link ETCSVariables#D_NVOVTRP}
	 * @param M_NVCONTACT
	 *            {@link ETCSVariables#M_NVCONTACT}
	 * @param T_NVCONTACT
	 *            {@link ETCSVariables#T_NVCONTACT}
	 * @param M_NVDERUN
	 *            {@link ETCSVariables#M_NVDERUN}
	 * @param D_NVSTFF
	 *            {@link ETCSVariables#D_NVSTFF}
	 * @param Q_NVDRIVER_ADHES
	 *            {@link ETCSVariables#Q_NVDRIVER_ADHES}
	 * @param A_NVMAXREDADH1
	 *            {@link ETCSVariables#A_NVMAXREDADH1}
	 * @param A_NVMAXREDADH2
	 *            {@link ETCSVariables#A_NVMAXREDADH2}
	 * @param A_NVMAXREDADH3
	 *            {@link ETCSVariables#A_NVMAXREDADH3}
	 * @param Q_NVLOCACC
	 *            {@link ETCSVariables#Q_NVLOCACC}
	 * @param M_NVAVADH
	 *            {@link ETCSVariables#M_NVAVADH}
	 * @param M_NVEBCL
	 *            {@link ETCSVariables#M_NVEBCL}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_3(int Q_DIR, int Q_SCALE,
	                int D_VALIDNV, Packet_3_Area area, int V_NVSHUNT, int V_NVSTFF, int V_NVONSIGHT, int V_NVLIMSUPERV, int V_NVUNFIT, int V_NVREL,
	                int D_NVROLL, boolean Q_NVSBTSMPERM, boolean Q_NVEMRRLS, boolean Q_NVGUIPERM, boolean Q_NVSBFBPERM, boolean Q_NVINHSMICPERM,
	                int V_NVALLOWOVTRP, int V_NVSUPOVTRP, int D_NVOVTRP, int T_NVOVTRP, int D_NVPOTRP, int M_NVCONTACT, int T_NVCONTACT, boolean M_NVDERUN,
	                int D_NVSTFF, boolean Q_NVDRIVER_ADHES, int A_NVMAXREDADH1, int A_NVMAXREDADH2, int A_NVMAXREDADH3, int Q_NVLOCACC, int M_NVAVADH, int M_NVEBCL) {
		super(3, Q_DIR, Q_SCALE);
		this.D_VALIDNV = D_VALIDNV;
		this.area = area;
		this.V_NVSHUNT = V_NVSHUNT;
		this.V_NVSTFF = V_NVSTFF;
		this.V_NVONSIGHT = V_NVONSIGHT;
		this.V_NVLIMSUPERV = V_NVLIMSUPERV;
		this.V_NVUNFIT = V_NVUNFIT;
		this.V_NVREL = V_NVREL;
		this.D_NVROLL = D_NVROLL;
		this.Q_NVSBTSMPERM = Q_NVSBTSMPERM;
		this.Q_NVEMRRLS = Q_NVEMRRLS;
		this.Q_NVGUIPERM = Q_NVGUIPERM;
		this.Q_NVSBFBPERM = Q_NVSBFBPERM;
		this.Q_NVINHSMICPERM = Q_NVINHSMICPERM;
		this.V_NVALLOWOVTRP = V_NVALLOWOVTRP;
		this.V_NVSUPOVTRP = V_NVSUPOVTRP;
		this.D_NVOVTRP = D_NVOVTRP;
		this.T_NVOVTRP = T_NVOVTRP;
		this.D_NVPOTRP = D_NVPOTRP;
		this.M_NVCONTACT = M_NVCONTACT;
		this.T_NVCONTACT = T_NVCONTACT;
		this.M_NVDERUN = M_NVDERUN;
		this.D_NVSTFF = D_NVSTFF;
		this.Q_NVDRIVER_ADHES = Q_NVDRIVER_ADHES;
		this.A_NVMAXREDADH1 = A_NVMAXREDADH1;
		this.A_NVMAXREDADH2 = A_NVMAXREDADH2;
		this.A_NVMAXREDADH3 = A_NVMAXREDADH3;
		this.Q_NVLOCACC = Q_NVLOCACC;
		this.M_NVAVADH = M_NVAVADH;
		this.M_NVEBCL = M_NVEBCL;
		this.Q_NVKINT = false;
	}

	/**
	 * Constructs A {@link Packet_3} with Integrated Correction Factors
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_VALIDNV
	 *            {@link ETCSVariables#D_VALIDNV}
	 * @param area
	 *            {@link Packet_3_Area}
	 * @param V_NVSHUNT
	 *            {@link ETCSVariables#V_NVSHUNT}
	 * @param V_NVSTFF
	 *            {@link ETCSVariables#V_NVSTFF}
	 * @param V_NVONSIGHT
	 *            {@link ETCSVariables#V_NVONSIGHT}
	 * @param V_NVLIMSUPERV
	 *            {@link ETCSVariables#V_NVLIMSUPERV}
	 * @param V_NVUNFIT
	 *            {@link ETCSVariables#V_NVUNFIT}
	 * @param V_NVREL
	 *            {@link ETCSVariables#V_NVREL}
	 * @param D_NVROLL
	 *            {@link ETCSVariables#D_NVROLL}
	 * @param Q_NVSBTSMPERM
	 *            {@link ETCSVariables#Q_NVSBFBPERM}
	 * @param Q_NVEMRRLS
	 *            {@link ETCSVariables#Q_NVEMRRLS}
	 * @param Q_NVGUIPERM
	 *            {@link ETCSVariables#Q_NVGUIPERM}
	 * @param Q_NVSBFBPERM
	 *            {@link ETCSVariables#Q_NVSBFBPERM}
	 * @param Q_NVINHSMICPERM
	 *            {@link ETCSVariables#Q_NVINHSMICPERM}
	 * @param V_NVALLOWOVTRP
	 *            {@link ETCSVariables#V_NVALLOWOVTRP}
	 * @param V_NVSUPOVTRP
	 *            {@link ETCSVariables#V_NVSUPOVTRP}
	 * @param D_NVOVTRP
	 *            {@link ETCSVariables#D_NVOVTRP}
	 * @param T_NVOVTRP
	 *            {@link ETCSVariables#T_NVOVTRP}
	 * @param D_NVPOTRP
	 *            {@link ETCSVariables#D_NVOVTRP}
	 * @param M_NVCONTACT
	 *            {@link ETCSVariables#M_NVCONTACT}
	 * @param T_NVCONTACT
	 *            {@link ETCSVariables#T_NVCONTACT}
	 * @param M_NVDERUN
	 *            {@link ETCSVariables#M_NVDERUN}
	 * @param D_NVSTFF
	 *            {@link ETCSVariables#D_NVSTFF}
	 * @param Q_NVDRIVER_ADHES
	 *            {@link ETCSVariables#Q_NVDRIVER_ADHES}
	 * @param A_NVMAXREDADH1
	 *            {@link ETCSVariables#A_NVMAXREDADH1}
	 * @param A_NVMAXREDADH2
	 *            {@link ETCSVariables#A_NVMAXREDADH2}
	 * @param A_NVMAXREDADH3
	 *            {@link ETCSVariables#A_NVMAXREDADH3}
	 * @param Q_NVLOCACC
	 *            {@link ETCSVariables#Q_NVLOCACC}
	 * @param M_NVAVADH
	 *            {@link ETCSVariables#M_NVAVADH}
	 * @param M_NVEBCL
	 *            {@link ETCSVariables#M_NVEBCL}
	 * @param integrated_correction_factor
	 *            {@link Packet_3_Integrated_Correction_Factor}
	 * @param length_step
	 *            {@link Packet_3_KR_Length_Step}
	 * @param M_NVKTINT
	 *            {@link ETCSVariables#M_NVKTINT}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_3(int Q_DIR, int Q_SCALE,
	                int D_VALIDNV, Packet_3_Area area, int V_NVSHUNT, int V_NVSTFF, int V_NVONSIGHT, int V_NVLIMSUPERV, int V_NVUNFIT, int V_NVREL,
	                int D_NVROLL, boolean Q_NVSBTSMPERM, boolean Q_NVEMRRLS, boolean Q_NVGUIPERM, boolean Q_NVSBFBPERM, boolean Q_NVINHSMICPERM,
	                int V_NVALLOWOVTRP, int V_NVSUPOVTRP, int D_NVOVTRP, int T_NVOVTRP, int D_NVPOTRP, int M_NVCONTACT, int T_NVCONTACT, boolean M_NVDERUN,
	                int D_NVSTFF, boolean Q_NVDRIVER_ADHES, int A_NVMAXREDADH1, int A_NVMAXREDADH2, int A_NVMAXREDADH3, int Q_NVLOCACC, int M_NVAVADH, int M_NVEBCL,
	                Packet_3_Integrated_Correction_Factor integrated_correction_factor, Packet_3_KR_Length_Step length_step, int M_NVKTINT) {
		super(3, Q_DIR, Q_SCALE);
		this.D_VALIDNV = D_VALIDNV;
		this.area = area;
		this.V_NVSHUNT = V_NVSHUNT;
		this.V_NVSTFF = V_NVSTFF;
		this.V_NVONSIGHT = V_NVONSIGHT;
		this.V_NVLIMSUPERV = V_NVLIMSUPERV;
		this.V_NVUNFIT = V_NVUNFIT;
		this.V_NVREL = V_NVREL;
		this.D_NVROLL = D_NVROLL;
		this.Q_NVSBTSMPERM = Q_NVSBTSMPERM;
		this.Q_NVEMRRLS = Q_NVEMRRLS;
		this.Q_NVGUIPERM = Q_NVGUIPERM;
		this.Q_NVSBFBPERM = Q_NVSBFBPERM;
		this.Q_NVINHSMICPERM = Q_NVINHSMICPERM;
		this.V_NVALLOWOVTRP = V_NVALLOWOVTRP;
		this.V_NVSUPOVTRP = V_NVSUPOVTRP;
		this.D_NVOVTRP = D_NVOVTRP;
		this.T_NVOVTRP = T_NVOVTRP;
		this.D_NVPOTRP = D_NVPOTRP;
		this.M_NVCONTACT = M_NVCONTACT;
		this.T_NVCONTACT = T_NVCONTACT;
		this.M_NVDERUN = M_NVDERUN;
		this.D_NVSTFF = D_NVSTFF;
		this.Q_NVDRIVER_ADHES = Q_NVDRIVER_ADHES;
		this.A_NVMAXREDADH1 = A_NVMAXREDADH1;
		this.A_NVMAXREDADH2 = A_NVMAXREDADH2;
		this.A_NVMAXREDADH3 = A_NVMAXREDADH3;
		this.Q_NVLOCACC = Q_NVLOCACC;
		this.M_NVAVADH = M_NVAVADH;
		this.M_NVEBCL = M_NVEBCL;
		this.Q_NVKINT = true;
		this.integrated_correction_factor = integrated_correction_factor;
		this.length_step = length_step;
		this.M_NVKTINT = M_NVKTINT;
	}
}
