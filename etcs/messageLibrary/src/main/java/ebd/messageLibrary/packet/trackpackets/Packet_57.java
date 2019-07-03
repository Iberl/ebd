package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 57 <br>
 * Type: Track To Train <br>
 * Description: Movement Authority Request Parameters <br>
 * Transmitted By: RBC
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Packet_57 extends TrackPacketDIR {

	// -------------------------------------
    // Movement Authority Request Parameters
	// -------------------------------------

    /** {@link ETCSVariables#T_MAR} */
    @BitLength(8)
    @OrderIndex(3)
    public int T_MAR         = ETCSVariables.T_MAR;

	/** {@link ETCSVariables#T_TIMEOUTRQST} */
	@BitLength(10)
	@OrderIndex(4)
	public int T_TIMEOUTRQST = ETCSVariables.T_TIMEOUTRQST;

	/** {@link ETCSVariables#T_CYCRQST} */
	@BitLength(8)
	@OrderIndex(5)
	public int T_CYCRQST     = ETCSVariables.T_CYCRQST;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_57}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_57() {
        super(57);
    }

	/**
	 * Constructs A {@link Packet_57}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param T_MAR
	 *            {@link ETCSVariables#T_MAR}
	 * @param T_TIMEOUTRQST
	 *            {@link ETCSVariables#T_TIMEOUTRQST}
	 * @param T_CYCRQST
	 *            {@link ETCSVariables#T_CYCRQST}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_57(int Q_DIR, int T_MAR, int T_TIMEOUTRQST, int T_CYCRQST) {
        super(57, Q_DIR);
        this.T_MAR         = T_MAR;
        this.T_TIMEOUTRQST = T_TIMEOUTRQST;
        this.T_CYCRQST     = T_CYCRQST;
    }

}
