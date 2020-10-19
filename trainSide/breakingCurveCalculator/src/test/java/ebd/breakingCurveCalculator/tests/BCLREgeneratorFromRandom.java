package ebd.breakingCurveCalculator.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import ebd.globalUtils.events.bcc.BreakingCurveLimitedRequestEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_15.Packet_15_Section;
import ebd.messageLibrary.util.ETCSVariables;


/**
 * @author Lars Schulze-Falck
 *
 */
public class BCLREgeneratorFromRandom{
	private Random rng;
	private String target;
	
	/**
	 * Creates an instance with a set seed for repeatability
	 */
	public BCLREgeneratorFromRandom(long seed) {
		rng = new Random(seed);
		target = "bcc;";
	}

	/**
	 * Generates a {@link BreakingCurveLimitedRequestEvent} with all fields validly filled with random data.
	 *
	 * @return A {@link BreakingCurveLimitedRequestEvent} with all fields randomly but also validly filled
	 */
	public BreakingCurveLimitedRequestEvent generate() {

		//generating packet15
		
		Packet_15 packet15 = new Packet_15();
		
		Packet_15_Section endsection = new Packet_15_Section();
		endsection.L_SECTION = 100;
		ArrayList<Packet_15_Section> sections = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Packet_15_Section tempsection = new Packet_15_Section();
			tempsection.L_SECTION = rng.nextInt(1500) + 1;
			sections.add(tempsection);
		}
		
		
		packet15.Q_SCALE = 1;
		packet15.endsection = endsection;
		packet15.sections = sections;
		packet15.V_LOA = rng.nextInt(9);
		packet15.Q_OVERLAP = ETCSVariables.Q_OVERLAP_INFO;
		packet15.D_OL = 200;
		packet15.Q_DANGERPOINT = ETCSVariables.Q_DANGERPOINT_INFO;
		packet15.D_DP = 100;
			
		//setting currentPosition
		Position currentPosition = new Position(0, true, new Location(2, 1, ETCSVariables.Q_DIR_NOMINAL, 20d));
		HashMap<Integer,Location> preLocs = new HashMap<>();
		preLocs.put(1,new Location(1, ETCSVariables.NID_LRBG, ETCSVariables.Q_DIR_NOMINAL, null));
		currentPosition.setPreviousLocations(preLocs);
		
		
		return new BreakingCurveLimitedRequestEvent("devTests", target, "test_BCLRE", packet15, currentPosition);
	}

}
