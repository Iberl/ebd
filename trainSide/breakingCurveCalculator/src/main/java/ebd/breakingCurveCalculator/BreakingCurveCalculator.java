package ebd.breakingCurveCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import ebd.breakingCurveCalculator.utils.*;
import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveCalculatorBusyException;
import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.etcsPacketConverters.MovementAuthorityConverter;
import ebd.globalUtils.location.Location;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveSetupException;
import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.globalUtils.events.bcc.BreakingCurveLimitedRequestEvent;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;

/**
 * Module shorthand: bcc
 * 
 * This class calculates a {@link BreakingCurve} out a {@link BreakingCurveRequestEvent}. After at least one of these events, 
 * a modified BreakingCurve can be calculated out of {@link BreakingCurveLimitedRequestEvent}.
 * 
 * @author Lars Schulze-Falck
 * @version v1.0
 * 
 */
public class BreakingCurveCalculator {
	
	/**
	 * Conversion factor for ETCS Values for speed to [m/s] 
	 * First term is based in the fact that the speed values of a ETCS variable are given in a resolution of 5 km/h.
	 * For example a V_MAXTRAIN of 10 represents a speed of 50km/h<br>
	 * The second term is the conversion factor between km/h and m/s
	 */
	public static final double ETCS_VALUE_TO_MS = 5d * (10d / 36d);

	private final EventBus eventBus;
	private final String eventTarget;
	private ConfigHandler ch = ConfigHandler.getInstance();
	/**
	 * If set to false, the Emergency Intervention Curve will be equal to the Service Intervention Curve
	 */

	private boolean bclreCan = false;
	private boolean isCalculating = false;

	private ForwardSpline normalBreakingPower;
	private ForwardSpline serviceBreakingPower;
	private ForwardSpline emergencyBreakingPower;
	/**
	 * {@link StaticSpeedProfil}
	 */
	private StaticSpeedProfil ssp;
	/**
	 * A profile that contains distances in [m] and acceleration in [m/s^2]
	 */
	private ForwardSpline gradientProfil;
	private Position referencePosition;

	private List<BreakingCurve> breakingCurveList;

	/**
     * This constructor takes an EventBus object and registers the instance on it 
     * @param eventBus
     * 		The local eventBus
     */
    public BreakingCurveCalculator(EventBus eventBus) {
    	this.eventBus = eventBus;
    	eventBus.register(this);
		this.eventTarget = "tsm";
    }

    /**
     * This methods listens to a {@link BreakingCurveRequestEvent}. If such an event occurs, this method prepares
	 * the calculation of the service breaking curve by first calling {@code calculateKnotList(args)} for every appropriate target
	 * and passing the result to a {@link CurveGroup};
	 * This results in three maps of targets and CurveGroups for the three breaking situations (normal, service and emergency). <br>
	 * This method also provides a weak protection against multiple concurrent calls to this function. This function should only be called again
     * after a {@link NewBreakingCurveEvent} occurs<br>
     * After finishing the calculation, this methods posts a {@link NewBreakingCurveEvent}
     * @param bcre
     *		{@link BreakingCurveRequestEvent}
     * @author Lars Schulze-Falck
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void reactToBCRE(BreakingCurveRequestEvent bcre) {
    	try {

    		if(this.isCalculating) {
    			throw new BreakingCurveCalculatorBusyException("BCC is already calculating a curve. Do only post new BreakingCurveRequestEvents "
    					+ "after a NewBreakingCurveEvent was postet. This request will be ignored");
    		}else {
				this.isCalculating = true;
    		}
		    //System.out.println(bcre.packet15.toString());
    		this.normalBreakingPower = bcre.normalBreakingPower;
    		this.serviceBreakingPower = bcre.serviceBreakingPower;
    		this.emergencyBreakingPower = bcre.emergencyBreakingPower;
    		this.referencePosition = bcre.referencePosition;
	    	this.ssp = new StaticSpeedProfil(bcre);
	    	this.gradientProfil = GradientProfileConverter.packet21ToAccGP(bcre.packet21, bcre.currentGradient);

	    	this.breakingCurveList = calculateBreakingCurveList(bcre.packet15);

			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveList));
			this.bclreCan = true; //bclre can only be calculated after the first full request is done.
			this.isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bcre, bccbe));
    	}
    	catch(Exception e) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bcre, e));
			this.breakingCurveList = Arrays.asList(new BreakingCurve(), new BreakingCurve(), new BreakingCurve());
			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveList));
			this.isCalculating = false;
    	}
    }
    
    /**
     * This function listens to a {@link BreakingCurveLimitedRequestEvent}. If such an event occurs, this method prepares
	 * the calculation of the service breaking curve by first calling {@code calculateKnotList(args)} for every appropriate target
	 * and passing the result to a {@link CurveGroup};
	 * This results in three maps of targets and CurveGroups for the three breaking situations (normal, service and emergency). <br>
     * This function can only be called after at least one {@link BreakingCurveRequestEvent} occurred.<br>
     * It its only valid in respect to the last {@link BreakingCurveRequestEvent} event that occured.<br>
     * It also provides a weak protection against multiple concurrent calls to this function. This function should only be called again 
     * after a {@link NewBreakingCurveEvent} occurs<br>
     * After finishing the calculation, this methods posts a {@link NewBreakingCurveEvent}
     * @param bclre
     *		{@link BreakingCurveLimitedRequestEvent}
     * @author Lars Schulze-Falck
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void reactToBCLRE(BreakingCurveLimitedRequestEvent bclre) {
    	try {
    		if(this.isCalculating) {
    			throw new BreakingCurveCalculatorBusyException("BCC is already calculating a curve. Do only post new BreakingCurveLimitedRequestEvents "
    					+ "after a NewBreakingCurveEvent was posted. This request will be ignored");
    		}if(!this.bclreCan) {
    			throw new BreakingCurveSetupException("A BreakingCurveLimitedRequestEvent can only be used after a BreakingCurve was caluculated");
    		}
    		else {
				this.isCalculating = true;
    		}

    		this.breakingCurveList = calculateBreakingCurveList(bclre.packet15);

			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveList));
			this.isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bclre, bccbe));
    	}
    	catch(Exception e) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bclre, e));
			this.breakingCurveList = Arrays.asList(new BreakingCurve(), new BreakingCurve(), new BreakingCurve());
			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveList));
			this.isCalculating = false;
    	}
    }


    private List<BreakingCurve> calculateBreakingCurveList(Packet_15 packet15){
		return calculateBreakingCurveListWIthShiftedPosition(packet15, this.referencePosition);
	}

	/**
	 *
	 * @param packet15 A {@link Packet_15}
	 * @param referencePosition A {@link Position} containing the location reference for all information besides {@code packet15}
	 * @return A {@link List} of {@link BreakingCurve}
	 */
	private List<BreakingCurve> calculateBreakingCurveListWIthShiftedPosition(Packet_15 packet15, Position referencePosition){


		TreeMap<Double, CurveGroup> ebdCurveMap = new TreeMap<>();
		TreeMap<Double, CurveGroup> sbdCurveMap = new TreeMap<>();
		TreeMap<Double, CurveGroup> nbdCurveMap = new TreeMap<>();
		List<Double> slowDownList = this.ssp.listOfSlowDowns();


		for(Double slowDown : slowDownList){
			List<Knot> emergencyDecelerationCurve = calculateKnotList(slowDown,
					this.ssp.getSpeedAtDistance(slowDown, CurveType.EMERGENCY_INTERVENTION_CURVE),
					true,
					this.emergencyBreakingPower);
			List<Knot> serviceDecelerationCurve = calculateKnotList(slowDown,
					this.ssp.getSpeedAtDistance(slowDown, CurveType.SERVICE_INTERVENTION_CURVE_1),
					false,
					this.serviceBreakingPower);
			List<Knot> normalDecelerationCurve = calculateKnotList(slowDown,
					this.ssp.getSpeedAtDistance(slowDown, CurveType.NORMAL_INTERVENTION_CURVE),
					false,
					this.normalBreakingPower);


			EBDCurveGroup ebd = new EBDCurveGroup(emergencyDecelerationCurve);
			ebdCurveMap.put(slowDown,ebd);

			SBDCurveGroup sbd = new SBDCurveGroup(serviceDecelerationCurve);
			sbdCurveMap.put(slowDown,sbd);

			NBDCurveGroup nbd = new NBDCurveGroup(normalDecelerationCurve);
			nbdCurveMap.put(slowDown,nbd);
		}

		double distanceToEOA = MovementAuthorityConverter.p15ToD_EMA(packet15);
		double speedAtEOA = packet15.V_LOA * ETCS_VALUE_TO_MS;
		List<Knot> serviceDecelerationCurve = calculateKnotList(distanceToEOA, speedAtEOA, false, this.serviceBreakingPower);
		List<Knot> normalDecelerationCurve = calculateKnotList(distanceToEOA, speedAtEOA, false, this.normalBreakingPower);
		SBDCurveGroup sbd = new SBDCurveGroup(serviceDecelerationCurve);
		sbdCurveMap.put(distanceToEOA,sbd);
		NBDCurveGroup nbd = new NBDCurveGroup(normalDecelerationCurve);
		nbdCurveMap.put(distanceToEOA,nbd);


		double overlap = MovementAuthorityConverter.p15GetOverlapDistance(packet15);
		double dangerpoint = MovementAuthorityConverter.p15GetOverlapDistance(packet15);
		double distanceToSVL = distanceToEOA + (Math.max(overlap, dangerpoint));
		List<Knot> emergencyDecelerationCurve = calculateKnotList(distanceToSVL, 0d, true, this.emergencyBreakingPower);
		EBDCurveGroup ebd = new EBDCurveGroup(emergencyDecelerationCurve);
		ebdCurveMap.put(distanceToSVL, ebd);

		Location refLoc = this.referencePosition.getLocation();
		BreakingCurve ebc = new BreakingCurve("ebc", refLoc, this.ssp, ebdCurveMap);
		BreakingCurve sbc = new BreakingCurve("sbc", refLoc, this.ssp, sbdCurveMap);
		BreakingCurve nbc = new BreakingCurve("nbc", refLoc, this.ssp, nbdCurveMap);

		return Arrays.asList(ebc, sbc, nbc);
	}

	/**
	 * <p>
	 * This Function calculates a knot list out of all the given information.
	 * It uses a strongly modified version of the algorithm developed by Georg Boltz in "Einfaches Bremskurvenmodell".
	 * Because we do not calculate one breaking curve, but a breaking curve group for every target in the
	 * {@link StaticSpeedProfil} (SSP) and we include the SSP in the {@link BreakingCurve}, we can use some assumption
	 * to simplify the calculation.<br>
	 *     Because we calculate a group for every target, we do no longer need to check for steps in the SSP and can calculate
	 *     every curve to distance 0.<br>
	 *         Because we include the SSP, we do no longer need to check if the curve crosses the SSP, instead we calculate
	 *         a continuous curve and let {@link BreakingCurve} use SSP to determine the correct speed.<br>
	 * </p>
	 * @param
	 * @param
	 * @return
	 * 		{@link BreakingCurve}
	 */
	private List<Knot> calculateKnotList(double distanceToEnd, double speedAtEnd, boolean ebd, ForwardSpline breakingPower)
			throws IllegalArgumentException, IndexOutOfBoundsException {
		List<Knot> knotList = new ArrayList<>();
		CurveType curveType;

		if(ebd){
			curveType = CurveType.EMERGENCY_INTERVENTION_CURVE;
		}
		else {
			curveType = CurveType.SERVICE_INTERVENTION_CURVE_1;
		}

		double deltaV = 0.2;

		double speed_EMA = speedAtEnd;

		if (speed_EMA > this.ssp.getSpeedAtDistance(distanceToEnd, curveType)) {
			speed_EMA = this.ssp.getSpeedAtDistance(distanceToEnd, curveType);
		}
		//s_EAP (see description of algorithm by Boltz) is in this calculation always 0,
		// because we work relative to the current position

		double vNow = speed_EMA;
		double vNext;
		double sNow = distanceToEnd;
		double sNext = sNow;

		//Begin of logic
		while(sNow > 0){

			vNext = vNow + deltaV;
			double vMidpoint = 0.5 * (vNow + vNext);
			double breakAcc = breakingPower.getPointOnCurve(vMidpoint);

			double deltaT = - deltaV / breakAcc;
			double deltaS = vMidpoint * deltaT;

			double sMidpoint = 0.5 * deltaS * sNow;

			breakAcc += gradientProfil.getPointOnCurve(sMidpoint);
			if (breakAcc <= 0) {
				if (this.gradientProfil.getPointOnCurve(sMidpoint).equals(-Double.MAX_VALUE)) {
					throw new IllegalArgumentException("The Movement Authority exceeded the maxium defined distance of the Gradient Profile");
				}
				else if (breakAcc - this.gradientProfil.getPointOnCurve(sMidpoint) > 0){
					throw new IllegalArgumentException("The downhill slope surpassed the breaking ability of the train");
				}
				else {
					throw new IllegalArgumentException("Breaking force was smaller than 0 for unknown reason");
				}
			}

			deltaT = - deltaV / breakAcc;
			deltaS = vMidpoint * deltaT;

			knotList.add(new Knot(sNow, new double[]{ vNow, deltaV/deltaS})); //Add KNOT
			sNow =+ deltaS;
		}

		return knotList;
	}

}
