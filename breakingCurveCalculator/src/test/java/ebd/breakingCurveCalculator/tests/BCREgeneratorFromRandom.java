package ebd.breakingCurveCalculator.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trackpackets.Packet_15.Packet_15_Section;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.packet.trackpackets.Packet_21.Packet_21_Gradient;
import ebd.messageLibrary.packet.trackpackets.Packet_27;
import ebd.messageLibrary.packet.trackpackets.Packet_27.Packet_27_StaticSpeedProfile;
import ebd.messageLibrary.packet.trackpackets.Packet_27.Packet_27_StaticSpeedProfileSection;
import ebd.messageLibrary.packet.trackpackets.Packet_65;

/**
 * @author Lars Schulze-Falck
 *
 */
public class BCREgeneratorFromRandom{
	Random rng;
	private List<String> targets = new ArrayList<>();

	/**
	 * Creates an instance with a set seed for repeatability
	 */
	public BCREgeneratorFromRandom(long seed) {
		rng = new Random(seed);
		targets.add("bcc;");
	}

	/**
	 * Generates a {@link BreakingCurveRequestEvent} with all fields validly filled with random data.
	 *
	 * @return A {@link BreakingCurveRequestEvent} with all fields randomly but also validly filled
	 */
	public BreakingCurveRequestEvent generate() {
		
		
		//setting ID
		String id = "test_BCRE_Random";
		
		//breaking Power
		double[] forceList = {0.5,1d,1.5,2d,2.5};
		ForwardSpline breakingPower  = new ForwardSpline(0);
		for (int speed = 0; speed < 120;) {
			double force = forceList[rng.nextInt(forceList.length)];
			double speedInMS = speed * (50d/36d);
			breakingPower.addKnotToCurve(new Knot(speedInMS, force));
			
			speed += rng.nextInt(20) + 10;
			
		}
		
		
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
		
		
		//generating packet21
		Packet_21_Gradient gradient = new Packet_21_Gradient(100, true, 2);
		ArrayList<Packet_21_Gradient> gradients = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Packet_21_Gradient tempgrad = new Packet_21_Gradient(rng.nextInt(1500) + 1, rng.nextBoolean(), rng.nextInt(10));
			gradients.add(tempgrad);
		}
		
		Packet_21 packet21 = new Packet_21();
		packet21.Q_SCALE = 1;
		packet21.gradient = gradient;
		packet21.gradients = gradients;
		
		//setting currentGradient
		int currentGradient = rng.nextInt(10);
		
		//setting currentPosition
		Position currentPosition = new Position(0, true, new Location("L1", null, null));
		
		//generating packet27
		
		Packet_27 packet27 = new Packet_27();
		ArrayList<Packet_27_StaticSpeedProfile> profileList = new ArrayList<>();
		
		for (int i = 0; i < rng.nextInt(12) + 4; i++) {
			
			Packet_27_StaticSpeedProfile p27SSP = packet27.new Packet_27_StaticSpeedProfile(rng.nextInt(1500) + 1, rng.nextInt(113) + 8, rng.nextBoolean());
			ArrayList<Packet_27_StaticSpeedProfileSection> sectionList = new ArrayList<>();
			
			for (int ii = 0; ii < rng.nextInt(3); ii++) {
				Packet_27_StaticSpeedProfileSection p27sec = packet27.new Packet_27_StaticSpeedProfileSection(rng.nextInt(3), rng.nextInt(11), rng.nextInt(3), rng.nextInt(113) + 8);
				sectionList.add(p27sec);
			}
			
			p27SSP.sections = sectionList;
			profileList.add(p27SSP);
		}
		
		Packet_27_StaticSpeedProfile p27SSP = packet27.new Packet_27_StaticSpeedProfile(rng.nextInt(1500) + 1, rng.nextInt(113) + 8, rng.nextBoolean());
		ArrayList<Packet_27_StaticSpeedProfileSection> sectionList = new ArrayList<>();
		
		for (int ii = 0; ii < rng.nextInt(3); ii++) {
			Packet_27_StaticSpeedProfileSection p27sec = packet27.new Packet_27_StaticSpeedProfileSection(rng.nextInt(3), rng.nextInt(11), rng.nextInt(3), rng.nextInt(113) + 8);
			sectionList.add(p27sec);
		}
		
		p27SSP.sections = sectionList;
		
		packet27.Q_SCALE = 1;
		packet27.speedProfile = p27SSP;
		packet27.speedProfiles = profileList;
		
		
		//generating list of packet65
		ArrayList<Packet_65> listPacket65 = new ArrayList<>();
		
		//setting NC_CDTRAIN
		int NC_CDTRAIN = rng.nextInt(11);
		
		//setting otherInternationalTrainCategories
		int NC_TRAIN = rng.nextInt(8);
		
		//setting L_Train
		int L_TRAIN = rng.nextInt(100) + 150;
		
		//setting currentSpeedLimit
		double currentSpeedLimit = rng.nextInt(30) + 10;
		
		//setting V_MAX
		int V_MAXTRAIN = rng.nextInt(101) + 20;
		
		return new BreakingCurveRequestEvent("devTests", targets,id, breakingPower, packet15, packet21, currentGradient, currentPosition, packet27, 
				listPacket65, NC_CDTRAIN, NC_TRAIN, L_TRAIN, currentSpeedLimit, V_MAXTRAIN);	
	}

}
