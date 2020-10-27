package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.util.userData.UserData;

import java.util.Objects;

/**
 * ID: 44 <br>
 * Type: Track To Train <br>
 * Description: Data Used By Applications Outside the ERTMS/ETCS System <br>
 * Transmitted By: Any <br>
 * Elements: userData (must be set)
 *
 * @author Christopher Bernjus
 */
public class Packet_44 extends TrackPacketDIR {

	// -------------------------------------------------------
	// Data Used By Applications Outside the ERTMS/ETCS System
	// -------------------------------------------------------

	/** {@link ETCSVariables#NID_XUSER} */
	@BitLength(9)
	@OrderIndex(3)
	public int NID_XUSER = ETCSVariables.NID_XUSER;

	/** {@link ETCSVariables#NID_NTC} */
	@BitLength(8)
	@OrderIndex(4)
	public int NID_NTC = ETCSVariables.NID_NTC;

	/** Other Data Objects depending on {@link ETCSVariables#NID_XUSER} **/
	@OrderIndex(5)
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
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param NID_XUSER
	 *            {@link ETCSVariables#NID_XUSER}
	 * @param NID_NTC
	 *            {@link ETCSVariables#NID_NTC}
	 * @param userData
	 * 			  UserData Object depending on {@link ETCSVariables#NID_XUSER}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_44(int Q_DIR, int NID_XUSER, int NID_NTC, UserData userData) {
		super(44, Q_DIR);
		this.NID_XUSER = NID_XUSER;
		this.NID_NTC = NID_NTC;
		this.userData = userData;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_44 packet_44 = (Packet_44) object;
		return NID_XUSER == packet_44.NID_XUSER && NID_NTC == packet_44.NID_NTC && Objects.equals(userData, packet_44.userData);
	}

	@Override
	public String toString() {
		return "Packet_44{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", Q_DIR=" + Q_DIR + ", L_PACKET=" + L_PACKET
			   + ", NID_XUSER=" + NID_XUSER + ", NID_NTC=" + NID_NTC
			   + ", userData=" + userData.toString()
			   + '}';
	}

}
