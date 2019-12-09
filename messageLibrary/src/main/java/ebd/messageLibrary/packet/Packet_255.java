package ebd.messageLibrary.packet;

import ebd.messageLibrary.serialization.annotations.OrderLength;

/**
 * ID: 255 <br>
 * Type: Both <br>
 * Description: End Of Information <br>
 * Transmitted To: RBC, RIU
 *
 * @author Christopher Bernjus
 */
@OrderLength(1)
public class Packet_255 extends Packet {

	// ------------------
	// End of Information
	// ------------------

	// Constructor

	/**
	 * Constructs A Packet_255
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_255() {
		super(255);
	}
	
}
