package ebd.breakingCurveCalculator.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
		List<BreakingCurve> lobc = new ArrayList<>();
		lobc.add(e.breakingCurveGroup.getEmergencyDecelerationCurve());
		lobc.add(e.breakingCurveGroup.getEmergencyInterventionCurve());
		lobc.add(e.breakingCurveGroup.getServiceDecelerationCurve());
		lobc.add(e.breakingCurveGroup.getServiceInterventionCurve());
		lobc.add(e.breakingCurveGroup.getServiceWarningCurve());
		lobc.add(e.breakingCurveGroup.getPermittedSpeedCurve());
		lobc.add(e.breakingCurveGroup.getServiceIndicationCurve());
		lobc.add(e.breakingCurveGroup.getServiceCoastingPhaseCurve());

		/*
		Double searchKey2 = bCurve.getHighestXValue();
		while (!(searchKey2 == null )) {
			System.out.println(searchKey2);
			System.out.println(bCurve.curve.get(searchKey2));
			System.out.println("----------");
			
			searchKey2 = bCurve.curve.lowerKey(searchKey2);
		}
		*/
		for(BreakingCurve bCurve : lobc) {
			double xPosition = 0d;
			double step = bCurve.getHighestXValue() / 100000d;
			FileWriter fW;
			try {

				fW = new FileWriter(bCurve.getID() + ".txt");
				BufferedWriter writer = new BufferedWriter(fW);
				writer.write("");

				while (xPosition <= bCurve.getHighestXValue()) {

					Double yValue = bCurve.getPointOnCurve(xPosition);
					writer.append(String.format("%f:%f%n", xPosition, yValue));
					xPosition += step;
				}

				writer.close();

			} catch (IOException e1) {
				String eventTarget = "tsm";
				eventBus.post(new BreakingCurveExceptionEvent("bcc", eventTarget, e, e1));
			}
		}
		System.out.println("Done");
	}

}
