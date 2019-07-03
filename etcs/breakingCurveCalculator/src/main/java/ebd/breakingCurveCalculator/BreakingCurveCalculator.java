package ebd.breakingCurveCalculator;

import java.util.ArrayList;
import java.util.List;

import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveCalculatorBusyException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ebd.breakingCurveCalculator.utils.GradientProfileConverter;
import ebd.breakingCurveCalculator.utils.MovementAuthorityConverter;
import ebd.breakingCurveCalculator.utils.StaticSpeedProfil;
import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveSetupException;
import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.globalUtils.events.bcc.BreakingCurveLimitedRequestEvent;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.location.Location;
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
	private List<String> eventTargets = new ArrayList<>();
	
	private boolean bclreCan = false;
	private boolean isCalculating = false;

    private ForwardSpline breakingPower;
    private ForwardSpline ssp;
    private ForwardSpline gradientProfile;
    private Position referencePosition;
    private EventBus eventBus;
    
    private BreakingCurve breakingCurve;
    
    /**
     * This constructor takes an EventBus object and registers the instance on it 
     * @param eventBus
     * 		The local eventBus
     */
    public BreakingCurveCalculator(EventBus eventBus) {
    	this.eventBus = eventBus;
    	eventBus.register(this);
    	eventTargets.add("tsm;");
    }

    /**
     * This function listens to a {@link BreakingCurveRequestEvent}. If such an event occurs, this method prepares the calculation of the breaking curve and 
     * calls {@link BreakingCurveCalculator#calculate(ForwardSpline, ForwardSpline, Position, double, double, String)}<br>
     * It also provides a weak protection against multiple concurrent calls to this function. This function should only be called again 
     * after a {@link NewBreakingCurveEvent} occures<br>
     * After finishing the calculation, this methods posts a {@link NewBreakingCurveEvent}
     * @param bcre
     *		{@link BreakingCurveRequestEvent}
     * @author Lars Schulze-Falck
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void calculateBreakingCurve(BreakingCurveRequestEvent bcre) {
    	try {
    		if(isCalculating) {
    			throw new BreakingCurveCalculatorBusyException("BCC is already calculating a curve. Do only post new BreakingCurveRequestEvents "
    					+ "after a NewBreakingCurveEvent was postet. This request will be ignored");
    		}else {
    			isCalculating = true;
    		}
    		this.breakingPower = bcre.breakingPower;
    		this.referencePosition = bcre.referencePosition;
	    	this.ssp = new StaticSpeedProfil(bcre);
	    	this.gradientProfile = GradientProfileConverter.package21ToGP(bcre.packet21, bcre.currentGradient);
	    	
	    	double d_EMA = MovementAuthorityConverter.p15ToD_EMA(bcre.packet15);
	    	double v_loa = bcre.packet15.V_LOA * ETCS_VALUE_TO_MS;
	    	
	    	breakingCurve = calculate(ssp, gradientProfile, this.referencePosition, d_EMA, v_loa , bcre.id);
	    	eventBus.post(new NewBreakingCurveEvent("bcc", eventTargets, breakingCurve));
	    	bclreCan = true; //bclre can only be calculated after the first full request is done.
	    	isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", eventTargets, bcre, bccbe));
    	}
    	catch(Exception e) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", eventTargets, bcre, e));
    		breakingCurve = new BreakingCurve(new Location("Unknown",null,null),"ERROR");
    		breakingCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
    		breakingCurve.addKnotToCurve(new Knot(Double.MAX_VALUE, new double[]{0d,0d}));
    		eventBus.post(new NewBreakingCurveEvent("bcc", eventTargets, breakingCurve));
    		isCalculating = false;
    	}
    }
    
    /**
     * This function listens to a {@link BreakingCurveLimitedRequestEvent}. If such an event occurs, this method prepares the calculation of the breaking curve and 
     * calls {@link BreakingCurveCalculator#calculate(ForwardSpline, ForwardSpline, Position, double, double, String)}<br>
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
    public void calculateBreakingCurve(BreakingCurveLimitedRequestEvent bclre) {
    	try {
    		if(isCalculating) {
    			throw new BreakingCurveCalculatorBusyException("BCC is already calculating a curve. Do only post new BreakingCurveLimitedRequestEvents "
    					+ "after a NewBreakingCurveEvent was posted. This request will be ignored");
    		}if(!bclreCan) {
    			throw new BreakingCurveSetupException("A BreakingCurveLimitedRequestEvent can only be used after a BreakingCurve was caluculated");
    		}
    		else {
    			isCalculating = true;
    		}
	    	double d_EMA = MovementAuthorityConverter.p15ToD_EMA(bclre.packet15) + bclre.referencePosition.totalDistanceToPreviousPosition(this.referencePosition);
	    	double v_loa = bclre.packet15.V_LOA * ETCS_VALUE_TO_MS;
	    	System.out.println(String.format("d_EMA: %f; v_loa: %f", d_EMA, v_loa));
	    	this.breakingCurve = calculate(ssp, gradientProfile, this.referencePosition, d_EMA, v_loa, bclre.id);
	    	eventBus.post(new NewBreakingCurveEvent("bcc", eventTargets, breakingCurve));
	    	isCalculating = false;
    	}
    	catch(BreakingCurveCalculatorBusyException bccbe) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", eventTargets, bclre, bccbe));
    	}
    	catch(Exception e) {
    		eventBus.post(new BreakingCurveExceptionEvent("bcc", eventTargets, bclre, e));
    		breakingCurve = new BreakingCurve(new Location("Unknown",null,null),"ERROR");
    		breakingCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
			breakingCurve.addKnotToCurve(new Knot(Double.MAX_VALUE, new double[]{0d,0d}));
    		eventBus.post(new NewBreakingCurveEvent("bcc", eventTargets,breakingCurve));
    		isCalculating = false;
    	}
    }

    
    
    /**
     * This Function calculates a breaking curve out of all the given information. It uses the algorithm developed by Georg Boltz in "Einfaches Bremskurvenmodell" <br>
     * 
     * Shorthands:
     * EMA End of movement authority
     * 
     * @param staticSpeedProfil
     * 		{@link StaticSpeedProfil}
     * @param gradientProfil
     * 		A profile that contains distances in [m] and acceleration in [m/s²]
     * @param endOfMoveAuth
     * 		Distance to the EMA
     * @param speedAtEndOfMoveAut
     * 		Maximal allowed speed at the EMA
     * @param refPosition
     * 		Reference Position
     * @param id
     * 		A String
     * @return
     * 		{@link BreakingCurve}
     */
    private BreakingCurve calculate(ForwardSpline staticSpeedProfil, ForwardSpline gradientProfil, Position refPosition, double endOfMoveAuth,  double speedAtEndOfMoveAut,  String id)
    	throws IllegalArgumentException, IndexOutOfBoundsException {
  	

    	BreakingCurve breakCurve = new BreakingCurve(refPosition.getLocation(), id);
    	double dis_EMA = endOfMoveAuth;
    	
    	
    	double deltaspeed_init = 0.36;
    	double deltaSpeed_init_min = deltaspeed_init * 0.1;
    	
    	double speed_EMA = speedAtEndOfMoveAut;

    	if (speed_EMA > staticSpeedProfil.getPointOnCurve(dis_EMA)) {
    		speed_EMA = staticSpeedProfil.getPointOnCurve(dis_EMA);
    	}
    	//s_EAP (see description of algorithm by Boltz) is in this calculation always 0, because we work relative to the current position
    	
    	double speedNow = speed_EMA;
    	double disNow = dis_EMA;
    	double disNext = disNow;
    	double disStar = 0d;
    	double speedNext;
    	ArrayList<Double> coefList;
    	
    	while (disNow > 0) {
    		double deltaSpeed = deltaspeed_init;
    		
    		while (speedNow < staticSpeedProfil.getPointOnCurve(disNow) && disNow > disStar) {
    			speedNext = speedNow + deltaSpeed;
    			
    			if (speedNext > staticSpeedProfil.getPointOnCurve(disNow)) {
    				speedNext = staticSpeedProfil.getPointOnCurve(disNow);
    				deltaSpeed = speedNext - speedNow;    				
    			}
    			
    			disStar = staticSpeedProfil.getLowerOrFirstKnotXValue(disNow); //This is "finding the next step s*" (see description of algorithm by Boltz)
    			
    			
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
    			breakPowerMidpoint += gradientProfil.getPointOnCurve(disMidpoint);
    			
    			if (breakPowerMidpoint <= 0) {
    				if (gradientProfil.getPointOnCurve(disMidpoint).equals(-Double.MAX_VALUE)) {
    					throw new IllegalArgumentException("The Movement Authority exceeded the maxium defined distance of the Gradient Profile");
    				}
    				else if (breakPowerMidpoint - gradientProfil.getPointOnCurve(disMidpoint) > 0){
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
    			
    			disNext = disNow + deltaDis;
    			speedNext = speedNow + deltaSpeed;
    			
    			if(speedNext > staticSpeedProfil.getPointOnCurve(disNext)) {
    				deltaSpeed = staticSpeedProfil.getPointOnCurve(disNext) - speedNow;
    				speedNext = staticSpeedProfil.getPointOnCurve(disNext);
    			}
    			
    			coefList = new ArrayList<>();
    			coefList.add(speedNow);
    			coefList.add(deltaSpeed / deltaDis);
    			breakCurve.addKnotToCurve(new Knot(disNow,coefList));
    		
    			disNow = disNext;
    			speedNow = speedNext;
    			deltaSpeed = deltaspeed_init;    		
    		}
    		
    		if (disNow == 0) {break;}
    		
    		if (disStar < disNow) {
    			coefList = new ArrayList<>();
    			coefList.add(speedNow);
    			coefList.add(0d);
    			breakCurve.addKnotToCurve(new Knot(disNow,coefList));
    		}
    		
    		disNow = disStar;
    		speedNow = Math.min(staticSpeedProfil.getPointOnCurve(disStar),speedNow);
    		disStar = staticSpeedProfil.getLowerOrFirstKnotXValue(disStar);
    	}
    	
    	coefList = new ArrayList<>();
		coefList.add(Math.min(staticSpeedProfil.getPointOnCurve(0d),speedNow));
		coefList.add(0d);
		breakCurve.addKnotToCurve(new Knot(disNow,coefList));
    	
    	return breakCurve;
    }
}
