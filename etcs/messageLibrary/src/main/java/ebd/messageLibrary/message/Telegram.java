package ebd.messageLibrary.message;

import ebd.messageLibrary.packet.Packet_255;
import ebd.messageLibrary.packet.TrackPacket;
import ebd.messageLibrary.packet.trackpackets.Packet_0;
import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 *  Telegram Message Transmitted By Balise
 */
@OrderLength(13)
public class Telegram {

	// ------------------------------
	// Telegram Transmitted By Balise
	// ------------------------------

	/** {@link ETCSVariables#Q_UPDOWN} */
	@BitLength(1)
	@OrderIndex(0)
	public boolean Q_UPDOWN = ETCSVariables.Q_UPDOWN;

	/** {@link ETCSVariables#M_VERSION} */
	@BitLength(7)
	@OrderIndex(1)
	public int M_VERSION    = ETCSVariables.M_VERSION;

	/** {@link ETCSVariables#Q_MEDIA} */
	@BitLength(1)
	@OrderIndex(2)
	public boolean Q_MEDIA  = ETCSVariables.Q_MEDIA;

	/** {@link ETCSVariables#N_PIG} */
	@BitLength(3)
	@OrderIndex(3)
	public int N_PIG        = ETCSVariables.N_PIG;

	/** {@link ETCSVariables#N_TOTAL} */
	@BitLength(3)
	@OrderIndex(4)
	public int N_TOTAL      = ETCSVariables.N_TOTAL;

	/** {@link ETCSVariables#M_DUP} */
	@BitLength(2)
	@OrderIndex(5)
	public int M_DUP        = ETCSVariables.M_DUP;

	/** {@link ETCSVariables#M_MCOUNT} */
	@BitLength(8)
	@OrderIndex(6)
	public int M_MCOUNT     = ETCSVariables.M_MCOUNT;

	/** {@link ETCSVariables#NID_C} */
	@BitLength(10)
	@OrderIndex(7)
	public int NID_C        = ETCSVariables.NID_C;

	/** {@link ETCSVariables#NID_BG} */
	@BitLength(14)
	@OrderIndex(8)
	public int NID_BG       = ETCSVariables.NID_BG;

	/** {@link ETCSVariables#Q_LINK} */
	@BitLength(1)
	@OrderIndex(9)
	public boolean Q_LINK   = ETCSVariables.Q_LINK;

	/** {@link Packet_0} */
	@OrderIndex(10)
	@CanBeNull
	public Packet_0 PACKET_0;

	/** List of {@link TrackPacket}s */
	@OrderIndex(11)
	@ItemType(TrackPacket.class)
	public List<TrackPacket> packets = new ArrayList<>();

	/** {@link Packet_255} */
	@OrderIndex(12)
	public Packet_255 PACKET_255 = new Packet_255();


	// Constructors

	/**
	 * Constructs An Empty {@link Telegram}
	 *
	 * @author Christopher Bernjus
	 */
	public Telegram() {}

	/**
	 * Constructs A {@link Telegram} Without {@code Packet_0} Information
	 *
	 * @param Q_UPDOWN
	 *            {@link ETCSVariables#Q_UPDOWN}
	 * @param M_VERSION
	 *            {@link ETCSVariables#M_VERSION}
	 * @param Q_MEDIA
	 *            {@link ETCSVariables#Q_MEDIA}
	 * @param N_PIG
	 *            {@link ETCSVariables#N_PIG}
	 * @param N_TOTAL
	 *            {@link ETCSVariables#N_TOTAL}
	 * @param M_DUP
	 *            {@link ETCSVariables#M_DUP}
	 * @param M_MCOUNT
	 *            {@link ETCSVariables#M_MCOUNT}
	 * @param NID_C
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_BG
	 *            {@link ETCSVariables#NID_BG}
	 * @param Q_LINK
	 *            {@link ETCSVariables#Q_LINK}
	 *
	 * @author Christopher Bernjus
	 */
	public Telegram(boolean Q_UPDOWN, int M_VERSION, boolean Q_MEDIA, int N_PIG, int N_TOTAL, int M_DUP, int M_MCOUNT, int NID_C, int NID_BG, boolean Q_LINK) {
		this.Q_UPDOWN  = Q_UPDOWN;
		this.M_VERSION = M_VERSION;
		this.Q_MEDIA   = Q_MEDIA;
		this.N_PIG     = N_PIG;
		this.N_TOTAL   = N_TOTAL;
		this.M_DUP     = M_DUP;
		this.M_MCOUNT  = M_MCOUNT;
		this.NID_C     = NID_C;
		this.NID_BG    = NID_BG;
		this.Q_LINK    = Q_LINK;
	}

	/**
	 * Constructs A {@link Telegram} With {@code Packet_0} Information
	 *
	 * @param Q_UPDOWN
	 *            {@link ETCSVariables#Q_UPDOWN}
	 * @param M_VERSION
	 *            {@link ETCSVariables#M_VERSION}
	 * @param Q_MEDIA
	 *            {@link ETCSVariables#Q_MEDIA}
	 * @param N_PIG
	 *            {@link ETCSVariables#N_PIG}
	 * @param N_TOTAL
	 *            {@link ETCSVariables#N_TOTAL}
	 * @param M_DUP
	 *            {@link ETCSVariables#M_DUP}
	 * @param M_MCOUNT
	 *            {@link ETCSVariables#M_MCOUNT}
	 * @param NID_C
	 *            {@link ETCSVariables#NID_C}
	 * @param NID_BG
	 *            {@link ETCSVariables#NID_BG}
	 * @param Q_LINK
	 *            {@link ETCSVariables#Q_LINK}
	 * @param PACKET_0
	 *            {@link Packet_0}
	 *
	 * @author Christopher Bernjus
	 */
	public Telegram(boolean Q_UPDOWN, int M_VERSION, boolean Q_MEDIA, int N_PIG, int N_TOTAL, int M_DUP, int M_MCOUNT, int NID_C, int NID_BG, boolean Q_LINK, Packet_0 PACKET_0) {
		this.Q_UPDOWN  = Q_UPDOWN;
		this.M_VERSION = M_VERSION;
		this.Q_MEDIA   = Q_MEDIA;
		this.N_PIG     = N_PIG;
		this.N_TOTAL   = N_TOTAL;
		this.M_DUP     = M_DUP;
		this.M_MCOUNT  = M_MCOUNT;
		this.NID_C     = NID_C;
		this.NID_BG    = NID_BG;
		this.Q_LINK    = Q_LINK;
		this.PACKET_0  = PACKET_0;
	}

}
