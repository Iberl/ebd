package ebd.breakingCurveCalculator.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ebd.globalUtils.events.ExceptionEvent;
import ebd.globalUtils.events.NormalEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.BreakingCurveExceptionEvent;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import org.greenrobot.eventbus.ThreadMode;

/**
 *
 * Monitors the event resulting out of {@link BreakingCurveCalculatorTest}
 * @author Lars Schulze-Falck
 *
 */
public class TestEventHandler{
	
	private EventBus eventBus;

	/**
	 * 
	 */
	public TestEventHandler(EventBus eventBus) {
		this.eventBus = eventBus;
		this.eventBus.register(this);
	}
	
	@Subscribe public void ExpetionCatch(ExceptionEvent e) {
		System.out.printf("A Event of type %s was posted%n", e.getClass());
		System.out.println(e.exception.getMessage());
		e.exception.printStackTrace();
	}
	
	@Subscribe public void DummyCatch(NormalEvent e) {
		System.out.printf("A Event of type %s was posted%n", e.getClass());
	}
	
	@Subscribe
	public void NewBreakingCurve(NewBreakingCurveEvent e) {
		saveBreakingCurvesToFile(e);
		System.out.println("Done");
	}

	private void saveBreakingCurvesToFile(NewBreakingCurveEvent nbce){
		LocalDateTime ldt = LocalDateTime.now();
		String timeString =  DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldt);
		String dateString = DateTimeFormatter.BASIC_ISO_DATE.format(ldt);
		String dirPathString = "results/breakingCurves/" + timeString.replaceAll(":", "-") + "/";
		BreakingCurve[] lobc = {nbce.emergencyBreakingCurve, nbce.serviceBreakingCurve, nbce.normalBreakingCurve};

		if(!new File(dirPathString).mkdirs()){
			System.err.println("Could not create necessary directories");
			System.exit(-1); //TODO Make better and Event
		}

		for(BreakingCurve bCurve : lobc) {
			FileWriter fW;
			String fileName = String.format("ETCS_ID_%d-%s-%s", 6485, bCurve.getID(), dateString);

			try {
			fW = new FileWriter(dirPathString + fileName);
			BufferedWriter writer = new BufferedWriter(fW);
			//System.out.println(bCurve.toStringMinimumSpeed());
			writer.write(bCurve.toStringAllKnots());
			//writer.write(bCurve.toStringMinimumSpeed());
			writer.flush();
			writer.close();

		} catch (IOException e1) {
			eventBus.post(new BreakingCurveExceptionEvent("bcc", "tsm", nbce, e1));
		}
		}
	}
}
