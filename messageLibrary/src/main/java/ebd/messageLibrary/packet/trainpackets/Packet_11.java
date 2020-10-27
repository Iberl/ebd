package ebd.messageLibrary.packet.trainpackets;

import ebd.messageLibrary.packet.TrainPacket;
import ebd.messageLibrary.serialization.annotations.BitLength;
import ebd.messageLibrary.serialization.annotations.IfNotEqual;
import ebd.messageLibrary.serialization.annotations.ItemType;
import ebd.messageLibrary.serialization.annotations.OrderIndex;
import ebd.messageLibrary.util.ETCSVariables;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 11 <br>
 * Type: Train To Track <br>
 * Description: Validated Train Data <br>
 * Transmitted To: RBC <br>
 * Subclasses: TractionSystem <br>
 * Lists: tractionSystems, nationalSystemIDs
 * @author Christopher Bernjus
 */
public class Packet_11 extends TrainPacket {

	/** Subclass For Handling Iterated Traction Systems */
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


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_11_TractionSystem that = (Packet_11_TractionSystem) object;
			return M_VOLTAGE == that.M_VOLTAGE && NID_CTRACTION == that.NID_CTRACTION;
		}

		@Override
		public String toString() {
			return "Packet_11_TractionSystem{"
				   + "M_VOLTAGE=" + M_VOLTAGE + ", NID_CTRACTION=" + NID_CTRACTION
				   + '}';
		}

	}

	/** Subclass For Handling Iterated National Systems */
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


		// Other Functions

		@Override
		public boolean equals(Object object) {
			if(this == object) return true;
			if(object == null || getClass() != object.getClass()) return false;
			Packet_11_NationalSystem that = (Packet_11_NationalSystem) object;
			return NID_NTC == that.NID_NTC;
		}

		@Override
		public String toString() {
			return "Packet_11_NationalSystem{"
				   + "NID_NTC=" + NID_NTC
				   + '}';
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


	// Other Functions

	@Override
	public boolean equals(Object object) {
		if(this == object) return true;
		if(object == null || getClass() != object.getClass()) return false;
		if(!super.equals(object)) return false;
		Packet_11 packet_11 = (Packet_11) object;
		return NC_CDTRAIN == packet_11.NC_CDTRAIN && NC_TRAIN == packet_11.NC_TRAIN && L_TRAIN == packet_11.L_TRAIN &&
			   V_MAXTRAIN == packet_11.V_MAXTRAIN && M_LOADINGGAUGE == packet_11.M_LOADINGGAUGE && M_AXLELOADCAT == packet_11.M_AXLELOADCAT &&
			   M_AIRTIGHT == packet_11.M_AIRTIGHT && N_AXLE == packet_11.N_AXLE && tractionSystems.equals(packet_11.tractionSystems) &&
			   nationalSystemIDs.equals(packet_11.nationalSystemIDs);
	}

	@Override
	public String toString() {
		return "Packet_11{"
			   + "NID_PACKET=" + NID_PACKET
			   + ", L_PACKET=" + L_PACKET
			   + "NC_CDTRAIN=" + NC_CDTRAIN + ", NC_TRAIN=" + NC_TRAIN + ", L_TRAIN=" + L_TRAIN
			   + ", V_MAXTRAIN=" + V_MAXTRAIN + ", M_LOADINGGAUGE=" + M_LOADINGGAUGE
			   + ", M_AXLELOADCAT=" + M_AXLELOADCAT + ", M_AIRTIGHT=" + M_AIRTIGHT + ", N_AXLE=" + N_AXLE
			   + ", tractionSystems=" + tractionSystems.toString()
			   + ", nationalSystemIDs=" + nationalSystemIDs.toString()
			   + '}';
	}

}
