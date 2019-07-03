package ebd.breakingCurveCalculator.utils.events;

import java.util.List;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.globalUtils.events.NormalEvent;

/**
 * @author Lars Schulze-Falck
 *
 */
public class NewBreakingCurveEvent extends NormalEvent {
	

	public BreakingCurve breakingCurve;
	/**
	* @param source
	 *          ID from the module the event was sent by
	 *          TODO: Define Format for IDs
	 * @param targets
	 *          ID from all modules the event is adressed to
	 *          TODO: Define Format for IDs
	 */
	public NewBreakingCurveEvent(String source, List<String> targets, BreakingCurve breakingCurve) {
		super(source, targets);
		this.breakingCurve = breakingCurve;
	}
}
