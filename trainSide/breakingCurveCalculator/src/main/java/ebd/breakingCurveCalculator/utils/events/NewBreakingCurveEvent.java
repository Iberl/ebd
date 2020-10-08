package ebd.breakingCurveCalculator.utils.events;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.CurveGroup;
import ebd.globalUtils.events.NormalEvent;

/**
 * @author Lars Schulze-Falck
 *
 */
public class NewBreakingCurveEvent extends NormalEvent {
	

	public final BreakingCurve breakingCurve;

	/**
	 * @param source
	  *          ID from the module the event was sent by
	  *          TODO: Define Format for IDs
	  * @param target
	  *          ID from all modules the event is adressed to
	 * @param breakingCurve
	 * 			The breaking curve group, containing all breaking curves
	 */
	public NewBreakingCurveEvent(String source, String target, BreakingCurve breakingCurve) {
		super(source, target);
		this.breakingCurve = breakingCurve;
	}
}
