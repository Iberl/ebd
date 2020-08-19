package ebd.breakingCurveCalculator.tests;

import java.util.ArrayList;

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
import ebd.messageLibrary.packet.trackpackets.Packet_65;
import ebd.messageLibrary.util.ETCSVariables;

/**
 * @author Lars Schulze-Falck
 *
 */
public class BCREgeneratorFromDataset{

	private String target = "bcc";
	int[] tsp;
	double[] bp;
	int[] gp;
	int eoa;

	/**
	 * Creates an instance with the provided data
	 */
	public BCREgeneratorFromDataset(int[] tsp, double[] bp, int [] gp, int eoa) {
		this.tsp = tsp;
		this.bp = bp;
		this.gp = gp;
		this.eoa = eoa;
	}

	/**
	 * Generates a {@link BreakingCurveRequestEvent} with all fields validly filled with the provided data.
	 *
	 * @return A {@link BreakingCurveRequestEvent} with all fields validly filled
	 */
	public BreakingCurveRequestEvent generate() {

		//setting ID
		String id = "test_BCRE_Dataset";

		//breaking Power
		ForwardSpline breakingPower  = new ForwardSpline(0);
		for (int i = 0; i < bp.length; i+=2) {
			breakingPower.addKnotToCurve(new Knot(bp[i] * 10d/36d, bp[i+1]));
		}

		//emergency breaking Power
		ForwardSpline emergencyBreakingPower  = new ForwardSpline(0);
		for (int i = 0; i < bp.length; i+=2) {
			emergencyBreakingPower.addKnotToCurve(new Knot(bp[i] * 10d/36d, bp[i+1] + 0.1));
		}

		//generating packet15

		Packet_15 packet15 = new Packet_15();

		Packet_15_Section endsection = new Packet_15_Section();
		endsection.L_SECTION = eoa;
		ArrayList<Packet_15_Section> sections = new ArrayList<>();

		packet15.Q_SCALE = 1;
		packet15.endsection = endsection;
		packet15.sections = sections;
		packet15.V_LOA = 0;


		//generating packet21
		int totalDistance = gp[0];
		Packet_21_Gradient gradient = new Packet_21_Gradient(gp[0], gp[1] >= 0, Math.abs(gp[1]));
		ArrayList<Packet_21_Gradient> gradients = new ArrayList<>();

		for (int i = 2; i < gp.length; i+=2) {
			Packet_21_Gradient tempgrad = new Packet_21_Gradient(gp[i] - totalDistance, gp[i+1] >= 0, Math.abs(gp[i+1]));
			totalDistance = gp[i];
			gradients.add(tempgrad);
		}

		Packet_21 packet21 = new Packet_21();
		packet21.Q_SCALE = 1;
		packet21.gradient = gradient;
		packet21.gradients = gradients;

		//setting currentGradient
		int currentGradient = gp[gp.length-1];

		//setting currentPosition
		Position currentPosition = new Position(0, true, new Location(1, ETCSVariables.NID_LRBG, ETCSVariables.Q_DIR_NOMINAL, null));

		//generating packet27

		Packet_27 packet27 = new Packet_27();

		Packet_27.Packet_27_Section p27SSP = new Packet_27.Packet_27_Section(tsp[0], tsp[1] / 5, true);
		totalDistance = tsp[0];
		ArrayList<Packet_27.Packet_27_Category> categoryList = new ArrayList<>();
		
/*		for (int ii = 0; ii < rng.nextInt(3); ii++) {
			Packet_27.Packet_27_Category p27cat = packet27.new Packet_27_Category(rng.nextInt(3), rng.nextInt(11), rng.nextInt(3), rng.nextInt(113) + 8);
			categoryList.add(p27cat);
		}*/
		
		p27SSP.categories = categoryList;
		packet27.Q_SCALE = 1;
		packet27.section = p27SSP;

		ArrayList<Packet_27.Packet_27_Section> sectionList = new ArrayList<>();

		for (int i = 2; i < tsp.length; i+=2) {

			p27SSP = new Packet_27.Packet_27_Section(tsp[i] - totalDistance,tsp[i+1] / 5,true);
			totalDistance = tsp[i];
			categoryList = new ArrayList<>();

/*			for (int ii = 0; ii < rng.nextInt(3); ii++) {
				Packet_27.Packet_27_Category p27sec = packet27.new Packet_27_Category(rng.nextInt(3), rng.nextInt(11), rng.nextInt(3), rng.nextInt(113) + 8);
				categoryList.add(p27sec);
			}*/

			p27SSP.categories = categoryList;
			sectionList.add(p27SSP);
		}
		packet27.sections = sectionList;


		//generating list of packet65
		ArrayList<Packet_65> listPacket65 = new ArrayList<>();

		//setting NC_CDTRAIN
		int NC_CDTRAIN = ETCSVariables.NC_CDTRAIN;

		//setting otherInternationalTrainCategories
		int NC_TRAIN = 0;

		//setting L_Train
		int L_TRAIN = 300;

		//setting currentSpeedLimit
		double currentSpeedLimit = 160 / 3.6;

		//setting V_MAX
		int V_MAXTRAIN = 200;

		return new BreakingCurveRequestEvent("devTests", target,id,breakingPower, emergencyBreakingPower, packet15, packet21, currentGradient, currentPosition, packet27,
				listPacket65, NC_CDTRAIN, NC_TRAIN, L_TRAIN, currentSpeedLimit, V_MAXTRAIN);
	}

}
