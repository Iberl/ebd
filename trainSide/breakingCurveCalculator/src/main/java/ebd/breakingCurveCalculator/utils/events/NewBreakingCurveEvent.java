package ebd.breakingCurveCalculator.utils.events;

import ebd.breakingCurveCalculator.CurveGroup;
import ebd.globalUtils.events.NormalEvent;

/**
 * @author Lars Schulze-Falck
 *
 */
public class NewBreakingCurveEvent extends NormalEvent {
	

	public CurveGroup curveGroup;

	public boolean lastMovementAuthorityMessage;
	/**
	 * @param source
	  *          ID from the module the event was sent by
	  *          TODO: Define Format for IDs
	  * @param target
	  *          ID from all modules the event is adressed to
	 * @param curveGroup
	 * 			The breaking curve group, containing all breaking curves
	 */
	public NewBreakingCurveEvent(String source, String target, CurveGroup curveGroup) {
		super(source, target);
		this.curveGroup = curveGroup;
	}
}
