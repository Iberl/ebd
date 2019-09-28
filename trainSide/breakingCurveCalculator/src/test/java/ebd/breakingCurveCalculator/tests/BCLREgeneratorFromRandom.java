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


/**
 * @author Lars Schulze-Falck
 *
 */
public class BCLREgeneratorFromRandom{
	private Random rng;
	private List<String> targets = new ArrayList<>();
	
	/**
	 * Creates an instance with a set seed for repeatability
	 */
	public BCLREgeneratorFromRandom(long seed) {
		rng = new Random(seed);
		targets.add("bcc;");
	}

	/**
	 * Generates a {@link BreakingCurveLimitedRequestEvent} with all fields validly filled with random data.
	 *
	 * @return A {@link BreakingCurveLimitedRequestEvent} with all fields randomly but also validly filled
	 */
	public BreakingCurveLimitedRequestEvent generate() {

		//generating packet15
		
		Packet_15 packet15 = new Packet_15();
		
		Packet_15_Section endsection = packet15.new Packet_15_Section();
		endsection.L_SECTION = 100;
		ArrayList<Packet_15_Section> sections = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Packet_15_Section tempsection = packet15.new Packet_15_Section();
			tempsection.L_SECTION = rng.nextInt(1500) + 1;
			sections.add(tempsection);
		}
		
		
		packet15.Q_SCALE = 1;
		packet15.endsection = endsection;
		packet15.sections = sections;
		packet15.V_LOA = rng.nextInt(9);
			
		//setting currentPosition
		Position currentPosition = new Position(0, true, new Location("L2", "L1", 20d));
		HashMap<String,Location> preLocs = new HashMap<>();
		preLocs.put("L1",new Location("L1",null,null));
		currentPosition.setPreviousLocations(preLocs);
		
		
		return new BreakingCurveLimitedRequestEvent("devTests", targets, "test_BCLRE", packet15, currentPosition);	
	}

}
