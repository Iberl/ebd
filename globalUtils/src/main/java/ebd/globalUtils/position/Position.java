package ebd.globalUtils.position;


import java.util.HashMap;

import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.exceptions.PositionReferenzException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class represents a position for a train. It consists out of an absolut reference point, a direction and an increment.
 * 
 * @author Jan Emrich and Lars Schulze-Falck
 *
 */
public class Position {
	
	/**
	 * Current direction of travel of the train: Nominal (true) or reverse (false). Does not change the way the increment is counted.
	 */
	private boolean direction;

	/**
     * Reference location //TODO Change according to {@link ebd.messageLibrary.util.ETCSVariables#Q_DIR}
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
    @Nullable
    private HashMap<String,Location> previousLocations = new HashMap<String,Location>();

    /**
     * represents a position on the track
     * @param increment relative to the location position
     * @param direction true == forward, false == backward
     * @param location location reference point
     */
    public Position(double increment, boolean direction, @NotNull Location location) {
        this.increment = increment;
        this.direction = direction;
        this.location = location;
    }
    
    public Position(double increment, boolean direction, @NotNull Location location, @Nullable HashMap<String, Location> previousLocations) {
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
    public Double totalDistanceToPastLocation(String pastLocID) throws PositionReferenzException{
    	Double totalDistance = 0d;
    	
    	if (pastLocID.equals(location.getId())) {
    		return getIncrement();
    	}
    	else if (!previousLocations.containsKey(pastLocID)) {
    		throw new PositionReferenzException(String.format("Previous Location ID (%s) was not found in the map of previous locations", pastLocID));
        }
    	
    	String backSteppingLocationId = this.location.getIdOfPrevious();
    	totalDistance += this.location.getDistanceToPrevious();
    	while(!backSteppingLocationId.equals(pastLocID)) {
    		Location tempLocation = previousLocations.get(backSteppingLocationId);
    		if(tempLocation == null  || tempLocation.getIdOfPrevious() == null) {
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
    
    
    public double getIncrement() {
        return increment;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public boolean isDirectedForward() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

	public HashMap<String, Location> getPreviousLocations() {
		return previousLocations;
	}

	public void setPreviousLocations(HashMap<String, Location> previousLocations) {
		this.previousLocations = previousLocations;
	}
    
    
}
