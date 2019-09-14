package ebd.breakingCurveCalculator;

import java.util.ArrayList;

import ebd.breakingCurveCalculator.utils.exceptions.BreakingCurveOutOfRangeException;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.position.exceptions.PositionReferenzException;
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
public class BreakingCurve extends BackwardSpline {
	
	/**
	 * 
	 */
	private Location refLocation;
	
	public BreakingCurve(Location refLocation) {
		super(1);
		setRefLocation(refLocation);
	}
	
	public BreakingCurve(Location refLocation, String id) {
		super(1, id);
		
		setRefLocation(refLocation);
	}
	
	
	/**
	 * This function finds any point on the breaking curve
	 * 
	 * @param relativeLocation Any position inside the bounds of the breaking curve
	 * 
	 * @return Returns an ArrayList<double>, the first entry being the given position and the second entry 
	 * 			being speed at this position
	 * 
	 * @throws BreakingCurveOutOfRangeException Is being thrown when the given position is outside
	 * 			the bounds of the breaking curve, either < 0 or greater than curve.lastKey()
	 */
	@Override
	public Double getPointOnCurve(Double relativeLocation) throws BreakingCurveOutOfRangeException{
		
		if (relativeLocation < 0) {
			throw new BreakingCurveOutOfRangeException("Given position was smaller then 0");
		}
				
		Double knotPosition = curve.higherKey(relativeLocation);
		
		if (knotPosition == null) {
			
			if (relativeLocation.equals(curve.lastKey())) {
				knotPosition = curve.lastKey();
			}
			else throw new BreakingCurveOutOfRangeException("Given position was greater than the range of this breaking curve");
		}
		
		ArrayList<Double> knotValue = curve.get(knotPosition);
			
		
		return (relativeLocation - knotPosition) * knotValue.get(1) + knotValue.get(0);
	}
	
	/**
	 * This function returns the interval boundary for a given position. In case the position is equal to a interval
	 * boundary, it will become the higher boundary, because the interval is left open, right closed.
	 * 
	 * @param relativePosition Any position greater 0 inside the bounds of the breaking curve
	 * @return Returns an ArrayList<Double>(2), first entry being the lower limit, second entry the higher limit
	 * @throws BreakingCurveOutOfRangeException Is being thrown when the given position is outside
	 * 			the bounds of the breaking curve, either <= 0 or greater than curve.lastKey()
	 */
	@Override
	public ArrayList<Double> getIntervallBoundariesOfPoint(Double relativePosition) throws BreakingCurveOutOfRangeException {
	
		if (relativePosition <= 0) {
			throw new BreakingCurveOutOfRangeException("Given position was smaller or equal 0");
		}
			
		Double lowerBoundary = curve.lowerKey(relativePosition);
		if (lowerBoundary == null) {
			lowerBoundary = (double) 0;
		}
		
		Double higherBoundary = curve.ceilingKey(relativePosition);
		if (higherBoundary == null) {
			throw new BreakingCurveOutOfRangeException("Given position was greater than the range of this breaking curve"); 
		}
		
		ArrayList<Double> intervalBoundarys = new ArrayList<>(2);
		intervalBoundarys.add(lowerBoundary);
		intervalBoundarys.add(higherBoundary);
		
		return intervalBoundarys;	
	}

	
	
	/**
	 * 
	 * This function returns the maximum allowed Speed at a given Position. This position must either reference the same location
	 * or have the location in its list of previous locations and must be at least at far in the direction of travel.
	 * In other  words, the asked position can not lay before the reference location in direction of travel.
	 * 
	 * @param position The asked for {@link Position}
	 *
	 *
	 * @return Double The maximum allowed speed at the asked for Position in [m/s]
	 *
	 * @throws PositionReferenzException Thrown should the given position can not resolve the distance to the reference location
	 *
	 *
	 * @author Lars Schulze-Falck
	 */
	public Double getMaxSpeedAtRelativePosition(Position position) throws PositionReferenzException{
		
		Double distanceToReferenceLocation = position.totalDistanceToPastLocation(refLocation.getId());
		
		return getPointOnCurve(distanceToReferenceLocation);
	}
	
	/**
	 * @return the reference position
	 */
	public Location getRefLocation() {
		return refLocation;
	}

	/**
	 * @param refLocation the reference position to set
	 */
	private void setRefLocation(Location refLocation) {
		this.refLocation = refLocation;
	}
	
}
