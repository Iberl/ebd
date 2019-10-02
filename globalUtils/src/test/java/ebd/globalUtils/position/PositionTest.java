package ebd.globalUtils.position;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;

import ebd.messageLibrary.util.ETCSVariables;
import org.junit.jupiter.api.Test;

import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.exceptions.PositionReferenzException;

/**
 * @author Lars Schulze-Falck
 *
 */
class PositionTest {

	/**
	 * Test method for {@link ebd.globalUtils.position.Position}.
	 */
	@Test
	void testPosition() {
		HashMap<Integer,Location> previousLocations = new HashMap<>();
		previousLocations.put(1, new Location(1, ETCSVariables.NID_LRBG, null));
		previousLocations.put(2,new Location(2, 1, 100d));
		previousLocations.put(3,new Location(3, 2, 100d));
		previousLocations.put(4,new Location(4, 3, 100d));
		previousLocations.put(5,new Location(5, 4, 100d));
		previousLocations.put(6,new Location(6, 0, 100d)); //This induces a break in the chain of locations
		previousLocations.put(7,new Location(7, 6, 100d));
		
		Position posOne = new Position(20d, false, new Location(4, 3, 100d));
		Position posTwo = new Position(15d, true, new Location(5, 4, 100d),previousLocations);
		Position posThree = new Position(0d,true,new Location(2, 1, 100d));
		posThree.setLocation(new Location(7, 6, 100d));
		posThree.setDirection(false);
		posThree.setIncrement(20d);
		posThree.setPreviousLocations(previousLocations);
		
		assertFalse(posOne.getLocation().equals(posTwo.getLocation()));
		assertFalse(posOne.getIncrement() == posTwo.getIncrement());
		assertFalse(posOne.isDirectedForward() == posTwo.isDirectedForward());
		
		assertThrows(PositionReferenzException.class, () -> posOne.totalDistanceToPastLocation(0)); //Tests unfound locations
		assertEquals(415d,posTwo.totalDistanceToPastLocation(1),0.001);
		assertThrows(PositionReferenzException.class, () -> posThree.totalDistanceToPastLocation(1)); //Tests breaks in the chain of locations
	}

}
