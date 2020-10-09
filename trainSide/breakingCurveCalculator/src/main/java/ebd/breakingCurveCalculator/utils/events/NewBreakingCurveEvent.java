package ebd.breakingCurveCalculator.utils.events;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.globalUtils.events.NormalEvent;

import java.util.List;

/**
 * @author Lars Schulze-Falck
 *
 */
public class NewBreakingCurveEvent extends NormalEvent {


	public final BreakingCurve emergencyBreakingCurve;
	public final BreakingCurve serviceBreakingCurve;
	public final BreakingCurve normalBreakingCurve;

	/**
	 * @param source
	 *          ID from the module the event was sent by.
	 * @param target
	 *          ID from all modules the event is adressed to.
	 * @param emergencyBreakingCurve
	 * 			A {@link BreakingCurve} containing Emergency Breaking Curves.
	 * @param serviceBreakingCurve
	 * 			A {@link BreakingCurve} containing Service Breaking Curves.
	 * @param normalBreakingCurve
	 * 			A {@link BreakingCurve} containing Normal Breaking Curves.
	 */
	public NewBreakingCurveEvent(String source,
								 String target,
								 BreakingCurve emergencyBreakingCurve,
								 BreakingCurve serviceBreakingCurve,
								 BreakingCurve normalBreakingCurve) {
		super(source, target);
		this.emergencyBreakingCurve = emergencyBreakingCurve;
		this.serviceBreakingCurve = serviceBreakingCurve;
		this.normalBreakingCurve = normalBreakingCurve;
	}

	/**
	 * @param source
	  *          ID from the module the event was sent by
	  * @param target
	  *          ID from all modules the event is adressed to
	 * @param breakingCurveList
	 * 			A list containing three BreakingCurves, the first being the emergency, the second the service and the third
	 * 			the normal breaking curve.
	 */
	public NewBreakingCurveEvent(String source, String target, List<BreakingCurve> breakingCurveList) {
		super(source, target);
		this.emergencyBreakingCurve = breakingCurveList.get(0);
		this.serviceBreakingCurve = breakingCurveList.get(1);
		this.normalBreakingCurve = breakingCurveList.get(2);
	}
}
