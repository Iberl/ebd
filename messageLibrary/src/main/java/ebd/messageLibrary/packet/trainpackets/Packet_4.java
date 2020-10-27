package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * ID: 4 <br>
 * Type: Train To Track <br>
 * Description: Error Reporting <br>
 * Transmitted To: RBC
 * @author Christopher Bernjus
 */
public class Packet_4 extends TrainPacket {

	// ---------------
	// Error Reporting
	// ---------------

	/** {@link ETCSVariables#M_ERROR} */
	@BitLength(8)
	@OrderIndex(2)
	public int M_ERROR = ETCSVariables.M_ERROR;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_4}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_4() {
		super(4);
	}

	/**
	 * Constructs A {@link Packet_4}
	 *
	 * @param M_ERROR
	 *            {@link ETCSVariables#M_ERROR}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_4(int M_ERROR) {
		super(4);
		this.M_ERROR = M_ERROR;
	}


	// Other Functions

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;
		Packet_4 packet_4 = (Packet_4) o;
		return M_ERROR == packet_4.M_ERROR;
	}

	@Override
	public String toString() {
		return "Packet_4{"
			   + "wNID_PACKET=" + NID_PACKET
			   + ", L_PACKET=" + L_PACKET
			   + ", M_ERROR=" + M_ERROR
			   + '}';
	}

}
