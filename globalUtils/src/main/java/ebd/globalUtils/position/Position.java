package ebd.globalUtils.position;


import ebd.globalUtils.configHandler.ConfigHandler;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.exceptions.PositionReferenzException;
import ebd.messageLibrary.util.ETCSVariables;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * A position represents a precise place on the track. It uses fixed reference points called
 * {@link Location} and an offset value called "increment" to represent this place.<br>
 * The increment points to the Estimated Front End (s. SRS-026-3 3.6.4).
 * From the increment, combined with the relative confidence intervall (s. {@link ConfigHandler#d_Confidence}) and the absolute
 * location confidence (s. {@link ConfigHandler#d_LocCon}), Max and Min Safe Front End are calculated.
 * 
 * @author Lars Schulze-Falck
 *
 */
public class Position {

    private enum Mode {
        ESTIMATED,
        MAX_SAFE_FRONT,
        MIN_SAFE_FRONT
    }

    private final ConfigHandler ch = ConfigHandler.getInstance();

	/**
	 * Direction of the increment in relation the current location: 0 for Reverse, 1 for Nominal s. {@link ETCSVariables#Q_DLRBG}.
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
     * Returns the total estimated distance between a previous location and the current Estimated Front End.
     * 
     * @param pastLocID
     * 		The ID of the previous location
     * @return
     * 		Distance in [m]
     * @throws PositionReferenzException
     * 		Thrown if previous location could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double estimatedDistanceToPastLocation(int pastLocID) throws PositionReferenzException{
        return distanceToPastLocation(pastLocID, Mode.ESTIMATED);
    }

    /**
     * Returns the total distance between a previous location and the current Max Safe Front End.
     *
     * @param pastLocID
     * 		The ID of the previous location
     * @return
     * 		Distance in [m]
     * @throws PositionReferenzException
     * 		Thrown if previous location could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double maxSafeFrontDistanceToPastLocation(int pastLocID) throws PositionReferenzException{
        return distanceToPastLocation(pastLocID, Mode.MAX_SAFE_FRONT);
    }

    /**
     * Returns the total distance between a previous location and the current Min Safe Front End.
     *
     * @param pastLocID
     * 		The ID of the previous location
     * @return
     * 		Distance in [m]
     * @throws PositionReferenzException
     * 		Thrown if previous location could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double minSafeFrontDistanceToPastLocation(int pastLocID) throws PositionReferenzException{
        return distanceToPastLocation(pastLocID, Mode.MIN_SAFE_FRONT);
    }


    
    /**
     * Returns the total distance between a previous estimated front end and the current estimated front end.
     * 
     * @param prevPosition
     * 		The previous Position
     * @return
     * 		Distance in [m]
     * @throws PositionReferenzException
     * 		Thrown if the location of the previous position could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double estimatedDistanceToPreviousPosition(@NotNull Position prevPosition) throws PositionReferenzException {
    	return estimatedDistanceToPastLocation(prevPosition.getLocation().getId()) - prevPosition.getEstimatedFrontEnd();
    }

    /**
     * Returns the total distance between a previous Max Safe Front End and the current Max Safe Front End.
     *
     * @param prevPosition
     * 		The previous Position
     * @return
     * 		Distance in [m]
     * @throws PositionReferenzException
     * 		Thrown if the location of the previous position could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double maxSafeDistanceToPreviousPosition(@NotNull Position prevPosition) throws PositionReferenzException {
        return maxSafeFrontDistanceToPastLocation(prevPosition.getLocation().getId()) - prevPosition.getMaxSafeFrontEnd();
    }

    /**
     * Returns the total distance between a previous Min Safe Front End and the current Min Safe Front End.
     *
     * @param prevPosition
     * 		The previous Position
     * @return
     * 		Distance in [m]
     * @throws PositionReferenzException
     * 		Thrown if the location of the previous position could not be found in the list of previous locations
     *
     * @author Lars Schulze-Falck
     */
    public Double minSafeDistanceToPreviousPosition(@NotNull Position prevPosition) throws PositionReferenzException {
        return minSafeFrontDistanceToPastLocation(prevPosition.getLocation().getId()) - prevPosition.getMinSafeFrontEnd();
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
    public Double estimatedDistanceToFuturePosition(Position futurePosition) throws PositionReferenzException {
    	return futurePosition.estimatedDistanceToPreviousPosition(this) - getIncrement();
    }

    public boolean previousLocationsContainsID(int locID){ return this.previousLocations.containsKey(locID); }


    @Override
    public String toString() {
        return "position={" +
                "direction=" + direction +
                ",locationID=" + location.getId() +
                ",incrementInM=" + increment +
                '}';
    }

    /**
     * @return The current Estimated Front End of the train
     */
    public double getEstimatedFrontEnd(){
        return this.increment;
    }

    /**
     * s. SRS Subset-026-3 3.6.4.4 b)
     * @return The current maximum safe front end of the train in [m], based on {@link ConfigHandler#d_Confidence}
     *          and {@link ConfigHandler#d_LocCon}
     */
    public double getMaxSafeFrontEnd(){
        return this.increment + this.increment * ch.d_Confidence + ch.d_LocCon;
    }

    /**
     * s. SRS Subset-026-3 3.6.4.4 c)
     * @return The current minimum safe front end of the train in [m], based on {@link ConfigHandler#d_Confidence}
     *          and {@link ConfigHandler#d_LocCon}
     */
    public double getMinSafeFrontEnd(){
        return this.increment - this.increment * ch.d_Confidence - ch.d_LocCon;
    }


    private Double distanceToPastLocation(int pastLocID, Mode mode){
        Double totalDistance = 0d;

        if ((pastLocID == location.getId())) {
            return switch (mode){
                case ESTIMATED -> getEstimatedFrontEnd();
                case MAX_SAFE_FRONT -> getMaxSafeFrontEnd();
                case MIN_SAFE_FRONT -> getMinSafeFrontEnd();
            };
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

        return totalDistance + switch (mode){
                                        case ESTIMATED -> getEstimatedFrontEnd();
                                        case MAX_SAFE_FRONT -> getMaxSafeFrontEnd();
                                        case MIN_SAFE_FRONT -> getMinSafeFrontEnd();
                                    };
    }

    /*
     Getter
    */
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

    public @NotNull Location getLocation() {
        return location;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
    }

	public Map<Integer, Location> getPreviousLocations() {
		return previousLocations;
	}

	public void setPreviousLocations(HashMap<Integer, Location> previousLocations) {
		this.previousLocations = previousLocations;
	}
}
