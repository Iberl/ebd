package ebd.drivingDynamics.util.conditions;

import org.greenrobot.eventbus.EventBus;

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
