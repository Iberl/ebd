package ebd.breakingCurveCalculator;


import ebd.breakingCurveCalculator.utils.CurveGroup;
import ebd.breakingCurveCalculator.utils.EmptyCurveGroup;
import ebd.breakingCurveCalculator.utils.StaticSpeedProfil;
import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveOutOfRangeException;
import ebd.globalUtils.enums.CurveType;
import ebd.globalUtils.enums.SpeedSupervisionState;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.spline.BackwardSpline;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

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
	private final String id;

	private final Location refLocation;

	private final StaticSpeedProfil ssp;

	private final TreeMap<Double, CurveGroup> curveMap;

	public BreakingCurve(){
		this.id = "emptyBreakingCurve";
		this.refLocation = new InitalLocation();
		this.ssp = new StaticSpeedProfil(Arrays.asList(0d,0d));
		TreeMap<Double,CurveGroup> cm = new TreeMap<>();
		cm.put(0d, new EmptyCurveGroup());
		this.curveMap = cm;
	}

	/**
	 * Creates a BreakingCurve that includes all speed restriction data.
	 * @param refLocation Reference {@link Location} for the curve, in other words the start point of the curve.
	 * @param ssp The connected {@link StaticSpeedProfil}
	 * @param curveMap A {@link TreeMap} of type {@code TreeMap<Double, BackwardSpline>},
	 *                 connecting deceleration with distances in [m] between refLocation and the food of the curve.
	 */
	public BreakingCurve(String id, Location refLocation, StaticSpeedProfil ssp, TreeMap<Double, CurveGroup> curveMap) {
		this.id = id;
		this.refLocation = refLocation;
		this.ssp = ssp;
		this.curveMap = curveMap;
	}

	/**
	 * Returns the current allowed speed at a given distance. The kind of speed depends on the given {@link CurveType}.
	 * If for example, given {@link CurveType#EMERGENCY_INTERVENTION_CURVE}, the current maximum speed before an emergency break
	 * intervention will be returned. <br>
	 *     For this, both the breaking curve and the ssp will be checked and the lost value found returned.<br>
	 * The value of the parameter {@code distance} has to be between 0 and the greatest defined distance as
	 * returned by {@link BreakingCurve#endOfDefinedDistance()} inklusive.
	 *
	 *
	 * @param distance Distance from reference location in [m], has to be >= 0 and <= the last key.
	 * @param curveType The type of curve that is queried.
	 * @return Speed in [m/s]
	 */
	public double getSpeedAtDistance(double distance, CurveType curveType){
		if(distance < 0 || distance > this.curveMap.lastKey()) throw new BreakingCurveOutOfRangeException("Distance value out of range, was: " + distance);
		double sspSpeed = this.ssp.getSpeedAtDistance(distance, curveType);
		double bcSpeed = getSpeedFromBCCurveMap(distance, curveType);
		return Math.min(sspSpeed,bcSpeed);
	}

	public double getVmrspAtDistance(double distance, CurveType curveType){
		return this.ssp.getSpeedAtDistance(distance, curveType);
	}

	/**
	 * Returns the distance between the reference location and the next target in [m]
	 * @param distance current distance of the train in [m]
	 * @return Distance in [m]
	 */
	public double nextTargetDistance(double distance){
		if(distance < 0) throw new BreakingCurveOutOfRangeException("Distance value has to be > 0, was: " + distance);

		Double distanceAtTarget = this.curveMap.higherKey(distance);
		if(distanceAtTarget == null) distanceAtTarget = endOfDefinedDistance();

		BackwardSpline permittedSpeedCurve = this.curveMap.get(distanceAtTarget).getCurveFromType(CurveType.PERMITTED_SPEED);
		if(permittedSpeedCurve == null) return 0;


		double targetSpeed = permittedSpeedCurve.getPointOnCurve(distanceAtTarget);
		double lowestSpeed = getSpeedAtDistance(distanceAtTarget, CurveType.PERMITTED_SPEED);

		if(lowestSpeed < targetSpeed){
			return nextTargetDistance(distanceAtTarget);
		}
		else return distanceAtTarget;
	}

	/**
	 *
	 * @param curDistance Current distance in [m]
	 * @param curSpeed Current Speed in [m/s]
	 * @return Either {@link SpeedSupervisionState#CEILING_SPEED_SUPERVISION} or {@link SpeedSupervisionState#TARGET_SPEED_SUPERVISION}
	 */
	public SpeedSupervisionState getSpeedSupervisionState(double curDistance, double curSpeed){
		if(curDistance < 0) throw new BreakingCurveOutOfRangeException("Distance value has to be > 0, was: " + curDistance);
		double indiSpeed = getSpeedFromBCCurveMap(curDistance, CurveType.INDICATION_CURVE);
		if( curSpeed < indiSpeed){
			return SpeedSupervisionState.CEILING_SPEED_SUPERVISION;
		}
		else return SpeedSupervisionState.TARGET_SPEED_SUPERVISION;
	}

	/**
	 * The {@link BreakingCurve} is defined between 0 and end of defined distance.
	 * @return Distance in [m].
	 */
	public double endOfDefinedDistance(){
		return this.curveMap.lastKey();
	}

	/**
	 * Returns the last distance after which the maximum speed of the curve with the given type is always lower or equal then the given speed
	 * before the end of the curve
	 * @param testSpeed in [m/s]
	 * @return In [m]. Returns {@link Double#POSITIVE_INFINITY} if no part of the breaking curve is lower then the given speed
	 */
	//TODO Tests
	public Double getDistanceSpeedAlwaysLower(double testSpeed, CurveType type){

		BackwardSpline curve = this.curveMap.lastEntry().getValue().getCurveFromType(type);
		if(curve == null) return Double.POSITIVE_INFINITY;
		return curve.xValueAfterWhichYValueIsAlwaysLowerThen(testSpeed);
	}

	/**
	 * Returns the last distance after which the maximum speed of the curve with the given type is always lower or equal then the given speed
	 * before the given target.
	 * @param testSpeed in [m/s]
	 * @param targetDistance in [m] pointing at a target.
	 * @param type The type of curved to be used
	 * @return In [m]. Returns {@link Double#POSITIVE_INFINITY} if no part of the breaking curve is lower then the given speed or target was not found
	 */
	public Double getDistanceSpeedAlwaysLower(double testSpeed, double targetDistance, CurveType type){

		BackwardSpline curve = this.curveMap.get(targetDistance).getCurveFromType(type);
		if(curve == null) return Double.POSITIVE_INFINITY;
		return curve.xValueAfterWhichYValueIsAlwaysLowerThen(testSpeed);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("BreakingCurve{" +
				"string=" + id + " " +
				"refLocation=" + refLocation.getId() +
				'}');
		return sb.toString();
	}

	/**
	 * Returns a String containing a description on the first line and a data point per line after the first line.
	 * Every data point has the format of value1 | value2 | ... | value9.<br>
	 *     In order, these are distance and then the speeds of the different curves in order of their ranking (s. {@link CurveType}).<br>
	 * If there is no associated speed, the value will be set to -1<br>
	 * @return A {@link String}
	 */
	public String toStringMinimumSpeed(){
		double maxDistance = this.curveMap.lastKey();
		String firstLine = "x in [m], v in [m/s] \n";
		String secondLine = String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s %n",
				"x",
				"v_" + CurveType.EMERGENCY_INTERVENTION_CURVE.toString(),
				"v_" + CurveType.SERVICE_INTERVENTION_CURVE_2.toString(),
				"v_" + CurveType.SERVICE_INTERVENTION_CURVE_1.toString(),
				"v_" + CurveType.NORMAL_INTERVENTION_CURVE.toString(),
				"v_" + CurveType.WARNING_CURVE.toString(),
				"v_" + CurveType.PERMITTED_SPEED.toString(),
				"v_" + CurveType.INDICATION_CURVE.toString(),
				"v_" + CurveType.C30_CURVE.toString()
				);
		String line = "%8.2f | %4.2f | %4.2f | %4.2f | %4.2f | %4.2f | %4.2f | %4.2f | %4.2f %n" ;

		StringBuilder sb = new StringBuilder(firstLine).append(secondLine);

		for (double d = 0d; d <= maxDistance; d += 0.5){
			double[] values = new double[9];
			values[0] = d;
			for(CurveType type : CurveType.values()){
				values[type.getRanking() + 1] = getSpeedAtDistance(d, type);
			}
			sb.append(String.format(Locale.ROOT, line, values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]));
		}

		return sb.toString();
	}

	/**
	 * A String containing all knots from all curves in curveMap.
	 * @return A {@link String}
	 */
	public String toStringAllKnots(){

		StringBuilder sb = new StringBuilder();

		sb.append("START SSP:0\n");
		sb.append(this.ssp.toString());
		sb.append("END\n");
		int counter = 0;
		for(Map.Entry<Double,CurveGroup> entry : this.curveMap.entrySet()) {
			for (CurveType type : CurveType.values()) {
				BackwardSpline curve = entry.getValue().getCurveFromType(type);
				if(curve == null) continue;
				sb.append("START ").append(type.toString()).append(":").append(counter).append("\n");
				sb.append(curve.toString());
				sb.append("END\n");
			}
			counter++;
		}
		return sb.toString();
	}

	/**
	 * @param offset Offset of current trip section to trip start.
	 * @return A String representing the {@link StaticSpeedProfil}, formatted for use with DMI.
	 */
	public String getSspDMIString(double offset){
		return this.ssp.toDMIString(offset);
	}




	/**
	 * Returns the lowest speed of a given Type at a given distance. If that type has no speed at that distance,
	 * {@link Double#POSITIVE_INFINITY} is returned instead.
	 * @param distance Distance in [m]
	 * @param curveType {@link CurveType}
	 * @return speed in [m/s] of {@link Double#POSITIVE_INFINITY}
	 */
	private double getSpeedFromBCCurveMap(double distance, CurveType curveType) {
		double minimumSpeed = Double.POSITIVE_INFINITY;
		for(Double point : this.curveMap.keySet()){
			if(point < distance) continue;

			CurveGroup cg = this.curveMap.get(point);
			BackwardSpline bs = cg.getCurveFromType(curveType);
			if(bs == null) return minimumSpeed;
			minimumSpeed = Math.min(bs.getPointOnCurve(distance),minimumSpeed);
		}
		return minimumSpeed;
	}

	/*
	Getter
	 */
	public Location getRefLocation() {
		return this.refLocation;
	}

	public String getID() {
		return this.id;
	}
}
