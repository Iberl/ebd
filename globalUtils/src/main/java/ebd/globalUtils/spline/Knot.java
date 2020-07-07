package ebd.globalUtils.spline;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class functions as representation of a single spline knot.
 * Its task is to make adding a Knot to a spline curve a clearer process.
 * 
 * @author Lars Schulze-Falck
 *
 */
public class Knot {
	
	public Double xValue;
	public ArrayList<Double> coefficients = new ArrayList<>();
	
	/**
	 * Generates an instance of knot<br>
	 * The order of coefficients for the list is defined by the power of x they are assigned to:<br>
	 * f(x) = c0 * x^0 + c1 * x^1 + c2 * x^2 ...
	 * 
	 * @param xValue The x-value of the knot
	 * @param coefficients A list of all coefficients in order.
	 */
	public Knot(Double xValue, ArrayList<Double> coefficients) {
		this.xValue = xValue;
		this.coefficients = new ArrayList<>(coefficients);
		
	}

	/**
	 * Generates an instance of knot<br>
	 * The order of coefficients for the array is defined by the power of x they are assigned to:<br>
	 * f(x) = c0 * x^0 + c1 * x^1 + c2 * x^2 ...
	 *
	 * @param xValue The x-value of the knot
	 * @param coefficients A array of all coefficients in order.
	 */
	public Knot(Double xValue, double[] coefficients) {
		this.xValue = xValue;
		for (double item : coefficients) {
			this.coefficients.add(item);
		}

	}
	
	/**
	 * Generates an instance of knot with only a x-value and a single coefficient<br>
	 * 
	 * @param xValue The x-value of the knot
	 * @param yValue The y-value of the knot
	 */
	public Knot(Double xValue, Double yValue) {
		this.xValue = xValue;
		this.coefficients.add(yValue);
	}
	
	/**
	 * Generates an instance of knot with only a x-value and a single coefficient<br>
	 * 
	 * @param xValue The x-value of the knot
	 * @param yValue The y-value of the knot
	 */
	public Knot(Integer xValue, Integer yValue) {
		this.xValue = (double) xValue;
		this.coefficients.add((double) yValue);
	}

	@Override
	public String toString() {

		return "Knot{" +
				"xValue=" + xValue +
				", coefficients=" + Arrays.toString(coefficients.toArray()) +
				'}';
	}
}
