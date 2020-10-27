package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfTrue;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 88 <br>
 * Type: Track To Train <br>
 * Description: Level Crossing Information <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
public class Packet_88 extends TrackPacketSCALE {

    // --------------------------
    // Level Crossing Information
	// --------------------------

	/** {@link ETCSVariables#NID_LX} */
	@BitLength(8)
	@OrderIndex(4)
	public int NID_LX         = ETCSVariables.NID_LX;

	/** {@link ETCSVariables#D_LX} */
	@BitLength(15)
	@OrderIndex(5)
	public int D_LX           = ETCSVariables.D_LX;

	/** {@link ETCSVariables#L_LX} */
	@BitLength(15)
	@OrderIndex(6)
	public int L_LX           = ETCSVariables.L_LX;

	/** {@link ETCSVariables#Q_LXSTATUS} */
	@BitLength(1)
	@OrderIndex(7)
	public boolean Q_LXSTATUS = ETCSVariables.Q_LXSTATUS;

		/** {@link ETCSVariables#V_LX} */
		@BitLength(7)
		@OrderIndex(8)
		@IfTrue("Q_LXSTATUS")
		public int V_LX           = ETCSVariables.V_LX;

		/** {@link ETCSVariables#Q_STOPLX} */
		@BitLength(1)
		@OrderIndex(9)
		@IfTrue("Q_LXSTATUS")
		public boolean Q_STOPLX   = ETCSVariables.Q_STOPLX;

			/** {@link ETCSVariables#L_STOPLX} */
			@BitLength(15)
			@OrderIndex(10)
			@IfTrue("Q_STOPLX")
			public int L_STOPLX       = ETCSVariables.L_STOPLX;


    // Constructors

	/**
	 * Constructs An Empty {@link Packet_88}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_88() {
        super(88);
    }

	/**
	 * Constructs A {@link Packet_88}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param NID_LX
	 *            {@link ETCSVariables#NID_LX}
	 * @param D_LX
	 *            {@link ETCSVariables#D_LX}
	 * @param L_LX
	 *            {@link ETCSVariables#L_LX}
	 * @param Q_LXSTATUS
	 *            {@link ETCSVariables#Q_LXSTATUS}
	 * @param V_LX
	 *            {@link ETCSVariables#V_LX}
	 * @param Q_STOPLX
	 *            {@link ETCSVariables#Q_STOPLX}
	 * @param L_STOPLX
	 *            {@link ETCSVariables#L_STOPLX}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_88(int Q_DIR, int Q_SCALE, int NID_LX, int D_LX, int L_LX,
              boolean Q_LXSTATUS, int V_LX,
              boolean Q_STOPLX, int L_STOPLX) {
        super(88, Q_DIR, Q_SCALE);
        this.NID_LX     = NID_LX;
        this.D_LX       = D_LX;
        this.L_LX       = L_LX;
        this.Q_LXSTATUS = Q_LXSTATUS;
        this.V_LX       = V_LX;
        this.Q_STOPLX   = Q_STOPLX;
        this.L_STOPLX   = L_STOPLX;
    }


    // Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_88 packet_88 = (Packet_88) object;
		return NID_LX == packet_88.NID_LX && D_LX == packet_88.D_LX && L_LX == packet_88.L_LX && Q_LXSTATUS == packet_88.Q_LXSTATUS &&
			   V_LX == packet_88.V_LX && Q_STOPLX == packet_88.Q_STOPLX && L_STOPLX == packet_88.L_STOPLX;
	}

	@Override
	public String toString() {
		return "Packet_88{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", NID_LX=" + NID_LX + ", D_LX=" + D_LX + ", L_LX=" + L_LX + ", Q_LXSTATUS=" + Q_LXSTATUS
			   + ", V_LX=" + V_LX + ", Q_STOPLX=" + Q_STOPLX + ", L_STOPLX=" + L_STOPLX
			   + '}';
	}

}
