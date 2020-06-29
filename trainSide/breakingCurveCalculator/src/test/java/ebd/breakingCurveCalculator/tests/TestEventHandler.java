package ebd.breakingCurveCalculator.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
 * Monitors the event resulting out of {@link BreakingCurveCalculatorTest2}
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
	
	@Subscribe(threadMode = ThreadMode.ASYNC)
	public void NewBreakingCurve(NewBreakingCurveEvent e) {
		saveBreakingCurvesToFile(e);
		System.out.println("Done");
	}

	private void saveBreakingCurvesToFile(NewBreakingCurveEvent nbce){
		LocalDateTime ldt = LocalDateTime.now();
		String timeString =  DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldt);
		String dirPathString = "results/breakingCurves/" + timeString.replaceAll(":", "-") + "/";

		if(!new File(dirPathString).mkdirs()){
			System.err.println("Could not create necessary directories");
			System.exit(-1); //TODO Make better and Event
		}

		List<BreakingCurve> lobc = new ArrayList<>();
		lobc.add(nbce.breakingCurveGroup.getEmergencyDecelerationCurve());
		lobc.add(nbce.breakingCurveGroup.getEmergencyInterventionCurve());
		lobc.add(nbce.breakingCurveGroup.getServiceDecelerationCurve());
		lobc.add(nbce.breakingCurveGroup.getServiceInterventionCurve());
		lobc.add(nbce.breakingCurveGroup.getServiceWarningCurve());
		lobc.add(nbce.breakingCurveGroup.getPermittedSpeedCurve());
		lobc.add(nbce.breakingCurveGroup.getServiceIndicationCurve());
		lobc.add(nbce.breakingCurveGroup.getServiceCoastingPhaseCurve());

		for(BreakingCurve bCurve : lobc) {
			double xPosition = 0d;
			double step = bCurve.getHighestXValue() / 100000d;
			FileWriter fW;
			String dateString = DateTimeFormatter.BASIC_ISO_DATE.format(ldt);
			String fileName = String.format("ETCS_ID_%d-%s-%s",6485,bCurve.getID(),dateString);

			try {
				fW = new FileWriter(dirPathString + fileName);
				BufferedWriter writer = new BufferedWriter(fW);
				writer.write("");

				while (xPosition <= bCurve.getHighestXValue()) {

					Double yValue = bCurve.getPointOnCurve(xPosition);
					writer.append(String.format("%f:%f%n", xPosition, yValue));
					xPosition += step;
				}
				writer.flush();
				writer.close();

			} catch (IOException e1) {
				eventBus.post(new BreakingCurveExceptionEvent("bcc", "tsm", nbce, e1));
			}
		}
	}

}
