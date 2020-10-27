package ebd.messageLibrary.packet;


/**
 * ID: 255 <br>
 * Type: Both <br>
 * Description: End Of Information <br>
 * Transmitted To: RBC, RIU
 *
 * @author Christopher Bernjus
 */
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


	// Other Functions

	@Override
	public String toString() {
		return "Packet_255{"
			   + "NID_PACKET=" + NID_PACKET
			   + '}';
	}

}
