package ebd.globalUtils.position;

import static org.junit.jupiter.api.Assertions.*;


import java.util.HashMap;

import ebd.messageLibrary.util.ETCSVariables;

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

	void testPosition() {
		HashMap<Integer,Location> previousLocations = new HashMap<>();
		previousLocations.put(1, new Location(1, ETCSVariables.NID_LRBG, ETCSVariables.Q_DIR_NOMINAL, null));
		previousLocations.put(2,new Location(2, 1, ETCSVariables.Q_DIR_NOMINAL, 100d));
		previousLocations.put(3,new Location(3, 2, ETCSVariables.Q_DIR_NOMINAL, 100d));
		previousLocations.put(4,new Location(4, 3, ETCSVariables.Q_DIR_NOMINAL, 100d));
		previousLocations.put(5,new Location(5, 4, ETCSVariables.Q_DIR_NOMINAL, 100d));
		previousLocations.put(6,new Location(6, 0, ETCSVariables.Q_DIR_NOMINAL, 100d)); //This induces a break in the chain of locations
		previousLocations.put(7,new Location(7, 6, ETCSVariables.Q_DIR_NOMINAL, 100d));
		
		Position posOne = new Position(20d, false, new Location(4, 3, ETCSVariables.Q_DIR_NOMINAL, 100d));
		Position posTwo = new Position(15d, true, new Location(5, 4, ETCSVariables.Q_DIR_NOMINAL, 100d),previousLocations);
		Position posThree = new Position(0d,true,new Location(2, 1, ETCSVariables.Q_DIR_NOMINAL, 100d));
		posThree.setLocation(new Location(7, 6, ETCSVariables.Q_DIR_NOMINAL, 100d));
		posThree.setDirection(0);
		posThree.setIncrement(20d);
		posThree.setPreviousLocations(previousLocations);
		
		assertFalse(posOne.getLocation().equals(posTwo.getLocation()));
		assertFalse(posOne.getIncrement() == posTwo.getIncrement());
		assertFalse(posOne.getDirection() == posTwo.getDirection());
		
		assertThrows(PositionReferenzException.class, () -> posOne.estimatedDistanceToPastLocation(0)); //Tests unfound locations
		assertEquals(415d,posTwo.estimatedDistanceToPastLocation(1),0.001);
		assertThrows(PositionReferenzException.class, () -> posThree.estimatedDistanceToPastLocation(1)); //Tests breaks in the chain of locations
	}

}
