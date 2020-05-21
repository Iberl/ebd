package ebd.breakingCurveCalculator;

import java.util.ArrayList;
import java.util.List;

import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveCalculatorBusyException;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketToProfileConverters.GradientProfileConverter;
import ebd.globalUtils.etcsPacketToProfileConverters.MovementAuthorityConverter;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ebd.breakingCurveCalculator.utils.StaticSpeedProfil;
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

	private EventBus eventBus;
	private String eventTarget;
	private ConfigHandler ch = ConfigHandler.getInstance();

	private boolean bclreCan = false;
	private boolean isCalculating = false;

	private ForwardSpline breakingPower;
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
	private double dangerPointOffset;

	private BreakingCurveGroup breakingCurveGroup;

	public enum CurveType {
		INDICATION_CURVE,
		PERMITTED_SPEED,
		WARNING_CURVE,
		SERVICE_CURVE,
		EMERGENCY_CURVE
	}

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
     * This function listens to a {@link BreakingCurveRequestEvent}. If such an event occurs, this method prepares
	 * the calculation of the service breaking curve by first calling {@link BreakingCurveCalculator#calculateKnotList(double, double, CurveType)}
	 * and then calls {@link BreakingCurveCalculator#getCurveFromList(List, Position, String)}<br>
	 * It then calculates additional breaking curves from this {@code List<Knot>} by shifting the knots with speed and time.
	 * This results in the permitted speed, warning speed, overspeed and intervention speed curves. <br>//TODO check which curves to use
     * It also provides a weak protection against multiple concurrent calls to this function. This function should only be called again 
     * after a {@link NewBreakingCurveEvent} occures<br>
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
    		this.breakingPower = bcre.breakingPower;
    		this.emergencyBreakingPower = bcre.emergencyBreakingPower;
    		this.referencePosition = bcre.referencePosition;
	    	this.ssp = new StaticSpeedProfil(bcre);
	    	this.gradientProfil = GradientProfileConverter.package21ToAccGP(bcre.packet21, bcre.currentGradient);
	    	this.dangerPointOffset = MovementAuthorityConverter.p15ToDangerPointDistance(bcre.packet15);

	    	this.breakingCurveGroup = calculateBreakingCurve(bcre.packet15, bcre.id);

			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveGroup));
			this.bclreCan = true; //bclre can only be calculated after the first full request is done.
			this.isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bcre, bccbe));
    	}
    	catch(Exception e) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bcre, e));
    		this.breakingCurveGroup = new BreakingCurveGroup();
			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveGroup));
			this.isCalculating = false;
    	}
    }
    
    /**
     * This function listens to a {@link BreakingCurveLimitedRequestEvent}. method prepares
	 * the calculation of the service breaking curve by first calling {@link BreakingCurveCalculator#calculateKnotList(double, double, CurveType)}
	 * and then calls {@link BreakingCurveCalculator#getCurveFromList(List, Position, String)}<br>
	 * It then calculates additional breaking curves from this {@code List<Knot>} by shifting the knots with speed and time.
	 * This results in the permitted speed, warning speed, overspeed and intervention speed curves. <br>//TODO check which curves to use
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

    		this.breakingCurveGroup = calculateBreakingCurveGroupWIthShiftedPosition(bclre.packet15, bclre.id, bclre.referencePosition);

			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveGroup));
			this.isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bclre, bccbe));
    	}
    	catch(Exception e) {
			this.breakingCurveGroup = new BreakingCurveGroup();
			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurveGroup));
			this.isCalculating = false;
    	}
    }


    private BreakingCurveGroup calculateBreakingCurve(Packet_15 packet15, String id){
		return calculateBreakingCurveGroupWIthShiftedPosition(packet15, id, this.referencePosition);
	}

	private BreakingCurveGroup calculateBreakingCurveGroupWIthShiftedPosition(Packet_15 packet15, String id, Position referencePosition){
		BreakingCurveGroup breakingCurveGroup = new BreakingCurveGroup(id);

		double d_EMA = MovementAuthorityConverter.p15ToD_EMA(packet15) + referencePosition.totalDistanceToPreviousPosition(this.referencePosition);
		double v_loa = packet15.V_LOA * ETCS_VALUE_TO_MS;
		List<Knot> knotListEmergency = calculateKnotList(d_EMA, v_loa, CurveType.EMERGENCY_CURVE);
		List<Knot> knotListService = calculateKnotList(d_EMA, v_loa, CurveType.SERVICE_CURVE);
		List<Knot> knotListWarning = calculateKnotList(d_EMA, v_loa, CurveType.WARNING_CURVE);
		List<Knot> knotListPermittedSpeed = calculateKnotList(d_EMA, v_loa, CurveType.PERMITTED_SPEED);
		List<Knot> knotListIndicationSpeed = calculateKnotList(d_EMA, v_loa, CurveType.INDICATION_CURVE);

		breakingCurveGroup.setEmergencyDecelerationCurve(getCurveFromList(knotListEmergency,this.referencePosition, "EmergencyDecelerationCurve"));
		breakingCurveGroup.setEmergencyInterventionCurve(getCurveFromListAndOffset(knotListEmergency, this.ch.emergencyInterventionOffset,
				this.referencePosition, "EmergencyInterventionCurve"));

		breakingCurveGroup.setServiceDecelerationCurve(getCurveFromList(knotListService,this.referencePosition,"ServiceDecelerationCurve"));
		breakingCurveGroup.setServiceInterventionCurve(getCurveFromListAndOffset(knotListService, this.ch.serviceInterventionOffset,
				this.referencePosition,"ServiceInterventionCurve"));
		breakingCurveGroup.setServiceWarningCurve(getCurveFromListAndOffset(knotListWarning, this.ch.serviceWarningOffset,
				this.referencePosition,"ServiceWarningCurve"));
		breakingCurveGroup.setServicePermittedSpeedCurve(getCurveFromListAndOffset(knotListPermittedSpeed, this.ch.servicePermittedOffset,
				this.referencePosition,"ServicePermittedSpeedCurve"));
		breakingCurveGroup.setServiceIndicationCurve(getCurveFromListAndOffset(knotListIndicationSpeed, this.ch.serviceIndicationOffset,
				this.referencePosition,"ServiceIndicationCurve"));
		breakingCurveGroup.setServiceCoastingPhaseCurve(getCurveFromListAndOffset(knotListPermittedSpeed, this.ch.serviceCoastingPhaseOffset,
				this.referencePosition,"ServiceCoastingPhaseCurve"));
				//TODO Check if BCLRE still works

		return breakingCurveGroup;
	}
    
    
    /**
     * //TODO comment
     * @param refPosition
     * 		Reference Position
     * @param id
     * 		A String
     * @return
     * 		{@link BreakingCurve}
     */
    private BreakingCurve getCurveFromList( List<Knot> knotList, Position refPosition, String id ) {

    	BreakingCurve breakCurve = new BreakingCurve(refPosition.getLocation(), id);
    	for (Knot knot : knotList){
    		breakCurve.addKnotToCurve(knot);
		}
    	
    	return breakCurve;
    }

	/**
	 *	//TODO comment
	 * @param knotList
	 * 		A {@code List<Knot>} to be transformed into a @{@link BreakingCurve}
	 * @param offset
	 * 		An offset in [s]
	 * @param referencePosition
	 * 		the reference position of the curve
	 * @param id
	 * 		The id of the curve
	 * @return
	 * 		A breaking curve made from the shifted knots
	 */
    private BreakingCurve getCurveFromListAndOffset(List<Knot> knotList, double offset, Position referencePosition, String id){
		List<Knot> knotListCopy = new ArrayList<>();
		knotListCopy.addAll(knotList);
    	BreakingCurve breakingCurve = new BreakingCurve(referencePosition.getLocation(), id);
		Knot lastKnot = knotListCopy.remove(0);
		breakingCurve.addKnotToCurve(lastKnot);
		for (Knot knot : knotListCopy){

			double newX = knot.xValue - (knot.coefficients.get(0) * offset);
			double newSlope = 0;
			if(knot.coefficients.get(1) != 0){
				newSlope = (lastKnot.coefficients.get(0) - knot.coefficients.get(0)) / (lastKnot.xValue - newX);
			}

			double[] newCoefficents = {knot.coefficients.get(0), newSlope};

			Knot newKnot = new Knot(newX, newCoefficents);
			breakingCurve.addKnotToCurve(newKnot);

			lastKnot = newKnot;
		}


    	return breakingCurve;
	}

	/**
	 * This Function calculates a breaking curve out of all the given information. It uses the algorithm developed by Georg Boltz in "Einfaches Bremskurvenmodell" <br>
	 * <br>
	 * <br>
	 * Shorthands:
	 * EMA End of movement authority
	 *

	 * @param distanceToEMA
	 * 		Distance to the EMA
	 * @param speedAtEndOfMoveAut
	 * 		Maximal allowed speed at the EMA
	 * @return
	 * 		{@link BreakingCurve}
	 */
	private List<Knot> calculateKnotList(double distanceToEMA, double speedAtEndOfMoveAut, CurveType curveType)
			throws IllegalArgumentException, IndexOutOfBoundsException {
		List<Knot> knotList = new ArrayList<>();
		ForwardSpline breakingPower;
		double dis_EMA;
		if(curveType == CurveType.EMERGENCY_CURVE){
			breakingPower = this.emergencyBreakingPower;
			dis_EMA = distanceToEMA + this.dangerPointOffset;
		}
		else {
			breakingPower = this.breakingPower;
			dis_EMA = distanceToEMA;
		}

		double deltaspeed_init = 0.36;
		double deltaSpeed_init_min = deltaspeed_init * 0.1;

		double speed_EMA = speedAtEndOfMoveAut;

		if (speed_EMA > this.ssp.getSpeedAtDistance(dis_EMA, curveType)) {
			speed_EMA = this.ssp.getSpeedAtDistance(dis_EMA, curveType);
		}
		//s_EAP (see description of algorithm by Boltz) is in this calculation always 0, because we work relative to the current position

		double speedNow = speed_EMA;
		double disNow = dis_EMA;
		double disStar = 0d;
		double speedNext;
		ArrayList<Double> coefList;

		//Begin of logic
		while (disNow > 0) {
			double deltaSpeed = deltaspeed_init;

			while (speedNow < this.ssp.getSpeedAtDistance(disNow, curveType) && disNow > disStar) {
				speedNext = speedNow + deltaSpeed;

				if (speedNext > this.ssp.getSpeedAtDistance(disNow, curveType)) {
					speedNext = this.ssp.getSpeedAtDistance(disNow, curveType);
					deltaSpeed = speedNext - speedNow;
				}

				disStar = this.ssp.getLowerOrFirstKnotXValue(disNow); //This is "finding the next step s*" (see description of algorithm by Boltz)


				double speedMidpoint = 0.5 * (speedNext + speedNow);
				double breakPowerMidpoint = breakingPower.getPointOnCurve(speedMidpoint);

				double deltaTime = - (deltaSpeed / breakPowerMidpoint);
				double deltaDis = speedMidpoint * deltaTime;



				if (disNow + deltaDis < disStar) {
					deltaDis = disStar - disNow;
					deltaSpeed = -breakPowerMidpoint * deltaDis / speedMidpoint;
					speedMidpoint = speedNow + (0.5 * deltaSpeed);
					breakPowerMidpoint = breakingPower.getPointOnCurve(speedMidpoint);

				}

				double disMidpoint = disNow + (0.5 * deltaDis);
				breakPowerMidpoint += this.gradientProfil.getPointOnCurve(disMidpoint);

				if (breakPowerMidpoint <= 0) {
					if (this.gradientProfil.getPointOnCurve(disMidpoint).equals(-Double.MAX_VALUE)) {
						throw new IllegalArgumentException("The Movement Authority exceeded the maxium defined distance of the Gradient Profile");
					}
					else if (breakPowerMidpoint - this.gradientProfil.getPointOnCurve(disMidpoint) > 0){
						throw new IllegalArgumentException("The downhill slope surpassed the breaking ability of the train");
					}
					else {
						throw new IllegalArgumentException("Breaking force was smaller than 0 for unknown reason");
					}
				}

				if (deltaSpeed < deltaSpeed_init_min) {
					deltaSpeed = deltaSpeed_init_min;
				}

				deltaTime = - deltaSpeed/breakPowerMidpoint;

				deltaDis = deltaTime * speedMidpoint;


				if (disNow + deltaDis < disStar) {
					deltaDis = disStar - disNow;
					deltaTime = deltaDis / speedMidpoint;
					deltaSpeed = -breakPowerMidpoint * deltaTime;
				}

				double disNext = disNow + deltaDis;
				speedNext = speedNow + deltaSpeed;

				if(speedNext > this.ssp.getSpeedAtDistance(disNext, curveType)) {
					deltaSpeed = this.ssp.getSpeedAtDistance(disNext, curveType) - speedNow;
					speedNext = this.ssp.getSpeedAtDistance(disNext, curveType);
				}

				coefList = new ArrayList<>();
				coefList.add(speedNow);
				coefList.add(deltaSpeed / deltaDis);
				knotList.add(0, new Knot(disNow,coefList));

				disNow = disNext;
				speedNow = speedNext;
				deltaSpeed = deltaspeed_init;
			}

			if (disNow == 0) {break;}

			if (disStar < disNow) {
				coefList = new ArrayList<>();
				coefList.add(speedNow);
				coefList.add(0d);
				knotList.add(0, new Knot(disNow,coefList));
			}

			disNow = disStar;
			speedNow = Math.min(this.ssp.getSpeedAtDistance(disStar, curveType),speedNow);
			disStar = this.ssp.getLowerOrFirstKnotXValue(disStar);
		}

		coefList = new ArrayList<>();
		coefList.add(Math.min(this.ssp.getSpeedAtDistance(0d, curveType),speedNow));
		coefList.add(0d);
		knotList.add(0, new Knot(disNow,coefList));

		return knotList;
	}



}
