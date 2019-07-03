package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 58 <br>
 * Type: Track To Train <br>
 * Description: Position Report Parameters <br>
 * Transmitted By: RBC <br>
 * Subclasses: Interval <br>
 * Lists: intervals
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Packet_58 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Intervals */
	@OrderLength(2)
	public static class Packet_58_Interval {

		/** {@link ETCSVariables#D_LOC} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_LOC = ETCSVariables.D_LOC;

		/** {@link ETCSVariables#Q_LGTLOC} */
		@BitLength(1)
		@OrderIndex(1)
		public boolean Q_LGTLOC = ETCSVariables.Q_LGTLOC;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_58_Interval}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_58_Interval() {}

		/**
		 * Constructs A {@link Packet_58_Interval}
		 *
		 * @param D_LOC
		 *            {@link ETCSVariables#D_LOC}
		 * @param Q_LGTLOC
		 *            {@link ETCSVariables#Q_LGTLOC}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_58_Interval(int D_LOC, boolean Q_LGTLOC) {
			this.D_LOC = D_LOC;
			this.Q_LGTLOC = Q_LGTLOC;
		}

	}

	// --------------------------
    // Position Report Parameters
	// --------------------------

	/** {@link ETCSVariables#T_CYCLOC} */
	@BitLength(8)
	@OrderIndex(4)
	public int T_CYCLOC = ETCSVariables.T_CYCLOC;

	/** {@link ETCSVariables#D_CYCLOC} */
	@BitLength(15)
	@OrderIndex(5)
	public int D_CYCLOC = ETCSVariables.D_CYCLOC;

	/** {@link ETCSVariables#M_LOC} */
	@BitLength(3)
	@OrderIndex(6)
	public int M_LOC    = ETCSVariables.M_LOC;

	/** List Of {@link Packet_58_Interval}s */
    @OrderIndex(7)
    @ItemType(Packet_58_Interval.class)
	public List<Packet_58_Interval> intervals = new ArrayList<>();


    // Constructors

	/**
	 * Constructs An Empty {@link Packet_58}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_58() {
        super(58);
    }

	/**
	 * Constructs A {@link Packet_58}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param T_CYCLOC
	 *            {@link ETCSVariables#T_CYCLOC}
	 * @param D_CYCLOC
	 *            {@link ETCSVariables#D_CYCLOC}
	 * @param M_LOC
	 *            {@link ETCSVariables#M_LOC}
	 *
	 * @author Christopher Bernjus
	 */
    public Packet_58(int Q_DIR, int Q_SCALE,
              int T_CYCLOC, int D_CYCLOC, int M_LOC) {
        super(58, Q_DIR, Q_SCALE);
        this.T_CYCLOC = T_CYCLOC;
        this.D_CYCLOC = D_CYCLOC;
        this.M_LOC    = M_LOC;
    }

}
