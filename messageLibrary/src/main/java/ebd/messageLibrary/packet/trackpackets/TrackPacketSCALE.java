package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * Superclass For All Track To Train Packets
 *
 * @author Christopher Bernjus
 */
public abstract class TrackPacketSCALE extends TrackPacketDIR {

	// --------------------------------
	// Superclass For All Track Packets
	// --------------------------------

	/** {@link ETCSVariables#Q_SCALE} */
	@BitLength(2)
	@OrderIndex(3)
	public int Q_SCALE  = ETCSVariables.Q_SCALE;


	// Constructors

	/**
	 * Constructs An Empty {@link TrackPacketSCALE}
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 *
	 * @author Christopher Bernjus
	 */
	protected TrackPacketSCALE(int NID_PACKET) {
		super(NID_PACKET);
	}

	/**
	 * Constructs A {@link TrackPacketSCALE} with {code Q_SCALE} information
	 *
	 * @param NID_PACKET
	 *            {@link ETCSVariables#NID_PACKET}
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 *
	 * @author Christopher Bernjus
	 */
	protected TrackPacketSCALE(int NID_PACKET, int Q_DIR, int Q_SCALE) {
		super(NID_PACKET, Q_DIR);
		this.Q_SCALE = Q_SCALE;
	}


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		TrackPacketSCALE that = (TrackPacketSCALE) object;
		return Q_SCALE == that.Q_SCALE;
	}

}
