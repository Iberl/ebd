package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.serialization.annotations.OrderLength;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 21 <br>
 * Type: Track To Train <br>
 * Description: Gradient Profile <br>
 * Transmitted By: Any <br>
 * Subclasses: Gradient <br>
 * Elements: gradient <br>
 * Lists: gradients
 *
 * @author Christopher Bernjus
 */
@OrderLength(6)
public class Packet_21 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Gradients */
	@OrderLength(3)
    public static class Packet_21_Gradient {

		/** {@link ETCSVariables#D_GRADIENT} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_GRADIENT = ETCSVariables.D_GRADIENT;

		/** {@link ETCSVariables#Q_GDIR} */
		@BitLength(1)
		@OrderIndex(1)
		public boolean Q_GDIR = ETCSVariables.Q_GDIR;

		/** {@link ETCSVariables#G_A} */
		@BitLength(8)
		@OrderIndex(2)
		public int G_A        = ETCSVariables.G_A;


    	// Constructors

		/**
		 * Constructs An Empty {@link Packet_21_Gradient}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_21_Gradient() {}

		/**
		 * Constructs A {@link Packet_21_Gradient}
		 *
		 * @param D_GRADIENT
		 *            {@link ETCSVariables#D_GRADIENT}
		 * @param Q_GDIR
		 *            {@link ETCSVariables#Q_GDIR}
		 * @param G_A
		 *            {@link ETCSVariables#G_A}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_21_Gradient(int D_GRADIENT, boolean Q_GDIR, int G_A) {
			this.D_GRADIENT = D_GRADIENT;
			this.Q_GDIR     = Q_GDIR;
			this.G_A        = G_A;
		}

	}


	// ----------------
    // Gradient Profile
	// ----------------

	/** First {@link Packet_21_Gradient} */
    @OrderIndex(4)
	public Packet_21_Gradient gradient = new Packet_21_Gradient();

	/** List Of Additional {@link Packet_21_Gradient}s */
    @OrderIndex(5)
    @ItemType(Packet_21_Gradient.class)
	public List<Packet_21_Gradient> gradients = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_21}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_21() {
        super(21);
    }

	/**
	 * Constructs A {@link Packet_21}
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param gradient
	 *            {@link Packet_21_Gradient}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_21(int Q_DIR, int Q_SCALE, Packet_21_Gradient gradient) {
        super(21, Q_DIR, Q_SCALE);
        this.gradient = gradient;
    }

}
