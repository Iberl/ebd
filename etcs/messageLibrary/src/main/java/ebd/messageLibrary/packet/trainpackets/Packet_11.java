package ebd.messageLibrary.packet.trainpackets;

import java.util.ArrayList;
import java.util.List;

import ebd.messageLibrary.serialization.annotations.*;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.messageLibrary.packet.TrainPacket;

/**
 * ID: 11 <br>
 * Type: Train To Track <br>
 * Description: Validated Train Data <br>
 * Transmitted To: RBC <br>
 * Subclasses: TractionSystem <br>
 * Lists: tractionSystems, nationalSystemIDs
 * @author Christopher Bernjus
 */
@OrderLength(15)
public class Packet_11 extends TrainPacket {

	/** Subclass For Handling Iterated Traction Systems */
	@OrderLength(2)
	public static class Packet_11_TractionSystem {

		/** {@link ETCSVariables#M_VOLTAGE} */
		@BitLength(4)
		@OrderIndex(0)
		public int M_VOLTAGE     = ETCSVariables.M_VOLTAGE;

		/** {@link ETCSVariables#NID_CTRACTION} */
		@BitLength(10)
		@OrderIndex(1)
		@IfNotEqual(field = "M_VOLTAGE", value = 0)
		public int NID_CTRACTION = ETCSVariables.NID_CTRACTION;


		// Constructors
		/**
		 * Constructs An Empty {@link Packet_11_TractionSystem}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_11_TractionSystem() {}

		/**
		 * Constructs A {@link Packet_11_TractionSystem}
		 *
		 * @param M_VOLTAGE
		 *            {@link ETCSVariables#M_VOLTAGE}
		 * @param NID_CTRACTION
		 *            {@link ETCSVariables#NID_CTRACTION}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_11_TractionSystem(int M_VOLTAGE, int NID_CTRACTION) {
			this.M_VOLTAGE     = M_VOLTAGE;
			this.NID_CTRACTION = NID_CTRACTION;
		}

	}

	/** Subclass For Handling Iterated National Systems */
	@OrderLength(1)
	public static class Packet_11_NationalSystem {

		/** {@link ETCSVariables#NID_NTC} */
		@BitLength(8)
		@OrderIndex(0)
		public int NID_NTC     = ETCSVariables.NID_NTC;


		// Constructors

		/**
		 * Constructs An Empty {@link Packet_11_NationalSystem}
		 *
		 * @author Christopher Bernjus
		 */
		public Packet_11_NationalSystem() {}

		/**
		 * Constructs A {@link Packet_11_NationalSystem}
		 *
		 * @param NID_NTC
		 *            {@link ETCSVariables#NID_NTC}
		 */
		public Packet_11_NationalSystem(int NID_NTC) {
			this.NID_NTC = NID_NTC;
		}

	}


	// --------------------
	// Validated Train Data
	// --------------------

	/** {@link ETCSVariables#NC_CDTRAIN} */
	@BitLength(4)
	@OrderIndex(2)
	public int NC_CDTRAIN     = ETCSVariables.NC_CDTRAIN;

	/** {@link ETCSVariables#NC_TRAIN} */
	@BitLength(15)
	@OrderIndex(3)
	public int NC_TRAIN       = ETCSVariables.NC_TRAIN;

	/** {@link ETCSVariables#L_TRAIN} */
	@BitLength(12)
	@OrderIndex(4)
	public int L_TRAIN        = ETCSVariables.L_TRAIN;

	/** {@link ETCSVariables#V_MAXTRAIN} */
	@BitLength(7)
	@OrderIndex(5)
	public int V_MAXTRAIN     = ETCSVariables.V_MAXTRAIN;

	/** {@link ETCSVariables#M_LOADINGGAUGE} */
	@BitLength(8)
	@OrderIndex(6)
	public int M_LOADINGGAUGE = ETCSVariables.M_LOADINGGAUGE;

	/** {@link ETCSVariables#M_AXLELOADCAT} */
	@BitLength(7)
	@OrderIndex(7)
	public int M_AXLELOADCAT  = ETCSVariables.M_AXLELOADCAT;

	/** {@link ETCSVariables#M_AIRTIGHT} */
	@BitLength(2)
	@OrderIndex(8)
	public int M_AIRTIGHT     = ETCSVariables.M_AIRTIGHT;

	/** {@link ETCSVariables#N_AXLE} */
	@BitLength(10)
	@OrderIndex(9)
	public int N_AXLE         = ETCSVariables.N_AXLE;


	/** List Of {@link Packet_11_TractionSystem}s */
	@OrderIndex(10)
	@ItemType(Packet_11_TractionSystem.class)
	public List<Packet_11_TractionSystem> tractionSystems = new ArrayList<>();

	/** List Of {@link Packet_11_NationalSystem}s */
	@OrderIndex(11)
	@ItemType(Packet_11_NationalSystem.class)
	public List<Packet_11_NationalSystem> nationalSystemIDs = new ArrayList<>();


	// Constructors

	/**
	 * Constructs An Empty {@link Packet_11}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_11() {
		super(11);
	}

	/**
	 * Constructs A {@link Packet_11}
	 *
	 * @param NC_CDTRAIN
	 *            {@link ETCSVariables#NC_CDTRAIN}
	 * @param NC_TRAIN
	 *            {@link ETCSVariables#NC_TRAIN}
	 * @param L_TRAIN
	 *            {@link ETCSVariables#L_TRAIN}
	 * @param V_MAXTRAIN
	 *            {@link ETCSVariables#V_MAXTRAIN}
	 * @param M_LOADINGGAUGE
	 *            {@link ETCSVariables#M_LOADINGGAUGE}
	 * @param M_AXLELOADCAT
	 *            {@link ETCSVariables#M_AXLELOADCAT}
	 * @param M_AIRTIGHT
	 *            {@link ETCSVariables#M_AIRTIGHT}
	 * @param N_AXLE
	 *            {@link ETCSVariables#N_AXLE}
	 *
	 * @author Christopher Bernjus
	 */
	public Packet_11(int NC_CDTRAIN, int NC_TRAIN, int L_TRAIN, int V_MAXTRAIN, int M_LOADINGGAUGE, int M_AXLELOADCAT, int M_AIRTIGHT, int N_AXLE) {
		super(11);
		this.NC_CDTRAIN     = NC_CDTRAIN;
		this.NC_TRAIN       = NC_TRAIN;
		this.L_TRAIN        = L_TRAIN;
		this.V_MAXTRAIN     = V_MAXTRAIN;
		this.M_LOADINGGAUGE = M_LOADINGGAUGE;
		this.M_AXLELOADCAT  = M_AXLELOADCAT;
		this.M_AIRTIGHT     = M_AIRTIGHT;
		this.N_AXLE         = N_AXLE;
	}

}
