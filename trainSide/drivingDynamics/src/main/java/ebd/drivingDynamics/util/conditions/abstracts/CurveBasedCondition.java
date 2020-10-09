package ebd.drivingDynamics.util.conditions.abstracts;

import ebd.drivingDynamics.util.conditions.abstracts.Condition;
import org.greenrobot.eventbus.EventBus;

/**
 * Parent class for all conditions that operate on speed curves, for example relative speed conditions.
 */
public abstract class CurveBasedCondition extends Condition {

    protected enum CurveBase {
        NOT_SET,
        TRIP_PROFILE,
        C30
    }

    protected CurveBase curveBase;

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public CurveBasedCondition(EventBus localEventBus) {
        super(localEventBus);
    }
}
