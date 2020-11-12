package ebd.globalUtils.events.drivingDynamics;

import ebd.globalUtils.events.NormalEvent;

public class DDUnlockEvent extends NormalEvent {
    /**
     * Constructs an Event that unlocks DrivingDynamics, allowing execution of code
     * This will generate a new DynamicState
     * TrainDataVolatile and RoutDataVolatile have to be set completely befor unlocking!
     *
     * @param source  ID from the module the event was sent by
     * @param target ID from from the target module or "all" if more then one target should be reached.
     */
    public DDUnlockEvent(String source, String target) {
        super(source, target);
    }
}
