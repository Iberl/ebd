package ebd.globalUtils.spline;

import ebd.globalUtils.spline.util.KnotCoefficientException;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * This implementation is based on the mathematical model of a Spline, which describes curves piecewise with polynomials.
 * In difference to this model, this implementation does not make sure that the curves are continuous, because these splines are not used analytical.
 * The Spline class itself warps a {@link TreeMap}.
 * 
 * @author Lars Schulze-Falck
 * @version 1.0
 *
 */
public abstract class Spline {
	
	/**
	 * Variable that represents the degree of the spline, in other words, the amount of . 
	 */
	protected int degree;
	
	
	protected String id;
	public TreeMap<Double,ArrayList<Double>> curve = new TreeMap<Double,ArrayList<Double>>();
		
	/**
	 * This function returns a point from a given x-value.
	 * @param xValue The x-Value of the point
	 * @return Double y-value of the curve at x-value
	 * @throws IndexOutOfBoundsException When the requested point is outside the defined area of this curve
	 * @author Lars Schulze-Falck
	 */	 
	abstract public Double getPointOnCurve(Double xValue);
		
	/**
	 * Addes a knot to the curve, uses the class Knot.
	 * Uses {@link Spline#degree} to check if the coefficient list has the right amount of values
	 * 
	 * @param knot An instance of Knot
	 * @throws KnotCoefficientException When the amount of coefficients does not match the chosen degree
	 * @author Lars Schulze-Falck 
	 */	
	abstract public void addKnotToCurve(Knot knot);

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Id: " + id + ", Degree: " + degree + "\n");
		for (Map.Entry<Double,ArrayList<Double>> entry : curve.entrySet()){
			sb.append("Key: ").append(entry.getKey()).append("; Coefficients: ");
			for(double coef : entry.getValue()){
				sb.append(coef).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Returns the ID of this curve
	 * @return String
	 */
	public String getID() {
		return id;
	}

	/**
	 * Returns the degree of the spline. A spline as degree + 1 coefficients.
	 * @return int
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * Sets the ID of this curve
	 * @param id String
	 */
	protected void setID(String id) {
		this.id = id;
	}

	protected void setDegree(int degree) {
		this.degree = degree;
	}


}
