package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.*;

import java.util.ArrayList;
import java.util.List;

import static ebd.messageLibrary.util.ETCSVariables.Q_DIFF_CANT_DEFICIENCY;
import static ebd.messageLibrary.util.ETCSVariables.Q_DIFF_OTHER_SPECIFIC_CATEGORY;
import static ebd.messageLibrary.util.ETCSVariables.Q_DIFF_REPLACING_CANT_DEFICIENCY;


/**
 * ID: 27 <br>
 * Type: Track To Train <br>
 * Description: International Static Speed Profile <br>
 * Transmitted By: Any <br>
 * Subclasses: StaticSpeedProfile, StaticSpeedProfileSection <br>
 * Elements: speedProfile <br>
 * Lists: speedProfiles
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Packet_27 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Profile Sections */
	@OrderLength(4)
	public class Packet_27_StaticSpeedProfileSection {

		/** {@link ETCSVariables#Q_DIFF} */
		@BitLength(2)
		@OrderIndex(0)
		public int Q_DIFF    = ETCSVariables.Q_DIFF;

			/** {@link ETCSVariables#NC_CDDIFF} */
			@BitLength(4)
			@OrderIndex(1)
			@IfEqual(field = "Q_DIFF", value = Q_DIFF_CANT_DEFICIENCY)
			public int NC_CDDIFF = ETCSVariables.NC_CDDIFF;

			/** {@link ETCSVariables#NC_DIFF} */
			@BitLength(4)
			@OrderIndex(2)
			@IfOneOf(field = "Q_DIFF", values = {Q_DIFF_REPLACING_CANT_DEFICIENCY, Q_DIFF_OTHER_SPECIFIC_CATEGORY})
			public int NC_DIFF   = ETCSVariables.NC_DIFF;

		/** {@link ETCSVariables#V_DIFF} */
		@BitLength(7)
		@OrderIndex(3)
		public int V_DIFF    = ETCSVariables.V_DIFF;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_27_StaticSpeedProfileSection}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_27_StaticSpeedProfileSection() {}

		/**
		 * Constructs A {@link Packet_27_StaticSpeedProfileSection}
		 *
		 * @param Q_DIFF
		 *            {@link ETCSVariables#Q_DIFF}
		 * @param NC_CDDIFF
		 *            {@link ETCSVariables#NC_CDDIFF}
		 * @param NC_DIFF
		 *            {@link ETCSVariables#NC_DIFF}
		 * @param V_DIFF
		 *            {@link ETCSVariables#V_DIFF}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_27_StaticSpeedProfileSection(int Q_DIFF, int NC_CDDIFF, int NC_DIFF, int V_DIFF) {
			this.Q_DIFF    = Q_DIFF;
			this.NC_CDDIFF = NC_CDDIFF;
			this.NC_DIFF   = NC_DIFF;
			this.V_DIFF    = V_DIFF;
		}

	}

	/**
	 * Subclass For Handling Iterated SpeedProfiles <br>
	 * Lists: sections
	 */
	@OrderLength(4)
	public class Packet_27_StaticSpeedProfile {

		/** {@link ETCSVariables#D_STATIC} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_STATIC    = ETCSVariables.D_STATIC;

		/** {@link ETCSVariables#V_STATIC} */
		@BitLength(7)
		@OrderIndex(1)
		public int V_STATIC    = ETCSVariables.V_STATIC;

		/** {@link ETCSVariables#Q_FRONT} */
		@BitLength(1)
		@OrderIndex(2)
		public boolean Q_FRONT = ETCSVariables.Q_FRONT;

		/** List Of {@link Packet_27_StaticSpeedProfileSection}s */
		@OrderIndex(3)
		@ItemType(Packet_27_StaticSpeedProfileSection.class)
		public List<Packet_27_StaticSpeedProfileSection> sections = new ArrayList<>();      // List of Speed Profile Sections

		// Constructors

		/**
		 * Constructs An Empty {@link Packet_27_StaticSpeedProfile}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_27_StaticSpeedProfile() {}

		/**
		 * Constructs A {@link Packet_27_StaticSpeedProfile}
		 *
		 * @param D_STATIC
		 *            {@link ETCSVariables#D_STATIC}
		 * @param V_STATIC
		 *            {@link ETCSVariables#V_STATIC}
		 * @param Q_FRONT
		 *            {@link ETCSVariables#Q_FRONT}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_27_StaticSpeedProfile(int D_STATIC, int V_STATIC, boolean Q_FRONT) {
			this.D_STATIC = D_STATIC;
			this.V_STATIC = V_STATIC;
			this.Q_FRONT  = Q_FRONT;
		}

	}


	// ----------------------------------
	// International Static Speed Profile
	// ----------------------------------

	/** First {@link Packet_27_StaticSpeedProfile} */
	@OrderIndex(4)
	public Packet_27_StaticSpeedProfile speedProfile = new Packet_27_StaticSpeedProfile();      // First Speed Profile

	/** List Of {@link Packet_27_StaticSpeedProfile}s */
	@OrderIndex(5)
	@ItemType(Packet_27_StaticSpeedProfile.class)
	public List<Packet_27_StaticSpeedProfile> speedProfiles = new ArrayList<>();        // List of Additional Speed Profiles


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_27}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_27() {
		super(27);
	}

	/**
	 * Constructs A {@link Packet_27}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param speedProfile
	 *            {@link Packet_27_StaticSpeedProfile}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_27(int Q_DIR, int Q_SCALE, Packet_27_StaticSpeedProfile speedProfile) {
		super(27, Q_DIR, Q_SCALE);
		this.speedProfile = speedProfile;
	}

}
