package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.packet.TrainPacket;

/**
 * ID: 5 <br>
 * Type: Train To Track <br>
 * Description: Train Running Number <br>
 * Transmitted To: RBC
 * @author Christopher Bernjus
 */
@OrderLength(3)
public class Packet_5 extends TrainPacket {

	// --------------------
	// Train Running Number
	// --------------------

	/** {@link ebd.messageLibrary.util.ETCSVariables#NID_OPERATIONAL}*/
	@BitLength(32)
	@OrderIndex(2)
	public int NID_OPERATIONAL = ETCSVariables.NID_OPERATIONAL;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_5}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_5() {
		super(5);
	}

	/**
	 * Constructs A {@link Packet_5}
	 *
	 * @param NID_OPERATIONAL
	 *            {@link ETCSVariables#NID_OPERATIONAL}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_5(int NID_OPERATIONAL) {
		super(5);
		this.NID_OPERATIONAL = NID_OPERATIONAL;
	}

}
