package ebd.breakingCurveCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveCalculatorBusyException;
import ebd.globalUtils.breakingCurveType.BreakingCurveType;
import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.etcsPacketConverters.GradientProfileConverter;
import ebd.globalUtils.etcsPacketConverters.MovementAuthorityConverter;
import ebd.globalUtils.spline.BackwardSpline;
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

	private final EventBus eventBus;
	private final String eventTarget;
	private ConfigHandler ch = ConfigHandler.getInstance();
	/**
	 * If set to false, the Emergency Intervention Curve will be equal to the Service Intervention Curve
	 */

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

	private BreakingCurve breakingCurve;

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
	 * the calculation of the service breaking curve by first calling {@link BreakingCurveCalculator#calculateKnotList(Packet_15, BreakingCurveType)}
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
	    	this.gradientProfil = GradientProfileConverter.packet21ToAccGP(bcre.packet21, bcre.currentGradient);

	    	this.breakingCurve = calculateBreakingCurve(bcre.packet15, bcre.id);

			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurve));
			this.bclreCan = true; //bclre can only be calculated after the first full request is done.
			this.isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bcre, bccbe));
    	}
    	catch(Exception e) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bcre, e));
    		this.breakingCurve = new BreakingCurve();
			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurve));
			this.isCalculating = false;
    	}
    }
    
    /**
     * This function listens to a {@link BreakingCurveLimitedRequestEvent}. method prepares
	 * the calculation of the service breaking curve by first calling {@link BreakingCurveCalculator#calculateKnotList(Packet_15, BreakingCurveType)}
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

    		this.breakingCurve = calculateBreakingCurveGroupWIthShiftedPosition(bclre.packet15, bclre.id, bclre.referencePosition);

			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurve));
			this.isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
			this.eventBus.post(new BreakingCurveExceptionEvent("bcc", this.eventTarget, bclre, bccbe));
    	}
    	catch(Exception e) {
			this.breakingCurve = new BreakingCurve();
			this.eventBus.post(new NewBreakingCurveEvent("bcc", this.eventTarget, this.breakingCurve));
			this.isCalculating = false;
    	}
    }


    private BreakingCurve calculateBreakingCurve(Packet_15 packet15, String id){
		return calculateBreakingCurveGroupWIthShiftedPosition(packet15, id, this.referencePosition);
	}

	private BreakingCurve calculateBreakingCurveGroupWIthShiftedPosition(Packet_15 packet15, String id, Position referencePosition){
		TreeMap<Double,CurveGroup> curveMap = new TreeMap<>();
		List<Double> slowDownList = this.ssp.listOfSlowDowns();



		for(Double slowDown : slowDownList){
			List<Knot> emergencyDecelerationCurve = calculateKnotList(slowDown,
					this.ssp.getSpeedAtDistance(slowDown,BreakingCurveType.EMERGENCY_INTERVENTION_CURVE),
					true);


		}

		double distanceToEOA = MovementAuthorityConverter.p15ToD_EMA(packet15);
		double speedAtEOA = packet15.V_LOA * ETCS_VALUE_TO_MS;
		List<Knot> serviceDecelerationCurve = calculateKnotList(distanceToEOA, speedAtEOA,false);

		double overlap = MovementAuthorityConverter.p15GetOverlapDistance(packet15);
		double dangerpoint = MovementAuthorityConverter.p15GetOverlapDistance(packet15);
		double distanceToSVL = distanceToEOA + (Math.max(overlap, dangerpoint));
		List<Knot> emergencyDecelerationCurve = calculateKnotList(distanceToSVL, 0d, true);


				//TODO Check if BCLRE still works

		return new BreakingCurve(this.referencePosition.getLocation(),this.ssp,curveMap);
	}
    
    

	/**
	 *	//TODO comment
	 * @param knotList
	 * 		A {@code List<Knot>} to be transformed into a @{@link BreakingCurve}
	 * @param offset
	 * 		An offset in [s]
	 * @return
	 * 		A breaking curve made from the shifted knots
	 */
    private BackwardSpline getCurveFromListAndOffset(List<Knot> knotList, double offset){
    	List<Knot> knotListCopy = new ArrayList<>(knotList);
    	List<Knot> tempKnotList = new ArrayList<>();
    	List<Integer> indexesOfKnotsToBeReset = new ArrayList<>();

    	//We get the first and last knot who have to be treated differently. The first knot gets added unchanged
		Knot lastKnot = knotListCopy.remove(knotListCopy.size()-1);
    	Knot formerKnot = knotListCopy.remove(0);
		tempKnotList.add(formerKnot);

		//We iterate through all other knots and determine the new xValue and slope for each of them.
		boolean bunchedKnots = false;
		for (Knot knot : knotListCopy){

			double newX = knot.xValue - (knot.coefficients.get(0) * offset);
			if(newX <= formerKnot.xValue && bunchedKnots){
				continue; //prevents multiple knots from bunching up

			}
			else if(newX <= formerKnot.xValue){
				bunchedKnots = true;
				indexesOfKnotsToBeReset.add(tempKnotList.size());
				newX = formerKnot.xValue + 0.001; //prevents knots from getting moved over a former knot
			}
			else {
				bunchedKnots = false;
			}

			double newSlope = 0;
			if(knot.coefficients.get(1) != 0){
				newSlope = (formerKnot.coefficients.get(0) - knot.coefficients.get(0)) / (formerKnot.xValue - newX);
			}

			double[] newCoefficents = {knot.coefficients.get(0), newSlope};

			Knot newKnot = new Knot(newX, newCoefficents);
			tempKnotList.add(newKnot);

			formerKnot = newKnot;
		}
		//Finally we add the last knot with unchanged xValue to pin the knot to the original knot. But we calculate a new slop.
		double newX = lastKnot.xValue;
		double newSlope = 0;
		if(lastKnot.coefficients.get(1) != 0){
			newSlope = (formerKnot.coefficients.get(0) - lastKnot.coefficients.get(0)) / (formerKnot.xValue - newX);
		}
		double[] newCoefficents = {lastKnot.coefficients.get(0), newSlope};
		Knot newKnot = new Knot(newX, newCoefficents);
		tempKnotList.add(newKnot);

		//We fix the y values and slopes of the bunched knots
		for(Integer index : indexesOfKnotsToBeReset){
			if(index >= tempKnotList.size() - 2){
				break;
			}
			Knot thisKnot = tempKnotList.get(index);
			Knot nextKnot = tempKnotList.get(index + 1);
			Knot resetKnot = new Knot(thisKnot.xValue,new  double[]{nextKnot.coefficients.get(0),0});
			tempKnotList.set(index,resetKnot);
		}

		BackwardSpline curve = new BackwardSpline(1);
		for(Knot knot : tempKnotList){
			curve.addKnotToCurve(knot);
		}
    	return curve;
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
	private List<Knot> calculateKnotList(double distanceToEnd, double speedAtEnd, boolean emergencyDecelerationCurve)
			throws IllegalArgumentException, IndexOutOfBoundsException {
		List<Knot> knotList = new ArrayList<>();
		ForwardSpline breakingPower;
		BreakingCurveType breakingCurveType;

		if(emergencyDecelerationCurve){
			breakingPower = this.emergencyBreakingPower;
			breakingCurveType = BreakingCurveType.EMERGENCY_INTERVENTION_CURVE;
		}
		else {
			breakingPower = this.breakingPower;
			breakingCurveType = BreakingCurveType.SERVICE_INTERVENTION_CURVE_1;
		}

		double deltaV_init = 0.2;

		double speed_EMA = speedAtEnd;

		if (speed_EMA > this.ssp.getSpeedAtDistance(distanceToEnd, breakingCurveType)) {
			speed_EMA = this.ssp.getSpeedAtDistance(distanceToEnd, breakingCurveType);
		}
		//s_EAP (see description of algorithm by Boltz) is in this calculation always 0,
		// because we work relative to the current position

		double vNow = speed_EMA;
		double sNow = distanceToEnd;
		double vNext;

		//Begin of logic
		while(sNow > 0){
			double deltaV = deltaV_init;
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
		}

		knotList.add( new Knot(0d, new double[]{ vNow, 0})); //Add KNOT

		return knotList;
	}

}
