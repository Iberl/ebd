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
		
		BreakingCurve bCurve = e.breakingCurve;

		/*
		Double searchKey2 = bCurve.getHighestXValue();
		while (!(searchKey2 == null )) {
			System.out.println(searchKey2);
			System.out.println(bCurve.curve.get(searchKey2));
			System.out.println("----------");
			
			searchKey2 = bCurve.curve.lowerKey(searchKey2);
		}
		*/
		double xPosition = 0d;
		double step = bCurve.getHighestXValue() / 100000d;
		FileWriter fW;
		try {
			
			fW = new FileWriter(bCurve.getID()+".txt");
			BufferedWriter writer = new BufferedWriter(fW);
			writer.write("");
			
			while (xPosition <= bCurve.getHighestXValue()){
			
				Double yValue = bCurve.getPointOnCurve(xPosition);
				writer.append(String.format("%f:%f%n", xPosition, yValue));
				xPosition += step;
			}
			
			writer.close();
		
		} catch (IOException e1) {
			List<String> eventTargets = new ArrayList<>();
			eventTargets.add("tsm;");
			eventBus.post(new BreakingCurveExceptionEvent("bcc", eventTargets, e, e1));
		}
		
		System.out.println("Done");
	}

}
