package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * Superclass For Packet_49 And Packet_63
 *
 * Type: Track To Train <br>
 * Subclasses: Balise <br>
 * Lists: balises
 *
 * @author Christopher Bernjus
 */
public abstract class BaliseListPacket extends TrackPacketDIR {

	/** Subclass For Handling Iterated Balises */
	@OrderLength(3)
	public static class BaliseListPacket_Balise {

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


		// Constructors

		/**
		 * Constructs An Empty {@link BaliseListPacket_Balise}
		 *
		 * @author Christopher Bernjus
		 */
		public BaliseListPacket_Balise() {}

		/**
		 * Constructs A {@link BaliseListPacket_Balise}
		 *
		 * @param Q_NEWCOUNTRY
		 *            {@link ETCSVariables#Q_NEWCOUNTRY}
		 * @param NID_C
		 *            {@link ETCSVariables#NID_C}
		 * @param NID_BG
		 *            {@link ETCSVariables#NID_BG}
		 *
		 * @author Christopher Bernjus
		 */
		public BaliseListPacket_Balise(boolean Q_NEWCOUNTRY, int NID_C, int NID_BG) {
			this.Q_NEWCOUNTRY = Q_NEWCOUNTRY;
			this.NID_C        = NID_C;
			this.NID_BG       = NID_BG;
		}

	}


	// ---------------
	// List of Balises
	// ---------------

	/** List Of {@link BaliseListPacket_Balise}s */
	@OrderIndex(3)
	@ItemType(BaliseListPacket_Balise.class)
	public List<BaliseListPacket_Balise> balises = new ArrayList<>();


	// Constructor

	/**
	 * Constructs An Empty {@link BaliseListPacket}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	BaliseListPacket(int NID_PACKET) {
		super(NID_PACKET);
	}

	/**
	 * Constructs A {@link BaliseListPacket}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 *
	 * @author Christopher Bernjus
	 */
	BaliseListPacket(int NID_PACKET, int Q_DIR) {
		super(NID_PACKET, Q_DIR);
	}


}
