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
	private final int id;

	/**
	 * Direction of train movement over the location, relates to {@link ebd.messageLibrary.util.ETCSVariables#Q_DIRTRAIN}, so:
	 * 1 = Nominal, 0 = Reverse, 2 = Unknown/Both.
	 * Can be used to validate messages that contain a Q_DIR.
	 */
	private final int direction;
	
	/**
	 * Id of the last previous crossed Location, is null if there is no previous location!
	 */
	@Nullable
	private final int idOfPrevious;
	
	/**
	 * Distance to the last previous crossed Location in [m], is null if there is no previous location!
	 */
	@Nullable
	private final Double distanceToPrevious;
	
	
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

	@Override
	public String toString() {
		return "Location{" +
				"id=" + id +
				", direction=" + direction +
				", idOfPrevious=" + idOfPrevious +
				", distanceToPrevious=" + distanceToPrevious +
				'}';
	}
}
