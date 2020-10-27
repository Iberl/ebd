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
 * ID: 5 <br>
 * Type: Track To Train <br>
 * Description: Linking Information <br>
 * Transmitted By: Any <br>
 * Subclasses: Link <br>
 * Elements: link <br>
 * Lists: links
 *
 * @author Christopher Bernjus
 */
public class Packet_5 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Links */
	public static class Packet_5_Link {

		/** {@link ETCSVariables#D_LINK} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_LINK = ETCSVariables.D_LINK;

		/** {@link ETCSVariables#Q_NEWCOUNTRY} */
		@BitLength(1)
		@OrderIndex(1)
		public boolean Q_NEWCOUNTRY = ETCSVariables.Q_NEWCOUNTRY;

		/** {@link ETCSVariables#NID_C} */
		@BitLength(10)
		@OrderIndex(2)
		@IfTrue("Q_NEWCOUNTRY")
		public int NID_C = ETCSVariables.NID_C;

		/** {@link ETCSVariables#NID_BG} */
		@BitLength(14)
		@OrderIndex(3)
		public int NID_BG = ETCSVariables.NID_BG;

		/** {@link ETCSVariables#Q_LINKORIENTATION} */
		@BitLength(1)
		@OrderIndex(4)
		public boolean Q_LINKORIENTATION = ETCSVariables.Q_LINKORIENTATION;

		/** {@link ETCSVariables#Q_LINKREACTION} */
		@BitLength(2)
		@OrderIndex(5)
		public int Q_LINKREACTION = ETCSVariables.Q_LINKREACTION;

		/** {@link ETCSVariables#Q_LOCACC} */
		@BitLength(6)
		@OrderIndex(6)
		public int Q_LOCACC = ETCSVariables.Q_LOCACC;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_5_Link}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_5_Link() {}

		/**
		 * Constructs A {@link Packet_5_Link}
		 *
		 * @param D_LINK
		 *            {@link ETCSVariables#D_LINK}
		 * @param Q_NEWCOUNTRY
		 *            {@link ETCSVariables#Q_NEWCOUNTRY}
		 * @param NID_C
		 *            {@link ETCSVariables#NID_C}
		 * @param NID_BG
		 *            {@link ETCSVariables#NID_BG}
		 * @param Q_LINKORIENTATION
		 *            {@link ETCSVariables#Q_LINKORIENTATION}
		 * @param Q_LINKREACTION
		 *            {@link ETCSVariables#Q_LINKREACTION}
		 * @param Q_LOCACC
		 *            {@link ETCSVariables#Q_LOCACC}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_5_Link(int D_LINK, boolean Q_NEWCOUNTRY, int NID_C, int NID_BG, boolean Q_LINKORIENTATION, int Q_LINKREACTION, int Q_LOCACC) {
			this.D_LINK            = D_LINK;
			this.Q_NEWCOUNTRY      = Q_NEWCOUNTRY;
			this.NID_C             = NID_C;
			this.NID_BG            = NID_BG;
			this.Q_LINKORIENTATION = Q_LINKORIENTATION;
			this.Q_LINKREACTION    = Q_LINKREACTION;
			this.Q_LOCACC          = Q_LOCACC;
		}


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_5_Link that = (Packet_5_Link) object;
			return D_LINK == that.D_LINK && Q_NEWCOUNTRY == that.Q_NEWCOUNTRY && NID_C == that.NID_C && NID_BG == that.NID_BG &&
				   Q_LINKORIENTATION == that.Q_LINKORIENTATION && Q_LINKREACTION == that.Q_LINKREACTION && Q_LOCACC == that.Q_LOCACC;
		}

		@Override
		public String toString() {
			return "Packet_5_Link{"
				   + "D_LINK=" + D_LINK + ", Q_NEWCOUNTRY=" + Q_NEWCOUNTRY + ", NID_C=" + NID_C
				   + ", NID_BG=" + NID_BG + ", Q_LINKORIENTATION=" + Q_LINKORIENTATION
				   + ", Q_LINKREACTION=" + Q_LINKREACTION + ", Q_LOCACC=" + Q_LOCACC
				   + '}';
		}

	}


	// -------
	// Linking
	// -------

	/** First {@link Packet_5_Link} */
	@OrderIndex(4)
	public Packet_5_Link link = new Packet_5_Link();

	/** List Of Additional {@link Packet_5_Link}s */
	@OrderIndex(5)
	@ItemType(Packet_5_Link.class)
	public List<Packet_5_Link> links = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_5}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_5() { super(5); }

	/**
	 * Constructs A {@link Packet_5}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param link
	 *            {@link Packet_5_Link}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_5(int Q_DIR, int Q_SCALE, Packet_5_Link link) {
		super(5, Q_DIR, Q_SCALE);
		this.link = link;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_5 packet_5 = (Packet_5) object;
		return Objects.equals(link, packet_5.link) && links.equals(packet_5.links);
	}

	@Override
	public String toString() {
		return "Packet_5{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", link=" + link.toString()
			   + ", links=" + links.toString()
			   + '}';
	}

}
