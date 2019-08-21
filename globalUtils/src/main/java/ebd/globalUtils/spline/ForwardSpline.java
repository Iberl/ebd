package ebd.globalUtils.spline;

import java.util.ArrayList;

import ebd.globalUtils.spline.util.KnotCoefficientException;

/**
 * <p>
 * -1- This class represents a forward spline curve.<br>
 * It uses a forward linear spline model. Spline curves are defined as sums of polynomial functions each defining
 * part of the curve. Each function as a base point called knot and a list of coefficients describing the curve
 * between knots.
 * For more detail: https://en.wikipedia.org/wiki/Spline_interpolation<br>
 * </p>
 * <p>
 * Forward means that any given knot is smaller in x than the part of the curve described by it. <br> 
 * -- Example:<br>
 * Given knots k1 (1, 4) with coefficient c1 and and k2 (5, 6) with coefficient c2.<br>
 * The curve is not defined for x-values smaller than 1 <br>
 * k1 and c1 describe the curve for all x-values 1 <= x < 5 <br>
 * k2 and c2 describe the curve for all x-values 5 <= x <br>
 * </p>
 * <p>
 * -2- Data structure:<br>
 * The data structure is a TreeMap mapping Double to ArrayList 
 * 
 * The key is the x-value of a knot.<br>
 * The value is a list, with the first entry being the y-value of the knot (aka first coefficient c0),
 * with all other entries being c1, c2, c3 ... in order.<br>
 * 
 * A knot is added by passing an instance of Knot to the function addKnotToCurve.
 * </p>
 * 
 * @author Lars Schulze-Falck
 *
 */
public class ForwardSpline extends Spline {
	
	
	public ForwardSpline(String id, int degree) {
		this.id = id;
		setDegree(degree);
	}
	
	public ForwardSpline(int degree) {
		this.id = "noID";
		setDegree(degree);
	}
	
	
	/* (non-Javadoc)
	 * @see spline.Spline#getPointOnCurve(java.lang.Double)
	 */
	@Override
	public Double getPointOnCurve(Double xValue) {
		
		Double key = getLowerOrFirstKnotXValue(xValue);
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
		if (knot.coefficients.size() - 1 > degree) {
			throw new KnotCoefficientException("There where to many coefficients for this spline degree");
		}
		else if (knot.coefficients.size() - 1 < degree) {
			throw new KnotCoefficientException("There where to few coefficients for this spline degree");
		}
		else {
			curve.put(knot.xValue, knot.coefficients);
		}
	}
	
	/**
	 * This function returns the interval boundary for a given x-value. In case the position is equal to a interval
	 * boundary, it will become the lower boundary, because the interval is left closed, right open.
	 * One of these boundaries can be <b>null</b>, should the point is lies to the left or right of the curve.
	 * 
	 * @param xValue Any x-value higher or equal the lowest knot of the curve
	 * @return Returns an ArrayList, first entry being the lower limit, second entry the higher limit
	 * @author Lars Schulze-Falck 
	 * 
	 */
	
	public ArrayList<Double> getIntervallBoundariesOfPoint(Double xValue){
		ArrayList<Double> retArray = new ArrayList<Double>(2);
		retArray.add(this.curve.floorKey(xValue));
		retArray.add(this.curve.higherKey(xValue));
		return retArray;
	}
	
	/**
	 * Returns the lowest x-Value of the curve, which also is the start of the defined area for this curve
	 * @return Double lowest key of the curve
	 * 
	 */
	public Double getLowestXValue() {
		return curve.firstKey();
	}
	
	/**
	 * Returns the x-value of the next lower knot, unless the specified x-value is equal
	 * to the x-value of the first knot, at which the x-value of the first knot is returned.
	 * 
	 * 
	 * 
	 * @param xValue The specifid x-Value
	 * @return Double
	 * @throws IndexOutOfBoundsException Thrown when the specified x-value is smaller than the x-value of the first knot
	 *
	 * @author Lars Schulze-Falck
	 */
	
	public Double getLowerOrFirstKnotXValue(Double xValue) throws IndexOutOfBoundsException{
		if (curve.floorKey(xValue) == null) {			
			throw new IndexOutOfBoundsException(String.format("Input value (%f) is lower then the lowest point (%f) in this curve",xValue,curve.firstKey()));	
		}
		
		else if (curve.firstKey().equals(xValue)) {
			return curve.firstKey();
		}
		else {
			return curve.lowerKey(xValue);
		}
	}
}
