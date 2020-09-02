package ebd.globalUtils.position;


import java.util.HashMap;
import java.util.Map;

import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.exceptions.PositionReferenzException;
import ebd.messageLibrary.util.ETCSVariables;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A position represents a precise place on the track. It uses fixed reference points called
 * {@link Location} and an offset value called "increment" to represent this place.
 * 
 * @author Jan Emrich and Lars Schulze-Falck
 *
 */
public class Position {
	
	/**
	 * Current direction of travel of the train in relation the current location: 0 for Reverse, 1 for Nominal and 2 for Unknown, s. {@link ETCSVariables#Q_DIRTRAIN}.
	 */
	private int direction;

	/**
     * Reference location
     */
	@NotNull
    private Location location;

    /**
     * Increment added to the reference point. It is always counted in the nominal travel direction of the train and can not be negative!
     */
    private double increment;
    
    /**
     * A HashMap of previous locations (s. SRS 3.6.2.2.2c) ). Should be 8 or more locations unless the train has crossed less than 8 balise groups total.
     * The Key of the HashMap is the location ID, the Value the {@link Location} itself
     */
    @NotNull
    private Map<Integer,Location> previousLocations = new HashMap<>();

    /**
     * A position represents a precise place on the track. It uses fixed reference points called
     * {@link Location} and an offset value called "increment" to represent this place.
     * @param increment relative to the location position
     * @param direction the movement direction, true for Nominal, false for Reverse
     * @param location location reference point
     */
    public Position(double increment, boolean direction, @NotNull Location location) {
        this.increment = increment;
        this.direction = direction ? 1 : 0;
        this.location = location;
    }

    /**
     * A position represents a precise place on the track. It uses fixed reference points called
     * {@link Location} and an offset value called "increment" to represent this place.
     * @param increment relative to the location position
     * @param direction the movement direction, 1 for Nominal, 0 for Reverse or 2 for unknown
     * @param location location reference point
     */
    public Position(double increment, int direction, @NotNull Location location) {
        this.increment = increment;
        this.direction = direction;
        this.location = location;
        this.previousLocations = previousLocations;
    }


    /**
     * A position represents a precise place on the track. It uses fixed reference points called
     * {@link Location} and an offset value called "increment" to represent this place.
     * @param increment relative to the location position
     * @param direction the movement direction, true for Nominal, false for Reverse
     * @param location location reference point
     * @param previousLocations A map of previous relevant locations
     */
    public Position(double increment, boolean direction, @NotNull Location location, @NotNull Map<Integer, Location> previousLocations) {
        this.increment = increment;
        this.direction = direction ? 1 : 0;
        this.location = location;
        this.previousLocations = previousLocations;
    }

    /**
     * A position represents a precise place on the track. It uses fixed reference points called
     * {@link Location} and an offset value called "increment" to represent this place.
     * @param increment relative to the location position
     * @param direction the movement direction, 1 for Nominal, 0 for Reverse or 2 for unknown
     * @param location location reference point
     * @param previousLocations A map of previous relevant locations
     */
    public Position(double increment, int direction, @NotNull Location location, @NotNull Map<Integer, Location> previousLocations) {
        this.increment = increment;
        this.direction = direction;
        this.location = location;
        this.previousLocations = previousLocations;
    }
    
    /**
     * Returns the total distance between a previous location and the current position. Its adds up all distances from the previous location to 
     * the location of this position and adds the increment.
     * 
     * @param pastLocID
     * 		The ID of the previous location
     * @return
     * 		Double
     * @throws PositionReferenzException
     * 		Thrown if previous location could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double totalDistanceToPastLocation(int pastLocID) throws PositionReferenzException{
    	Double totalDistance = 0d;
    	
    	if ((pastLocID == location.getId())) {
    		return getIncrement();
    	}
    	else if (!previousLocations.containsKey(pastLocID)) {
    		throw new PositionReferenzException(String.format("Previous Location ID (%s) was not found in the map of previous locations", pastLocID));
        }
    	
    	int backSteppingLocationId = this.location.getIdOfPrevious();
    	totalDistance += this.location.getDistanceToPrevious();
    	while(!(backSteppingLocationId == pastLocID)) {
    		Location tempLocation = previousLocations.get(backSteppingLocationId);
    		if(tempLocation == null  || tempLocation.getIdOfPrevious() == ETCSVariables.NID_LRBG) {
    			throw new PositionReferenzException(String.format("There was no unbroken chain between Location ID (%s) and the past location (%s)", this.location.getId(), pastLocID));
    		}
    		totalDistance += tempLocation.getDistanceToPrevious();
    		backSteppingLocationId = tempLocation.getIdOfPrevious();
    	}
    	
    	return totalDistance + getIncrement();
    }
    
    
    /**
     * Returns the total distance between a previous position and the current position.
     * 
     * @param prevPosition
     * 		The previous Position
     * @return
     * 		Double
     * @throws PositionReferenzException
     * 		Thrown if the location of the previous position could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double totalDistanceToPreviousPosition(@NotNull Position prevPosition) throws PositionReferenzException {
    	return totalDistanceToPastLocation(prevPosition.getLocation().getId()) - prevPosition.getIncrement();
    }
    
    /**
     * Returns the total distance between a future position and the current position.
     * 
     * @param futurePosition
     * 		The Position further along
     * @return
     * 		Double
     * @throws PositionReferenzException
     * 		Thrown if the location of this position could not be found in the list of previous locations of the future position
     *
     * @author Lars Schulze-Falck
     */
    public Double totalDistanceToFuturePosition(Position futurePosition) throws PositionReferenzException {
    	return futurePosition.totalDistanceToPreviousPosition(this) - getIncrement();
    }

    public boolean previousLocationsContainsID(int locID){ return this.previousLocations.containsKey(locID); }
    
    
    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    /**
     * Current direction of travel of the train: 0 for Reverse, 1 for Nominal and 2 for Unknown, s. {@link ETCSVariables#Q_DIRTRAIN}.
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Current direction of travel of the train: 0 for Reverse, 1 for Nominal and 2 for Unknown, s. {@link ETCSVariables#Q_DIRTRAIN}.
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

	public Map<Integer, Location> getPreviousLocations() {
		return previousLocations;
	}

	public void setPreviousLocations(HashMap<Integer, Location> previousLocations) {
		this.previousLocations = previousLocations;
	}
    
    
}
