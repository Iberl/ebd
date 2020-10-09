package ebd.globalUtils.location;


import org.jetbrains.annotations.Nullable;

/**
 * This class represents a exact physical location marked by a linked balise on the train tracks.
 * @author Lars Schulze-Falck
 *
 */
public class Location {
	
	/**
	 * ID if this location, normally the balise ID
	 */
	private int id;

	/**
	 * Direction of this location, values are based on {@link ebd.messageLibrary.util.ETCSVariables#Q_DIR}, so:
	 * 1 = Nominal, 0 = Reverse, 2 = Unknown/Both.
	 */
	private int direction;
	
	/**
	 * Id of the last previous crossed Location, is null if there is no previous location!
	 */
	@Nullable
	private int idOfPrevious;
	
	/**
	 * Distance to the last previous crossed Location in [m], is null if there is no previous location!
	 */
	@Nullable
	private Double distanceToPrevious;
	
	
	public Location(int id, int idOfPrevious, int direction, Double distanceToPrevious) {
		this.id = id;
		this.idOfPrevious = idOfPrevious;
		this.direction = direction;
		this.distanceToPrevious = distanceToPrevious;
	}


	public int getId() {
		return id;
	}

	/**
	 * Direction of this location, values are based on {@link ebd.messageLibrary.util.ETCSVariables#Q_DIR}, so:
	 * 1 = Nominal, 0 = Reverse, 2 = Unknown/Both.
	 */
	public int getDirection() { return direction; }

	/**
	 * Id of the last previous crossed Location, is null if there is no previous location!
	 */
	public int getIdOfPrevious() {
		return idOfPrevious;
	}

	/**
	 * Distance to the last previous crossed Location in [m], is null if there is no previous location!
	 */
	public Double getDistanceToPrevious() {
		return distanceToPrevious;
	}


	
	
}
