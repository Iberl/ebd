package ebd.breakingCurveCalculator.tests;

import ebd.globalUtils.etcsPacketToSplineConverters.MovementAuthorityConverter;
import org.greenrobot.eventbus.EventBus;

import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.globalUtils.events.bcc.BreakingCurveLimitedRequestEvent;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;

/**
 * @author Lars Schulze-Falck
 *
 */
public class BreakingCurveCalculatorTest {
	
	
	
	/**
	 * This method runs a breaking curve creation process, starting with a {@link BreakingCurveRequestEvent} from either
	 * randomly generated data or set data. It is then followed by a {@link BreakingCurveLimitedRequestEvent}.
	 * The events are monitored in the {@link ebd.breakingCurveCalculator.tests.TestEventHandler}
	 * @param args No function
	 *
	 * @author Lars Schulze-Falck
	 * @throws InterruptedException If the timer is interrupted
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//SETUP
		//Datasets

		int[] tsp = {0,180,1800,180};
		double[] bp = {0,1};
		int[] gp = {0,0};
		
		
/*		int[] tsp = {0,160 , 350,140 , 500,100 , 600,160 , 1075,140 , 1250,120 , 1900,80 , 2000,200};
		double[] bp = {0,0.5 , 40,1 , 80,1.5 , 140,2 , 300,1 , 600,1};
		int[] gp = {0,0 , 500,10 , 1400,0 , 2000,0};*/

		/*
		int[] tsp = {0,150, 250,120, 400,160, 650,140, 1075,120, 1250,80, 1800,80};
		double[] bp = {0,0.5, 40,1.0, 60,1.5, 80,2.0, 140,2.0, 300,1.0};
		int[] gp = {0,-10, 500,0, 1400,5};
		*/
		
			
		//Configuration
		boolean random = false;
		long seed = 100;
		
		//LOGIC
		
		EventBus eventBus = new EventBus();
		TestEventHandler teh = new TestEventHandler(eventBus);
		BreakingCurveCalculator bcc = new BreakingCurveCalculator(eventBus);
		BCREgeneratorFromRandom bcreGenRandom = new BCREgeneratorFromRandom(seed);
		BCREgeneratorFromDataset bcreGenDataset = new BCREgeneratorFromDataset(tsp, bp, gp);
		BCLREgeneratorFromRandom bclreGenRandom = new BCLREgeneratorFromRandom(seed);
		BreakingCurveRequestEvent bcre;
		
		if (random) {
			bcre = bcreGenRandom.generate();
		}else {
			bcre = bcreGenDataset.generate();
		}
		
		eventBus.post(bcre);
		
		
		Thread.sleep(2000);
		BreakingCurveLimitedRequestEvent bclre = bclreGenRandom.generate();
		System.out.printf("New distance to end of movement authority: %f%n", MovementAuthorityConverter.p15ToD_EMA(bclre.packet15));
		eventBus.post(bclre);
	}

}
