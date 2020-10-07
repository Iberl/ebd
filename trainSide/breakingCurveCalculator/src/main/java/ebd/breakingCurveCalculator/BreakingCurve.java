package ebd.breakingCurveCalculator;

import java.util.TreeMap;

import ebd.breakingCurveCalculator.utils.StaticSpeedProfil;
import ebd.globalUtils.breakingCurveType.BreakingCurveType;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import ebd.globalUtils.spline.BackwardSpline;

/**
 * <p>
 * -1- This class represents a breaking curve. <br>
 * It uses a backwards linear spline model. It is a collection of knots (x,y) with a single coefficient describing
 * the curve between two knots. Backwards means that any given knot is greater in x than the part of the curve 
 * described by it.   
 * </p>
 * <p>
 * -- Example: <br>
 * Given knots k1 (1, 10) with coefficient c1 and k2 (5, 6) with coefficient c2. <br>
 * k1 and c1 describe the curve for all x-values <= 1 <br>
 * k2 and c2 describe the curve for all x-values 1 < x <= 5 <br>
 * The curve is not defined for x-values greater than 5 <br>
 * 
 * Because the use case of this class, all x-values are called position and all y-values are called speed.   
 * </p>
 * <p>
 * -2- Data structure: <br>
 * The data structure is a TreeMap mapping Double to ArrayList 
 * 
 * The key is the x-value of a knot. <br>
 * The value is a list, with the first entry being the y-value of the knot (aka first coefficient c0),
 * with the other entry being c1. <br>
 * 
 * A knot is added by passing an instance of Knot to the function addKnotToCurve.
 * </p>
 * </p>
 * <p>
 * -3- ID:
 * The class can have a ID in form of a string for identification
 * </p>
 * 
 * @author Lars Schulze-Falck
 *
 */
public class BreakingCurve {
	
	/**
	 * Reference location of the breaking curve
	 */
	private Location refLocation;

	/**
	 * If true, this is a Emergency Breaking Deceleration (EBD) Curve, if false, a Service Breaking Deceleration SBD curve.
	 */
	private boolean ebd;

	private StaticSpeedProfil ssp;

	private TreeMap<Double, CurveGroup> curveMap;

	/**
	 * Creates a BreakingCurve that includes all speed restriction data.
	 * @param refLocation Reference {@link Location} for the curve, in other words the start point of the curve.
	 * @param ssp The connected {@link StaticSpeedProfil}
	 * @param curveMap A {@link TreeMap} of type {@code TreeMap<Double, BackwardSpline>},
	 *                 connecting deceleration with distances in [m] between refLocation and the food of the curve.
	 */
	public BreakingCurve(Location refLocation, StaticSpeedProfil ssp, TreeMap<Double, CurveGroup> curveMap) {
		this.refLocation = refLocation;
		this.ssp = ssp;
		this.curveMap = curveMap;
	}

	/**
	 * Returns the current allowed speed at a given distance. The kind of speed depends on the given {@link BreakingCurveType}.
	 * If for example, given {@link BreakingCurveType#EMERGENCY_INTERVENTION_CURVE}, the current maximum speed before an emergency break
	 * intervention will be returned. <br>
	 *     This will return the correct value in either  {@link SpeedSupervisionState#CEILING_SPEED_SUPERVISION}
	 *     or {@link SpeedSupervisionState#TARGET_SPEED_SUPERVISION}<br>
	 *
	 * @param distance Distance from reference location in [m]
	 * @param breakingCurveType The type of curve that is queried.
	 * @return Speed in [m/s]
	 */
	public double getSpeedAtDistance(double distance, BreakingCurveType breakingCurveType){
		double sspSpeed = this.ssp.getSpeedAtDistance(distance, breakingCurveType);
		double bcSpeed = getSpeedFromBCCurve(distance,breakingCurveType);
		return Math.min(sspSpeed,bcSpeed);
	}

	public SpeedSupervisionState getSpeedSupervisionState(double distance){
		double sspSpeed = this.ssp.getSpeedAtDistance(distance,BreakingCurveType.EMERGENCY_INTERVENTION_CURVE);
		double indiSpeed = getSpeedFromBCCurve(distance,BreakingCurveType.INDICATION_CURVE);
		if( sspSpeed > indiSpeed){
			return SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
		}
		else return SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("BreakingCurve{" +
				"refLocation=" + refLocation.getId() +
				", ebd=" + ebd +
				'}');
		return sb.toString();
	}

	private double getSpeedFromBCCurve(double distance, BreakingCurveType curveType) {
		CurveGroup cg = this.curveMap.ceilingEntry(distance).getValue();
		BackwardSpline bs = switch (curveType){
			case C30_CURVE -> cg.getC30Curve();
			case NORMAL_CURVE -> cg.getNormalBreakingCurve();
			case INDICATION_CURVE -> cg.getIndicationCurve();
			case PERMITTED_SPEED -> cg.getPermittedSpeedCurve();
			case WARNING_CURVE -> cg.getWarningCurve();
			case SERVICE_INTERVENTION_CURVE -> cg.getServiceInterventionCurve();
			case EMERGENCY_INTERVENTION_CURVE -> cg.getEmergencyInterventionCurve();
			default -> throw new IllegalStateException("Curve type not known: " + curveType);
		};

		return bs.getPointOnCurve(distance);
	}

	/*
	Getter
	 */
	public Location getRefLocation() {
		return refLocation;
	}

	public boolean isEbd() {
		return ebd;
	}

}
