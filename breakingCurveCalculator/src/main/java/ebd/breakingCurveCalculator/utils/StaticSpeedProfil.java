package ebd.breakingCurveCalculator.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.breakingCurveCalculator.utils.exceptions.SSPInvalidInputException;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_65;

/**
 * This class calculates and represents a static speed profile. It is based on ForwardSpline from the Spline Module.
 * A static speed profile is a step function, showing the maximal allowed speed as a function of distance.
 * 
 * @author Lars Schulze-Falck
 *
 */
public class StaticSpeedProfil extends ForwardSpline{
	
	/**
	 * Empty constructor
	 */
	private StaticSpeedProfil() {
		super(0);
	}
	
	/**
	 * Constructor setting the ID
	 * @param id
	 * 		A String
	 */
	private StaticSpeedProfil(String id) {
		super(0, id);
	}
	
	/**
	 * Constructor generating a StaticSpeedProfile out of a BreakingCurveRequestEvent
	 * @param bcre
	 * 		{@link BreakingCurveRequestEvent}
	 */
	public StaticSpeedProfil(BreakingCurveRequestEvent bcre) {
		super(0);
		generateSSPOutOfBCRequestEvent(bcre);
	}
	
	/**
	 * Constructor generating a StaticSpeedProfile out of a BreakingCurveRequestEvent
	 * @param bcre
	 * 		{@link BreakingCurveRequestEvent}
	 * @param id
	 * 		A String
	 */
	public StaticSpeedProfil(BreakingCurveRequestEvent bcre, String id) {
		super(0, id);
		generateSSPOutOfBCRequestEvent(bcre);		
	}
	
	/**
	 * This constructor takes an array which will be converted to a spline curve. The input array must be
	 * even sized. Even indices are the x values, uneven indices are the y values of the knots: <br>
	 * {x1,y1,x2,y2,x3,y3 ... xn,yn} <br>
	 * Used to test the SSP methods.
	 * 
	 * @param inputArray
	 * 		Array that will be converted
	 * @throws SSPInvalidInputException 
	 * 		If Array is not even
	 * 
	 */
	public StaticSpeedProfil(ArrayList<Double> inputArray) throws SSPInvalidInputException{
		super(0);
		if ((inputArray.size() % 2 != 0)) {	throw new SSPInvalidInputException(String.format("The input array needs to be of even size, size was %d",inputArray.size()));}
		
		for (int i = 0; i < inputArray.size(); i += 2) {
			addKnotToCurve(new Knot(inputArray.get(i), inputArray.get(i +1)));
		}
	}
	
	/**
	 * This constructor takes an array which will be converted to a spline curve. The input array must be
	 * even sized. Even indices are the x values, uneven indices are the y values of the knots: <br>
	 * {x1,y1,x2,y2,x3,y3 ... xn,yn} <br>
	 * Mostly used to test the SSP methods.
	 * 
	 * @param inputArray Array that will be converted
	 * @param id 
	 * 		ID String
	 * @throws SSPInvalidInputException 
	 * 		If Array is not even
	 */
	public StaticSpeedProfil(ArrayList<Double> inputArray, String id) throws SSPInvalidInputException {
		super(0, id);
		if (inputArray.size() % 2 != 0) {throw new SSPInvalidInputException(String.format("The input array needs to be of even size, size was %d",inputArray.size()));}
		
		for (int i = 0; i < inputArray.size(); i += 2) {
			addKnotToCurve(new Knot(inputArray.get(i), inputArray.get(i +1)));
		}
	}
	
	
	/**
	 * This method takes a ForwardSpline of zero degree (ForwardSpline(0)) and adds it to the existing SSP
	 *  
	 * @param inputSplineOfZerodegree
	 * 		A {@link ForwardSpline} with degree 0
	 * @throws SSPInvalidInputException
	 * 		If degree of input Spline was higher then 0
	 *
	 * @author Lars Schulze-Falck
	 */
	public void addSplineToCurve(ForwardSpline inputSplineOfZerodegree) throws SSPInvalidInputException {
		if (inputSplineOfZerodegree.getdegree() != 0) {//Checking if the degree of the spline to add is the same degree as SSP
			throw new SSPInvalidInputException(String.format("The input spline needs to be of 0 degree, was %d instead",inputSplineOfZerodegree.getdegree()));
		}
		
		/*
		 * Getting the curves to add together to make the code clearer
		 */
		TreeMap<Double,ArrayList<Double>> oldCurve = this.curve;
		TreeMap<Double,ArrayList<Double>> inCurve = inputSplineOfZerodegree.curve;
		
		/*
		 * We will generate a new spline that will replace the old one
		 */
		ForwardSpline newSpline = new ForwardSpline(0);
		
		Double searchKey;
		Double value;
		
		/*
		 * Finding the first key of the new spline by checking which of the old curves has the lowest key and getting that value
		 */
		if (oldCurve.firstKey().equals(inCurve.firstKey())) {
			searchKey = oldCurve.firstKey();
			value = Math.min(oldCurve.get(searchKey).get(0),inCurve.get(searchKey).get(0));
			
			newSpline.addKnotToCurve(new Knot(searchKey, value));
		} 
		else {
			if (oldCurve.firstKey() < inCurve.firstKey()) {
				searchKey = oldCurve.firstKey();
				value = oldCurve.get(searchKey).get(0);
				newSpline.addKnotToCurve(new Knot(searchKey, value));
			}
			else {
				searchKey = inCurve.firstKey();
				value = inCurve.get(searchKey).get(0);
				newSpline.addKnotToCurve(new Knot(searchKey, value));
			}
			
		}
		/*
		 * Iterating through both curves, searching for the next higher key.		
		 */
		while (true) {
			
			Double xOld = oldCurve.higherKey(searchKey);
			Double xIn = inCurve.higherKey(searchKey);
			
			/*
			 * If xOld is null, the old curve is "empty", we only need to check the input curve for new keys,
			 * but we still have to respect the last keys value when adding new Knots to the new Spline
			 */
			if(xOld == null) {
				Double fixValue = oldCurve.lastEntry().getValue().get(0);
				while (xIn != null) {//Until both are "empty"
					value = Math.min(fixValue, inCurve.get(xIn).get(0));
					newSpline.addKnotToCurve(new Knot(xIn, value));
					xIn = inCurve.higherKey(xIn);
				}
				
				break;
			}
			/*
			 * If xIn is null, the input curve is "empty", we only need to check the old curve for new keys,
			 * but we still have to respect the last keys value when adding new Knots to the new Spline
			 */
			if(xIn == null) {
				Double fixValue = inCurve.lastEntry().getValue().get(0);
				while (xOld != null) {//Until both are "empty"
					value = Math.min(fixValue, oldCurve.get(xOld).get(0));
					newSpline.addKnotToCurve(new Knot(xOld, value));
					xOld = oldCurve.higherKey(xOld);
				}
				break;
			}
			
			searchKey = Math.min(xOld,xIn); //Next higher key
			Double valueOld = Double.MAX_VALUE;
			Double valueIn = Double.MAX_VALUE;
			
			if(oldCurve.floorEntry(searchKey) != null) {valueOld = oldCurve.floorEntry(searchKey).getValue().get(0);}
			if(inCurve.floorEntry(searchKey) != null) {valueIn = inCurve.floorEntry(searchKey).getValue().get(0);}
			
			value = Math.min(valueOld,valueIn);
			if (!newSpline.curve.lastEntry().getValue().get(0).equals(value)) {
				newSpline.addKnotToCurve(new Knot(searchKey, value));
			}
			
		}
		
		this.curve = newSpline.curve;
		
	}
	
	
	/**
	 * This method generates a SSP from an BreakingCurveRequestEvent. It is based on SRS 3.6 and 3.11. <br>
	 * This method does not check completeness of the Event and does throw {@link NullPointerException} in case it is missing relevant information.
	 * It also assumes that all information is correct and fitting into the profile.<br>
	 * The returning SSP profile has the units [m] and [m/s].
	 * 
	 * @param bcre
	 *		A valid {@link BreakingCurveRequestEvent}
	 * @author Lars Schulze-Falck
	 */
	private void generateSSPOutOfBCRequestEvent(BreakingCurveRequestEvent bcre){
		
		double totalDistance = 0;													//Keeping track of the total length traveled.
		ArrayList<ForwardSpline> listOfSlices = new ArrayList<>();	//For keeping and finally adding multiple generated SSP Slices
		
		
		/*
		 * Adding the first knot, if D_STATIC of the first profile is not 0. 
		 * Then the first speed value is based on the current allowed speed of the train (see SRS 3.6.3.2.2).
		 * 
		 */
		if (bcre.packet27.speedProfile.D_STATIC > 0) {addKnotToCurve(new Knot(0d, (double)bcre.currentSpeedLimit));}
		
		
		/*
		 * Adds the first profile into the list of all other profiles.
		 */
		List<Packet_27.Packet_27_StaticSpeedProfile> profiles = bcre.packet27.speedProfiles;
		profiles.add(0, bcre.packet27.speedProfile);
		
		
		/*
		 * Next we iterate through all profiles and add a knot to the SSP
		 */
		for (Packet_27.Packet_27_StaticSpeedProfile profile : profiles) {
			
			
			
			/*
			 * Here we iterate through all sections and search for the applicable speed, see SRS 3.11.3.2 for details
			 */
			
			ArrayList<Integer> allPossibleSpeeds = new ArrayList<>();
			boolean cantReplaced = false;
			
			Integer cantSpeed = Integer.MAX_VALUE;
			Integer cantDifference = Integer.MAX_VALUE;
			ArrayList<Integer> otherSpeeds = new ArrayList<>();
			
			for (Packet_27.Packet_27_StaticSpeedProfileSection section : profile.sections) {
				
				switch(section.Q_DIFF) {
				case 0:
					int tempdiff = bcre.NC_CDTRAIN - section.NC_CDDIFF; //selects closest but smaller SSP cant category to the train cant category;
					
					if (tempdiff >= 0 && tempdiff <= cantDifference) {
						cantDifference = tempdiff;
						cantSpeed = section.V_DIFF;
					}
				case 1:
					if(((bcre.NC_TRAIN & (int) Math.pow(2, section.NC_DIFF)) == (int) Math.pow(2, section.NC_DIFF))) {//handles other train categories that replace cant deficency category
						cantReplaced = true;
						otherSpeeds.add(section.V_DIFF);
					}
				case 2:
					if(((bcre.NC_TRAIN & (int) Math.pow(2, section.NC_DIFF)) == (int) Math.pow(2, section.NC_DIFF))) {//handles other train categories that do not replace cant deficency category
						otherSpeeds.add(section.V_DIFF);
					}
				}	
			}
			
			if (!cantReplaced) {//Should cant replace (Q_DIFF) be set, the otherSpeeds replace the cant deficiency speed.
				if (cantSpeed < Integer.MAX_VALUE) {//If there was no applicable cant deficiency, we add the basic speed
					allPossibleSpeeds.add(cantSpeed);
				}
				else {
					allPossibleSpeeds.add(profile.V_STATIC);
				}
			}
			
			allPossibleSpeeds.addAll(otherSpeeds);
			allPossibleSpeeds.add(bcre.maxSpeedofTrain); //To be sure that we do not go over V_MAXTRAIN
			Collections.sort(allPossibleSpeeds); //Sort all speeds so the lowest is at index 0
			
			/*
			 * Then we add the distance to the next knot to totalDistance. Finally we add the knot to the SSP, with the total distance so far and the lowest found speed.<br>
			 * We also keep a lookout for the special value of V_STATIC = 127, which means that the next knot is the last valid knot. (s. SRS 7.5.1.171)
			 * We represent this fact by setting the last knot to 0 m/s.
			 */
			totalDistance += profile.D_STATIC * Math.pow(10, bcre.packet27.Q_SCALE - 1);
			
			if (profile.V_STATIC == 127) {
				addKnotToCurve(new Knot(totalDistance, 0d));
				break;
			}
			
			addKnotToCurve(new Knot(totalDistance, allPossibleSpeeds.get(0) * BreakingCurveCalculator.ETCS_VALUE_TO_MS));
			
			/*
			 * If we have to respect the train length (Train Length Delay) we generate a SSP Slice to add to the SSP later
			 */
			if (!profile.Q_FRONT) {
				ForwardSpline slice = new ForwardSpline(0);
				slice.addKnotToCurve(new Knot(totalDistance, profile.V_STATIC * BreakingCurveCalculator.ETCS_VALUE_TO_MS));
				slice.addKnotToCurve(new Knot(totalDistance + bcre.L_TRAIN, Double.MAX_VALUE));
				listOfSlices.add(slice);
			}
		}
		
		
		/*
		 * Now we handle possible Temporary Speed Restrictions
		 * We do this by generating a SSP slice for each TSR and adding it to the already existing SSP later
		 */
		if (bcre.listPacket65.size() > 0) {
			
			for (Packet_65 tsr : bcre.listPacket65) {
				ForwardSpline slice = new ForwardSpline(0, "65");
				
				slice.addKnotToCurve(new Knot(tsr.D_TSR * Math.pow(10, tsr.Q_SCALE - 1), tsr.V_TSR * BreakingCurveCalculator.ETCS_VALUE_TO_MS));
				
				if (tsr.Q_FRONT) 	{slice.addKnotToCurve(new Knot(tsr.D_TSR * Math.pow(10, tsr.Q_SCALE - 1) + tsr.L_TSR, Double.MAX_VALUE));}
				else 				{slice.addKnotToCurve(new Knot(tsr.D_TSR * Math.pow(10, tsr.Q_SCALE - 1) + tsr.L_TSR + bcre.L_TRAIN, Double.MAX_VALUE));}
				listOfSlices.add(slice);
			}		
		}
		
		
		/*
		 * Finally we add all slices to the SSP
		 */
		for (ForwardSpline slice : listOfSlices) {
			addSplineToCurve(slice);
		}
	}
}
	
	
	


