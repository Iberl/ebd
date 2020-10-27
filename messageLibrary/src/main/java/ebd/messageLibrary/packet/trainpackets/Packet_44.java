package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.util.userData.UserData;

/**
 * ID: 44 <br>
 * Type: Train To Track <br>
 * Description: Data Used By Applications Outside The ERTMS/ETCS System <br>
 * Transmitted By: RBC, RIU <br>
 * Elements: userData (must be set)
 *
 * @author Christopher Bernjus
 */
public class Packet_44 extends TrainPacket {

	// -------------------------------------------------------
	// Data Used By Applications Outside The ERTMS/ETCS System
	// -------------------------------------------------------

	/** {@link ETCSVariables#NID_XUSER} */
	@BitLength(9)
	@OrderIndex(2)
	public int NID_XUSER = ETCSVariables.NID_XUSER;

	/** Other Data Objects depending on {@link ETCSVariables#NID_XUSER} **/
	@OrderIndex(3)
	public UserData userData;


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_44}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_44() {
		super(44);
	}

	/**
	 * Constructs A {@link Packet_44}
	 *
	 * @param NID_XUSER
	 *            {@link ETCSVariables#NID_XUSER}
	 * @param userData
	 * 			  UserData Object depending on {@link ETCSVariables#NID_XUSER}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_44(int NID_XUSER, UserData userData) {
		super(44);
		this.NID_XUSER = NID_XUSER;
		this.userData = userData;
	}


	// Other Functions


	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_44 packet_44 = (Packet_44) object;
		return NID_XUSER == packet_44.NID_XUSER && userData.equals(packet_44.userData);
	}

	@Override
	public String toString() {
		return "Packet_44{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", L_PACKET=" + L_PACKET
			   + ", NID_XUSER=" + NID_XUSER
			   + ", userData=" + userData.toString()
			   + '}';
	}

}
