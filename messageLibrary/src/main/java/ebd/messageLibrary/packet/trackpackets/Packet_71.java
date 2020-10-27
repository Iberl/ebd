package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 71 <br>
 * Type: Track To Train <br>
 * Description: Adhesion Factor <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
public class Packet_71 extends TrackPacketSCALE {

	// ---------------
    // Adhesion Factor
	// ---------------

	/** {@link ETCSVariables#D_ADHESION} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_ADHESION     = ETCSVariables.D_ADHESION;

	/** {@link ETCSVariables#L_ADHESION} */
	@BitLength(15)
	@OrderIndex(5)
	public int L_ADHESION     = ETCSVariables.L_ADHESION;

	/** {@link ETCSVariables#M_ADHESION} */
	@BitLength(1)
	@OrderIndex(6)
	public boolean M_ADHESION = ETCSVariables.M_ADHESION;


    // Constructors

	/**
	 * Constructs An Empty {@link Packet_71}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_71() {
        super(71);
    }

	/**
	 * Constructs A {@link Packet_71}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_ADHESION
	 *            {@link ETCSVariables#D_ADHESION}
	 * @param L_ADHESION
	 *            {@link ETCSVariables#L_ADHESION}
	 * @param M_ADHESION
	 *            {@link ETCSVariables#M_ADHESION}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_71(int Q_DIR, int Q_SCALE, int D_ADHESION, int L_ADHESION, boolean M_ADHESION) {
        super(71, Q_DIR, Q_SCALE);
        this.D_ADHESION = D_ADHESION;
        this.L_ADHESION = L_ADHESION;
        this.M_ADHESION = M_ADHESION;
    }


    // Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_71 packet_71 = (Packet_71) object;
		return D_ADHESION == packet_71.D_ADHESION && L_ADHESION == packet_71.L_ADHESION && M_ADHESION == packet_71.M_ADHESION;
	}

	@Override
	public String toString() {
		return "Packet_71{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", D_ADHESION=" + D_ADHESION + ", L_ADHESION=" + L_ADHESION + ", M_ADHESION=" + M_ADHESION
			   + '}';
	}

}
