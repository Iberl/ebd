package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfNotEqual;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import static ebd.messageLibrary.util.ETCSVariables.M_VOLTAGE_NO_TRACTION_SYSTEM;

/**
 * ID: 39 <br>
 * Type: Track To Train <br>
 * Description: Track Condition Change Of Traction System <br>
 * Transmitted By: Any
 *
 * @author Christopher Bernjus
 */
@OrderLength(7)
public class Packet_39 extends TrackPacketSCALE {

    // -----------------------------------------
    // Track Condition Change Of Traction System
	// -----------------------------------------

	/** {@link ETCSVariables#D_TRACTION} */
	@BitLength(15)
	@OrderIndex(4)
	public int D_TRACTION    = ETCSVariables.D_TRACTION;

	/** {@link ETCSVariables#M_VOLTAGE} */
	@BitLength(4)
	@OrderIndex(5)
	public int M_VOLTAGE     = ETCSVariables.M_VOLTAGE;

	/** {@link ETCSVariables#NID_CTRACTION} */
	@BitLength(10)
	@OrderIndex(6)
	@IfNotEqual(field = "M_VOLTAGE", value = M_VOLTAGE_NO_TRACTION_SYSTEM)
	public int NID_CTRACTION = ETCSVariables.NID_CTRACTION;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_39}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_39() {
        super(39);
    }

	/**
	 * Constructs A {@link Packet_39}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_TRACTION
	 *            {@link ETCSVariables#D_TRACTION}
	 * @param M_VOLTAGE
	 *            {@link ETCSVariables#M_VOLTAGE}
	 * @param NID_CTRACTION
	 *            {@link ETCSVariables#NID_CTRACTION}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_39(int Q_DIR, int Q_SCALE,
              int D_TRACTION, int M_VOLTAGE, int NID_CTRACTION) {
        super(39, Q_DIR, Q_SCALE);
        this.D_TRACTION    = D_TRACTION;
        this.M_VOLTAGE     = M_VOLTAGE;
        this.NID_CTRACTION = NID_CTRACTION;
    }

}
