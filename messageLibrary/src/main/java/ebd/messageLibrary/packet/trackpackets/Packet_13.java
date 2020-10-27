package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfTrue;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ID: 13 <br>
 * Type: Track To Train <br>
 * Description: Staff Responsible Distance Information From Loop <br>
 * Transmitted By: Loop <br>
 * Subclasses: Section <br>
 * Elements: section <br>
 * Lists: sections
 *
 * @author Christopher Bernjus
 */
public class Packet_13 extends TrackPacketSCALE {

	/** Subclass For Handling iterated Subsections */
	public static class Packet_13_Section {

		/** {@link ETCSVariables#Q_NEWCOUNTRY} */
		@BitLength(1)
		@OrderIndex(0)
		public boolean Q_NEWCOUNTRY = ETCSVariables.Q_NEWCOUNTRY;

			/** {@link ETCSVariables#NID_C} */
			@BitLength(10)
			@OrderIndex(1)
			@IfTrue("Q_NEWCOUNTRY")
			public int NID_C = ETCSVariables.NID_C;

		/** {@link ETCSVariables#NID_BG} */
		@BitLength(14)
		@OrderIndex(2)
		public int NID_BG = ETCSVariables.NID_BG;

		/** {@link ETCSVariables#D_SR} */
		@BitLength(15)
		@OrderIndex(3)
		public int D_SR = ETCSVariables.D_SR;


		// Constructors


		/**
		 * Constructs An Empty {@link Packet_13_Section}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_13_Section() {}


		/**
		 * Constructs A {@link Packet_13_Section}
		 *
		 * @param Q_NEWCOUNTRY
		 *            {@link ETCSVariables#Q_NEWCOUNTRY}
		 * @param NID_C
		 *            {@link ETCSVariables#NID_C}
		 * @param NID_BG
		 *            {@link ETCSVariables#NID_BG}
		 * @param D_SR
		 *            {@link ETCSVariables#D_SR}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_13_Section(boolean Q_NEWCOUNTRY, int NID_C, int NID_BG, int D_SR) {
			this.Q_NEWCOUNTRY = Q_NEWCOUNTRY;
			this.NID_C = NID_C;
			this.NID_BG = NID_BG;
			this.D_SR = D_SR;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_13_Section that = (Packet_13_Section) object;
			return Q_NEWCOUNTRY == that.Q_NEWCOUNTRY && NID_C == that.NID_C && NID_BG == that.NID_BG && D_SR == that.D_SR;
		}

		@Override
		public String toString() {
			return "Packet_13_Section{"
				   + "Q_NEWCOUNTRY=" + Q_NEWCOUNTRY + ", NID_C=" + NID_C + ", NID_BG=" + NID_BG + ", D_SR=" + D_SR
				   + '}';
		}

	}

	// ------------------------------------------------
	// Staff Responsible Distance Information From Loop
	// ------------------------------------------------

	/** {@link ETCSVariables#Q_NEWCOUNTRY} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_NEWCOUNTRY = ETCSVariables.Q_NEWCOUNTRY;

		/** {@link ETCSVariables#NID_C} */
		@BitLength(10)
		@OrderIndex(5)
		@IfTrue("Q_NEWCOUNTRY")
		public int NID_C = ETCSVariables.NID_C;

	/** {@link ETCSVariables#NID_BG} */
	@BitLength(14)
	@OrderIndex(6)
	public int NID_BG = ETCSVariables.NID_BG;

	/** First {@link Packet_13_Section} */
	@OrderIndex(7)
	public Packet_13_Section section = new Packet_13_Section();

	/** Additional {@link Packet_13_Section}s */
	@OrderIndex(8)
	@ItemType(Packet_13_Section.class)
	public List<Packet_13_Section> sections = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_13}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_13() {
		super(13);
	}

	/**
	 * Constructs A {@link Packet_13}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param Q_NEWCOUNTRY
	 *            {@link ETCSVariables#Q_NEWCOUNTRY}
	 * @param NID_C
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_BG
	 *            {@link ETCSVariables#NID_BG}
	 * @param section
	 *            {@link Packet_13_Section}
	 */
	public Packet_13(int Q_DIR, int Q_SCALE, boolean Q_NEWCOUNTRY, int NID_C, int NID_BG, Packet_13_Section section) {
		super(13, Q_DIR, Q_SCALE);
		this.Q_NEWCOUNTRY = Q_NEWCOUNTRY;
		this.NID_C = NID_C;
		this.NID_BG = NID_BG;
		this.section = section;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_13 packet_13 = (Packet_13) object;
		return Q_NEWCOUNTRY == packet_13.Q_NEWCOUNTRY && NID_C == packet_13.NID_C && NID_BG == packet_13.NID_BG &&
			   Objects.equals(section, packet_13.section) && sections.equals(packet_13.sections);
	}

	@Override
	public String toString() {
		return "Packet_13{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", Q_NEWCOUNTRY=" + Q_NEWCOUNTRY + ", NID_C=" + NID_C + ", NID_BG=" + NID_BG
			   + ", section=" + section.toString()
			   + ", sections=" + sections.toString()
			   + '}';
	}

}
