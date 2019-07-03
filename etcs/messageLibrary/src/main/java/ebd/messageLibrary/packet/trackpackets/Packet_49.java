package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.OrderLength;

/**
 * ID: 49 <br>
 * Type: Track To Train <br>
 * Description: List of Balises in SH Area <br>
 * Transmitted By: Any <br>
 * Subclasses: Balise <br>
 * Lists: balises
 *
 * @author Christopher Bernjus
 */
@OrderLength(4)
public class Packet_49 extends BaliseListPacket {

    // --------------------------
    // List of Balises in SH Area
    // --------------------------


	// Constructor

	/**
	 * Constructs An Empty {@link Packet_49}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_49() {
        super(49);
    }

	/**
	 * Constructs A {@link Packet_49}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_49(int Q_DIR) {
		super(49, Q_DIR);
	}

}
