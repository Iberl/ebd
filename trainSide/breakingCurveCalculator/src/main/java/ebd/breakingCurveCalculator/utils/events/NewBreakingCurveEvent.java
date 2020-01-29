package ebd.breakingCurveCalculator.utils.events;

import java.util.List;

import ebd.breakingCurveCalculator.BreakingCurveGroup;
import ebd.globalUtils.events.NormalEvent;

/**
 * @author Lars Schulze-Falck
 *
 */
public class NewBreakingCurveEvent extends NormalEvent {
	

	public BreakingCurveGroup breakingCurveGroup;
	/**
	 * @param source
	  *          ID from the module the event was sent by
	  *          TODO: Define Format for IDs
	  * @param targets
	  *          ID from all modules the event is adressed to
	 * @param breakingCurveGroup
	 * 			The breaking curve group, containing all breaking curves
	 */
	public NewBreakingCurveEvent(String source, List<String> targets, BreakingCurveGroup breakingCurveGroup) {
		super(source, targets);
		this.breakingCurveGroup = breakingCurveGroup;
	}
}
