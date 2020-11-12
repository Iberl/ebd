
package ebd.globalUtils.spline;

import ebd.globalUtils.spline.util.KnotCoefficientException;

import java.util.ArrayList;


/**
 * <p>
 * -1- This class represents a backwards spline curve.<br>
 * It uses a backwards linear spline model. Spline curves are defined as sums of polynomial functions each defining
 * part of the curve. Each function as a base point called knot and a list of coefficients describing the curve
 * between knots.<br>
 * For more detail: https://en.wikipedia.org/wiki/Spline_interpolation<br>
 * </p>
 * <p>
 * Backwards means that any given knot is greater in x than the part of the curve described by it.<br>   
 * -- Example:<br>
 * Given knots k1 (1, 4) with coefficient c1 and and k2 (5, 6) with coefficient c2. <br>
 * k1 and c1 describe the curve for all x-values <= 1 <br>
 * k2 and c2 describe the curve for all x-values 1 < x <= 5 <br>
 * The curve is not defined for x-values greater than 5 <br>
 * </p>
 * <p>
 * -2- Data structure:
 * The data structure is a TreeMap mapping Double to ArrayList 
 * 
 * The key is the x-value of a knot. <br>
 * The value is a list, with the first entry being the y-value of the knot (aka first coefficient c0),
 * with all other entries being c1, c2, c3 ... in order. <br>
 * 
 * A knot is added by passing an instance of Knot to the function addKnotToCurve.
 * </p>
 * 
 * @author Lars Schulze-Falck
 *
 */
public class BackwardSpline extends Spline {
	

		
	public BackwardSpline(int degree,String id) {
		this.id = id;
		setDegree(degree);
	}
	
	public BackwardSpline(int degree) {
		this.id = "noID";
		setDegree(degree);
	}
	
	
	/* (non-Javadoc)
	 * @see spline.Spline#getPointOnCurve(java.lang.Double)
	 */
	@Override
	public Double getPointOnCurve(Double xValue) {

		Double key = getCeilingKnotXValue(xValue);
		ArrayList<Double> coefficents = curve.get(key);
		Double deltaX = xValue - key;
		Double result = 0d;
		for (int i = 0; i < coefficents.size(); i++) {
			result += coefficents.get(i) * Math.pow(deltaX, i);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see spline.Spline#addKnotToCurve(spline.Knot)
	 */
	@Override
	public void addKnotToCurve(Knot knot) throws  KnotCoefficientException{
		if (knot.coefficients.size() > degree + 1) {
			throw new KnotCoefficientException("There where to many coefficients for this degree");
		}
		else if (knot.coefficients.size() < degree + 1) {
			throw new KnotCoefficientException("There where to few coefficients for this degree");
		}
		else {
			curve.put(knot.xValue, knot.coefficients);
		}
	}
	
	
	/**
	 * This function returns the interval boundary for a given x-value. In case the position is equal to a interval
	 * boundary, it will become the higher boundary, because the interval is left open, right closed.
	 * 
	 * @param xValue Any x-value lower or equal the highest knot of the curve
	 * @return Returns an ArrayList<Double>(2), first entry being the lower limit, second entry the higher limit
	 * @author Lars Schulze-Falck 
	 * 
	 */
	public ArrayList<Double> getIntervallBoundariesOfPoint(Double xValue){
		ArrayList<Double> retArray = new ArrayList<Double>(2);
		retArray.add(curve.lowerKey(xValue));
		retArray.add(curve.ceilingKey(xValue));
		return retArray;
	}
	
	/**
	 * Returns the highest key of the curve, which also is the end of the defined area for this curve
	 * @return Double Highest key of the curve
	 * 
	 */
	public Double getHighestXValue() {
		return curve.lastKey();
	}
		
	/**
	 * Returns the x-value of the next higher or equal knot.
	 *
	 * @param xValue The specified x-Value
	 * @return Double
	 * @throws IndexOutOfBoundsException Thrown when the specified x-value is higher than the x-value of the last knot
	 *
	 * @author Lars Schulze-Falck
	 */
	
	public Double getCeilingKnotXValue(Double xValue) throws IndexOutOfBoundsException{
		if (curve.ceilingKey(xValue) == null) {
			throw new IndexOutOfBoundsException(String.format("Input value (%f) is higher then the higest point (%f) in this curve",xValue,curve.lastKey()));	
		}
		return curve.ceilingKey(xValue);
	}

	/**
	 * Returns the distance after which the maximum speed of the breaking curve is always lower or equal then the given speed
	 * @param yThreshold Y value no part of the curve can be greater then after the returned x value.
	 * @return X value after which the curve is consistently lower then yThreshold.
	 * 			Returns {@link Double#POSITIVE_INFINITY} if no such value exists.
	 */
	//TODO Tests
	public double xValueAfterWhichYValueIsAlwaysLowerThen(double yThreshold){
		Double lastDist = this.curve.lastKey();
		double lastSpeed = this.curve.lastEntry().getValue().get(0);
		if(lastSpeed > yThreshold){
			return Double.POSITIVE_INFINITY;
		}
		if(lastSpeed == yThreshold){
			return lastDist;
		}
		//Iterating of the tree map to find the highest key with a lower value then yThreshold
		while(true){
			Double nextDist = this.curve.lowerKey(lastDist);
			if (nextDist == null) return 0d;

			double nextSpeed = this.curve.get(nextDist).get(0);
			if(nextSpeed >= yThreshold){
				return calculatePreciseIntersection(lastDist,yThreshold);
			}

			lastDist = nextDist;
		}

	}

	/**
	 * Calculates the precise point at which the curve takes a certain value bas on the knowledge of the next higher key.
	 * If the degree of the curve is greater than 1, it will use an numerical approach
	 *
	 * @param nextHigherKey The next higher key to the precise point
	 * @param yValue The value that the curve should be equal to
	 * @return the precise X-value at which the curve is equal to yValue
	 */
	private double calculatePreciseIntersection(double nextHigherKey, double yValue) {
		if(degree == 0) return nextHigherKey;
		else if(degree == 1){
			double knotSpeed = this.curve.get(nextHigherKey).get(0);
			double knotConstant = this.curve.get(nextHigherKey).get(1);

			return (yValue - knotSpeed) / knotConstant + nextHigherKey;
		}
		else{
			return calculateNumericalIntersection(nextHigherKey, yValue);
		}

	}

	/**
	 * Calculates the point at which the curve takes a certain value bas on the knowledge of the next higher key.
	 *
	 * @param nextHigherKey The next higher key to the precise point
	 * @param yValue The value that the curve should be equal to
	 * @return the precise X-value at which the curve is equal to yValue
	 */
	private double calculateNumericalIntersection(double nextHigherKey, double yValue){
		Double startXValue = this.curve.lowerKey(nextHigherKey);
		startXValue = (startXValue == null) ? 0 : startXValue;
		double endXValue = nextHigherKey;
		double curYValue = 0;

		while(true){
			double curXValue = (startXValue + endXValue) - 2;
			curYValue = getPointOnCurve(curXValue);

			if(Math.abs(curYValue - yValue) > 0.001) return curXValue;
			else if(curYValue > yValue) startXValue = curXValue;
			else endXValue = curXValue;
		}
	}
}
