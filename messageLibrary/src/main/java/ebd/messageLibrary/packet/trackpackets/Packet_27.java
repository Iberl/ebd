package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static ebd.messageLibrary.util.ETCSVariables.*;


/**
 * ID: 27 <br>
 * Type: Track To Train <br>
 * Description: International Static Speed Profile <br>
 * Transmitted By: Any <br>
 * Subclasses: Section, Category <br>
 * Elements: section <br>
 * Lists: sections
 *
 * @author Christopher Bernjus
 */
public class Packet_27 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Profile Categories */
	public static class Packet_27_Category {

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
		 * Constructs An Empty {@link Packet_27_Category}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_27_Category() {}

		/**
		 * Constructs A {@link Packet_27_Category}
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
		public Packet_27_Category(int Q_DIFF, int NC_CDDIFF, int NC_DIFF, int V_DIFF) {
			this.Q_DIFF    = Q_DIFF;
			this.NC_CDDIFF = NC_CDDIFF;
			this.NC_DIFF   = NC_DIFF;
			this.V_DIFF    = V_DIFF;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_27_Category that = (Packet_27_Category) object;
			return Q_DIFF == that.Q_DIFF && NC_CDDIFF == that.NC_CDDIFF && NC_DIFF == that.NC_DIFF && V_DIFF == that.V_DIFF;
		}

		@Override
		public String toString() {
			return "Packet_27_StaticSpeedProfileSection{"
				   + "Q_DIFF=" + Q_DIFF + ", NC_CDDIFF=" + NC_CDDIFF
				   + ", NC_DIFF=" + NC_DIFF + ", V_DIFF=" + V_DIFF
				   + '}';
		}

	}

	/**
	 * Subclass For Handling Iterated Sections <br>
	 * Lists: categories
	 *
	 * @author Christopher Bernjus
	 */
	public static class Packet_27_Section {

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

		/** List Of {@link Packet_27_Category}s */
		@OrderIndex(3)
		@ItemType(Packet_27_Category.class)
		public List<Packet_27_Category> categories = new ArrayList<>();


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_27_Section}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_27_Section() {}

		/**
		 * Constructs A {@link Packet_27_Section}
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
		public Packet_27_Section(int D_STATIC, int V_STATIC, boolean Q_FRONT) {
			this.D_STATIC = D_STATIC;
			this.V_STATIC = V_STATIC;
			this.Q_FRONT  = Q_FRONT;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_27_Section that = (Packet_27_Section) object;
			return D_STATIC == that.D_STATIC && V_STATIC == that.V_STATIC && Q_FRONT == that.Q_FRONT && categories.equals(that.categories);
		}

		@Override
		public String toString() {
			return "Packet_27_StaticSpeedProfile{"
				   + "D_STATIC=" + D_STATIC + ", V_STATIC=" + V_STATIC + ", Q_FRONT=" + Q_FRONT
				   + ", sections=" + categories.toString()
				   + '}';
		}

	}


	// ----------------------------------
	// International Static Speed Profile
	// ----------------------------------

	/** First {@link Packet_27_Section} */
	@OrderIndex(4)
	public Packet_27_Section section = new Packet_27_Section();      // First Speed Profile

	/** List Of {@link Packet_27_Section}s */
	@OrderIndex(5)
	@ItemType(Packet_27_Section.class)
	public List<Packet_27_Section> sections = new ArrayList<>();        // List of Additional Speed Profiles


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
	 * @param section
	 *            {@link Packet_27_Section}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_27(int Q_DIR, int Q_SCALE, Packet_27_Section section) {
		super(27, Q_DIR, Q_SCALE);
		this.section = section;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_27 packet_27 = (Packet_27) object;
		return Objects.equals(section, packet_27.section) && sections.equals(packet_27.sections);
	}

	@Override
	public String toString() {
		return "Packet_27{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", speedProfile=" + section.toString()
			   + ", speedProfiles=" + sections.toString()
			   + '}';
	}

}
