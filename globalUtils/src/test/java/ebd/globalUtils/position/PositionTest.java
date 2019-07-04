package ebd.globalUtils.position;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;

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
		HashMap<String,Location> previousLocations = new HashMap<>();
		previousLocations.put("L1",new Location("L1", null, null));
		previousLocations.put("L2",new Location("L2", "L1", 100d));
		previousLocations.put("L3",new Location("L3", "L2", 100d));
		previousLocations.put("L4",new Location("L4", "L3", 100d));
		previousLocations.put("L5",new Location("L5", "L4", 100d));
		previousLocations.put("L6",new Location("L6", "L0", 100d)); //This induces a break in the chain of locations
		previousLocations.put("L7",new Location("L7", "L6", 100d));
		
		Position posOne = new Position(20d, false, new Location("L4", "L3", 100d));
		Position posTwo = new Position(15d, true, new Location("L5", "L4", 100d),previousLocations);
		Position posThree = new Position(0d,true,new Location("L2", "L1", 100d));
		posThree.setLocation(new Location("L7", "L6", 100d));
		posThree.setDirection(false);
		posThree.setIncrement(20d);
		posThree.setPreviousLocations(previousLocations);
		
		assertFalse(posOne.getLocation().equals(posTwo.getLocation()));
		assertFalse(posOne.getIncrement() == posTwo.getIncrement());
		assertFalse(posOne.isDirectedForward() == posTwo.isDirectedForward());
		
		assertThrows(PositionReferenzException.class, () -> posOne.totalDistanceToPastLocation("L0")); //Tests unfound locations
		assertEquals(415d,posTwo.totalDistanceToPastLocation("L1"),0.001);
		assertThrows(PositionReferenzException.class, () -> posThree.totalDistanceToPastLocation("L1")); //Tests breaks in the chain of locations
	}

}
