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
	 * Id of the last previous crossed Location, is null if there is no previous location!
	 */
	@Nullable
	private int idOfPrevious;
	
	/**
	 * Distance to the last previous crossed Location in [m], is null if there is no previous location!
	 */
	@Nullable
	private Double distanceToPrevious;
	
	
	public Location(int id, int idOfPrevious, Double distanceToPrevious) {
		this.id = id;
		this.idOfPrevious = idOfPrevious;
		this.distanceToPrevious = distanceToPrevious;
	}


	public int getId() {
		return id;
	}


	public int getIdOfPrevious() {
		return idOfPrevious;
	}


	public Double getDistanceToPrevious() {
		return distanceToPrevious;
	}


	
	
}
