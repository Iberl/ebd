package ebd.breakingCurveCalculator.tests;

import ebd.breakingCurveCalculator.BreakingCurveCalculator;
import ebd.globalUtils.events.bcc.BreakingCurveLimitedRequestEvent;
import ebd.globalUtils.events.bcc.BreakingCurveRequestEvent;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.Test;

/**
 * @author Lars Schulze-Falck
 *
 */
public class BreakingCurveCalculatorTest {
	
	
	
	/**
	 * This method runs a breaking curve creation process, starting with a {@link BreakingCurveRequestEvent} from either
	 * randomly generated data or set data. It is then followed by a {@link BreakingCurveLimitedRequestEvent}.
	 * The events are monitored in the {@link ebd.breakingCurveCalculator.tests.TestEventHandler}
	 *
	 * @author Lars Schulze-Falck
	 * @throws InterruptedException If the timer is interrupted
	 */
	@Test
	public void mainTest() throws InterruptedException {
		
		//SETUP
		//Datasets

		int[] tsp = {0,160,1800,60};
		double[] bp = {0,0.4,100,0.2};
		int[] gp = {0,0};
		int eoa = 3000;
		
		
		/*int[] tsp = {0,160 , 350,140 , 500,100 , 600,160 , 1075,140 , 1250,120 , 1900,80 , 2000,200};
		double[] bp = {0,0.5 , 40,1 , 80,1.5 , 140,2 , 300,1 , 600,1};
		int[] gp = {0,0 , 500,10 , 1400,0 , 2000,0};
		int eoa = 2200;*/

/*		int[] tsp = {0,150, 250,120, 400,160, 650,140, 1075,120, 1250,80, 1800,80};
		double[] bp = {0,0.5, 40,1.0, 60,1.5, 80,2.0, 140,2.0, 300,1.0};
		int[] gp = {0,-10, 500,0, 1400,5};*/

			
		//Configuration
		boolean random = false;
		long seed = 100;
		
		//LOGIC
		
		EventBus eventBus = new EventBus();
		TestEventHandler teh = new TestEventHandler(eventBus);
		BreakingCurveCalculator bcc = new BreakingCurveCalculator(eventBus);
		BCREgeneratorFromRandom bcreGenRandom = new BCREgeneratorFromRandom(seed);
		BCREgeneratorFromDataset bcreGenDataset = new BCREgeneratorFromDataset(tsp, bp, gp, eoa);
		BCLREgeneratorFromRandom bclreGenRandom = new BCLREgeneratorFromRandom(seed);
		BreakingCurveRequestEvent bcre;
		
		if (random) {
			bcre = bcreGenRandom.generate();
		}else {
			bcre = bcreGenDataset.generate();
		}
		
		eventBus.post(bcre);
		
		Thread.sleep(3000);

		/*while (true){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				if(br.readLine().equals("q")){
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		/*BreakingCurveLimitedRequestEvent bclre = bclreGenRandom.generate();
		System.out.printf("New distance to end of movement authority: %f%n", MovementAuthorityConverter.p15ToD_EMA(bclre.packet15));
		eventBus.post(bclre);*/
	}

}
