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
	private String id;
	
	/**
	 * Id of the last previous crossed Location, is null if there is no previous location!
	 */
	@Nullable
	private String idOfPrevious;
	
	/**
	 * Distance to the last previous crossed Location in [m], is null if there is no previous location!
	 */
	@Nullable
	private Double distanceToPrevious;
	
	
	public Location(String id, String idOfPrevious, Double distanceToPrevious) {
		this.id = id;
		this.idOfPrevious = idOfPrevious;
		this.distanceToPrevious = distanceToPrevious;
	}


	public String getId() {
		return id;
	}


	public String getIdOfPrevious() {
		return idOfPrevious;
	}


	public Double getDistanceToPrevious() {
		return distanceToPrevious;
	}


	
	
}
