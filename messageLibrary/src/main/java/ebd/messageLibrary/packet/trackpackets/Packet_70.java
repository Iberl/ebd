package ebd.messageLibrary.packet.trackpackets;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

import static ebd.messageLibrary.util.ETCSVariables.*;

/**
 * ID: 70 <br>
 * Type: Track To Train <br>
 * Description: Route Suitability Data <br>
 * Transmitted By: Any <br>
 * Subclasses: Characteristic <br>
 * Elements: characteristic <br>
 * Lists: characteristics
 *
 * @author Christopher Bernjus
 */
@OrderLength(8)
public class Packet_70 extends TrackPacketSCALE {

	/** Subclass For Handling Iterated Characteristic */
	@OrderLength(6)
	public static class Packet_70_Characteristic {

		/** {@link ETCSVariables#D_SUITABILITY} */
		@BitLength(15)
		@OrderIndex(0)
		public int D_SUITABILITY = ETCSVariables.D_SUITABILITY;

		/** {@link ETCSVariables#Q_SUITABILITY} */
		@BitLength(2)
		@OrderIndex(1)
		public int Q_SUITABILITY = ETCSVariables.Q_SUITABILITY;

			/** {@link ETCSVariables#M_LINEGAUGE} */
			@BitLength(8)
			@OrderIndex(2)
			@IfEqual(field = "Q_SUITABILITY", value = Q_SUITABILITY_LOADING_GAUGE)
			public int M_LINEGAUGE   = ETCSVariables.M_LINEGAUGE;

			/** {@link ETCSVariables#M_AXLELOADCAT} */
			@BitLength(7)
			@OrderIndex(3)
			@IfEqual(field = "Q_SUITABILITY", value = Q_SUITABILITY_MAX_AXLE_LOAD)
			public int M_AXLELOADCAT = ETCSVariables.M_AXLELOADCAT;

			/** {@link ETCSVariables#M_VOLTAGE} */
			@BitLength(4)
			@OrderIndex(4)
			@IfEqual(field = "Q_SUITABILITY", value = Q_SUITABILITY_TRACTION_SYSTEM)
			public int M_VOLTAGE     = ETCSVariables.M_VOLTAGE;

				/** {@link ETCSVariables#NID_CTRACTION} */
				@BitLength(10)
				@OrderIndex(5)
				@IfNotEqual(field = "M_VOLTAGE", value = M_VOLTAGE_NO_TRACTION_SYSTEM)
				public int NID_CTRACTION = ETCSVariables.NID_CTRACTION;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_70_Characteristic}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_70_Characteristic() {}

		/**
		 * Constructs A {@link Packet_70_Characteristic}
		 *
		 * @param D_SUITABILITY
		 *            {@link ETCSVariables#D_SUITABILITY}
		 * @param Q_SUITABILITY
		 *            {@link ETCSVariables#Q_SUITABILITY}
		 * @param M_LINEGAUGE
		 *            {@link ETCSVariables#M_LINEGAUGE}
		 * @param M_AXLELOADCAT
		 *            {@link ETCSVariables#M_AXLELOADCAT}
		 * @param M_VOLTAGE
		 *            {@link ETCSVariables#M_VOLTAGE}
		 * @param NID_CTRACTION
		 *            {@link ETCSVariables#NID_CTRACTION}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_70_Characteristic(int D_SUITABILITY, int Q_SUITABILITY,
		                                int M_LINEGAUGE, int M_AXLELOADCAT, int M_VOLTAGE, int NID_CTRACTION) {
			this.D_SUITABILITY = D_SUITABILITY;
			this.Q_SUITABILITY = Q_SUITABILITY;
			this.M_LINEGAUGE   = M_LINEGAUGE;
			this.M_AXLELOADCAT = M_AXLELOADCAT;
			this.M_VOLTAGE     = M_VOLTAGE;
			this.NID_CTRACTION = NID_CTRACTION;
		}

	}

	// ----------------------
	// Route Suitability Data
	// ----------------------

	/** {@link ETCSVariables#Q_TRACKINIT} */
	@BitLength(1)
	@OrderIndex(4)
	public boolean Q_TRACKINIT = ETCSVariables.Q_TRACKINIT;

		/** {@link ETCSVariables#D_TRACKINIT} */
		@BitLength(15)
		@OrderIndex(5)
		@IfTrue("Q_TRACKINIT")
		public int D_TRACKINIT     = ETCSVariables.D_TRACKINIT;

		/** First {@link Packet_70_Characteristic} */
		@OrderIndex(6)
		@IfFalse("Q_TRACKINIT")
		public Packet_70_Characteristic characteristic = new Packet_70_Characteristic();

		/** List Of Additional {@link Packet_70_Characteristic}s */
		@OrderIndex(7)
		@ItemType(Packet_70_Characteristic.class)
		@IfFalse("Q_TRACKINIT")
		public List<Packet_70_Characteristic> characteristics = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_70}
	 *
	 * @author Christopher Bernjus
	 */
	Packet_70() {
		super(70);
	}

	/**
	 * Consturcts A {@link Packet_70} With An Empty Profile
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param D_TRACKINIT
	 *            {@link ETCSVariables#D_TRACKINIT}
	 *
	 * @author Christopher Bernjus
	 */
	Packet_70(int Q_DIR, int Q_SCALE, boolean Q_TRACKINIT, int D_TRACKINIT) {
		super(70, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT    = Q_TRACKINIT;
		this.D_TRACKINIT    = D_TRACKINIT;
	}

	/**
	 * Constructs A {@link Packet_70} With Possible Profiles
	 *
	 * @param Q_DIR
	 *            {@link ETCSVariables#Q_DIR}
	 * @param Q_SCALE
	 *            {@link ETCSVariables#Q_SCALE}
	 * @param characteristic
	 *            {@link Packet_70_Characteristic}
	 *
	 * @author Christopher Bernjus
	 */
	Packet_70(int Q_DIR, int Q_SCALE, boolean Q_TRACKINIT, Packet_70_Characteristic characteristic) {
		super(70, Q_DIR, Q_SCALE);
		this.Q_TRACKINIT    = Q_TRACKINIT;
		this.characteristic = characteristic;
	}

}
