package ebd.globalUtils.events.bcc;

import java.util.ArrayList;
import java.util.List;

import ebd.globalUtils.events.NormalEvent;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_65;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * With this Event, the TSM can request BCC to calculate a new BreakingCurve. It is the responsibility of the thrower to check for the integrity of the provided Information.<br>
 * Special care has to be taken that the Movement Authority does not exceed the maximum defined distance of the Static Speed Profile,
 * should the {@link Packet_27} contain the end marker {@link ETCSVariables#V_STATIC} = 127<br>
 * Special care has to be taken that the Movement Authority does not exceed the maximum defined distance of the Gradient Profile,
 * should the {@link Packet_21} contain the end marker {@link ETCSVariables#G_A} = 255<br>
 * 
 * @author Lars Schulze-Falck
 *
 */
public class BreakingCurveRequestEvent extends NormalEvent {
	

	/**
	 * Constructor setting all required fields

	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or "all" if more then one target should be reached.
	 *
	 * @param id
	 * 			String to identify the breaking curve
	 * @param breakingPower
	 * 			Breaking Power as {@link ForwardSpline} in the units [m] and [m/s�]
	 * @param emergencyBreakingPower
	 * 			Emergency Breaking Power as {@link ForwardSpline} in the units [m] and [m/s�]
	 * @param packet15
	 * 			{@link Packet_15}
	 * @param packet21
	 * 			{@link Packet_21}
	 * @param currentGradient 
	 * 			Current gradient from an existing gradient profile or default value. In [0/00] (also called per mille).
	 * @param referencePosition
	 * 			Reference {@link Position} to the data (given by the RBG)
	 * @param packet27
	 * 			{@link Packet_27}
	 * @param NC_CDTRAIN
	 * 			{@link ETCSVariables#NC_CDTRAIN}
	 * @param L_TRAIN
	 * 			{@link ETCSVariables#L_TRAIN}
	 * @param currentSpeedLimit
	 * 			Current allowed speed of the train. Either out of previous SSP or from current mode.<br>
	 * 			NOTE: In [m/s]
	 * @param maxSpeedofTrain
	 * 			The maximum Speed of the train in [km/h]. This value will be divided by 5 in the constructor,
	 * 			so it the same unit as speed values provided by the ETCS Message System.

	 */
	public BreakingCurveRequestEvent(String source, String target, String id, ForwardSpline breakingPower,
									 ForwardSpline emergencyBreakingPower, Packet_15 packet15, Packet_21 packet21,
									 double currentGradient, Position referencePosition, Packet_27 packet27,
									 int NC_CDTRAIN, double L_TRAIN,
									 double currentSpeedLimit, int maxSpeedofTrain) {
		super(source, target);
		this.id = id;
		this.breakingPower = breakingPower;
		this.emergencyBreakingPower = emergencyBreakingPower;
		this.packet15 = packet15;
		this.packet21 = packet21;
		this.currentGradient = currentGradient;
		this.referencePosition = referencePosition;
		this.packet27 = packet27;
		this.NC_CDTRAIN = NC_CDTRAIN;
		this.L_TRAIN = L_TRAIN;
		this.currentSpeedLimit = currentSpeedLimit;
		this.maxSpeedofTrain = maxSpeedofTrain / 5;
		
	}
	
	/**
	 * Constructor setting all fields
	 * @param source
	 *          ID from the module the event was sent by
	 * @param target
	 *          ID from from the target module or "all" if more then one target should be reached.
	 * @param id
	 * 			String to identify the breaking curve
	 * @param breakingPower
	 * 			Breaking Power as {@link ForwardSpline} in the units [m] and [m/s�]
	 * @param emergencyBreakingPower
	 * 			Emergency Breaking Power as {@link ForwardSpline} in the units [m] and [m/s�]
	 * @param packet15
	 * 			{@link Packet_15}
	 * @param packet21
	 * 			{@link Packet_21}
	 * @param currentGradient 
	 * 			Current gradient from an existing gradient profile or default value. In [0/00] (also called per mille).
	 * @param referencePosition
	 * 			Reference {@link Position} to the data (given by the RBG)
	 * @param packet27
	 * 			{@link Packet_27}
	 * @param listPacket65
	 * 			A {@link List} of {@link Packet_65}, can be empty
	 * @param NC_CDTRAIN
	 * 			{@link ETCSVariables#NC_CDTRAIN}
	 * @param NC_TRAIN
	 * 			{@link ETCSVariables#NC_TRAIN}
	 * @param L_TRAIN
	 * 			{@link ETCSVariables#L_TRAIN}
	 * @param currentSpeedLimit 
	 * 			Current allowed speed of the train. Either out of previous SSP or from current mode.<br>
	 * 			NOTE: In [m/s]
	 * @param maxSpeedofTrain
	 * 			The maximum Speed of the train in [km/h]. This value will be divided by 5 in the constructor,
	 * 			so it the same unit as speed values provided by the ETCS Message System.
	 */
	public BreakingCurveRequestEvent(String source, String target, String id,ForwardSpline breakingPower, ForwardSpline emergencyBreakingPower,
									 Packet_15 packet15, Packet_21 packet21, double currentGradient,
									 Position referencePosition, Packet_27 packet27, List<Packet_65> listPacket65,
									 int NC_CDTRAIN, int NC_TRAIN, double L_TRAIN, double currentSpeedLimit, int maxSpeedofTrain) {
		super(source,target);
		this.id = id;
		this.breakingPower = breakingPower;
		this.emergencyBreakingPower = emergencyBreakingPower;
		this.packet15 = packet15;
		this.packet21 = packet21;
		this.currentGradient = currentGradient;
		this.referencePosition = referencePosition;
		this.packet27 = packet27;
		this.listPacket65 = listPacket65;
		this.NC_CDTRAIN = NC_CDTRAIN;
		this.NC_TRAIN = NC_TRAIN;
		this.L_TRAIN = L_TRAIN;
		this.currentSpeedLimit = currentSpeedLimit;
		this.maxSpeedofTrain = maxSpeedofTrain / 5;
	}
	
	/**
	 * ID of the resulting breaking curve group
	 */
	public String id;																		
	
	//Information for BCC
	/**
	 * Breaking Power as {@link ForwardSpline} in the units [m] and [m/s�]
	 */
	public ForwardSpline breakingPower;

	/**
	 * Emergency Breaking Power as {@link ForwardSpline} in the units [m] and [m/s�]
	 */
	public ForwardSpline emergencyBreakingPower;

	/**
	 * Movement Authority Packet {@link Packet_15}
	 */
	public Packet_15 packet15;
	
	/**
	 * Gradient Profile Packet {@link Packet_21}
	 */
	public Packet_21 packet21;
	
	/**
	 * current gradient in 0/00 (per mill)
	 */
	public double currentGradient;
	
	/**
	 * Reference {@link Position} to the data (given by the RBG)
	 */
	public Position referencePosition; 														
	
	//Information for generation of SSP
	
	/**
	 * International Speed Profile Packet {@link Packet_27}
	 */
	public Packet_27 packet27;
	
	/**
	 * A list of Temporary Speed Restriction Packets {@link Packet_65}, defaults to an empty List
	 */
	public List<Packet_65> listPacket65 = new ArrayList<Packet_65>();
	
	/**
	 * {@link ETCSVariables#NC_CDDIFF} from Train Data
	 */
	public int NC_CDTRAIN;
	
	/**
	 * {@link ETCSVariables#NC_TRAIN} from Train Data
	 */
	public int NC_TRAIN = 0;
	
	/**
	 * {@link ETCSVariables#L_TRAIN} from Train Data in [m]
	 */
	public double L_TRAIN;
	
	/**
	 * Current allowed speed of the train in [m/s]
	 */
	public double currentSpeedLimit;
	
	/**
	 * {@link ETCSVariables#V_MAXTRAIN} from Train Data in [km/h] / 5.
	 */
	public int maxSpeedofTrain;
	
	
	

}
