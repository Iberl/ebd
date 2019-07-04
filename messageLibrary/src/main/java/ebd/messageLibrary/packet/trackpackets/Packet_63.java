package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 63 <br>
 * Type: Track To Train <br>
 * Description: List of Balises in SR Area <br>
 * Transmitted By: RBC <br>
 * Subclasses: Balise <br>
 * Lists: balises
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Packet_63 extends BaliseListPacket {

	// -------------------------------
    // List of Balises in SR Authority
	// -------------------------------


	// Constructor

	/**
	 * Constructs An Empty {@link Packet_63}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_63() {
        super(63);
    }

	/**
	 * Constructs A {@link Packet_63}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_63(int Q_DIR) {
		super(63, Q_DIR);
	}
}
