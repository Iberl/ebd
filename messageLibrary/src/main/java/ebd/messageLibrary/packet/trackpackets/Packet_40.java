package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 40 <br>
 * Type: Track To Train <br>
 * Description: Track Condition Change of Allowed Current Consumption <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
public class Packet_40 extends TrackPacketSCALE {

    // -----------------------------------------------------
    // Track Condition Change of Allowed Current Consumption
	// -----------------------------------------------------

	/** {@link ETCSVariables#D_CURRENT} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_CURRENT = ETCSVariables.D_CURRENT;

	/** {@link ETCSVariables#M_CURRENT} */
	@BitLength(10)
	@OrderIndex(5)
	public int M_CURRENT = ETCSVariables.M_CURRENT;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_40}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_40() {
        super(40);
    }

	/**
	 * Constructs A {@link Packet_40}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_CURRENT
	 *            {@link ETCSVariables#D_CURRENT}
	 * @param M_CURRENT
	 *            {@link ETCSVariables#M_CURRENT}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_40(int Q_DIR, int Q_SCALE, int D_CURRENT, int M_CURRENT) {
        super(40, Q_DIR, Q_SCALE);
        this.D_CURRENT = D_CURRENT;
        this.M_CURRENT = M_CURRENT;
    }


    // Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_40 packet_40 = (Packet_40) object;
		return D_CURRENT == packet_40.D_CURRENT && M_CURRENT == packet_40.M_CURRENT;
	}

	@Override
	public String toString() {
		return "Packet_40{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", Q_SCALE=" + Q_SCALE
			   + ", D_CURRENT=" + D_CURRENT + ", M_CURRENT=" + M_CURRENT
			   + '}';
	}

}
